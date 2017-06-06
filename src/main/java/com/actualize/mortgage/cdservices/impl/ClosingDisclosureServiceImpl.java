/*
 * @(#)ClosingDisclosureServiceImpl.java 1.0 04/11/2017
 * 
 */
package com.actualize.mortgage.cdservices.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;

import com.actualize.mortgage.cdpagemodels.ClosingDisclosure;
import com.actualize.mortgage.cdservices.ClosingDisclosureService;
import com.actualize.mortgage.convertors.ClosingDisclosureConverter;
import com.actualize.mortgage.ledatamodels.MISMODocument;
import com.actualize.mortgage.utils.JsonToUcd;

import transformx.utils.EvaluateXmlNodes;
import transformx.utils.UCDXMLTransformer;

/**
 * This is the implementation class for the {@link ClosingDisclosureService} which is used to write 
 * the business logic to create ClosingDisclosure XML / PDF and generate Page Objects to represents
 *  the all the pages present in Closing Disclosure
 * 
 * @author rsudula
 * @version 1.0
 * 
 */
public class ClosingDisclosureServiceImpl implements ClosingDisclosureService {
	

    @Override
    public ClosingDisclosure createClosingDisclosureObjectfromXMLDoc(InputStream inputXmlStream) throws Exception {
        MISMODocument document = new MISMODocument(inputXmlStream); 
        ClosingDisclosureConverter closingDisclosureConverter = new ClosingDisclosureConverter();
        ClosingDisclosure closingDisclosure = closingDisclosureConverter.convertXmltoJSON(document);
        return closingDisclosure;
    }

    @Override
    public String createClosingDisclosureXMLfromObject(ClosingDisclosure closingDisclosure) throws Exception {
    		JsonToUcd jsonToUcd = new JsonToUcd();
        return jsonToUcd.transform(closingDisclosure);
    }

	@Override
	public String createClosingDisclosureUCDXML(InputStream inputXmlStream) throws Exception {
		
		 Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputXmlStream);
		 UCDXMLTransformer transformer = new UCDXMLTransformer();
	     EvaluateXmlNodes evaluateXmlNodes = new EvaluateXmlNodes();
	     OutputStream outputStream = null;
  
	        doc.getDocumentElement().removeAttribute("xsi:schemaLocation");
	        doc.getDocumentElement().setAttribute("xmlns:gse", "http://www.datamodelextension.org");
	        
	        try{

			// write the inputStream to a FileOutputStream
			outputStream =  new FileOutputStream(new File(getClass().getClassLoader().getResource("targetFile.xml").getFile()));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputXmlStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
	        }
			finally {
				if (outputStream != null) {
					try {
						// outputStream.flush();
						outputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
	        
	        File ucdFileName = new File(getClass().getClassLoader().getResource("targetFile.xml").getFile());
	        doc= transformer.getUCDXmlDocument(doc, ucdFileName);

	        doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(ucdFileName);
	        doc = evaluateXmlNodes.removeFeePaidToType(doc);
	        transformer.removeEmptyNodes(doc);
	        ucdFileName = transformer.createUCDXMLFile(doc, ucdFileName);
	        
		return FileUtils.readFileToString(ucdFileName, "UTF-8");
	}

}
