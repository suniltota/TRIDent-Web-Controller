/**
 * 
 */
package com.actualize.mortgage.api;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mismo.residential._2009.schemas.MESSAGE;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.actualize.mortgage.cd.domainmodels.ClosingDisclosure;
import com.actualize.mortgage.domainmodels.LoanEstimate;
import com.actualize.mortgage.domainmodels.PDFResponse;
import com.actualize.mortgage.mappingmodels.IntermediateXMLData;
import com.actualize.mortgage.mappingmodels.UCDXMLResult;
import com.actualize.mortgage.mismodao.MISMODocument;
import com.actualize.mortgage.service.impl.UCDXMLServiceImpl;
import com.actualize.mortgage.services.impl.ClosingDisclosurePDFServicesImpl;
import com.actualize.mortgage.services.impl.ClosingDisclosureServicesImpl;
import com.actualize.mortgage.services.impl.FileService;
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
@RestController
@RequestMapping(value = "/actualize/transformx/")
public class TridentWebAPI {
	
	private static final Logger LOG = LogManager.getLogger(TridentWebAPI.class);
	

	@RequestMapping(value = "/{version}/templatetocdjson", method = { RequestMethod.POST })
	public String templatetocdjson(@PathVariable String version, @RequestBody String txtdoc) throws Exception {
		LOG.info("Service: CD text template to json object api invoked");
        Properties propFile = parsePropertiesString(txtdoc);
        InputStream mappingFileStream = getClass().getClassLoader().getResourceAsStream("TextTemplateMap.xml");
        UCDTransformerServiceImpl  ucdTransformerServiceImpl = new UCDTransformerServiceImpl();
        IntermediateXMLData intermediateXMLData = ucdTransformerServiceImpl.generateIntermediateXMLForTxtTemplate(mappingFileStream, propFile);
        return ucdTransformerServiceImpl.generateDocument(intermediateXMLData);
	}
	
	@RequestMapping(value = "/{version}/templatetolejson", method = { RequestMethod.POST })
	public LoanEstimate templatetolejson(@PathVariable String version, @RequestBody String txtdoc) throws Exception
	{
		LOG.info("Service: LE text template to json object called");
        Properties propFile = parsePropertiesString(txtdoc);
        InputStream mappingFileStream;
        
        FileService fileService = new FileService();
        UCDTransformerServiceImpl  ucdTransformerServiceImpl = new UCDTransformerServiceImpl();
        LoanEstimateServicesImpl loanEstimateServicesImpl = new LoanEstimateServicesImpl();
        
        if(null!=fileService.getTextMappingFile() && !"".equalsIgnoreCase(fileService.getTextMappingFile()) && !"TextTemplateMap.xml".equalsIgnoreCase(fileService.getTextMappingFile())) {
            mappingFileStream = new FileInputStream(fileService.getTextMappingFile());
        } else {
            mappingFileStream = getClass().getClassLoader().getResourceAsStream("TextTemplateMap.xml");
        }
        IntermediateXMLData intermediateXMLData = ucdTransformerServiceImpl.generateIntermediateXMLForTxtTemplate(mappingFileStream, propFile);
        MESSAGE message = ucdTransformerServiceImpl.generateMasterXML(intermediateXMLData);
        UCDXMLResult ucdXMLResult = ucdTransformerServiceImpl.generateUCDXML(message);
        
		MESSAGE msgObject = ucdXMLResult.getUcdDocument().getMessage();
		
		StringWriter sw = new StringWriter();
    	JAXBContext jaxbContext = JAXBContext.newInstance(MESSAGE.class);
    	Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    	jaxbMarshaller.marshal(msgObject, sw);
    	String xmldoc = sw.toString();
		InputStream in = new ByteArrayInputStream(xmldoc.getBytes(StandardCharsets.UTF_8));
		
		return loanEstimateServicesImpl.createLoanEstimateDocumentObjectfromXMLDoc(in);
		
	}
	
	@RequestMapping(value = "/{version}/calculatecdpayments", method = { RequestMethod.POST })
	public String calculatecdpayments(@PathVariable String version, @RequestBody ClosingDisclosure closingDisclosure) throws Exception
	{
		LOG.info("Service call: cd calculations");
		
		CalculatePayments calculator = new CalculatePayments();
        ClosingDisclosureServicesImpl closingDisclosureServicesImpl = new ClosingDisclosureServicesImpl();
		String xmldoc =	closingDisclosureServicesImpl.createClosingDisclosureXMLfromObject(closingDisclosure);
		Document doc = calculator.calculate(xmldoc);
        
        Transformer tr = TransformerFactory.newInstance().newTransformer();
	        tr.setOutputProperty(OutputKeys.INDENT, "yes");
	        tr.setOutputProperty(OutputKeys.METHOD, "xml");
	        tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	        tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
	        StreamResult result = new StreamResult(new StringWriter());
        	tr.transform(new DOMSource(doc), result);
        
        return result.getWriter().toString();
		
	}
	
