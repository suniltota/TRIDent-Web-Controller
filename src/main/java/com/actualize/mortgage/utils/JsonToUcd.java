package com.actualize.mortgage.utils;

import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.Address;
import com.actualize.mortgage.domainmodels.ClosingInformation;
import com.actualize.mortgage.domainmodels.LoanInformation;
import com.actualize.mortgage.domainmodels.PDFDocument;

public class JsonToUcd {
	private static final String GSE_ALIAS = "gse";
	private static final String MISMO_ALIAS = "mismo";
	private static final String XLINK_ALIAS = "xlink";
	private static final String XMLNS_ALIAS = "xmlns";
	private static final String GSE_URI = "http://www.datamodelextension.org";
	private static final String MISMO_URI = "http://www.mismo.org/residential/2009/schemas";
	private static final String XLINK_URI = "http://www.w3.org/1999/xlink";
	private static final String XSI_URI = "http://www.w3.org/2001/XMLSchema-instance";

	private static final Logger LOGGER = Logger.getLogger(JsonToUcd.class.getName());

	private static final DocumentBuilderFactory dbf = initializeDocumentBuilderFactory();
//	private static final XPath xPath = XPathFactory.newInstance().newXPath();
	
    private static DocumentBuilderFactory initializeDocumentBuilderFactory() {
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
    	return dbf;
    }

