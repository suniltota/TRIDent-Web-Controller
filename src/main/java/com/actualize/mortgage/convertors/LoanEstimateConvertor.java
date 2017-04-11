package com.actualize.mortgage.convertors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.actualize.mortgage.ledatamodels.Deal;
import com.actualize.mortgage.ledatamodels.DocumentClass;
import com.actualize.mortgage.ledatamodels.DocumentClassification;
import com.actualize.mortgage.ledatamodels.LoanIdentifier;
import com.actualize.mortgage.ledatamodels.MISMODocument;
import com.actualize.mortgage.ledatamodels.TermsOfLoan;

public class LoanEstimateConvertor {
	
	/**
	 * 
	 * @param in
	 * @param validate
	 * @return xml as document
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	public Document run(InputStream in, boolean validate) throws ParserConfigurationException, IOException, SAXException {
		// Create the results document and root element ("Results")
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document xmldoc = builder.newDocument();
		Element resultsElement = xmldoc.createElement("Results");
        xmldoc.appendChild(resultsElement);
        Element statusElement = xmldoc.createElement("Status");
        resultsElement.appendChild(statusElement);
        
        // Add the start and end times
		Element startElement = xmldoc.createElement("StartTime");
		resultsElement.appendChild(startElement);
		Element endElement = xmldoc.createElement("EndTime");
		resultsElement.appendChild(endElement);

		// Stamp the start time
		startElement.appendChild(xmldoc.createTextNode(new Date().toString()));

    	// Save input stream into ByteArrayOutputStream (needed for multiple purposes, e.g. validation and input)
    	ByteArrayOutputStream baos = inputStreamToByteArrayOutputStream(in);
		in.close();


		MISMODocument data = new MISMODocument(new ByteArrayInputStream(baos.toByteArray()));
	  //  insertPdfResults(data, xmldoc, resultsElement);

		// Stamp the end time
    	endElement.appendChild(xmldoc.createTextNode(new Date().toString()));

    	// Set status to success
    	statusElement.appendChild(xmldoc.createTextNode("Success"));
    	return xmldoc;
	}
	
	/**
	 * converts inputStream to ByteArrayOutputStream
	 * @param in
	 * @return xml as ByteArrayOutputStream
	 * @throws IOException
	 */
	private static ByteArrayOutputStream inputStreamToByteArrayOutputStream(InputStream in) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		while ((len = in.read(buffer)) > -1 ) {
		    baos.write(buffer, 0, len);
		}
		baos.flush();
		return baos;
	}
	
	/**
	 * 
	 * @param data
	 * @throws IOException
	 */
	public void run(MISMODocument data) throws  IOException {

		// Grab deal and loan identifier
		Deal deal = null;
		NodeList nodes = data.getElementsAddNS("//DEAL");
		NodeList documentClassificationNodes = data.getElementsAddNS("//DOCUMENT_CLASSIFICATION");
		
		if (nodes.getLength() > 0)
			deal = new Deal(Deal.NS, (Element)nodes.item(0));
		LoanIdentifier loanIdentifier = new LoanIdentifier((Element)deal.getElementAddNS("LOANS/LOAN/LOAN_IDENTIFIERS/LOAN_IDENTIFIER[LoanIdentifierType='LenderLoan']"));
		TermsOfLoan termsOfLoan = new TermsOfLoan((Element)deal.getElementAddNS("LOANS/LOAN/TERMS_OF_LOAN[LoanPurposeType='Refinance']"));

		DocumentClassification documentClassification = null;
		if(documentClassificationNodes.getLength()>0)
		    documentClassification = new DocumentClassification(DocumentClassification.NS, (Element)documentClassificationNodes.item(0));
		
		DocumentClass documentClass = new DocumentClass((Element)documentClassification.getElementAddNS("DOCUMENT_CLASSES/DOCUMENT_CLASS[DocumentType='Other']"));
		
	}
}
