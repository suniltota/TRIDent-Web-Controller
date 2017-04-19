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
import com.actualize.mortgage.cdpagemodels.ClosingDisclosurePageOne;
import com.actualize.mortgage.cdpagemodels.ClosingDisclosurePageThree;
import com.actualize.mortgage.cdpagemodels.ClosingDisclosurePageTwo;
import com.actualize.mortgage.domainmodels.Borrower;
import com.actualize.mortgage.domainmodels.CashToClose;
import com.actualize.mortgage.domainmodels.CashToCloseModel;
import com.actualize.mortgage.domainmodels.ClosingCostDetails;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsLoanCosts;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsOtherCosts;
import com.actualize.mortgage.domainmodels.ClosingCostProperties;
import com.actualize.mortgage.domainmodels.ClosingInformation;
import com.actualize.mortgage.domainmodels.CostsAtClosing;
import com.actualize.mortgage.domainmodels.CostsAtClosingCashToClose;
import com.actualize.mortgage.domainmodels.CostsAtClosingClosingCosts;
import com.actualize.mortgage.domainmodels.EscrowsModel;
import com.actualize.mortgage.domainmodels.FeeModel;
import com.actualize.mortgage.domainmodels.IEPatClosing;
import com.actualize.mortgage.domainmodels.LoanInformation;
import com.actualize.mortgage.domainmodels.LoanInformationLoanIdentifier;
import com.actualize.mortgage.domainmodels.LoanTerms;
import com.actualize.mortgage.domainmodels.LoanTermsBalloonPayment;
import com.actualize.mortgage.domainmodels.LoanTermsETIA;
import com.actualize.mortgage.domainmodels.LoanTermsEscrowAccount;
import com.actualize.mortgage.domainmodels.LoanTermsInterestRate;
import com.actualize.mortgage.domainmodels.LoanTermsIntialEscrow;
import com.actualize.mortgage.domainmodels.LoanTermsLoanAmount;
import com.actualize.mortgage.domainmodels.LoanTermsPI;
import com.actualize.mortgage.domainmodels.LoanTermsPrepaymentPenalty;
import com.actualize.mortgage.domainmodels.NameModel;
import com.actualize.mortgage.domainmodels.Prepaids;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsDetails;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsModel;
import com.actualize.mortgage.domainmodels.PropertyValuationDetailModel;
import com.actualize.mortgage.domainmodels.SalesContractDetailModel;
import com.actualize.mortgage.domainmodels.TransactionInformation;
import com.actualize.mortgage.ledatamodels.AboutVersion;
import com.actualize.mortgage.ledatamodels.AboutVersions;
import com.actualize.mortgage.ledatamodels.Address;
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
import com.actualize.mortgage.ledatamodels.EscrowItemPayments;
import com.actualize.mortgage.ledatamodels.EscrowItems;
import com.actualize.mortgage.ledatamodels.EstimatedPropertyCost;
import com.actualize.mortgage.ledatamodels.EstimatedPropertyCostComponents;
import com.actualize.mortgage.ledatamodels.Fee;
import com.actualize.mortgage.ledatamodels.FeeDetail;
import com.actualize.mortgage.ledatamodels.FeePayment;
import com.actualize.mortgage.ledatamodels.FeePayments;
import com.actualize.mortgage.ledatamodels.Fees;
import com.actualize.mortgage.ledatamodels.IntegratedDisclosure;
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
import com.actualize.mortgage.ledatamodels.LoanDetail;
import com.actualize.mortgage.ledatamodels.LoanIdentifiers;
import com.actualize.mortgage.ledatamodels.MIDataDetail;
import com.actualize.mortgage.ledatamodels.MISMODocument;
import com.actualize.mortgage.ledatamodels.MaturityRule;
import com.actualize.mortgage.ledatamodels.Name;
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

        //PAGE ONE Of CD
        ClosingDisclosurePageOne closingDisclosurePageOne = new ClosingDisclosurePageOne();
	        closingDisclosurePageOne.setClosingInformation(createClosingInformation(deal));
	        closingDisclosurePageOne.setTransactionInformation(createTransactionInformation(deal));
	        closingDisclosurePageOne.setLoanInformation(createLoanInformation(deal));
	        closingDisclosurePageOne.setLoanTerms(createLoanTerms(mismodoc));
	        closingDisclosurePageOne.setProjectedPayments(createProjectedPayments(deal));
	        closingDisclosurePageOne.setCostsAtClosing(createCostsAtClosing(deal));
	     closingDisclosure.setClosingDisclosurePageOne(closingDisclosurePageOne);    
        
	    //PAGE TWO OF CD 
	     ClosingDisclosurePageTwo closingDisclosurePageTwo = new ClosingDisclosurePageTwo();
	        closingDisclosurePageTwo.setClosingCostDetailsLoanCosts(ClosingCostDetailsLoanCosts(deal));
	     	closingDisclosurePageTwo.setClosingCostDetailsOtherCosts(createClosingCostOtherCosts(deal)); 
        closingDisclosure.setClosingDisclosurePageTwo(closingDisclosurePageTwo);
        
        //PAGE THREE OF CD
        ClosingDisclosurePageThree closingDisclosurePageThree = new ClosingDisclosurePageThree();
            closingDisclosurePageThree.setCashToCloses(createCalculatingCashtoClose(deal));
        closingDisclosure.setClosingDisclosurePageThree(closingDisclosurePageThree);
        
        
        
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
          	propertyValuationDetailModel.setPropertyEstimatedValueAmount(propertyValuationDetail.PropertyValuationAmount);
          	propertyValuationDetailModel.setPropertyValuationAmount(propertyValuationDetail.PropertyValuationAmount);
          	propertyValuationDetailModel.setPropertyValuationMethodType(propertyValuationDetail.PropertyValuationMethodType);
          	propertyValuationDetailModel.setPropertyValuationMethodTypeOtherDescription(propertyValuationDetail.PropertyValuationMethodTypeOtherDescription);
          closingInformationSection.setPropertyValuationDetail(propertyValuationDetailModel);
        return closingInformationSection;
    }
    
    private TransactionInformation createTransactionInformation(Deal deal)
    {
    	TransactionInformation transactionInformation = new TransactionInformation();
        
    	Parties borrowerParties = new Parties((Element)deal.getElementAddNS("PARTIES"), "[ROLES/ROLE/ROLE_DETAIL/PartyRoleType='Borrower']");
    	Parties sellerParties = new Parties((Element)deal.getElementAddNS("PARTIES"), "[ROLES/ROLE/ROLE_DETAIL/PartyRoleType='PropertySeller']");
    	Parties lenders = new Parties((Element)deal.getElementAddNS("PARTIES"), "[ROLES/ROLE/ROLE_DETAIL/PartyRoleType='NotePayTo']");
    	
    	transactionInformation.setBorrower(createBorrowers(borrowerParties));
    	transactionInformation.setSeller(createBorrowers(sellerParties));
    	transactionInformation.setLender(createBorrowers(lenders));
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
        List<LoanInformationLoanIdentifier> loanInformationLoanIdentifiers = new LinkedList<>();
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
				loanMic = miDataDetail.MICertificateIdentifier;
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
		
 	    loanInformationSection.setLoanTerm(loanTotalTerm); 
 	    loanInformationSection.setPurpose(loanPurpose); 
 	    loanInformationSection.setProduct(loanProduct); 
 	    loanInformationSection.setLoanType(loanType);
 	    loanInformationSection.setLoanId(loanId);
 	    loanInformationSection.setMic(loanMic);
 	    loanInformationSection.setConstructionLoanType(construction.ConstructionLoanType);
 	    loanInformationSection.setConstructionPeriodNumberOfMonthsCount(construction.ConstructionPeriodNumberOfMonthsCount);
 	    loanInformationSection.setConstructionLoanTotalTermMonthsCount(construction.ConstructionLoanTotalTermMonthsCount); 
 	    loanInformationSection.setLoanMaturityPeriodType(maturityRule.LoanMaturityPeriodType);
 	    loanInformationSection.setLoanMaturityPeriodCount(maturityRule.LoanMaturityPeriodCount);
 	    loanInformationSection.setIntegratedDisclosureHomeEquityLoanIndicator(idDetail.IntegratedDisclosureHomeEquityLoanIndicator);
 	    loanInformationSection.setLienPriorityType(loanTerms.lienPriorityType);
 	    loanInformationSection.setIntegratedDisclosureLoanProductDescription(idDetail.IntegratedDisclosureLoanProductDescription);
 	    loanInformationSection.setMortgageType(loanTerms.mortgageType);
 	    loanInformationSection.setMortgageTypeOtherDescription(loanTerms.mortgageTypeOtherDescription);
 	    loanInformationSection.setMiRequiredIndicator(loanDetail.miRequiredIndicator);
 	    loanInformationSection.setMiCertificateIdentifier(miDataDetail.MICertificateIdentifier);
 	    loanInformationSection.setLoanIdentifiers(loanInformationLoanIdentifiers);
 	    loanInformationSection.setAmortizationType(amortization.AmortizationType);	     
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
    	LoanTermsIntialEscrow loanTermsIntialEscrow = new LoanTermsIntialEscrow();
		LoanTermsEscrowAccount  loanTermsEscrowAccount = new LoanTermsEscrowAccount();

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
        EscrowItems escrowItems = new EscrowItems((Element)deal.getElementAddNS(loan + "/ESCROW/ESCROW_ITEMS"));
        EscrowItem escrowItem = new EscrowItem((Element)deal.getElementAddNS(loan + "/ESCROW/ESCROW_ITEMS/ESCROW_ITEM"));
        Fees fees = new Fees((Element)deal.getElementAddNS(loan + "/FEE_INFORMATION/FEES"));
        EstimatedPropertyCostComponents estimatedPropertyCostComponents = new EstimatedPropertyCostComponents((Element)deal.getElementAddNS(loan + "/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/ESTIMATED_PROPERTY_COST/ESTIMATED_PROPERTY_COST_COMPONENTS"));
        IntegratedDisclosureDetail idDetail = new IntegratedDisclosureDetail((Element)deal.getElementAddNS(loan + "/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_DETAIL"));
        AboutVersions aboutVersions = document.aboutVersions;
        List<AboutVersion> aboutVersionList = new LinkedList<>();
        //LoanTermsLoanAmount
        if("true".equalsIgnoreCase(loanDetail.negativeAmortizationIndicator))
        	loanTermsLoanAmount.setStatus("YES");
        else
        	loanTermsLoanAmount.setStatus("NO");
        
        loanTermsLoanAmount.setAmount(termsOfLoan.noteAmount);
        loanTermsLoanAmount.setNegativeAmoritzationIndicator(loanDetail.negativeAmortizationIndicator);
        loanTermsLoanAmount.setNegativeAmortizationLimitMonthsCount(negativeAmortizationRule.NegativeAmortizationLimitMonthsCount);
        loanTermsLoanAmount.setNegativeAmortizationMaximumLoanBalanceAmount(negativeAmortizationRule.NegativeAmortizationMaximumLoanBalanceAmount);
        
        //loanTermsInterestRate
        if("true".equalsIgnoreCase(loanDetail.interestRateIncreaseIndicator)){
			loanTermsInterestRate.setStatus("YES");
        }
        else
        	loanTermsInterestRate.setStatus("NO");
       
        if("true".equalsIgnoreCase(other.BuydownReflectedInNoteIndicator) && !("").equals(buydownOccurence.BuydownInitialEffectiveInterestRatePercent))
			interest = buydownOccurence.BuydownInitialEffectiveInterestRatePercent;
        else if(!"".equals(termsOfLoan.disclosedFullyIndexedRatePercent))
			interest = termsOfLoan.disclosedFullyIndexedRatePercent;
		else if(!"".equals(termsOfLoan.weightedAverageInterestRatePercent))
			interest = termsOfLoan.weightedAverageInterestRatePercent;
		else
			interest = termsOfLoan.noteRatePercent;
        
		loanTermsInterestRate.setInterest(interest);
        loanTermsInterestRate.setBuydownTemporarySubsidyFundingIndicator(loanDetail.buydownTemporarySubsidyFundingIndicator);
 	    loanTermsInterestRate.setGseBuydownReflectedInNoteIndicator(other.BuydownReflectedInNoteIndicator);
 	    loanTermsInterestRate.setBuydownInitialEffectiveInterestRatePercent(buydownOccurence.BuydownInitialEffectiveInterestRatePercent);
 	    loanTermsInterestRate.setBuydownChangeFrequencyMonthsCount(buydownRule.BuydownChangeFrequencyMonthsCount);
 	    loanTermsInterestRate.setBuydownIncreaseRatePercent(buydownRule.BuydownIncreaseRatePercent);
 	    loanTermsInterestRate.setNoteRatePercent(termsOfLoan.noteRatePercent);
 	    loanTermsInterestRate.setDisclosedFullyIndexedRatePercent(termsOfLoan.disclosedFullyIndexedRatePercent);
 	    loanTermsInterestRate.setInterestRateIncreaseIndicator(loanDetail.interestRateIncreaseIndicator);
 	    loanTermsInterestRate.setAdjustmentRuleTypeFirst("First");
 	    loanTermsInterestRate.setPerChangeRateAdjustmentFrequencyMonthsCount(interestRatePerChangeAdjustmentRule.PerChangeRateAdjustmentFrequencyMonthsCount);
 	    loanTermsInterestRate.setFirstRateChangeMonthsCount(interestRateLifetimeAdjustmentRule.FirstRateChangeMonthsCount);
 	    loanTermsInterestRate.setCeilingRatePercentEarliestEffectiveMonthsCount(interestRateLifetimeAdjustmentRule.CeilingRatePercentEarliestEffectiveMonthsCount);
 	    loanTermsInterestRate.setCeilingRatePercent(interestRateLifetimeAdjustmentRule.CeilingRatePercent);
 	    loanTermsInterestRate.setDisclosedFullyIndexedRatePercent(termsOfLoan.disclosedFullyIndexedRatePercent);
 	    
 	    //loanTermsPI
		
		if("true".equalsIgnoreCase(loanDetail.paymentIncreaseIndicator))
			loanTermsPI.setStatus("YES");
		else
			loanTermsPI.setStatus("NO");
		
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
		loanTermsPI.setInterestOnlyIndicator(loanDetail.interestOnlyIndicator);
		loanTermsPI.setInterestOnlyTermMonthsCount(interestOnly.InterestOnlyTermMonthsCount);
		loanTermsPI.setAdjustmentRuleType("First");
		loanTermsPI.setFirstPrincipalAndInterestPaymentChangeMonthsCount(principalAndInterestPaymentLifetimeAdjustmentRule.FirstPrincipalAndInterestPaymentChangeMonthsCount);
		loanTermsPI.setPrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount(principalAndInterestPaymentLifetimeAdjustmentRule.PrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount);
		loanTermsPI.setPrincipalAndInterestPaymentMaximumAmount(principalAndInterestPaymentLifetimeAdjustmentRule.PrincipalAndInterestPaymentMaximumAmount);
 	 
		//loanTermsPrepaymentPenalty
		
		if("true".equalsIgnoreCase(loanDetail.prepaymentPenaltyIndicator))
			loanTermsPrepaymentPenalty.setStatus("YES");
		else
			loanTermsPrepaymentPenalty.setStatus("NO");
			
		loanTermsPrepaymentPenalty.setPrepaymentPenaltyIndicator(loanDetail.prepaymentPenaltyIndicator);
		loanTermsPrepaymentPenalty.setPrepaymentPenaltyMaximumLifeOfLoanAmount(prepaymentPenaltyLifetimeRule.PrepaymentPenaltyMaximumLifeOfLoanAmount);
		loanTermsPrepaymentPenalty.setPrepaymentPenaltyExpirationMonthsCount(prepaymentPenaltyLifetimeRule.PrepaymentPenaltyExpirationMonthsCount);	

		//LoanTermsBalloonPayment
		if("true".equalsIgnoreCase(loanDetail.balloonIndicator))
			loanTermsBalloonPayment.setStatus("YES");
		else
			loanTermsBalloonPayment.setStatus("NO");
		
		loanTermsBalloonPayment.setBalloonIndicator(loanDetail.balloonIndicator);
		loanTermsBalloonPayment.setBalloonPaymentAmount(loanDetail.balloonPaymentAmount);
		
		//LoanTermsIntialEscrow
		
		if(null != escrowItems && null != escrowItem)
		{
			EscrowItem escrowsItem = getEscrowModel(escrowItems,"InitialEscrowPaymentAtClosing");
			loanTermsIntialEscrow.setEscrowIndicator("YES");
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
		 	loanTermsIntialEscrow.setEscrowIndicator("NO");
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
		
		//loanTermsETIA
		List<LoanTermsETIA>  loanTermsETIAs = new LinkedList<>();

		for(int i=0; i<estimatedPropertyCostComponents.estimatedPropertyCostComponent.length; i++){
			LoanTermsETIA  loanTermsETIA = new LoanTermsETIA();
			loanTermsETIA.setProjectedPaymentEscrowedType(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEscrowedType);
			loanTermsETIA.setProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEstimatedTaxesInsuranceAssessmentComponentType);
			loanTermsETIA.setProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription(estimatedPropertyCostComponents.estimatedPropertyCostComponent[i].projectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription);
			loanTermsETIAs.add(loanTermsETIA);
		}
		
		loanTermsEscrowAccount.setFirstYearTotalNonEscrowPaymentDescription(idDetail.FirstYearTotalNonEscrowPaymentAmount);
		loanTermsEscrowAccount.setFirstYearTotalNonEscrowPaymentAmount(idDetail.FirstYearTotalNonEscrowPaymentDescription);
	
        loanTerms.setLoanTermsLoanAmount(loanTermsLoanAmount);
 	    loanTerms.setLoanTermsInterestRate(loanTermsInterestRate);
 	    loanTerms.setLoanTermsPI(loanTermsPI);
 	    loanTerms.setLoanTermsPrepaymentPenalty(loanTermsPrepaymentPenalty);
 	    loanTerms.setLoanTermsBalloonPayment(loanTermsBalloonPayment);
 	    loanTerms.setLoanTermsIntialEscrow(loanTermsIntialEscrow);
 	    loanTerms.setLoanTermsETIA(loanTermsETIAs);
 	    loanTerms.setLoanTermsEscrowAccount(loanTermsEscrowAccount);
    	return loanTerms;
    }
    
    /**
	 * calculates all the projected payments elements
	 * @param deal
	 * @return ProjectedPaymentsModel as a List
	 */
	private ProjectedPaymentsModel createProjectedPayments(Deal deal)
	{
		ProjectedPayments payments = new ProjectedPayments((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/PROJECTED_PAYMENTS"));	
		EstimatedPropertyCost propertyCost = new EstimatedPropertyCost((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/ESTIMATED_PROPERTY_COST"));
		LoanDetail loanDetail = new LoanDetail((Element)deal.getElementAddNS("LOANS/LOAN/LOAN_DETAIL"));
		ProjectedPaymentsModel projectedPaymentsModel = new ProjectedPaymentsModel();
		List<ProjectedPaymentsDetails> projectedPaymentList = new LinkedList<>();
		InterestOnly interestOnly = new InterestOnly((Element)deal.getElementAddNS("LOANS/LOAN/INTEREST_ONLY"));
		String monthscount  = interestOnly.InterestOnlyTermMonthsCount;
		int interestOnlyTermMonthsCount = 0;
			if(null != monthscount && !"".equalsIgnoreCase(monthscount)){
				interestOnlyTermMonthsCount = Integer.parseInt(monthscount);
			}
			
		for (int i = 0; i < payments.projectedPayments.length && i < 4; i++) {
			ProjectedPayment payment = payments.projectedPayments[i];
			projectedPaymentsModel.setPaymentFrequencyType(payment.paymentFrequencyType);
			ProjectedPaymentsDetails projectedPayment = new ProjectedPaymentsDetails();
				projectedPayment.setPaymentFrequencyType(payment.paymentFrequencyType);
				projectedPayment.setProjectedPaymentCalculationPeriodEndNumber(payment.projectedPaymentCalculationPeriodEndNumber);
				projectedPayment.setProjectedPaymentCalculationPeriodStartNumber(payment.projectedPaymentCalculationPeriodStartNumber);
				projectedPayment.setProjectedPaymentCalculationPeriodTermType(payment.projectedPaymentCalculationPeriodTermType);
				projectedPayment.setProjectedPaymentCalculationPeriodTermTypeOtherDescription(payment.projectedPaymentCalculationPeriodTermTypeOtherDescription);
				projectedPayment.setProjectedPaymentEstimatedEscrowPaymentAmount(payment.projectedPaymentEstimatedEscrowPaymentAmount);
				projectedPayment.setProjectedPaymentEstimatedTotalMaximumPaymentAmount(payment.projectedPaymentEstimatedTotalMaximumPaymentAmount);
				projectedPayment.setProjectedPaymentEstimatedTotalMinimumPaymentAmount(payment.projectedPaymentEstimatedTotalMinimumPaymentAmount);
				projectedPayment.setProjectedPaymentMIPaymentAmount(payment.projectedPaymentMIPaymentAmount);
				projectedPayment.setProjectedPaymentPrincipalAndInterestMaximumPaymentAmount(payment.projectedPaymentPrincipalAndInterestMaximumPaymentAmount);
				projectedPayment.setProjectedPaymentPrincipalAndInterestMinimumPaymentAmount(payment.projectedPaymentPrincipalAndInterestMinimumPaymentAmount);
				projectedPayment.setSequenceNumber(payment.sequenceNumber);
				int startYear = Integer.parseInt(payment.projectedPaymentCalculationPeriodStartNumber);
				if ((startYear-1)*12 < interestOnlyTermMonthsCount && "true".equalsIgnoreCase(loanDetail.interestOnlyIndicator))
					projectedPayment.setInterestOnlyStatus("true");
			projectedPaymentList.add(projectedPayment);
		}
		projectedPaymentsModel.setProjectedPaymentsDetails(projectedPaymentList);
		return projectedPaymentsModel;
	}
	
	/**
	 * creates CostsAtClosing UI response
	 * @param deal
	 * @return CostsAtClosing
	 */
	private CostsAtClosing createCostsAtClosing(Deal deal)
	{
		DocumentClass documentClass = new DocumentClass((Element)deal.getElementAddNS("../../../../DOCUMENT_CLASSIFICATION/DOCUMENT_CLASSES/DOCUMENT_CLASS[DocumentType='Other']"));
		String idSummary = "LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_SECTION_SUMMARIES/INTEGRATED_DISCLOSURE_SECTION_SUMMARY";
		String idDetail = idSummary + "/INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL";
		String ciDetail = "LOANS/LOAN/CLOSING_INFORMATION/CLOSING_INFORMATION_DETAIL";
		ClosingInformationDetail closingDetail = new ClosingInformationDetail((Element)deal.getElementAddNS(ciDetail));
		IntegratedDisclosureSectionSummaryDetail idClosingDetail = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSectionType='TotalClosingCosts'][IntegratedDisclosureSubsectionType='ClosingCostsSubtotal']"));
		IntegratedDisclosureSectionSummaryDetail totalOtherCosts = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSectionType='TotalOtherCosts']"));
		IntegratedDisclosureSectionSummaryDetail totalLoanCosts = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSectionType='TotalLoanCosts']"));
		IntegratedDisclosureSubsectionPayment idLenderCredits = new IntegratedDisclosureSubsectionPayment((Element)deal.getElementAddNS(idSummary + "[INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL/IntegratedDisclosureSubsectionType='LenderCredits']/INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENTS/INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENT"));
		String lenderCredits;
		if (idLenderCredits.integratedDisclosureSubsectionPaymentAmount.equals("")) {
			IntegratedDisclosureSectionSummaryDetail idLenderCreditTwo = new IntegratedDisclosureSectionSummaryDetail((Element)deal.getElementAddNS(idDetail + "[IntegratedDisclosureSubsectionType='LenderCredits']"));
			lenderCredits = idLenderCreditTwo.integratedDisclosureSubsectionTotalAmount;
		} else
			lenderCredits = idLenderCredits.integratedDisclosureSubsectionPaymentAmount;
		
		CostsAtClosingClosingCosts costsAtClosingClosingCosts = new CostsAtClosingClosingCosts();
		CostsAtClosingCashToClose costsAtClosingCashToClose = new CostsAtClosingCashToClose(); 
			costsAtClosingClosingCosts.setAmount(idClosingDetail.integratedDisclosureSectionTotalAmount);
			costsAtClosingClosingCosts.setTotalOtherCosts(totalOtherCosts.integratedDisclosureSectionTotalAmount);
			costsAtClosingClosingCosts.setLenderCredits(lenderCredits);
			costsAtClosingClosingCosts.setTotalLoanCosts(totalLoanCosts.integratedDisclosureSectionTotalAmount);
			costsAtClosingCashToClose.setAmount(closingDetail.CashFromBorrowerAtClosingAmount.equals("") ? closingDetail.CashToBorrowerAtClosingAmount : closingDetail.CashFromBorrowerAtClosingAmount);
			costsAtClosingCashToClose.setCashFromBorrowerAtClosingAmount(closingDetail.CashFromBorrowerAtClosingAmount);
			costsAtClosingCashToClose.setCashToBorrowerAtClosingAmount(closingDetail.CashToBorrowerAtClosingAmount);
		
		if("ClosingDisclosure:AlternateForm".equalsIgnoreCase(documentClass.documentTypeOtherDescription)){
			costsAtClosingCashToClose.setFromType("".equals(closingDetail.CashFromBorrowerAtClosingAmount.trim())?"false":"true");
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
		ClosingCostDetailsLoanCosts closingCostDetailsLoanCosts = new ClosingCostDetailsLoanCosts();

		List<ClosingCostProperties> originationChargeList = new LinkedList<>();
		List<ClosingCostProperties> sbDidNotShopFors = new LinkedList<>();
		List<ClosingCostProperties> sbDidShopFors = new LinkedList<>();
		ClosingCostProperties tlCosts = new ClosingCostProperties();
		
		String loan = "LOANS/LOAN";
	    DocumentClass documentClass = new DocumentClass((Element)deal.getElementAddNS("../../../../DOCUMENT_CLASSIFICATION/DOCUMENT_CLASSES/DOCUMENT_CLASS"));
		String idSummary = "LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_SECTION_SUMMARIES/INTEGRATED_DISCLOSURE_SECTION_SUMMARY";
		String idDetail = idSummary + "/INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL";
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
					if(null != closingCostProperties.getFeeType())
						originationChargeList.add(closingCostProperties);
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
					closingCostProperties = feeCostsTableRow(fee, true);
					closingCostProperties.setToEntity(fee.feeDetail.feeTotalPercent);
				}
				else
				{
					closingCostProperties = feeCostsTableRow(fee, true);
				}
			else
				closingCostProperties = feeCostsTableRow(fee, true);
		}
		return closingCostProperties;
	}
	
    /**
     * Insert Fee Details
     * @param fee
     * @param withTo
     * @param label
     * @param to
     * @return
     */
	private ClosingCostProperties feeCostsTableRow(Fee fee, boolean to) 
	{
		
		String paidTo = null != fee.feePaidTo ? fee.feePaidTo.legalEntity.legalEntityDetail.fullName:"";
		ClosingCostProperties closingCostProperties = new ClosingCostProperties();
				
		/*str += !"".equals(fee.feeDetail.feePaidToTypeOtherDescription) ? fee.feeDetail.feePaidToTypeOtherDescription :"";
		  if ("true".equals(fee.feeDetail.optionalCostIndicator) && !"".equals(fee.feeDetail.feePaidToTypeOtherDescription) && !fee.feeDetail.feePaidToTypeOtherDescription.toLowerCase().contains("optional"))
			str += " (optional)";*/
	
		closingCostProperties.setToEntity(StringFormatter.STRINGCLEAN.formatString(paidTo));
		
		closingCostProperties.setFeeType(StringFormatter.CAMEL.formatString(fee.feeDetail.feeType));
		closingCostProperties.setGseDisplayLabel(fee.feeDetail.displayLabelText);
		
		if(!"".equals(fee.feeDetail.displayLabelText))
			closingCostProperties.setDisplayLabel(fee.feeDetail.displayLabelText);
		else if("Other".equalsIgnoreCase(fee.feeDetail.feeType))
			    closingCostProperties.setDisplayLabel(StringFormatter.CAMEL.formatString(fee.feeDetail.feeTypeOtherDescription));
		else
			closingCostProperties.setDisplayLabel(StringFormatter.CAMEL.formatString(fee.feeDetail.feeType));
		
		if(fee.feePayments.feePayments.length > 0)
		for(FeePayment feepay :fee.feePayments.feePayments)
		{
			if(!"".equals(feepay.FeePaymentPaidByType))
				{
					String paidByType = feepay.FeePaymentPaidByType;
					if( "Buyer".equalsIgnoreCase(paidByType)) 
						if("true".equalsIgnoreCase(feepay.FeePaymentPaidOutsideOfClosingIndicator))
				            closingCostProperties.setBpB4Closing((!"".equals(feepay.FeeActualPaymentAmount) && StringFormatter.doubleValue(feepay.FeeActualPaymentAmount) != 0) ? feepay.FeeActualPaymentAmount : "");
						else
						    closingCostProperties.setBpAtClosing(((!"".equals(feepay.FeeActualPaymentAmount) && StringFormatter.doubleValue(feepay.FeeActualPaymentAmount) != 0)) ? feepay.FeeActualPaymentAmount : "");
					else if("Seller".equalsIgnoreCase(paidByType))
						if("true".equalsIgnoreCase(feepay.FeePaymentPaidOutsideOfClosingIndicator))
		                    closingCostProperties.setSpAtClosing((!"".equals(feepay.FeeActualPaymentAmount) && StringFormatter.doubleValue(feepay.FeeActualPaymentAmount) != 0) ? feepay.FeeActualPaymentAmount : "");
						else
		                    closingCostProperties.setSpAtClosing((!"".equals(feepay.FeeActualPaymentAmount) && StringFormatter.doubleValue(feepay.FeeActualPaymentAmount) != 0) ? feepay.FeeActualPaymentAmount : "");
					else
                        closingCostProperties.setPaidByOthers((!"".equals(feepay.FeeActualPaymentAmount) && StringFormatter.doubleValue(feepay.FeeActualPaymentAmount) != 0) ? feepay.FeeActualPaymentAmount : "");
					
					if("Lender".equalsIgnoreCase(paidByType))
						closingCostProperties.setLenderStatus("YES");
					else
						closingCostProperties.setLenderStatus("NO");
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
	private ClosingCostProperties calculateTLCosts(IntegratedDisclosureSectionSummaryDetail totalLoanCosts, IntegratedDisclosureSectionSummaries integratedDisclosureSectionSummaries)
	{
		ClosingCostProperties tlCosts = new ClosingCostProperties();
        	
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
						tlCosts.setLenderStatus("YES");
					else
						tlCosts.setLenderStatus("NO");
				}
			}
		}
		return tlCosts;
	}
		
	/**
     * create ClosingCostDetailsOtherCosts UI response
     * @param deal
     * @return ClosingCostDetailsOtherCosts
     */
    private ClosingCostDetailsOtherCosts createClosingCostOtherCosts(Deal deal)
    {
    	ClosingCostDetails closingCostDetails = new ClosingCostDetails();
    	ClosingCostDetailsOtherCosts closingCostDetailsOtherCosts = new ClosingCostDetailsOtherCosts();
    	List<ClosingCostProperties> tOGovtFeesList = new ArrayList<>();
		List<Prepaids> prepaidsList = new LinkedList<>();
		List<IEPatClosing> iePatClosingList = new LinkedList<>();
		List<ClosingCostProperties> otherCostsList = new LinkedList<>();
		String deedAmt = "";
		String mrtgAmt = "";
		Fee recordingFee = null;
    	Fees taxesAndOtherGovernmentFees = new Fees((Element)deal.getElementAddNS("LOANS/LOAN/FEE_INFORMATION/FEES"),"[FEE_DETAIL/IntegratedDisclosureSectionType = 'TaxesAndOtherGovernmentFees']");
    	for(Fee fee : taxesAndOtherGovernmentFees.fees)
		{
			ClosingCostProperties closingCostProperties = new ClosingCostProperties();
			switch (fee.feeDetail.feeType){
			case "RecordingFeeForDeed":
				deedAmt = fee.feeDetail.feeActualTotalAmount;
				break;
				//8.2.1
			case "RecordingFeeForMortgage":
				mrtgAmt = fee.feeDetail.feeActualTotalAmount;
				break;
			case "RecordingFeeTotal":
				recordingFee = fee;
				break;
			default:
				closingCostProperties = feeCostsTableRow(fee, true);
			
			if(null != closingCostProperties.getFeeType())
				tOGovtFeesList.add(closingCostProperties);	
			}
		}
    	
    	
    	Collections.sort(tOGovtFeesList,new Comparator<ClosingCostProperties>(){
			@Override
			public int compare(ClosingCostProperties o1, ClosingCostProperties o2) {
				return o1.getFeeType().compareTo(o2.getFeeType());
			}
		});
    	String str = "Recording Fees          " +"Deed: "+ deedAmt+ " Mortgage: " + mrtgAmt;
    	if (null != recordingFee)
    		tOGovtFeesList.add(0, feeCostsTableRow(recordingFee, false));
    	
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
		
		closingCostDetailsOtherCosts.setPrepaidsList(prepaidsList);
		return closingCostDetailsOtherCosts;
    	
    }
    /**
     * Creates createCalculatingCashtoClose UI response
     * @param document
     * @return 
     */
    public List<CashToClose> createCalculatingCashtoClose(Deal deal) {
    	List<CashToClose> cashToCloseList = new LinkedList<>();
		
    	DocumentClass documentClass = new DocumentClass((Element)deal.getElementAddNS("../../../../DOCUMENT_CLASSIFICATION/DOCUMENT_CLASSES/DOCUMENT_CLASS[DocumentType='Other']"));
		boolean alternateView = "ClosingDisclosure:AlternateForm".equalsIgnoreCase(documentClass.documentTypeOtherDescription) ? true : false ;

		List<CashToCloseModel> cashToCloseModels = populateCashToCloseModel(deal);
		String closingCostsFinancedDetail = "";
		String closingCostsFinancedFinalAmount = "";
		for (CashToCloseModel cashToCloseModel : cashToCloseModels) {
			switch (cashToCloseModel.getItemType()) {
				case "LoanAmount":
					setValuesAndInsert(cashToCloseList,cashToCloseModel,"Loan Amount",!alternateView ? "-1" : "1");
					break;
				case "TotalClosingCosts":
					setValuesAndInsert(cashToCloseList,cashToCloseModel,"Total Closing Costs (J)",!alternateView ? "1" : "2");
					break;
				case "ClosingCostsPaidBeforeClosing":
					setValuesAndInsert(cashToCloseList,cashToCloseModel,"Closing Costs Paid Before Closing",!alternateView ? "2" : "3");
					break;
				case "ClosingCostsFinanced":
					closingCostsFinancedDetail = "Closing Costs Financed (Paid from your Loan Amount)";
					closingCostsFinancedFinalAmount =  cashToCloseModel.getItemFinalAmount();
					setValuesAndInsert(cashToCloseList,cashToCloseModel,"Closing Costs Financed \n (Paid from your Loan Amount)",!alternateView ? "3" : "-1");
					break;
				case "DownPayment":
					setValuesAndInsert(cashToCloseList,cashToCloseModel,"Down Payment/Funds from Borrower",!alternateView ? "4" : "-1");
					break;
				case "TotalPayoffsAndPayments":
					setValuesAndInsert(cashToCloseList,cashToCloseModel,"Total Payoffs and Payments (K)",!alternateView ? "-1" : "4");
					break;
				case "Deposit":
					setValuesAndInsert(cashToCloseList,cashToCloseModel,"Deposit",!alternateView ? "5" : "-1");
					break;
				case "FundsForBorrower":
					setValuesAndInsert(cashToCloseList,cashToCloseModel,"Funds for Borrower",!alternateView ? "6" : "-1");
					break;
				case "SellerCredits":
					setValuesAndInsert(cashToCloseList,cashToCloseModel,"Seller Credits",!alternateView ? "7" : "-1");
					break;
				case "AdjustmentsAndOtherCredits":
					setValuesAndInsert(cashToCloseList,cashToCloseModel,"Adjustments and Other Credits",!alternateView ? "8" : "-1");
					break;
				case "CashToCloseTotal":
					CashToClose cashToClose = new CashToClose();
					cashToClose.setLabel("Cash to Close");
					cashToClose.setIndex(!alternateView ? "9" : "5");
					if(alternateView){
						if (!cashToCloseModel.getItemEstimatedAmount().isEmpty()) {
							if(cashToCloseModel.getItemPaymentType().equalsIgnoreCase("FromBorrower")){
								cashToClose.setDtcStatus("YES");
							} else if(cashToCloseModel.getItemPaymentType().equalsIgnoreCase("ToBorrower")){
								cashToClose.setDtcStatus("NO");
							}
						} else if(!cashToCloseModel.getItemFinalAmount().isEmpty()) {
							if (cashToCloseModel.getItemPaymentType().equalsIgnoreCase("FromBorrower")) {
								cashToClose.setDtcStatus("YES");
							} else if(cashToCloseModel.getItemPaymentType().equalsIgnoreCase("ToBorrower")){
								cashToClose.setDtcStatus("NO");
							}
						}
						if(!closingCostsFinancedFinalAmount.isEmpty()){
							cashToClose.setClosingCostsFinancedTotalAmount(closingCostsFinancedFinalAmount);
							cashToClose.setDtcDetail(closingCostsFinancedDetail);
						}
					}
					cashToClose.setType(cashToCloseModel.getItemType());
					cashToClose.setLeFromBorrower(cashToCloseModel.getItemEstimatedAmount());
					cashToClose.setFinalFromBorrower(cashToCloseModel.getItemFinalAmount());
					cashToCloseList.add(cashToClose);
					break;
			}
		}
		
		Collections.sort(cashToCloseList,new Comparator<CashToClose>(){
			@Override
			public int compare(CashToClose o1, CashToClose o2) {
				return o1.getIndex().compareTo(o2.getIndex());
			}
		});
		
		return cashToCloseList;
	}
	
    /**
     * Insert values to UI response
     * @param cashToCloseList
     * @param cashToCloseModel
     * @param displayLabel
     * @param index
     */
	private void setValuesAndInsert(List<CashToClose> cashToCloseList,CashToCloseModel cashToCloseModel, String displayLabel, String index)
	{
		if(!"-1".equals(index))
		{
			CashToClose cashToClose = new CashToClose();
				cashToClose.setLabel(displayLabel);
				cashToClose.setType(cashToCloseModel.getItemType());
				cashToClose.setLeFromBorrower(cashToCloseModel.getItemEstimatedAmount());
				cashToClose.setFinalFromBorrower(cashToCloseModel.getItemFinalAmount());
				cashToClose.setDtcStatus(cashToCloseModel.getIsAmountChangedIndicator());
				cashToClose.setDtcDetail(cashToCloseModel.getItemChangeDescription());
				cashToClose.setIndex(index);
			cashToCloseList.add(cashToClose);
		}
	}
	
	/**
	 * Insert CashToClose values to populate in UI response
	 * @param deal
	 * @return CashToCloseModel List
	 */
	public List<CashToCloseModel> populateCashToCloseModel(Deal deal)
	{
		List<CashToCloseModel> cashToCloseModels = new LinkedList<>();
		CashToCloseItems cashToCloseItems = new CashToCloseItems((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/CASH_TO_CLOSE_ITEMS"));

		System.out.println("CashToCloseItems length:::::"+cashToCloseItems.cashToCloseItems.length);
		if(null != cashToCloseItems && cashToCloseItems.cashToCloseItems.length>0)
		{
			for(CashToCloseItem cashtocloseitem : cashToCloseItems.cashToCloseItems)
			{
				CashToCloseModel cashToCloseModel = new CashToCloseModel();
					cashToCloseModel.setIsAmountChangedIndicator(!"".equals(cashtocloseitem.integratedDisclosureCashToCloseItemAmountChangedIndicator) ? cashtocloseitem.integratedDisclosureCashToCloseItemAmountChangedIndicator : "");
					cashToCloseModel.setItemChangeDescription(!"".equals(cashtocloseitem.integratedDisclosureCashToCloseItemChangeDescription) ? cashtocloseitem.integratedDisclosureCashToCloseItemChangeDescription : "");
					cashToCloseModel.setItemEstimatedAmount(!"".equals(cashtocloseitem.integratedDisclosureCashToCloseItemEstimatedAmount) ? cashtocloseitem.integratedDisclosureCashToCloseItemEstimatedAmount : "");
					cashToCloseModel.setItemPaymentType(!"".equals(cashtocloseitem.integratedDisclosureCashToCloseItemPaymentType) ? cashtocloseitem.integratedDisclosureCashToCloseItemPaymentType : "");
					cashToCloseModel.setItemType(!"".equals(cashtocloseitem.integratedDisclosureCashToCloseItemType) ? cashtocloseitem.integratedDisclosureCashToCloseItemType : "" );
					cashToCloseModel.setItemFinalAmount(!"".equals(cashtocloseitem.integratedDisclosureCashToCloseItemFinalAmount) ? cashtocloseitem.integratedDisclosureCashToCloseItemFinalAmount : "");
				cashToCloseModels.add(cashToCloseModel);
			}	
		}
		return cashToCloseModels;
	}
	
    /**
     * Populates the EscrowItem from XML for a given escrow type
     * @param escrowItems
     * @param escrowType
     * @return EscrowsModel
     */
    private EscrowItem getEscrowModel(EscrowItems escrowItems, String escrowType){
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
			if (propertyValuationDetail.PropertyValuationAmount.equals(""))
				return propertyDetail.PropertyEstimatedValueAmount;
			else
				return propertyValuationDetail.PropertyValuationAmount;		
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
	private List<Borrower> createBorrowers(Parties borrowers) {
		
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
				borrower.setNameModel(applicant);
				borrower.setAddress(addressModel);
				borrowersList.add(borrower);
			}	
		}
		return borrowersList;
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
			prepaid.setFeeType(prepaidItem.prepaidItemDetail.prepaidItemType);
			prepaid.setGseDisplayLabel(prepaidItem.prepaidItemDetail.displayLabelText);
			if(null != prepaidItem.prepaidItemDetail.displayLabelText && !"".equals(prepaidItem.prepaidItemDetail.displayLabelText))
				prepaid.setDisplayLabel(prepaidItem.prepaidItemDetail.displayLabelText);
			else if("Other".equalsIgnoreCase(prepaidItem.prepaidItemDetail.displayLabelText))
				prepaid.setDisplayLabel(StringFormatter.CAMEL.formatString(prepaidItem.prepaidItemDetail.prepaidItemTypeOtherDescription));
			else
				prepaid.setDisplayLabel(StringFormatter.CAMEL.formatString(prepaidItem.prepaidItemDetail.prepaidItemType));
			if (to)
			{
				if(("PrepaidInterest").equalsIgnoreCase(prepaid.getFeeType()))
				{
					prepaid.setMonths(prepaidItem.prepaidItemDetail.prepaidItemPerDiemAmount);
					prepaid.setToDate(prepaidItem.prepaidItemDetail.prepaidItemPaidFromDate);
					prepaid.setFromDate(prepaidItem.prepaidItemDetail.prepaidItemPaidThroughDate);
				}
				else
				{
					prepaid.setMonths(prepaidItem.prepaidItemDetail.prepaidItemMonthsPaidCount);
       			 	prepaid.setToEntity(prepaidItem.prepaidItemPaidTo.legalEntity.legalEntityDetail.fullName);
				}
			}
			
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
						prepaid.setLenderStatus("YES");
					else
						prepaid.setLenderStatus("NO");
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
	
}
