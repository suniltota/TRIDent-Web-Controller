package com.actualize.mortgage.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.Address;
import com.actualize.mortgage.domainmodels.Borrower;
import com.actualize.mortgage.domainmodels.ClosingInformation;
import com.actualize.mortgage.domainmodels.Lender;
import com.actualize.mortgage.domainmodels.LoanInformation;
import com.actualize.mortgage.domainmodels.LoanTerms;
import com.actualize.mortgage.domainmodels.PDFDocument;
import com.actualize.mortgage.domainmodels.Seller;

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
		insertData(document, element, "AboutVersionIdentifier", "TRIDent Web Toolkit, v0.1"); // TODO: set correct version number
		insertData(document, element, "CreatedDatetime", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + 'Z');
	}

	private void insertAdjustment(Document document, Element element, PDFDocument jsonDocument) {
		insertInterestRateAdjustment(document, insertLevels(document, element, "INTEREST_RATE_ADJUSTMENT"), jsonDocument);
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
		insertParties(document, insertLevels(document, element, "PARTIES"), jsonDocument);
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

	private void insertInterestRateAdjustment(Document document, Element element, PDFDocument jsonDocument) {
		insertInterestRateLifetimeAdjustmentRule(document, insertLevels(document, element, "INTEREST_RATE_LIFETIME_ADJUSTMENT_RULE"), jsonDocument);
	}

	private void insertInterestRateLifetimeAdjustmentRule(Document document, Element element, PDFDocument jsonDocument) {
		LoanTerms loanTerms = jsonDocument.getPageOne().getLoanTerms();
		insertData(document, element, "CeilingRatePercent", loanTerms.getLoanTermsInterestRate().getCeilingRatePercent());
		insertData(document, element, "CeilingRatePercentEarliestEffectiveMonthsCount", loanTerms.getLoanTermsInterestRate().getCeilingRatePercentEarliestEffectiveMonthsCount());
		insertData(document, element, "FirstRateChangeMonthsCount", loanTerms.getLoanTermsInterestRate().getFirstRateChangeMonthsCount());
		//insertData(document, element, "FloorRatePercent", loanTerms.getLoanTermsInterestRate().???);
		//insertData(document, element, "MarginRatePercent", loanTerms.getLoanTermsInterestRate().???);
	}

	private void insertLoan(Document document, Element element, PDFDocument jsonDocument) {
		insertAdjustment(document, insertLevels(document, element, "ADJUSTMENT"), jsonDocument);
		insertClosingInformationDetail(document, insertLevels(document, element, "CLOSING_INFORMATION/CLOSING_INFORMATION_DETAIL"), jsonDocument);
		insertIntegratedDisclosureDetail(document, insertLevels(document, element, "DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_DETAIL"), jsonDocument);
		insertLoanDetail(document, insertLevels(document, element, "LOAN_DETAIL"), jsonDocument);
		insertLoanIdentifiers(document, insertLevels(document, element, "LOAN_IDENTIFIERS"), jsonDocument);
		insertMaturityRule(document, insertLevels(document, element, "MATURITY/MATURITY_RULE"), jsonDocument);
		insertTermsOfLoan(document, insertLevels(document, element, "TERMS_OF_LOAN"), jsonDocument);
	}

	private void insertLoanDetail(Document document, Element element, PDFDocument jsonDocument) {
		LoanTerms loanTerms = jsonDocument.getPageOne().getLoanTerms();
		insertData(document, element, "InterestRateIncreaseIndicator", loanTerms.getLoanTermsInterestRate().getInterestRateIncreaseIndicator());
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

	private void insertParties(Document document, Element element, PDFDocument jsonDocument) {
		List<Borrower> borrowers = jsonDocument.getPageOne().getTransactionInformation().getBorrower();
		for (Borrower borrower : borrowers) {
			Element party = insertLevels(document, element, "PARTY");
			Element roleDetail = insertLevels(document, party, "ROLES/ROLE/ROLE_DETAIL");
			insertData(document, roleDetail, "PartyRoleType", borrower.getPartyRoleType());
			if ("Other".equals(borrower.getPartyRoleType()))
				insertData(document, roleDetail, "PartyRoleTypeOtherDescription", borrower.getPartyRoleOtherDescription());
			Element name = insertLevels(document, party, "INDIVIDUAL/NAME");
			insertData(document, name, "FirstName", borrower.getNameModel().getFirstName());
			insertData(document, name, "LastName", borrower.getNameModel().getLastName());
			insertData(document, name, "MiddleName", borrower.getNameModel().getMiddleName());
			insertData(document, name, "SuffixName", borrower.getNameModel().getSuffixName());
			Element address = insertLevels(document, party, "ADDRESSES/ADDRESS");
			insertData(document, address, "AddressLineText", borrower.getAddress().getAddressLineText());
			insertData(document, address, "AddressUnitDesignatorType", borrower.getAddress().getAddressUnitDesignatorType());
			insertData(document, address, "AddressUnitIdentifier", borrower.getAddress().getAddressUnitIdentifier());
			insertData(document, address, "CityName", borrower.getAddress().getCityName());
			insertData(document, address, "CountryCode", borrower.getAddress().getCountryCode());
			insertData(document, address, "PostalCode", borrower.getAddress().getPostalCode());
			insertData(document, address, "StateCode", borrower.getAddress().getStateCode());
		}

		List<Seller> sellers = jsonDocument.getPageOne().getTransactionInformation().getSeller();
		for (Seller seller : sellers) {
			Element party = insertLevels(document, element, "PARTY");
			Element roleDetail = insertLevels(document, party, "ROLES/ROLE/ROLE_DETAIL");
			insertData(document, roleDetail, "PartyRoleType", "Seller");
			Element name = insertLevels(document, party, "INDIVIDUAL/NAME");
			insertData(document, name, "FirstName", seller.getNameModel().getFirstName());
			insertData(document, name, "LastName", seller.getNameModel().getLastName());
			insertData(document, name, "MiddleName", seller.getNameModel().getMiddleName());
			insertData(document, name, "SuffixName", seller.getNameModel().getSuffixName());
			Element address = insertLevels(document, party, "ADDRESSES/ADDRESS");
			insertData(document, address, "AddressLineText", seller.getAddress().getAddressLineText());
			insertData(document, address, "AddressUnitDesignatorType", seller.getAddress().getAddressUnitDesignatorType());
			insertData(document, address, "AddressUnitIdentifier", seller.getAddress().getAddressUnitIdentifier());
			insertData(document, address, "CityName", seller.getAddress().getCityName());
			insertData(document, address, "CountryCode", seller.getAddress().getCountryCode());
			insertData(document, address, "PostalCode", seller.getAddress().getPostalCode());
			insertData(document, address, "StateCode", seller.getAddress().getStateCode());
		}

		List<Lender> lenders = jsonDocument.getPageOne().getTransactionInformation().getLender(); // TODO: There should be two lenders - one individual and one organization
		for (Lender lender : lenders) {
			Element party = insertLevels(document, element, "PARTY");
			Element roleDetail = insertLevels(document, party, "ROLES/ROLE/ROLE_DETAIL");
			insertData(document, roleDetail, "PartyRoleType", "NotePayTo");
			Element legalEntity = insertLevels(document, party, "LEGAL_ENTITY/LEGAL_ENTITY_DETAIL");
			insertData(document, legalEntity, "FullName", lender.getNameModel().getFullName());
			Element address = insertLevels(document, party, "ADDRESSES/ADDRESS");
			insertData(document, address, "AddressLineText", lender.getAddress().getAddressLineText());
			insertData(document, address, "AddressUnitDesignatorType", lender.getAddress().getAddressUnitDesignatorType());
			insertData(document, address, "AddressUnitIdentifier", lender.getAddress().getAddressUnitIdentifier());
			insertData(document, address, "CityName", lender.getAddress().getCityName());
			insertData(document, address, "CountryCode", lender.getAddress().getCountryCode());
			insertData(document, address, "PostalCode", lender.getAddress().getPostalCode());
			insertData(document, address, "StateCode", lender.getAddress().getStateCode());
			//Element licenseDetail = insertLevels(document, party, "LICENSE/LICENSE_DETAIL");
			//insertData(document, licenseDetail, "NMLSID", lender.???);
		}
		
		// TODO: Mortgage Broker, SettlementAgent, Real Estate Agent (Buyer, Seller)
	}

	private void insertSubjectProperty(Document document, Element element, PDFDocument jsonDocument) {
		Address address = jsonDocument.getPageOne().getClosingInformation().getProperty();
		insertData(document, element, "AddressLineText", address.getAddressLineText());
		insertData(document, element, "AddressUnitDesignatorType", address.getAddressUnitDesignatorType());
		insertData(document, element, "AddressUnitIdentifier", address.getAddressUnitIdentifier());
		insertData(document, element, "CityName", address.getCityName());
		insertData(document, element, "PostalCode", address.getPostalCode());
		insertData(document, element, "StateCode", address.getStateCode());
	}

	private void insertTermsOfLoan(Document document, Element element, PDFDocument jsonDocument) {
		LoanInformation loanInformation = jsonDocument.getPageOne().getLoanInformation();
		LoanTerms loanTerms = jsonDocument.getPageOne().getLoanTerms();
		insertData(document, element, "LienPriorityType", "FirstLien");
		insertData(document, element, "MortgageType", loanInformation.getLoanType());
		insertData(document, element, "NoteAmount", loanTerms.getLoanTermsLoanAmount().getNoteAmount());
		insertData(document, element, "NoteRatePercent", loanTerms.getLoanTermsInterestRate().getNoteRatePercent());
	}
}