	@RequestMapping(value = "/{version}/calculatelepayments", method = { RequestMethod.POST })
	public String calculatelepayments(@PathVariable String version, @RequestBody LoanEstimate loanEstimateJSON) throws Exception
	{
		LOG.info("Service call: le calculations");
		
		CalculatePayments calculator = new CalculatePayments();
        LoanEstimateServicesImpl loanEstimateServicesImpl = new LoanEstimateServicesImpl();
		String xmldoc =	loanEstimateServicesImpl.createLoanEstimateXMLfromObject(loanEstimateJSON);
		Document doc = calculator.calculate(xmldoc);
        
        Transformer tr = TransformerFactory.newInstance().newTransformer();
	        tr.setOutputProperty(OutputKeys.INDENT, "yes");
	        tr.setOutputProperty(OutputKeys.METHOD, "xml");
	        tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	        tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        StreamResult result = new StreamResult(new StringWriter());
        	tr.transform(new DOMSource(doc), result);
        
        return result.getWriter().toString();
		
	}
	
	@RequestMapping(value = "/{version}/cdjsontopdf", method = { RequestMethod.POST })
	public List<PDFResponse> cdjsontopdf(@PathVariable String version, @RequestBody ClosingDisclosure closingDisclosure) throws Exception
	{
		LOG.info("Service: cdjsontopdf called");
    	
		ClosingDisclosureServicesImpl closingDisclosureServicesImpl = new ClosingDisclosureServicesImpl();
    	ClosingDisclosurePDFServicesImpl closingDisclosurePDFServicesImpl = new ClosingDisclosurePDFServicesImpl();
		
		String xmldoc = closingDisclosureServicesImpl.createClosingDisclosureXMLfromObject(closingDisclosure);
		
        return closingDisclosurePDFServicesImpl.createPDF(xmldoc);
		
	}
	
	@RequestMapping(value = "/{version}/lejsontopdf", method = { RequestMethod.POST })
	public PDFResponse lejsontopdf(@PathVariable String version, @RequestBody LoanEstimate loanEstimateJSON) throws Exception
	{
		LOG.info("Service: lejsontopdf called");
    	
		LoanEstimateServicesImpl loanEstimateServicesImpl = new LoanEstimateServicesImpl();
    	LoanEstimatePDFServicesImpl loanEstimatePDFServicesImpl = new LoanEstimatePDFServicesImpl();
		
		String xmldoc = loanEstimateServicesImpl.createLoanEstimateXMLfromObject(loanEstimateJSON);
		
		MISMODocument mismoDocument = new MISMODocument(new ByteArrayInputStream(xmldoc.getBytes("utf-8")));
        
        return loanEstimatePDFServicesImpl.generateLoanEstimatePDF(mismoDocument);
		
	}
	
	@RequestMapping(value = "/{version}/validatecdjson", method = { RequestMethod.POST })
	public UCDValidationErrors validatecdjson(@PathVariable String version, @RequestBody ClosingDisclosure closingDisclosure) throws Exception
	{
		LOG.info("Service: validatecdjson called");
    	
		ClosingDisclosureServicesImpl closingDisclosureServicesImpl = new ClosingDisclosureServicesImpl();
		
		String xmldoc = closingDisclosureServicesImpl.createClosingDisclosureXMLfromObject(closingDisclosure);
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new InputSource(new ByteArrayInputStream(xmldoc.getBytes("utf-8"))));
		UCDValidator ucdValidator = new UCDValidator();
		
		return ucdValidator.validateUCDXML(document);
	}
	
	@RequestMapping(value = "/{version}/cdjsontrim", method = { RequestMethod.POST })
	public String cdjsontrim(@PathVariable String version, @RequestBody ClosingDisclosure closingDisclosure) throws Exception
	{
		LOG.info("Service: cdjsontopdf called");
    	
		ClosingDisclosureServicesImpl closingDisclosureServicesImpl = new ClosingDisclosureServicesImpl();
		UCDXMLServiceImpl ucdxmlServiceImpl = new UCDXMLServiceImpl();
		
		String xmldoc = closingDisclosureServicesImpl.createClosingDisclosureXMLfromObject(closingDisclosure);
		InputStream inputXmlStream = new ByteArrayInputStream(xmldoc.getBytes(StandardCharsets.UTF_8));
		
		return ucdxmlServiceImpl.createClosingDisclosureUCDXML(inputXmlStream);
		
	}

	/**
     *convert input data to properties
     * @param s
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
}
