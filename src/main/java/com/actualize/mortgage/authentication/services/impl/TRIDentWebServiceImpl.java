/**
 * 
 */
package com.actualize.mortgage.authentication.services.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.actualize.mortgage.cd.domainmodels.ClosingDisclosure;
import com.actualize.mortgage.domainmodels.CalculateCDResponse;
import com.actualize.mortgage.domainmodels.CalculateLEResponse;
import com.actualize.mortgage.domainmodels.ErrorsListModel;
import com.actualize.mortgage.domainmodels.LoanEstimate;
import com.actualize.mortgage.domainmodels.PDFResponse;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.mappingmodels.IntermediateXMLData;
import com.actualize.mortgage.pdf.mismodao.MISMODocument;
import com.actualize.mortgage.service.impl.UCDXMLServiceImpl;
import com.actualize.mortgage.services.impl.ClosingDisclosurePDFServicesImpl;
import com.actualize.mortgage.services.impl.ClosingDisclosureServicesImpl;
import com.actualize.mortgage.services.impl.IClosingDisclosureServices;
import com.actualize.mortgage.services.impl.ILoanEstimateServices;
import com.actualize.mortgage.services.impl.LoanEstimatePDFServicesImpl;
import com.actualize.mortgage.services.impl.LoanEstimateServicesImpl;
import com.actualize.mortgage.services.impl.UCDTransformerServiceImpl;
import com.actualize.mortgage.ucd.calculatepayments.CalculatePayments;
import com.actualize.mortgage.validation.domainmodels.UCDValidationErrors;
import com.actualize.mortgage.validation.services.impl.UCDValidator;

/**
 * @author sboragala
 *
 */
@Service
public class TRIDentWebServiceImpl {
	
	@Autowired
	private IClosingDisclosureServices closingDisclosureServices;
	
	@Autowired
	private ILoanEstimateServices loanEstimateServices;

	public ClosingDisclosure convertTemplateToCDJson(String txtdoc) throws Exception {
		ClosingDisclosureServicesImpl closingDisclosureServicesImpl = new ClosingDisclosureServicesImpl();
		InputStream in = new ByteArrayInputStream(getMISMOXML(txtdoc).getBytes(StandardCharsets.UTF_8));
		return closingDisclosureServicesImpl.createClosingDisclosureObjectfromXMLDoc(in);
	}

	/**
	 * This method will transform Dom object to xml 
	 * 
	 * @param doc
	 * @return
	 * @throws TransformerException
	 */
	public String transformToXml(Document doc) throws TransformerException {
		Transformer tr = TransformerFactory.newInstance().newTransformer();
		tr.setOutputProperty(OutputKeys.INDENT, "yes");
		tr.setOutputProperty(OutputKeys.METHOD, "xml");
		tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		StreamResult result = new StreamResult(new StringWriter());
		tr.transform(new DOMSource(doc), result);
		return result.getWriter().toString();
	}

	/**
	 * convert input data to properties
	 * 
	 * @param inputdata
	 * @return Properties
	 * @throws Exception
	 */
	private Properties parsePropertiesString(String inputData) throws Exception {
		// load() returning void rather than the Properties object
		// so this takes 3 lines instead of "return new Properties().load(...);"
		final Properties p = new Properties();
		p.load(new StringReader(inputData));
		return p;
	}

	/**
	 * converts text template to mismo xml
	 * 
	 * @param txtdoc
	 * @return string as mismo xml
	 * @throws Exception
	 */
	private String getMISMOXML(String txtdoc) throws Exception {
		Properties propFile = parsePropertiesString(txtdoc);
		InputStream mappingFileStream = getClass().getClassLoader().getResourceAsStream("TextTemplateMap.xml");
		UCDTransformerServiceImpl ucdTransformerServiceImpl = new UCDTransformerServiceImpl();
		IntermediateXMLData intermediateXMLData = ucdTransformerServiceImpl
				.generateIntermediateXMLForTxtTemplate(mappingFileStream, propFile);
		return ucdTransformerServiceImpl.generateDocument(intermediateXMLData);
	}

	public LoanEstimate convertTemplateToLEJson(String txtdoc) throws Exception {
		LoanEstimateServicesImpl loanEstimateServicesImpl = new LoanEstimateServicesImpl();
		InputStream in = new ByteArrayInputStream(getMISMOXML(txtdoc).getBytes(StandardCharsets.UTF_8));
		return loanEstimateServicesImpl.createLoanEstimateDocumentObjectfromXMLDoc(in);
	}

	public String calculateCDPayments(ClosingDisclosure closingDisclosure) throws Exception {
		CalculatePayments calculator = new CalculatePayments();
		ClosingDisclosureServicesImpl closingDisclosureServicesImpl = new ClosingDisclosureServicesImpl();
		String xmldoc = closingDisclosureServicesImpl.createClosingDisclosureXMLfromObject(closingDisclosure);
		Document doc = calculator.calculate(xmldoc);
		return transformToXml(doc);
	}

	public String calculateLEPayments(LoanEstimate loanEstimateJSON) throws Exception {
		CalculatePayments calculator = new CalculatePayments();
		LoanEstimateServicesImpl loanEstimateServicesImpl = new LoanEstimateServicesImpl();
		String xmldoc = loanEstimateServicesImpl.createLoanEstimateXMLfromObject(loanEstimateJSON);
		Document doc = calculator.calculate(xmldoc);
		return transformToXml(doc);
	}

