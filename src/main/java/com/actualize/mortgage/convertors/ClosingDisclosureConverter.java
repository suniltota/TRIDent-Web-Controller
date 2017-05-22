/**
 * @(#)ClosingDisclosureConverter.java 1.0 04/11/2017
 */

package com.actualize.mortgage.convertors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.cddatamodels.PrepaidItemPayment;
import com.actualize.mortgage.cdpagemodels.ClosingDisclosure;
import com.actualize.mortgage.cdpagemodels.ClosingDisclosureDocumentDetails;
import com.actualize.mortgage.domainmodels.AddressModel;
import com.actualize.mortgage.domainmodels.AutomatedUnderwritingsModel;
import com.actualize.mortgage.domainmodels.Borrower;
import com.actualize.mortgage.domainmodels.CashToClose;
import com.actualize.mortgage.domainmodels.CashToCloseModel;
import com.actualize.mortgage.domainmodels.ClosingAdjustmentItemModel;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsLoanCosts;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsOtherCosts;
import com.actualize.mortgage.domainmodels.ClosingCostFundModel;
import com.actualize.mortgage.domainmodels.ClosingCostProperties;
import com.actualize.mortgage.domainmodels.ClosingCostsTotal;
import com.actualize.mortgage.domainmodels.ClosingInformationDetailModel;
import com.actualize.mortgage.domainmodels.ClosingInformationModel;
import com.actualize.mortgage.domainmodels.ConstructionModel;
import com.actualize.mortgage.domainmodels.ContactInformationDetail;
import com.actualize.mortgage.domainmodels.ContactInformationModel;
import com.actualize.mortgage.domainmodels.CostsAtClosing;
import com.actualize.mortgage.domainmodels.CostsAtClosingCashToClose;
import com.actualize.mortgage.domainmodels.CostsAtClosingClosingCosts;
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
import com.actualize.mortgage.domainmodels.LicenseDetailModel;
import com.actualize.mortgage.domainmodels.LoanCalculationModel;
import com.actualize.mortgage.domainmodels.LoanCalculationsQualifiedMortgage;
import com.actualize.mortgage.domainmodels.LoanDetailModel;
import com.actualize.mortgage.domainmodels.LoanInformation;
import com.actualize.mortgage.domainmodels.LoanInformationLoanIdentifier;
import com.actualize.mortgage.domainmodels.LoanProductModel;
import com.actualize.mortgage.domainmodels.LoanTerms;
import com.actualize.mortgage.domainmodels.LoanTermsPrepaymentPenalty;
import com.actualize.mortgage.domainmodels.LoanTermsTemporaryBuydown;
import com.actualize.mortgage.domainmodels.MIDataDetailModel;
import com.actualize.mortgage.domainmodels.MaturityRuleModel;
import com.actualize.mortgage.domainmodels.NameModel;
import com.actualize.mortgage.domainmodels.NegativeAmortizationModel;
import com.actualize.mortgage.domainmodels.PartialPaymentModel;
import com.actualize.mortgage.domainmodels.PartialPaymentsModel;
import com.actualize.mortgage.domainmodels.PaymentModel;
import com.actualize.mortgage.domainmodels.PaymentRuleModel;
import com.actualize.mortgage.domainmodels.PaymentsModel;
import com.actualize.mortgage.domainmodels.Prepaids;
import com.actualize.mortgage.domainmodels.PrincipalAndInterestPaymentAdjustmentModel;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsDetails;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsEE;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsET;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsMI;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsPC;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsPI;
import com.actualize.mortgage.domainmodels.PropertyValuationDetailModel;
import com.actualize.mortgage.domainmodels.ProrationModel;
import com.actualize.mortgage.domainmodels.QualifiedMortgageModel;
import com.actualize.mortgage.domainmodels.SalesContractDetailModel;
import com.actualize.mortgage.domainmodels.SummariesofTransactions;
import com.actualize.mortgage.domainmodels.SummariesofTransactionsDetailsBorrowerTransaction;
import com.actualize.mortgage.domainmodels.SummariesofTransactionsDetailsDueFromSellerAtClosing;
import com.actualize.mortgage.domainmodels.SummariesofTransactionsDetailsPaidByAlready;
import com.actualize.mortgage.domainmodels.SummariesofTransactionsDetailsSellerTransaction;
import com.actualize.mortgage.domainmodels.TermsOfLoanModel;
import com.actualize.mortgage.domainmodels.TransactionInformation;
import com.actualize.mortgage.ledatamodels.Address;
import com.actualize.mortgage.ledatamodels.AmortizationRule;
import com.actualize.mortgage.ledatamodels.BuydownOccurence;
import com.actualize.mortgage.ledatamodels.BuydownRule;
import com.actualize.mortgage.ledatamodels.CashToCloseItem;
import com.actualize.mortgage.ledatamodels.CashToCloseItems;
import com.actualize.mortgage.ledatamodels.ClosingAdjustmentItem;
import com.actualize.mortgage.ledatamodels.ClosingCostFund;
import com.actualize.mortgage.ledatamodels.ClosingInformation;
import com.actualize.mortgage.ledatamodels.ClosingInformationDetail;
import com.actualize.mortgage.ledatamodels.Construction;
import com.actualize.mortgage.ledatamodels.Deal;
import com.actualize.mortgage.ledatamodels.Document;
import com.actualize.mortgage.ledatamodels.DocumentClass;
import com.actualize.mortgage.ledatamodels.DocumentClassification;
import com.actualize.mortgage.ledatamodels.EscrowDetail;
import com.actualize.mortgage.ledatamodels.EscrowItem;
import com.actualize.mortgage.ledatamodels.EscrowItemDetail;
import com.actualize.mortgage.ledatamodels.EscrowItemPayment;
import com.actualize.mortgage.ledatamodels.EscrowItems;
import com.actualize.mortgage.ledatamodels.EstimatedPropertyCostComponents;
import com.actualize.mortgage.ledatamodels.Fee;
import com.actualize.mortgage.ledatamodels.FeePayment;
import com.actualize.mortgage.ledatamodels.FeeSummaryDetail;
import com.actualize.mortgage.ledatamodels.Fees;
import com.actualize.mortgage.ledatamodels.Foreclosures;
import com.actualize.mortgage.ledatamodels.HighCostMortgages;
import com.actualize.mortgage.ledatamodels.IntegratedDisclosureDetail;
import com.actualize.mortgage.ledatamodels.IntegratedDisclosureSectionSummaries;
import com.actualize.mortgage.ledatamodels.IntegratedDisclosureSectionSummary;
import com.actualize.mortgage.ledatamodels.IntegratedDisclosureSectionSummaryDetail;
import com.actualize.mortgage.ledatamodels.IntegratedDisclosureSubsectionPayment;
import com.actualize.mortgage.ledatamodels.IntegratedDisclosureSubsectionPayments;
import com.actualize.mortgage.ledatamodels.InterestOnly;
import com.actualize.mortgage.ledatamodels.InterestRateAdjustment;
import com.actualize.mortgage.ledatamodels.InterestRatePerChangeAdjustmentRule;
import com.actualize.mortgage.ledatamodels.LateChargeRule;
import com.actualize.mortgage.ledatamodels.Liabilities;
import com.actualize.mortgage.ledatamodels.Liability;
import com.actualize.mortgage.ledatamodels.LicenseDetail;
import com.actualize.mortgage.ledatamodels.LoanDetail;
import com.actualize.mortgage.ledatamodels.LoanIdentifiers;
import com.actualize.mortgage.ledatamodels.LoanProduct;
import com.actualize.mortgage.ledatamodels.MIDataDetail;
import com.actualize.mortgage.ledatamodels.MISMODocument;
import com.actualize.mortgage.ledatamodels.MaturityRule;
import com.actualize.mortgage.ledatamodels.Name;
import com.actualize.mortgage.ledatamodels.NegativeAmortization;
import com.actualize.mortgage.ledatamodels.Other;
import com.actualize.mortgage.ledatamodels.PartialPayment;
import com.actualize.mortgage.ledatamodels.Parties;
import com.actualize.mortgage.ledatamodels.Party;
import com.actualize.mortgage.ledatamodels.Payment;
import com.actualize.mortgage.ledatamodels.PayoffsAndPayments;
import com.actualize.mortgage.ledatamodels.PrepaidItem;
import com.actualize.mortgage.ledatamodels.PrepaidItems;
import com.actualize.mortgage.ledatamodels.PrepaymentPenaltyLifetimeRule;
import com.actualize.mortgage.ledatamodels.PrincipalAndInterestPaymentAdjustment;
import com.actualize.mortgage.ledatamodels.PrincipalAndInterestPaymentPerChangeAdjustmentRule;
import com.actualize.mortgage.ledatamodels.ProjectedPayment;
import com.actualize.mortgage.ledatamodels.ProjectedPayments;
import com.actualize.mortgage.ledatamodels.PropertyDetail;
import com.actualize.mortgage.ledatamodels.PropertyValuationDetail;
import com.actualize.mortgage.ledatamodels.ProrationItem;
import com.actualize.mortgage.ledatamodels.QualifiedMortgage;
import com.actualize.mortgage.ledatamodels.SalesContractDetail;
import com.actualize.mortgage.ledatamodels.TermsOfLoan;
import com.actualize.mortgage.ledatamodels.Underwriting;
import com.actualize.mortgage.utils.Convertor;
import com.actualize.mortgage.utils.StringFormatter;

/**
 * This class will map all the Closing Disclosure XPATH elements to JSON Objects and its attributes 
 * @author rsudula
 * @version 1.0
 * 
 */

public class ClosingDisclosureConverter {
	/**
	 * Initiates the creation of JSON object for CD
	 * @param mismodoc
	 * @return ClosingDisclosure
	 */
    public ClosingDisclosure convertXmltoJSON(MISMODocument mismodoc) {
        ClosingDisclosure closingDisclosure = new ClosingDisclosure();        
        Document document = null;
        NodeList nodes = mismodoc.getElementsAddNS("//DOCUMENT");
        if (nodes.getLength() > 0)
            document = new Document(Document.NS, (Element)nodes.item(0));
        
        Deal deal = new Deal(Deal.NS, (Element)document.getElementAddNS("DEAL_SETS/DEAL_SET/DEALS/DEAL"));

	        closingDisclosure.setClosingDisclosureDocDetails(createClosingDisclosureDocumentDetails(document));
	        closingDisclosure.setTermsOfLoan(createTermsOfLoanModel(deal));
	    	closingDisclosure.setLoanDetail(createLoanDetailModel(deal));
	    	closingDisclosure.setDocumentClassification(createDocumentClassificationModel(document));
        	closingDisclosure.setClosingInformation(createClosingInformation(deal));
        	closingDisclosure.setConstruction(createConstructionModel(deal));
        	closingDisclosure.setClosingInformationDetail(createClosingInformationDetail(deal));
	        closingDisclosure.setTransactionInformation(createTransactionInformation(deal));
	        closingDisclosure.setIntegratedDisclosureDetail(createIntegratedDisclosureDetail(deal));
	        closingDisclosure.setMiDataDetail(createMIDataDetailModel(deal));
	        closingDisclosure.setLoanInformation(createLoanInformation(deal));
	        closingDisclosure.setSalesContractDetail(createSalesContractDetailModel(deal));
	        closingDisclosure.setNegativeAmortization(createNegativeAmortizationModel(deal));
	        closingDisclosure.setInterestOnly(createInterestOnlyModel(deal));
	        closingDisclosure.setMaturityRule(createMaturityRuleModel(deal));
	        closingDisclosure.setLoanProduct(createLoanProductModel(deal));
	        closingDisclosure.setLoanTerms(createLoanTerms(deal));
	        closingDisclosure.setProjectedPayments(createProjectedPayments(deal));
	        closingDisclosure.setEtiaSection(createETIASection(deal));
	        //closingDisclosure.setCostsAtClosing(createCostsAtClosing(deal));
	        closingDisclosure.setClosingCostDetailsLoanCosts(ClosingCostDetailsLoanCosts(deal));
	     	closingDisclosure.setClosingCostDetailsOtherCosts(createClosingCostOtherCosts(deal)); 
	     	closingDisclosure.setClosingCostsTotal(createClosingCostsTotal(deal));
	     	closingDisclosure.setCashToCloses(createCalculatingCashtoClose(deal));
	     	closingDisclosure.setPayoffsAndPayments(createPayoffsAndPayments(deal));
	     	closingDisclosure.setProrationsList(createProrationsModels(deal));
	     	closingDisclosure.setClosingAdjustmentItemList(createClosingAdjustmentModels(deal));
	     	closingDisclosure.setLiabilityList(createLiabilityModels(deal));
	     	closingDisclosure.setClosingCostFundList(createClosingCostFundModels(deal));
	     	closingDisclosure.setSummariesofTransactions(createSummariesofTransactions(deal));
	     	closingDisclosure.setInterestRateAdjustment(createInterestRateAdjustmentModel(deal)); //AIR Table
	     	closingDisclosure.setPrincipalAndInterestPaymentAdjustment(createPrincipalAndInterestPaymentAdjustmentModel(deal));
	     	closingDisclosure.setPayment(createPaymentModel(deal));
	     	closingDisclosure.setLateChargeRule(createLateChargeRuleModel(deal));
	     	closingDisclosure.setLoanCalculationsQualifiedMortgage(createLoanCalculationsQualifiedMortgage(deal));
	     	closingDisclosure.setContactInformation(createContactInformation(deal));
	     	
        
        return closingDisclosure;
    }

