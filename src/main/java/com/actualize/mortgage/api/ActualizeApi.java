package com.actualize.mortgage.api;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
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

import com.actualize.mortgage.domainmodels.PDFDocument;
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
	
    @RequestMapping(value = "/ucdxml", method = { RequestMethod.POST })
    public List<PDFDocument> fillFormByXML(@RequestBody String xmldoc) throws Exception {
        sessionContext.getUserDetails().setMessage(xmldoc);
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(xmldoc.getBytes("utf-8"))));
        MESSAGE message = transformXmlToObject(document);
        return mortgageServices.createDocument(message);
    }
	
	
	@RequestMapping(value = "/readTxt", method = { RequestMethod.POST })
    public List<PDFDocument> fillFormByTxt(@RequestBody MESSAGE messageXMLObject) throws Exception {
		 return  mortgageServices.createDocument(messageXMLObject);
    }
	
    @RequestMapping(value = "/saveUCD", method = { RequestMethod.POST })
    public List<PDFResponse> saveModifiedUCD(@RequestBody List<PDFDocument> pdfDocument) throws Exception {
        String currentXMLObject = sessionContext.getUserDetails().getMessage();

        PopulateInputData reader = new PopulateInputData();
        List<InputData> inputData = reader.getData(new ByteArrayInputStream(currentXMLObject.getBytes("utf-8")));
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
	
	public MESSAGE transformXmlToObject(Document xmlout) throws Exception{
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
	
}
