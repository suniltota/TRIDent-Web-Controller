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
import com.actualize.mortgage.domainmodels.AutomatedUnderwritingsModel;
import com.actualize.mortgage.domainmodels.Borrower;
import com.actualize.mortgage.domainmodels.CashToClose;
import com.actualize.mortgage.domainmodels.CashToCloseModel;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsLoanCosts;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsOtherCosts;
import com.actualize.mortgage.domainmodels.ClosingCostProperties;
import com.actualize.mortgage.domainmodels.ClosingCostsTotal;
import com.actualize.mortgage.domainmodels.ClosingInformation;
import com.actualize.mortgage.domainmodels.CostsAtClosing;
import com.actualize.mortgage.domainmodels.CostsAtClosingCashToClose;
import com.actualize.mortgage.domainmodels.CostsAtClosingClosingCosts;
import com.actualize.mortgage.domainmodels.ETIA;
import com.actualize.mortgage.domainmodels.ETIASection;
import com.actualize.mortgage.domainmodels.IEPatClosing;
import com.actualize.mortgage.domainmodels.LoanInformation;
import com.actualize.mortgage.domainmodels.LoanInformationLoanIdentifier;
import com.actualize.mortgage.domainmodels.LoanTerms;
import com.actualize.mortgage.domainmodels.LoanTermsBalloonPayment;
import com.actualize.mortgage.domainmodels.LoanTermsInterestRate;
import com.actualize.mortgage.domainmodels.LoanTermsLoanAmount;
import com.actualize.mortgage.domainmodels.LoanTermsPI;
import com.actualize.mortgage.domainmodels.LoanTermsPrepaymentPenalty;
import com.actualize.mortgage.domainmodels.LoanTermsTemporaryBuydown;
import com.actualize.mortgage.domainmodels.NameModel;
import com.actualize.mortgage.domainmodels.Prepaids;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsDetails;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsEE;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsET;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsMI;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsPC;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsPI;
import com.actualize.mortgage.domainmodels.PropertyValuationDetailModel;
import com.actualize.mortgage.domainmodels.SalesContractDetailModel;
import com.actualize.mortgage.domainmodels.SummariesofTransactions;
import com.actualize.mortgage.domainmodels.TLCostsModel;
import com.actualize.mortgage.domainmodels.TransactionInformation;
import com.actualize.mortgage.ledatamodels.AboutVersion;
import com.actualize.mortgage.ledatamodels.AboutVersions;
import com.actualize.mortgage.ledatamodels.Address;
import com.actualize.mortgage.ledatamodels.Adjustment;
import com.actualize.mortgage.ledatamodels.AmortizationRule;
import com.actualize.mortgage.ledatamodels.BuydownOccurence;
import com.actualize.mortgage.ledatamodels.BuydownRule;
import com.actualize.mortgage.ledatamodels.CashToCloseItem;
import com.actualize.mortgage.ledatamodels.CashToCloseItems;
import com.actualize.mortgage.ledatamodels.ClosingInformationDetail;
import com.actualize.mortgage.ledatamodels.Construction;
import com.actualize.mortgage.ledatamodels.Deal;
import com.actualize.mortgage.ledatamodels.Document;
import com.actualize.mortgage.ledatamodels.DocumentClass;
import com.actualize.mortgage.ledatamodels.EscrowItem;
import com.actualize.mortgage.ledatamodels.EscrowItemDetail;
import com.actualize.mortgage.ledatamodels.EscrowItemPayment;
import com.actualize.mortgage.ledatamodels.EscrowItems;
import com.actualize.mortgage.ledatamodels.EstimatedPropertyCostComponents;
import com.actualize.mortgage.ledatamodels.Fee;
import com.actualize.mortgage.ledatamodels.FeePayment;
import com.actualize.mortgage.ledatamodels.Fees;
import com.actualize.mortgage.ledatamodels.IntegratedDisclosureDetail;
import com.actualize.mortgage.ledatamodels.IntegratedDisclosureSectionSummaries;
import com.actualize.mortgage.ledatamodels.IntegratedDisclosureSectionSummary;
import com.actualize.mortgage.ledatamodels.IntegratedDisclosureSectionSummaryDetail;
import com.actualize.mortgage.ledatamodels.IntegratedDisclosureSubsectionPayment;
import com.actualize.mortgage.ledatamodels.IntegratedDisclosureSubsectionPayments;
import com.actualize.mortgage.ledatamodels.InterestOnly;
import com.actualize.mortgage.ledatamodels.InterestRateLifetimeAdjustmentRule;
import com.actualize.mortgage.ledatamodels.InterestRatePerChangeAdjustmentRule;
import com.actualize.mortgage.ledatamodels.InterestRatePerChangeAdjustmentRules;
import com.actualize.mortgage.ledatamodels.LegalEntityDetail;
import com.actualize.mortgage.ledatamodels.Liabilities;
import com.actualize.mortgage.ledatamodels.LoanDetail;
import com.actualize.mortgage.ledatamodels.LoanIdentifiers;
import com.actualize.mortgage.ledatamodels.MIDataDetail;
import com.actualize.mortgage.ledatamodels.MISMODocument;
import com.actualize.mortgage.ledatamodels.MaturityRule;
import com.actualize.mortgage.ledatamodels.Name;
import com.actualize.mortgage.ledatamodels.NegativeAmortization;
import com.actualize.mortgage.ledatamodels.NegativeAmortizationRule;
import com.actualize.mortgage.ledatamodels.Other;
import com.actualize.mortgage.ledatamodels.Parties;
import com.actualize.mortgage.ledatamodels.PaymentRule;
import com.actualize.mortgage.ledatamodels.PrepaidItem;
import com.actualize.mortgage.ledatamodels.PrepaidItems;
import com.actualize.mortgage.ledatamodels.PrepaymentPenaltyLifetimeRule;
import com.actualize.mortgage.ledatamodels.PrincipalAndInterestPaymentLifetimeAdjustmentRule;
import com.actualize.mortgage.ledatamodels.ProjectedPayment;
import com.actualize.mortgage.ledatamodels.ProjectedPayments;
import com.actualize.mortgage.ledatamodels.PropertyDetail;
import com.actualize.mortgage.ledatamodels.PropertyValuationDetail;
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
	
    public ClosingDisclosure convertXmltoJSON(MISMODocument mismodoc) {
        ClosingDisclosure closingDisclosure = new ClosingDisclosure();        
        Document document = null;
        NodeList nodes = mismodoc.getElementsAddNS("//DOCUMENT");
        if (nodes.getLength() > 0)
            document = new Document(Document.NS, (Element)nodes.item(0));
        Deal deal = new Deal(Deal.NS, (Element)document.getElementAddNS("DEAL_SETS/DEAL_SET/DEALS/DEAL"));

	        closingDisclosure.setClosingInformation(createClosingInformation(deal));
	        closingDisclosure.setTransactionInformation(createTransactionInformation(deal));
	        closingDisclosure.setLoanInformation(createLoanInformation(deal));
	        closingDisclosure.setLoanTerms(createLoanTerms(mismodoc));
	        closingDisclosure.setProjectedPayments(createProjectedPayments(deal));
	        closingDisclosure.setEtiaSection(createETIASection(deal));
	        closingDisclosure.setCostsAtClosing(createCostsAtClosing(deal));
	        closingDisclosure.setClosingCostDetailsLoanCosts(ClosingCostDetailsLoanCosts(deal));
	     	closingDisclosure.setClosingCostDetailsOtherCosts(createClosingCostOtherCosts(deal)); 
	     	closingDisclosure.setClosingCostsTotal(createClosingCostsTotal(deal));
	     	closingDisclosure.setCashToCloses(createCalculatingCashtoClose(deal));
	     	closingDisclosure.setSummariesofTransactions(createSummariesofTransactions(deal));
	     	
        //PAGE THREE OF CD
        /*ClosingDisclosurePageThree closingDisclosurePageThree = new ClosingDisclosurePageThree();
            closingDisclosurePageThree.setCashToCloses(createCalculatingCashtoClose(deal));
        closingDisclosure.setClosingDisclosurePageThree(closingDisclosurePageThree);*/
        
        return closingDisclosure;
    }
 
    /**
     * extracts ClosingInformation from xml and converts to JSON
     * @param mismodoc
     * @return closingInformationSection of PageOne
     */
    private ClosingInformation createClosingInformation(Deal deal)
    {
  		  LegalEntityDetail legalEntityDetail = new LegalEntityDetail(null);
          String subjectProperty = "COLLATERALS/COLLATERAL/SUBJECT_PROPERTY";
          String salesContract = subjectProperty + "/SALES_CONTRACTS/SALES_CONTRACT";
          String loan = "LOANS/LOAN";
          String propertyValuation = subjectProperty + "/PROPERTY_VALUATIONS/PROPERTY_VALUATION";
          SalesContractDetailModel salesContractDetailModel = new SalesContractDetailModel();
          PropertyValuationDetailModel propertyValuationDetailModel = new PropertyValuationDetailModel();
          ClosingInformation closingInformationSection = new ClosingInformation();
          IntegratedDisclosureDetail idDetail = new IntegratedDisclosureDetail((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_DETAIL"));
          ClosingInformationDetail closingInformationDetail = new ClosingInformationDetail((Element)deal.getElementAddNS("LOANS/LOAN/CLOSING_INFORMATION/CLOSING_INFORMATION_DETAIL"));
          Address propertyAddress = new Address((Element)deal.getElementAddNS(subjectProperty + "/ADDRESS"));
          PropertyDetail propertyDetail = new PropertyDetail((Element)deal.getElementAddNS(subjectProperty + "/PROPERTY_DETAIL"));
  		  PropertyValuationDetail propertyValuationDetail = new PropertyValuationDetail((Element)deal.getElementAddNS(propertyValuation + "/PROPERTY_VALUATION_DETAIL"));
  		  SalesContractDetail salesContractDetail = new SalesContractDetail((Element)deal.getElementAddNS(salesContract + "/SALES_CONTRACT_DETAIL"));
  		  TermsOfLoan loanTerms = new TermsOfLoan((Element)deal.getElementAddNS(loan + "/TERMS_OF_LOAN"));
  		  Parties closingAgent = new Parties((Element)deal.getElementAddNS("PARTIES"), "[ROLES/ROLE/ROLE_DETAIL/PartyRoleType='ClosingAgent']");
  		    		  
  		  for(int i=0; i<closingAgent.parties.length;i++)
  		  {
  			  if(null != new LegalEntityDetail((Element)closingAgent.parties[i].getElementAddNS("LEGAL_ENTITY/LEGAL_ENTITY_DETAIL")).element)
  				  legalEntityDetail = new LegalEntityDetail((Element)closingAgent.parties[i].getElementAddNS("LEGAL_ENTITY/LEGAL_ENTITY_DETAIL"));
  		  } 
          closingInformationSection.setClosingDate(closingInformationDetail.ClosingDate);
          closingInformationSection.setDateIssued(idDetail.IntegratedDisclosureIssuedDate);
          closingInformationSection.setDisbursementDate(closingInformationDetail.DisbursementDate);
          closingInformationSection.setFileNo(closingInformationDetail.ClosingAgentOrderNumberIdentifier);
          closingInformationSection.setProperty(toAddressModel(propertyAddress));
          closingInformationSection.setSalePrice(StringFormatter.ZEROTRUNCDOLLARS.formatString(salePrice(loanTerms, salesContractDetail, propertyValuationDetail, propertyDetail)));
          	salesContractDetailModel.setPersonalPropertyAmount(salesContractDetail.PersonalPropertyAmount);
          	salesContractDetailModel.setPersonalPropertyIndicator(Convertor.stringToBoolean(salesContractDetail.PersonalPropertyIncludedIndicator));
          	salesContractDetailModel.setRealPropertyAmount(salesContractDetail.RealPropertyAmount);
          	salesContractDetailModel.setSaleContractAmount(salesContractDetail.SalesContractAmount);
          closingInformationSection.setSalesContractDetail(salesContractDetailModel);
          closingInformationSection.setSettlementAgent(legalEntityDetail.fullName);
          	propertyValuationDetailModel.setPropertyEstimatedValueAmount(propertyDetail.propertyEstimatedValueAmount);
          	propertyValuationDetailModel.setPropertyValuationAmount(propertyValuationDetail.propertyValuationAmount);
          	propertyValuationDetailModel.setPropertyValuationMethodType(propertyValuationDetail.propertyValuationMethodType);
          	propertyValuationDetailModel.setPropertyValuationMethodTypeOtherDescription(propertyValuationDetail.propertyValuationMethodTypeOtherDescription);
         	propertyValuationDetailModel.setPropertyValue(!"".equals(propertyDetail.propertyEstimatedValueAmount) ? "Estimated" : "Appraised");
          closingInformationSection.setPropertyValuationDetail(propertyValuationDetailModel);
          
        return closingInformationSection;
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
    	String loanTotalTerm = "";  
 	    String loanPurpose;
 	    String loanType = "";
 	    String loanProduct = "";
        String loan = "LOANS/LOAN";
        String loanId = "";
    	String loanMic = "";
        
    	IntegratedDisclosureDetail idDetail = new IntegratedDisclosureDetail((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_DETAIL"));
        MaturityRule maturityRule = new MaturityRule((Element)deal.getElementAddNS(loan + "/MATURITY/MATURITY_RULE"));
        Construction construction = new Construction((Element)deal.getElementAddNS(loan + "/CONSTRUCTION"));
 	    TermsOfLoan loanTerms = new TermsOfLoan((Element)deal.getElementAddNS(loan + "/TERMS_OF_LOAN"));
        LoanDetail loanDetail = new LoanDetail((Element)deal.getElementAddNS("LOANS/LOAN/LOAN_DETAIL"));
        MIDataDetail miDataDetail = new MIDataDetail((Element)deal.getElementAddNS(loan + "/MI_DATA/MI_DATA_DETAIL"));
        AmortizationRule amortization = new AmortizationRule((Element)deal.getElementAddNS(loan + "/AMORTIZATION/AMORTIZATION_RULE"));
        LoanIdentifiers loanidentifiers = new LoanIdentifiers((Element)deal.getElementAddNS(loan + "/LOAN_IDENTIFIERS"));
        Underwriting underwriting = new Underwriting(null, (Element)deal.getElementAddNS(loan+"/UNDERWRITING"));
        InterestOnly interestOnly = new InterestOnly((Element)deal.getElementAddNS(loan+"/INTEREST_ONLY"));
        NegativeAmortization negativeAmortization = new NegativeAmortization(null, (Element)deal.getElementAddNS(loan+"/NEGATIVE_AMORTIZATION_RULE"));
        
        
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
 	  	
 	    //Loan Term
 	  	if(!"".equals(loanDetail.constructionLoanIndicator) && "ConstructionToPermanent".equalsIgnoreCase(construction.ConstructionLoanType))
		{
			loanTotalTerm = construction.ConstructionLoanTotalTermMonthsCount;
		}
		else if(!"".equals(maturityRule.LoanMaturityPeriodType) && "Year".equalsIgnoreCase(maturityRule.LoanMaturityPeriodType))
		{
			loanTotalTerm = maturityRule.LoanMaturityPeriodCount;
		}
		else if("Month".equalsIgnoreCase(maturityRule.LoanMaturityPeriodType) && !("").equalsIgnoreCase(maturityRule.LoanMaturityPeriodCount))
		{
			loanTotalTerm = maturityRule.LoanMaturityPeriodCount;
		}
 	    //Loan Purpose
		if(("Purchase").equalsIgnoreCase(loanTerms.loanPurposeType))
			loanPurpose = "Purchase";
		else if("true".equalsIgnoreCase(loanDetail.constructionLoanIndicator))
			loanPurpose = "Construction";
		else if("true".equalsIgnoreCase(idDetail.IntegratedDisclosureHomeEquityLoanIndicator))
			loanPurpose = "Home Equity Loan";
		else
			loanPurpose = "Refinance"; 	  	
		//Loan Type
		loanType = loanTerms.mortgageType;
		//Loan Product
		loanProduct = idDetail.IntegratedDisclosureLoanProductDescription;
		//Loan Mic && Loan Id
		if("true".equalsIgnoreCase(loanDetail.miRequiredIndicator)){
			if("Conventional".equalsIgnoreCase(loanTerms.mortgageType))
				loanMic = miDataDetail.miCertificateIdentifier;
			else
				for(LoanInformationLoanIdentifier loanidentifierdata : loanInformationLoanIdentifiers){
					if("AgencyCase".equalsIgnoreCase(loanidentifierdata.getLoanIdentifierType()))
						loanMic = loanidentifierdata.getLoanIdentifier();
				}
		}
		
		for(LoanInformationLoanIdentifier loanidentifierdata : loanInformationLoanIdentifiers){
			if("LenderLoan".equalsIgnoreCase(loanidentifierdata.getLoanIdentifierType()))
				loanId = loanidentifierdata.getLoanIdentifier();
		}
		
 	    loanInformationSection.setPurpose(loanPurpose); 
 	    loanInformationSection.setConstructionLoan(Convertor.stringToBoolean(loanDetail.constructionLoanIndicator));
 	    loanInformationSection.setConstructionLoanType(construction.ConstructionLoanType);
 	    loanInformationSection.setConstructionPeriodNumberOfMonthsCount(construction.ConstructionPeriodNumberOfMonthsCount);
 	    loanInformationSection.setConstructionLoanTotalTermMonthsCount(construction.ConstructionLoanTotalTermMonthsCount); 
 	    loanInformationSection.setLoanMaturityPeriodType(maturityRule.LoanMaturityPeriodType);
 	    loanInformationSection.setLoanMaturityPeriodCount(maturityRule.LoanMaturityPeriodCount);
 	    loanInformationSection.setIntegratedDisclosureHomeEquityLoanIndicator(Convertor.stringToBoolean(idDetail.IntegratedDisclosureHomeEquityLoanIndicator));
 	    loanInformationSection.setLienPriorityType(loanTerms.lienPriorityType);
 	    loanInformationSection.setIntegratedDisclosureLoanProductDescription(idDetail.IntegratedDisclosureLoanProductDescription);
 	    loanInformationSection.setMortgageType(loanTerms.mortgageType);
 	    loanInformationSection.setMortgageTypeOtherDescription(loanTerms.mortgageTypeOtherDescription);
 	    loanInformationSection.setMiRequiredIndicator(Convertor.stringToBoolean(loanDetail.miRequiredIndicator));
 	    loanInformationSection.setMiCertificateIdentifier(miDataDetail.miCertificateIdentifier);
 	    loanInformationSection.setLoanIdentifiers(loanInformationLoanIdentifiers);
 	    loanInformationSection.setAmortizationType(amortization.AmortizationType);
 	    loanInformationSection.setAutomatedUnderwritings(automatedUnderwritingsModelList);
 	    loanInformationSection.setLoanManualUnderwritingIndicator(Boolean.parseBoolean(underwriting.underwritingDetail.loanManualUnderwritingIndicator));
 	    loanInformationSection.setInterestRateIncreaseIndicator(Convertor.stringToBoolean(loanDetail.interestRateIncreaseIndicator));
 	    loanInformationSection.setInterestOnlyIndicator(Convertor.stringToBoolean(loanDetail.interestOnlyIndicator));
 	    loanInformationSection.setNegativeAmoritzationIndicator(Convertor.stringToBoolean(loanDetail.negativeAmortizationIndicator));
 	    loanInformationSection.setNegativeAmoritzationType(negativeAmortization.negativeAmortizationType);
 	    loanInformationSection.setInterestOnlyTermMonthsCount(interestOnly.interestOnlyTermMonthsCount);
 	    loanInformationSection.setSeasonalPaymentFeatureIndicator(false);
 	    loanInformationSection.setStepPaymentsFeatureIndicator(false);
 	    loanInformationSection.setOptionalPaymentsFeatureIndicator(false);
 	    return loanInformationSection;
    }
    
    /**
     * Creates Loan Terms Section from MISMODocument
     * @param mismodoc
     * @return
     */
    private LoanTerms createLoanTerms(MISMODocument mismodoc)
    {
    	LoanTerms loanTerms = new LoanTerms();
    	LoanTermsLoanAmount loanTermsLoanAmount = new LoanTermsLoanAmount();
    	LoanTermsInterestRate loanTermsInterestRate = new LoanTermsInterestRate();
    	LoanTermsPI loanTermsPI = new LoanTermsPI();
    	LoanTermsPrepaymentPenalty loanTermsPrepaymentPenalty = new LoanTermsPrepaymentPenalty();
    	LoanTermsBalloonPayment loanTermsBalloonPayment = new LoanTermsBalloonPayment();
    	LoanTermsTemporaryBuydown loanTermsTemporaryBuydown = new LoanTermsTemporaryBuydown();

    	String interest ="";
    	String principalAmount = "";
		Document document = null;
        NodeList nodes = mismodoc.getElementsAddNS("//DOCUMENT");
        String loan = "LOANS/LOAN";
        if (nodes.getLength() > 0)
            document = new Document(Document.NS, (Element)nodes.item(0));
        Deal deal = new Deal(Deal.NS, (Element)document.getElementAddNS("DEAL_SETS/DEAL_SET/DEALS/DEAL"));
        TermsOfLoan termsOfLoan = new TermsOfLoan((Element)deal.getElementAddNS(loan + "/TERMS_OF_LOAN"));
        NegativeAmortizationRule negativeAmortizationRule = new NegativeAmortizationRule((Element)deal.getElementAddNS(loan + "/NEGATIVE_AMORTIZATION/NEGATIVE_AMORTIZATION_RULE/"));
        LoanDetail loanDetail = new LoanDetail((Element)deal.getElementAddNS(loan + "/LOAN_DETAIL"));
        BuydownRule buydownRule = new BuydownRule((Element)deal.getElementAddNS(loan + "/BUYDOWN/BUYDOWN_RULE"));
        BuydownOccurence buydownOccurence = new BuydownOccurence((Element)deal.getElementAddNS(loan + "/BUYDOWN/BUYDOWN_OCCURRENCES/BUYDOWN_OCCURRENCE"));
        Other other = buydownRule.extension.other;
        InterestRatePerChangeAdjustmentRule interestRatePerChangeAdjustmentRule = new InterestRatePerChangeAdjustmentRule((Element)deal.getElementAddNS(loan + "/ADJUSTMENT/INTEREST_RATE_ADJUSTMENT/INTEREST_RATE_PER_CHANGE_ADJUSTMENT_RULES/INTEREST_RATE_PER_CHANGE_ADJUSTMENT_RULE")); 
        InterestRateLifetimeAdjustmentRule interestRateLifetimeAdjustmentRule = new InterestRateLifetimeAdjustmentRule((Element)deal.getElementAddNS(loan + "/ADJUSTMENT/INTEREST_RATE_ADJUSTMENT/INTEREST_RATE_LIFETIME_ADJUSTMENT_RULE"));
        PaymentRule paymentRule = new PaymentRule((Element)deal.getElementAddNS(loan + "/PAYMENT/PAYMENT_RULE"));
        InterestOnly interestOnly = new InterestOnly((Element)deal.getElementAddNS(loan + "/INTEREST_ONLY"));
        PrincipalAndInterestPaymentLifetimeAdjustmentRule principalAndInterestPaymentLifetimeAdjustmentRule = new PrincipalAndInterestPaymentLifetimeAdjustmentRule((Element)deal.getElementAddNS(loan + "/ADJUSTMENT/PRINCIPAL_AND_INTEREST_PAYMENT_ADJUSTMENT/PRINCIPAL_AND_INTEREST_PAYMENT_LIFETIME_ADJUSTMENT_RULE"));
        InterestRatePerChangeAdjustmentRules interestRatePerChangeAdjustmentRules = new InterestRatePerChangeAdjustmentRules((Element)deal.getElementAddNS(loan + "/ADJUSTMENT/INTEREST_RATE_ADJUSTMENT/INTEREST_RATE_PER_CHANGE_ADJUSTMENT_RULES"));
        PrepaymentPenaltyLifetimeRule prepaymentPenaltyLifetimeRule = new PrepaymentPenaltyLifetimeRule((Element)deal.getElementAddNS(loan + "/PREPAYMENT_PENALTY/PREPAYMENT_PENALTY_LIFETIME_RULE"));
        AboutVersions aboutVersions = document.aboutVersions;
        List<AboutVersion> aboutVersionList = new LinkedList<>();
      
        
        loanTermsLoanAmount.setNoteAmount(termsOfLoan.noteAmount);
        loanTermsLoanAmount.setNegativeAmoritzationIndicator(Convertor.stringToBoolean(loanDetail.negativeAmortizationIndicator));
        loanTermsLoanAmount.setNegativeAmortizationLimitMonthsCount(negativeAmortizationRule.NegativeAmortizationLimitMonthsCount);
        loanTermsLoanAmount.setNegativeAmortizationMaximumLoanBalanceAmount(negativeAmortizationRule.NegativeAmortizationMaximumLoanBalanceAmount);
       
        if("true".equalsIgnoreCase(other.BuydownReflectedInNoteIndicator) && !("").equals(buydownOccurence.BuydownInitialEffectiveInterestRatePercent))
			interest = buydownOccurence.BuydownInitialEffectiveInterestRatePercent;
        else if(!"".equals(termsOfLoan.disclosedFullyIndexedRatePercent))
			interest = termsOfLoan.disclosedFullyIndexedRatePercent;
		else if(!"".equals(termsOfLoan.weightedAverageInterestRatePercent))
			interest = termsOfLoan.weightedAverageInterestRatePercent;
		else
			interest = termsOfLoan.noteRatePercent;
        
       
 	    loanTermsInterestRate.setNoteRatePercent(termsOfLoan.noteRatePercent);
 	    loanTermsInterestRate.setDisclosedFullyIndexedRatePercent(termsOfLoan.disclosedFullyIndexedRatePercent);
 	    loanTermsInterestRate.setInterestRateIncreaseIndicator(Convertor.stringToBoolean(loanDetail.interestRateIncreaseIndicator));
 	    loanTermsInterestRate.setAdjustmentRuleTypeFirst("First");
 	    loanTermsInterestRate.setPerChangeRateAdjustmentFrequencyMonthsCount(interestRatePerChangeAdjustmentRule.PerChangeRateAdjustmentFrequencyMonthsCount);
 	    loanTermsInterestRate.setFirstRateChangeMonthsCount(interestRateLifetimeAdjustmentRule.FirstRateChangeMonthsCount);
 	    loanTermsInterestRate.setCeilingRatePercentEarliestEffectiveMonthsCount(interestRateLifetimeAdjustmentRule.CeilingRatePercentEarliestEffectiveMonthsCount);
 	    loanTermsInterestRate.setCeilingRatePercent(interestRateLifetimeAdjustmentRule.CeilingRatePercent);
 	    loanTermsInterestRate.setDisclosedFullyIndexedRatePercent(termsOfLoan.disclosedFullyIndexedRatePercent);
		
		if(!"".equals(paymentRule.InitialPrincipalAndInterestPaymentAmount))
			principalAmount = paymentRule.InitialPrincipalAndInterestPaymentAmount;
		if("".equalsIgnoreCase(principalAmount))
			principalAmount = paymentRule.FullyIndexedInitialPrincipalAndInterestPaymentAmount;
        
		//AboutVersionIdentifier
		if(null != aboutVersions.aboutVersions)
		for(int i=0; i<aboutVersions.aboutVersions.length; i++){
			aboutVersionList.add(aboutVersions.aboutVersions[i]);
	    }
		   
		if(interestRatePerChangeAdjustmentRules.interestRatePerChangeAdjustmentRules.length>0)
	        for(int i=0; i<interestRatePerChangeAdjustmentRules.interestRatePerChangeAdjustmentRules.length;i++)
	 	    {
	        	for(AboutVersion aboutVersion : aboutVersionList){
		        	
					if("DDOFileNumber".equalsIgnoreCase(aboutVersion.AboutVersionIdentifier))
						loanTermsPI.setPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount(interestRatePerChangeAdjustmentRules.interestRatePerChangeAdjustmentRules[i].PerChangeRateAdjustmentFrequencyMonthsCount);
					else
						if("First".equalsIgnoreCase(interestRatePerChangeAdjustmentRules.interestRatePerChangeAdjustmentRules[i].AdjustmentRuleType))
							loanTermsPI.setPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount(interestRatePerChangeAdjustmentRules.interestRatePerChangeAdjustmentRules[i].PerChangeRateAdjustmentFrequencyMonthsCount);
	        	}
	        }
		
 	    loanTermsPI.setPaymentFrequencyType(paymentRule.PaymentFrequencyType);
		loanTermsPI.setAmount(principalAmount);
 	    loanTermsPI.setInitialPrincipalAndInterestPaymentAmount(paymentRule.InitialPrincipalAndInterestPaymentAmount);
		loanTermsPI.setFullyIndexedInitialPrincipalAndInterestPaymentAmount(paymentRule.FullyIndexedInitialPrincipalAndInterestPaymentAmount);
		loanTermsPI.setAdjustmentRuleType("First");
		loanTermsPI.setFirstPrincipalAndInterestPaymentChangeMonthsCount(principalAndInterestPaymentLifetimeAdjustmentRule.firstPrincipalAndInterestPaymentChangeMonthsCount);
		loanTermsPI.setPrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount(principalAndInterestPaymentLifetimeAdjustmentRule.principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount);
		loanTermsPI.setPrincipalAndInterestPaymentMaximumAmount(principalAndInterestPaymentLifetimeAdjustmentRule.principalAndInterestPaymentMaximumAmount);
		loanTermsPI.setPaymentIncreaseIndicator(Convertor.stringToBoolean(loanDetail.paymentIncreaseIndicator));
		//loanTermsPrepaymentPenalty
		loanTermsPrepaymentPenalty.setPrepaymentPenaltyIndicator(Convertor.stringToBoolean(loanDetail.prepaymentPenaltyIndicator));
		loanTermsPrepaymentPenalty.setPrepaymentPenaltyMaximumLifeOfLoanAmount(prepaymentPenaltyLifetimeRule.PrepaymentPenaltyMaximumLifeOfLoanAmount);
		loanTermsPrepaymentPenalty.setPrepaymentPenaltyExpirationMonthsCount(prepaymentPenaltyLifetimeRule.PrepaymentPenaltyExpirationMonthsCount);	

		//LoanTermsBalloonPayment
		loanTermsBalloonPayment.setBalloonIndicator(Convertor.stringToBoolean(loanDetail.balloonIndicator));
		loanTermsBalloonPayment.setBalloonPaymentAmount(loanDetail.balloonPaymentAmount);
		
		//TemporaryBuydown
		loanTermsTemporaryBuydown.setGseBuydownReflectedInNoteIndicator(Convertor.stringToBoolean(other.BuydownReflectedInNoteIndicator));
        loanTermsTemporaryBuydown.setBuydownInitialEffectiveInterestRatePercent(buydownOccurence.BuydownInitialEffectiveInterestRatePercent);
        loanTermsTemporaryBuydown.setBuydownTemporarySubsidyFundingIndicator(Convertor.stringToBoolean(loanDetail.buydownTemporarySubsidyFundingIndicator));
        loanTermsTemporaryBuydown.setBuydownChangeFrequencyMonthsCount(buydownRule.BuydownChangeFrequencyMonthsCount);
        loanTermsTemporaryBuydown.setBuydownIncreaseRatePercent(buydownRule.BuydownIncreaseRatePercent);
		//LoanTermsIntialEscrow
		/*if(null != escrowItems && null != escrowItem)
		{
			EscrowItem escrowsItem = getEscrowItem(escrowItems,"InitialEscrowPaymentAtClosing");
			loanTermsIntialEscrow.setEscrowIndicator(true);
			loanTermsIntialEscrow.setEscrowItemType(escrowsItem.escrowItemDetail.escrowItemType);
			loanTermsIntialEscrow.setDisplayLabelText(escrowsItem.escrowItemDetail.displayLabelText);
			loanTermsIntialEscrow.setFeePaidToType(escrowsItem.escrowItemDetail.feePaidToType);
			loanTermsIntialEscrow.setTypeOtherDescription(escrowsItem.escrowItemDetail.escrowItemTypeOtherDescription);
			for(int i=0; i<escrowsItem.escrowItemPayments.escrowItemPayment.length;i++)
	 	    {
	        	EscrowItemPayment escrowItemPayment = escrowsItem.escrowItemPayments.escrowItemPayment[i];
	        	
	        	if("Buyer".equalsIgnoreCase(escrowItemPayment.escrowItemPaymentPaidByType)) 
				    loanTermsIntialEscrow.setEscrowItemActualPaymentAmount(escrowItemPayment.escrowItemActualPaymentAmount);
				else if("Seller".equalsIgnoreCase(escrowItemPayment.escrowItemPaymentPaidByType))
					loanTermsIntialEscrow.setEscrowItemActualPaymentAmount(escrowItemPayment.escrowItemActualPaymentAmount);
				else
					loanTermsIntialEscrow.setEscrowItemActualPaymentAmount(escrowItemPayment.escrowItemActualPaymentAmount);
	        	
	        	loanTermsIntialEscrow.setEscrowItemPaymentPaidByType(escrowItemPayment.escrowItemPaymentPaidByType);
	 	    }
		 }
		 else
		 {
		 	loanTermsIntialEscrow.setEscrowIndicator(false);
		 	if(fees.fees.length > 0 )
		 		for(int i=0;i<fees.fees.length;i++){
		 			FeeDetail feedetail = fees.fees[i].feeDetail;
		 			if(!"".equals(feedetail.feeType) && "EscrowWaiverFee".equalsIgnoreCase(feedetail.feeType))
		 			{
		 				loanTermsIntialEscrow.setFeeActualPaymentAmount(feedetail.feeActualTotalAmount);
		 			}
		 		}
		 }
		
		loanTermsIntialEscrow.setFeeType("EscrowWaiverFee");
		loanTermsIntialEscrow.setIntegratedDisclosureSectionType("InitialEscrowPaymentAtClosing");
		
		
		
		loanTermsEscrowAccount.setFirstYearTotalNonEscrowPaymentDescription(idDetail.FirstYearTotalNonEscrowPaymentAmount);
		loanTermsEscrowAccount.setFirstYearTotalNonEscrowPaymentAmount(idDetail.FirstYearTotalNonEscrowPaymentDescription);
	*/
        loanTerms.setLoanTermsLoanAmount(loanTermsLoanAmount);
 	    loanTerms.setLoanTermsInterestRate(loanTermsInterestRate);
 	    loanTerms.setLoanTermsPI(loanTermsPI);
 	    loanTerms.setLoanTermsTemporaryBuydown(loanTermsTemporaryBuydown);
 	    loanTerms.setLoanTermsPrepaymentPenalty(loanTermsPrepaymentPenalty);
 	    loanTerms.setLoanTermsBalloonPayment(loanTermsBalloonPayment);
 	    
    	return loanTerms;
    }
    
  	private ETIASection createETIASection(Deal deal)
  	{
  		ETIASection etiaSection = new ETIASection();
  		EstimatedPropertyCostComponents estimatedPropertyCostComponents = new EstimatedPropertyCostComponents((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/ESTIMATED_PROPERTY_COST/ESTIMATED_PROPERTY_COST_COMPONENTS"));
  		
  		String projectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount = deal.getValueAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/ESTIMATED_PROPERTY_COST/ESTIMATED_PROPERTY_COST_DETAIL/ProjectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount");
  		
  		List<ETIA>  eTIAs = new LinkedList<>();
  		
  		for(int i=0; i<estimatedPropertyCostComponents.estimatedPropertyCostComponent.length; i++){
  			ETIA  eTIA = new ETIA();
  			eTIA.setProjectedPaymentEscrowedType(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEscrowedType);
  			eTIA.setProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEstimatedTaxesInsuranceAssessmentComponentType);
  			eTIA.setProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription);
  			eTIAs.add(eTIA);
  		}
  		
  		etiaSection.setEtiaValues(eTIAs);
		etiaSection.setProjectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount(projectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount);
  		
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
		MIDataDetail miDataDetail = new MIDataDetail((Element)deal.getElementAddNS("LOANS/LOAN/MI_DATA/MI_DATA_DETAIL"));
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
		projectedPayments.setMiSTDate(miDataDetail.miScheduledTerminationDate);
		projectedPayments.setMIRequired(Boolean.parseBoolean(loanDetail.miRequiredIndicator));
		projectedPayments.setMiCompanyName(miDataDetail.miCompanyNameType);
		projectedPayments.setMiCompanyNameOtherDescription(miDataDetail.miCompanyNameTypeOtherDescription);
		
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
			costsAtClosingCashToClose.setAmount(closingDetail.CashFromBorrowerAtClosingAmount.equals("") ? closingDetail.CashToBorrowerAtClosingAmount : closingDetail.CashFromBorrowerAtClosingAmount);
			costsAtClosingCashToClose.setCashFromBorrowerAtClosingAmount(closingDetail.CashFromBorrowerAtClosingAmount);
			costsAtClosingCashToClose.setCashToBorrowerAtClosingAmount(closingDetail.CashToBorrowerAtClosingAmount);
		
		if("ClosingDisclosure:AlternateForm".equalsIgnoreCase(documentClass.documentTypeOtherDescription)){
			costsAtClosingCashToClose.setFromType("".equals(closingDetail.CashFromBorrowerAtClosingAmount.trim()) ? false : true);
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
		
		ClosingCostDetailsLoanCosts closingCostDetailsLoanCosts = new ClosingCostDetailsLoanCosts();
		ClosingCostProperties loanDiscountPoints = null;
		List<ClosingCostProperties> originationChargeList = new LinkedList<>();
		List<ClosingCostProperties> sbDidNotShopFors = new LinkedList<>();
		List<ClosingCostProperties> sbDidShopFors = new LinkedList<>();
		TLCostsModel tlCosts = new TLCostsModel();
		
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
    	TLCostsModel totalOtherCosts = new TLCostsModel();
    	
    	List<ClosingCostProperties> tOGovtFeesList = new ArrayList<>();
		List<Prepaids> prepaidsList = new LinkedList<>();
		List<IEPatClosing> iePatClosingList = new LinkedList<>();
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
				closingCostDetailsOtherCosts.setiEPatClosingTotalAmount(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionTotalAmount);
    		else if("TotalOtherCosts".equalsIgnoreCase(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionType))
				closingCostDetailsOtherCosts.setTotalOtherCostsTotalAmount(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSectionTotalAmount);
    		else if("OtherCostsSubtotal".equalsIgnoreCase(idSectionSummaries.integratedDisclosureSectionSummaries[i].integratedDisclosureSectionSummaryDetail.integratedDisclosureSubsectionType))
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
					 iePatClosingList.add(getEscrowModel(escrowItem));
			}
			
			for(int i=0; i<escrowItems.escrowItems.length;i++)
	 	    {
				if (("Property Tax").equalsIgnoreCase(escrowItems.escrowItems[i].escrowItemDetail.displayLabelText)) {
					iePatClosingList.add(getEscrowModel(escrowItems.escrowItems[i]));
					break;
				} 
				else if (isPropertyTax(escrowItems.escrowItems[i].escrowItemDetail.escrowItemType)) {
					IEPatClosing iePatClosing = new IEPatClosing();
						iePatClosing = getEscrowModel(escrowItems.escrowItems[i]);
						iePatClosing.setDisplayLabel("Property Taxes");
					iePatClosingList.add(iePatClosing);
				}
	 	    }
			
			for(int i=0; i<escrowItems.escrowItems.length;i++)
				if(checkOtherEscrows(escrowItems.escrowItems[i].escrowItemDetail.escrowItemType))
					iePatClosingList.add(getEscrowModel(escrowItems.escrowItems[i]));
		}
		
		//OtherFees
		for(int i=0;i<otherFees.fees.length;i++)
			if(!"".equals(otherFees.fees[i].feeDetail.feeType))
				otherCostsList.add(feeCostsTableRow(otherFees.fees[i]));
		 
		closingCostDetailsOtherCosts.settOGovtFeesList(tOGovtFeesList);
		closingCostDetailsOtherCosts.setPrepaidsList(prepaidsList);
		closingCostDetailsOtherCosts.setiEPatClosingList(iePatClosingList);
		closingCostDetailsOtherCosts.setOtherCostsList(otherCostsList);
		closingCostDetailsOtherCosts.setTotalOtherCosts(totalOtherCosts);
		
		return closingCostDetailsOtherCosts;
    	
    }
    
    
    private ClosingCostsTotal createClosingCostsTotal(Deal deal)
    {
    	String loan = "LOANS/LOAN";
		String idSummaryBase = loan + "/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_SECTION_SUMMARIES/INTEGRATED_DISCLOSURE_SECTION_SUMMARY";
		String idSummary = idSummaryBase + "/INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL";
		
    	ClosingCostsTotal closingCostsTotal = new ClosingCostsTotal();
    	TLCostsModel totalOtherCosts = new TLCostsModel();

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
					totalOtherCosts.setBpAtClosing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
				else
					totalOtherCosts.setBpB4Closing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
			}
			else if(("Seller").equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaidByType))
			{
				if(("AtClosing").equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentTimingType))
					totalOtherCosts.setBpAtClosing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
				else
					totalOtherCosts.setBpB4Closing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
			}
			if("Lender".equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaidByType))
				totalOtherCosts.setLenderStatus(true);
			else
				totalOtherCosts.setLenderStatus(false);
		}
    	
    	
    	
    	
    	
    	
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
		
    	SummariesofTransactions summariesofTransactions = new SummariesofTransactions();
    	Liabilities liabilities = new Liabilities(null, (Element)deal.getElementAddNS("LIABILITIES/")); 
    	Adjustment adjustment = new Adjustment(null, (Element)deal.getElementAddNS("LOANS/LOAN/ADJUSTMENT"));
		return summariesofTransactions;
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
			cashToCashToCloseModel.setIntegratedDisclosureCashToCloseItemAmountChangedIndicator(cashToCloseItem.integratedDisclosureCashToCloseItemAmountChangedIndicator);
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
		if (salesContractDetail.PersonalPropertyIncludedIndicator.equalsIgnoreCase("true"))
			return salesContractDetail.RealPropertyAmount;
		return salesContractDetail.SalesContractAmount;
	}
	
	/**
	 * fetch the Name Model from XML
	 * @param name
	 * @return name detail
	 */
	private static NameModel toNameModel(Name name) {
		NameModel nameModel = new NameModel();
		
		if (!name.FullName.equals(""))
			nameModel.setFullName(name.FullName);
		if (!name.MiddleName.equals("")) 
			nameModel.setMiddleName(name.MiddleName);
		if (!name.LastName.equals("")) 
			nameModel.setLastName(name.LastName);
		if (!name.SuffixName.equals("")) 
			nameModel.setSuffixName(name.SuffixName);
		
		return nameModel;
	}
	
	/**
	 * fetch the address model from XML
	 * @param address
	 * @return address Model
	 */
	private static com.actualize.mortgage.domainmodels.Address toAddressModel(Address address) {
	com.actualize.mortgage.domainmodels.Address addressModel = new com.actualize.mortgage.domainmodels.Address();
		
		if (!"".equals(address.AddressType))
			addressModel.setAddressType(address.AddressType);
		if (!"".equals(address.CityName))
			addressModel.setCityName(address.CityName);
		if (!"".equals(address.AddressLineText))
			addressModel.setAddressLineText(address.AddressLineText);
		if (!"".equals(address.StateCode))
			addressModel.setStateCode(address.StateCode);
		if (!"".equals(address.PostalCode)) 
			addressModel.setPostalCode(address.PostalCode);
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
			if (construction.ConstructionLoanType.equalsIgnoreCase("ConstructionOnly"))
				return construction.ConstructionPeriodNumberOfMonthsCount;
			return construction.ConstructionLoanTotalTermMonthsCount;
		}
		return maturityRule.LoanMaturityPeriodCount;
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
				com.actualize.mortgage.domainmodels.Address addressModel = new com.actualize.mortgage.domainmodels.Address();
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
	private TLCostsModel calculateTLCosts(IntegratedDisclosureSectionSummaryDetail totalLoanCosts, IntegratedDisclosureSectionSummaries integratedDisclosureSectionSummaries)
	{
		TLCostsModel tlCosts = new TLCostsModel();
        	
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
							tlCosts.setBpAtClosing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
						else
							tlCosts.setBpB4Closing(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaymentAmount);
					}
					if("Lender".equalsIgnoreCase(integrateddisclosuresubsectionpayment.integratedDisclosureSubsectionPaidByType))
						tlCosts.setLenderStatus(true);
					else
						tlCosts.setLenderStatus(false);
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
		prepaid.setGseDisplayLabelText(prepaidItem.prepaidItemDetail.displayLabelText);
		if(null != prepaidItem.prepaidItemDetail.displayLabelText && !"".equals(prepaidItem.prepaidItemDetail.displayLabelText))
			prepaid.setDisplayLabelText(prepaidItem.prepaidItemDetail.displayLabelText);
		else if("Other".equalsIgnoreCase(prepaidItem.prepaidItemDetail.displayLabelText))
			prepaid.setDisplayLabelText(StringFormatter.CAMEL.formatString(prepaidItem.prepaidItemDetail.prepaidItemTypeOtherDescription));
		else
			prepaid.setDisplayLabelText(StringFormatter.CAMEL.formatString(prepaidItem.prepaidItemDetail.prepaidItemType));
		
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
	private IEPatClosing getEscrowModel(EscrowItem escrowItem)
	{
		IEPatClosing iePatClosing = new IEPatClosing();
		
		EscrowItemDetail escrowItemDetail = escrowItem.escrowItemDetail;  
		
		iePatClosing.setGseDisplayLabel(escrowItemDetail.displayLabelText);
		iePatClosing.setEscrowItemType(escrowItemDetail.escrowItemType);
		iePatClosing.setEscrowItemTypeOtherDescription(escrowItemDetail.escrowItemTypeOtherDescription);
		
		if("".equals(escrowItemDetail.displayLabelText))
		{
			if("Other".equalsIgnoreCase(escrowItemDetail.escrowItemType))
				iePatClosing.setDisplayLabel(StringFormatter.CAMEL.formatString(escrowItemDetail.escrowItemTypeOtherDescription));
			else
				iePatClosing.setDisplayLabel(StringFormatter.CAMEL.formatString(escrowItemDetail.escrowItemType));
		}
		else
			iePatClosing.setDisplayLabel(escrowItemDetail.displayLabelText);
			
		iePatClosing.setEscrowCollectedNumberOfMonthsCount(escrowItemDetail.escrowCollectedNumberOfMonthsCount);
		iePatClosing.setEscrowMonthlyPaymentAmount(escrowItemDetail.escrowMonthlyPaymentAmount);
		iePatClosing.setFeePaidToType(escrowItemDetail.feePaidToType);
		iePatClosing.setFeePaidToTypeOtherDescription(escrowItemDetail.feePaidToTypeOtherDescription);
		iePatClosing.setIntegratedDisclosureSectionType(escrowItemDetail.integratedDisclosureSectionType);
		iePatClosing.setRegulationZPointsAndFeesIndicator(escrowItemDetail.regulationZPointsAndFeesIndicator);
		iePatClosing.setPaymentIncludedInAPRIndicator(escrowItemDetail.paymentIncludedInAPRIndicator);
		
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