    /**
     * get all the details regarding the current document
     * @param mismodoc
     * @return ClosingDisclosureDocumentDetails
     */
    private ClosingDisclosureDocumentDetails createClosingDisclosureDocumentDetails(Document document) 
    {
    	ClosingDisclosureDocumentDetails closingDisclosureDocumentDetails = new ClosingDisclosureDocumentDetails();
    	
    	DocumentClassification docClassification = new DocumentClassification(Document.NS, (Element)document.getElementAddNS("DOCUMENT_CLASSIFICATION"));
        Deal deal = new Deal(Deal.NS, (Element)document.getElementAddNS("DEAL_SETS/DEAL_SET/DEALS/DEAL"));
        EscrowDetail escrowdetail = new EscrowDetail((Element)deal.getElementAddNS("LOANS/LOAN/ESCROW/ESCROW_DETAIL"));
        
        closingDisclosureDocumentDetails.setDocumentType(docClassification.documentClasses.documentClass.documentTypeOtherDescription.split(":")[0]);
        closingDisclosureDocumentDetails.setFormType(docClassification.documentClasses.documentClass.documentTypeOtherDescription.split(":")[1]);
        closingDisclosureDocumentDetails.setEscrowAggregateAccountingAdjustmentAmount(escrowdetail.escrowAggregateAccountingAdjustmentAmount);
        
		return closingDisclosureDocumentDetails;
    }
    
    
    /**
     * extracts ClosingInformation from xml and converts to JSON
     * @param mismodoc
     * @return closingInformationSection of PageOne
     */
    private ClosingInformationModel createClosingInformation(Deal deal)
    {
      String subjectProperty = "COLLATERALS/COLLATERAL/SUBJECT_PROPERTY";
      String propertyValuation = subjectProperty + "/PROPERTY_VALUATIONS/PROPERTY_VALUATION";
     
      PropertyValuationDetailModel propertyValuationDetailModel = new PropertyValuationDetailModel();
      ClosingInformationModel closingInformationSection = new ClosingInformationModel();
      IntegratedDisclosureDetail idDetail = new IntegratedDisclosureDetail((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_DETAIL"));
      Address propertyAddress = new Address((Element)deal.getElementAddNS(subjectProperty + "/ADDRESS"));
      PropertyDetail propertyDetail = new PropertyDetail((Element)deal.getElementAddNS(subjectProperty + "/PROPERTY_DETAIL"));
	  PropertyValuationDetail propertyValuationDetail = new PropertyValuationDetail((Element)deal.getElementAddNS(propertyValuation + "/PROPERTY_VALUATION_DETAIL"));
	 
      closingInformationSection.setDateIssued(idDetail.integratedDisclosureIssuedDate);
      closingInformationSection.setProperty(toAddressModel(propertyAddress));
      	propertyValuationDetailModel.setIdentifierOwnerURI(propertyValuationDetail.identifierOwnerURI);
      	propertyValuationDetailModel.setPropertyEstimatedValueAmount(propertyDetail.propertyEstimatedValueAmount);
      	propertyValuationDetailModel.setPropertyValuationAmount(propertyValuationDetail.propertyValuationAmount);
      	propertyValuationDetailModel.setPropertyValuationMethodType(propertyValuationDetail.propertyValuationMethodType);
      	propertyValuationDetailModel.setPropertyValuationMethodTypeOtherDescription(propertyValuationDetail.propertyValuationMethodTypeOtherDescription);
     	propertyValuationDetailModel.setPropertyValue(!"".equals(propertyDetail.propertyEstimatedValueAmount) ? "Estimated" : "Appraised");
      closingInformationSection.setPropertyValuationDetail(propertyValuationDetailModel);
      
        return closingInformationSection;
    }
    
    /**
     * converts SalesContractDetail to SalesContractDetailModel
     * @param deal
     * @return SalesContractDetailModel
     */
    private SalesContractDetailModel createSalesContractDetailModel(Deal deal)
    {
    	SalesContractDetailModel salesContractDetailModel = new SalesContractDetailModel();
    	
    	SalesContractDetail salesContractDetail = new SalesContractDetail((Element)deal.getElementAddNS("COLLATERALS/COLLATERAL/SUBJECT_PROPERTY/SALES_CONTRACTS/SALES_CONTRACT/SALES_CONTRACT_DETAIL"));
    	
    	salesContractDetailModel.setPersonalPropertyAmount(salesContractDetail.personalPropertyAmount);
      	salesContractDetailModel.setPersonalPropertyIndicator(Convertor.stringToBoolean(salesContractDetail.personalPropertyIncludedIndicator));
      	salesContractDetailModel.setRealPropertyAmount(salesContractDetail.realPropertyAmount);
      	salesContractDetailModel.setSaleContractAmount(salesContractDetail.salesContractAmount);
		return salesContractDetailModel;
    }
    
    /**
     * converts ClosingInformationDetail to ClosingInformationDetailModel
     * @param deal
     * @return ClosingInformationDetailModel
     */
    private ClosingInformationDetailModel createClosingInformationDetail(Deal deal) {
    	ClosingInformationDetailModel closingInformationDetailModel = new ClosingInformationDetailModel();
    	
    	ClosingInformationDetail closingInformationDetail = new ClosingInformationDetail((Element)deal.getElementAddNS("LOANS/LOAN/CLOSING_INFORMATION/CLOSING_INFORMATION_DETAIL"));
    	
    	closingInformationDetailModel.setCashFromBorrowerAtClosingAmount(closingInformationDetail.cashFromBorrowerAtClosingAmount);
    	closingInformationDetailModel.setCashFromSellerAtClosingAmount(closingInformationDetail.cashFromSellerAtClosingAmount);
    	closingInformationDetailModel.setCashToBorrowerAtClosingAmount(closingInformationDetail.cashToBorrowerAtClosingAmount);
    	closingInformationDetailModel.setCashToSellerAtClosingAmount(closingInformationDetail.cashToSellerAtClosingAmount);
    	closingInformationDetailModel.setClosingAgentOrderNumberIdentifier(closingInformationDetail.closingAgentOrderNumberIdentifier);
    	closingInformationDetailModel.setClosingDate(closingInformationDetail.closingDate);
    	closingInformationDetailModel.setClosingRateSetDate(closingInformationDetail.closingRateSetDate);
    	closingInformationDetailModel.setCurrentRateSetDate(closingInformationDetail.currentRateSetDate);
    	closingInformationDetailModel.setDisbursementDate(closingInformationDetail.disbursementDate);
    	closingInformationDetailModel.setDocumentOrderClassificationType(closingInformationDetail.documentOrderClassificationType);
    	
		return closingInformationDetailModel;
    	
	}
    
    /**
     * converts NegativeAmortization to NegativeAmortizationModel
     * @param deal
     * @return NegativeAmortizationModel
     */
    private NegativeAmortizationModel createNegativeAmortizationModel(Deal deal) {
    	NegativeAmortization negativeAmortization = new NegativeAmortization(null, (Element)deal.getElementAddNS("LOANS/LOAN/NEGATIVE_AMORTIZATION_RULE"));
    	NegativeAmortizationModel negativeAmortizationModel = new NegativeAmortizationModel();
	    	negativeAmortizationModel.setNegativeAmortizationLimitMonthsCount(negativeAmortization.negativeAmortizationLimitMonthsCount);
	    	negativeAmortizationModel.setNegativeAmortizationMaximumLoanBalanceAmount(negativeAmortization.negativeAmortizationMaximumLoanBalanceAmount);
	    	negativeAmortizationModel.setNegativeAmortizationType(negativeAmortization.negativeAmortizationType);
    	
		return negativeAmortizationModel;
	}
    
    /**
     * converts InterestOnly to InterestOnlyModel
     * @param deal
     * @return InterestOnlyModel
     */
    private InterestOnlyModel createInterestOnlyModel(Deal deal) {
    	InterestOnlyModel interestOnlyModel = new InterestOnlyModel();
    	InterestOnly interestOnly = new InterestOnly((Element)deal.getElementAddNS("LOANS/LOAN/INTEREST_ONLY"));
    		interestOnlyModel.setInterestOnlyTermMonthsCount(interestOnly.interestOnlyTermMonthsCount);
		return interestOnlyModel;
	}

    /**
     * converts MaturityRule to MaturityRuleModel
     * @param deal
     * @return MaturityRuleModel
     */
    private MaturityRuleModel createMaturityRuleModel(Deal deal) {
    	MaturityRuleModel maturityRuleModel = new MaturityRuleModel();
    	MaturityRule maturityRule = new MaturityRule((Element)deal.getElementAddNS("LOANS/LOAN/MATURITY/MATURITY_RULE"));
    		maturityRuleModel.setLoanMaturityPeriodCount(maturityRule.loanMaturityPeriodCount);
    		maturityRuleModel.setLoanMaturityPeriodType(maturityRule.loanMaturityPeriodType);
    		maturityRuleModel.setLoanTermMaximumMonthsCount(maturityRule.loanTermMaximumMonthsCount);
    	
		return maturityRuleModel;
	}
    
    /**
     * converts LoanProduct to LoanProductModel
     * @param deal
     * @return LoanProductModel
     */
    private LoanProductModel createLoanProductModel(Deal deal) {
    	LoanProductModel loanProductModel = new LoanProductModel();
    	LoanProduct loanProduct = new LoanProduct(null, (Element)deal.getElementAddNS("LOANS/LOAN/LOAN_PRODUCT"));
    	
    	loanProductModel.setLoanPriceQuoteInterestRatePercent(loanProduct.loanPriceQuoteInterestRatePercent);

    	return loanProductModel;
	}

    /**
     * Creates Transaction Information from MISMODocument
     * @param deal
     * @return TransactionInformation
     */
    private TransactionInformation createTransactionInformation(Deal deal)
    {
    	TransactionInformation transactionInformation = new TransactionInformation();
        
    	String refinanceSameLenderIndicator = deal.getValueAddNS("LOANS/LOAN/REFINANCE/RefinanceSameLenderIndicator");
    	
    	Parties borrowerParties = new Parties((Element)deal.getElementAddNS("PARTIES"), "[ROLES/ROLE/ROLE_DETAIL/PartyRoleType='Borrower']");
    	Parties sellerParties = new Parties((Element)deal.getElementAddNS("PARTIES"), "[ROLES/ROLE/ROLE_DETAIL/PartyRoleType='PropertySeller']");
    	Parties lenders = new Parties((Element)deal.getElementAddNS("PARTIES"), "[ROLES/ROLE/ROLE_DETAIL/PartyRoleType='NotePayTo']");
    	transactionInformation.setBorrower(createBorrowers(borrowerParties,"Borrower"));
    	transactionInformation.setSeller(createBorrowers(sellerParties,"PropertySeller"));
    	transactionInformation.setLender(createBorrowers(lenders,"NotePayTo"));
    	transactionInformation.setRefinanceSameLenderIndicator(Boolean.parseBoolean(refinanceSameLenderIndicator));
    	
		return transactionInformation;
    	
    }
    
    /**
     * Creates Loan Information from MISMODocument
     * @param mismodoc
     * @return
     */
    private LoanInformation createLoanInformation(Deal deal)
    {
    	LoanInformation loanInformationSection = new LoanInformation();

    	String loan = "LOANS/LOAN";
    	
        AmortizationRule amortization = new AmortizationRule((Element)deal.getElementAddNS(loan + "/AMORTIZATION/AMORTIZATION_RULE"));
        LoanIdentifiers loanidentifiers = new LoanIdentifiers((Element)deal.getElementAddNS(loan + "/LOAN_IDENTIFIERS"));
        Underwriting underwriting = new Underwriting(null, (Element)deal.getElementAddNS(loan+"/UNDERWRITING"));
        
        List<LoanInformationLoanIdentifier> loanInformationLoanIdentifiers = new LinkedList<>();
        List<AutomatedUnderwritingsModel> automatedUnderwritingsModelList = new LinkedList<>();
        
        if(underwriting.automatedUnderwritings.automatedUnderwriting.length >0)
        {
        	for(int i=0; i<underwriting.automatedUnderwritings.automatedUnderwriting.length;i++)
     	    {
        		AutomatedUnderwritingsModel automatedUnderwritingsModel = new AutomatedUnderwritingsModel();
        			automatedUnderwritingsModel.setAutomatedUnderwritingCaseIdentifier(underwriting.automatedUnderwritings.automatedUnderwriting[i].automatedUnderwritingCaseIdentifier);
        			automatedUnderwritingsModel.setAutomatedUnderwritingSystemType(underwriting.automatedUnderwritings.automatedUnderwriting[i].automatedUnderwritingSystemType);
        			automatedUnderwritingsModel.setAutomatedUnderwritingSystemTypeOtherDescription(underwriting.automatedUnderwritings.automatedUnderwriting[i].automatedUnderwritingSystemTypeOtherDescription);
        		automatedUnderwritingsModelList.add(automatedUnderwritingsModel);
     	    }
        }
        
        if(loanidentifiers.loanIdentifieries.length>0)
        for(int i=0; i<loanidentifiers.loanIdentifieries.length;i++)
 	    {
        	LoanInformationLoanIdentifier loanInformationLoanIdentifier = new LoanInformationLoanIdentifier();
 	  			loanInformationLoanIdentifier.setLoanIdentifier(loanidentifiers.loanIdentifieries[i].LoanIdentifier);
 	  			loanInformationLoanIdentifier.setLoanIdentifierType(loanidentifiers.loanIdentifieries[i].LoanIdentifierType);
 	  		loanInformationLoanIdentifiers.add(loanInformationLoanIdentifier);
 	  	}
 	  	
 	    loanInformationSection.setLoanIdentifiers(loanInformationLoanIdentifiers);
 	    loanInformationSection.setAmortizationType(amortization.AmortizationType);
 	    loanInformationSection.setAutomatedUnderwritings(automatedUnderwritingsModelList);
 	    loanInformationSection.setLoanManualUnderwritingIndicator(Boolean.parseBoolean(underwriting.underwritingDetail.loanManualUnderwritingIndicator));

 	    return loanInformationSection;
    }
    
    /**
     * converts construction to ConstructionModel
     * @param deal
     * @return ConstructionModel
     */
    private ConstructionModel createConstructionModel(Deal deal)
    {
    	ConstructionModel constructionModel = new ConstructionModel();
    	Construction construction = new Construction((Element)deal.getElementAddNS("LOANS/LOAN/CONSTRUCTION"));
    		constructionModel.setConstructionLoanTotalTermMonthsCount(construction.constructionLoanTotalTermMonthsCount);
    		constructionModel.setConstructionLoanType(construction.constructionLoanType);
    		constructionModel.setConstructionPeriodNumberOfMonthsCount(construction.constructionPeriodNumberOfMonthsCount);
    	
		return constructionModel;
    }
    
    /**
     * converts miDataDetail to MIDataDetailModel
     * @param deal
     * @return MIDataDetailModel
     */
    private MIDataDetailModel createMIDataDetailModel(Deal deal)
    {
    	MIDataDetailModel miDataDetailModel = new MIDataDetailModel();
    	MIDataDetail miDataDetail = new MIDataDetail((Element)deal.getElementAddNS("LOANS/LOAN/MI_DATA/MI_DATA_DETAIL"));
    		miDataDetailModel.setMiCertificateIdentifier(miDataDetail.miCertificateIdentifier);
    		miDataDetailModel.setMiCompanyNameType(miDataDetail.miCompanyNameType);
    		miDataDetailModel.setMiCompanyNameTypeOtherDescription(miDataDetail.miCompanyNameTypeOtherDescription);
    		miDataDetailModel.setMiInitialPremiumAmount(miDataDetail.miInitialPremiumAmount);
    		miDataDetailModel.setMiScheduledTerminationDate(miDataDetail.miScheduledTerminationDate);
    	
		return miDataDetailModel;
    	
    }
    
    /**
     * Creates Loan Terms Section from MISMODocument
     * @param mismodoc
     * @return
     */
    private LoanTerms createLoanTerms(Deal deal)
    {
    	LoanTerms loanTerms = new LoanTerms();
    	LoanTermsPrepaymentPenalty loanTermsPrepaymentPenalty = new LoanTermsPrepaymentPenalty();
    	LoanTermsTemporaryBuydown loanTermsTemporaryBuydown = new LoanTermsTemporaryBuydown();

	    String loan = "LOANS/LOAN";
    
        BuydownRule buydownRule = new BuydownRule((Element)deal.getElementAddNS(loan + "/BUYDOWN/BUYDOWN_RULE"));
        BuydownOccurence buydownOccurence = new BuydownOccurence((Element)deal.getElementAddNS(loan + "/BUYDOWN/BUYDOWN_OCCURRENCES/BUYDOWN_OCCURRENCE"));
        Other other = buydownRule.extension.other;
        PrepaymentPenaltyLifetimeRule prepaymentPenaltyLifetimeRule = new PrepaymentPenaltyLifetimeRule((Element)deal.getElementAddNS(loan + "/PREPAYMENT_PENALTY/PREPAYMENT_PENALTY_LIFETIME_RULE"));
  
		//loanTermsPrepaymentPenalty
		loanTermsPrepaymentPenalty.setPrepaymentPenaltyMaximumLifeOfLoanAmount(prepaymentPenaltyLifetimeRule.prepaymentPenaltyMaximumLifeOfLoanAmount);
		loanTermsPrepaymentPenalty.setPrepaymentPenaltyExpirationMonthsCount(prepaymentPenaltyLifetimeRule.prepaymentPenaltyExpirationMonthsCount);	
		
		//TemporaryBuydown
		loanTermsTemporaryBuydown.setGseBuydownReflectedInNoteIndicator(Convertor.stringToBoolean(other.buydownReflectedInNoteIndicator));
        loanTermsTemporaryBuydown.setBuydownInitialEffectiveInterestRatePercent(buydownOccurence.buydownInitialEffectiveInterestRatePercent);
        loanTermsTemporaryBuydown.setBuydownChangeFrequencyMonthsCount(buydownRule.buydownChangeFrequencyMonthsCount);
        loanTermsTemporaryBuydown.setBuydownIncreaseRatePercent(buydownRule.buydownIncreaseRatePercent);
        loanTermsTemporaryBuydown.setBuydownDurationMonthsCount(buydownRule.buydownDurationMonthsCount);
		
 	    loanTerms.setLoanTermsTemporaryBuydown(loanTermsTemporaryBuydown);
 	    loanTerms.setLoanTermsPrepaymentPenalty(loanTermsPrepaymentPenalty);
 	    
    	return loanTerms;
    }
    
    /**
     * creates ETIA section in response
     * @param deal
     * @return ETIASection
     */
  	private ETIASection createETIASection(Deal deal)
  	{
  		ETIASection etiaSection = new ETIASection();
  		List<String> escrowTypes = new LinkedList<>();
  		EstimatedPropertyCostComponents estimatedPropertyCostComponents = new EstimatedPropertyCostComponents((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/ESTIMATED_PROPERTY_COST/ESTIMATED_PROPERTY_COST_COMPONENTS"));
  		
  		String projectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount = deal.getValueAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/ESTIMATED_PROPERTY_COST/ESTIMATED_PROPERTY_COST_DETAIL/ProjectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount");
  		
  		List<ETIA>  eTIAs = new LinkedList<>();
  		
  		for(int i=0; i<estimatedPropertyCostComponents.estimatedPropertyCostComponent.length; i++){
  			if("Other".equalsIgnoreCase(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEstimatedTaxesInsuranceAssessmentComponentType) && !"".equalsIgnoreCase(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription))
  				escrowTypes.add(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription);
  			else
  				escrowTypes.add(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEstimatedTaxesInsuranceAssessmentComponentType);
  			
  			ETIA  eTIA = new ETIA();
  			eTIA.setProjectedPaymentEscrowedType(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEscrowedType);
  			eTIA.setProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEstimatedTaxesInsuranceAssessmentComponentType);
  			eTIA.setProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription);
  			eTIAs.add(eTIA);
  		}
  		
  		etiaSection.setEtiaValues(eTIAs);
		etiaSection.setProjectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount(projectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount);
  		etiaSection.setEscrowTypes(escrowTypes);
  		
  		return etiaSection;
  	}
  	
    /**
	 * calculates all the projected payments elements
	 * @param deal
	 * @return ProjectedPaymentsDetails
	 */
	private ProjectedPaymentsDetails createProjectedPayments(Deal deal)
	{
		ProjectedPayments payments = new ProjectedPayments((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/PROJECTED_PAYMENTS"));	
		LoanDetail loanDetail = new LoanDetail((Element)deal.getElementAddNS("LOANS/LOAN/LOAN_DETAIL"));
		InterestOnly interestOnly = new InterestOnly((Element)deal.getElementAddNS("LOANS/LOAN/INTEREST_ONLY"));
		
		ProjectedPaymentsDetails projectedPayments = new ProjectedPaymentsDetails();

		String monthscount  = interestOnly.interestOnlyTermMonthsCount;
		
		List<ProjectedPaymentsPC>  paymentCalculationList = new LinkedList<>();
		List<ProjectedPaymentsPI>  principalInterestList = new LinkedList<>();
		List<ProjectedPaymentsMI>  mortgageInsuranceList = new LinkedList<>();
		List<ProjectedPaymentsEE>  estimatedEscrowList = new LinkedList<>();
		List<ProjectedPaymentsET>  estimatedTotalList = new LinkedList<>();
		
		int interestOnlyTermMonthsCount = 0;
			if(null != monthscount && !"".equalsIgnoreCase(monthscount)){
				interestOnlyTermMonthsCount = Integer.parseInt(monthscount);
			}
			
		for (int i = 0; i < payments.projectedPayments.length && i < 4; i++) {
			
			ProjectedPayment payment = payments.projectedPayments[i];
			
			projectedPayments.setPaymentFrequencyType(payment.paymentFrequencyType);
			
			ProjectedPaymentsPC paymentCalculation = new ProjectedPaymentsPC();
			ProjectedPaymentsPI principalInterest = new ProjectedPaymentsPI();
			ProjectedPaymentsMI mortgageInsurance = new ProjectedPaymentsMI();
			ProjectedPaymentsEE estimatedEscrow = new ProjectedPaymentsEE();
			ProjectedPaymentsET estimatedTotal = new ProjectedPaymentsET();
			
			paymentCalculation.setProjectedPaymentCalculationPeriodEndNumber(payment.projectedPaymentCalculationPeriodEndNumber);
			paymentCalculation.setProjectedPaymentCalculationPeriodStartNumber(payment.projectedPaymentCalculationPeriodStartNumber);
			paymentCalculation.setProjectedPaymentCalculationPeriodTermType(payment.projectedPaymentCalculationPeriodTermType);
			paymentCalculation.setProjectedPaymentCalculationPeriodTermTypeOtherDescription(payment.projectedPaymentCalculationPeriodTermTypeOtherDescription);
			paymentCalculation.setSequenceNumber(payment.sequenceNumber);
		
			int startYear = Integer.parseInt(payment.projectedPaymentCalculationPeriodStartNumber);
			if ((startYear-1)*12 < interestOnlyTermMonthsCount && "true".equalsIgnoreCase(loanDetail.interestOnlyIndicator))
				principalInterest.setInterestOnlyStatus(true);
			else
				principalInterest.setInterestOnlyStatus(false);
			principalInterest.setProjectedPaymentPrincipalAndInterestMaximumPaymentAmount(payment.projectedPaymentPrincipalAndInterestMaximumPaymentAmount);
			principalInterest.setProjectedPaymentPrincipalAndInterestMinimumPaymentAmount(payment.projectedPaymentPrincipalAndInterestMinimumPaymentAmount);
				
			mortgageInsurance.setProjectedPaymentMIPaymentAmount(payment.projectedPaymentMIPaymentAmount);
			
			estimatedEscrow.setProjectedPaymentEstimatedEscrowPaymentAmount(payment.projectedPaymentEstimatedEscrowPaymentAmount);
			
			estimatedTotal.setProjectedPaymentEstimatedTotalMaximumPaymentAmount(payment.projectedPaymentEstimatedTotalMaximumPaymentAmount);
			estimatedTotal.setProjectedPaymentEstimatedTotalMinimumPaymentAmount(payment.projectedPaymentEstimatedTotalMinimumPaymentAmount);
			
			paymentCalculationList.add(paymentCalculation);
			principalInterestList.add(principalInterest);
			mortgageInsuranceList.add(mortgageInsurance);
			estimatedEscrowList.add(estimatedEscrow);
			estimatedTotalList.add(estimatedTotal);
				
		}
		
		projectedPayments.setEstimatedEscrow(estimatedEscrowList);
		projectedPayments.setEstimatedTotal(estimatedTotalList);
		projectedPayments.setMortgageInsurance(mortgageInsuranceList);
		projectedPayments.setPaymentCalculation(paymentCalculationList);
		projectedPayments.setPrincipalInterest(principalInterestList);
		projectedPayments.setMiMonthsDuration("");
		
		return projectedPayments;
	}
	
	/**
	 * creates CostsAtClosing UI response
	 * @param deal
	 * @return CostsAtClosing
	 */
	private CostsAtClosing createCostsAtClosing(Deal deal)
	{
		String idSummary = "LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_SECTION_SUMMARIES/INTEGRATED_DISCLOSURE_SECTION_SUMMARY";
		String idDetail = idSummary + "/INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL";
		String ciDetail = "LOANS/LOAN/CLOSING_INFORMATION/CLOSING_INFORMATION_DETAIL";
		String lenderCredits;
		
		DocumentClass documentClass = new DocumentClass((Element)deal.getElementAddNS("../../../../DOCUMENT_CLASSIFICATION/DOCUMENT_CLASSES/DOCUMENT_CLASS[DocumentType='Other']"));
		CostsAtClosingClosingCosts costsAtClosingClosingCosts = new CostsAtClosingClosingCosts();
		CostsAtClosingCashToClose costsAtClosingCashToClose = new CostsAtClosingCashToClose(); 
		ClosingInformationDetail closingDetail = new ClosingInformationDetail((Element)deal.getElementAddNS(ciDetail));
		IntegratedDisclosureSectionSummaryDetail idClosingDetail = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSectionType='TotalClosingCosts'][IntegratedDisclosureSubsectionType='ClosingCostsSubtotal']"));
		IntegratedDisclosureSectionSummaryDetail totalOtherCosts = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSectionType='TotalOtherCosts']"));
		IntegratedDisclosureSectionSummaryDetail totalLoanCosts = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSectionType='TotalLoanCosts']"));
		IntegratedDisclosureSubsectionPayment idLenderCredits = new IntegratedDisclosureSubsectionPayment((Element)deal.getElementAddNS(idSummary + "[INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL/IntegratedDisclosureSubsectionType='LenderCredits']/INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENTS/INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENT"));

		if (idLenderCredits.integratedDisclosureSubsectionPaymentAmount.equals("")) {
			IntegratedDisclosureSectionSummaryDetail idLenderCreditTwo = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSubsectionType='LenderCredits']"));
			lenderCredits = idLenderCreditTwo.integratedDisclosureSubsectionTotalAmount;
			costsAtClosingClosingCosts.setIntegratedDisclosureSubsectionTotalAmount(idLenderCreditTwo.integratedDisclosureSubsectionTotalAmount);
		} else
		{
			lenderCredits = idLenderCredits.integratedDisclosureSubsectionPaymentAmount;
			costsAtClosingClosingCosts.setIntegratedDisclosureSubsectionPaymentAmount(idLenderCredits.integratedDisclosureSubsectionPaymentAmount);
		}
		
			costsAtClosingClosingCosts.setAmount(idClosingDetail.integratedDisclosureSectionTotalAmount);
			costsAtClosingClosingCosts.setTotalOtherCosts(totalOtherCosts.integratedDisclosureSectionTotalAmount);
			costsAtClosingClosingCosts.setLenderCredits(lenderCredits);
			costsAtClosingClosingCosts.setTotalLoanCosts(totalLoanCosts.integratedDisclosureSectionTotalAmount);
			costsAtClosingCashToClose.setAmount(closingDetail.cashFromBorrowerAtClosingAmount.equals("") ? closingDetail.cashToBorrowerAtClosingAmount : closingDetail.cashFromBorrowerAtClosingAmount);
			costsAtClosingCashToClose.setCashFromBorrowerAtClosingAmount(closingDetail.cashFromBorrowerAtClosingAmount);
			costsAtClosingCashToClose.setCashToBorrowerAtClosingAmount(closingDetail.cashToBorrowerAtClosingAmount);
		
		if("ClosingDisclosure:AlternateForm".equalsIgnoreCase(documentClass.documentTypeOtherDescription)){
			costsAtClosingCashToClose.setFromType("".equals(closingDetail.cashFromBorrowerAtClosingAmount.trim()) ? false : true);
        }
		
		CostsAtClosing costsAtClosing = new CostsAtClosing();
		costsAtClosing.setCostsAtClosingClosingCosts(costsAtClosingClosingCosts);
		costsAtClosing.setCostsAtClosingCashToClose(costsAtClosingCashToClose);
		return costsAtClosing;
	}
	