    public Document transform(PDFDocument jsonDocument) {
		Document document = null;
		try {
			document = dbf.newDocumentBuilder().newDocument();
			Element message = (Element) document.appendChild(document.createElement(addNamespace("MESSAGE")));
			insertMessage(document, message, jsonDocument);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;
	}

	private String addNamespace(String tag) {
		return (tag.indexOf(':') == -1 ? MISMO_ALIAS + ":" : "") + tag;
	}
	
	private Element insertData(Document document, Element element, String elementName, String elementValue) {
		Element e = null;
		if (elementValue != null && !elementValue.isEmpty()) {
			e = (Element)element.appendChild(document.createElement(addNamespace(elementName)));
			e.appendChild(document.createTextNode(elementValue));
		}
		return element;
	}

	private Element insertLevels(Document xmlout, Element parentElement, String path) {
		Element parent = parentElement;
		for (String container : path.split("/"))
			parent = (Element) parent.appendChild(xmlout.createElement(addNamespace(container)));
		return parent;
	}

	private void insertAboutVersion(Document document, Element element, PDFDocument jsonDocument) {
		// TODO: set correct version number and created date time
		insertData(document, element, "AboutVersionIdentifier", "TRIDent Web Toolkit, v0.1");
		insertData(document, element, "CreatedDatetime", "2017-03-01T14:19:48Z");
	}

	private void insertClosingInformationDetail(Document document, Element element, PDFDocument jsonDocument) {
		ClosingInformation closingInformation = jsonDocument.getPageOne().getClosingInformation();
		insertData(document, element, "ClosingAgentOrderNumberIdentifier", closingInformation.getFileNo());
		insertData(document, element, "ClosingDate", closingInformation.getClosingDate());
		insertData(document, element, "DisbursementDate", closingInformation.getDisbursementDate());
		insertData(document, element, "DocumentOrderClassificationType", "Final");
	}

	private void insertDeal(Document document, Element element, PDFDocument jsonDocument) {
		insertSubjectProperty(document, insertLevels(document, element, "COLLATERALS/COLLATERAL/SUBJECT_PROPERTY"), jsonDocument);
		insertLoan(document, insertLevels(document, element, "LOANS/LOAN"), jsonDocument);
	}

	private void insertDealSet(Document document, Element element, PDFDocument jsonDocument) {
		insertDeal(document, insertLevels(document, element, "DEALS/DEAL"), jsonDocument);
	}

	private void insertDealSets(Document document, Element element, PDFDocument jsonDocument) {
		insertDealSet(document, insertLevels(document, element, "DEAL_SET"), jsonDocument);
	}

	private void insertDocumentSet(Document document, Element element, PDFDocument jsonDocument) {
		element.setAttribute("MISMOReferenceModelIdentifier", "3.3.0299");
		insertDealSets(document, insertLevels(document, element, "DEAL_SETS"), jsonDocument);
	}

	private void insertIntegratedDisclosureDetail(Document document, Element element, PDFDocument jsonDocument) {
		insertData(document, element, "IntegratedDisclosureIssuedDate", jsonDocument.getPageOne().getClosingInformation().getDateIssued());
		insertData(document, element, "IntegratedDisclosureLoanProductDescription", jsonDocument.getPageOne().getLoanInformation().getProduct());
	}

	private void insertLoan(Document document, Element element, PDFDocument jsonDocument) {
		insertClosingInformationDetail(document, insertLevels(document, element, "CLOSING_INFORMATION/CLOSING_INFORMATION_DETAIL"), jsonDocument);
		insertIntegratedDisclosureDetail(document, insertLevels(document, element, "DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_DETAIL"), jsonDocument);
		insertLoanIdentifiers(document, insertLevels(document, element, "LOAN_IDENTIFIERS"), jsonDocument);
		insertMaturityRule(document, insertLevels(document, element, "MATURITY/MATURITY_RULE"), jsonDocument);
		insertTermsOfLoan(document, insertLevels(document, element, "TERMS_OF_LOAN"), jsonDocument);
	}

	private void insertLoanIdentifiers(Document document, Element element, PDFDocument jsonDocument) {
		LoanInformation loanInformation = jsonDocument.getPageOne().getLoanInformation();
		if (!loanInformation.getMic().isEmpty()) {
			Element loanIdentifier = insertLevels(document, element, "LOAN_IDENTIFIER");
			insertData(document, loanIdentifier, "LoanIdentifier", loanInformation.getMic());
			insertData(document, loanIdentifier, "LoanIdentifierType", "AgencyCase");
		}
		if (!loanInformation.getLoanId().isEmpty()) {
			Element loanIdentifier = insertLevels(document, element, "LOAN_IDENTIFIER");
			insertData(document, loanIdentifier, "LoanIdentifier", loanInformation.getLoanId());
			insertData(document, loanIdentifier, "LoanIdentifierType", "LenderLoan");
		}
	}

	private void insertMaturityRule(Document document, Element element, PDFDocument jsonDocument) {
		LoanInformation loanInformation = jsonDocument.getPageOne().getLoanInformation();
		if (!loanInformation.getLoanTerm().isEmpty()) {
			insertData(document, element, "LoanMaturityPeriodCount", loanInformation.getLoanTerm());
			insertData(document, element, "LoanMaturityPeriodType", "Month");
		}
	}

	private void insertMessage(Document document, Element element, PDFDocument jsonDocument) {
		element.setAttribute(XMLNS_ALIAS + ":xsi", XSI_URI);
		element.setAttribute("xsi:schemaLocation", "http://www.mismo.org/residential/2009/schemas ../../../MISMO/V3.3.0_CR_2014-02/ReferenceModel_v3.3.0_B299/MISMO_3.3.0_B299.xsd");
		element.setAttribute(XMLNS_ALIAS + ":" + MISMO_ALIAS, MISMO_URI);
		element.setAttribute(XMLNS_ALIAS + ":" + GSE_ALIAS, GSE_URI);
		element.setAttribute(XMLNS_ALIAS + ":" + XLINK_ALIAS, XLINK_URI);
		element.setAttribute("MISMOReferenceModelIdentifier", "3.3.0299");
		insertAboutVersion(document, insertLevels(document, element, "ABOUT_VERSIONS/ABOUT_VERSION"), jsonDocument);
		insertDocumentSet(document, insertLevels(document, element, "DOCUMENT_SETS/DOCUMENT_SET"), jsonDocument);
	}

	private void insertSubjectProperty(Document document, Element element, PDFDocument jsonDocument) {
		Address address = jsonDocument.getPageOne().getClosingInformation().getProperty();
		insertData(document, element, "AddressLineText", address.getAddressLineText());
		insertData(document, element, "AddressUnitDesignatorType", address.getAddressUnitDesignatorType());
		insertData(document, element, "AddressUnitIdentifier", address.getAddressUnitIdentifier());
		insertData(document, element, "AddressLineText", address.getAddressLineText());
		insertData(document, element, "CityName", address.getCityName());
		insertData(document, element, "PostalCode", address.getPostalCode());
		insertData(document, element, "StateCode", address.getStateCode());
	}

	private void insertTermsOfLoan(Document document, Element element, PDFDocument jsonDocument) {
		LoanInformation loanInformation = jsonDocument.getPageOne().getLoanInformation();
		insertData(document, element, "LienPriorityType", "FirstLien");
		insertData(document, element, "MortgageType", loanInformation.getLoanType());
	}
}
