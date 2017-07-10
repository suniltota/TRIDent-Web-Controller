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

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.actualize.mortgage.cd.domainmodels.ClosingDisclosure;
import com.actualize.mortgage.domainmodels.LoanEstimate;
import com.actualize.mortgage.domainmodels.PDFResponse;
import com.actualize.mortgage.pdf.mismodao.MISMODocument;
import com.actualize.mortgage.service.impl.UCDXMLServiceImpl;
import com.actualize.mortgage.services.impl.ClosingDisclosurePDFServicesImpl;
import com.actualize.mortgage.services.impl.ClosingDisclosureServicesImpl;
import com.actualize.mortgage.services.impl.LoanEstimatePDFServicesImpl;
import com.actualize.mortgage.services.impl.LoanEstimateServicesImpl;
import com.actualize.mortgage.template.mappingmodels.IntermediateXMLData;
import com.actualize.mortgage.template.services.impl.UCDTransformerServiceImpl;
import com.actualize.mortgage.ucd.calculatepayments.CalculatePayments;
import com.actualize.mortgage.validation.domainmodels.UCDValidationErrors;
import com.actualize.mortgage.validation.services.impl.UCDValidator;

/**
 * @author sboragala
 *
 */
@Service
public class TRIDentWebServiceImpl {

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
}
