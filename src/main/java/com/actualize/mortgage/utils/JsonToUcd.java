package com.actualize.mortgage.utils;

public class JsonToUcd {
	/*private static final String GSE_ALIAS = "gse";
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
	*//**
	 * Method is used to transform one file into another form
	 * @param jsonDocument is Input JSON Object
	 * @return object of Document
	 *//*
    public Document transform(ClosingDisclosureDocument jsonDocument) {
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
	*//**
	 * Inserts Data to XML Object from JSON Object
	 * @param document Output XML file
	 * @param element parent node of XML
	 * @param element parent node of XMLName
	 * @param element parent node of XMLValue
	 * @return
	 *//*
	private Element insertData(Document document, Element element, String elementName, String elementValue) {
		Element e = null;
		if (elementValue != null && !elementValue.isEmpty()) {
			e = (Element)element.appendChild(document.createElement(addNamespace(elementName)));
			e.appendChild(document.createTextNode(elementValue));
		}
		return element;
	}
	*//**
	 * Inserts Levels from JSON Object
	 * @param document Output XML file
	 * @param element parent node of XML
	 * @param element parent node of XMLName
	 * @param element parent node of XMLValue
	 * @return
	 *//*
	private Element insertLevels(Document xmlout, Element parentElement, String path) {
		Element parent = parentElement;
		for (String container : path.split("/"))
			parent = (Element) parent.appendChild(xmlout.createElement(addNamespace(container)));
		return parent;
	}
	*//**
     * Inserts About Version from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertAboutVersion(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO: set correct version number and created date time
		insertData(document, element, "AboutVersionIdentifier", "TRIDent Web Toolkit, v0.1"); //TODO: This datapoint is not found in UCD Spec. 
		insertData(document, element, "CreatedDatetime", "2017-03-01T14:19:48Z");
	}
	*//**
     * Inserts Closing Information Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertClosingInformationDetail(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		ClosingInformation closingInformation = jsonDocument.getPageOne().getClosingInformation();
		CostsAtClosing costsAtClosing = jsonDocument.getPageOne().getCostsAtClosing();
		CostsAtClosingCashToClose costsAtClosingCashToClose = costsAtClosing.getCostsAtClosingCashToClose();
		insertData(document, element, "CashFromBorrowerAtClosingAmount", costsAtClosingCashToClose.getCashFromBorrowerAtClosingAmount());
		insertData(document, element, "CashFromSellerAtClosingAmount", "");
		insertData(document, element, "CashToBorrowerAtClosingAmount", costsAtClosingCashToClose.getCashToBorrowerAtClosingAmount());
		insertData(document, element, "CashToSellerAtClosingAmount", "");
		insertData(document, element, "CurrentRateSetDate", "");
		insertData(document, element, "DocumentOrderClassificationType", ""); //TODO: This datapoint is not found in UCD Spec.
		insertData(document, element, "CashFromBorrowerAtClosingAmount", costsAtClosingCashToClose.getAmount());
		insertData(document, element, "CashFromSellerAtClosingAmount", costsAtClosingCashToClose.getAmount());
		insertData(document, element, "CashToBorrowerAtClosingAmount", costsAtClosingCashToClose.getAmount());
		insertData(document, element, "CashToSellerAtClosingAmount", costsAtClosingCashToClose.getAmount());
		insertData(document, element, "ClosingAgentOrderNumberIdentifier", closingInformation.getFileNo());
		insertData(document, element, "ClosingDate", closingInformation.getClosingDate());
		insertData(document, element, "DisbursementDate", closingInformation.getDisbursementDate());
		
	}
    *//**
     * Inserts Deal from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertDeal(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		insertSubjectProperty(document, insertLevels(document, element, "COLLATERALS/COLLATERAL/SUBJECT_PROPERTY"), jsonDocument);
		insertLoan(document, insertLevels(document, element, "LOANS/LOAN"), jsonDocument);
		insertParties(document, insertLevels(document, element, "PARTIES"), jsonDocument);
		insertLiabilities(document, insertLevels(document, element, "LIABILITIES"), jsonDocument);
	}
	 *//**
     * Inserts Liabilities from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertLiabilities(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
			insertLiability(document, insertLevels(document, element, "LIABILITY"), jsonDocument);
	}
	 *//**
     * Inserts Liability from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	 private void insertLiability(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		 insertLiabilityDetail(document, insertLevels(document, element, "LIABILITY_DETAIL"), jsonDocument);
		 insertLiabilityHolder(document, insertLevels(document, element, "LIABILITY_HOLDER"), jsonDocument);
		 insertPayoff(document, insertLevels(document, element, "PAYOFF"), jsonDocument);
	}
	 *//**
	     * Inserts Payoff from JSON Object
	     * @param document Output XML file
	     * @param element parent node of XML
	     * @param jsonDocument Input JSON Object
	     *//*
	 private void insertPayoff(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "PayoffAmount", "");
		insertData(document, element, "PayoffPrepaymentPenaltyAmount", "");
		insertExtension(document, insertLevels(document, element, "EXTENSION"), jsonDocument);
	}
	*//**
	 * Inserts Liability Holder from JSON Object
	 * @param document Output XML file
	 * @param element parent node of XML
	 * @param jsonDocument Input JSON Object
	 *//*
	 private void insertLiabilityHolder(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		 insertName(document, insertLevels(document, element, "NAME"), jsonDocument);
	 }
	*//**
	 * Inserts Liability Detail from JSON Object
	 * @param document Output XML file
	 * @param element parent node of XML
	 * @param jsonDocument Input JSON Object
	 *//*
	private void insertLiabilityDetail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "LiabilityDescription", "");
		Element liabilityTypeElement = insertData(document, element, "LiabilityType", "");
		liabilityTypeElement.setAttribute("gse:DisplayLabelText", "");
		insertData(document, element, "LiabilityTypeOtherDescription", "");
		insertExtension(document, insertLevels(document, element, "EXTENSION"), jsonDocument);
	}
	*//**
     * Inserts Deal Set from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertDealSet(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		insertDeal(document, insertLevels(document, element, "DEALS/DEAL"), jsonDocument);
	}
	*//**
     * Inserts Deal Sets from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertDealSets(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		insertDealSet(document, insertLevels(document, element, "DEAL_SET"), jsonDocument);
	}
	*//**
     * Inserts Document Set from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertDocumentSet(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		insertDocuments(document, insertLevels(document, element, "DOCUMENTS"), jsonDocument);
	}
	*//**
     * Inserts Documents from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertDocuments(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
			insertDocument(document, insertLevels(document, element, "DOCUMENT"), jsonDocument);
	}
	*//**
     * Inserts Document from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*	
	private void insertDocument(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		element.setAttribute("MISMOReferenceModelIdentifier", "3.3.0299");
		insertDealSets(document, insertLevels(document, element, "DEAL_SETS"), jsonDocument);
		insertAuditTrail(document, insertLevels(document, element, "AUDIT_TRAIL"), jsonDocument);
		insertRelationships(document, insertLevels(document, element, "RELATIONSHIPS"), jsonDocument);
		insertSignatories(document, insertLevels(document, element, "SIGNATORIES"), jsonDocument);
		insertSystemSignatures(document, insertLevels(document, element, "SYSTEM_SIGNATORIES"), jsonDocument);
		insertViews(document, insertLevels(document, element, "VIEWS"), jsonDocument);
		insertAboutVersions(document, insertLevels(document, element, "ABOUT_VERSIONS"), jsonDocument);
		insertDocumentClassification(document, insertLevels(document, element, "DOCUMENT_CLASSIFICATION"), jsonDocument);
	}
	*//**
     * Inserts Document Classification from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertDocumentClassification(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertDocumentClasses(document,	insertLevels(document, element, "DOCUMENT_CLASSES"), jsonDocument);
		insertDocumentClassificationDetail(document, insertLevels(document, element, "DOCUMENT_CLASSIFICATION_DETAIL"), jsonDocument);
	}
	*//**
     * Inserts Document Classification Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertDocumentClassificationDetail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "DocumentFormIssuingEntityNameType", "");
		insertData(document, element, "DocumentFormIssuingEntityVersionIdentifier", "");
		insertExtension(document, insertLevels(document, element, "EXTENSION"), jsonDocument);
	}
	*//**
     * Inserts Document Classes from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertDocumentClasses(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
			insertDocumentClass(document, insertLevels(document, element, "DOCUMENT_CLASS"), jsonDocument);
	}
	*//**
     * Inserts Document Class from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertDocumentClass(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "DocumentType", "");
		insertData(document, element, "DocumentTypeOtherDescription", "");
	}
	*//**
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
     * Inserts About Versions from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*	
	private void insertAboutVersions(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
			insertAboutVersion(document, insertLevels(document, element, "ABOUT_VERSION"), jsonDocument);
	}
	*//**
     * Inserts Integrated Disclosure Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertIntegratedDisclosureDetail(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		ClosingInformation closingInformation = jsonDocument.getPageOne().getClosingInformation();
		LoanInformation loanInformation = jsonDocument.getPageOne().getLoanInformation();
		//LoanTermsEscrowAccount  loanTermsEscrowAccount = jsonDocument.getPageOne().getLoanTerms().getLoanTermsEscrowAccount();
		System.out.println("TO DO insertIntegratedDisclosureDetail");
		insertData(document, element, "FirstYearTotalEscrowPaymentAmount", "");
		insertData(document, element, "FirstYearTotalEscrowPaymentDescription", "");
		//insertData(document, element, "FirstYearTotalNonEscrowPaymentAmount", loanTermsEscrowAccount.getFirstYearTotalNonEscrowPaymentAmount());
		//insertData(document, element, "FirstYearTotalNonEscrowPaymentDescription", loanTermsEscrowAccount.getFirstYearTotalNonEscrowPaymentDescription());
		insertData(document, element, "IntegratedDisclosureHomeEquityLoanIndicator",Convertor.booleanToString(loanInformation.isIntegratedDisclosureHomeEquityLoanIndicator()));
		insertData(document, element, "IntegratedDisclosureLoanProductDescription", loanInformation.getIntegratedDisclosureLoanProductDescription());
		insertData(document, element, "IntegratedDisclosureIssuedDate", closingInformation.getDateIssued());
	}
	*//**
     * Inserts Loan from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertLoan(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		
		insertAdjustment(document, insertLevels(document, element, "ADJUSTMENT"), jsonDocument);
		insertAmortizationRule(document, insertLevels(document, element, "AMORTIZATION/AMORTIZATION_RULE"), jsonDocument);
		insertBuydown(document, insertLevels(document, element, "BUYDOWN"), jsonDocument);
		insertClosingInformation(document, insertLevels(document, element, "CLOSING_INFORMATION"), jsonDocument);
		insertConstruction(document, insertLevels(document, element, "CONSTRUCTION"), jsonDocument);
		insertDocumentSpecificDataSet(document, insertLevels(document, element, "DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET"), jsonDocument);
		insertEscrow(document, insertLevels(document, element, "ESCROW"), jsonDocument);
		insertFeeInformation(document, insertLevels(document, element, "FEE_INFORMATION"), jsonDocument);
		insertForeclosures(document, insertLevels(document, element, "FORECLOSURES"), jsonDocument); // Not needed for LE
		insertHeloc(document, insertLevels(document, element, "HELOC"), jsonDocument); // Not needed for LE
		insertHighCostMortgages(document, insertLevels(document, element, "HIGH_COST_MORTGAGES"), jsonDocument); //  Not needed for LE
		insertHmdaLoan(document, insertLevels(document, element, "HMDA_LOAN"), jsonDocument); //  Not needed for LE
		insertInterestOnly(document, insertLevels(document, element, "INTEREST_ONLY"), jsonDocument);
		insertLateChargeRule(document, insertLevels(document, element, "LATE_CHARGE/EXTENSION/OTHER/gse:LATE_CHARGE_RULES/LATE_CHARGE_RULE"), jsonDocument);
		insertLoanDetail(document, insertLevels(document, element, "LOAN_DETAIL"), jsonDocument);
		insertLoanIdentifiers(document, insertLevels(document, element, "LOAN_IDENTIFIERS"), jsonDocument);
		insertLoanLevelCredit(document, insertLevels(document, element, "LOAN_LEVEL_CREDIT"), jsonDocument);
		insertLoanProduct(document, insertLevels(document, element, "LOAN_PRODUCT"), jsonDocument); //  Not needed for LE
		insertMaturityRule(document, insertLevels(document, element, "MATURITY/MATURITY_RULE"), jsonDocument);
		insertMIDataDetail(document, insertLevels(document, element, "MI_DATA/MI_DATA_DETAIL"), jsonDocument); // Not needed for LE
		insertNegativeAmortization(document, insertLevels(document, element, "NEGATIVE_AMORTIZATION"), jsonDocument);
		insertPayment(document, insertLevels(document, element, "PAYMENT"), jsonDocument);
		insertPrepaymentPenalty(document, insertLevels(document, element, "PREPAYMENT_PENALTY"), jsonDocument);
		insertQualification(document, insertLevels(document, element, "QUALIFICATION"), jsonDocument); //Not needed for LE
		insertQualifiedMortgage(document, insertLevels(document, element, "QUALIFIED_MORTGAGE"), jsonDocument); // Not needed for LE
		insertRefinance(document, insertLevels(document, element, "REFINANCE"), jsonDocument); //Not needed for LE
		insertReverseMortgage(document, insertLevels(document, element, "REVERSE_MORTGAGE"), jsonDocument); //Not needed for LE
		insertServicing(document, insertLevels(document, element, "SERVICING"), jsonDocument); // Not needed for LE
		insertTermsOfLoan(document, insertLevels(document, element, "TERMS_OF_LOAN"), jsonDocument);
		insertUnderwriting(document, insertLevels(document, element, "UNDERWRITING"), jsonDocument); // Not needed for LE
	
	}
    *//**
     * Inserts Underwriting from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertUnderwriting(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertAutomatedUnderwritings(document, insertLevels(document, element, "AUTOMATED_UNDERWRITINGS"), jsonDocument);
		insertUnderwritingDetail(document, insertLevels(document, element, "UNDERWRITING_DETAIL"), jsonDocument);
	}
	*//**
     * Inserts Underwriting Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertUnderwritingDetail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "LoanManualUnderwritingIndicator", "");
	}

	*//**
    * Inserts Automated Underwritings from JSON Object
    * @param document Output XML file
    * @param element parent node of XML
    * @param jsonDocument Input JSON Object
    *//*
    private void insertAutomatedUnderwritings(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
    	//for (String group : groupings)
			insertAutomatedUnderwriting(document, insertLevels(document, element, "AUTOMATED_UNDERWRITING"), jsonDocument);
	}
    *//**
     * Inserts Automated Underwriting from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertAutomatedUnderwriting(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "AutomatedUnderwritingCaseIdentifier", "");
		insertData(document, element, "AutomatedUnderwritingRecommendationDescription", "");
		insertData(document, element, "AutomatedUnderwritingSystemType", "");
		insertData(document, element, "AutomatedUnderwritingSystemTypeOtherDescription", "");
	}

	*//**
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
     * Inserts Refinace from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertRefinance(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "RefinanceCashOutDeterminationType", "");
		insertData(document, element, "RefinanceSameLenderIndicator", "");
	}
	*//**
	 * Inserts Qualified Mortgage from JSON Object
	 * @param document Output XML file
	 * @param element parent node of XML
	 * @param jsonDocument Input JSON Object
	 *//*
	private void insertQualifiedMortgage(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertExemption(document, insertLevels(document, element, "EXEMPTIONS/EXEMPTION"), jsonDocument);
		insertQualifiedMortgageDetail(document, insertLevels(document, element, "QUALIFIED_MORTGAGE_DETAIL"), jsonDocument);
	}
	*//**
	 * Inserts Qualified Mortgage Detail from JSON Object
	 * @param document Output XML file
	 * @param insertLevels
	 * @param jsonDocument Input JSON Object
	 *//*
	private void insertQualifiedMortgageDetail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "AbilityToRepayMethodType", "");
	}

	*//**
	 * Inserts Exemption from JSON Object
	 * @param document Output XML file
	 * @param insertLevels
	 * @param jsonDocument Input JSON Object
	 *//*
	private void insertExemption(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "AbilityToRepayExemptionReasonType", "");
	}

	*//**
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
     * Inserts Prepayment Penalty from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertPrepaymentPenalty(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertPrepaymentPenaltyLifetimeRule(document, insertLevels(document, element, "PREPAYMENT_PENALTY_LIFETIME_RULE"), jsonDocument);
	}
	*//**
     * Inserts Prepayment Penalty Lifetime Rule from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertPrepaymentPenaltyLifetimeRule(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "PrepaymentPenaltyExpirationDate", "");
		insertData(document, element, "PrepaymentPenaltyExpirationMonthsCount", "");
		insertData(document, element, "PrepaymentPenaltyMaximumLifeOfLoanAmount", "");
	}
	*//**
     * Inserts Payment from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertPayment(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertPartialPayments(document, insertLevels(document, element, "PARTIAL_PAYMENTS"), jsonDocument); 
		insertPaymentRule(document, insertLevels(document, element, "PAYMENT_RULE"), jsonDocument);
	}
	*//**
     * Inserts Payment Rule from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertPaymentRule(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		LoanTerms loanTerms = jsonDocument.getPageOne().getLoanTerms();
		LoanTermsPI loanTermsPI = loanTerms.getLoanTermsPI();
		insertData(document, element, "FullyIndexedInitialPrincipalAndInterestPaymentAmount", loanTermsPI.getFullyIndexedInitialPrincipalAndInterestPaymentAmount());
		insertData(document, element, "InitialPrincipalAndInterestPaymentAmount", loanTermsPI.getInitialPrincipalAndInterestPaymentAmount());
		insertData(document, element, "PartialPaymentAllowedIndicator", "");
		insertData(document, element, "PaymentFrequencyType", loanTermsPI.getPaymentFrequencyType());
		insertData(document, element, "PaymentOptionIndicator", "");
		insertData(document, element, "SeasonalPaymentPeriodEndMonth", "");
		insertData(document, element, "SeasonalPaymentPeriodStartMonth", "");
		insertExtension(document, insertLevels(document, element, "EXTENSION"), jsonDocument);
	}
	*//**
     * Inserts Partial Payments from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertPartialPayments(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
			insertPartialPayment(document, insertLevels(document, element, "PARTIAL_PAYMENT"), jsonDocument);
	}
	*//**
     * Inserts Partial Payments from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertPartialPayment(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "PartialPaymentApplicationMethodType", "");
		insertData(document, element, "PartialPaymentApplicationMethodTypeOtherDescription", "");
	}
	*//**
     * Inserts Negative Amortization from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertNegativeAmortization(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertNegativeAmortizationRule(document, insertLevels(document, element, "NEGATIVE_AMORTIZATION_RULE"), jsonDocument);
	}
	*//**
     * Inserts Negative Amortization Rule  from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertNegativeAmortizationRule(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "LoanNegativeAmortizationResolutionType", "");
		insertData(document, element, "LoanNegativeAmortizationResolutionTypeOtherDescription", "");
		insertData(document, element, "NegativeAmortizationLimitMonthsCount", jsonDocument.getPageOne().getLoanTerms().getLoanTermsLoanAmount().getNegativeAmortizationLimitMonthsCount());
		insertData(document, element, "NegativeAmortizationMaximumLoanBalanceAmount", jsonDocument.getPageOne().getLoanTerms().getLoanTermsLoanAmount().getNegativeAmortizationMaximumLoanBalanceAmount());
		insertData(document, element, "NegativeAmortizationType", "");
	}
	*//**
     * Inserts MI Data Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertMIDataDetail(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "MICertificateIdentifier", jsonDocument.getPageOne().getLoanInformation().getMiCertificateIdentifier());
		insertData(document, element, "MICompanyNameType", "");
		insertData(document, element, "MICompanyNameTypeOtherDescription", "");
		insertData(document, element, "MIScheduledTerminationDate", "");
	}
	*//**
     * Inserts Loan Product from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertLoanProduct(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertLoanPriceQuotes(document, insertLevels(document, element, "LOAN_PRICE_QUOTES"), jsonDocument);
		insertLocks(document, insertLevels(document, element, "LOCKS"), jsonDocument);
	}
	*//**
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
     * Inserts Loan Price Quotes from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertLoanPriceQuotes(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
			insertLoanPriceQuote(document, insertLevels(document, element, "LOAN_PRICE_QUOTE"), jsonDocument);
	}
	*//**
     * Inserts Loan Price Quote from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertLoanPriceQuote(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertLoanPriceQuoteDetail(document, insertLevels(document, element, "LOAN_PRICE_QUOTE_DETAIL"), jsonDocument);
	}
	*//**
     * Inserts Loan Price Quote Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertLoanPriceQuoteDetail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "LoanPriceQuoteInterestRatePercent", "");
	}
	*//**
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
     * Inserts Loan Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertLoanDetail(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		LoanTerms loanterms = jsonDocument.getPageOne().getLoanTerms();
		LoanTermsLoanAmount loanTermsLoanAmount = loanterms.getLoanTermsLoanAmount();
		LoanTermsInterestRate loanTermsInterestRate = loanterms.getLoanTermsInterestRate();
		LoanTermsPI loanTermsPI = loanterms.getLoanTermsPI();
		LoanTermsPrepaymentPenalty loanTermsPrepaymentPenalty = loanterms.getLoanTermsPrepaymentPenalty();
		LoanTermsBalloonPayment loanTermsBalloonPayment = loanterms.getLoanTermsBalloonPayment();
		LoanTermsIntialEscrow loanTermsIntialEscrow = new LoanTermsIntialEscrow();
		
		insertData(document, element, "AssumedIndicator", ""); //TODO Not Found in UCD-Spec
		insertData(document, element, "AssumabilityIndicator", "");
		insertData(document, element, "BalloonIndicator",Convertor.booleanToString(loanTermsBalloonPayment.isBalloonIndicator()));
		insertData(document, element, "BalloonPaymentAmount", loanTermsBalloonPayment.getBalloonPaymentAmount());
		insertData(document, element, "BuydownTemporarySubsidyFundingIndicator", Convertor.booleanToString(loanTermsInterestRate.isBuydownTemporarySubsidyFundingIndicator()));
		insertData(document, element, "ConstructionLoanIndicator", "");
		insertData(document, element, "CreditorServicingOfLoanStatementType", ""); //TODO Not Found in UCD-Spec
		insertData(document, element, "DemandFeatureIndicator", "");
		insertData(document, element, "EscrowAbsenceReasonType", ""); 
		insertData(document, element, "EscrowIndicator", Convertor.booleanToString(loanTermsIntialEscrow.isEscrowIndicator()));
		//insertData(document, element, "InterestOnlyIndicator",Boolean.toString( loanTermsPI.isInterestOnlyIndicator()));
		System.out.println("insertLoanDetail");
		insertData(document, element, "InterestRateIncreaseIndicator",Boolean.toString(loanTermsInterestRate.isInterestRateIncreaseIndicator()));
		insertData(document, element, "LoanAmountIncreaseIndicator", "");//TODO Need to add this data to the object "LoanTermsLoanAmount"
		insertData(document, element, "LoanLevelCreditScoreValue", ""); //TODO Not Found in UCD-Spec
		insertData(document, element, "MIRequiredIndicator",Convertor.booleanToString(jsonDocument.getPageOne().getLoanInformation().isMiRequiredIndicator()));
		insertData(document, element, "NegativeAmortizationIndicator",Convertor.booleanToString(loanTermsLoanAmount.isNegativeAmoritzationIndicator()));
		insertData(document, element, "PaymentIncreaseIndicator", ""); //TODO Need to add this to Object 
		insertData(document, element, "PrepaymentPenaltyIndicator", Convertor.booleanToString(loanTermsPrepaymentPenalty.isPrepaymentPenaltyIndicator()));
		insertData(document, element, "SeasonalPaymentFeatureIndicator", "");
		insertData(document, element, "StepPaymentsFeatureDescription", "");//TODO Not Found in UCD-Spec
		insertData(document, element, "TotalSubordinateFinancingAmount", "");
		insertExtension(document, insertLevels(document, element, "EXTENSION"), jsonDocument);
	}
	*//**
     * Inserts Late Charge Rule from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertLateChargeRule(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "LateChargeAmount", "");
		insertData(document, element, "LateChargeGracePeriodDaysCount", "");
		insertData(document, element, "LateChargeMaximumAmount", "");
		insertData(document, element, "LateChargeMinimumAmount", "");
		insertData(document, element, "LateChargeRatePercent", "");
		insertData(document, element, "LateChargeType", "");
	}
	*//**
     * Inserts Interest Only from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertInterestOnly(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//insertData(document, element, "InterestOnlyTermMonthsCount", jsonDocument.getPageOne().getLoanTerms().getLoanTermsPI().getInterestOnlyTermMonthsCount());
		System.out.println("insertInterestOnly");
	}
	*//**
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
	*//**
     * Inserts High Cost Mortgages from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertHighCostMortgages(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
			insertHighCostMortgage(document, insertLevels(document, element, "HIGH_COST_MORTGAGE"), jsonDocument);
	}
	*//**
     * Inserts High Cost Mortgage from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertHighCostMortgage(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "AveragePrimeOfferRatePercent", "");
		insertData(document, element, "RegulationZExcludedBonaFideDiscountPointsIndicator", "");
		insertData(document, element, "RegulationZExcludedBonaFideDiscountPointsPercent", "");
		insertData(document, element, "RegulationZTotalAffiliateFeesAmount", "");
		insertData(document, element, "RegulationZTotalLoanAmount", "");
		insertData(document, element, "RegulationZTotalPointsAndFeesAmount", "");
	}
	*//**
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
     * Inserts Foreclosures from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertForeclosures(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
			insertForeclosure(document, insertLevels(document, element, "FORECLOSURE"), jsonDocument);
	}
	*//**
     * Inserts Foreclosure from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertForeclosure(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertForeclosureDetail(document, insertLevels(document, element, "FORECLOSURE_DETAIL"), jsonDocument);
	}
	*//**
     * Inserts Foreclosure Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertForeclosureDetail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "DeficiencyRightsPreservedIndicator", "");
	}
	*//**
     * Inserts Fee Information from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertFeeInformation(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertFees(document, insertLevels(document, element, "FEES"), jsonDocument);
		insertFeeSummaryDetail(document, insertLevels(document, element, "FEES_SUMMARY/FEE_SUMMARY_DETAIL"), jsonDocument);
	}
	*//**
     * Inserts Fee Summary Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertFeeSummaryDetail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "APRPercent", "");
		insertData(document, element, "FeeSummaryTotalAmountFinancedAmount", "");
		insertData(document, element, "FeeSummaryTotalFinanceChargeAmount", "");
		insertData(document, element, "FeeSummaryTotalInterestPercent", "");
		insertData(document, element, "FeeSummaryTotalOfAllPaymentsAmount", "");
	}
	*//**
     * Inserts Fees from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertFees(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
			insertFee(document, insertLevels(document, element, "FEE"), jsonDocument);
	}
	*//**
     * Inserts Fee from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertFee(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertFeeDetail(document,  insertLevels(document, element, "FEE_DETAIL"), jsonDocument);
		insertFeePaidTo(document, 	insertLevels(document, element, "FEE_PAID_TO"), jsonDocument);
		insertFeePayments(document, insertLevels(document, element, "FEE_PAYMENTS"), jsonDocument);
	}
	*//**
     * Inserts Fee Payments from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertFeePayments(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
			insertFeePayment(document,	insertLevels(document, element, "FEE_PAYMENT"), jsonDocument);
	}
	*//**
     * Inserts Fee Payment from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertFeePayment(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "FeeActualPaymentAmount", "");
		insertData(document, element, "FeePaymentPaidByType", "");
		insertData(document, element, "FeePaymentPaidOutsideOfClosingIndicator", "");
	}
	*//**
     * Inserts Fee Paid To from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertFeePaidTo(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertLegalEntity(document,	insertLevels(document, element, "LEGAL_ENTITY"), jsonDocument);
	}
	*//**
     * Inserts Fee Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertFeeDetail(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "BorrowerChosenProviderIndicator", "");
		insertData(document, element, "FeeActualTotalAmount", "");
		insertData(document, element, "FeeEstimatedTotalAmount", "");
		insertData(document, element, "FeePaidToType", "");
		insertData(document, element, "FeePaidToTypeOtherDescription", "");
		insertData(document, element, "FeePercentBasisType", "");
		insertData(document, element, "FeeTotalPercent", "");
		Element FeeTypeelement = insertData(document, element, "FeeType", "");
		FeeTypeelement.setAttribute("gse:DisplayLabelText", "");
		insertData(document, element, "FeeTypeOtherDescription", "");
		insertData(document, element, "IntegratedDisclosureSectionType", "");
		insertData(document, element, "OptionalCostIndicator", "");
		insertData(document, element, "RegulationZPointsAndFeesIndicator", "");
		insertData(document, element, "RequiredProviderOfServiceIndicator", "");
		insertExtension(document, insertLevels(document, element, "EXTENSION"), jsonDocument);
	}
	*//**
     * Inserts Escrow from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertEscrow(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertEscrowDetail(document, insertLevels(document, element, "ESCROW_DETAIL"), jsonDocument);
		insertEscrowItems(document, insertLevels(document, element, "ESCROW_ITEMS"), jsonDocument);
	}
	*//**
     * Inserts Escrow Items from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertEscrowItems(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
			insertEscrowItem(document, insertLevels(document, element, "ESCROW_ITEM"), jsonDocument);
	}
	*//**
     * Inserts Escrow Item from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertEscrowItem(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertEscrowItemDetail(document, insertLevels(document, element, "ESCROW_ITEM_DETAIL"), jsonDocument);
		insertEscrowItemPayments(document,  insertLevels(document, element, "ESCROW_ITEM_PAYMENTS"), jsonDocument);
	}
	*//**
     * Inserts Escrow Item Payments from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertEscrowItemPayments(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
			insertEscrowItemPayment(document, insertLevels(document, element, "ESCROW_ITEM_PAYMENT"), jsonDocument);
	}
	*//**
     * Inserts Escrow Item Payment from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertEscrowItemPayment(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "EscrowItemActualPaymentAmount", "");
		insertData(document, element, "EscrowItemPaymentPaidByType", "");
		insertData(document, element, "EscrowItemPaymentTimingType", "");
	}
	*//**
     * Inserts Escrow Item Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertEscrowItemDetail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "EscrowCollectedNumberOfMonthsCount", "");
		insertData(document, element, "EscrowItemCategoryType", "");
		insertData(document, element, "EscrowItemEstimatedTotalAmount", "");
		insertData(document, element, "EscrowItemType", "");
		element.setAttribute("gse:DisplayLabelText", "");
		insertData(document, element, "EscrowItemTypeOtherDescription", "");
		insertData(document, element, "EscrowMonthlyPaymentAmount", "");
		insertData(document, element, "FeePaidToType", "");
		insertData(document, element, "FeePaidToTypeOtherDescription", "");
		insertData(document, element, "IntegratedDisclosureSectionType", "");
		insertData(document, element, "RegulationZPointsAndFeesIndicator", "");
		insertExtension(document, insertLevels(document, element, "EXTENSION"), jsonDocument);
	}
	*//**
     * Inserts Escrow Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertEscrowDetail(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "EscrowAggregateAccountingAdjustmentAmount", "");
	}
	*//**
     * Inserts Document Specific DataSet from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertDocumentSpecificDataSet(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertExecution(document, insertLevels(document, element, "EXECUTION"), jsonDocument);
		insertIntegratedDisclosure(document, insertLevels(document, element, "INTEGRATED_DISCLOSURE"), jsonDocument);
		insertURLA(document, insertLevels(document, element, "URLA"), jsonDocument);
	}
	*//**
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
     *//*
	private void insertIntegratedDisclosure(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub

		insertCashToCloseItems(document, insertLevels(document, element, "CASH_TO_CLOSE_ITEMS"), jsonDocument);
		insertEstimatedPropertyCost(document, insertLevels(document, element, "ESTIMATED_PROPERTY_COST"), jsonDocument);
		insertIntegratedDisclosureDetail(document, insertLevels(document, element, "INTEGRATED_DISCLOSURE_DETAIL"), jsonDocument);
		insertIntegratedDisclosureSectionSummaries(document, insertLevels(document, element, "INTEGRATED_DISCLOSURE_SECTION_SUMMARIES"), jsonDocument);
		insertProjectedPayments(document, insertLevels(document, element, "PROJECTED_PAYMENTS"), jsonDocument);
	}
	*//**
     * Inserts Projected Payments from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertProjectedPayments(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		List<ProjectedPayments> projectedPayments = jsonDocument.getPageOne().getProjectedPayments();
		for (projectedPayment projectedPayment : projectedPayments)
			insertProjectedPayment(document, insertLevels(document, element, "PROJECTED_PAYMENT"), jsonDocument);//TODO Need to implement as Individual Object
	}
	*//**
     * Inserts Projected Payment from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertProjectedPayment(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//insertAttributeValue(xmlout, parentElement, "SequenceNumber", "");
		
		element.setAttribute("SequenceNumber", "");
		insertData(document, element, "PaymentFrequencyType", "");
		insertData(document, element, "ProjectedPaymentCalculationPeriodEndNumber", "");
		insertData(document, element, "ProjectedPaymentCalculationPeriodStartNumber", "");
		insertData(document, element, "ProjectedPaymentCalculationPeriodTermType", "");
		insertData(document, element, "ProjectedPaymentCalculationPeriodTermTypeOtherDescription", "");
		insertData(document, element, "ProjectedPaymentEstimatedEscrowPaymentAmount", "");
		insertData(document, element, "ProjectedPaymentEstimatedTotalMaximumPaymentAmount", "");
		insertData(document, element, "ProjectedPaymentEstimatedTotalMinimumPaymentAmount", "");
		insertData(document, element, "ProjectedPaymentMIPaymentAmount", "");
		insertData(document, element, "ProjectedPaymentPrincipalAndInterestMaximumPaymentAmount", "");
		insertData(document, element, "ProjectedPaymentPrincipalAndInterestMinimumPaymentAmount", "");
	}
	*//**
     * Inserts Integrated Disclosure Section Summaries from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertIntegratedDisclosureSectionSummaries(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
        List<IntegratedDisclosureSectionSummaries> IntegratedDisclosureSectionSummaries = jsonDocument.getPageXXX().getIntegratedDisclosureSectionSummaries();
		for (IntegratedDisclosureSectionSummary IntegratedDisclosureSectionSummary : IntegratedDisclosureSectionSummaries) //TODO Not Implemented
			insertIntegratedDisclosureSectionSummary(document, insertLevels(document, element, "INTEGRATED_DISCLOSURE_SECTION_SUMMARY"), jsonDocument);
	}
	*//**
     * Inserts Integrated Disclosure Section Summary from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertIntegratedDisclosureSectionSummary(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertIntegratedDisclosureSectionSummaryDetail(document, insertLevels(document, element, "INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL"), jsonDocument);
		insertIntegratedDisclosureSubsectionPayments(document, insertLevels(document, element, "INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENTS"), jsonDocument);
	}
	*//**
     * Inserts Integrated Disclosure Subsection Payments from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertIntegratedDisclosureSubsectionPayments(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
			insertIntegratedDisclosureSubsectionPayment(document, insertLevels(document, element, "INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENT"), jsonDocument);
	}
	*//**
     * Inserts Integrated Disclosure Subsection Payment from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertIntegratedDisclosureSubsectionPayment(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "IntegratedDisclosureSubsectionPaidByType", "");
		insertData(document, element, "IntegratedDisclosureSubsectionPaymentAmount", "");
		insertData(document, element, "IntegratedDisclosureSubsectionPaymentTimingType","");
		//TODO Need To Add the Object
	}
	*//**
     * Inserts Integrated Disclosure Section Summary Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertIntegratedDisclosureSectionSummaryDetail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//ID_SubsectionModel ID_SubsectionModel = jsonDocument.getPageThree().getSummariesofTransactions().get
		insertData(document, element, "IntegratedDisclosureSectionTotalAmount", "");
		insertData(document, element, "IntegratedDisclosureSectionType", "");
		insertData(document, element, "IntegratedDisclosureSubsectionTotalAmount", "");
		insertData(document, element, "IntegratedDisclosureSubsectionType", "");
		insertData(document, element, "IntegratedDisclosureSubsectionTypeOtherDescription", "");
		insertData(document, element, "LenderCreditToleranceCureAmount", "");
	}
	*//**
     * Inserts Estimated Property Cost from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertEstimatedPropertyCost(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertEstimatedPropertyCostComponents(document, insertLevels(document, element, "ESTIMATED_PROPERTY_COST_COMPONENTS"), jsonDocument);
		insertEstimatedPropertyCostDetail(document, insertLevels(document, element, "ESTIMATED_PROPERTY_COST_DETAIL"), jsonDocument);
	}
	*//**
     * Inserts Estimated Property Cost Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertEstimatedPropertyCostDetail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		System.out.println("insertEstimatedPropertyCostDetail");
	//	insertData(document, element, "ProjectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount", jsonDocument.getPageOne().getProjectedPayments().getProjectedPaymentsETIA().getAmount());
	}
	*//**
     * Inserts Estimated Property Cost Components from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertEstimatedPropertyCostComponents(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//element.setAttribute("gse:DisplayLabelText", estimatedPropertyCostComponents.getgseDispalyLabelText()); //TODO Data Not found for this field
		System.out.println("insertEstimatedPropertyCostComponents");
		List<ETIA> eTIA = jsonDocument.getPageOne().getLoanTerms().getLoanTermsETIA();
		for (ETIA ETIA : eTIA)
			insertEstimatedPropertyCostComponent(document, insertLevels(document, element, "ESTIMATED_PROPERTY_COST_COMPONENT"), ETIA);
	}
	*//**
     * Inserts Estimated Property Cost Component from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertEstimatedPropertyCostComponent(Document document, Element element,
			ETIA eTIA) {
		// TODO Auto-generated method stub
		
		insertData(document, element, "ProjectedPaymentEscrowedType", eTIA.getProjectedPaymentEscrowedType());
		insertData(document, element, 
				"ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType", eTIA.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType()); //TODO Need to Add Object Data
		insertData(document, element,
				"ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription", eTIA.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription());
	
	}
	*//**
     * Inserts Cash To Close Items from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertCashToCloseItems(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		List<CashToCloseModel> cashToCloseItem = jsonDocument.getPageThree().getCashToCloses();
		for(CashToCloseModel cashToCloseModel : cashToCloseItem) //TODO Object Not Implemented
			insertCashToCloseItem(document,	insertLevels(document, element, "CASH_TO_CLOSE_ITEM"), jsonDocument);
	}
	*//**
     * Inserts Cash To Close Item from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertCashToCloseItem(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
			insertData(document, element, "IntegratedDisclosureCashToCloseItemAmountChangedIndicator", "cashToCloseModel.getIsAmountChangedIndicator()");
			insertData(document, element, "IntegratedDisclosureCashToCloseItemChangeDescription", "cashToCloseModel.getItemChangeDescription()");
			insertData(document, element, "IntegratedDisclosureCashToCloseItemEstimatedAmount", "cashToCloseModel.getItemEstimatedAmount()");
			insertData(document, element, "IntegratedDisclosureCashToCloseItemFinalAmount", "cashToCloseModel.getItemFinalAmount()");
			insertData(document, element, "IntegratedDisclosureCashToCloseItemPaymentType", "cashToCloseModel.getItemPaymentType()");
			insertData(document, element, "IntegratedDisclosureCashToCloseItemType", "cashToCloseModel.getItemPaymentType()");
	}
	*//**
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
	*//**
     * Inserts Construction from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertConstruction(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		LoanInformation loanInformation = jsonDocument.getPageOne().getLoanInformation();
		insertData(document, element, "ConstructionLoanTotalTermMonthsCount", loanInformation.getConstructionLoanTotalTermMonthsCount());
		insertData(document, element, "ConstructionLoanType", loanInformation.getConstructionLoanType());
		insertData(document, element, "ConstructionPeriodNumberOfMonthsCount", loanInformation.getConstructionPeriodNumberOfMonthsCount());
	}
	*//**
     * Inserts Buydown from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertBuydown(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertBuydownOccurences(document ,insertLevels(document, element, "BUYDOWN_OCCURRENCES"), jsonDocument);
		insertBuydownRule(document ,insertLevels(document, element, "BUYDOWN_RULE"), jsonDocument);
	}
	*//**
     * Inserts Buydown Rule from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertBuydownRule(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		LoanTermsInterestRate loanTermsInterestRate = jsonDocument.getPageOne().getLoanTerms().getLoanTermsInterestRate();
		insertData(document, element, "BuydownChangeFrequencyMonthsCount", loanTermsInterestRate.getBuydownChangeFrequencyMonthsCount());
		insertData(document, element, "BuydownDurationMonthsCount", "");//TODO Field data Not found
		insertData(document, element, "BuydownIncreaseRatePercent", loanTermsInterestRate.getBuydownIncreaseRatePercent());
		insertExtension(document, insertLevels(document, element, "EXTENSION"), jsonDocument);
	}
	*//**
     * Inserts Buydown Occurences from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertBuydownOccurences(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		List<BuyDownOccurance> buyDownOccurances = jsonDocument.getPageXXX().getBuyDownOccurance();
		for (BuyDownOccurance buyDownOccurance : buyDownOccurances)
			insertBuydownOccurence(document ,insertLevels(document, element, "BUYDOWN_OCCURRENCES"), jsonDocument);//TODO Need To Add the Object
	}
	*//**
     * Inserts Buydown Occurence from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertBuydownOccurence(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		LoanTermsInterestRate loanTermsInterestRate = jsonDocument.getPageOne().getLoanTerms().getLoanTermsInterestRate();
		insertData(document, element, "BuydownInitialEffectiveInterestRatePercent", loanTermsInterestRate.getBuydownInitialEffectiveInterestRatePercent());
	}
	*//**
     * Inserts Closing Information from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertClosingInformation(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertClosingAdjustmentItems(document ,insertLevels(document, element, "CLOSING_ADJUSTMENT_ITEMS"), jsonDocument);
		insertClosingCostFunds(document ,insertLevels(document, element, "CLOSING_COST_FUNDS"), jsonDocument);
		insertClosingInformationDetail(document,insertLevels(document, element, "CLOSING_INFORMATION_DETAIL"), jsonDocument);
		insertPrepaidItems(document ,insertLevels(document, element, "PREPAID_ITEMS"), jsonDocument);
		insertProrationItems(document ,insertLevels(document, element, "PRORATION_ITEMS"), jsonDocument);
	}
	*//**
     * Inserts Proration Items from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertProrationItems(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		List<ProrationItems> prorationItems = jsonDocument.getPageOne().getClosingInformation().getProrationItems();
		for (ProrationItem prorationItem : prorationItems)
			insertProrationItem(document, insertLevels(document, element, "PRORATION_ITEM"), jsonDocument);//TODO Need To Add the Object
	}
	*//**
     * Inserts Proration Item from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertProrationItem(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "IntegratedDisclosureSectionType", "");
		insertData(document, element, "IntegratedDisclosureSubsectionType", "");
		insertData(document, element, "ProrationItemAmount", "");
		insertData(document, element, "ProrationItemPaidFromDate", "");
		insertData(document, element, "ProrationItemPaidThroughDate", "");
		Element prorationItemTypeElement = insertData(document, element, "ProrationItemType", "");
		prorationItemTypeElement.setAttribute("gse:DisplayLabelText", "");
		//insertAttributeValue(xmlout, prorationItemTypeElement, "gse:DisplayLabelText", "");
		insertData(document, element, "ProrationItemTypeOtherDescription", "");
		//TODO Need To Add the Object
	}
	*//**
     * Inserts Prepaid Items from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertPrepaidItems(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		List<PrepaidItems> prepaidItems = jsonDocument.getPageOne().getClosingInformation().getPrepaidItems();
		for (PrepaidItem prepaidItem : prepaidItems)
			insertPrepaidItem(document, insertLevels(document, element, "PREPAID_ITEM"), jsonDocument);
	}
	*//**
     * Inserts Prepaid Item from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertPrepaidItem(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub

		insertPrepaidItemDetail(document, insertLevels(document, element, "PREPAID_ITEM_DETAIL"), jsonDocument);
		insertPrepaidItemPaidTo(document, insertLevels(document, element, "PREPAID_ITEM_PAID_TO"), jsonDocument);
		insertPrepaidItemPayments(document, insertLevels(document, element, "PREPAID_ITEM_PAYMENTS"), jsonDocument);
	}
	*//**
     * Inserts Prepaid Item Payments from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertPrepaidItemPayments(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		List<PrepaidItemPayments> prepaidItemPayments = jsonDocument.getPageOne().getClosingInformation().getPrepaidItems().getPrepaidItemPayments();
		for (PrepaidItemPayment prepaidItemPayment : prepaidItemPayments)
			insertPrepaidItemPayment(document, insertLevels(document, element, "PREPAID_ITEM_PAYMENT"), jsonDocument);
	}
	*//**
     * Inserts Prepaid Item Payment from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertPrepaidItemPayment(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "PrepaidItemActualPaymentAmount", "");
		insertData(document, element, "PrepaidItemPaymentPaidByType", "");
		insertData(document, element, "PrepaidItemPaymentTimingType", "");
		insertData(document, element, "RegulationZPointsAndFeesIndicator", "");
		//TODO Need To Add the Object
	}
	*//**
     * Inserts Prepaid Item Paid To from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertPrepaidItemPaidTo(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertLegalEntity(document, insertLevels(document, element, "LEGAL_ENTITY"), jsonDocument );
	}
	*//**
     * Inserts Prepaid Item Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertPrepaidItemDetail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "FeePaidToType", "");
		insertData(document, element, "FeePaidToTypeOtherDescription", "");
		insertData(document, element, "IntegratedDisclosureSectionType", "");
		insertData(document, element, "PrepaidItemEstimatedTotalAmount", "");// TODO Value Not binded with object 
		insertData(document, element, "PrepaidItemMonthsPaidCount", "");
		insertData(document, element, "PrepaidItemNumberOfDaysCount", "");// TODO Value Not binded with object 
		insertData(document, element, "PrepaidItemPaidFromDate", "");
		insertData(document, element, "PrepaidItemPaidThroughDate", "");
		insertData(document, element, "PrepaidItemPerDiemAmount", "");
		insertData(document, element, "PrepaidItemPerDiemCalculationMethodType", "");
		Element prepaidItemTypeElement = insertData(document, element, "PrepaidItemType", "");
		prepaidItemTypeElement.setAttribute("gse:DisplayLabelText", "");// TODO Value Not binded with object
		//insertAttributeValue(xmlout, prepaidItemTypeElement, "gse:DisplayLabelText", "");
		insertData(document, element, "PrepaidItemTypeOtherDescription", "");
		insertData(document, element, "RegulationZPointsAndFeesIndicator", "");
		insertExtension(document,insertLevels(document, element, "PREPAID_ITEM_PAYMENTS"), jsonDocument);
		//TODO Need To Add the Object
	}
	*//**
     * Inserts Closing Cost Funds from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertClosingCostFunds(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		List<ClosingCostFunds> ClosingCostFunds = jsonDocument.getPageOne().getClosingInformation().getClosingCostFunds();
		for (ClosingCostFunds closingCostFunds : ClosingCostFunds)
			insertClosingCostFund(document ,insertLevels(document, element, "CLOSING_COST_FUND"), jsonDocument);
	}
	*//**
     * Inserts Closing Cost Fund from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertClosingCostFund(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "ClosingCostFundAmount", "");
		insertData(document, element, "FundsType", "");
		insertData(document, element, "IntegratedDisclosureSectionType", "");
	}
	*//**
     * Inserts Closing Adjustment Items from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertClosingAdjustmentItems(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		List<ClosingAdjustmentItem> closingAdjustmentItems = jsonDocument.getPageThree().getClosingAdjustmentItem();
		for (ClosingAdjustmentItem closingAdjustmentItem : closingAdjustmentItems)
			insertClosingAdjustmentItem(document, insertLevels(document, element, "CLOSING_ADJUSTMENT_ITEM"), jsonDocument);
	}
	*//**
     * Inserts Closing Adjustment Item from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertClosingAdjustmentItem(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub

		insertClosingAdjustmentItemDetail(document,insertLevels(document, element, "CLOSING_ADJUSTMENT_ITEM_DETAIL"), jsonDocument);
		insertClosingAdjustmentItemPaidBy(document,insertLevels(document, element, "CLOSING_ADJUSTMENT_ITEM_PAID_BY"), jsonDocument);
		insertLegalEntityDetail(document,insertLevels(document, element, "EXTENSION/OTHER/gse:CLOSING_ADJUSTMENT_ITEM_PAID_TO/LEGAL_ENTITY/LEGAL_ENTITY_DETAIL/"), jsonDocument);
	
	}
	*//**
     * Inserts Closing Adjustment Item Paid By from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertClosingAdjustmentItemPaidBy(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub

		insertLegalEntity(document,insertLevels(document, element, "LEGAL_ENTITY"), jsonDocument);
		insertIndividual(document,insertLevels(document, element, "INDIVIDUAL"), jsonDocument);
	}
	*//**
     * Inserts Individual from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertIndividual(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertContactPoints(document,insertLevels(document, element, "CONTACT_POINTS"), jsonDocument);
		insertName(document,insertLevels(document, element, "NAME"), jsonDocument);
	}
	*//**
     * Inserts Name from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertName(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "FirstName", "");
		insertData(document, element, "FullName", "");
		insertData(document, element, "LastName", "");
		insertData(document, element, "MiddleName", "");
		insertData(document, element, "SuffixName", "");
	}
	*//**
     * Inserts Contact Points from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertContactPoints(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		List<ContactPoints> contactPoints = jsonDocument.getPageOne().getClosingInformation().getClosingAdjustmentItems().getClosingAdjustmentItem().getClosingAdjustmentItemPaidBy().getIndividual().getContactPoints();
		for (ContactPoints contactPoint : contactPoints)
			insertContactPoint(document, insertLevels(document, element, "CONTACT_POINT"), jsonDocument);
	
	}
	*//**
     * Inserts Contact Point from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertContactPoint(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertContactPointEmail(document, insertLevels(document, element, "CONTACT_POINT_EMAIL"), jsonDocument);
		insertContactPointTelephone(document, insertLevels(document, element, "CONTACT_POINT_TELEPHONE"), jsonDocument);
	}
	*//**
     * Inserts Contact Point Telephone from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertContactPointTelephone(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "ContactPointTelephoneValue","");
	}
	*//**
     * Inserts Contact Point Email from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertContactPointEmail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "ContactPointEmailValue","");
	}
	*//**
     * Inserts Legal Entity from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertLegalEntity(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertLegalEntityDetail(document,insertLevels(document, element, "LEGAL_ENTITY_DETAIL"), jsonDocument);
	}
	*//**
     * Inserts Legal Entity Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertLegalEntityDetail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//LegalEntityDetail legalEntityDetail = jsonDocument.getPageOne().getClosingInformation().getClosingAdjustmentItems().getClosingAdjustmentItem().getClosingAdjustmentItemPaidBy().getLegalEntity().getLegalEntityDetail();
		insertData(document, element, "FullName", "");
		insertData(document, element, "GlobalLegalEntityIdentifier", "");
	}
	*//**
     * Inserts Closing Adjustment Item Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertClosingAdjustmentItemDetail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "ClosingAdjustmentItemAmount", "");
		insertData(document, element, "ClosingAdjustmentItemPaidOutsideOfClosingIndicator", "");
		Element closingAdjustmentItemTypeElement = insertData(document, element, "ClosingAdjustmentItemType", "");
		closingAdjustmentItemTypeElement.setAttribute("gse:DisplayLabelText", "");
		//insertAttribute(document, closingAdjustmentItemTypeElement, "gse:DisplayLabelText", jsonDocument);
		insertData(document, element, "ClosingAdjustmentItemTypeOtherDescription", "");
		insertData(document, element, "IntegratedDisclosureSectionType", "");
		insertData(document, element, "IntegratedDisclosureSubsectionType", "");
	
	}
	*//**
     * Inserts Amortization Rule from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertAmortizationRule(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document ,element ,"AmortizationType" , jsonDocument.getPageOne().getLoanInformation().getAmortizationType());
	}
	*//**
     * Inserts Adjustment from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertAdjustment(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertInterestRateAdjustment(document ,insertLevels(document, element, "INTEREST_RATE_ADJUSTMENT"), jsonDocument);
		insertPrincipalAndInterestPaymentAdjustment(document ,insertLevels(document, element, "PRINCIPAL_AND_INTEREST_PAYMENT_ADJUSTMENT"), jsonDocument);
	}
	*//**
     * Inserts Principal And Interest Payment Adjustment from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertPrincipalAndInterestPaymentAdjustment(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertPrincipalAndInterestPaymentLifetimeAdjustmentRule(document ,insertLevels(document, element, "PRINCIPAL_AND_INTEREST_PAYMENT_LIFETIME_ADJUSTMENT_RULE"), jsonDocument);
		insertPrincipalAndInterestPaymentPerChangeAdjustmentRules(document ,insertLevels(document, element, "PRINCIPAL_AND_INTEREST_PAYMENT_PER_CHANGE_ADJUSTMENT_RULES"), jsonDocument);
	}
	*//**
     * Inserts Principal And Interest Payment Per Change Adjustment Rules from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertPrincipalAndInterestPaymentPerChangeAdjustmentRules(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		List<PrincipalAndInterestPaymentPerChangeAdjustmentRules> principalAndInterestPaymentPerChangeAdjustmentRules = jsonDocument.getPageFour().getPrincipalAndInterestPaymentPerChangeAdjustmentRule();
		for (PrincipalAndInterestPaymentPerChangeAdjustmentRule principalAndInterestPaymentPerChangeAdjustmentRule : principalAndInterestPaymentPerChangeAdjustmentRules)
			insertPrincipalAndInterestPaymentPerChangeAdjustmentRule(document,insertLevels(document, element, "PRINCIPAL_AND_INTEREST_PAYMENT_PER_CHANGE_ADJUSTMENT_RULE"),jsonDocument);
	}
	*//**
     * Inserts Principal And Interest Payment Per Change Adjustment Rule from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertPrincipalAndInterestPaymentPerChangeAdjustmentRule(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		LoanTermsPI loanTermsPI = jsonDocument.getPageOne().getLoanTerms().getLoanTermsPI();
		insertData(document,element, "AdjustmentRuleType", loanTermsPI.getAdjustmentRuleType());
		insertData(document,element, "PerChangeMaximumPrincipalAndInterestPaymentAmount", ""); //TODO Value not binded to Object
		insertData(document,element, "PerChangeMinimumPrincipalAndInterestPaymentAmount", ""); //TODO Value not binded to Object
		insertData(document,element, "PerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount", loanTermsPI.getPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount());
	}
	*//**
     * Inserts Principal And Interest Payment Lifetime Adjustment Rule from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertPrincipalAndInterestPaymentLifetimeAdjustmentRule(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		LoanTermsPI loanTermsPI = jsonDocument.getPageOne().getLoanTerms().getLoanTermsPI();
		insertData(document, element, "FirstPrincipalAndInterestPaymentChangeMonthsCount",loanTermsPI.getFirstPrincipalAndInterestPaymentChangeMonthsCount() );
		insertData(document, element, "PrincipalAndInterestPaymentMaximumAmount", loanTermsPI.getPrincipalAndInterestPaymentMaximumAmount());
		insertData(document, element, "PrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount", loanTermsPI.getPrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount());
	}
	*//**
     * Inserts Interest Rate Adjustment from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertInterestRateAdjustment(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertIndexRules(document ,insertLevels(document, element, "INDEX_RULES"), jsonDocument);
		insertInterestRateLifetimeAdjustmentRule(document ,insertLevels(document, element, "INTEREST_RATE_LIFETIME_ADJUSTMENT_RULE"), jsonDocument);
		insertInterestRatePerChangeAdjustmentRules(document ,insertLevels(document, element, "INTEREST_RATE_PER_CHANGE_ADJUSTMENT_RULES"), jsonDocument);
	}
	*//**
     * Inserts Interest Rate Per Change Adjustment Rules from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertInterestRatePerChangeAdjustmentRules(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		List<InterestRatePerChangeAdjustmentRule> interestRatePerChangeAdjustmentRules = jsonDocument.getPageFour().getInterestRatePerChangeAdjustmentRule();
		for (InterestRatePerChangeAdjustmentRule interestRatePerChangeAdjustmentRule : interestRatePerChangeAdjustmentRules)
			insertInterestRatePerChangeAdjustmentRule(document ,insertLevels(document, element, "INTEREST_RATE_PER_CHANGE_ADJUSTMENT_RULE"), jsonDocument);
		
	}
	*//**
     * Inserts Interest Rate Per Change Adjustment Rule from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertInterestRatePerChangeAdjustmentRule(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		LoanTerms loanTerms = jsonDocument.getPageOne().getLoanTerms();
		LoanTermsInterestRate loanTermsInterestRate = loanTerms.getLoanTermsInterestRate();
		insertData(document ,element , "AdjustmentRuleType", loanTermsInterestRate.getAdjustmentRuleTypeFirst());
		insertData(document ,element , "PerChangeMaximumIncreaseRatePercent", "");
		insertData(document ,element , "PerChangeRateAdjustmentFrequencyMonthsCount", loanTermsInterestRate.getPerChangeRateAdjustmentFrequencyMonthsCount());
	}                                
	*//**
     * Inserts Interest Rate Lifetime Adjustment Rule from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertInterestRateLifetimeAdjustmentRule(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		LoanTerms loanTerms = jsonDocument.getPageOne().getLoanTerms();
		LoanTermsInterestRate loanTermsInterestRate = loanTerms.getLoanTermsInterestRate();
		insertData(document, element, "CeilingRatePercent", loanTermsInterestRate.getCeilingRatePercent());
		insertData(document, element, "CeilingRatePercentEarliestEffectiveMonthsCount", loanTermsInterestRate.getCeilingRatePercentEarliestEffectiveMonthsCount());
		insertData(document, element, "FirstRateChangeMonthsCount", "FirstRateChangeMonthsCount");
		insertData(document, element, "FloorRatePercent", "FloorRatePercent");
		insertData(document, element, "MarginRatePercent", "MarginRatePercent");
		insertExtension(document ,insertLevels(document, element, "EXTENSION"), jsonDocument);
		
	}
	*//**
     * Inserts Extension from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertExtension(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertMismo(document ,insertLevels(document, element, "MISMO") ,jsonDocument);
		insertOther(document ,insertLevels(document, element, "OTHER") ,jsonDocument);
	}
	*//**
     * Inserts Other from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertOther(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		
		insertData(document, element, GSE_ALIAS + ":BuydownReflectedInNoteIndicator","");
		insertData(document, element, GSE_ALIAS + ":DocumentSignatureRequiredIndicator", "");
		insertData(document, element, GSE_ALIAS + ":EscrowAccountRolloverAmount", "");
		insertData(document, element,
				GSE_ALIAS + ":IntegratedDisclosureEstimatedClosingCostsExpirationTimezoneType", "");
		insertData(document, element, GSE_ALIAS + ":IntegratedDisclosureSectionType", "");
		insertData(document, element, GSE_ALIAS + ":LiabilitySecuredBySubjectPropertyIndicator", "");
		insertData(document, element, GSE_ALIAS + ":LockExpirationTimezoneType","");
		insertData(document, element, GSE_ALIAS + ":TotalOptionalPaymentCount", "");
		insertData(document, element, GSE_ALIAS + ":TotalStepCount", "");
		insertData(document, element, GSE_ALIAS + ":TotalStepPaymentCount", "");
		insertData(document, element, GSE_ALIAS + ":SubordinateFinancingIsNewIndicator", "");
	}
	*//**
     * Inserts Mismo from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertMismo(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "PaymentIncludedInAPRIndicator", "");
		insertData(document, element, "PayoffPartialIndicator", "");
	}
	*//**
     * Inserts Index Rules from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertIndexRules(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub 
		//IndexRules Found in Page 4 AdjustableRateSection
		List<IndexRule> indexRules = jsonDocument.getPageFour().getAdjustableRateSection();
		for (IndexRule indexRule : indexRules)
			insertIndexRule(document, element, "INDEX_RULE", jsonDocument);
	}
	*//**
     * Inserts Index Rule from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertIndexRule(Document document, Element element, String string, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "IndexType", "jsonDocument.IndexType");
		insertData(document, element, "IndexTypeOtherDescription", "jsonDocument.IndexTypeOtherDescription");
	}
	*//**
     * Inserts Loan Identifiers from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertLoanIdentifiers(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		LoanInformation loanInformation = jsonDocument.getPageOne().getLoanInformation();
		List<LoanInformationLoanIdentifier> loanInformationLoanIdentifier = loanInformation.getLoanIdentifiers();
		Element loanIdentifier = insertLevels(document, element, "LOAN_IDENTIFIER");
		for(LoanInformationLoanIdentifier loanIdentifiers : loanInformationLoanIdentifier){
		    insertData(document, loanIdentifier, "LoanIdentifier", loanIdentifiers.getLoanIdentifier());
		    insertData(document, loanIdentifier, "LoanIdentifierType", loanIdentifiers.getLoanIdentifierType());
		}
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
	*//**
     * Inserts Maturity Rule from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertMaturityRule(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		LoanInformation loanInformation = jsonDocument.getPageOne().getLoanInformation();
		if (!loanInformation.getLoanTerm().isEmpty()) {
			insertData(document, element, "LoanMaturityPeriodCount", loanInformation.getLoanMaturityPeriodCount());
			insertData(document, element, "LoanMaturityPeriodType", loanInformation.getLoanMaturityPeriodType());
			insertData(document, element, "LoanTermMaximumMonthsCount", "");
		}
	}
    *//**
     * Inserts Message from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertMessage(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		element.setAttribute(XMLNS_ALIAS + ":xsi", XSI_URI);
		element.setAttribute("xsi:schemaLocation", "http://www.mismo.org/residential/2009/schemas ../../../MISMO/V3.3.0_CR_2014-02/ReferenceModel_v3.3.0_B299/MISMO_3.3.0_B299.xsd");
		element.setAttribute(XMLNS_ALIAS + ":" + MISMO_ALIAS, MISMO_URI);
		element.setAttribute(XMLNS_ALIAS + ":" + GSE_ALIAS, GSE_URI);
		element.setAttribute(XMLNS_ALIAS + ":" + XLINK_ALIAS, XLINK_URI);
		element.setAttribute("MISMOReferenceModelIdentifier", "3.3.0299");
		insertAboutVersion(document, insertLevels(document, element, "ABOUT_VERSIONS/ABOUT_VERSION"), jsonDocument);
		insertDocumentSet(document, insertLevels(document, element, "DOCUMENT_SETS/DOCUMENT_SET"), jsonDocument);
	}
    *//**
     * Inserts Parties from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertParties(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
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

		List<Borrower> sellers = jsonDocument.getPageOne().getTransactionInformation().getSeller();
		for (Borrower seller : sellers) {
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

		List<Borrower> lenders = jsonDocument.getPageOne().getTransactionInformation().getLender(); // TODO: There should be two lenders - one individual and one organization
		for (Borrower lender : lenders) {
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
	*//**
     * Inserts Subject Property from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertSubjectProperty(Document document, Element element, ClosingDisclosureDocument jsonDocument) {

		insertAddress(document, insertLevels(document, element, "ADDRESS"), jsonDocument);
		insertUnparsedLegalDescription(document, 
				insertLevels(document, element,"LEGAL_DESCRIPTIONS/LEGAL_DESCRIPTION/UNPARSED_LEGAL_DESCRIPTIONS/UNPARSED_LEGAL_DESCRIPTION"), jsonDocument);
		insertLocationIdentifier(document, insertLevels(document, element, "LOCATION_IDENTIFIER"), jsonDocument);
		insertPropertyDetail(document, insertLevels(document, element, "PROPERTY_DETAIL"), jsonDocument);
		insertPropertyValuations(document, insertLevels(document, element, "PROPERTY_VALUATIONS"), jsonDocument);
		insertSalesContractDetail(document, insertLevels(document, element, "SALES_CONTRACTS/SALES_CONTRACT/SALES_CONTRACT_DETAIL"), jsonDocument);
	
	}
	*//**
     * Inserts Sales Contract Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertSalesContractDetail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		ClosingInformation closingInformation = jsonDocument.getPageOne().getClosingInformation();
		SalesContractDetailModel salesContractDetail = closingInformation.getSalesContractDetail();
		insertData(document, element, "PersonalPropertyAmount", salesContractDetail.getPersonalPropertyAmount());
		insertData(document, element, "PersonalPropertyIncludedIndicator", salesContractDetail.isPersonalPropertyIndicator()+"");
		insertData(document, element, "RealPropertyAmount", salesContractDetail.getRealPropertyAmount());
		insertData(document, element, "SalesContractAmount", salesContractDetail.getSaleContractAmount());
	}
	*//**
     * Inserts Property Valuations from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertPropertyValuations(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		//for (String group : groupings)
			insertPropertyValuation(document, insertLevels(document, element, "PROPERTY_VALUATION"), jsonDocument);
	}
	*//**
     * Inserts Property Valuation from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertPropertyValuation(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertPropertyValuationDetail(document, insertLevels(document, element, "PROPERTY_VALUATION_DETAIL"), jsonDocument);
	}
	*//**
     * Inserts Property Valuation Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*	
	private void insertPropertyValuationDetail(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		Element AppraisalIdentifierelement = insertLevels(document, element, "AppraisalIdentifier");
		AppraisalIdentifierelement.setAttribute("IdentifierOwnerURI", "");
		//insertAttributeValue(xmlout, element, "IdentifierOwnerURI", "");
		insertData(document, element, "PropertyValuationAmount", "");
		insertData(document, element, "PropertyValuationMethodType", "");
		insertData(document, element, "PropertyValuationMethodTypeOtherDescription", "");
	}
	*//**
     * Inserts Property Detail from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertPropertyDetail(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "AffordableUnitsCount", "");
		insertData(document, element, "ConstructionMethodType", "");
		insertData(document, element, "FinancedUnitCount", "");
		insertData(document, element, "MetropolitanDivisionIndicator", "");
		insertData(document, element, "MSAIndicator", "");
		insertData(document, element, "PropertyEstateType", "");
		insertData(document, element, "PropertyEstateTypeOtherDescription", "");
		insertData(document, element, "PropertyEstimatedValueAmount", "");
		insertData(document, element, "PropertyUsageType", "");
	}
	*//**
     * Inserts Location Identifier from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertLocationIdentifier(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertCensusInformation(document, insertLevels(document, element, "CENSUS_INFORMATION"), jsonDocument);
		insertFipsInformation(document, insertLevels(document, element, "FIPS_INFORMATION"), jsonDocument);
	}
	*//**
     * Inserts Fips Information from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*	
	private void insertFipsInformation(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "FIPSCountyCode", "");
	}
	*//**
     * Inserts Census Information from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*	
	private void insertCensusInformation(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "CensusTractIdentifier", "");
	}
	*//**
     * Inserts Address from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertAddress(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		Address address = jsonDocument.getPageOne().getClosingInformation().getProperty();
		insertData(document, element, "AddressLineText", address.getAddressLineText());
		insertData(document, element, "AddressUnitDesignatorType", address.getAddressUnitDesignatorType());
		insertData(document, element, "AddressUnitIdentifier", address.getAddressUnitIdentifier());
		insertData(document, element, "AddressLineText", address.getAddressLineText());
		insertData(document, element, "CityName", address.getCityName());
		insertData(document, element, "PostalCode", address.getPostalCode());
		insertData(document, element, "StateCode", address.getStateCode());
	}
	*//**
     * Inserts Unparsed Legal Description from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertUnparsedLegalDescription(Document document, Element element,
			ClosingDisclosureDocument jsonDocument) {
		// TODO Auto-generated method stub
		insertData(document, element, "UnparsedLegalDescription", "");
	}
	*//**
     * Inserts Terms Of Loan from JSON Object
     * @param document Output XML file
     * @param element parent node of XML
     * @param jsonDocument Input JSON Object
     *//*
	private void insertTermsOfLoan(Document document, Element element, ClosingDisclosureDocument jsonDocument) {
		LoanInformation loanInformation = jsonDocument.getPageOne().getLoanInformation();
		LoanTermsLoanAmount loanTermsLoanAmount = jsonDocument.getPageOne().getLoanTerms().getLoanTermsLoanAmount();
		LoanTermsInterestRate loanTermsInterestRate = jsonDocument.getPageOne().getLoanTerms().getLoanTermsInterestRate();
		insertData(document, element, "AssumedLoanAmount", loanInformation.getLoanType());
		insertData(document, element, "DisclosedFullyIndexedRatePercent", loanInformation.getLoanType());
		insertData(document, element, "LienPriorityType", loanInformation.getLienPriorityType());
		insertData(document, element, "LoanPurposeType", loanInformation.getLoanType());
		insertData(document, element, "MortgageType", loanInformation.getMortgageType());
		insertData(document, element, "MortgageTypeOtherDescription", loanInformation.getMortgageTypeOtherDescription());
		insertData(document, element, "NoteAmount", loanTermsLoanAmount.getNoteAmount());
		insertData(document, element, "NoteRatePercent", loanTermsInterestRate.getNoteRatePercent());
		insertData(document, element, "WeightedAverageInterestRatePercent", "");// TODO Need to add this data to Object
	}*/
}
