package com.actualize.mortgage.utils;

import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.actualize.mortgage.cdpagemodels.ClosingDisclosure;
import com.actualize.mortgage.domainmodels.AddressModel;
import com.actualize.mortgage.domainmodels.AutomatedUnderwritingsModel;
import com.actualize.mortgage.domainmodels.Borrower;
import com.actualize.mortgage.domainmodels.CashToClose;
import com.actualize.mortgage.domainmodels.CashToCloseModel;
import com.actualize.mortgage.domainmodels.ClosingAdjustmentItemModel;
import com.actualize.mortgage.domainmodels.ClosingCostFundModel;
import com.actualize.mortgage.domainmodels.ClosingCostProperties;
import com.actualize.mortgage.domainmodels.ClosingInformationDetailModel;
import com.actualize.mortgage.domainmodels.ConstructionModel;
import com.actualize.mortgage.domainmodels.ContactInformationDetailModel;
import com.actualize.mortgage.domainmodels.DocumentClassificationModel;
import com.actualize.mortgage.domainmodels.ETIA;
import com.actualize.mortgage.domainmodels.ETIASection;
import com.actualize.mortgage.domainmodels.EscrowItemModel;
import com.actualize.mortgage.domainmodels.IntegratedDisclosureDetailModel;
import com.actualize.mortgage.domainmodels.IntegratedDisclosureSectionSummaryDetailModel;
import com.actualize.mortgage.domainmodels.IntegratedDisclosureSectionSummaryModel;
import com.actualize.mortgage.domainmodels.IntegratedDisclosureSubsectionPaymentModel;
import com.actualize.mortgage.domainmodels.InterestOnlyModel;
import com.actualize.mortgage.domainmodels.InterestRateAdjustmentModel;
import com.actualize.mortgage.domainmodels.LateChargeRuleModel;
import com.actualize.mortgage.domainmodels.LiabilityModel;
import com.actualize.mortgage.domainmodels.LoanCalculationModel;
import com.actualize.mortgage.domainmodels.LoanDetailModel;
import com.actualize.mortgage.domainmodels.LoanInformation;
import com.actualize.mortgage.domainmodels.LoanInformationLoanIdentifier;
import com.actualize.mortgage.domainmodels.LoanProductModel;
import com.actualize.mortgage.domainmodels.LoanTermsPrepaymentPenalty;
import com.actualize.mortgage.domainmodels.LoanTermsTemporaryBuydown;
import com.actualize.mortgage.domainmodels.MIDataDetailModel;
import com.actualize.mortgage.domainmodels.MaturityRuleModel;
import com.actualize.mortgage.domainmodels.MismoContactPointsModel;
import com.actualize.mortgage.domainmodels.MismoIndividualModel;
import com.actualize.mortgage.domainmodels.MismoPaymentsModel;
import com.actualize.mortgage.domainmodels.MismoProjectedPaymentsModel;
import com.actualize.mortgage.domainmodels.NameModel;
import com.actualize.mortgage.domainmodels.NegativeAmortizationModel;
import com.actualize.mortgage.domainmodels.OtherModel;
import com.actualize.mortgage.domainmodels.PartialPaymentModel;
import com.actualize.mortgage.domainmodels.PartialPaymentsModel;
import com.actualize.mortgage.domainmodels.PaymentModel;
import com.actualize.mortgage.domainmodels.PaymentRuleModel;
import com.actualize.mortgage.domainmodels.PaymentsModel;
import com.actualize.mortgage.domainmodels.Prepaids;
import com.actualize.mortgage.domainmodels.PrincipalAndInterestPaymentAdjustmentModel;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsDetails;
import com.actualize.mortgage.domainmodels.PropertyValuationDetailModel;
import com.actualize.mortgage.domainmodels.ProrationModel;
import com.actualize.mortgage.domainmodels.QualifiedMortgageModel;
import com.actualize.mortgage.domainmodels.SalesContractDetailModel;
import com.actualize.mortgage.domainmodels.TermsOfLoanModel;

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
	/**
	 * Method is used to transform one file into another form
	 * @param jsonDocument is Input JSON Object
	 * @return object of Document
	 * @throws TransformerFactoryConfigurationError 
	 * @throws TransformerConfigurationException 
	 */
    public String transform(ClosingDisclosure jsonDocument) throws Exception {
		Document document = null;
		try {
			document = dbf.newDocumentBuilder().newDocument();
			Element message = (Element) document.appendChild(document.createElement(addNamespace("MESSAGE")));
			insertMessage(document, message, jsonDocument);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Transformer tr = TransformerFactory.newInstance().newTransformer();
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        tr.setOutputProperty(OutputKeys.METHOD, "xml");
        tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        StreamResult result = new StreamResult(new StringWriter());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        tr.transform(new DOMSource(document), result);
        String xmlString = result.getWriter().toString();
		return xmlString;
	}
	
	private String addNamespace(String tag) {
		return (tag.indexOf(':') == -1 ? MISMO_ALIAS + ":" : "") + tag;
	}
	/**
	 * Inserts Data to XML Object from JSON Object
	 * @param document Output XML file
	 * @param element parent node of XML
	 * @param element parent node of XMLName
	 * @param element parent node of XMLValue
	 * @return
	 */
	private Element insertData(Document document, Element element, String elementName, String elementValue) {
		Element e = null;
		if (elementValue != null && !elementValue.isEmpty()) {
			e = (Element)element.appendChild(document.createElement(addNamespace(elementName)));
			e.appendChild(document.createTextNode(elementValue));
		}
		return element;
	}
	/**
	 * Inserts Data to XML Object from JSON Object
	 * @param document Output XML file
	 * @param element parent node of XML
	 * @param element parent node of XMLName
	 * @param element parent node of XMLValue
	 * @return
	 */
	private Element returnElement(Document document, Element element, String elementName, String elementValue) {
		Element e = null;
		if (elementValue != null && !elementValue.isEmpty()) {
			e = (Element)element.appendChild(document.createElement(addNamespace(elementName)));
			e.appendChild(document.createTextNode(elementValue));
		}
		return e;
	}
	/**
	 * Inserts Levels from JSON Object
	 * @param document Output XML file
	 * @param element parent node of XML
	 * @param element parent node of XMLName
	 * @param element parent node of XMLValue
	 * @return
	 */
	private Element insertLevels(Document xmlout, Element parentElement, String path) {
		Element parent = parentElement;
		for (String container : path.split("/"))
			parent = (Element) parent.appendChild(xmlout.createElement(addNamespace(container)));
		return parent;
	}
	/**
     * Inserts About Version from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertAboutVersion(Document document, Element element, ClosingDisclosure jsonDocument) {
		// TODO: set correct version number and created date time
		insertData(document, element, "AboutVersionIdentifier", "TRIDent Web Toolkit, v0.1"); //TODO: This datapoint is not found in UCD Spec. 
		insertData(document, element, "CreatedDatetime", Convertor.getUTCDate());
	}
	/**
     * Inserts Closing Information Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertClosingInformationDetail(Document document, Element element, ClosingInformationDetailModel closingInformationDetailModel) {
		insertData(document, element, "CashFromBorrowerAtClosingAmount", closingInformationDetailModel.getCashFromBorrowerAtClosingAmount());
		insertData(document, element, "CashFromSellerAtClosingAmount", closingInformationDetailModel.getCashFromSellerAtClosingAmount());
		insertData(document, element, "CashToBorrowerAtClosingAmount", closingInformationDetailModel.getCashToBorrowerAtClosingAmount());
		insertData(document, element, "CashToSellerAtClosingAmount", closingInformationDetailModel.getCashToSellerAtClosingAmount());
		insertData(document, element, "CurrentRateSetDate", closingInformationDetailModel.getCurrentRateSetDate());
		insertData(document, element, "DocumentOrderClassificationType", closingInformationDetailModel.getDocumentOrderClassificationType()); //TODO: This datapoint is not found in UCD Spec.
		insertData(document, element, "ClosingAgentOrderNumberIdentifier", closingInformationDetailModel.getClosingAgentOrderNumberIdentifier());
		insertData(document, element, "ClosingDate", closingInformationDetailModel.getClosingDate());
		insertData(document, element, "DisbursementDate", closingInformationDetailModel.getDisbursementDate());
		
	}
    /**
     * Inserts Deal to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertDeal(Document document, Element element, ClosingDisclosure jsonDocument) {
		insertSubjectProperty(document, insertLevels(document, element, "COLLATERALS/COLLATERAL/SUBJECT_PROPERTY"), jsonDocument);
		insertLoan(document, insertLevels(document, element, "LOANS/LOAN"), jsonDocument);
		   insertParties(document, insertLevels(document, element, "PARTIES"), jsonDocument);
		if(jsonDocument.getLiabilityList().size() > 0)
			insertLiabilities(document, insertLevels(document, element, "LIABILITIES"), jsonDocument.getLiabilityList());
	}
	
	/**
	 * inserts Liabilities to MISMO XML 
	 * @param document
	 * @param element
	 * @param liabilityList
	 */
	private void insertLiabilities(Document document, Element element, List<LiabilityModel> liabilityList) {
		for (LiabilityModel liabilityModel : liabilityList)
			insertLiability(document, insertLevels(document, element, "LIABILITY"), liabilityModel);
	}
	
	/**
	 * inserts Liability from JSON Object to XML
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	private void insertLiability(Document document, Element element, LiabilityModel liabilityModel) {
		 insertLiabilityDetail(document, insertLevels(document, element, "LIABILITY_DETAIL"), liabilityModel);
		 insertLiabilityHolder(document, insertLevels(document, element, "LIABILITY_HOLDER"), liabilityModel);
		 insertPayoff(document, insertLevels(document, element, "PAYOFF"), liabilityModel);
	}
	
	/**
	 * inserts Payoff to MISMO XML
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	private void insertPayoff(Document document, Element element, LiabilityModel liabilityModel) {
		OtherModel other = new OtherModel();
		insertData(document, element, "PayoffAmount", liabilityModel.getPayoffAmount());
		insertData(document, element, "PayoffPrepaymentPenaltyAmount", liabilityModel.getPayoffPrepaymentPenaltyAmount());
		insertExtension(document, insertLevels(document, element, "EXTENSION"), other);
	}
	
	/** 
	 * inserts Liability Holder to MISMO XML
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	 private void insertLiabilityHolder(Document document, Element element,
			 LiabilityModel liabilityModel) {
		NameModel name = new NameModel();
			name.setFullName(liabilityModel.getLiabilityHolderFullName());
		insertName(document, insertLevels(document, element, "NAME"), name);
	 }
	 
	/**
	 * inserts LiabilityDetail to MISMO XML
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	private void insertLiabilityDetail(Document document, Element element,
			LiabilityModel liabilityModel) {
		OtherModel other = new OtherModel();
			other.setIntegratedDisclosureSectionType(liabilityModel.getIntegratedDisclosureSectionType());
			other.setLiabilitySecuredBySubjectPropertyIndicator(Boolean.toString(liabilityModel.isLiabilitySecuredBySubjectPropertyIndicator()));
			
		insertData(document, element, "LiabilityDescription", liabilityModel.getLiabilityDescription());
		Element liabilityTypeElement = insertData(document, element, "LiabilityType", liabilityModel.getLiabilityType());
		liabilityTypeElement.setAttribute("gse:DisplayLabelText", liabilityModel.getDisplayLabel());
		insertData(document, element, "LiabilityTypeOtherDescription", liabilityModel.getLiabilityTypeOtherDescription());
		insertExtension(document, insertLevels(document, element, "EXTENSION"),other);
	}
	
	/**
	 * inserts Deal Set to MISMO XML
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	private void insertDealSet(Document document, Element element, ClosingDisclosure jsonDocument) {
		insertDeal(document, insertLevels(document, element, "DEALS/DEAL"), jsonDocument);
	}
	
	/**
     * inserts Deal Sets to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertDealSets(Document document, Element element, ClosingDisclosure jsonDocument) {
		insertDealSet(document, insertLevels(document, element, "DEAL_SET"), jsonDocument);
	}
	/**
     * Inserts Document Set to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertDocumentSet(Document document, Element element, ClosingDisclosure jsonDocument) {
		insertDocuments(document, insertLevels(document, element, "DOCUMENTS"), jsonDocument);
	}
	/**
     * Inserts Documents to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertDocuments(Document document, Element element, ClosingDisclosure jsonDocument) {
		insertDocument(document, insertLevels(document, element, "DOCUMENT"), jsonDocument);
	}
	/**
     * Inserts Document to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */	
	private void insertDocument(Document document, Element element, ClosingDisclosure jsonDocument) {
		element.setAttribute("MISMOReferenceModelIdentifier", "3.3.0299");
		insertDealSets(document, insertLevels(document, element, "DEAL_SETS"), jsonDocument);
	/*	insertAuditTrail(document, insertLevels(document, element, "AUDIT_TRAIL"), jsonDocument);
		insertRelationships(document, insertLevels(document, element, "RELATIONSHIPS"), jsonDocument);
		insertSignatories(document, insertLevels(document, element, "SIGNATORIES"), jsonDocument);
		insertSystemSignatures(document, insertLevels(document, element, "SYSTEM_SIGNATORIES"), jsonDocument);
		insertViews(document, insertLevels(document, element, "VIEWS"), jsonDocument);*/
		insertAboutVersions(document, insertLevels(document, element, "ABOUT_VERSIONS"), null);
		insertDocumentClassification(document, insertLevels(document, element, "DOCUMENT_CLASSIFICATION"), jsonDocument.getDocumentClassification());
	}
	
	/**
	 * inserts DocumentClassification in MISMO XML
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	private void insertDocumentClassification(Document document, Element element,
			DocumentClassificationModel documentClassification) {
		insertDocumentClasses(document,	insertLevels(document, element, "DOCUMENT_CLASSES"), documentClassification);
		insertDocumentClassificationDetail(document, insertLevels(document, element, "DOCUMENT_CLASSIFICATION_DETAIL"), documentClassification);
	}
	
	private void insertDocumentClassificationDetail(Document document, Element element,
			DocumentClassificationModel documentClassification) {
		OtherModel other = new OtherModel();
			other.setDocumentSignatureRequiredIndicator(Boolean.toString(documentClassification.isDocumentSignatureRequiredIndicator()).toLowerCase());
		insertData(document, element, "DocumentFormIssuingEntityNameType", documentClassification.getDocumentFormIssuingEntityNameType());
		insertData(document, element, "DocumentFormIssuingEntityVersionIdentifier", documentClassification.getDocumentFormIssuingEntityVersionIdentifier());
		insertExtension(document, insertLevels(document, element, "EXTENSION"), other);
	}
	
	private void insertDocumentClasses(Document document, Element element,
			DocumentClassificationModel documentClassification) {
		//for (String group : groupings)
			insertDocumentClass(document, insertLevels(document, element, "DOCUMENT_CLASS"), documentClassification);
	}
	
	private void insertDocumentClass(Document document, Element element, DocumentClassificationModel documentClassification) {

		insertData(document, element, "DocumentType", documentClassification.getDocumentType());
		insertData(document, element, "DocumentTypeOtherDescription",documentClassification.getDocumentTypeOtherDescription());
	}
	/**
     * Inserts Views from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertViews(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
			insertView(document, insertLevels(document, element, "VIEW"), jsonDocument);
	}
	*//**
     * Inserts View from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertView(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertViewFile(document, insertLevels(document, element, "VIEW_FILES/VIEW_FILE"), jsonDocument);
	}
	*//**
     * Inserts View File from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertViewFile(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertForeignObject(document, insertLevels(document, element, "FOREIGN_OBJECT"), jsonDocument);
	}
	*//**
     * Inserts Foreign Object from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertForeignObject(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertLevels(document, element, "EmbeddedContentXML"); // Placeholder for Base64 document
        element.appendChild(document.createElement(addNamespace("MIMETypeIdentifier")))
               .appendChild(document.createTextNode("application/pdf"));
        element.appendChild(document.createElement(addNamespace("ObjectEncodingType")))
               .appendChild(document.createTextNode("Base64"));
        element.appendChild(document.createElement(addNamespace("ObjectName")))
               .appendChild(document.createTextNode("ClosingDisclosure.pdf"));
	}
	*//**
     * Inserts System Signatories from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertSystemSignatures(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
			insertSignature(document, insertLevels(document, element, "SYSTEM_SIGNATURE"), jsonDocument);
	}
	*//**
     * Inserts Signature from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertSignature(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "XMLDigitalSignatureElement", "");
	}
	*//**
     * Inserts Signatories from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*	
	private void insertSignatories(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
			insertSignatory(document, insertLevels(document, element, "SIGNATORY"), jsonDocument);
	}
	*//**
     * Inserts Signatory from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*	
	private void insertSignatory(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		element.setAttribute("SequenceNumber", "");
		element.setAttribute(XLINK_ALIAS + ":label", "");
		insertExecution(document, insertLevels(document, element, "EXECUTION"), jsonDocument);
	}
	*//**
     * Inserts Relationships from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*		
	private void insertRelationships(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
			insertRelationship(document, insertLevels(document, element, "RELATIONSHIP"), jsonDocument);
	}
	*//**
     * Inserts Relationship from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*	
	private void insertRelationship(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		element.setAttribute("SequenceNumber", "");
		element.setAttribute(XLINK_ALIAS + ":from", "");
		element.setAttribute(XLINK_ALIAS + ":to", "");
		element.setAttribute(XLINK_ALIAS + ":arcrole", "");
	}
	*//**
     * Inserts Audit Trail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*	
	private void insertAuditTrail(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertAuditTrailEntries(document, insertLevels(document, element, "AUDIT_TRAIL_ENTRIES"), jsonDocument);
	}
	*//**
     * Inserts Audit Trail Entries from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*	
	private void insertAuditTrailEntries(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertAuditTrailEntry(document, insertLevels(document, element, "AUDIT_TRAIL_ENTRY"), jsonDocument);
	}
	*//**
     * Inserts Audit Trail Entry from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*		
	private void insertAuditTrailEntry(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertAuditTrailEntryDetail(document, insertLevels(document, element, "AUDIT_TRAIL_ENTRY_DETAIL"), jsonDocument);
	}
	*//**
     * Inserts Audit Trail Entry Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*	
	private void insertAuditTrailEntryDetail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "EntryDatetime", "");
		insertData(document, element, "EventType", "");
		insertData(document, element, "EventTypeOtherDescription", "");
	}
	*//**
     * Inserts About Versions to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */	
	private void insertAboutVersions(Document document, Element element, ClosingDisclosure jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
		insertAboutVersionsInDocument(document, insertLevels(document, element, "ABOUT_VERSION"), jsonDocument);
			
	}
	/**
	 * Inserts About Versions under documents to MISMO XML
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	private void insertAboutVersionsInDocument(Document document, Element element, ClosingDisclosure jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
		insertData(document, element, "AboutVersionIdentifier", "Retrievable"); //TODO: This datapoint is not found in UCD Spec. 
		insertData(document, element, "DataVersionIdentifier", "UCD Delivery Specification 1.4");
	}
	/**
     * inserts Integrated Disclosure Detail to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertIntegratedDisclosureDetail(Document document, Element element, IntegratedDisclosureDetailModel integratedDisclosureDetail) {
		insertData(document, element, "FirstYearTotalEscrowPaymentAmount", integratedDisclosureDetail.getFirstYearTotalEscrowPaymentAmount());
		insertData(document, element, "FirstYearTotalEscrowPaymentDescription", integratedDisclosureDetail.getFirstYearTotalEscrowPaymentDescription());
		insertData(document, element, "FirstYearTotalNonEscrowPaymentAmount", integratedDisclosureDetail.getFirstYearTotalNonEscrowPaymentAmount());
		insertData(document, element, "FirstYearTotalNonEscrowPaymentDescription", integratedDisclosureDetail.getFirstYearTotalNonEscrowPaymentDescription());
		insertData(document, element, "IntegratedDisclosureHomeEquityLoanIndicator", Boolean.toString(integratedDisclosureDetail.isIntegratedDisclosureHomeEquityLoanIndicator()));
		insertData(document, element, "IntegratedDisclosureLoanProductDescription", integratedDisclosureDetail.getIntegratedDisclosureLoanProductDescription());
		insertData(document, element, "IntegratedDisclosureIssuedDate", integratedDisclosureDetail.getIntegratedDisclosureIssuedDate());
	}
	/**
	 * inserts Loan to MISMO XML
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	private void insertLoan(Document document, Element element, ClosingDisclosure jsonDocument) {
		
		insertAdjustment(document, insertLevels(document, element, "ADJUSTMENT"), jsonDocument);
		insertAmortizationRule(document, insertLevels(document, element, "AMORTIZATION/AMORTIZATION_RULE"), jsonDocument.getLoanInformation());
		insertBuydown(document, insertLevels(document, element, "BUYDOWN"), jsonDocument.getLoanTerms().getLoanTermsTemporaryBuydown());
		insertClosingInformation(document, insertLevels(document, element, "CLOSING_INFORMATION"), jsonDocument);
		insertConstruction(document, insertLevels(document, element, "CONSTRUCTION"), jsonDocument.getConstruction());
		insertDocumentSpecificDataSet(document, insertLevels(document, element, "DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET"), jsonDocument);
		insertEscrow(document, insertLevels(document, element, "ESCROW"), jsonDocument);
		insertFeeInformation(document, insertLevels(document, element, "FEE_INFORMATION"), jsonDocument);
		insertForeclosures(document, insertLevels(document, element, "FORECLOSURES"), Boolean.toString(jsonDocument.getLoanCalculationsQualifiedMortgage().getLoanCalculationModel().isDeficiencyRightsPreservedIndicator()).toLowerCase()); // Not needed for LE
		/*insertHeloc(document, insertLevels(document, element, "HELOC"), jsonDocument); // Not needed for LE*/
		insertHighCostMortgages(document, insertLevels(document, element, "HIGH_COST_MORTGAGES"), jsonDocument.getLoanCalculationsQualifiedMortgage().getQualifiedMortgage()); //  Not needed for LE
		//insertHmdaLoan(document, insertLevels(document, element, "HMDA_LOAN"), jsonDocument); //  Not needed for LE*/
		insertInterestOnly(document, insertLevels(document, element, "INTEREST_ONLY"), jsonDocument.getInterestOnly());
		//check for NULL
		insertLateChargeRule(document, insertLevels(document, element, "LATE_CHARGE/EXTENSION/OTHER/gse:LATE_CHARGE_RULES/LATE_CHARGE_RULE"), jsonDocument.getLateChargeRule());
		insertLoanDetail(document, insertLevels(document, element, "LOAN_DETAIL"), jsonDocument.getLoanDetail());
		insertLoanIdentifiers(document, insertLevels(document, element, "LOAN_IDENTIFIERS"), jsonDocument.getLoanInformation().getLoanIdentifiers());
		//insertLoanLevelCredit(document, insertLevels(document, element, "LOAN_LEVEL_CREDIT"), jsonDocument);
		if(! jsonDocument.getLoanProduct().getLoanPriceQuoteInterestRatePercent().isEmpty() && null != jsonDocument.getLoanProduct().getLoanPriceQuoteInterestRatePercent())
		insertLoanProduct(document, insertLevels(document, element, "LOAN_PRODUCT"), jsonDocument.getLoanProduct());
		insertMaturityRule(document, insertLevels(document, element, "MATURITY/MATURITY_RULE"), jsonDocument.getMaturityRule());
		insertMIDataDetail(document, insertLevels(document, element, "MI_DATA/MI_DATA_DETAIL"), jsonDocument.getMiDataDetail()); 
		insertNegativeAmortization(document, insertLevels(document, element, "NEGATIVE_AMORTIZATION"), jsonDocument.getNegativeAmortization());
		insertPayment(document, insertLevels(document, element, "PAYMENT"), jsonDocument.getPayment());
		insertPrepaymentPenalty(document, insertLevels(document, element, "PREPAYMENT_PENALTY"), jsonDocument.getLoanTerms().getLoanTermsPrepaymentPenalty());
		//insertQualification(document, insertLevels(document, element, "QUALIFICATION"), jsonDocument); //Not needed for LE
		insertQualifiedMortgage(document, insertLevels(document, element, "QUALIFIED_MORTGAGE"), jsonDocument.getLoanCalculationsQualifiedMortgage().getQualifiedMortgage()); // Not needed for LE
		insertRefinance(document, insertLevels(document, element, "REFINANCE"),Boolean.toString(jsonDocument.getTransactionInformation().isRefinanceSameLenderIndicator()).toLowerCase()); //Not needed for LE
		/*insertReverseMortgage(document, insertLevels(document, element, "REVERSE_MORTGAGE"), jsonDocument); //Not needed for LE
		insertServicing(document, insertLevels(document, element, "SERVICING"), jsonDocument); // Not needed for LE
*/		insertTermsOfLoan(document, insertLevels(document, element, "TERMS_OF_LOAN"), jsonDocument.getTermsOfLoan());
		insertUnderwriting(document, insertLevels(document, element, "UNDERWRITING"), jsonDocument); // Not needed for LE
	
	}
    /**
     * Inserts Underwriting to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertUnderwriting(Document document, Element element, ClosingDisclosure jsonDocument) {
		insertAutomatedUnderwritings(document, insertLevels(document, element, "AUTOMATED_UNDERWRITINGS"), jsonDocument.getLoanInformation().getAutomatedUnderwritings());
		insertUnderwritingDetail(document, insertLevels(document, element, "UNDERWRITING_DETAIL"), Boolean.toString(jsonDocument.getLoanInformation().isLoanManualUnderwritingIndicator()));
	}
	/**
     * Inserts Underwriting Detail to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertUnderwritingDetail(Document document, Element element,
			String loanManualUnderwritingIndicator) {
		insertData(document, element, "LoanManualUnderwritingIndicator", loanManualUnderwritingIndicator);
	}

	/**
    * Inserts Automated Underwritings to MISMO XML
    * @param document Output XML file
    * @param element parent node of XML
    * @param jsonDocument Input JSON Object
    */
    private void insertAutomatedUnderwritings(Document document, Element element,
    		List<AutomatedUnderwritingsModel> automatedUnderwritingsModels) {
    	for (AutomatedUnderwritingsModel automatedUnderwritings : automatedUnderwritingsModels)
			insertAutomatedUnderwriting(document, insertLevels(document, element, "AUTOMATED_UNDERWRITING"), automatedUnderwritings);
	}
    /**
     * Inserts Automated Underwriting to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertAutomatedUnderwriting(Document document, Element element,
			AutomatedUnderwritingsModel automatedUnderwritings) {
		insertData(document, element, "AutomatedUnderwritingCaseIdentifier", automatedUnderwritings.getAutomatedUnderwritingCaseIdentifier());
		//insertData(document, element, "AutomatedUnderwritingRecommendationDescription", automatedUnderwritings.get);
		insertData(document, element, "AutomatedUnderwritingSystemType", automatedUnderwritings.getAutomatedUnderwritingSystemType());
		insertData(document, element, "AutomatedUnderwritingSystemTypeOtherDescription", automatedUnderwritings.getAutomatedUnderwritingSystemTypeOtherDescription());
	}

	/**
     * Inserts Servicing from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertServicing(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertServicingDetail(document, insertLevels(document, element, "SERVICING_DETAIL"), jsonDocument);
	}
	*//**
     * Inserts Servicing Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
    private void insertServicingDetail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
    	insertData(document, element, "LoanAcquisitionActualUPBAmount", "");
	}

	*//**
     * Inserts Reverse Mortgage from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertReverseMortgage(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "ReverseInitialPrincipalLimitAmount", "");
	}
    *//**
     * Inserts Refinace to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertRefinance(Document document, Element element, String refinanceSameLenderIndicator) {
		//insertData(document, element, "RefinanceCashOutDeterminationType", "");
		insertData(document, element, "RefinanceSameLenderIndicator", refinanceSameLenderIndicator);
	}
	/**
	 * Inserts Qualified Mortgage to MISMO XML
	 * @param document Output XML file
	 * @param element parent node of XML
	 * @param jsonDocument Input JSON Object
	 */
	private void insertQualifiedMortgage(Document document, Element element, QualifiedMortgageModel qualifiedMortgage) {
		if(!"".equals(qualifiedMortgage.getAbilityToRepayExemptionReasonType()))
			insertExemption(document, insertLevels(document, element, "EXEMPTIONS/EXEMPTION"), qualifiedMortgage.getAbilityToRepayExemptionReasonType());
		if(!"".equals(qualifiedMortgage.getAbilityToRepayMethodType()))
			insertQualifiedMortgageDetail(document, insertLevels(document, element, "QUALIFIED_MORTGAGE_DETAIL"), qualifiedMortgage.getAbilityToRepayMethodType());
	}
	/**
	 * Inserts Qualified Mortgage Detail to MISMO XML
	 * @param document Output XML file
	 * @param insertLevels
	 * @param jsonDocument Input JSON Object
	 */
	private void insertQualifiedMortgageDetail(Document document, Element element,
			String abilityToRepayMethodType) {
		insertData(document, element, "AbilityToRepayMethodType", abilityToRepayMethodType);
	}
	/**
	 * Inserts Exemption to MISMO XML
	 * @param document Output XML file
	 * @param insertLevels
	 * @param jsonDocument Input JSON Object
	 */
	private void insertExemption(Document document, Element element, String abilityToRepayMethodType) {
		insertData(document, element, "AbilityToRepayExemptionReasonType", abilityToRepayMethodType);
	}
	/**
	 * inserts Qualification from JSON Object
	 * @param document Output XML file
	 * @param element parent node of XML
	 * @param jsonDocument Input JSON Object
	 *//*
	private void insertQualification(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "TotalMonthlyIncomeAmount", "");
		insertData(document, element, "IncomeConsideredInDecisionIndicator", "");
		insertData(document, element, "CreditScoreConsideredInDecisionIndicator", "");
		insertData(document, element, "TotalDebtExpenseRatioPercent", "");
		insertData(document, element, "TotalDebtExpenseRatioConsideredInDecisionIndicator", "");
		insertData(document, element, "CombinedLTVRatioConsideredInDecisionIndicator", "");
	}
	*//**
     * Inserts Prepayment Penalty to MISMO Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertPrepaymentPenalty(Document document, Element element, LoanTermsPrepaymentPenalty prepaymentPenalty ) {
		insertPrepaymentPenaltyLifetimeRule(document, insertLevels(document, element, "PREPAYMENT_PENALTY_LIFETIME_RULE"), prepaymentPenalty);
	}
	/**
     * Inserts Prepayment Penalty Lifetime Rule to MISMO Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertPrepaymentPenaltyLifetimeRule(Document document, Element element,
			LoanTermsPrepaymentPenalty prepaymentPenalty) {
		//insertData(document, element, "PrepaymentPenaltyExpirationDate", prepaymentPenalty.get);
		insertData(document, element, "PrepaymentPenaltyExpirationMonthsCount", prepaymentPenalty.getPrepaymentPenaltyExpirationMonthsCount());
		insertData(document, element, "PrepaymentPenaltyMaximumLifeOfLoanAmount", prepaymentPenalty.getPrepaymentPenaltyMaximumLifeOfLoanAmount());
	}
	/**
     * Inserts Payment to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertPayment(Document document, Element element, PaymentModel payment) {
		insertPartialPayments(document, insertLevels(document, element, "PARTIAL_PAYMENTS"), payment.getPartialPayments()); 
		insertPaymentRule(document, insertLevels(document, element, "PAYMENT_RULE"), payment.getPaymentRule());
	}
	/**
     * Inserts Payment Rule to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertPaymentRule(Document document, Element element, PaymentRuleModel paymentRule) {
		insertData(document, element, "FullyIndexedInitialPrincipalAndInterestPaymentAmount", paymentRule.getFullyIndexedInitialPrincipalAndInterestPaymentAmount());
		insertData(document, element, "InitialPrincipalAndInterestPaymentAmount", paymentRule.getInitialPrincipalAndInterestPaymentAmount());
		//insertData(document, element, "PartialPaymentAllowedIndicator", paymentRule.get);
		insertData(document, element, "PaymentFrequencyType", paymentRule.getPaymentFrequencyType());
		//insertData(document, element, "PaymentOptionIndicator", paymentRule.get);
		insertData(document, element, "SeasonalPaymentPeriodEndMonth", paymentRule.getSeasonalPaymentPeriodEndMonth());
		insertData(document, element, "SeasonalPaymentPeriodStartMonth", paymentRule.getSeasonalPaymentPeriodStartMonth());
		OtherModel other = new OtherModel();
			other.setTotalOptionalPaymentCount(paymentRule.getTotalOptionalPaymentCount());
			other.setTotalStepPaymentCount(paymentRule.getTotalStepPaymentCount());
		insertExtension(document, insertLevels(document, element, "EXTENSION"), other);
	}
	/**
     * Inserts Partial Payments to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertPartialPayments(Document document, Element element,
			PartialPaymentsModel partialPayments) {
		for (PartialPaymentModel partialPayment : partialPayments.getPartialPaymentModels())
			insertPartialPayment(document, insertLevels(document, element, "PARTIAL_PAYMENT"), partialPayment);
	}
	/**
     * Inserts Partial Payments to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertPartialPayment(Document document, Element element, PartialPaymentModel partialPayment) {
		insertData(document, element, "PartialPaymentApplicationMethodType", partialPayment.getPartialPaymentApplicationMethodType());
		insertData(document, element, "PartialPaymentApplicationMethodTypeOtherDescription", partialPayment.getPartialPaymentApplicationMethodTypeOtherDescription());
	}
	/**
     * Inserts Negative Amortization to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertNegativeAmortization(Document document, Element element, NegativeAmortizationModel negativeAmortization) {
		insertNegativeAmortizationRule(document, insertLevels(document, element, "NEGATIVE_AMORTIZATION_RULE"), negativeAmortization);
	}
	/**
     * Inserts Negative Amortization Rule to MISMO XML 
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertNegativeAmortizationRule(Document document, Element element,
			NegativeAmortizationModel negativeAmortization) {
		//insertData(document, element, "LoanNegativeAmortizationResolutionType", "");
		//insertData(document, element, "LoanNegativeAmortizationResolutionTypeOtherDescription", "");
		insertData(document, element, "NegativeAmortizationLimitMonthsCount", negativeAmortization.getNegativeAmortizationLimitMonthsCount());
		insertData(document, element, "NegativeAmortizationMaximumLoanBalanceAmount", negativeAmortization.getNegativeAmortizationMaximumLoanBalanceAmount());
		insertData(document, element, "NegativeAmortizationType", negativeAmortization.getNegativeAmortizationType());
	}
	/**
     * Inserts MI Data Detail to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertMIDataDetail(Document document, Element element, MIDataDetailModel miDataDetail) {
		insertData(document, element, "MICertificateIdentifier", miDataDetail.getMiCertificateIdentifier());
		insertData(document, element, "MICompanyNameType", miDataDetail.getMiCompanyNameType());
		insertData(document, element, "MICompanyNameTypeOtherDescription",  miDataDetail.getMiCompanyNameTypeOtherDescription());
		insertData(document, element, "MIScheduledTerminationDate",  miDataDetail.getMiScheduledTerminationDate());
	}
	/**
     * Inserts Loan Product to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertLoanProduct(Document document, Element element, LoanProductModel loanProduct) {
		insertLoanPriceQuotes(document, insertLevels(document, element, "LOAN_PRICE_QUOTES"), loanProduct);
		//insertLocks(document, insertLevels(document, element, "LOCKS"), jsonDocument);
	}
	/**
     * Inserts Locks from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertLocks(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
			insertLock(document, insertLevels(document, element, "LOCK"), jsonDocument);
	}
	*//**
     * Inserts Lock from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertLock(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "LockExpirationDatetime", "");
		insertData(document, element, "LockStatusType", "");
		insertExtension(document, insertLevels(document, element, "EXTENSION"), jsonDocument);
	}
	*//**
     * Inserts Loan Price Quotes to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertLoanPriceQuotes(Document document, Element element,
			LoanProductModel loanProduct) {
		//for (String group : groupings)
			insertLoanPriceQuote(document, insertLevels(document, element, "LOAN_PRICE_QUOTE"), loanProduct);
	}
	/**
     * Inserts Loan Price Quote to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertLoanPriceQuote(Document document, Element element, LoanProductModel loanProduct) {
		insertLoanPriceQuoteDetail(document, insertLevels(document, element, "LOAN_PRICE_QUOTE_DETAIL"), loanProduct);
	}
	/**
     * Inserts Loan Price Quote Detail to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertLoanPriceQuoteDetail(Document document, Element element,
			LoanProductModel loanProduct) {
		insertData(document, element, "LoanPriceQuoteInterestRatePercent", loanProduct.getLoanPriceQuoteInterestRatePercent());
	}
	/**
     * Inserts Loan Level Credit from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertLoanLevelCredit(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertLoanLevelCreditDetail(document, insertLevels(document, element, "LOAN_LEVEL_CREDIT_DETAIL"), jsonDocument);
	}
	*//**
     * Inserts Loan Level Credit Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertLoanLevelCreditDetail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "LoanLevelCreditScoreValue", "");
		insertData(document, element, "CreditScoreModelNameType", "");
		insertData(document, element, "CreditScoreModelNameTypeOtherDescription", "");
		insertData(document, element, "CreditScoreCategoryVersionType", "");
	}
	*//**
     * Inserts Loan Detail to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertLoanDetail(Document document, Element element, LoanDetailModel loanDetail) {
			
		//insertData(document, element, "AssumedIndicator",);
		insertData(document, element, "AssumabilityIndicator", Boolean.toString(loanDetail.isAssumabilityIndicator()));
		insertData(document, element, "BalloonIndicator", Boolean.toString(loanDetail.isBalloonIndicator()));
		insertData(document, element, "BalloonPaymentAmount",  loanDetail.getBalloonPaymentAmount());
		insertData(document, element, "BuydownTemporarySubsidyFundingIndicator",Boolean.toString(loanDetail.isBuydownTemporarySubsidyFundingIndicator()));
		insertData(document, element, "ConstructionLoanIndicator",Boolean.toString(loanDetail.isConstructionLoanIndicator()));
		insertData(document, element, "CreditorServicingOfLoanStatementType", loanDetail.getCreditorServicingOfLoanStatementType());
		insertData(document, element, "DemandFeatureIndicator",Boolean.toString(loanDetail.isDemandFeatureIndicator()));
		insertData(document, element, "EscrowAbsenceReasonType",  loanDetail.getEscrowAbsenceReasonType()); 
		insertData(document, element, "EscrowIndicator", Boolean.toString(loanDetail.isEscrowIndicator()));
		insertData(document, element, "InterestOnlyIndicator", Boolean.toString(loanDetail.isInterestOnlyIndicator()));
		insertData(document, element, "InterestRateIncreaseIndicator", Boolean.toString(loanDetail.isInterestRateIncreaseIndicator()));
		insertData(document, element, "LoanAmountIncreaseIndicator", Boolean.toString(loanDetail.isLoanAmountIncreaseIndicator()));
		//insertData(document, element, "LoanLevelCreditScoreValue", ); 
		insertData(document, element, "MIRequiredIndicator", Boolean.toString(loanDetail.isMiRequiredIndicator()));
		insertData(document, element, "NegativeAmortizationIndicator", Boolean.toString(loanDetail.isNegativeAmortizationIndicator()));
		insertData(document, element, "PaymentIncreaseIndicator",Boolean.toString(loanDetail.isPaymentIncreaseIndicator()));  
		insertData(document, element, "PrepaymentPenaltyIndicator",Boolean.toString(loanDetail.isPrepaymentPenaltyIndicator()));
		insertData(document, element, "SeasonalPaymentFeatureIndicator", Boolean.toString(loanDetail.isSeasonalPaymentFeatureIndicator()));
		insertData(document, element, "StepPaymentsFeatureDescription", loanDetail.getStepPaymentsFeatureDescription());
		insertData(document, element, "TotalSubordinateFinancingAmount", loanDetail.getTotalSubordinateFinancingAmount());
		OtherModel other = new OtherModel();
			other.setSubordinateFinancingIsNewIndicator(Boolean.toString(loanDetail.isSubordinateFinancingIsNewIndicator()).toLowerCase());
		insertExtension(document, insertLevels(document, element, "EXTENSION"), other);
	}
	/**
     * inserts Late Charge Rule to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertLateChargeRule(Document document, Element element, LateChargeRuleModel lateChargeRule) {
		insertData(document, element, "LateChargeAmount", lateChargeRule.getLateChargeAmount());
		insertData(document, element, "LateChargeGracePeriodDaysCount", lateChargeRule.getLateChargeGracePeriodDaysCount() );
		//insertData(document, element, "LateChargeMaximumAmount", "");
		//insertData(document, element, "LateChargeMinimumAmount", "");
		insertData(document, element, "LateChargeRatePercent", lateChargeRule.getLateChargeRatePercent());
		insertData(document, element, "LateChargeType",  lateChargeRule.getLateChargeType());
	}
	/**
	 * insert insterestOnly in MISMO XML
	 * @param document
	 * @param element
	 * @param interestOnly
	 */
	private void insertInterestOnly(Document document, Element element, InterestOnlyModel interestOnly) {
		insertData(document, element, "InterestOnlyTermMonthsCount", interestOnly.getInterestOnlyTermMonthsCount());
	}
	/**
     * Inserts Hmda Loan from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertHmdaLoan(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertHmdaLoanDenial(document, insertLevels(document, element, "HMDA_LOAN_DENIALS"), jsonDocument);
		insertHmdaLoanDetail(document, insertLevels(document, element, "HMDA_LOAN_DETAIL"), jsonDocument);
	}
	*//**
     * Inserts Hmda Loan Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertHmdaLoanDetail(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "HMDAPurposeOfLoanType", "");
		insertData(document, element, "HMDAPreapprovalType", "");
		insertData(document, element, "HMDADispositionType", "");
		insertData(document, element, "HMDADispositionDate", "");
		insertData(document, element, "HMDAReportingCRAExemptionIndicator", "");
		insertData(document, element, "HMDAReportingSmallPopulationIndicator", "");
		insertData(document, element, "HMDAPurchaserType", "");
		insertData(document, element, "HMDAPurchaserTypeOtherDescription", "");
		insertData(document, element, "HMDARateSpreadPercent", "");
		insertData(document, element, "HMDAHOEPALoanStatusIndicator", "");
		insertData(document, element, "HMDAMultipleCreditScoresUsedIndicator", "");
		insertData(document, element, "HMDAOtherNonAmortizingFeaturesIndicator", "");
		insertData(document, element, "HMDAManufacturedHomeLegalClassificationType", "");
		insertData(document, element, "HMDAApplicationSubmissionType", "");
		insertData(document, element, "HMDACoveredLoanInitiallyPayableToReportingInstitutionStatusType", "");
		insertData(document, element, "HMDABusinessPurposeIndicator", "");
	}
	*//**
     * Inserts Hmda Loan Denial from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertHmdaLoanDenial(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "HMDAReasonForDenialType", "");
		insertData(document, element, "HMDAReasonForDenialTypeOtherDescription", "");
	}
	*/
	/**
	 * Inserts HighCostMortgages to MISMO XML
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	private void insertHighCostMortgages(Document document, Element element, QualifiedMortgageModel qualifiedMortgage) {
		//for (String group : groupings)
			insertHighCostMortgage(document, insertLevels(document, element, "HIGH_COST_MORTGAGE"), qualifiedMortgage);
	}
	/**
     * Inserts High Cost Mortgage to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertHighCostMortgage(Document document, Element element,
			 QualifiedMortgageModel qualifiedMortgage) {
		insertData(document, element, "AveragePrimeOfferRatePercent", qualifiedMortgage.getAveragePrimeOfferRatePercent());
		insertData(document, element, "RegulationZExcludedBonaFideDiscountPointsIndicator", qualifiedMortgage.getRegulationZExcludedBonaFideDiscountPointsPercent() );
		insertData(document, element, "RegulationZTotalAffiliateFeesAmount", qualifiedMortgage.getRegulationZTotalAffiliateFeesAmount());
		insertData(document, element, "RegulationZTotalLoanAmount", qualifiedMortgage.getRegulationZTotalLoanAmount());
		insertData(document, element, "RegulationZTotalPointsAndFeesAmount", qualifiedMortgage.getRegulationZTotalPointsAndFeesAmount());
	}
	/**
     * Inserts Heloc from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertHeloc(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertHelocRule(document, insertLevels(document, element, "HELOC_RULE"), jsonDocument);
	}
	*//**
     * Inserts Heloc Rule from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertHelocRule(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "HELOCMaximumBalanceAmount", "");
	}
	*//**
     * Inserts Foreclosures to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertForeclosures(Document document, Element element, String deficiencyRightsPreservedIndicator) {
		//for (String group : groupings)
			insertForeclosure(document, insertLevels(document, element, "FORECLOSURE"), deficiencyRightsPreservedIndicator);
	}
	/**
     * inserts Foreclosure to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertForeclosure(Document document, Element element, String deficiencyRightsPreservedIndicator) {
		insertForeclosureDetail(document, insertLevels(document, element, "FORECLOSURE_DETAIL"), deficiencyRightsPreservedIndicator);
	}
	/**
     * inserts Foreclosure Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertForeclosureDetail(Document document, Element element,
			String deficiencyRightsPreservedIndicator) {
		insertData(document, element, "DeficiencyRightsPreservedIndicator", deficiencyRightsPreservedIndicator);
	}
	/**
	 * inserts fee information in MISMO XML
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	private void insertFeeInformation(Document document, Element element, ClosingDisclosure jsonDocument) {
		insertFees(document, insertLevels(document, element, "FEES"), jsonDocument);
		insertFeeSummaryDetail(document, insertLevels(document, element, "FEES_SUMMARY/FEE_SUMMARY_DETAIL"), jsonDocument.getLoanCalculationsQualifiedMortgage().getLoanCalculationModel());
	}
	
	/**
	 * inserts FeeSummaryDetail in MISMO XML
	 * @param document
	 * @param element
	 * @param loanCalculation
	 */
	private void insertFeeSummaryDetail(Document document, Element element,
			LoanCalculationModel loanCalculation) {
		insertData(document, element, "APRPercent", loanCalculation.getAprPercent());
		insertData(document, element, "FeeSummaryTotalAmountFinancedAmount", loanCalculation.getFeeSummaryTotalAmountFinancedAmount());
		insertData(document, element, "FeeSummaryTotalFinanceChargeAmount", loanCalculation.getFeeSummaryTotalFinanceChargeAmount());
		insertData(document, element, "FeeSummaryTotalInterestPercent", loanCalculation.getFeeSummaryTotalInterestPercent());
		insertData(document, element, "FeeSummaryTotalOfAllPaymentsAmount", loanCalculation.getFeeSummaryTotalOfAllPaymentsAmount());
	}
	
	/**
	 * inserts Fees in MISMO XML 
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	private void insertFees(Document document, Element element, ClosingDisclosure jsonDocument) {
		 
		if(jsonDocument.getClosingCostDetailsLoanCosts().getOriginationCharges().size() > 0)
			for (ClosingCostProperties closingCostProperties : jsonDocument.getClosingCostDetailsLoanCosts().getOriginationCharges())
				insertFee(document, insertLevels(document, element, "FEE"), closingCostProperties);
		if(jsonDocument.getClosingCostDetailsLoanCosts().getSbDidNotShopFors().size() > 0)
			for (ClosingCostProperties closingCostProperties : jsonDocument.getClosingCostDetailsLoanCosts().getSbDidNotShopFors())
				insertFee(document, insertLevels(document, element, "FEE"), closingCostProperties);
		if(jsonDocument.getClosingCostDetailsLoanCosts().getSbDidShopFors().size() > 0)
			for (ClosingCostProperties closingCostProperties : jsonDocument.getClosingCostDetailsLoanCosts().getSbDidShopFors())
				insertFee(document, insertLevels(document, element, "FEE"), closingCostProperties);
	}
	
	/**
	 * inserts Fee in MISMO XML
	 * @param document
	 * @param element
	 * @param closingCostProperties
	 */
	private void insertFee(Document document, Element element, ClosingCostProperties closingCostProperties) {
		insertFeeDetail(document,  insertLevels(document, element, "FEE_DETAIL"), closingCostProperties);
		if(!closingCostProperties.getFeePaidToFullName().isEmpty() && null != closingCostProperties.getFeePaidToFullName())
			insertFeePaidTo(document, 	insertLevels(document, element, "FEE_PAID_TO"), closingCostProperties.getFeePaidToFullName());
		PaymentsModel paymentsModel = new PaymentsModel();
			paymentsModel.setBpAtClosing(closingCostProperties.getBpAtClosing());
			paymentsModel.setBpB4Closing(closingCostProperties.getBpB4Closing());
			paymentsModel.setLenderStatus(closingCostProperties.isLenderStatus());
			paymentsModel.setPaidByOthers(closingCostProperties.getPaidByOthers());
			paymentsModel.setSpAtClosing(closingCostProperties.getSpAtClosing());
			paymentsModel.setSpB4Closing(closingCostProperties.getSpB4Closing());
		List<MismoPaymentsModel> mismoPaymentsModelList = Convertor.toMismoFeePayments(paymentsModel, "FEE");
		if(mismoPaymentsModelList.size() > 0)
			insertFeePayments(document, insertLevels(document, element, "FEE_PAYMENTS"), mismoPaymentsModelList);
	}
	
	/**
	 * inserts FeePayments in MISMO XML
	 * @param document
	 * @param element
	 * @param closingCostProperties
	 */
	private void insertFeePayments(Document document, Element element, List<MismoPaymentsModel> mismoPaymentsModelList) {
		for (MismoPaymentsModel mismoPaymentsModel : mismoPaymentsModelList)
			insertFeePayment(document,	insertLevels(document, element, "FEE_PAYMENT"), mismoPaymentsModel);
	}
	
	/**
	 * inserts FeePayment in MISMO XML
	 * @param document
	 * @param element
	 * @param closingCostProperties
	 */
	private void insertFeePayment(Document document, Element element, MismoPaymentsModel mismoPayment) {
		insertData(document, element, "FeeActualPaymentAmount", mismoPayment.getAmount());
		insertData(document, element, "FeePaymentPaidByType", mismoPayment.getPaidByType());
		insertData(document, element, "FeePaymentPaidOutsideOfClosingIndicator", mismoPayment.getClosingIndicator());
	}
	
	/**
	 * inserts FeePaidTo in MISMO XML
	 * @param document
	 * @param element
	 * @param closingCostProperties
	 */
	private void insertFeePaidTo(Document document, Element element, String fullName ) {
		insertLegalEntity(document,	insertLevels(document, element, "LEGAL_ENTITY"), fullName);
	}
	
	/**
	 * inserts FeeDetail in MISMO XML
	 * @param document
	 * @param element
	 * @param closingCostProperties
	 */
	private void insertFeeDetail(Document document, Element element,  ClosingCostProperties closingCostProperties) {
		
		OtherModel other = new OtherModel();
			other.setPaymentIncludedInAPRIndicator(Boolean.toString(closingCostProperties.isPaymentIncludedInAPRIndicator()));
		insertData(document, element, "BorrowerChosenProviderIndicator", "");
		insertData(document, element, "FeeActualTotalAmount", closingCostProperties.getFeeActualTotalAmount());
		insertData(document, element, "FeeEstimatedTotalAmount", "" );
		insertData(document, element, "FeePaidToType", closingCostProperties.getFeePaidToType());
		insertData(document, element, "FeePaidToTypeOtherDescription", closingCostProperties.getFeePaidToTypeOtherDescription());
		insertData(document, element, "FeePercentBasisType", closingCostProperties.getFeePercentBasisType());
		insertData(document, element, "FeeTotalPercent", closingCostProperties.getFeeTotalPercent());
		Element feeTypeElement = returnElement(document, element, "FeeType", closingCostProperties.getFeeType());
			if(!closingCostProperties.getGseDisplayLabel().isEmpty() && null != closingCostProperties.getGseDisplayLabel())
				feeTypeElement.setAttribute("gse:DisplayLabelText", closingCostProperties.getGseDisplayLabel());
		insertData(document, element, "FeeTypeOtherDescription", closingCostProperties.getFeeTypeOtherDescription());
		insertData(document, element, "IntegratedDisclosureSectionType", closingCostProperties.getIntegratedDisclosureSectionType());
		insertData(document, element, "OptionalCostIndicator", Boolean.toString(closingCostProperties.isOptionalCostIndicator()));
		insertData(document, element, "RegulationZPointsAndFeesIndicator", Boolean.toString(closingCostProperties.isRegulationZPointsAndFeesIndicator()).toLowerCase());
		insertData(document, element, "RequiredProviderOfServiceIndicator", "");
		
		insertExtension(document, insertLevels(document, element, "EXTENSION"), other);
	}
	
	/**
	 * inserts Escrow in MISMO XML
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	private void insertEscrow(Document document, Element element, ClosingDisclosure jsonDocument) {
		if(!"".equals(jsonDocument.getClosingDisclosureDocDetails().getEscrowAggregateAccountingAdjustmentAmount()))
			insertEscrowDetail(document, insertLevels(document, element, "ESCROW_DETAIL"), jsonDocument.getClosingDisclosureDocDetails().getEscrowAggregateAccountingAdjustmentAmount());
		if(jsonDocument.getClosingCostDetailsOtherCosts().getEscrowItemsList().size() > 0)
			insertEscrowItems(document, insertLevels(document, element, "ESCROW_ITEMS"), jsonDocument.getClosingCostDetailsOtherCosts().getEscrowItemsList());
	}
	
	/**
	 * inserts EscrowItems in MISMO XML
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	private void insertEscrowItems(Document document, Element element, List<EscrowItemModel> escrowItemList) {
		for (EscrowItemModel escrowItem : escrowItemList)
			insertEscrowItem(document, insertLevels(document, element, "ESCROW_ITEM"), escrowItem);
	}
	/**
     * Inserts Escrow Item to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertEscrowItem(Document document, Element element, EscrowItemModel escrowItem) {
		insertEscrowItemDetail(document, insertLevels(document, element, "ESCROW_ITEM_DETAIL"), escrowItem);
		PaymentsModel paymentsModel = new PaymentsModel();
			paymentsModel.setBpAtClosing(escrowItem.getBpAtClosing());
			paymentsModel.setBpB4Closing(escrowItem.getBpB4Closing());
			paymentsModel.setSpAtClosing(escrowItem.getSpAtClosing());
			paymentsModel.setSpB4Closing(escrowItem.getSpB4Closing());
			paymentsModel.setLenderStatus(escrowItem.isLenderStatus());
			paymentsModel.setPaidByOthers(escrowItem.getPaidByOthers());
		List<MismoPaymentsModel> mismoPaymentsList = Convertor.toMismoFeePayments(paymentsModel, "ESCROW");
		if(mismoPaymentsList.size() > 0)
			insertEscrowItemPayments(document,  insertLevels(document, element, "ESCROW_ITEM_PAYMENTS"), mismoPaymentsList);
	}
	/**
     * Inserts Escrow Item Payments to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertEscrowItemPayments(Document document, Element element,
			List<MismoPaymentsModel> mismoPaymentsList) {
		for (MismoPaymentsModel mismoPayment : mismoPaymentsList)
			insertEscrowItemPayment(document, insertLevels(document, element, "ESCROW_ITEM_PAYMENT"), mismoPayment);
	}
	/**
     * Inserts Escrow Item Payment to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertEscrowItemPayment(Document document, Element element,
			MismoPaymentsModel mismoPayment) {
		insertData(document, element, "EscrowItemActualPaymentAmount",mismoPayment.getAmount());
		insertData(document, element, "EscrowItemPaymentPaidByType", mismoPayment.getPaidByType());
		insertData(document, element, "EscrowItemPaymentTimingType", mismoPayment.getClosingIndicator());
	}
	/**
     * Inserts Escrow Item Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertEscrowItemDetail(Document document, Element element,
			EscrowItemModel escrowItem) {
		insertData(document, element, "EscrowCollectedNumberOfMonthsCount", escrowItem.getEscrowCollectedNumberOfMonthsCount());
		insertData(document, element, "EscrowItemCategoryType","");
		insertData(document, element, "EscrowItemEstimatedTotalAmount","");
		Element itemType = returnElement(document, element, "EscrowItemType", escrowItem.getEscrowItemType());
			if(!escrowItem.getDisplayLabel().isEmpty() && null != escrowItem.getDisplayLabel())
				itemType.setAttribute("gse:DisplayLabelText",  escrowItem.getDisplayLabel());
		insertData(document, element, "EscrowItemTypeOtherDescription", escrowItem.getEscrowItemTypeOtherDescription());
		insertData(document, element, "EscrowMonthlyPaymentAmount", escrowItem.getEscrowMonthlyPaymentAmount());
		insertData(document, element, "FeePaidToType", escrowItem.getFeePaidToType());
		insertData(document, element, "FeePaidToTypeOtherDescription", escrowItem.getFeePaidToTypeOtherDescription());
		insertData(document, element, "IntegratedDisclosureSectionType", escrowItem.getIntegratedDisclosureSectionType());
		insertData(document, element, "RegulationZPointsAndFeesIndicator", Boolean.toString(escrowItem.isRegulationZPointsAndFeesIndicator()));
		OtherModel other = new OtherModel();
			other.setPaymentIncludedInAPRIndicator(Boolean.toString(escrowItem.isPaymentIncludedInAPRIndicator()));
		insertExtension(document, insertLevels(document, element, "EXTENSION"), other);
	}
	
	/**
	 * inserts EscrowDetail in MISMO XML
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	private void insertEscrowDetail(Document document, Element element, String  escrowAggregateAccountingAdjustmentAmount) {
		insertData(document, element, "EscrowAggregateAccountingAdjustmentAmount", escrowAggregateAccountingAdjustmentAmount);
	}
	/**
     * Inserts Document Specific DataSet to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertDocumentSpecificDataSet(Document document, Element element, ClosingDisclosure jsonDocument) {
		// TODO Auto-generated method stub
		//insertExecution(document, insertLevels(document, element, "EXECUTION"), jsonDocument);
		insertIntegratedDisclosure(document, insertLevels(document, element, "INTEGRATED_DISCLOSURE"), jsonDocument);
		//insertURLA(document, insertLevels(document, element, "URLA"), jsonDocument);
	}
	/**
     * Inserts URLA from JSON Object (URLA : Uniform Residential Loan Application)
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertURLA(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertURLADetail(document, insertLevels(document, element, "URLA_DETAIL"), jsonDocument);
	}
	*//**
     * Inserts URLA Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertURLADetail(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "BorrowerRequestedLoanAmount", ""); //TODO Need to add the Object
	}
	*//**
     * Inserts Integrated Disclosure from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertIntegratedDisclosure(Document document, Element element,
			ClosingDisclosure jsonDocument) {
		insertCashToCloseItems(document, insertLevels(document, element, "CASH_TO_CLOSE_ITEMS"), jsonDocument.getCashToCloses());
		insertEstimatedPropertyCost(document, insertLevels(document, element, "ESTIMATED_PROPERTY_COST"), jsonDocument.getEtiaSection());
		insertIntegratedDisclosureDetail(document, insertLevels(document, element, "INTEGRATED_DISCLOSURE_DETAIL"), jsonDocument.getIntegratedDisclosureDetail());
		insertIntegratedDisclosureSectionSummaries(document, insertLevels(document, element, "INTEGRATED_DISCLOSURE_SECTION_SUMMARIES"), jsonDocument);
		insertProjectedPayments(document, insertLevels(document, element, "PROJECTED_PAYMENTS"), jsonDocument.getProjectedPayments());
	}
	/**
     * Inserts Projected Payments to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertProjectedPayments(Document document, Element element,
			ProjectedPaymentsDetails projectedPaymentsDetails) {
		List<MismoProjectedPaymentsModel> mismoProjectedPaymentsModels = Convertor.createMismoProjectedPayments(projectedPaymentsDetails);
		for (MismoProjectedPaymentsModel projectedPayment : mismoProjectedPaymentsModels)
			insertProjectedPayment(document, insertLevels(document, element, "PROJECTED_PAYMENT"), projectedPayment);
	}
	/**
     * Inserts Projected Payment to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertProjectedPayment(Document document, Element element,
			MismoProjectedPaymentsModel projectedPayment) {
		//insertAttributeValue(xmlout, parentElement, "SequenceNumber", "");
		
		element.setAttribute("SequenceNumber", projectedPayment.getSequenceNumber() );
		insertData(document, element, "PaymentFrequencyType", projectedPayment.getPaymentFrequencyType());
		insertData(document, element, "ProjectedPaymentCalculationPeriodEndNumber", projectedPayment.getProjectedPaymentCalculationPeriodEndNumber());
		insertData(document, element, "ProjectedPaymentCalculationPeriodStartNumber", projectedPayment.getProjectedPaymentCalculationPeriodStartNumber());
		insertData(document, element, "ProjectedPaymentCalculationPeriodTermType",  projectedPayment.getProjectedPaymentCalculationPeriodTermType());
		insertData(document, element, "ProjectedPaymentCalculationPeriodTermTypeOtherDescription", projectedPayment.getProjectedPaymentCalculationPeriodTermTypeOtherDescription());
		insertData(document, element, "ProjectedPaymentEstimatedEscrowPaymentAmount", projectedPayment.getProjectedPaymentEstimatedEscrowPaymentAmount());
		insertData(document, element, "ProjectedPaymentEstimatedTotalMaximumPaymentAmount", projectedPayment.getProjectedPaymentEstimatedTotalMaximumPaymentAmount());
		insertData(document, element, "ProjectedPaymentEstimatedTotalMinimumPaymentAmount",  projectedPayment.getProjectedPaymentEstimatedTotalMinimumPaymentAmount());
		insertData(document, element, "ProjectedPaymentMIPaymentAmount", projectedPayment.getProjectedPaymentMIPaymentAmount());
		insertData(document, element, "ProjectedPaymentPrincipalAndInterestMaximumPaymentAmount", projectedPayment.getProjectedPaymentPrincipalAndInterestMaximumPaymentAmount());
		insertData(document, element, "ProjectedPaymentPrincipalAndInterestMinimumPaymentAmount", projectedPayment.getProjectedPaymentEstimatedTotalMinimumPaymentAmount());
	}
	/**
     * Inserts Integrated Disclosure Section Summaries to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertIntegratedDisclosureSectionSummaries(Document document, Element element,
			ClosingDisclosure jsonDocument) {
		for (IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummary : Convertor.createIntegratedDisclosureSectionSummaryModel(jsonDocument)) //TODO Not Implemented
			insertIntegratedDisclosureSectionSummary(document, insertLevels(document, element, "INTEGRATED_DISCLOSURE_SECTION_SUMMARY"), integratedDisclosureSectionSummary);
	}
	/**
     * Inserts Integrated Disclosure Section Summary to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertIntegratedDisclosureSectionSummary(Document document, Element element,
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummary) {
		insertIntegratedDisclosureSectionSummaryDetail(document, insertLevels(document, element, "INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL"), integratedDisclosureSectionSummary.getIntegratedDisclosureSectionSummaryDetailModel());
		if(null != integratedDisclosureSectionSummary.getIntegratedDisclosureSubsectionPayments())
			insertIntegratedDisclosureSubsectionPayments(document, insertLevels(document, element, "INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENTS"), integratedDisclosureSectionSummary.getIntegratedDisclosureSubsectionPayments());
	}
	/**
     * Inserts Integrated Disclosure Subsection Payments to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertIntegratedDisclosureSubsectionPayments(Document document, Element element,
			List<IntegratedDisclosureSubsectionPaymentModel> integratedDisclosureSubsectionPaymentModels ) {
		// TODO Auto-generated method stub
		for (IntegratedDisclosureSubsectionPaymentModel integratedDisclosureSubsectionPayment : integratedDisclosureSubsectionPaymentModels)
			insertIntegratedDisclosureSubsectionPayment(document, insertLevels(document, element, "INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENT"), integratedDisclosureSubsectionPayment);
	}
	/**
     * Inserts Integrated Disclosure Subsection Payment to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertIntegratedDisclosureSubsectionPayment(Document document, Element element,
			IntegratedDisclosureSubsectionPaymentModel integratedDisclosureSubsectionPayment) {
		insertData(document, element, "IntegratedDisclosureSubsectionPaidByType", integratedDisclosureSubsectionPayment.getIntegratedDisclosureSubsectionPaidByType());
		insertData(document, element, "IntegratedDisclosureSubsectionPaymentAmount", integratedDisclosureSubsectionPayment.getIntegratedDisclosureSubsectionPaymentAmount());
		insertData(document, element, "IntegratedDisclosureSubsectionPaymentTimingType", integratedDisclosureSubsectionPayment.getIntegratedDisclosureSubsectionPaymentTimingType());
	}
	/**
     * Inserts Integrated Disclosure Section Summary Detail to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertIntegratedDisclosureSectionSummaryDetail(Document document, Element element,
			IntegratedDisclosureSectionSummaryDetailModel integratedDisclosureSectionSummaryDetail) {
		insertData(document, element, "IntegratedDisclosureSectionTotalAmount", integratedDisclosureSectionSummaryDetail.getIntegratedDisclosureSectionTotalAmount());
		insertData(document, element, "IntegratedDisclosureSectionType", integratedDisclosureSectionSummaryDetail.getIntegratedDisclosureSectionType());
		insertData(document, element, "IntegratedDisclosureSubsectionTotalAmount", integratedDisclosureSectionSummaryDetail.getIntegratedDisclosureSubsectionTotalAmount());
		insertData(document, element, "IntegratedDisclosureSubsectionType", integratedDisclosureSectionSummaryDetail.getIntegratedDisclosureSubsectionType());
		insertData(document, element, "IntegratedDisclosureSubsectionTypeOtherDescription", integratedDisclosureSectionSummaryDetail.getIntegratedDisclosureSubsectionTypeOtherDescription());
		insertData(document, element, "LenderCreditToleranceCureAmount", integratedDisclosureSectionSummaryDetail.getLenderCreditToleranceCureAmount());
	}
	/**
     * Inserts Estimated Property Cost to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertEstimatedPropertyCost(Document document, Element element,
			ETIASection propertyCost) {
		insertEstimatedPropertyCostComponents(document, insertLevels(document, element, "ESTIMATED_PROPERTY_COST_COMPONENTS"), propertyCost.getEtiaValues());
		if(!"".equals(propertyCost.getProjectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount()) && null != propertyCost.getProjectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount())
			insertEstimatedPropertyCostDetail(document, insertLevels(document, element, "ESTIMATED_PROPERTY_COST_DETAIL"), propertyCost.getProjectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount());
	}
	/**
     * Inserts Estimated Property Cost Detail to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertEstimatedPropertyCostDetail(Document document, Element element,
			String projectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount) {
		insertData(document, element, "ProjectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount", projectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount);
	}
	/**
     * Inserts Estimated Property Cost Components to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertEstimatedPropertyCostComponents(Document document, Element element,
			List<ETIA> etiaValues) {
		//element.setAttribute("gse:DisplayLabelText", estimatedPropertyCostComponents.getgseDispalyLabelText()); //TODO Data Not found for this field
		for (ETIA ETIA : etiaValues)
			insertEstimatedPropertyCostComponent(document, insertLevels(document, element, "ESTIMATED_PROPERTY_COST_COMPONENT"), ETIA);
	}
	/**
     * Inserts Estimated Property Cost Component to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertEstimatedPropertyCostComponent(Document document, Element element,
			ETIA eTIA) {
		insertData(document, element, "ProjectedPaymentEscrowedType", eTIA.getProjectedPaymentEscrowedType());
		insertData(document, element, 
				"ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType", eTIA.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType());
		insertData(document, element,
				"ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription", eTIA.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription());
	
	}
	/**
     * Inserts Cash To Close Items to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertCashToCloseItems(Document document, Element element,
			CashToClose cashToClose) {
		insertCashToCloseItem(document,	insertLevels(document, element, "CASH_TO_CLOSE_ITEM"), cashToClose.getAdjustmentsAndOtherCredits());
		insertCashToCloseItem(document,	insertLevels(document, element, "CASH_TO_CLOSE_ITEM"), cashToClose.getClosingCostsFinanced());
		insertCashToCloseItem(document,	insertLevels(document, element, "CASH_TO_CLOSE_ITEM"), cashToClose.getClosingCostsPaidBeforeClosing());
		insertCashToCloseItem(document,	insertLevels(document, element, "CASH_TO_CLOSE_ITEM"), cashToClose.getDeposit());
		insertCashToCloseItem(document,	insertLevels(document, element, "CASH_TO_CLOSE_ITEM"), cashToClose.getDownPayment());
		insertCashToCloseItem(document,	insertLevels(document, element, "CASH_TO_CLOSE_ITEM"), cashToClose.getFundsForBorrower());
		insertCashToCloseItem(document,	insertLevels(document, element, "CASH_TO_CLOSE_ITEM"), cashToClose.getLoanAmount());
		insertCashToCloseItem(document,	insertLevels(document, element, "CASH_TO_CLOSE_ITEM"), cashToClose.getSellerCredits());
		insertCashToCloseItem(document,	insertLevels(document, element, "CASH_TO_CLOSE_ITEM"), cashToClose.getTotalClosingCosts());
		insertCashToCloseItem(document,	insertLevels(document, element, "CASH_TO_CLOSE_ITEM"), cashToClose.getTotalPayoffsAndPayments());
		
		if(cashToClose.getCashToCloseTotal().size() > 0)
			for(CashToCloseModel cashToCloseModel : cashToClose.getCashToCloseTotal())
				insertCashToCloseItem(document,	insertLevels(document, element, "CASH_TO_CLOSE_ITEM"), cashToCloseModel);
	}
	/**
     * Inserts Cash To Close Item to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertCashToCloseItem(Document document, Element element,
			CashToCloseModel cashToClose) {
			insertData(document, element, "IntegratedDisclosureCashToCloseItemAmountChangedIndicator",Boolean.toString(cashToClose.isIntegratedDisclosureCashToCloseItemAmountChangedIndicator()));
			insertData(document, element, "IntegratedDisclosureCashToCloseItemChangeDescription", cashToClose.getIntegratedDisclosureCashToCloseItemChangeDescription());
			insertData(document, element, "IntegratedDisclosureCashToCloseItemEstimatedAmount", cashToClose.getIntegratedDisclosureCashToCloseItemEstimatedAmount());
			insertData(document, element, "IntegratedDisclosureCashToCloseItemFinalAmount", cashToClose.getIntegratedDisclosureCashToCloseItemFinalAmount());
			insertData(document, element, "IntegratedDisclosureCashToCloseItemPaymentType", cashToClose.getIntegratedDisclosureCashToCloseItemPaymentType());
			insertData(document, element, "IntegratedDisclosureCashToCloseItemType",  cashToClose.getIntegratedDisclosureCashToCloseItemType());
	}
	/**
     * Inserts Execution from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertExecution(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertExecutionDetail(document,	insertLevels(document, element, "EXECUTION_DETAIL"), jsonDocument);
	}
	*//**
     * Inserts Execution Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertExecutionDetail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "ActualSignatureType", "");
		insertData(document, element, "ActualSignatureTypeOtherDescription", "");
		insertData(document, element, "ExecutionDate", "");
		insertData(document, element, "ExecutionDatetime", "");
		//TODO Need To Add the Object
	}
	*/
	
	/**
	 * inserts construction to MISMO XML 
	 * @param document
	 * @param element
	 * @param construction
	 */
	private void insertConstruction(Document document, Element element, ConstructionModel construction) {
		insertData(document, element, "ConstructionLoanTotalTermMonthsCount", construction.getConstructionLoanTotalTermMonthsCount());
		insertData(document, element, "ConstructionLoanType", construction.getConstructionLoanType());
		insertData(document, element, "ConstructionPeriodNumberOfMonthsCount", construction.getConstructionPeriodNumberOfMonthsCount());
	}
	
	/**
	 * inserts Buydown to MISMO XML
	 * @param document
	 * @param element
	 * @param temporaryBuydown
	 */
	private void insertBuydown(Document document, Element element, LoanTermsTemporaryBuydown temporaryBuydown) {
		insertBuydownOccurences(document ,insertLevels(document, element, "BUYDOWN_OCCURRENCES"), temporaryBuydown);
		insertBuydownRule(document ,insertLevels(document, element, "BUYDOWN_RULE"), temporaryBuydown);
	}
	
	/**
	 * inserts BuydownRule to MISMO XML
	 * @param document
	 * @param element
	 * @param temporaryBuydown
	 */
	private void insertBuydownRule(Document document, Element element, LoanTermsTemporaryBuydown temporaryBuydown) {
		OtherModel other = new OtherModel();
			other.setBuydownReflectedInNoteIndicator(Boolean.toString(temporaryBuydown.isGseBuydownReflectedInNoteIndicator()));
		insertData(document, element, "BuydownChangeFrequencyMonthsCount", temporaryBuydown.getBuydownChangeFrequencyMonthsCount());
		insertData(document, element, "BuydownDurationMonthsCount", temporaryBuydown.getBuydownDurationMonthsCount());
		insertData(document, element, "BuydownIncreaseRatePercent", temporaryBuydown.getBuydownIncreaseRatePercent());
		insertExtension(document, insertLevels(document, element, "EXTENSION"), other);
	}
	
	/**
	 * inserts BuydownOccurences to MISMO XML
	 * @param document
	 * @param element
	 * @param temporaryBuydown
	 */
	private void insertBuydownOccurences(Document document, Element element, LoanTermsTemporaryBuydown temporaryBuydown) {
		//for (BuyDownOccurance buyDownOccurance : buyDownOccurances)
			insertBuydownOccurence(document ,insertLevels(document, element, "BUYDOWN_OCCURRENCES"), temporaryBuydown);
	}
	
	/**
	 * inserts BuydownOccurence to MISMO XML
	 * @param document
	 * @param element
	 * @param temporaryBuydown
	 */
	private void insertBuydownOccurence(Document document, Element element, LoanTermsTemporaryBuydown temporaryBuydown) {
		insertData(document, element, "BuydownInitialEffectiveInterestRatePercent", temporaryBuydown.getBuydownInitialEffectiveInterestRatePercent());
	}
	
    /**
     * inserts closingInformation to MISMO XML 
     * @param document
     * @param element
     * @param jsonDocument
     */
	private void insertClosingInformation(Document document, Element element, ClosingDisclosure jsonDocument) {
		insertClosingAdjustmentItems(document ,insertLevels(document, element, "CLOSING_ADJUSTMENT_ITEMS"), jsonDocument.getClosingAdjustmentItemList());
		if(jsonDocument.getClosingCostFundList().size() > 0)
			insertClosingCostFunds(document ,insertLevels(document, element, "CLOSING_COST_FUNDS"), jsonDocument.getClosingCostFundList());
		insertClosingInformationDetail(document,insertLevels(document, element, "CLOSING_INFORMATION_DETAIL"), jsonDocument.getClosingInformationDetail());
		insertPrepaidItems(document ,insertLevels(document, element, "PREPAID_ITEMS"), jsonDocument.getClosingCostDetailsOtherCosts().getPrepaidsList());
		if(jsonDocument.getProrationsList().size() > 0)
			insertProrationItems(document ,insertLevels(document, element, "PRORATION_ITEMS"), jsonDocument.getProrationsList());
	}
	
	/**
	 * inserts prorationItems to MISMO XML
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	private void insertProrationItems(Document document, Element element, List<ProrationModel> prorationItems) {
		for (ProrationModel prorationItem : prorationItems)
			insertProrationItem(document, insertLevels(document, element, "PRORATION_ITEM"), prorationItem);
	}
	
	/**
	 * inserts prorationItem to MISMO XML
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	private void insertProrationItem(Document document, Element element, ProrationModel prorationItem) {
		insertData(document, element, "IntegratedDisclosureSectionType", prorationItem.getIntegratedDisclosureSectionType());
		insertData(document, element, "IntegratedDisclosureSubsectionType", prorationItem.getIntegratedDisclosureSubsectionType());
		insertData(document, element, "ProrationItemAmount", prorationItem.getProrationItemAmount());
		insertData(document, element, "ProrationItemPaidFromDate",  prorationItem.getProrationItemPaidFromDate());
		insertData(document, element, "ProrationItemPaidThroughDate",  prorationItem.getProrationItemPaidThroughDate());
		Element prorationItemTypeElement = returnElement(document, element, "ProrationItemType",  prorationItem.getProrationItemType());
			if(!prorationItem.getDisplayLabel().isEmpty() && null != prorationItem.getDisplayLabel())
				prorationItemTypeElement.setAttribute("gse:DisplayLabelText",  prorationItem.getDisplayLabel());
		insertData(document, element, "ProrationItemTypeOtherDescription", prorationItem.getProrationItemTypeOtherDescription());
	}
		
	/**
     * Inserts Prepaid Items to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertPrepaidItems(Document document, Element element, List<Prepaids> prepaidItems) {
		for (Prepaids prepaidItem : prepaidItems)
			insertPrepaidItem(document, insertLevels(document, element, "PREPAID_ITEM"), prepaidItem);
	}
	/**
     * Inserts Prepaid Item to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertPrepaidItem(Document document, Element element,
			Prepaids prepaidItem) {
		insertPrepaidItemDetail(document, insertLevels(document, element, "PREPAID_ITEM_DETAIL"), prepaidItem);
		if(!prepaidItem.getPrepaidPaidToFullName().isEmpty())
			insertPrepaidItemPaidTo(document, insertLevels(document, element, "PREPAID_ITEM_PAID_TO"), prepaidItem.getPrepaidPaidToFullName());
		insertPrepaidItemPayments(document, insertLevels(document, element, "PREPAID_ITEM_PAYMENTS"), prepaidItem);
	}
	/**
     * Inserts Prepaid Item Payments to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertPrepaidItemPayments(Document document, Element element,
			Prepaids prepaidItem) {
		PaymentsModel paymentsModel = new PaymentsModel();
			paymentsModel.setBpAtClosing(prepaidItem.getBpAtClosing());
			paymentsModel.setBpB4Closing(prepaidItem.getBpB4Closing());
			paymentsModel.setLenderStatus(prepaidItem.isLenderStatus());
			paymentsModel.setPaidByOthers(prepaidItem.getPaidByOthers());
			paymentsModel.setSpAtClosing(prepaidItem.getSpAtClosing());
			paymentsModel.setSpB4Closing(prepaidItem.getSpB4Closing());
		
		List<MismoPaymentsModel> mismoFeePaymentsModels = Convertor.toMismoFeePayments(paymentsModel, "PREPAID");
		
		for (MismoPaymentsModel prepaidItemPayment : mismoFeePaymentsModels)
			insertPrepaidItemPayment(document, insertLevels(document, element, "PREPAID_ITEM_PAYMENT"), prepaidItemPayment);
	}
	/**
     * Inserts Prepaid Item Payment to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertPrepaidItemPayment(Document document, Element element,
			MismoPaymentsModel prepaidItemPayment) {
		insertData(document, element, "PrepaidItemActualPaymentAmount", prepaidItemPayment.getAmount());
		insertData(document, element, "PrepaidItemPaymentPaidByType", prepaidItemPayment.getPaidByType());
		insertData(document, element, "PrepaidItemPaymentTimingType", prepaidItemPayment.getClosingIndicator());
		//insertData(document, element, "RegulationZPointsAndFeesIndicator", "");
	}
	/**
     * Inserts Prepaid Item Paid To to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertPrepaidItemPaidTo(Document document, Element element,
			String fullName) {
		insertLegalEntity(document, insertLevels(document, element, "LEGAL_ENTITY"), fullName);
	}
	/**
     * Inserts Prepaid Item Detail to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertPrepaidItemDetail(Document document, Element element,
			Prepaids prepaidItem) {
		insertData(document, element, "FeePaidToType", prepaidItem.getFeePaidToType());
		insertData(document, element, "FeePaidToTypeOtherDescription", prepaidItem.getFeePaidToTypeOtherDescription());
		insertData(document, element, "IntegratedDisclosureSectionType", prepaidItem.getIntegratedDisclosureSectionType());
		//insertData(document, element, "PrepaidItemEstimatedTotalAmount", prepaidItem.getPre); 
		insertData(document, element, "PrepaidItemMonthsPaidCount", prepaidItem.getPrepaidItemMonthsPaidCount());
		//insertData(document, element, "PrepaidItemNumberOfDaysCount", prepaidItem.getprep);// TODO Value Not binded with object 
		insertData(document, element, "PrepaidItemPaidFromDate", prepaidItem.getPrepaidItemPaidFromDate());
		insertData(document, element, "PrepaidItemPaidThroughDate", prepaidItem.getPrepaidItemPaidThroughDate());
		insertData(document, element, "PrepaidItemPerDiemAmount", prepaidItem.getPrepaidItemPerDiemAmount());
		insertData(document, element, "PrepaidItemPerDiemCalculationMethodType", prepaidItem.getPrepaidItemPerDiemCalculationMethodType());
		Element prepaidItemTypeElement = returnElement(document, element, "PrepaidItemType", prepaidItem.getPrepaidItemType());
			if(!prepaidItem.getDisplayLabel().isEmpty() && null != prepaidItem.getDisplayLabel())
				prepaidItemTypeElement.setAttribute("gse:DisplayLabelText", prepaidItem.getDisplayLabel());
		insertData(document, element, "PrepaidItemTypeOtherDescription", prepaidItem.getPrepaidItemTypeOtherDescription());
		insertData(document, element, "RegulationZPointsAndFeesIndicator", Boolean.toString(prepaidItem.isRegulationZPointsAndFeesIndicator()));
		OtherModel other = new OtherModel();
		other.setPaymentIncludedInAPRIndicator(Boolean.toString(prepaidItem.isPaymentIncludedInAPRIndicator()));
		insertExtension(document,insertLevels(document, element, "EXTENSION"), other);
	}
	/**
	 * inserts ClosingCostFunds in MISMO XML 
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	private void insertClosingCostFunds(Document document, Element element,
			List<ClosingCostFundModel> closingCostFundList) {
		for (ClosingCostFundModel closingCostFund : closingCostFundList)
			insertClosingCostFund(document ,insertLevels(document, element, "CLOSING_COST_FUND"), closingCostFund);
	}
	
	/**
	 * inserts ClosingCostFund in MISMO XML
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	private void insertClosingCostFund(Document document, Element element,
			ClosingCostFundModel closingCostFund) {
		insertData(document, element, "ClosingCostFundAmount", closingCostFund.getClosingCostFundAmount());
		insertData(document, element, "FundsType", closingCostFund.getFundsType());
		insertData(document, element, "IntegratedDisclosureSectionType", closingCostFund.getIntegratedDisclosureSectionType());
	}
	/**
     * Inserts Closing Adjustment Items to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertClosingAdjustmentItems(Document document, Element element, List<ClosingAdjustmentItemModel> closingAdjustmentItemList) {
		for (ClosingAdjustmentItemModel closingAdjustmentItem : closingAdjustmentItemList)
			insertClosingAdjustmentItem(document, insertLevels(document, element, "CLOSING_ADJUSTMENT_ITEM"), closingAdjustmentItem);
	}
	/**
     * Inserts Closing Adjustment Item to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertClosingAdjustmentItem(Document document, Element element, ClosingAdjustmentItemModel closingAdjustmentItem) {
		insertClosingAdjustmentItemDetail(document,insertLevels(document, element, "CLOSING_ADJUSTMENT_ITEM_DETAIL"), closingAdjustmentItem);
		insertClosingAdjustmentItemPaidBy(document,insertLevels(document, element, "CLOSING_ADJUSTMENT_ITEM_PAID_BY"), closingAdjustmentItem);
		if(!"".equalsIgnoreCase(closingAdjustmentItem.getPaidToEntityFullName()))
			insertLegalEntityDetail(document,insertLevels(document, element, "EXTENSION/OTHER/gse:CLOSING_ADJUSTMENT_ITEM_PAID_TO/LEGAL_ENTITY/LEGAL_ENTITY_DETAIL/"), closingAdjustmentItem.getPaidToEntityFullName());
	
	}
	/**
     * Inserts Closing Adjustment Item Paid By to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertClosingAdjustmentItemPaidBy(Document document, Element element,
			 ClosingAdjustmentItemModel closingAdjustmentItem) {
		if(!"".equals(closingAdjustmentItem.getPaidByEntityFullName()))
		  insertLegalEntity(document,insertLevels(document, element, "LEGAL_ENTITY"), closingAdjustmentItem.getPaidByEntityFullName());
		if(!"".equals(closingAdjustmentItem.getPaidByIndividualFullName()))
		{
			MismoIndividualModel individual = new MismoIndividualModel();
			NameModel name = new NameModel();
				name.setFullName(closingAdjustmentItem.getPaidByIndividualFullName());
				individual.setName(name);
			insertIndividual(document,insertLevels(document, element, "INDIVIDUAL"), individual);
		}
	}
	/**
     * Inserts Individual from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertIndividual(Document document, Element element, MismoIndividualModel individual) {
		if(!individual.getContactPoints().isEmpty())
			insertContactPoints(document,insertLevels(document, element, "CONTACT_POINTS"), individual.getContactPoints());
		insertName(document,insertLevels(document, element, "NAME"), individual.getName());
	}
	/**
     * Inserts Name from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertName(Document document, Element element, NameModel name) {
		insertData(document, element, "FirstName", name.getFirstName());
		insertData(document, element, "FullName", name.getFullName());
		insertData(document, element, "LastName", name.getLastName());
		insertData(document, element, "MiddleName",name.getLastName());
		insertData(document, element, "SuffixName", name.getSuffixName());
	}
	/**
     * Inserts Contact Points to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertContactPoints(Document document, Element element, List<MismoContactPointsModel> contactPoints) {
		for (MismoContactPointsModel contactPoint : contactPoints)
			insertContactPoint(document, insertLevels(document, element, "CONTACT_POINT"), contactPoint);
	
	}
	/**
     * Inserts Contact Point to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertContactPoint(Document document, Element element, MismoContactPointsModel contactPoint) {
		if(!contactPoint.getEmail().isEmpty())
			insertContactPointEmail(document, insertLevels(document, element, "CONTACT_POINT_EMAIL"), contactPoint.getEmail());
		if(!contactPoint.getPhone().isEmpty())
			insertContactPointTelephone(document, insertLevels(document, element, "CONTACT_POINT_TELEPHONE"), contactPoint.getPhone());
	}
	/**
     * Inserts Contact Point Telephone to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertContactPointTelephone(Document document, Element element,
			String phone) {
		insertData(document, element, "ContactPointTelephoneValue", phone);
	}
	/**
     * Inserts Contact Point Email to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertContactPointEmail(Document document, Element element,
			String email) {
		insertData(document, element, "ContactPointEmailValue", email);
	}
	/**
     * Inserts Legal Entity to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertLegalEntity(Document document, Element element, String fullName) {
		insertLegalEntityDetail(document,insertLevels(document, element, "LEGAL_ENTITY_DETAIL"), fullName);
	}
	/**
     * Inserts Legal Entity Detail to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertLegalEntityDetail(Document document, Element element,
			String fullName) {
		insertData(document, element, "FullName", fullName);
		//insertData(document, element, "GlobalLegalEntityIdentifier", "");
	}
	/**
     * Inserts Closing Adjustment Item Detail to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertClosingAdjustmentItemDetail(Document document, Element element,
			ClosingAdjustmentItemModel closingAdjustmentItem) {
		insertData(document, element, "ClosingAdjustmentItemAmount", closingAdjustmentItem.getClosingAdjustmentItemAmount());
		//insertData(document, element, "ClosingAdjustmentItemPaidOutsideOfClosingIndicator",);
		Element closingAdjustmentItemTypeElement = insertData(document, element, "ClosingAdjustmentItemType", closingAdjustmentItem.getClosingAdjustmentItemType());
			if(!closingAdjustmentItem.getDisplayLabel().isEmpty() && null != closingAdjustmentItem.getDisplayLabel())
				closingAdjustmentItemTypeElement.setAttribute("gse:DisplayLabelText",closingAdjustmentItem.getDisplayLabel());
		insertData(document, element, "ClosingAdjustmentItemTypeOtherDescription", closingAdjustmentItem.getClosingAdjustmentItemTypeOtherDescription());
		insertData(document, element, "IntegratedDisclosureSectionType", closingAdjustmentItem.getIntegratedDisclosureSectionType());
		insertData(document, element, "IntegratedDisclosureSubsectionType", closingAdjustmentItem.getIntegratedDisclosureSubsectionType());
	
	}
	/**
	 * inserts AmortizationRule in MISMO XML
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	private void insertAmortizationRule(Document document, Element element, LoanInformation loanInformation) {
		insertData(document ,element ,"AmortizationType" , loanInformation.getAmortizationType());
	}
	/**
     * Inserts Adjustment to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertAdjustment(Document document, Element element, ClosingDisclosure jsonDocument) {
		insertInterestRateAdjustment(document ,insertLevels(document, element, "INTEREST_RATE_ADJUSTMENT"), jsonDocument.getInterestRateAdjustment());
		insertPrincipalAndInterestPaymentAdjustment(document ,insertLevels(document, element, "PRINCIPAL_AND_INTEREST_PAYMENT_ADJUSTMENT"), jsonDocument.getPrincipalAndInterestPaymentAdjustment());
	}
	/**
     * Inserts Principal And Interest Payment Adjustment to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param principalAndInterestPaymentAdjustment Input JSON Object
     */
	private void insertPrincipalAndInterestPaymentAdjustment(Document document, Element element,
			PrincipalAndInterestPaymentAdjustmentModel principalAndInterestPaymentAdjustment) {
		insertPrincipalAndInterestPaymentLifetimeAdjustmentRule(document ,insertLevels(document, element, "PRINCIPAL_AND_INTEREST_PAYMENT_LIFETIME_ADJUSTMENT_RULE"), principalAndInterestPaymentAdjustment);
		insertPrincipalAndInterestPaymentPerChangeAdjustmentRules(document ,insertLevels(document, element, "PRINCIPAL_AND_INTEREST_PAYMENT_PER_CHANGE_ADJUSTMENT_RULES"), principalAndInterestPaymentAdjustment);
	}
	/**
     * Inserts Principal And Interest Payment Per Change Adjustment Rules to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertPrincipalAndInterestPaymentPerChangeAdjustmentRules(Document document, Element element,
			PrincipalAndInterestPaymentAdjustmentModel principalAndInterestPaymentAdjustment) {
		if("First".equalsIgnoreCase(principalAndInterestPaymentAdjustment.getFirstAdjustmentRuleType()))
			insertPrincipalAndInterestPaymentPerChangeAdjustmentRule(document,insertLevels(document, element, "PRINCIPAL_AND_INTEREST_PAYMENT_PER_CHANGE_ADJUSTMENT_RULE"),principalAndInterestPaymentAdjustment, "First");
		if("Subsequent".equalsIgnoreCase(principalAndInterestPaymentAdjustment.getSubsequentAdjustmentRuleType()))
			insertPrincipalAndInterestPaymentPerChangeAdjustmentRule(document,insertLevels(document, element, "PRINCIPAL_AND_INTEREST_PAYMENT_PER_CHANGE_ADJUSTMENT_RULE"),principalAndInterestPaymentAdjustment, "Subsequent");
	}
	/**
     * Inserts Principal And Interest Payment Per Change Adjustment Rule to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertPrincipalAndInterestPaymentPerChangeAdjustmentRule(Document document, Element element,
			PrincipalAndInterestPaymentAdjustmentModel principalAndInterestPaymentAdjustment, String type) {
		if("First".equalsIgnoreCase(type))
		{
			insertData(document,element, "AdjustmentRuleType", principalAndInterestPaymentAdjustment.getFirstAdjustmentRuleType());
			insertData(document,element, "PerChangeMaximumPrincipalAndInterestPaymentAmount", principalAndInterestPaymentAdjustment.getFirstPerChangeMaximumPrincipalAndInterestPaymentAmount()); 
			insertData(document,element, "PerChangeMinimumPrincipalAndInterestPaymentAmount", principalAndInterestPaymentAdjustment.getFirstPerChangeMinimumPrincipalAndInterestPaymentAmount());
			insertData(document,element, "PerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount", principalAndInterestPaymentAdjustment.getFirstPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount());
		}
		if("Subsequent".equalsIgnoreCase(type))
		{
			insertData(document,element, "AdjustmentRuleType", principalAndInterestPaymentAdjustment.getSubsequentAdjustmentRuleType());
			insertData(document,element, "PerChangeMaximumPrincipalAndInterestPaymentAmount", principalAndInterestPaymentAdjustment.getSubsequentPerChangeMaximumPrincipalAndInterestPaymentAmount()); 
			insertData(document,element, "PerChangeMinimumPrincipalAndInterestPaymentAmount", principalAndInterestPaymentAdjustment.getSubsequentPerChangeMinimumPrincipalAndInterestPaymentAmount());
			insertData(document,element, "PerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount", principalAndInterestPaymentAdjustment.getSubsequentPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount());
		}
	}
	/**
     * Inserts Principal And Interest Payment Lifetime Adjustment Rule to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertPrincipalAndInterestPaymentLifetimeAdjustmentRule(Document document, Element element,
			PrincipalAndInterestPaymentAdjustmentModel principalAndInterestPaymentAdjustment) {
		insertData(document, element, "FirstPrincipalAndInterestPaymentChangeMonthsCount",principalAndInterestPaymentAdjustment.getFirstPrincipalAndInterestPaymentChangeMonthsCount() );
		insertData(document, element, "PrincipalAndInterestPaymentMaximumAmount", principalAndInterestPaymentAdjustment.getPrincipalAndInterestPaymentMaximumAmount());
		insertData(document, element, "PrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount", principalAndInterestPaymentAdjustment.getPrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount());
	}
	/**
     * inserts Interest Rate Adjustment to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertInterestRateAdjustment(Document document, Element element, InterestRateAdjustmentModel interestRateAdjustment) {
		if(!interestRateAdjustment.getIndexType().isEmpty() && null != interestRateAdjustment.getIndexType())
			insertIndexRules(document ,insertLevels(document, element, "INDEX_RULES/INDEX_RULE"), interestRateAdjustment.getIndexType());
		insertInterestRateLifetimeAdjustmentRule(document ,insertLevels(document, element, "INTEREST_RATE_LIFETIME_ADJUSTMENT_RULE"), interestRateAdjustment);
		insertInterestRatePerChangeAdjustmentRules(document ,insertLevels(document, element, "INTEREST_RATE_PER_CHANGE_ADJUSTMENT_RULES"), interestRateAdjustment);
	}
	/**
     * inserts Interest Rate Per Change Adjustment Rules to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertInterestRatePerChangeAdjustmentRules(Document document, Element element,
			InterestRateAdjustmentModel interestRateAdjustment) {
		if("First".equalsIgnoreCase(interestRateAdjustment.getFirstAdjustmentRule()))
			insertInterestRatePerChangeAdjustmentRule(document ,insertLevels(document, element, "INTEREST_RATE_PER_CHANGE_ADJUSTMENT_RULE"), interestRateAdjustment, "First");
		if("Subsequent".equalsIgnoreCase(interestRateAdjustment.getSubsequentAdjustmentRule()))
			insertInterestRatePerChangeAdjustmentRule(document ,insertLevels(document, element, "INTEREST_RATE_PER_CHANGE_ADJUSTMENT_RULE"), interestRateAdjustment, "Subsequent");
		
	}
	/**
     * Inserts Interest Rate Per Change Adjustment Rule to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertInterestRatePerChangeAdjustmentRule(Document document, Element element,
			InterestRateAdjustmentModel interestRateAdjustment, String type) {
		if("First".equalsIgnoreCase(type))
		{
			insertData(document ,element , "AdjustmentRuleType", interestRateAdjustment.getFirstAdjustmentRule());
			insertData(document ,element , "PerChangeMaximumIncreaseRatePercent", interestRateAdjustment.getFirstPerChangeMaximumIncreaseRatePercent());
			insertData(document ,element , "PerChangeRateAdjustmentFrequencyMonthsCount", interestRateAdjustment.getFirstPerChangeRateAdjustmentFrequencyMonthsCount());
		}
		if("Subsequent".equalsIgnoreCase(type))
		{
			insertData(document ,element , "AdjustmentRuleType", interestRateAdjustment.getSubsequentAdjustmentRule());
			insertData(document ,element , "PerChangeMaximumIncreaseRatePercent", interestRateAdjustment.getSubsequentPerChangeMaximumIncreaseRatePercent());
			insertData(document ,element , "PerChangeRateAdjustmentFrequencyMonthsCount", interestRateAdjustment.getSubsequentPerChangeRateAdjustmentFrequencyMonthsCount());
		}
		
	}                                
	/**
     * Inserts Interest Rate Lifetime Adjustment Rule to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertInterestRateLifetimeAdjustmentRule(Document document, Element element,
			InterestRateAdjustmentModel interestRateLifetimeAdjustmentRule) {
		insertData(document, element, "CeilingRatePercent", interestRateLifetimeAdjustmentRule.getCeilingRatePercent());
		insertData(document, element, "CeilingRatePercentEarliestEffectiveMonthsCount", interestRateLifetimeAdjustmentRule.getCeilingRatePercentEarliestEffectiveMonthsCount());
		insertData(document, element, "FirstRateChangeMonthsCount", interestRateLifetimeAdjustmentRule.getFirstRateChangeMonthsCount());
		insertData(document, element, "FloorRatePercent", interestRateLifetimeAdjustmentRule.getFloorRatePercent());
		insertData(document, element, "MarginRatePercent", interestRateLifetimeAdjustmentRule.getMarginRatePercent());
		OtherModel other = new OtherModel();
			other.setTotalStepCount(interestRateLifetimeAdjustmentRule.getTotalStepCount());
		insertExtension(document ,insertLevels(document, element, "EXTENSION"), other);
		
	}
	/**
	 * inserts Extension in MISMO XML
	 * @param document
	 * @param element
	 * @param jsonDocument
	 */
	private void insertExtension(Document document, Element element, OtherModel other) {
		if(!"".equals(other.getPaymentIncludedInAPRIndicator()) || !"".equals(other.getPayoffPartialIndicator()))
			insertMismo(document ,insertLevels(document, element, "MISMO") ,other);
		insertOther(document ,insertLevels(document, element, "OTHER") ,other);
	}
	
	/**
	 * inserts gse datapoints under Other in MISMO XML
	 * @param document
	 * @param element
	 * @param other
	 */
	private void insertOther(Document document, Element element, OtherModel other) {
	 	insertData(document, element, GSE_ALIAS + ":BuydownReflectedInNoteIndicator", other.getBuydownReflectedInNoteIndicator());
		insertData(document, element, GSE_ALIAS + ":DocumentSignatureRequiredIndicator", other.getDocumentSignatureRequiredIndicator());
		insertData(document, element, GSE_ALIAS + ":EscrowAccountRolloverAmount", other.getEscrowAccountRolloverAmount());
		insertData(document, element,
				GSE_ALIAS + ":IntegratedDisclosureEstimatedClosingCostsExpirationTimezoneType", other.getIntegratedDisclosureEstimatedClosingCostsExpirationTimezoneType());
		insertData(document, element, GSE_ALIAS + ":IntegratedDisclosureSectionType", other.getIntegratedDisclosureSectionType());
		insertData(document, element, GSE_ALIAS + ":LiabilitySecuredBySubjectPropertyIndicator", other.getLiabilitySecuredBySubjectPropertyIndicator());
		insertData(document, element, GSE_ALIAS + ":LockExpirationTimezoneType", other.getLockExpirationTimezoneType());
		insertData(document, element, GSE_ALIAS + ":TotalOptionalPaymentCount", other.getTotalOptionalPaymentCount());
		insertData(document, element, GSE_ALIAS + ":TotalStepCount", other.getTotalStepCount());
		insertData(document, element, GSE_ALIAS + ":TotalStepPaymentCount", other.getTotalStepPaymentCount());
		insertData(document, element, GSE_ALIAS + ":SubordinateFinancingIsNewIndicator", other.getSubordinateFinancingIsNewIndicator());
	}
	
	/**
	 * inserts mismo datapoints under Other in MISMO XML
	 * @param document
	 * @param element
	 * @param other
	 */
	private void insertMismo(Document document, Element element, OtherModel other) {
		insertData(document, element, "PaymentIncludedInAPRIndicator", other.getPaymentIncludedInAPRIndicator());
		insertData(document, element, "PayoffPartialIndicator", other.getPayoffPartialIndicator());
	}
	/**
     * Inserts Index Rules from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertIndexRules(Document document, Element element, String indexType) {
		//for (IndexRule indexRule : indexRules)
		insertIndexRule(document, element, "INDEX_RULE", indexType);
	}
	/**
     * Inserts Index Rule from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertIndexRule(Document document, Element element, String string, String indexType) {
		insertData(document, element, "IndexType", indexType);
		//insertData(document, element, "IndexTypeOtherDescription", "jsonDocument.IndexTypeOtherDescription");
	}
	/**
     * Inserts Loan Identifiers to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertLoanIdentifiers(Document document, Element element, List<LoanInformationLoanIdentifier> loanIdentifiers) {
	
		for(LoanInformationLoanIdentifier loanIdentifierModel: loanIdentifiers)
		{
			Element loanIdentifier = insertLevels(document, element, "LOAN_IDENTIFIER");
			    insertData(document, loanIdentifier, "LoanIdentifier", loanIdentifierModel.getLoanIdentifier());
			    insertData(document, loanIdentifier, "LoanIdentifierType", loanIdentifierModel.getLoanIdentifierType());
		}
	}
	/**
     * Inserts Maturity Rule to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertMaturityRule(Document document, Element element, MaturityRuleModel maturityRule) {
			insertData(document, element, "LoanMaturityPeriodCount", maturityRule.getLoanMaturityPeriodCount());
			insertData(document, element, "LoanMaturityPeriodType", maturityRule.getLoanMaturityPeriodType());
			insertData(document, element, "LoanTermMaximumMonthsCount", maturityRule.getLoanTermMaximumMonthsCount());
	}
    /**
     * Inserts Message to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertMessage(Document document, Element element, ClosingDisclosure jsonDocument) {
		element.setAttribute(XMLNS_ALIAS + ":xsi", XSI_URI);
		element.setAttribute("xsi:schemaLocation", "http://www.mismo.org/residential/2009/schemas ../../../MISMO/V3.3.0_CR_2014-02/ReferenceModel_v3.3.0_B299/MISMO_3.3.0_B299.xsd");
		element.setAttribute(XMLNS_ALIAS + ":" + MISMO_ALIAS, MISMO_URI);
		element.setAttribute(XMLNS_ALIAS + ":" + GSE_ALIAS, GSE_URI);
		element.setAttribute(XMLNS_ALIAS + ":" + XLINK_ALIAS, XLINK_URI);
		element.setAttribute("MISMOReferenceModelIdentifier", "3.3.0299");
		insertAboutVersion(document, insertLevels(document, element, "ABOUT_VERSIONS/ABOUT_VERSION"), jsonDocument);
		insertDocumentSet(document, insertLevels(document, element, "DOCUMENT_SETS/DOCUMENT_SET"), jsonDocument);
	}
	/**
     * Inserts Parties to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertParties(Document document, Element element, ClosingDisclosure jsonDocument) {
		List<Borrower> borrowers = jsonDocument.getTransactionInformation().getBorrower();
			insertPartys(document, element, borrowers);
		List<Borrower> sellers = jsonDocument.getTransactionInformation().getSeller();
			insertPartys(document, element, sellers);
		List<Borrower> lenders = jsonDocument.getTransactionInformation().getLender();
			insertPartys(document, element, lenders);
				
		ContactInformationDetailModel mortagageBroker =	jsonDocument.getContactInformation().getMortagageBroker();
		if(null != mortagageBroker)
			insertParty(document, element, mortagageBroker);
		
		ContactInformationDetailModel lender =	jsonDocument.getContactInformation().getLender();
		if(null != lender)
			insertParty(document, element, lender);
		
		ContactInformationDetailModel realEstateBrokerB =	jsonDocument.getContactInformation().getRealEstateBrokerB();
		if(null != realEstateBrokerB)
			insertParty(document, element, realEstateBrokerB);
		
		ContactInformationDetailModel realEstateBrokerS =	jsonDocument.getContactInformation().getRealEstateBrokerS();
		if(null != realEstateBrokerS)
			insertParty(document, element, realEstateBrokerS);
		
		ContactInformationDetailModel settlementAgent =	jsonDocument.getContactInformation().getSettlementAgent();
		if(null != settlementAgent)
			insertParty(document, element, settlementAgent);
	}
	
	/**
     * Inserts Party to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertPartys(Document document, Element element, List<Borrower> borrowers)
	{
		for (Borrower borrower : borrowers) {
			Element party = insertLevels(document, element, "PARTY");
			Element roleDetail = insertLevels(document, party, "ROLES/ROLE/ROLE_DETAIL");
			insertData(document, roleDetail, "PartyRoleType", borrower.getPartyRoleType());
			if ("Other".equals(borrower.getPartyRoleType()))
				insertData(document, roleDetail, "PartyRoleTypeOtherDescription", borrower.getPartyRoleOtherDescription());
			
			if(!borrower.getNameModel().getFullName().isEmpty())
			{
				Element legalEntity = insertLevels(document, party, "LEGAL_ENTITY/LEGAL_ENTITY_DETAIL");
					insertData(document, legalEntity, "FullName", borrower.getNameModel().getFullName());
			}
			else
			{
				Element name = insertLevels(document, party, "INDIVIDUAL/NAME");
					insertData(document, name, "FirstName", borrower.getNameModel().getFirstName());
					insertData(document, name, "LastName", borrower.getNameModel().getLastName());
					insertData(document, name, "MiddleName", borrower.getNameModel().getMiddleName());
					insertData(document, name, "SuffixName", borrower.getNameModel().getSuffixName());
			}
			
			Element address = insertLevels(document, party, "ADDRESSES/ADDRESS");
			insertData(document, address, "AddressLineText", borrower.getAddress().getAddressLineText());
			insertData(document, address, "AddressUnitDesignatorType", borrower.getAddress().getAddressUnitDesignatorType());
			insertData(document, address, "AddressUnitIdentifier", borrower.getAddress().getAddressUnitIdentifier());
			insertData(document, address, "CityName", borrower.getAddress().getCityName());
			insertData(document, address, "CountryCode", borrower.getAddress().getCountryCode());
			insertData(document, address, "PostalCode", borrower.getAddress().getPostalCode());
			insertData(document, address, "StateCode", borrower.getAddress().getStateCode());
		}
	}
	
	/**
	 * inserts party to MISMO XML
	 * @param document Output XML file
	 * @param element parent node of XML
	 * @param partyDetail Input JSON Object
	 */
	private void insertParty(Document document, Element element, ContactInformationDetailModel partyDetail)
	{
		if(!partyDetail.getName().getFullName().isEmpty())
		{
			Element party = insertLevels(document, element, "PARTY");
			Element roleDetail = insertLevels(document, party, "ROLES/ROLE/ROLE_DETAIL");
				insertData(document, roleDetail, "PartyRoleType", partyDetail.getPartyRoleType());
			
			Element legalEntity = insertLevels(document, party, "LEGAL_ENTITY/LEGAL_ENTITY_DETAIL");
				insertData(document, legalEntity, "FullName",partyDetail.getName().getFullName());
				
			Element address = insertLevels(document, party, "ADDRESSES/ADDRESS");
				insertData(document, address, "AddressLineText", partyDetail.getAddress().getAddressLineText());
				insertData(document, address, "AddressUnitDesignatorType", partyDetail.getAddress().getAddressUnitDesignatorType());
				insertData(document, address, "AddressUnitIdentifier", partyDetail.getAddress().getAddressUnitIdentifier());
				insertData(document, address, "CityName", partyDetail.getAddress().getCityName());
				insertData(document, address, "CountryCode", partyDetail.getAddress().getCountryCode());
				insertData(document, address, "PostalCode", partyDetail.getAddress().getPostalCode());
				insertData(document, address, "StateCode", partyDetail.getAddress().getStateCode());
				
				Element licenseDetail = insertLevels(document, party, "LICENSE/LICENSE_DETAIL");
					insertData(document, licenseDetail, "identifierOwnerURI", partyDetail.getOrganizationLicenseDetail().getIdentifierOwnerURI());
					insertData(document, licenseDetail, "licenseAuthorityLevelType", partyDetail.getOrganizationLicenseDetail().getLicenseAuthorityLevelType());
					insertData(document, licenseDetail, "licenseIdentifier", partyDetail.getOrganizationLicenseDetail().getLicenseIdentifier());
					insertData(document, licenseDetail, "licenseIssueDate", partyDetail.getOrganizationLicenseDetail().getLicenseIssueDate());
					insertData(document, licenseDetail, "licenseIssuingAuthorityName", partyDetail.getOrganizationLicenseDetail().getLicenseIssuingAuthorityName());
					insertData(document, licenseDetail, "licenseIssuingAuthorityStateCode", partyDetail.getOrganizationLicenseDetail().getLicenseIssuingAuthorityStateCode());
		}
		
		if(!partyDetail.getName().getFirstName().isEmpty() || !partyDetail.getName().getLastName().isEmpty() || !partyDetail.getName().getMiddleName().isEmpty() || !partyDetail.getName().getSuffixName().isEmpty())
		{
			Element party = insertLevels(document, element, "PARTY");
			Element roleDetail = insertLevels(document, party, "ROLES/ROLE/ROLE_DETAIL");
				insertData(document, roleDetail, "PartyRoleType", partyDetail.getPartyRoleType());
						
			Element name = insertLevels(document, party, "INDIVIDUAL/NAME");
				insertData(document, name, "FirstName", partyDetail.getName().getFirstName());
				insertData(document, name, "LastName", partyDetail.getName().getLastName());
				insertData(document, name, "MiddleName", partyDetail.getName().getMiddleName());
				insertData(document, name, "SuffixName", partyDetail.getName().getSuffixName());
			
			if((!partyDetail.getIndividualEmail().isEmpty() && null != partyDetail.getIndividualEmail()) || (!partyDetail.getIndividualPhone().isEmpty() && null != partyDetail.getIndividualPhone()))	
			{	
				Element contact = insertLevels(document, party, "INDIVIDUAL/CONTACT_POINTS");
				
				if((!partyDetail.getIndividualEmail().isEmpty() && null != partyDetail.getIndividualEmail()))
				{
					Element email = insertLevels(document, contact, "CONTACT_POINT/CONTACT_POINT_EMAIL");
						insertData(document, email, "ContactPointEmailValue", partyDetail.getIndividualEmail());
				}
				
				if(!partyDetail.getIndividualPhone().isEmpty() && null != partyDetail.getIndividualPhone())
				{
					Element phone = insertLevels(document, contact, "CONTACT_POINT/CONTACT_POINT_TELEPHONE");
						insertData(document, phone, "ContactPointTelephoneValue", partyDetail.getIndividualPhone());
				}
			
			}
			Element licenseDetail = insertLevels(document, party, "LICENSE/LICENSE_DETAIL");
				insertData(document, licenseDetail, "identifierOwnerURI", partyDetail.getIndividualLicenseDetail().getIdentifierOwnerURI());
				insertData(document, licenseDetail, "licenseAuthorityLevelType", partyDetail.getIndividualLicenseDetail().getLicenseAuthorityLevelType());
				insertData(document, licenseDetail, "licenseIdentifier", partyDetail.getIndividualLicenseDetail().getLicenseIdentifier());
				insertData(document, licenseDetail, "licenseIssueDate", partyDetail.getIndividualLicenseDetail().getLicenseIssueDate());
				insertData(document, licenseDetail, "licenseIssuingAuthorityName", partyDetail.getIndividualLicenseDetail().getLicenseIssuingAuthorityName());
				insertData(document, licenseDetail, "licenseIssuingAuthorityStateCode", partyDetail.getIndividualLicenseDetail().getLicenseIssuingAuthorityStateCode());
		}
		
	}
	
	
	/**
     * Inserts Subject Property from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertSubjectProperty(Document document, Element element, ClosingDisclosure jsonDocument) {

		insertAddress(document, insertLevels(document, element, "ADDRESS"), jsonDocument.getClosingInformation().getProperty());
		//insertUnparsedLegalDescription(document, 
			//	insertLevels(document, element,"LEGAL_DESCRIPTIONS/LEGAL_DESCRIPTION/UNPARSED_LEGAL_DESCRIPTIONS/UNPARSED_LEGAL_DESCRIPTION"), "TODO");
		//insertLocationIdentifier(document, insertLevels(document, element, "LOCATION_IDENTIFIER"), jsonDocument);
		insertPropertyDetail(document, insertLevels(document, element, "PROPERTY_DETAIL"), jsonDocument.getClosingInformation().getPropertyValuationDetail().getPropertyEstimatedValueAmount());
		insertPropertyValuations(document, insertLevels(document, element, "PROPERTY_VALUATIONS"), jsonDocument.getClosingInformation().getPropertyValuationDetail());
		insertSalesContractDetail(document, insertLevels(document, element, "SALES_CONTRACTS/SALES_CONTRACT/SALES_CONTRACT_DETAIL"), jsonDocument.getSalesContractDetail());
	
	}
	/**
     * Inserts Sales Contract Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertSalesContractDetail(Document document, Element element,
			SalesContractDetailModel salesContractDetail) {
		insertData(document, element, "PersonalPropertyAmount", salesContractDetail.getPersonalPropertyAmount());
		insertData(document, element, "PersonalPropertyIncludedIndicator",Boolean.toString(salesContractDetail.isPersonalPropertyIndicator()));
		insertData(document, element, "RealPropertyAmount", salesContractDetail.getRealPropertyAmount());
		insertData(document, element, "SalesContractAmount", salesContractDetail.getSaleContractAmount());
	}
	/**
     * Inserts Property Valuations from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertPropertyValuations(Document document, Element element,
			PropertyValuationDetailModel propertyValuationDetailModel) {
		//for (String group : groupings)
			insertPropertyValuation(document, insertLevels(document, element, "PROPERTY_VALUATION"), propertyValuationDetailModel);
	}
	/**
     * Inserts Property Valuation from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertPropertyValuation(Document document, Element element,
			PropertyValuationDetailModel propertyValuationDetailModel) {
		insertPropertyValuationDetail(document, insertLevels(document, element, "PROPERTY_VALUATION_DETAIL"), propertyValuationDetailModel);
	}
	/**
     * Inserts Property Valuation Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */	
	private void insertPropertyValuationDetail(Document document, Element element,
			PropertyValuationDetailModel propertyValuationDetail) {
		Element AppraisalIdentifierelement = insertLevels(document, element, "AppraisalIdentifier");
		AppraisalIdentifierelement.setAttribute("IdentifierOwnerURI",propertyValuationDetail.getIdentifierOwnerURI());
		//insertAttributeValue(xmlout, element, "IdentifierOwnerURI", "");
		insertData(document, element, "PropertyValuationAmount", propertyValuationDetail.getPropertyValuationAmount());
		insertData(document, element, "PropertyValuationMethodType", propertyValuationDetail.getPropertyValuationMethodType());
		insertData(document, element, "PropertyValuationMethodTypeOtherDescription", propertyValuationDetail.getPropertyValuationMethodTypeOtherDescription());
		
	}
	/**
     * Inserts Property Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertPropertyDetail(Document document, Element element, String propertyEstimatedValueAmount) {
		insertData(document, element, "AffordableUnitsCount", "");
		insertData(document, element, "ConstructionMethodType", "");
		insertData(document, element, "FinancedUnitCount", "");
		insertData(document, element, "MetropolitanDivisionIndicator", "");
		insertData(document, element, "MSAIndicator", "");
		insertData(document, element, "PropertyEstateType", "");
		insertData(document, element, "PropertyEstateTypeOtherDescription", "");
		insertData(document, element, "PropertyEstimatedValueAmount", propertyEstimatedValueAmount);
		insertData(document, element, "PropertyUsageType", "");
	}
	/**
     * Inserts Location Identifier to MISMO XML
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	/*private void insertLocationIdentifier(Document document, Element element,
			ClosingDisclosure jsonDocument) {
		insertCensusInformation(document, insertLevels(document, element, "CENSUS_INFORMATION"), "TODO");
		insertFipsInformation(document, insertLevels(document, element, "FIPS_INFORMATION"), "TODO");
	}*/
	/**
     * Inserts Fips Information from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */	
	/*private void insertFipsInformation(Document document, Element element,
			String FIPSCountyCode) {
		insertData(document, element, "FIPSCountyCode", FIPSCountyCode);
	}*/
	/**
     * Inserts Census Information from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */	
	/*private void insertCensusInformation(Document document, Element element,
			String censusTractIdentifier) {
		insertData(document, element, "CensusTractIdentifier", censusTractIdentifier);
	}*/
	/**
     * Inserts Address from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertAddress(Document document, Element element, AddressModel addressModel) {
		
		insertData(document, element, "AddressLineText", addressModel.getAddressLineText());
		insertData(document, element, "AddressUnitDesignatorType", addressModel.getAddressUnitDesignatorType());
		insertData(document, element, "AddressUnitIdentifier", addressModel.getAddressUnitIdentifier());
		insertData(document, element, "CityName", addressModel.getCityName());
		insertData(document, element, "PostalCode", addressModel.getPostalCode());
		insertData(document, element, "StateCode", addressModel.getStateCode());
	}
	/**
     * Inserts Unparsed Legal Description from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertUnparsedLegalDescription(Document document, Element element,
			String unparsedLegalDescription) {
		insertData(document, element, "UnparsedLegalDescription", "");
	}
	/**
     * Inserts Terms Of Loan from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     */
	private void insertTermsOfLoan(Document document, Element element, TermsOfLoanModel termsOfLoan) {
		insertData(document, element, "AssumedLoanAmount", termsOfLoan.getAssumedLoanAmount());
		insertData(document, element, "DisclosedFullyIndexedRatePercent", termsOfLoan.getDisclosedFullyIndexedRatePercent());
		insertData(document, element, "LienPriorityType", termsOfLoan.getLienPriorityType());
		insertData(document, element, "LoanPurposeType", termsOfLoan.getLoanPurposeType());
		insertData(document, element, "MortgageType", termsOfLoan.getMortgageType());
		insertData(document, element, "MortgageTypeOtherDescription", termsOfLoan.getMortgageTypeOtherDescription());
		insertData(document, element, "NoteAmount", termsOfLoan.getNoteAmount());
		insertData(document, element, "NoteRatePercent", termsOfLoan.getNoteRatePercent());
		insertData(document, element, "WeightedAverageInterestRatePercent", termsOfLoan.getWeightedAverageInterestRatePercent());
	}
}
