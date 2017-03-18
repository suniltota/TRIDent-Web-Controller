package com.actualize.mortgage.api;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.mismo.residential._2009.schemas.MESSAGE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.actualize.mortgage.domainmodels.MESSAGEModel;
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
    public List<PDFDocument> fillFormByXML(@RequestBody MESSAGE messageXMLObject) throws Exception {
			sessionContext.getUserDetails().setMessage(messageXMLObject);
		 return  mortgageServices.createDocument(messageXMLObject);
    }
	
	
	@RequestMapping(value = "/readTxt", method = { RequestMethod.POST })
    public List<PDFDocument> fillFormByTxt(@RequestBody MESSAGE messageXMLObject) throws Exception {
		 return  mortgageServices.createDocument(messageXMLObject);
    }
	
	@RequestMapping(value = "/saveUCD", method = { RequestMethod.POST })
    public List<PDFDocument> saveModifiedUCD(@RequestBody List<PDFDocument> pdfDocument) throws Exception {
		MESSAGE currentXMLObject = sessionContext.getUserDetails().getMessage();
		
		
		File file = new File("D:\\Atlassian\\Application Data\\JIRA\\import\\sample.xml");
	    JAXBContext jaxbContext = JAXBContext.newInstance(MESSAGEModel.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	  //  jaxbMarshaller.marshal(currentXMLObject, file);// this line create customer.xml file in specified path.

	   // jaxbMarshaller.marshal(new JAXBElement<MESSAGEModel>(new QName("uri","local"), MESSAGEModel.class,file);
	    
	    StringWriter sw = new StringWriter();
	    jaxbMarshaller.marshal(currentXMLObject, sw);
	    String xmlString = sw.toString();

	    System.out.println(xmlString);
	    
	    PopulateInputData reader = new PopulateInputData();
        List<InputData> inputData = reader.getData(new ByteArrayInputStream(xmlString.getBytes("utf-8")));
        ByteArrayOutputStream pdfOutStream = null;
        List<PDFResponse> pdfResponseList = new ArrayList<>();
        for(InputData data: inputData) {
            PDFResponse outputResponse = new PDFResponse();
            outputResponse.setFilename("ClosingDisclosure");
            outputResponse.setOutputType("application/pdf");
            if (data.isSellerOnly()){
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
        return pdfDocument;
		
		 //  mortgageServices.updateMismoObject(currentXMLObject, modifiedJSONObject);
    }
	
}
