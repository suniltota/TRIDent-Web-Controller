package com.actualize.mortgage.api;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.mismo.residential._2009.schemas.MESSAGE;
import org.mismo.residential._2009.schemas.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.actualize.mortgage.domainmodels.ClosingDisclosureDocument;
import com.actualize.mortgage.domainmodels.IntermediateXMLData;
import com.actualize.mortgage.domainmodels.PDFResponse;
import com.actualize.mortgage.sercurity.SessionContext;
import com.actualize.mortgage.services.MortgageServices;
import com.uniformdisclosure.UniformDisclosureBuilder;
import com.uniformdisclosure.UniformDisclosureBuilderSeller;

import datalayer.InputData;
import datalayer.PopulateInputData;

@RestController
@RequestMapping(value="/actualize")
public class ActualizeApi {
	
	@Autowired
	private MortgageServices mortgageServices;
	
	@Autowired
    SessionContext sessionContext;
	
	/**
	 * generates JSON response for closing disclosure on giving xml as input in String format
	 * @param xmldoc
	 * @return JSON response for closing disclosure
	 * @throws Exception
	 */
	
    @RequestMapping(value = "/ucdxml", method = { RequestMethod.POST })
    public List<ClosingDisclosureDocument> fillFormByXML(@RequestBody String xmldoc) throws Exception {
        sessionContext.getUserDetails().setMessage(xmldoc);
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(xmldoc.getBytes("utf-8"))));
        MESSAGE message = transformXmlToObject(document);
        return mortgageServices.createDocument(message);
    }
	
	/**
	 * generates JSON response for closing disclosure on giving xml as input in String format
	 * @param messageXMLObject
	 * @return JSON response for closing disclosure
	 * @throws Exception
	 */
	@RequestMapping(value = "/readTxt", method = { RequestMethod.POST })
    public List<ClosingDisclosureDocument> fillFormByTxt(@RequestBody MESSAGE messageXMLObject) throws Exception {
		 return  mortgageServices.createDocument(messageXMLObject);
    }
	
	/**
	 * generates PDF for closing disclosure on giving xml as input in String format
	 * @param xmldoc
	 * @return PDF document 
	 * @throws Exception
	 */
    @RequestMapping(value = "/generatePDF", method = { RequestMethod.POST })
    public List<PDFResponse> saveModifiedUCD(@RequestBody String xmldoc) throws Exception {
        PopulateInputData reader = new PopulateInputData();
        List<InputData> inputData = reader.getData(new ByteArrayInputStream(xmldoc.getBytes("utf-8")));
        ByteArrayOutputStream pdfOutStream = null;
        List<PDFResponse> pdfResponseList = new ArrayList<>();
        for (InputData data : inputData) {
            PDFResponse outputResponse = new PDFResponse();
            outputResponse.setFilename("ClosingDisclosure");
            outputResponse.setOutputType("application/pdf");
            if (data.isSellerOnly()) {
                UniformDisclosureBuilderSeller pdfbuilder = new UniformDisclosureBuilderSeller();
                pdfOutStream = pdfbuilder.run(data);
                outputResponse.setResponseData(pdfOutStream.toByteArray());
            } else {
                UniformDisclosureBuilder pdfbuilder = new UniformDisclosureBuilder();
                pdfOutStream = pdfbuilder.run(data);
                outputResponse.setResponseData(pdfOutStream.toByteArray());
            }
            pdfResponseList.add(outputResponse);
        }
        return pdfResponseList;
    }
    
    /**
     * converts the JSON response to UCD XML
     * @param pdfDocument
     * @return UCD XML as String
     * @throws Exception
     */
    @RequestMapping(value = "/saveUCDXML", method = { RequestMethod.POST })
    public String saveModifiedUCDXML(@RequestBody List<ClosingDisclosureDocument> pdfDocument) throws Exception {
        String currentXMLObject = sessionContext.getUserDetails().getMessage();
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(currentXMLObject.getBytes("utf-8"))));
        MESSAGE message = transformXmlToObject(document);
        
        for(ClosingDisclosureDocument pdf : pdfDocument){
            message = mortgageServices.updateMismoObject(message, pdf);
        }
        return transformObjectToXML(message);
    }
    
    /**
     * converts MESSAGE JAXB Object to String 
     * @param message
     * @return xml as String
     * @throws Exception
     */
    public String transformObjectToXML(MESSAGE message) throws Exception{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.newDocument();
       JAXBContext context = JAXBContext.newInstance(message.getClass());
       context.createMarshaller().marshal(message, document);
       
       TransformerFactory tf = TransformerFactory.newInstance();
       Transformer t = tf.newTransformer();
       DOMSource source = new DOMSource(document);
       StreamResult result = new StreamResult(new StringWriter());
       t.transform(source, result);
       
       return  result.getWriter().toString();
   }
    
    /**
     * converts org.w3c.dom.document to JAXB MESSAGE object
     * @param xmlout
     * @return MESSAGE as JAXB Object
     * @throws Exception
     */
	private MESSAGE transformXmlToObject(Document xmlout) throws Exception{
        // Prepare document to write
        Transformer tr = TransformerFactory.newInstance().newTransformer();
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        tr.setOutputProperty(OutputKeys.METHOD, "xml");
        tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        // Write xmldoc to stream out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        tr.transform(new DOMSource(xmlout), new StreamResult(out));
        out.close();

        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<MESSAGE> unmarshalledObject = (JAXBElement<MESSAGE>) jaxbUnmarshaller.unmarshal(new ByteArrayInputStream(out.toByteArray()));

        return unmarshalledObject.getValue();
    }
	
	/**
	 * when a user inputs the plain text in a defined format as an input, will return UCD xml  
	 * @param txtdoc
	 * @return master xml as String
	 * @throws Exception
	 */
	@RequestMapping(value = "/textToXml", method = { RequestMethod.POST })
    public String generateXmlFromTxtTemplate(@RequestBody String txtdoc) throws Exception {
        Properties propFile = parsePropertiesString(txtdoc);
        InputStream mappingFileStream = getClass().getClassLoader().getResourceAsStream("TextTemplateMap.xml");
        IntermediateXMLData intermediateXMLData = mortgageServices.generateIntermediateXMLForTxtTemplate(mappingFileStream, propFile);
        MESSAGE message = mortgageServices.generateMasterXML(intermediateXMLData);
        return transformObjectToXML(message);
    }
	
    /**
     * parses the String to Properties
     * @param inputData
     * @return properties 
     * @throws Exception
     */
    private Properties parsePropertiesString(String inputData) throws Exception {
        // load() returning void rather than the Properties object
        // so this takes 3 lines instead of "return new Properties().load(...);"
        final Properties p = new Properties();
        p.load(new StringReader(inputData));
        return p;
    }
}