	/**
	 * create ClosingCostDetailsLoanCosts UI response
	 * @param deal
	 * @return
	 */
	private ClosingCostDetailsLoanCosts ClosingCostDetailsLoanCosts(Deal deal)
	{
		String loan = "LOANS/LOAN";
		String idSummary = "LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_SECTION_SUMMARIES/INTEGRATED_DISCLOSURE_SECTION_SUMMARY";
		String idDetail = idSummary + "/INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL";
		ClosingCostProperties loanDiscountPoints = null;
		
		ClosingCostDetailsLoanCosts closingCostDetailsLoanCosts = new ClosingCostDetailsLoanCosts();
		List<ClosingCostProperties> originationChargeList = new LinkedList<>();
		List<ClosingCostProperties> sbDidNotShopFors = new LinkedList<>();
		List<ClosingCostProperties> sbDidShopFors = new LinkedList<>();
		PaymentsModel tlCosts = new PaymentsModel();
		
		DocumentClass documentClass = new DocumentClass((Element)deal.getElementAddNS("../../../../DOCUMENT_CLASSIFICATION/DOCUMENT_CLASSES/DOCUMENT_CLASS"));
		IntegratedDisclosureSectionSummaries integratedDisclosureSectionSummaries = new IntegratedDisclosureSectionSummaries((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_SECTION_SUMMARIES"));
		IntegratedDisclosureSectionSummaryDetail totalLoanCosts = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSectionType='TotalLoanCosts']"));
		IntegratedDisclosureSectionSummaryDetail idOraganisationCharges = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSectionType='OriginationCharges']"));
		IntegratedDisclosureSectionSummaryDetail idServicesBorrowerDidNotShopFor = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSectionType='ServicesBorrowerDidNotShopFor']"));
		IntegratedDisclosureSectionSummaryDetail idServicesBorrowerDidShopFor = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSectionType='ServicesBorrowerDidShopFor']"));
		Fees fees = new Fees((Element)deal.getElementAddNS(loan + "/FEE_INFORMATION/FEES"));

		closingCostDetailsLoanCosts.setOcTotalAmount(idOraganisationCharges.integratedDisclosureSectionTotalAmount);
		closingCostDetailsLoanCosts.setSbDidNotShopTotalAmount(idServicesBorrowerDidNotShopFor.integratedDisclosureSectionTotalAmount);
		closingCostDetailsLoanCosts.setSbDidShopTotalAmount(idServicesBorrowerDidShopFor.integratedDisclosureSectionTotalAmount);
		 if (!("Other".equalsIgnoreCase(documentClass.documentType) && "ClosingDisclosure:SellerOnly".equalsIgnoreCase(documentClass.documentTypeOtherDescription))) 
		 {	
			closingCostDetailsLoanCosts.setTlCostsTotalAmount(totalLoanCosts.integratedDisclosureSectionTotalAmount);
			tlCosts = calculateTLCosts(totalLoanCosts, integratedDisclosureSectionSummaries);
		 }
		
		if(null != fees.fees && fees.fees.length>0)
		for(Fee fee : fees.fees)
		{
			if("OriginationCharges".equalsIgnoreCase(fee.feeDetail.integratedDisclosureSectionType))
			{
				ClosingCostProperties closingCostProperties = new ClosingCostProperties();
					closingCostProperties = loanCostsTable(fee,"OriginationCharges");
					if(null != closingCostProperties.getFeeType() && !"LoanDiscountPoints".equalsIgnoreCase(closingCostProperties.getFeeType()))
						originationChargeList.add(closingCostProperties);
					else if("LoanDiscountPoints".equalsIgnoreCase(closingCostProperties.getFeeType()))
						loanDiscountPoints = closingCostProperties;
			}
			else if("ServicesBorrowerDidNotShopFor".equalsIgnoreCase(fee.feeDetail.integratedDisclosureSectionType))
			{
				ClosingCostProperties closingCostProperties = new ClosingCostProperties();
					closingCostProperties = loanCostsTable(fee,"ServicesBorrowerDidNotShopFor");
					if(null != closingCostProperties.getFeeType())
						sbDidNotShopFors.add(closingCostProperties);
			}
			else if("ServicesBorrowerDidShopFor".equalsIgnoreCase(fee.feeDetail.integratedDisclosureSectionType))
			{
				ClosingCostProperties closingCostProperties = new ClosingCostProperties();
					closingCostProperties = loanCostsTable(fee,"ServicesBorrowerDidShopFor");
					if(null != closingCostProperties.getFeeType())
						sbDidShopFors.add(closingCostProperties);
			}
		}
		
		Collections.sort(originationChargeList,new Comparator<ClosingCostProperties>(){
			@Override
			public int compare(ClosingCostProperties o1, ClosingCostProperties o2) {
				return o1.getFeeType().compareTo(o2.getFeeType());
			}
		});
		
		if(null != loanDiscountPoints)
			originationChargeList.add(0, loanDiscountPoints);
		
		Collections.sort(sbDidNotShopFors,new Comparator<ClosingCostProperties>(){
			@Override
			public int compare(ClosingCostProperties o1, ClosingCostProperties o2) {
				return o1.getFeeType().compareTo(o2.getFeeType());
			}
		});
		
		Collections.sort(sbDidShopFors,new Comparator<ClosingCostProperties>(){
			@Override
			public int compare(ClosingCostProperties o1, ClosingCostProperties o2) {
				return o1.getFeeType().compareTo(o2.getFeeType());
			}
		});
		
		closingCostDetailsLoanCosts.setOriginationCharges(originationChargeList);
		closingCostDetailsLoanCosts.setSbDidNotShopFors(sbDidNotShopFors);
		closingCostDetailsLoanCosts.setSbDidShopFors(sbDidShopFors);
		closingCostDetailsLoanCosts.setTlCosts(tlCosts);
		
		return closingCostDetailsLoanCosts;
	}
		
	/**
     * create ClosingCostDetailsOtherCosts UI response
     * @param deal
     * @return ClosingCostDetailsOtherCosts
     */
    private ClosingCostDetailsOtherCosts createClosingCostOtherCosts(Deal deal)
    {
    	String loan = "LOANS/LOAN";
		String idSummaryBase = loan + "/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_SECTION_SUMMARIES/";
    			
    	ClosingCostDetailsOtherCosts closingCostDetailsOtherCosts = new ClosingCostDetailsOtherCosts();
    	PaymentsModel totalOtherCosts = new PaymentsModel();
    	
    	List<ClosingCostProperties> tOGovtFeesList = new ArrayList<>();
		List<Prepaids> prepaidsList = new LinkedList<>();
		List<EscrowItemModel> escrowItemsList = new LinkedList<>();
		List<ClosingCostProperties> otherCostsList = new LinkedList<>();
		
		IntegratedDisclosureSectionSummaries idSectionSummaries = new IntegratedDisclosureSectionSummaries((Element)deal.getElementAddNS(idSummaryBase));
		Fees taxesAndOtherGovernmentFees = new Fees((Element)deal.getElementAddNS("LOANS/LOAN/FEE_INFORMATION/FEES"),"[FEE_DETAIL/IntegratedDisclosureSectionType = 'TaxesAndOtherGovernmentFees']");
    	Fees otherFees = new Fees((Element)deal.getElementAddNS("LOANS/LOAN/FEE_INFORMATION/FEES"),"[FEE_DETAIL/IntegratedDisclosureSectionType = 'OtherCosts']");
    	EscrowItems escrowItems = new EscrowItems((Element)deal.getElementAddNS("LOANS/LOAN/ESCROW/ESCROW_ITEMS"));
    
    	for(int i=0; i<idSectionSummaries.integratedDisclosureSectionSummaries.length; i++)
    	{
    		if("OtherCosts".equalsIgnoreCase(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
    			closingCostDetailsOtherCosts.setOtherTotalAmount(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionTotalAmount);
    		else if("TaxesAndOtherGovernmentFees".equalsIgnoreCase(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
				closingCostDetailsOtherCosts.settOGovtFeesTotalAmount(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionTotalAmount);
    		else if("Prepaids".equalsIgnoreCase(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
				closingCostDetailsOtherCosts.setPrepaidsTotalAmount(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionTotalAmount);
    		else if("InitialEscrowPaymentAtClosing".equalsIgnoreCase(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
				closingCostDetailsOtherCosts.setEscrowItemsTotalAmount(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionTotalAmount);
    		else if("TotalOtherCosts".equalsIgnoreCase(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
				closingCostDetailsOtherCosts.setTotalOtherCostsTotalAmount(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionTotalAmount);
    	 if("OtherCostsSubtotal".equalsIgnoreCase(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSubsectionType))
    		{
    			IntegratedDisclosureSubsectionPayment[] integratedDisclosureSubsectionPayments = idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSubsectionPayments.integratedDisclosureSubsectionPayments;
    			for(int j=0; j< integratedDisclosureSubsectionPayments.length; j++)
    			{
    				String paidBy = integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaidByType;
    				if("Buyer".equalsIgnoreCase(paidBy))
    				{
    					if("AtClosing".equalsIgnoreCase(integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaymentTimingType))
    						totalOtherCosts.setBpAtClosing(integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaymentAmount);
    					else if("BeforeClosing".equalsIgnoreCase(integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaymentTimingType))
    						totalOtherCosts.setBpB4Closing(integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaymentAmount);
    				}
    				else if("Seller".equalsIgnoreCase(paidBy))
    				{
    					if("AtClosing".equalsIgnoreCase(integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaymentTimingType))
    						totalOtherCosts.setSpAtClosing(integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaymentAmount);
    					else if("BeforeClosing".equalsIgnoreCase(integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaymentTimingType))
    						totalOtherCosts.setSpB4Closing(integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaymentAmount);
    				}
    				else
    					totalOtherCosts.setPaidByOthers(integratedDisclosureSubsectionPayments[j].integratedDisclosureSubsectionPaymentAmount);
    					
    					if("Lender".equalsIgnoreCase(paidBy))
    						totalOtherCosts.setLenderStatus(true);
    					else
    						totalOtherCosts.setLenderStatus(false);
    			}
    		}
    	}
    	
    	for(Fee fee : taxesAndOtherGovernmentFees.fees)
			tOGovtFeesList.add(feeCostsTableRow(fee));
    	
    	PrepaidItems prepaidItems = new PrepaidItems((Element)deal.getElementAddNS("LOANS/LOAN/CLOSING_INFORMATION/PREPAID_ITEMS"));
    	
    	List<String> prepaidItemsToDisplay = new LinkedList<>();
			prepaidItemsToDisplay.add("HomeownersInsurancePremium");
			prepaidItemsToDisplay.add("MortgageInsurancePremium");
			prepaidItemsToDisplay.add("PrepaidInterest");
		
		Map<String,PrepaidItem> prepaidItemMap = new HashMap<>();
		for(PrepaidItem prepaidItem :prepaidItems.prepaidItems)
			if(null != prepaidItem.prepaidItemDetail.prepaidItemType || "".equals(prepaidItem.prepaidItemDetail.prepaidItemType))
				prepaidItemMap.put(prepaidItem.prepaidItemDetail.prepaidItemType, prepaidItem);
		
		for(String prepaidItem : prepaidItemsToDisplay)
			if(null != prepaidItemMap.get(prepaidItem))
				prepaidsList.add(setPrepaids(prepaidItemMap.get(prepaidItem), true));
		 
		for(PrepaidItem prepaidItem :prepaidItems.prepaidItems)
			if(checkOtherPrepaids(prepaidItem.prepaidItemDetail.prepaidItemType))
				prepaidsList.add(setPrepaids(prepaidItem, true));
			else if(isPropertyTax(prepaidItem.prepaidItemDetail.prepaidItemType))
			{
				Prepaids prepaid = setPrepaids(prepaidItem, true);
				prepaid.setDisplayLabel("Property Taxes");
				prepaidsList.add(prepaid);
			}	
		//populate ESCROWS
		if(null != escrowItems.escrowItems)
		{
			List<String> escrowItemsToDisplay = new LinkedList<>();
				escrowItemsToDisplay.add("HomeownersInsurance");
				escrowItemsToDisplay.add("MortgageInsurance");
			
			for(String escrow : escrowItemsToDisplay)
			{
				EscrowItem escrowItem = getEscrowItem(escrowItems, escrow);
				 if (null != escrowItem.element)
					 escrowItemsList.add(getEscrowModel(escrowItem));
			}
			
			for(int i=0; i<escrowItems.escrowItems.length;i++)
	 	    {
				if (("Property Tax").equalsIgnoreCase(escrowItems.escrowItems[i].escrowItemDetail.displayLabelText)) {
					escrowItemsList.add(getEscrowModel(escrowItems.escrowItems[i]));
					break;
				} 
				else if (isPropertyTax(escrowItems.escrowItems[i].escrowItemDetail.escrowItemType)) {
					EscrowItemModel iePatClosing = new EscrowItemModel();
						iePatClosing = getEscrowModel(escrowItems.escrowItems[i]);
						iePatClosing.setDisplayLabel("Property Taxes");
					escrowItemsList.add(iePatClosing);
				}
	 	    }
			
			for(int i=0; i<escrowItems.escrowItems.length;i++)
				if(checkOtherEscrows(escrowItems.escrowItems[i].escrowItemDetail.escrowItemType))
					escrowItemsList.add(getEscrowModel(escrowItems.escrowItems[i]));
		}
		
		//OtherFees
		for(int i=0;i<otherFees.fees.length;i++)
			if(!"".equals(otherFees.fees[i].feeDetail.feeType))
				otherCostsList.add(feeCostsTableRow(otherFees.fees[i]));
		 
		closingCostDetailsOtherCosts.settOGovtFeesList(tOGovtFeesList);
		closingCostDetailsOtherCosts.setPrepaidsList(prepaidsList);
		closingCostDetailsOtherCosts.setEscrowItemsList(escrowItemsList);
		closingCostDetailsOtherCosts.setOtherCostsList(otherCostsList);
		closingCostDetailsOtherCosts.setTotalOtherCosts(totalOtherCosts);
		
		return closingCostDetailsOtherCosts;
    	
    }
    
    /**
     * creates closing costs total
     * @param deal
     * @return ClosingCostsTotal
     */
    private ClosingCostsTotal createClosingCostsTotal(Deal deal)
    {
    	String loan = "LOANS/LOAN";
		String idSummaryBase = loan + "/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_SECTION_SUMMARIES/INTEGRATED_DISCLOSURE_SECTION_SUMMARY";
		String idSummary = idSummaryBase + "/INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL";
		
    	ClosingCostsTotal closingCostsTotal = new ClosingCostsTotal();
    	PaymentsModel closingCostsSubtotal = new PaymentsModel();

    	IntegratedDisclosureSubsectionPayment idPayment = new IntegratedDisclosureSubsectionPayment((Element)deal.getElementAddNS(idSummaryBase + "[INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL/IntegratedDisclosureSubsectionType='ClosingCostsSubtotal']/INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENTS/INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENT"));
    	closingCostsTotal.setTotalClosingCosts(idPayment.integratedDisclosureSubsectionPaymentAmount);
    	
    	idPayment = new IntegratedDisclosureSubsectionPayment((Element)deal.getElementAddNS(idSummaryBase + "[INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL/IntegratedDisclosureSubsectionType='LenderCredits']/INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENTS/INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENT"));
    	
    	if (idPayment.integratedDisclosureSubsectionPaymentAmount.equals("")) {
			IntegratedDisclosureSectionSummaryDetail idLenderCreditTwo = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idSummary + "[IntegratedDisclosureSubsectionType='LenderCredits']"));
			closingCostsTotal.setLenderCredits(idLenderCreditTwo.integratedDisclosureSubsectionTotalAmount);
		} else
			closingCostsTotal.setLenderCredits(idPayment.integratedDisclosureSubsectionPaymentAmount);
    	
    	IntegratedDisclosureSectionSummary integratedDisclosureSectionSummary = new IntegratedDisclosureSectionSummary((Element)deal.getElementAddNS(idSummaryBase + "[INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL/IntegratedDisclosureSubsectionType='ClosingCostsSubtotal']"));
    	
    	IntegratedDisclosureSubsectionPayments integratedDisclosureSubsectionPayments = integratedDisclosureSectionSummary.integratedDisclosureSubsectionPayments;
	    if(integratedDisclosureSubsectionPayments.integratedDisclosureSubsectionPayments.length>0)
		for(IntegratedDisclosureSubsectionPayment integrateddisclosuresubsectionpayment : integratedDisclosureSubsectionPayments.integratedDisclosureSubsectionPayments)
		{
			if(("Buyer").equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaidByType))
			{
				if(("AtClosing").equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentTimingType))
					closingCostsSubtotal.setBpAtClosing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
				else
					closingCostsSubtotal.setBpB4Closing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
			}
			else if(("Seller").equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaidByType))
			{
				if(("AtClosing").equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentTimingType))
					closingCostsSubtotal.setSpAtClosing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
				else
					closingCostsSubtotal.setSpB4Closing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
			}
			else
				closingCostsSubtotal.setPaidByOthers(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
			if("Lender".equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaidByType))
				closingCostsSubtotal.setLenderStatus(true);
		}
    	
    	closingCostsTotal.setClosingCostsSubtotal(closingCostsSubtotal);
    	closingCostsTotal.setLenderCreditToleranceCureAmount(integratedDisclosureSectionSummary.integratedDisclosureSectionSummaryDetail.lenderCreditToleranceCureAmount);
		return closingCostsTotal;
    }
    
    /**
     * Creates createCalculatingCashtoClose UI response
     * @param document
     * @return CashToClose
     */
    public CashToClose createCalculatingCashtoClose(Deal deal) {

    	CashToClose cashToClose = new CashToClose();
    	List<CashToCloseModel> cashToCloseModelList = new LinkedList<>();
    	
    	DocumentClass documentClass = new DocumentClass((Element)deal.getElementAddNS("../../../../DOCUMENT_CLASSIFICATION/DOCUMENT_CLASSES/DOCUMENT_CLASS[DocumentType='Other']"));
    	CashToCloseItems cashToCloseItems = new CashToCloseItems((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/CASH_TO_CLOSE_ITEMS"));
    	
    	boolean alternateView = "ClosingDisclosure:AlternateForm".equalsIgnoreCase(documentClass.documentTypeOtherDescription) ? true : false ;
		
    	cashToClose.setAlternateView(alternateView);
    	
    	for (CashToCloseItem cashToCloseItem : cashToCloseItems.cashToCloseItems) {
			switch (cashToCloseItem.integratedDisclosureCashToCloseItemType) {
				case "LoanAmount":
					cashToClose.setLoanAmount(setCashToClose(cashToCloseItem,"Loan Amount",!alternateView ? "-1" : "1"));
					break;
				case "TotalClosingCosts":
					cashToClose.setTotalClosingCosts(setCashToClose(cashToCloseItem,"Total Closing Costs (J)",!alternateView ? "1" : "2"));
					break;
				case "ClosingCostsPaidBeforeClosing":
					cashToClose.setClosingCostsPaidBeforeClosing(setCashToClose(cashToCloseItem,"Closing Costs Paid Before Closing",!alternateView ? "2" : "3"));
					break;
				case "ClosingCostsFinanced":
					cashToClose.setClosingCostsFinanced(setCashToClose(cashToCloseItem,"Closing Costs Financed \n (Paid from your Loan Amount)",!alternateView ? "3" : "-1"));
					break;
				case "DownPayment":
					cashToClose.setDownPayment(setCashToClose(cashToCloseItem,"Down Payment/Funds from Borrower",!alternateView ? "4" : "-1"));
					break;
				case "TotalPayoffsAndPayments":
					cashToClose.setTotalPayoffsAndPayments(setCashToClose(cashToCloseItem,"Total Payoffs and Payments (K)",!alternateView ? "-1" : "4"));
					break;
				case "Deposit":
					cashToClose.setDeposit(setCashToClose(cashToCloseItem,"Deposit",!alternateView ? "5" : "-1"));
					break;
				case "FundsForBorrower":
					cashToClose.setFundsForBorrower(setCashToClose(cashToCloseItem,"Funds for Borrower",!alternateView ? "6" : "-1"));
					break;
				case "SellerCredits":
					cashToClose.setSellerCredits(setCashToClose(cashToCloseItem,"Seller Credits",!alternateView ? "7" : "-1"));
					break;
				case "AdjustmentsAndOtherCredits":
					cashToClose.setAdjustmentsAndOtherCredits(setCashToClose(cashToCloseItem,"Adjustments and Other Credits",!alternateView ? "8" : "-1"));
					break;
				case "CashToCloseTotal":
					cashToCloseModelList.add(setCashToClose(cashToCloseItem,"Cash to Close",!alternateView ? "9" : "5"));
					break;
			}
		}
		
    	cashToClose.setCashToCloseTotal(cashToCloseModelList);
		
		return cashToClose;
	}
    
    /**
     * this methods creates SummariesofTransactions response
     * @param deal
     * @return SummariesofTransactions
     */
    private SummariesofTransactions createSummariesofTransactions(Deal deal)
    {
    	String adjustmentTypes ="FuelCosts,RelocationFunds,Repairs,SellersEscrowAssumption,SellersMortgageInsuranceAssumption,SweatEquity.TenantSecurityDeposit,TradeEquity,Other";
		String cityTaxFees   = "CityPropertyTax,DistrictPropertyTax,TownPropertyTax";
		String countyTaxFees = "BoroughPropertyTax,CountyPropertyTax";
		String assesmentFees = "CondominiumAssociationSpecialAssessment,CooperativeAssociationSpecialAssessment,HomeownersAssociationSpecialAssessment";
		String[] adjustmentFees	 = {"CondominiumAssociationDues","CooperativeAssociationDues","EarthquakeInsurancePremium","FloodInsurancePremium",
								"GroundRent","HailInsurancePremium","HazardInsurancePremium","HomeownersAssociationDues",
								"HomeownersInsurancePremium","InterestOnLoanAssumption","MortgageInsurancePremium","PastDuePropertyTax",
								"RentFromSubjectProperty","StatePropertyTax","Utilities","VolcanoInsurancePremium","WindAndStormInsurancePremium","Other"};
		String paidAlready   =  "ProceedsOfSubordinateLiens,SatisfactionOfSubordinateLien,";
		String liabilityFromSeller = "DelinquentTaxes,HELOC,TaxLien,Taxes,ThirdPositionMortgage,Other";
		String subjectProperty = "COLLATERALS/COLLATERAL/SUBJECT_PROPERTY";
        String salesContract = subjectProperty + "/SALES_CONTRACTS/SALES_CONTRACT";
        String idSummary = "LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_SECTION_SUMMARIES/";
        
    	SummariesofTransactions summariesofTransactions = new SummariesofTransactions();
    	SummariesofTransactionsDetailsDueFromSellerAtClosing dueFromSellerAtClosing = new  SummariesofTransactionsDetailsDueFromSellerAtClosing();
    	
    
    	IntegratedDisclosureSectionSummaries integratedDisclosureSectionSummaryList = new IntegratedDisclosureSectionSummaries((Element)deal.getElementAddNS(idSummary));
    	ClosingInformation closingInformation =  new ClosingInformation(null, (Element)deal.getElementAddNS("LOANS/LOAN/CLOSING_INFORMATION"));
    	ClosingInformationDetail closingInformationDetail = new ClosingInformationDetail((Element)deal.getElementAddNS("LOANS/LOAN/CLOSING_INFORMATION/CLOSING_INFORMATION_DETAIL"));
/*
    	List<ProrationModel> prorationsModels = createProrationsModels(deal);
		List<LiabilityModel> liabilityModels = createLiabilityModels(deal);
		*/
		List<ClosingCostFundModel> closingCostFundModels = createClosingCostFundModels(deal);
		/*
		summariesofTransactions.setLiabilityList(liabilityModels);
		summariesofTransactions.setProrationList(prorationsModels);
		summariesofTransactions.setClosingAdjustmentItemList(closingAdjustmentItemModels);
		summariesofTransactions.setClosingCostFundList(closingCostFundModels);*/
		
		//Due From Borrower AtClosing
		/*SummariesofTransactionsDetailsDueFromBorrowerAtClosing duefromBorroweratClosing = new SummariesofTransactionsDetailsDueFromBorrowerAtClosing();
		List<LiabilityModel> duefromBorroweratClosingList = new LinkedList<>();
		List<ClosingAdjustmentItemModel> duefromBorroweratClosingAdjustmentsList = new LinkedList<>();
		List<ProrationModel> paidBySellerInAdvance = new LinkedList<>();*/
		
		//Paid Already By
		SummariesofTransactionsDetailsPaidByAlready paidByAlready = new SummariesofTransactionsDetailsPaidByAlready();
		List<ClosingAdjustmentItemModel> closingAdjustmentItemModels = createClosingAdjustmentModels(deal);
		
		for(ClosingAdjustmentItemModel closingAdjustmentItem : closingAdjustmentItemModels)
		{
			if("PaidAlreadyByOrOnBehalfOfBorrowerAtClosing".equalsIgnoreCase(closingAdjustmentItem.getIntegratedDisclosureSectionType()) 
					&& "SellerCredit".equalsIgnoreCase(closingAdjustmentItem.getClosingAdjustmentItemType()))
			{
				if(!"OtherCredits".equalsIgnoreCase(closingAdjustmentItem.getIntegratedDisclosureSubsectionType()) && !"OtherCredits".equalsIgnoreCase(closingAdjustmentItem.getIntegratedDisclosureSubsectionType()))
				{
					if (paidAlready.contains(closingAdjustmentItem.getClosingAdjustmentItemType()) && paidAlready.contains(closingAdjustmentItem.getClosingAdjustmentItemTypeOtherDescription()))
					{
						paidByAlready.setSubordinateLien(closingAdjustmentItem);
					}
				}
			}
		}
		
		
		//Calculations
		SummariesofTransactionsDetailsBorrowerTransaction borrowerTransaction = new SummariesofTransactionsDetailsBorrowerTransaction();
		SummariesofTransactionsDetailsSellerTransaction sellerTransaction = new SummariesofTransactionsDetailsSellerTransaction();
		
		//Borrower Transaction
		IntegratedDisclosureSectionSummaryModel dueFromBorrowerAtClosingSummaryModel = new IntegratedDisclosureSectionSummaryModel();
		IntegratedDisclosureSectionSummaryModel paidAlreadyByOrOnBehalfOfBorrowerAtClosingSummaryModel = new IntegratedDisclosureSectionSummaryModel();
		
		for(int i=0;i<integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries.length;i++)
			if("DueFromBorrowerAtClosing".equalsIgnoreCase(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
				dueFromBorrowerAtClosingSummaryModel = toIntegratedDisclosureSectionSummaryModel(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i]);
			else if("PaidAlreadyByOrOnBehalfOfBorrowerAtClosing".equalsIgnoreCase(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
				paidAlreadyByOrOnBehalfOfBorrowerAtClosingSummaryModel = toIntegratedDisclosureSectionSummaryModel(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i]);
		
		summariesofTransactions.setBorrowerTransaction(borrowerTransaction);

		if("".equals(dueFromBorrowerAtClosingSummaryModel.getIntegratedDisclosureSectionSummaryDetailModel().getIntegratedDisclosureSectionTotalAmount()))
			dueFromBorrowerAtClosingSummaryModel.getIntegratedDisclosureSectionSummaryDetailModel().setIntegratedDisclosureSectionTotalAmount("0");
		
		if("".equals(paidAlreadyByOrOnBehalfOfBorrowerAtClosingSummaryModel.getIntegratedDisclosureSectionSummaryDetailModel().getIntegratedDisclosureSectionTotalAmount()))
			paidAlreadyByOrOnBehalfOfBorrowerAtClosingSummaryModel.getIntegratedDisclosureSectionSummaryDetailModel().setIntegratedDisclosureSectionTotalAmount("0");
		
		borrowerTransaction.setDueFromBorrowerAtClosing(dueFromBorrowerAtClosingSummaryModel);
		borrowerTransaction.setPaidAlreadyByOrOnBehalfOfBorrowerAtClosing(paidAlreadyByOrOnBehalfOfBorrowerAtClosingSummaryModel);
		
		//seller transaction
		IntegratedDisclosureSectionSummaryModel dueFromSellerAtClosingSummaryModel = new IntegratedDisclosureSectionSummaryModel();
		IntegratedDisclosureSectionSummaryModel dueToSellerAtClosingSummaryModel = new IntegratedDisclosureSectionSummaryModel();
		
		for(int i=0;i<integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries.length;i++)
			if("DueFromSellerAtClosing".equalsIgnoreCase(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
				dueFromSellerAtClosingSummaryModel = toIntegratedDisclosureSectionSummaryModel(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i]); 
			else if("DueToSellerAtClosing".equalsIgnoreCase(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
				dueToSellerAtClosingSummaryModel = toIntegratedDisclosureSectionSummaryModel(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i]);
		
		if("".equals(dueFromSellerAtClosingSummaryModel.getIntegratedDisclosureSectionSummaryDetailModel().getIntegratedDisclosureSectionTotalAmount()))
			dueFromSellerAtClosingSummaryModel.getIntegratedDisclosureSectionSummaryDetailModel().setIntegratedDisclosureSectionTotalAmount("0");
		
		if("".equals(dueToSellerAtClosingSummaryModel.getIntegratedDisclosureSectionSummaryDetailModel().getIntegratedDisclosureSectionTotalAmount()))
			dueToSellerAtClosingSummaryModel.getIntegratedDisclosureSectionSummaryDetailModel().setIntegratedDisclosureSectionTotalAmount("0");
			
		sellerTransaction.setFromSellerAtClosing(dueFromSellerAtClosingSummaryModel);
		sellerTransaction.setToSellerAtClosing(dueToSellerAtClosingSummaryModel);
		
		summariesofTransactions.setDueFromSeller(dueFromSellerAtClosing);
		summariesofTransactions.setSellerTransaction(sellerTransaction);
		
		summariesofTransactions.setPaidByAlready(paidByAlready);
			
		return summariesofTransactions;
    }
    
    /**
     * creates response for PayoffsAndPayments 
     * @param deal
     * @return PayoffsAndPayments
     */
    private PayoffsAndPayments createPayoffsAndPayments(Deal deal)
    {
    	PayoffsAndPayments payoffsAndPayments = new PayoffsAndPayments();
    	IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
    	IntegratedDisclosureSectionSummaries integratedDisclosureSectionSummaryList = new IntegratedDisclosureSectionSummaries((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_SECTION_SUMMARIES/"));
    	
    	for(int i=0;i<integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries.length;i++)
			if("PayoffsAndPayments".equalsIgnoreCase(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
				integratedDisclosureSectionSummaryModel = toIntegratedDisclosureSectionSummaryModel(integratedDisclosureSectionSummaryList.integratedDisclosureSectionSummaries[i]);
    	
    	payoffsAndPayments.setIntegratedDisclosureSectionSummary(integratedDisclosureSectionSummaryModel);
    	
		return payoffsAndPayments;
    }
    
    /**
     * creates InterestRateAdjustmentModel from InterestRateAdjustment, response for air table
     * @param deal
     * @return InterestRateAdjustmentModel
     */
    private InterestRateAdjustmentModel createInterestRateAdjustmentModel(Deal deal) //AIR Table Response
    {
    	InterestRateAdjustmentModel interestRateAdjustmentModel = new InterestRateAdjustmentModel();
		
		InterestRateAdjustment interestRateAdjustment = new InterestRateAdjustment((Element)deal.getElementAddNS("LOANS/LOAN/ADJUSTMENT/INTEREST_RATE_ADJUSTMENT"));
		
		interestRateAdjustmentModel.setCeilingRatePercent(interestRateAdjustment.interestRateLifetimeAdjustmentRule.ceilingRatePercent);
		interestRateAdjustmentModel.setCeilingRatePercentEarliestEffectiveMonthsCount(interestRateAdjustment.interestRateLifetimeAdjustmentRule.ceilingRatePercentEarliestEffectiveMonthsCount);
		interestRateAdjustmentModel.setFirstRateChangeMonthsCount(interestRateAdjustment.interestRateLifetimeAdjustmentRule.firstRateChangeMonthsCount);
		interestRateAdjustmentModel.setFloorRatePercent(interestRateAdjustment.interestRateLifetimeAdjustmentRule.floorRatePercent);
		interestRateAdjustmentModel.setIndexType(interestRateAdjustment.indexRule.indexType);
		interestRateAdjustmentModel.setIndexTypeOtherDescription(interestRateAdjustment.indexRule.indexTypeOtherDescription);
		interestRateAdjustmentModel.setMarginRatePercent(interestRateAdjustment.interestRateLifetimeAdjustmentRule.marginRatePercent);
		interestRateAdjustmentModel.setTotalStepCount(interestRateAdjustment.interestRateLifetimeAdjustmentRule.other.totalStepCount);
		
		for(int i=0; i<interestRateAdjustment.interestRatePerChangeAdjustmentRulesList.interestRatePerChangeAdjustmentRules.length; i++)
		{
			InterestRatePerChangeAdjustmentRule interestRatePerChangeAdjustmentRule = interestRateAdjustment.interestRatePerChangeAdjustmentRulesList.interestRatePerChangeAdjustmentRules[i];
			if("First".equalsIgnoreCase(interestRatePerChangeAdjustmentRule.adjustmentRuleType))
			{
				interestRateAdjustmentModel.setFirstAdjustmentRule(interestRatePerChangeAdjustmentRule.adjustmentRuleType);
				interestRateAdjustmentModel.setFirstPerChangeMaximumIncreaseRatePercent(interestRatePerChangeAdjustmentRule.perChangeMaximumIncreaseRatePercent);
				interestRateAdjustmentModel.setFirstPerChangeRateAdjustmentFrequencyMonthsCount(interestRatePerChangeAdjustmentRule.perChangeRateAdjustmentFrequencyMonthsCount);
			}
			else if("Subsequent".equalsIgnoreCase(interestRatePerChangeAdjustmentRule.adjustmentRuleType))
			{
				interestRateAdjustmentModel.setSubsequentAdjustmentRule(interestRatePerChangeAdjustmentRule.adjustmentRuleType);
				interestRateAdjustmentModel.setSubsequentPerChangeMaximumIncreaseRatePercent(interestRatePerChangeAdjustmentRule.perChangeMaximumIncreaseRatePercent);
				interestRateAdjustmentModel.setSubsequentPerChangeRateAdjustmentFrequencyMonthsCount(interestRatePerChangeAdjustmentRule.perChangeRateAdjustmentFrequencyMonthsCount);
			}
		}
		return interestRateAdjustmentModel;
    }
    
    /**
     * creates PrincipalAndInterestPaymentAdjustmentModel from principalAndInterestPaymentAdjustment, response for AP table
     * @param deal
     * @return PrincipalAndInterestPaymentAdjustmentModel
     */
    private PrincipalAndInterestPaymentAdjustmentModel createPrincipalAndInterestPaymentAdjustmentModel(Deal deal)
    {
    	PrincipalAndInterestPaymentAdjustmentModel principalAndInterestPaymentAdjustmentModel = new PrincipalAndInterestPaymentAdjustmentModel();
    	PrincipalAndInterestPaymentAdjustment principalAndInterestPaymentAdjustment = new PrincipalAndInterestPaymentAdjustment((Element)deal.getElementAddNS("LOANS/LOAN/ADJUSTMENT/PRINCIPAL_AND_INTEREST_PAYMENT_ADJUSTMENT"));
    	
    	principalAndInterestPaymentAdjustmentModel.setFirstPrincipalAndInterestPaymentChangeMonthsCount(principalAndInterestPaymentAdjustment.principalAndInterestPaymentLifetimeAdjustmentRule.firstPrincipalAndInterestPaymentChangeMonthsCount);
    	principalAndInterestPaymentAdjustmentModel.setPrincipalAndInterestPaymentMaximumAmount(principalAndInterestPaymentAdjustment.principalAndInterestPaymentLifetimeAdjustmentRule.principalAndInterestPaymentMaximumAmount);
    	principalAndInterestPaymentAdjustmentModel.setPrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount(principalAndInterestPaymentAdjustment.principalAndInterestPaymentLifetimeAdjustmentRule.principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount);
    	
    	PrincipalAndInterestPaymentPerChangeAdjustmentRule[] principalAndInterestPaymentPerChangeAdjustmentRule = principalAndInterestPaymentAdjustment.principalAndInterestPaymentPerChangeAdjustmentRules.principalAndInterestPaymentPerChangeAdjustmentRules;
    	
    	for(int i=0; i<principalAndInterestPaymentPerChangeAdjustmentRule.length; i++)
    	{
    		if("First".equalsIgnoreCase(principalAndInterestPaymentPerChangeAdjustmentRule[i].adjustmentRuleType))
    		{
	    		principalAndInterestPaymentAdjustmentModel.setFirstAdjustmentRuleType(principalAndInterestPaymentPerChangeAdjustmentRule[i].adjustmentRuleType);
	        	principalAndInterestPaymentAdjustmentModel.setFirstPerChangeMaximumPrincipalAndInterestPaymentAmount(principalAndInterestPaymentPerChangeAdjustmentRule[i].perChangeMaximumPrincipalAndInterestPaymentAmount);
	        	principalAndInterestPaymentAdjustmentModel.setFirstPerChangeMinimumPrincipalAndInterestPaymentAmount(principalAndInterestPaymentPerChangeAdjustmentRule[i].perChangeMinimumPrincipalAndInterestPaymentAmount);
	        	principalAndInterestPaymentAdjustmentModel.setFirstPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount(principalAndInterestPaymentPerChangeAdjustmentRule[i].perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount);
    		}
    		else if("Subsequent".equalsIgnoreCase(principalAndInterestPaymentPerChangeAdjustmentRule[i].adjustmentRuleType))
    		{
	        	principalAndInterestPaymentAdjustmentModel.setSubsequentAdjustmentRuleType(principalAndInterestPaymentPerChangeAdjustmentRule[i].adjustmentRuleType);
	        	principalAndInterestPaymentAdjustmentModel.setSubsequentPerChangeMaximumPrincipalAndInterestPaymentAmount(principalAndInterestPaymentPerChangeAdjustmentRule[i].perChangeMaximumPrincipalAndInterestPaymentAmount);
	        	principalAndInterestPaymentAdjustmentModel.setSubsequentPerChangeMinimumPrincipalAndInterestPaymentAmount(principalAndInterestPaymentPerChangeAdjustmentRule[i].perChangeMinimumPrincipalAndInterestPaymentAmount);
	        	principalAndInterestPaymentAdjustmentModel.setSubsequentPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount(principalAndInterestPaymentPerChangeAdjustmentRule[i].perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount);
    		}
    	}
    	
    	return principalAndInterestPaymentAdjustmentModel;
    	
    }
    
    /**
     * create PaymentModel in JSON response
     * @param deal
     * @return PaymentModel
     */
    private PaymentModel createPaymentModel(Deal deal)
    {
    	PaymentModel paymentModel = new PaymentModel();
    	PartialPaymentsModel partialPaymentsModel = new PartialPaymentsModel();
    	PaymentRuleModel paymentRuleModel = new PaymentRuleModel();
    	
    	Payment payment = new Payment(null, (Element)deal.getElementAddNS("LOANS/LOAN/PAYMENT"));
    	
    	List<PartialPaymentModel> partialPaymentsModels = new LinkedList<>();
    	
    	PartialPayment[] partialPayments = payment.partialPayments.partialPayments;
    	
    	for(int i=0; i<partialPayments.length; i++)
    	{
    		PartialPaymentModel partialPayment = new PartialPaymentModel();
    			partialPayment.setPartialPaymentApplicationMethodType(partialPayments[i].partialPaymentApplicationMethodType);
    			partialPayment.setPartialPaymentApplicationMethodTypeOtherDescription(partialPayments[i].partialPaymentApplicationMethodTypeOtherDescription);
    		 partialPaymentsModels.add(partialPayment);
    	}
    	
	    	paymentRuleModel.setFullyIndexedInitialPrincipalAndInterestPaymentAmount(payment.paymentRule.fullyIndexedInitialPrincipalAndInterestPaymentAmount);
	    	paymentRuleModel.setInitialPrincipalAndInterestPaymentAmount(payment.paymentRule.initialPrincipalAndInterestPaymentAmount);
	    	paymentRuleModel.setPartialPaymentAllowedIndicator(Boolean.parseBoolean(payment.paymentRule.partialPaymentAllowedIndicator));
	    	paymentRuleModel.setPaymentFrequencyType(payment.paymentRule.paymentFrequencyType);
	    	paymentRuleModel.setPaymentOptionIndicator(Boolean.parseBoolean(payment.paymentRule.paymentOptionIndicator));
	    	paymentRuleModel.setSeasonalPaymentPeriodEndMonth(payment.paymentRule.seasonalPaymentPeriodEndMonth);
	    	paymentRuleModel.setSeasonalPaymentPeriodStartMonth(payment.paymentRule.seasonalPaymentPeriodStartMonth);
	    	paymentRuleModel.setTotalOptionalPaymentCount(payment.paymentRule.other.totalOptionalPaymentCount);
	    	paymentRuleModel.setTotalStepPaymentCount(payment.paymentRule.other.totalStepPaymentCount);
    	
    	partialPaymentsModel.setPartialPaymentModels(partialPaymentsModels);
    	paymentModel.setPartialPayments(partialPaymentsModel);
    	paymentModel.setPaymentRule(paymentRuleModel);
		return paymentModel;
    	
    }
    
    /**
     * converts LateChargeRule to LateChargeRuleModel
     * @param deal
     * @return LateChargeRuleModel
     */
    private LateChargeRuleModel createLateChargeRuleModel(Deal deal)
    {
    	LateChargeRuleModel lateChargeRuleModel = new LateChargeRuleModel();
    	
    	LateChargeRule lateChargeRule = new LateChargeRule((Element)deal.getElement("mismo:LOANS/mismo:LOAN/mismo:LATE_CHARGE/mismo:EXTENSION/mismo:OTHER/gse:LATE_CHARGE_RULES/mismo:LATE_CHARGE_RULE"));
		
    	lateChargeRuleModel.setLateChargeAmount(lateChargeRule.lateChargeAmount);
    	lateChargeRuleModel.setLateChargeGracePeriodDaysCount(lateChargeRule.lateChargeGracePeriodDaysCount);
    	lateChargeRuleModel.setLateChargeRatePercent(lateChargeRule.lateChargeRatePercent);
    	lateChargeRuleModel.setLateChargeType(lateChargeRule.lateChargeType);
    	
    	return lateChargeRuleModel;
    }
    
    /**
     * converts IntegratedDisclosureDetail to IntegratedDisclosureDetailModel
     * @param deal
     * @return IntegratedDisclosureDetailModel
     */
    private IntegratedDisclosureDetailModel createIntegratedDisclosureDetail(Deal deal)
    {
    	IntegratedDisclosureDetailModel integratedDisclosureDetailModel = new IntegratedDisclosureDetailModel();
    	
    	IntegratedDisclosureDetail idDetail = new IntegratedDisclosureDetail((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_DETAIL"));
    	
	    	integratedDisclosureDetailModel.setFirstYearTotalEscrowPaymentAmount(idDetail.firstYearTotalEscrowPaymentAmount);
	    	integratedDisclosureDetailModel.setFirstYearTotalEscrowPaymentDescription(idDetail.firstYearTotalEscrowPaymentDescription);
	    	integratedDisclosureDetailModel.setFirstYearTotalNonEscrowPaymentAmount(idDetail.firstYearTotalNonEscrowPaymentAmount);
	    	integratedDisclosureDetailModel.setFirstYearTotalNonEscrowPaymentDescription(idDetail.firstYearTotalNonEscrowPaymentDescription);
	    	integratedDisclosureDetailModel.setIntegratedDisclosureHomeEquityLoanIndicator(Boolean.parseBoolean(idDetail.integratedDisclosureHomeEquityLoanIndicator));
	    	integratedDisclosureDetailModel.setIntegratedDisclosureIssuedDate(idDetail.integratedDisclosureIssuedDate);
	    	integratedDisclosureDetailModel.setIntegratedDisclosureLoanProductDescription(idDetail.integratedDisclosureLoanProductDescription);
		return integratedDisclosureDetailModel;
    }
    
    /**
     * creates LoanCalculations QualifiedMortgage for JSON Response 
     * @param deal
     * @return LoanCalculationsQualifiedMortgage
     */
    private LoanCalculationsQualifiedMortgage createLoanCalculationsQualifiedMortgage(Deal deal)
    {
    	LoanCalculationsQualifiedMortgage loanCalculationsQualifiedMortgage = new LoanCalculationsQualifiedMortgage();
    	LoanCalculationModel loanCalculationModel = new LoanCalculationModel();
    	QualifiedMortgageModel qualifiedMortgageModel = new QualifiedMortgageModel();
    	
    	FeeSummaryDetail feeSummaryDetail = new FeeSummaryDetail((Element)deal.getElementAddNS("LOANS/LOAN/FEE_INFORMATION/FEES_SUMMARY/FEE_SUMMARY_DETAIL"));
    	HighCostMortgages highCostMortgages = new HighCostMortgages(null, (Element)deal.getElementAddNS("LOANS/LOAN/HIGH_COST_MORTGAGES/HIGH_COST_MORTGAGE"));
    	QualifiedMortgage qualifiedMortgage = new QualifiedMortgage(null, (Element)deal.getElementAddNS("LOANS/LOAN/QUALIFIED_MORTGAGE"));
    	Foreclosures foreclosures =  new Foreclosures(null, (Element)deal.getElementAddNS("LOANS/LOAN/FORECLOSURES/FORECLOSURE/FORECLOSURE_DETAIL"));
    	
    	loanCalculationModel.setAprPercent(feeSummaryDetail.aprPercent);
    	loanCalculationModel.setFeeSummaryTotalFinanceChargeAmount(feeSummaryDetail.feeSummaryTotalFinanceChargeAmount);
    	loanCalculationModel.setFeeSummaryTotalAmountFinancedAmount(feeSummaryDetail.feeSummaryTotalAmountFinancedAmount);
    	loanCalculationModel.setFeeSummaryTotalInterestPercent(feeSummaryDetail.feeSummaryTotalInterestPercent);
    	loanCalculationModel.setFeeSummaryTotalOfAllPaymentsAmount(feeSummaryDetail.feeSummaryTotalOfAllPaymentsAmount);
    	loanCalculationModel.setDeficiencyRightsPreservedIndicator(Boolean.parseBoolean(foreclosures.deficiencyRightsPreservedIndicator));
    	
    	qualifiedMortgageModel.setAveragePrimeOfferRatePercent(highCostMortgages.averagePrimeOfferRatePercent);
    	qualifiedMortgageModel.setRegulationZExcludedBonaFideDiscountPointsIndicator(Boolean.parseBoolean(highCostMortgages.regulationZExcludedBonaFideDiscountPointsIndicator));
    	qualifiedMortgageModel.setRegulationZExcludedBonaFideDiscountPointsPercent(highCostMortgages.regulationZExcludedBonaFideDiscountPointsPercent);
    	qualifiedMortgageModel.setRegulationZTotalAffiliateFeesAmount(highCostMortgages.regulationZTotalAffiliateFeesAmount);
    	qualifiedMortgageModel.setRegulationZTotalLoanAmount(highCostMortgages.regulationZTotalLoanAmount);
    	qualifiedMortgageModel.setRegulationZTotalPointsAndFeesAmount(highCostMortgages.regulationZTotalPointsAndFeesAmount);
    	
    	qualifiedMortgageModel.setAbilityToRepayExemptionReasonType(qualifiedMortgage.exemption.abilityToRepayExemptionReasonType);
    	qualifiedMortgageModel.setAbilityToRepayMethodType(qualifiedMortgage.qualifiedMortgageDetail.abilityToRepayMethodType);
    	
    	loanCalculationsQualifiedMortgage.setLoanCalculationModel(loanCalculationModel);
    	loanCalculationsQualifiedMortgage.setQualifiedMortgage(qualifiedMortgageModel);
		
    	return loanCalculationsQualifiedMortgage;
    }
    
    /**
     * create contact information for JSON response
     * @param deal
     * @return ContactInformationModel
     */
     private ContactInformationModel createContactInformation(Deal deal)
    {
    
		ContactInformationModel contactInformationModel = new ContactInformationModel();
		Parties parties = new Parties((Element)deal.getElementAddNS("PARTIES"));
		
		List<Party> closingAgent = new LinkedList<>();
		List<Party> lender = new LinkedList<>();
		List<Party> realEstateAgentB = new LinkedList<>();
		List<Party> realEstateAgentS = new LinkedList<>();
		List<Party> mortgageBroker = new LinkedList<>();
		
       	if(parties.parties.length >0)
		for(int i=0;i<parties.parties.length; i++)
		{	
			if(null != parties.parties[i].roles.element)
				switch(parties.parties[i].roles.roles[0].roleDetail.PartyRoleType)
				{
					case "ClosingAgent":
						closingAgent.add(parties.parties[i]);
					break;
					case "NotePayTo":
						lender.add(parties.parties[i]);
					break;
					case "RealEstateAgent":
						if ("Selling".equalsIgnoreCase(parties.parties[i].roles.roles[0].realEstateAgent.realEstateAgentType))
							realEstateAgentB.add(parties.parties[i]);
						else if("Listing".equalsIgnoreCase(parties.parties[i].roles.roles[0].realEstateAgent.realEstateAgentType))
							realEstateAgentS.add(parties.parties[i]);
					break;
					case "MortgageBroker":
						mortgageBroker.add(parties.parties[i]);
					break;
				}  		
		}
       	
   		if(lender.size()>0)
   			contactInformationModel.setLender(getContactInformationDetail(lender, "NotePayTo"));
   		if(mortgageBroker.size()>0)
   			contactInformationModel.setMortagageBroker(getContactInformationDetail(mortgageBroker, "MortgageBroker"));
   		if(realEstateAgentB.size()>0)
   			contactInformationModel.setRealEstateBrokerB(getContactInformationDetail(realEstateAgentB, "RealEstateAgent"));
   		if(realEstateAgentS.size()>0)
   			contactInformationModel.setRealEstateBrokerS(getContactInformationDetail(realEstateAgentS, "RealEstateAgent"));
   		if(closingAgent.size()>0)
   			contactInformationModel.setSettlementAgent(getContactInformationDetail(closingAgent, "ClosingAgent"));
        	
    		return contactInformationModel;
        	
        }
     
   /**
    * get all the details from party and assigns to contactinformationDetail
    * @param party
    * @return ContactInformationDetail
    */
    private ContactInformationDetail getContactInformationDetail(List<Party> parties, String partyType)
    {
    	ContactInformationDetail contactInformationDetail = new ContactInformationDetail();
    	AddressModel addressModel = new AddressModel();
		NameModel nameModel = new NameModel();
		LicenseDetailModel individualLicenseDetail = new LicenseDetailModel();
		LicenseDetailModel organizationLicenseDetail = new LicenseDetailModel();
		
    	parties.forEach(party ->{
    		
    		for(int i=0;i<party.addresses.addresses.length; i++)
	    	{
    			if(null != party.addresses.element && null != party.addresses.addresses[i].element)
    			{
    				Address address = party.addresses.addresses[i];
	    				addressModel.setAddressLineText(address.addressLineText);
	    				addressModel.setAddressType(address.addressType);
	    				addressModel.setCityName(address.cityName);
	    				addressModel.setStateCode(address.stateCode);
	    				addressModel.setCountryCode(address.countryCode);
	    				addressModel.setPostalCode(address.postalCode);
    			}
	    	}
    	
	    	contactInformationDetail.setPartyRoleType(partyType);
	    	
    	if(null != party.legalEntity.legalEntityDetail.element)
	   	{
    		contactInformationDetail.setOrganizationName(party.legalEntity.legalEntityDetail.fullName);
	    		
	    		if(null != party.roles.element && null != party.roles.roles[0].licenses.element && null != party.roles.roles[0].licenses.licenses[0].licenseDetail.element)
				{
					LicenseDetail licenseDetail = party.roles.roles[0].licenses.licenses[0].licenseDetail;
					
					organizationLicenseDetail.setIdentifierOwnerURI(licenseDetail.identifierOwnerURI);
					organizationLicenseDetail.setLicenseAuthorityLevelType(licenseDetail.licenseAuthorityLevelType);
					organizationLicenseDetail.setLicenseIdentifier(licenseDetail.licenseIdentifier);
					organizationLicenseDetail.setLicenseIssueDate(licenseDetail.licenseIssueDate);
					organizationLicenseDetail.setLicenseIssuingAuthorityName(licenseDetail.licenseIssuingAuthorityName);
					organizationLicenseDetail.setLicenseIssuingAuthorityStateCode(licenseDetail.licenseIssuingAuthorityStateCode);
				}
	    	}
	    	if(null != party.individual.element && null != party.individual.name.element)
	    	{	
	    		Name name = party.individual.name;
	    		
    			nameModel.setFirstName(name.firstName);
    			nameModel.setFullName(name.fullName);
    			nameModel.setLastName(name.lastName);
    			nameModel.setMiddleName(name.middleName);
    			nameModel.setSuffixName(name.suffixName);
				
				if(null != party.roles.element &&  null != party.roles.roles[0].licenses.element && null != party.roles.roles[0].licenses.licenses[0].licenseDetail.element)
				{
					LicenseDetail licenseDetail = party.roles.roles[0].licenses.licenses[0].licenseDetail;
					
					individualLicenseDetail.setIdentifierOwnerURI(licenseDetail.identifierOwnerURI);
					individualLicenseDetail.setLicenseAuthorityLevelType(licenseDetail.licenseAuthorityLevelType);
					individualLicenseDetail.setLicenseIdentifier(licenseDetail.licenseIdentifier);
					individualLicenseDetail.setLicenseIssueDate(licenseDetail.licenseIssueDate);
					individualLicenseDetail.setLicenseIssuingAuthorityName(licenseDetail.licenseIssuingAuthorityName);
					individualLicenseDetail.setLicenseIssuingAuthorityStateCode(licenseDetail.licenseIssuingAuthorityStateCode);
				}
	    	
    	}
	    	if(null != party.individual.element && null != party.individual.contactPoints.element)
	    	{	
	    		for(int i=0; i<party.individual.contactPoints.contactPoints.length; i++)
	    		{
	    			if(null != party.individual.contactPoints.contactPoints[i].contactPointEmail.element)
	    				contactInformationDetail.setIndividualEmail(party.individual.contactPoints.contactPoints[i].contactPointEmail.ContactPointEmailValue);
	    			if(null != party.individual.contactPoints.contactPoints[i].contactPointTelephone.element)
	    				contactInformationDetail.setIndividualPhone(party.individual.contactPoints.contactPoints[i].contactPointTelephone.ContactPointTelephoneValue);
	    		}
	    	}
    	});
    	
    	contactInformationDetail.setAddress(addressModel);
    	contactInformationDetail.setIndividualLicenseDetail(individualLicenseDetail);
    	contactInformationDetail.setOrganizationLicenseDetail(organizationLicenseDetail);
    	contactInformationDetail.setName(nameModel);
    	
		return contactInformationDetail;
    }
    
    /**
     * converts loan detail to LoanDetailModel
     * @param loanDetail
     * @return LoanDetailModel
     */
    private LoanDetailModel createLoanDetailModel(Deal deal)
    {
    	LoanDetail loanDetail = new LoanDetail((Element)deal.getElementAddNS("LOANS/LOAN/LOAN_DETAIL"));	
  	    
    	LoanDetailModel loanDetailModel = new LoanDetailModel();
	    	loanDetailModel.setAssumabilityIndicator(Boolean.parseBoolean(loanDetail.assumabilityIndicator));
	    	loanDetailModel.setBalloonIndicator(Boolean.parseBoolean(loanDetail.balloonIndicator));
	    	loanDetailModel.setBalloonPaymentAmount(loanDetail.balloonPaymentAmount);
	    	loanDetailModel.setBuydownTemporarySubsidyFundingIndicator(Boolean.parseBoolean(loanDetail.buydownTemporarySubsidyFundingIndicator));
	    	loanDetailModel.setConstructionLoanIndicator(Boolean.parseBoolean(loanDetail.constructionLoanIndicator));
	    	loanDetailModel.setCreditorServicingOfLoanStatementType(loanDetail.creditorServicingOfLoanStatementType);
	    	loanDetailModel.setDemandFeatureIndicator(Boolean.parseBoolean(loanDetail.demandFeatureIndicator));
	    	loanDetailModel.setEscrowAbsenceReasonType(loanDetail.escrowAbsenceReasonType);
	    	loanDetailModel.setEscrowIndicator(Boolean.parseBoolean(loanDetail.escrowIndicator));
	    	loanDetailModel.setInterestOnlyIndicator(Boolean.parseBoolean(loanDetail.interestOnlyIndicator));
	    	loanDetailModel.setInterestRateIncreaseIndicator(Boolean.parseBoolean(loanDetail.interestRateIncreaseIndicator));
	    	loanDetailModel.setLoanAmountIncreaseIndicator(Boolean.parseBoolean(loanDetail.loanAmountIncreaseIndicator));
	    	loanDetailModel.setMiRequiredIndicator(Boolean.parseBoolean(loanDetail.miRequiredIndicator));
	    	loanDetailModel.setNegativeAmortizationIndicator(Boolean.parseBoolean(loanDetail.negativeAmortizationIndicator));
	    	loanDetailModel.setPaymentIncreaseIndicator(Boolean.parseBoolean(loanDetail.paymentIncreaseIndicator));
	    	loanDetailModel.setPrepaymentPenaltyIndicator(Boolean.parseBoolean(loanDetail.prepaymentPenaltyIndicator));
	    	loanDetailModel.setSeasonalPaymentFeatureIndicator(Boolean.parseBoolean(loanDetail.seasonalPaymentFeatureIndicator));
	    	loanDetailModel.setStepPaymentsFeatureDescription(loanDetail.stepPaymentsFeatureDescription);
	    	loanDetailModel.setTotalSubordinateFinancingAmount(loanDetail.totalSubordinateFinancingAmount);
	    	loanDetailModel.setSubordinateFinancingIsNewIndicator(Boolean.parseBoolean(loanDetail.subordinateFinancingIsNewIndicator));
	    	
		return loanDetailModel;
    }
    
    /**
     * converts loanTerms to TermsOfLoanModel
     * @param loanTerms
     * @return TermsOfLoanModel
     */
    private TermsOfLoanModel createTermsOfLoanModel(Deal deal)
    {
    	TermsOfLoan loanTerms = new TermsOfLoan((Element)deal.getElementAddNS("LOANS/LOAN/TERMS_OF_LOAN"));
 	   
    	TermsOfLoanModel termsOfLoanModel = new TermsOfLoanModel();
	    	termsOfLoanModel.setAssumedLoanAmount(loanTerms.assumedLoanAmount);
	    	termsOfLoanModel.setDisclosedFullyIndexedRatePercent(loanTerms.disclosedFullyIndexedRatePercent);
	    	termsOfLoanModel.setLienPriorityType(loanTerms.lienPriorityType);
	    	termsOfLoanModel.setLoanPurposeType(loanTerms.loanPurposeType);
	    	termsOfLoanModel.setMortgageType(loanTerms.mortgageType);
	    	termsOfLoanModel.setMortgageTypeOtherDescription(loanTerms.mortgageTypeOtherDescription);
	    	termsOfLoanModel.setNoteAmount(loanTerms.noteAmount);
	    	termsOfLoanModel.setNoteRatePercent(loanTerms.noteRatePercent);
	    	termsOfLoanModel.setWeightedAverageInterestRatePercent(loanTerms.weightedAverageInterestRatePercent);
	    	
		return termsOfLoanModel;
    }
    
    /**
     * converts DocumentClassification to DocumentClassificationModel for JSON response
     * @param document
     * @return DocumentClassificationModel
     */
    private DocumentClassificationModel createDocumentClassificationModel(Document document)
    {
    	DocumentClassification docClassification = new DocumentClassification(Document.NS, (Element)document.getElementAddNS("DOCUMENT_CLASSIFICATION"));
 	    DocumentClassificationModel documentClassification = new DocumentClassificationModel();

 	    documentClassification.setDocumentFormIssuingEntityNameType(docClassification.documentClassificationDetail.documentFormIssuingEntityNameType);
 	    documentClassification.setDocumentFormIssuingEntityVersionIdentifier(docClassification.documentClassificationDetail.documentFormIssuingEntityVersionIdentifier);
 	    documentClassification.setDocumentSignatureRequiredIndicator(Boolean.parseBoolean(docClassification.documentClassificationDetail.other.documentSignatureRequiredIndicator));
 	    documentClassification.setDocumentType(docClassification.documentClasses.documentClass.documentType);
 	    documentClassification.setDocumentTypeOtherDescription(docClassification.documentClasses.documentClass.documentTypeOtherDescription);
 	    
		return documentClassification;
    }
    
   /**
    * converts integratedDisclosureSectionSummary to IntegratedDisclosureSectionSummaryModel
    * @param integratedDisclosureSectionSummary
    * @return IntegratedDisclosureSectionSummaryModel
    */
    private IntegratedDisclosureSectionSummaryModel toIntegratedDisclosureSectionSummaryModel(IntegratedDisclosureSectionSummary integratedDisclosureSectionSummary)
    {
    	IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
    	IntegratedDisclosureSectionSummaryDetailModel integratedDisclosureSectionSummaryDetailModel = new IntegratedDisclosureSectionSummaryDetailModel();
    	IntegratedDisclosureSectionSummaryDetail integratedDisclosureSectionSummaryDetail = integratedDisclosureSectionSummary.integratedDisclosureSectionSummaryDetail;
    	
    	integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionTotalAmount(integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionTotalAmount);
    	integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionType(integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType);
    	integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSubsectionTotalAmount(integratedDisclosureSectionSummaryDetail.integratedDisclosureSubsectionTotalAmount);
    	integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSubsectionType(integratedDisclosureSectionSummaryDetail.integratedDisclosureSubsectionType);
    	integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSubsectionTypeOtherDescription(integratedDisclosureSectionSummaryDetail.integratedDisclosureSubsectionTypeOtherDescription);
    	integratedDisclosureSectionSummaryDetailModel.setLenderCreditToleranceCureAmount(integratedDisclosureSectionSummaryDetail.lenderCreditToleranceCureAmount);
    		
    	IntegratedDisclosureSubsectionPayment[] integratedDisclosureSubsectionPayments = integratedDisclosureSectionSummary.integratedDisclosureSubsectionPayments.integratedDisclosureSubsectionPayments;
    		
    	for(int i=0; i<integratedDisclosureSubsectionPayments.length; i++)
    	{
    		IntegratedDisclosureSubsectionPaymentModel integratedDisclosureSubsectionPaymentModel = new IntegratedDisclosureSubsectionPaymentModel();
    			integratedDisclosureSubsectionPaymentModel.setIntegratedDisclosureSubsectionPaidByType(integratedDisclosureSubsectionPayments[i].integratedDisclosureSubsectionPaidByType);
    			integratedDisclosureSubsectionPaymentModel.setIntegratedDisclosureSubsectionPaymentAmount(integratedDisclosureSubsectionPayments[i].integratedDisclosureSubsectionPaymentAmount);
    			integratedDisclosureSubsectionPaymentModel.setIntegratedDisclosureSubsectionPaymentTimingType(integratedDisclosureSubsectionPayments[i].integratedDisclosureSubsectionPaymentTimingType);
    		integratedDisclosureSectionSummaryModel.getIntegratedDisclosureSubsectionPayments().add(integratedDisclosureSubsectionPaymentModel);
    	}
    	
    	integratedDisclosureSectionSummaryModel.setIntegratedDisclosureSectionSummaryDetailModel(integratedDisclosureSectionSummaryDetailModel);
    	
		return integratedDisclosureSectionSummaryModel;
    }
    
    /**
     * converts closingCostFundList to ClosingCostFundModel list
     * @param closingCostFundList
     * @return ClosingCostFundModel List
     */
    private List<ClosingCostFundModel> createClosingCostFundModels(Deal deal) {
    	ClosingInformation closingInformation =  new ClosingInformation(null, (Element)deal.getElementAddNS("LOANS/LOAN/CLOSING_INFORMATION"));
    	
    	ClosingCostFund[] closingCostFundList = closingInformation.closingCostFunds.closingCostFundList;
    	
    	List<ClosingCostFundModel> closingCostFundModels = new LinkedList<>();
    	for(int i=0; i<closingCostFundList.length;i++)
    	{
    		ClosingCostFundModel closingCostFundModel = new ClosingCostFundModel();
    			closingCostFundModel.setClosingCostFundAmount(closingCostFundList[i].closingCostFundAmount);
    			closingCostFundModel.setFundsType(closingCostFundList[i].fundsType);
    			closingCostFundModel.setIntegratedDisclosureSectionType(closingCostFundList[i].integratedDisclosureSectionType);
    		closingCostFundModels.add(closingCostFundModel);
    	}
    	return closingCostFundModels;
	}

    /**
     * converts closingAdjustmentItemList to ClosingAdjustmentItemModel list
     * @param closingAdjustmentItemList
     * @return list of ClosingAdjustmentItemModel
     */
	private List<ClosingAdjustmentItemModel> createClosingAdjustmentModels(Deal deal) {
		ClosingInformation closingInformation =  new ClosingInformation(null, (Element)deal.getElementAddNS("LOANS/LOAN/CLOSING_INFORMATION"));
		
		ClosingAdjustmentItem[] closingAdjustmentItemList = closingInformation.closingAdjustmentItems.closingAdjustmentItemList;
    	
		List<ClosingAdjustmentItemModel> closingAdjustmentItemModels = new LinkedList<>();
    	
		for(int i=0;i<closingAdjustmentItemList.length;i++)
    	{
    		ClosingAdjustmentItemModel closingAdjustmentItemModel = new ClosingAdjustmentItemModel();
    			closingAdjustmentItemModel.setDisplayLabel(closingAdjustmentItemList[i].closingAdjustmentItemDetail.displayLabelText);
    			closingAdjustmentItemModel.setClosingAdjustmentItemAmount(closingAdjustmentItemList[i].closingAdjustmentItemDetail.closingAdjustmentItemAmount);
    			closingAdjustmentItemModel.setClosingAdjustmentItemPaidOutsideOfClosingIndicator(Boolean.parseBoolean(closingAdjustmentItemList[i].closingAdjustmentItemDetail.closingAdjustmentItemPaidOutsideOfClosingIndicator));
    			closingAdjustmentItemModel.setClosingAdjustmentItemType(closingAdjustmentItemList[i].closingAdjustmentItemDetail.closingAdjustmentItemType);
    			closingAdjustmentItemModel.setClosingAdjustmentItemTypeOtherDescription(closingAdjustmentItemList[i].closingAdjustmentItemDetail.closingAdjustmentItemTypeOtherDescription);
    			closingAdjustmentItemModel.setIntegratedDisclosureSectionType(closingAdjustmentItemList[i].closingAdjustmentItemDetail.integratedDisclosureSectionType);
    			closingAdjustmentItemModel.setIntegratedDisclosureSubsectionType(closingAdjustmentItemList[i].closingAdjustmentItemDetail.integratedDisclosureSubsectionType);
    			closingAdjustmentItemModel.setPaidByEntityFullName(closingAdjustmentItemList[i].paidBy.legalEntity.legalEntityDetail.fullName);
    			closingAdjustmentItemModel.setPaidByIndividualFullName(closingAdjustmentItemList[i].paidBy.individual.name.fullName);
    			closingAdjustmentItemModel.setPaidToEntityFullName(closingAdjustmentItemList[i].paidToEntityFullName);
    		closingAdjustmentItemModels.add(closingAdjustmentItemModel);
    		
    	}
    	
		return closingAdjustmentItemModels;
	}
	
	/**
	 * converts liability to liability Models 
	 * @param liability
	 * @return list of liability Model
	 */
	private List<LiabilityModel> createLiabilityModels(Deal deal) {
		Liabilities liabilities = new Liabilities(null, (Element)deal.getElementAddNS("LIABILITIES/")); 
		Liability[] liability = liabilities.liabilityList;
    	List<LiabilityModel> liabilityModels = new LinkedList<>();
    	
    	for(int i=0; i<liability.length; i++)
    	{
    		LiabilityModel liabilityModel = new LiabilityModel();
    			liabilityModel.setDisplayLabel(liability[i].liabilityDetail.displayLabelText);
	    		liabilityModel.setIntegratedDisclosureSectionType(liability[i].liabilityDetail.other.integratedDisclosureSectionType);
	    		liabilityModel.setLiabilityDescription(liability[i].liabilityDetail.liabilityDescription);
	    		liabilityModel.setLiabilityHolderFullName(liability[i].liabilityholderName.fullName);
	    		liabilityModel.setLiabilitySecuredBySubjectPropertyIndicator(Boolean.parseBoolean(liability[i].liabilityDetail.other.liabilitySecuredBySubjectPropertyIndicator));
	    		liabilityModel.setLiabilityType(liability[i].liabilityDetail.liabilityType);
	    		liabilityModel.setLiabilityTypeOtherDescription(liability[i].liabilityDetail.liabilityTypeOtherDescription);
	    		liabilityModel.setPayoffAmount(liability[i].payOff.payoffAmount);
	    		liabilityModel.setPayoffPrepaymentPenaltyAmount(liability[i].payOff.payoffPrepaymentPenaltyAmount);
	    		liabilityModel.setPayoffPartialIndicator(Boolean.parseBoolean(liability[i].payOff.payoffPartialIndicator));
	    	liabilityModels.add(liabilityModel);
    	}
		return liabilityModels;
	}
	
	/**
	 * converts ProrationItem to Proration Model
	 * @param prorationItemList
	 * @return List of ProrationModel
	 */
	private List<ProrationModel> createProrationsModels(Deal deal) {
		
		ClosingInformation closingInformation =  new ClosingInformation(null, (Element)deal.getElementAddNS("LOANS/LOAN/CLOSING_INFORMATION"));
		
		ProrationItem[] prorationItemList = closingInformation.prorationItems.prorationItemList;
		
		List<ProrationModel> prorationsModels = new LinkedList<>();
    	
    	for(int i=0; i<prorationItemList.length;i++)
    	{
    		ProrationModel prorationsModel = new ProrationModel();
    			prorationsModel.setDisplayLabel(prorationItemList[i].displayLabelText);
    			prorationsModel.setIntegratedDisclosureSectionType(prorationItemList[i].integratedDisclosureSectionType);
    			prorationsModel.setIntegratedDisclosureSubsectionType(prorationItemList[i].integratedDisclosureSubsectionType);
    			prorationsModel.setProrationItemAmount(prorationItemList[i].prorationItemAmount);
    			prorationsModel.setProrationItemPaidFromDate(prorationItemList[i].prorationItemPaidFromDate);
    			prorationsModel.setProrationItemPaidThroughDate(prorationItemList[i].prorationItemPaidThroughDate);
    			prorationsModel.setProrationItemType(prorationItemList[i].prorationItemType);
    			prorationsModel.setProrationItemTypeOtherDescription(prorationItemList[i].prorationItemTypeOtherDescription);
    		prorationsModels.add(prorationsModel);
    	}
    	
		return prorationsModels;
	}
	
	/**
     * insert values to UI response
     * @param cashToCloseItem
     * @param displayLabel
     * @param index
     * @return CashToCloseModel
     */
	private CashToCloseModel setCashToClose(CashToCloseItem cashToCloseItem, String displayLabel, String index)
	{
		CashToCloseModel cashToCashToCloseModel = new CashToCloseModel();
		if(!"-1".equals(index))
		{
			cashToCashToCloseModel.setIndex(index);
			cashToCashToCloseModel.setIntegratedDisclosureCashToCloseItemAmountChangedIndicator(Boolean.parseBoolean(cashToCloseItem.integratedDisclosureCashToCloseItemAmountChangedIndicator));
			cashToCashToCloseModel.setIntegratedDisclosureCashToCloseItemChangeDescription(cashToCloseItem.integratedDisclosureCashToCloseItemChangeDescription);
			cashToCashToCloseModel.setIntegratedDisclosureCashToCloseItemEstimatedAmount(cashToCloseItem.integratedDisclosureCashToCloseItemEstimatedAmount);
			cashToCashToCloseModel.setIntegratedDisclosureCashToCloseItemFinalAmount(cashToCloseItem.integratedDisclosureCashToCloseItemFinalAmount);
			cashToCashToCloseModel.setIntegratedDisclosureCashToCloseItemPaymentType(cashToCloseItem.integratedDisclosureCashToCloseItemPaymentType);
			cashToCashToCloseModel.setIntegratedDisclosureCashToCloseItemType(cashToCloseItem.integratedDisclosureCashToCloseItemType);
		}
		return cashToCashToCloseModel;
	}
	
    /**
     * Populates the EscrowItem from XML for a given escrow type
     * @param escrowItems
     * @param escrowType
     * @return EscrowsModel
     */
    private EscrowItem getEscrowItem(EscrowItems escrowItems, String escrowType){
		EscrowItem escrowItem = new EscrowItem(null);
		
		for(int i=0; i<escrowItems.escrowItems.length;i++)
 	    {
        	EscrowItemDetail escrowItemDetail = escrowItems.escrowItems[i].escrowItemDetail;
        	
        	if(escrowType.equalsIgnoreCase(escrowItemDetail.escrowItemType))
        	{
        		   escrowItem = escrowItems.escrowItems[i];
        	}
 	    }
		return escrowItem;
	}
    
	/**
	 * calculates the salePrice
	 * @param loanTerms
	 * @param salesContractDetail
	 * @param propertyValuationDetail
	 * @param propertyDetail
	 * @return saleprice as a String
	 */
	private static String salePrice(TermsOfLoan loanTerms, SalesContractDetail salesContractDetail, PropertyValuationDetail propertyValuationDetail, PropertyDetail propertyDetail) {
		if (!loanTerms.loanPurposeType.equalsIgnoreCase("Purchase"))
			if (propertyValuationDetail.propertyValuationAmount.equals(""))
				return propertyDetail.propertyEstimatedValueAmount;
			else
				return propertyValuationDetail.propertyValuationAmount;		
		if (salesContractDetail.personalPropertyIncludedIndicator.equalsIgnoreCase("true"))
			return salesContractDetail.realPropertyAmount;
		return salesContractDetail.salesContractAmount;
	}
	
	/**
	 * fetch the Name Model from XML
	 * @param name
	 * @return name detail
	 */
	private static NameModel toNameModel(Name name) {
		NameModel nameModel = new NameModel();
		
		if (!name.fullName.equals(""))
			nameModel.setFullName(name.fullName);
		if (!name.middleName.equals("")) 
			nameModel.setMiddleName(name.middleName);
		if (!name.lastName.equals("")) 
			nameModel.setLastName(name.lastName);
		if (!name.suffixName.equals("")) 
			nameModel.setSuffixName(name.suffixName);
		
		return nameModel;
	}
	
	/**
	 * fetch the address model from XML
	 * @param address
	 * @return address Model
	 */
	private static AddressModel toAddressModel(Address address) {
	AddressModel addressModel = new AddressModel();
		
		if (!"".equals(address.addressType))
			addressModel.setAddressType(address.addressType);
		if (!"".equals(address.cityName))
			addressModel.setCityName(address.cityName);
		if (!"".equals(address.addressLineText))
			addressModel.setAddressLineText(address.addressLineText);
		if (!"".equals(address.stateCode))
			addressModel.setStateCode(address.stateCode);
		if (!"".equals(address.postalCode)) 
			addressModel.setPostalCode(address.postalCode);
		if (!"".equals(address.countryCode)) 
			addressModel.setCountryCode(address.countryCode);
		return addressModel;
	}
	
	/**
	 * calculates the loan term
	 * @param loanDetail
	 * @param maturityRule
	 * @param construction
	 * @return loanTerm as a string
	 */
	private static String loanTerm(LoanDetail loanDetail, MaturityRule maturityRule, Construction construction) {
		if (loanDetail.constructionLoanIndicator.equalsIgnoreCase("true")) {
			if (construction.constructionLoanType.equalsIgnoreCase("ConstructionOnly"))
				return construction.constructionPeriodNumberOfMonthsCount;
			return construction.constructionLoanTotalTermMonthsCount;
		}
		return maturityRule.loanMaturityPeriodCount;
	}
	
	
    /**
     * fetches the list of sellers from the XMl
     * @param borrowers
     * @return borrowers list as JSON
     */
	private List<Borrower> createBorrowers(Parties borrowers, String partyRoleType) {
		
		List<Borrower> borrowersList = new LinkedList<>();
		if (borrowers.parties.length > 0) {
			for(int i=0; i<borrowers.parties.length;i++)
			{
				Borrower borrower = new Borrower();
				NameModel applicant = new NameModel();
				AddressModel addressModel = new AddressModel();
				if (!borrowers.parties[i].legalEntity.legalEntityDetail.fullName.equals(""))
				{	
					applicant.setFullName(borrowers.parties[i].legalEntity.legalEntityDetail.fullName);
					borrower.setType("O");
				}
				else
				{
					applicant = toNameModel(borrowers.parties[i].individual.name);
					borrower.setType("I");
				}
				addressModel = toAddressModel(new Address((Element)borrowers.parties[i].getElementAddNS("ADDRESSES/ADDRESS[AddressType='Mailing']")));
				String status = borrowers.parties[i].getValueAddNS("LEGAL_DESCRIPTIONS/LEGAL_DESCRIPTION/UNPARSED_LEGAL_DESCRIPTIONS/UNPARSED_LEGAL_DESCRIPTION/UnparsedLegalDescription");
				addressModel.setUnparsedLegalDescription(status);
				addressModel.setLegalDescription(status.length() >0 ? true : false);
				borrower.setNameModel(applicant);
				borrower.setAddress(addressModel);
				borrower.setPartyRoleType(partyRoleType);
				borrowersList.add(borrower);
			}	
		}
		return borrowersList;
	}
	
	/**
	 * Insert Fee to Loan Costs Table
	 * @param fee
	 * @param sectionType
	 * @return ClosingCostProperties
	 */
	private ClosingCostProperties loanCostsTable(Fee fee,String sectionType) 
	{
		ClosingCostProperties closingCostProperties = new ClosingCostProperties();
		
		if(sectionType.equalsIgnoreCase(fee.feeDetail.integratedDisclosureSectionType))
		{
			if (("LoanDiscountPoints").equalsIgnoreCase(fee.feeDetail.feeType))
				if(!"".equals(fee.feeDetail.feeTotalPercent) && !"0.0000".equalsIgnoreCase(fee.feeDetail.feeTotalPercent)&& !"".equals(fee.feeDetail.feePaidToType))
				{
					closingCostProperties = feeCostsTableRow(fee);
				}
				else
				{
					closingCostProperties = feeCostsTableRow(fee);
				}
			else
				closingCostProperties = feeCostsTableRow(fee);
		}
		return closingCostProperties;
	}
	
    /**
     * Insert Fee Details
     * @param fee
     * @param withTo
     * @param label
     * @param to
     * @return ClosingCostProperties
     */
	private ClosingCostProperties feeCostsTableRow(Fee fee) 
	{
		ClosingCostProperties closingCostProperties = new ClosingCostProperties();
		
		closingCostProperties.setGseDisplayLabel(fee.feeDetail.displayLabelText);
		
		  if ("true".equals(fee.feeDetail.optionalCostIndicator) && !"".equals(fee.feeDetail.feePaidToTypeOtherDescription) && !fee.feeDetail.feePaidToTypeOtherDescription.toLowerCase().contains("optional"))
			  fee.feeDetail.displayLabelText += " (optional)";
	
		closingCostProperties.setFeeType(fee.feeDetail.feeType);
		closingCostProperties.setFeeTypeOtherDescription(fee.feeDetail.feePaidToTypeOtherDescription);
		closingCostProperties.setOptionalCostIndicator(Convertor.stringToBoolean(fee.feeDetail.optionalCostIndicator));
		closingCostProperties.setFeePaidToType(fee.feeDetail.feePaidToType);
		closingCostProperties.setFeePaidToTypeOtherDescription(fee.feeDetail.feePaidToTypeOtherDescription);
		closingCostProperties.setIntegratedDisclosureSectionType(fee.feeDetail.integratedDisclosureSectionType);
		closingCostProperties.setFeePercentBasisType(fee.feeDetail.feePercentBasisType);
		closingCostProperties.setRegulationZPointsAndFeesIndicator(Convertor.stringToBoolean(fee.feeDetail.regulationZPointsAndFeesIndicator));
		closingCostProperties.setPaymentIncludedInAPRIndicator(Convertor.stringToBoolean(fee.feeDetail.paymentIncludedInAPRIndicator));
		closingCostProperties.setFeeTotalPercent(fee.feeDetail.feeTotalPercent);
		closingCostProperties.setFeePaidToFullName(fee.feePaidTo.legalEntity.legalEntityDetail.fullName);
		closingCostProperties.setFeeActualTotalAmount(fee.feeDetail.feeActualTotalAmount);
		
		if(!"".equals(fee.feeDetail.displayLabelText))
			closingCostProperties.setDisplayLabel(fee.feeDetail.displayLabelText);
		else if("Other".equalsIgnoreCase(fee.feeDetail.feeType))
			    closingCostProperties.setDisplayLabel(StringFormatter.CAMEL.formatString(fee.feeDetail.feeTypeOtherDescription));
		else
			closingCostProperties.setDisplayLabel(StringFormatter.CAMEL.formatString(fee.feeDetail.feeType));
		
		if(fee.feePayments.feePayments.length > 0)
		for(FeePayment feepay :fee.feePayments.feePayments)
		{
			if(!"".equals(feepay.feePaymentPaidByType))
			{
				String paidByType = feepay.feePaymentPaidByType;
				if( "Buyer".equalsIgnoreCase(paidByType)) 
					if("true".equalsIgnoreCase(feepay.feePaymentPaidOutsideOfClosingIndicator))
			            closingCostProperties.setBpB4Closing((!"".equals(feepay.feeActualPaymentAmount) && StringFormatter.doubleValue(feepay.feeActualPaymentAmount) != 0) ? feepay.feeActualPaymentAmount : "");
					else
					    closingCostProperties.setBpAtClosing(((!"".equals(feepay.feeActualPaymentAmount) && StringFormatter.doubleValue(feepay.feeActualPaymentAmount) != 0)) ? feepay.feeActualPaymentAmount : "");
				else if("Seller".equalsIgnoreCase(paidByType))
					if("true".equalsIgnoreCase(feepay.feePaymentPaidOutsideOfClosingIndicator))
	                    closingCostProperties.setSpAtClosing((!"".equals(feepay.feeActualPaymentAmount) && StringFormatter.doubleValue(feepay.feeActualPaymentAmount) != 0) ? feepay.feeActualPaymentAmount : "");
					else
	                    closingCostProperties.setSpAtClosing((!"".equals(feepay.feeActualPaymentAmount) && StringFormatter.doubleValue(feepay.feeActualPaymentAmount) != 0) ? feepay.feeActualPaymentAmount : "");
				else
                     closingCostProperties.setPaidByOthers((!"".equals(feepay.feeActualPaymentAmount) && StringFormatter.doubleValue(feepay.feeActualPaymentAmount) != 0) ? feepay.feeActualPaymentAmount : "");
				
				if("Lender".equalsIgnoreCase(paidByType))
					closingCostProperties.setLenderStatus(true);
				else
					closingCostProperties.setLenderStatus(false);
			}

		}
		
		return closingCostProperties;
	}
	
	/**
	 * Calculate Total Loan Costs
	 * @param totalLoanCosts
	 * @param integratedDisclosureSectionSummaries
	 * @return
	 */
	private PaymentsModel calculateTLCosts(IntegratedDisclosureSectionSummaryDetail totalLoanCosts, IntegratedDisclosureSectionSummaries integratedDisclosureSectionSummaries)
	{
		PaymentsModel tlCosts = new PaymentsModel();
        	
		if(null != integratedDisclosureSectionSummaries.integratedDisclosureSectionSummaries)	
		for(IntegratedDisclosureSectionSummary integratedDisclosureSectionSummary : integratedDisclosureSectionSummaries.integratedDisclosureSectionSummaries){	
			if("TotalLoanCosts".equalsIgnoreCase(integratedDisclosureSectionSummary.integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType) && "LoanCostsSubtotal".equalsIgnoreCase(integratedDisclosureSectionSummary.integratedDisclosureSectionSummaryDetail.integratedDisclosureSubsectionType))
			{
				IntegratedDisclosureSubsectionPayments integratedDisclosureSubsectionPayments = integratedDisclosureSectionSummary.integratedDisclosureSubsectionPayments;
			    if(integratedDisclosureSubsectionPayments.integratedDisclosureSubsectionPayments.length>0)
				for(IntegratedDisclosureSubsectionPayment integrateddisclosuresubsectionpayment : integratedDisclosureSubsectionPayments.integratedDisclosureSubsectionPayments)
				{
										
					if(("Buyer").equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaidByType))
					{
						if(("AtClosing").equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentTimingType))
							tlCosts.setBpAtClosing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
						else
							tlCosts.setBpB4Closing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
					}
					else if(("Seller").equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaidByType))
					{
						if(("AtClosing").equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentTimingType))
							tlCosts.setSpAtClosing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
						else
							tlCosts.setSpB4Closing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
					}
					else
						tlCosts.setPaidByOthers(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
					if("Lender".equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaidByType))
						tlCosts.setLenderStatus(true);
					
				}
			}
		}
		return tlCosts;
	}
	
	/**
	 * Extracts the elements from PrepaidItem and sets to Prepaids Model
	 * @param prepaidItem
	 * @param to
	 * @return Prepaids Model
	 */
	private Prepaids setPrepaids(PrepaidItem prepaidItem, boolean to)
	{
		Prepaids prepaid = new Prepaids();
		
		prepaid.setPrepaidItemType(prepaidItem.prepaidItemDetail.prepaidItemType);
		prepaid.setPrepaidItemTypeOtherDescription(prepaidItem.prepaidItemDetail.prepaidItemTypeOtherDescription);
		prepaid.setDisplayLabel(prepaidItem.prepaidItemDetail.displayLabelText);
		
		prepaid.setPrepaidItemPerDiemAmount(prepaidItem.prepaidItemDetail.prepaidItemPerDiemAmount);
		prepaid.setPrepaidItemPaidFromDate(prepaidItem.prepaidItemDetail.prepaidItemPaidFromDate);
		prepaid.setPrepaidItemPaidThroughDate(prepaidItem.prepaidItemDetail.prepaidItemPaidThroughDate);
		prepaid.setPrepaidItemMonthsPaidCount(prepaidItem.prepaidItemDetail.prepaidItemMonthsPaidCount);
		prepaid.setFeePaidToType(prepaidItem.prepaidItemDetail.feePaidToType);
		prepaid.setFeePaidToTypeOtherDescription(prepaidItem.prepaidItemDetail.feePaidToTypeOtherDescription);
		prepaid.setIntegratedDisclosureSectionType(prepaidItem.prepaidItemDetail.integratedDisclosureSectionType);
		prepaid.setPrepaidItemPerDiemCalculationMethodType(prepaidItem.prepaidItemDetail.prepaidItemPerDiemCalculationMethodType);
	 	prepaid.setPrepaidPaidToFullName(prepaidItem.prepaidItemPaidTo.legalEntity.legalEntityDetail.fullName);
		
		for(PrepaidItemPayment prepaidPayment: prepaidItem.prepaidItemPayments.prepaidItemPayments)
		{
			if( null != prepaidPayment.prepaidItemPaymentPaidByType)
			{
				String paidBy = prepaidPayment.prepaidItemPaymentPaidByType;
				if( "Buyer".equalsIgnoreCase(paidBy)) 
					if("BeforeClosing".equalsIgnoreCase(prepaidPayment.prepaidItemPaymentTimingType))
						prepaid.setBpB4Closing(prepaidPayment.prepaidItemActualPaymentAmount);
					else
						prepaid.setBpAtClosing(prepaidPayment.prepaidItemActualPaymentAmount);
				else if("Seller".equalsIgnoreCase(paidBy))
					if("BeforeClosing".equalsIgnoreCase(prepaidPayment.prepaidItemPaymentTimingType))
						prepaid.setSpB4Closing(prepaidPayment.prepaidItemActualPaymentAmount);
					else
						prepaid.setSpAtClosing(prepaidPayment.prepaidItemActualPaymentAmount);
				else
					prepaid.setPaidByOthers(prepaidPayment.prepaidItemActualPaymentAmount);
				if("Lender".equalsIgnoreCase(paidBy))
					 prepaid.setLenderStatus(true);
					else
					 prepaid.setLenderStatus(false);
			 }
		}
		return prepaid;		
	}
	
	/**
	 * Checks for property Tax
	 * @param type
	 * @return boolean
	 */
	private boolean isPropertyTax(String type)
	{
		if(null != type)
		return	   type.equalsIgnoreCase("BoroughPropertyTax")
				|| type.equalsIgnoreCase("CityPropertyTax")
				|| type.equalsIgnoreCase("CountyPropertyTax")
				|| type.equalsIgnoreCase("DistrictPropertyTax")
				|| type.equalsIgnoreCase("PropertyTaxes")
				|| type.equalsIgnoreCase("StatePropertyTax")
				|| type.equalsIgnoreCase("TownPropertyTax");
		return false;
	}
	
	/**
	 * Checks for OtherTypePrepaids
	 * @param prepaidType
	 * @return boolean
	 */
	private boolean checkOtherPrepaids(String prepaidType)
	{
		if("HomeownersInsurancePremium".equalsIgnoreCase(prepaidType) || "MortgageInsurancePremium".equalsIgnoreCase(prepaidType) || "PrepaidInterest".equalsIgnoreCase(prepaidType)
				||"Property Taxes".equalsIgnoreCase(prepaidType) || isPropertyTax(prepaidType) || null == prepaidType || ("").equals(prepaidType) )
			return false;
		return true;
	}
	
	/**
	 * Extracts the elements from escrowItem and sets to IEPatClosing Model for UI response
	 * @param escrowItem
	 * @return IEPatClosing
	 */
	private EscrowItemModel getEscrowModel(EscrowItem escrowItem)
	{
		EscrowItemModel iePatClosing = new EscrowItemModel();
		
		EscrowItemDetail escrowItemDetail = escrowItem.escrowItemDetail;  
		
		iePatClosing.setDisplayLabel(escrowItemDetail.displayLabelText);
		iePatClosing.setEscrowItemType(escrowItemDetail.escrowItemType);
		iePatClosing.setEscrowItemTypeOtherDescription(escrowItemDetail.escrowItemTypeOtherDescription);
		iePatClosing.setEscrowCollectedNumberOfMonthsCount(escrowItemDetail.escrowCollectedNumberOfMonthsCount);
		iePatClosing.setEscrowMonthlyPaymentAmount(escrowItemDetail.escrowMonthlyPaymentAmount);
		iePatClosing.setFeePaidToType(escrowItemDetail.feePaidToType);
		iePatClosing.setFeePaidToTypeOtherDescription(escrowItemDetail.feePaidToTypeOtherDescription);
		iePatClosing.setIntegratedDisclosureSectionType(escrowItemDetail.integratedDisclosureSectionType);
		iePatClosing.setRegulationZPointsAndFeesIndicator(Boolean.parseBoolean(escrowItemDetail.regulationZPointsAndFeesIndicator));
		iePatClosing.setPaymentIncludedInAPRIndicator(Boolean.parseBoolean(escrowItemDetail.paymentIncludedInAPRIndicator));
		
		for(EscrowItemPayment escrowitempayment : escrowItem.escrowItemPayments.escrowItemPayment)
		{
			String paidBy = escrowitempayment.escrowItemPaymentPaidByType;
			
			if ("Buyer".equalsIgnoreCase(paidBy)) 
				if ("BeforeClosing".equalsIgnoreCase(escrowitempayment.escrowItemPaymentTimingType))
					iePatClosing.setBpB4Closing(escrowitempayment.escrowItemActualPaymentAmount);
				else
					iePatClosing.setBpAtClosing(escrowitempayment.escrowItemActualPaymentAmount);
			else if ("Seller".equalsIgnoreCase(paidBy))
				if ("BeforeClosing".equalsIgnoreCase(escrowitempayment.escrowItemPaymentTimingType))
					iePatClosing.setSpB4Closing(escrowitempayment.escrowItemActualPaymentAmount);
				else
					iePatClosing.setSpAtClosing(escrowitempayment.escrowItemActualPaymentAmount);
			else
				iePatClosing.setPaidByOthers(escrowitempayment.escrowItemActualPaymentAmount);
			
			if ("Lender".equalsIgnoreCase(paidBy))
				iePatClosing.setLenderStatus(true);
			else
				
				iePatClosing.setLenderStatus(false);
		}
		return iePatClosing;
	}

	/**
	 * Checks for other type of escrows
	 * @param escrowType
	 * @return boolean
	 */
	private boolean checkOtherEscrows(String escrowType)
	{
		if("HomeownersInsurance".equalsIgnoreCase(escrowType) || "MortgageInsurance".equalsIgnoreCase(escrowType) || "PrepaidInterest".equalsIgnoreCase(escrowType)
				||"Property Taxes".equalsIgnoreCase(escrowType) || isPropertyTax(escrowType) ||null == escrowType || "".equals(escrowType))
			return false;
		return true;
	}
}