	public List<PDFResponse> cdJsonToPdf(ClosingDisclosure closingDisclosure) throws Exception {
		ClosingDisclosureServicesImpl closingDisclosureServicesImpl = new ClosingDisclosureServicesImpl();
		ClosingDisclosurePDFServicesImpl closingDisclosurePDFServicesImpl = new ClosingDisclosurePDFServicesImpl();
		String xmldoc = closingDisclosureServicesImpl.createClosingDisclosureXMLfromObject(closingDisclosure);
		return closingDisclosurePDFServicesImpl.createPDF(xmldoc);
	}

	public PDFResponse leJsonToPdf(LoanEstimate loanEstimateJSON) throws Exception {
		LoanEstimateServicesImpl loanEstimateServicesImpl = new LoanEstimateServicesImpl();
		LoanEstimatePDFServicesImpl loanEstimatePDFServicesImpl = new LoanEstimatePDFServicesImpl();
		String xmldoc = loanEstimateServicesImpl.createLoanEstimateXMLfromObject(loanEstimateJSON);
		MISMODocument mismoDocument = new MISMODocument(new ByteArrayInputStream(xmldoc.getBytes("utf-8")));
		return loanEstimatePDFServicesImpl.generateLoanEstimatePDF(mismoDocument);
	}

	public UCDValidationErrors validateCDJson(ClosingDisclosure closingDisclosure) throws Exception {
		ClosingDisclosureServicesImpl closingDisclosureServicesImpl = new ClosingDisclosureServicesImpl();

		String xmldoc = closingDisclosureServicesImpl.createClosingDisclosureXMLfromObject(closingDisclosure);
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new InputSource(new ByteArrayInputStream(xmldoc.getBytes("utf-8"))));
		UCDValidator ucdValidator = new UCDValidator();
		return ucdValidator.validateUCDXML(document);
	}

	public String trimCDJson(ClosingDisclosure closingDisclosure) throws Exception {
		ClosingDisclosureServicesImpl closingDisclosureServicesImpl = new ClosingDisclosureServicesImpl();
		UCDXMLServiceImpl ucdxmlServiceImpl = new UCDXMLServiceImpl();
		String xmldoc = closingDisclosureServicesImpl.createClosingDisclosureXMLfromObject(closingDisclosure);
		InputStream inputXmlStream = new ByteArrayInputStream(xmldoc.getBytes(StandardCharsets.UTF_8));
		return ucdxmlServiceImpl.createClosingDisclosureUCDXML(inputXmlStream);
	}
	
	public boolean hasExceptions(String xmlDoc) throws ServiceException
	{
		final String MISMO_URL = "http://www.mismo.org/residential/2009/schemas";
		XPath xpath = null;
		String mismo = "";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    factory.setNamespaceAware(true);
	    DocumentBuilder builder;  
        try  
        {  
            builder = factory.newDocumentBuilder();  
            Document doc = builder.parse(new InputSource(new StringReader(xmlDoc)));
            NodeList root = doc.getElementsByTagName("mismo:MESSAGE");
    		if(root.getLength() >0 )
    			return false;
    		else
    			return true;
        } catch (Exception e) {  
        	throw new ServiceException("Unable to Parse the String");
        }
        
	}
	
	
	public CalculateCDResponse createCalculateCDResponse(ClosingDisclosure closingDisclosure) throws Exception
	{
		CalculateCDResponse calculateCDResponse = new CalculateCDResponse();
		
		String xmlDoc = calculateCDPayments(closingDisclosure);
		if(!hasExceptions(xmlDoc))
		{
			InputStream in = new ByteArrayInputStream(xmlDoc.getBytes(StandardCharsets.UTF_8));
			ClosingDisclosure closingDisclosureResponse = closingDisclosureServices.createClosingDisclosureObjectfromXMLDoc(in);
			calculateCDResponse.setClosingDisclosure(closingDisclosureResponse);
		}
		else
		{
		JAXBContext jaxbContext = JAXBContext.newInstance(ErrorsListModel.class);  
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
        StringReader reader = new StringReader(xmlDoc);
        ErrorsListModel errorsList = (ErrorsListModel) jaxbUnmarshaller.unmarshal(reader);
        calculateCDResponse.setErrorsList(errorsList);
		}
		return calculateCDResponse;
	}
	
	public CalculateLEResponse createCalculateLEResponse(LoanEstimate loanEstimate) throws Exception
	{
		CalculateLEResponse calculateLEResponse = new CalculateLEResponse();
		
		String xmlDoc = calculateLEPayments(loanEstimate);
		if(!hasExceptions(xmlDoc))
		{
			InputStream in = new ByteArrayInputStream(xmlDoc.getBytes(StandardCharsets.UTF_8));
			LoanEstimate loanEstimateResponse = loanEstimateServices.createLoanEstimateDocumentObjectfromXMLDoc(in);
			calculateLEResponse.setLoanEstimate(loanEstimateResponse);
		}
		else
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(ErrorsListModel.class);  
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        StringReader reader = new StringReader(xmlDoc);
	        ErrorsListModel errorsList = (ErrorsListModel) jaxbUnmarshaller.unmarshal(reader);
	        calculateLEResponse.setErrorsList(errorsList);
		}
		return calculateLEResponse;
	}
	
}
