/**
 * @(#)ClosingDisclosureConverter.java 1.0 04/11/2017
 */

package com.actualize.mortgage.convertors;

import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.cdpagemodels.ClosingDisclosure;
import com.actualize.mortgage.cdpagemodels.ClosingDisclosurePageOne;
import com.actualize.mortgage.domainmodels.Borrower;
import com.actualize.mortgage.domainmodels.ClosingInformation;
import com.actualize.mortgage.domainmodels.CostsAtClosing;
import com.actualize.mortgage.domainmodels.CostsAtClosingCashToClose;
import com.actualize.mortgage.domainmodels.CostsAtClosingClosingCosts;
import com.actualize.mortgage.domainmodels.EscrowsModel;
import com.actualize.mortgage.domainmodels.FeeModel;
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
import com.actualize.mortgage.ledatamodels.IntegratedDisclosureDetail;
import com.actualize.mortgage.ledatamodels.IntegratedDisclosureSectionSummaryDetail;
import com.actualize.mortgage.ledatamodels.IntegratedDisclosureSubsectionPayment;
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

import leform.Formatter;

/**
 * This class will map all the Closing Disclosure XPATH elements to JSON Objects and its attributes 
 * @author rsudula
 * @version 1.0
 * 
 */

public class ClosingDisclosureConverter {
	String loanId = "";
	String loanMic = "";
    public ClosingDisclosure convertXmltoJSON(MISMODocument mismodoc) {
        ClosingDisclosure closingDisclosure = new ClosingDisclosure();
      
        // Page -1 method
     // Page -2 method
     // Page -3 method
     // Page -4 method
     // Page -5 method
        
        
        Document document = null;
        NodeList nodes = mismodoc.getElementsAddNS("//DOCUMENT");
        if (nodes.getLength() > 0)
            document = new Document(Document.NS, (Element)nodes.item(0));
        Deal deal = new Deal(Deal.NS, (Element)document.getElementAddNS("DEAL_SETS/DEAL_SET/DEALS/DEAL"));

        //PAGE - 1 Closing Information Section Mapping
       
        
        ClosingDisclosurePageOne closingDisclosurePageOne = new ClosingDisclosurePageOne();
        closingDisclosurePageOne.setClosingInformation(createClosingInformation(deal));
        closingDisclosurePageOne.setTransactionInformation(createTransactionInformation(deal));
        closingDisclosurePageOne.setLoanInformation(createLoanInformation(deal));
        closingDisclosurePageOne.setLoanTerms(createLoanTerms(mismodoc));
        closingDisclosurePageOne.setProjectedPayments(createProjectedPayments(deal));
        closingDisclosurePageOne.setCostsAtClosing(createCostsAtClosing(deal));
        closingDisclosure.setClosingDisclosurePageOne(closingDisclosurePageOne);
        return closingDisclosure;
    }
 
    /**
     * extracts ClosingInformation from xml and converts to JSON
     * @param mismodoc
     * @return closingInformationSection of PageOne
     */
    private ClosingInformation createClosingInformation(Deal deal)
    {
  		  LegalEntityDetail legalEntityDetail = null;
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
          closingInformationSection.setSettlementAgent(legalEntityDetail.FullName);
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
		if(("Purchase").equalsIgnoreCase(loanTerms.LoanPurposeType))
			loanPurpose = "Purchase";
		else if("true".equalsIgnoreCase(loanDetail.constructionLoanIndicator))
			loanPurpose = "Construction";
		else if("true".equalsIgnoreCase(idDetail.IntegratedDisclosureHomeEquityLoanIndicator))
			loanPurpose = "Home Equity Loan";
		else
			loanPurpose = "Refinance"; 	  	
		//Loan Type
		loanType = loanTerms.MortgageType;
		//Loan Product
		loanProduct = idDetail.IntegratedDisclosureLoanProductDescription;
		//Loan Mic && Loan Id
		if("true".equalsIgnoreCase(loanDetail.miRequiredIndicator)){
			if("Conventional".equalsIgnoreCase(loanTerms.MortgageType)){
				loanMic = miDataDetail.MICertificateIdentifier;
			}
			else
			{
				loanInformationLoanIdentifiers.forEach(loanidentifierdata ->{
					if("AgencyCase".equalsIgnoreCase(loanidentifierdata.getLoanIdentifierType()))
						loanMic = loanidentifierdata.getLoanIdentifier();
				});
			}
		}
		loanInformationLoanIdentifiers.forEach(loanidentifierdata ->{
			if("LenderLoan".equalsIgnoreCase(loanidentifierdata.getLoanIdentifierType()))
				loanId = loanidentifierdata.getLoanIdentifier();
		});
		
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
 	    loanInformationSection.setLienPriorityType(loanTerms.LienPriorityType);
 	    loanInformationSection.setIntegratedDisclosureLoanProductDescription(idDetail.IntegratedDisclosureLoanProductDescription);
 	    loanInformationSection.setMortgageType(loanTerms.MortgageType);
 	    loanInformationSection.setMortgageTypeOtherDescription(loanTerms.MortgageTypeOtherDescription);
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
		String initialPrincipalAndInterestPaymentAmount = "";
		String fullyIndexedInitialPrincipalAndInterestPaymentAmount = "";
		String interestOnlyIndicator = "";
		String interestOnlyTermMonthsCount = "";
		String adjustmentRuleType = "First";
		String perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount = "";
		String firstPrincipalAndInterestPaymentChangeMonthsCount = "";
		String principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount = "";
		String principalAndInterestPaymentMaximumAmount = "";
		String escrowIndicator = "";
		String feeType = "EscrowWaiverFee";
		String feeActualPaymentAmount = "";
		String integratedDisclosureSectionType = "InitialEscrowPaymentAtClosing";
		String escrowItemType = "";
		String displayLabelText = "";
		String feePaidToType = "";
		String typeOtherDescription = "";
		String escrowItemPaymentPaidByType = "";
		String escrowItemActualPaymentAmount = "";
		String aboutVersionIdentifier = "";
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
        
        loanTermsLoanAmount.setAmount(termsOfLoan.NoteAmount);
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
        else if(!"".equals(termsOfLoan.DisclosedFullyIndexedRatePercent))
			interest = termsOfLoan.DisclosedFullyIndexedRatePercent;
		else if(!"".equals(termsOfLoan.WeightedAverageInterestRatePercent))
			interest = termsOfLoan.WeightedAverageInterestRatePercent;
		else
			interest = termsOfLoan.NoteRatePercent;
        
		loanTermsInterestRate.setInterest(interest);
        loanTermsInterestRate.setBuydownTemporarySubsidyFundingIndicator(loanDetail.buydownTemporarySubsidyFundingIndicator);
 	    loanTermsInterestRate.setGseBuydownReflectedInNoteIndicator(other.BuydownReflectedInNoteIndicator);
 	    loanTermsInterestRate.setBuydownInitialEffectiveInterestRatePercent(buydownOccurence.BuydownInitialEffectiveInterestRatePercent);
 	    loanTermsInterestRate.setBuydownChangeFrequencyMonthsCount(buydownRule.BuydownChangeFrequencyMonthsCount);
 	    loanTermsInterestRate.setBuydownIncreaseRatePercent(buydownRule.BuydownIncreaseRatePercent);
 	    loanTermsInterestRate.setNoteRatePercent(termsOfLoan.NoteRatePercent);
 	    loanTermsInterestRate.setDisclosedFullyIndexedRatePercent(termsOfLoan.DisclosedFullyIndexedRatePercent);
 	    loanTermsInterestRate.setInterestRateIncreaseIndicator(loanDetail.interestRateIncreaseIndicator);
 	    loanTermsInterestRate.setAdjustmentRuleTypeFirst("First");
 	    loanTermsInterestRate.setPerChangeRateAdjustmentFrequencyMonthsCount(interestRatePerChangeAdjustmentRule.PerChangeRateAdjustmentFrequencyMonthsCount);
 	    loanTermsInterestRate.setFirstRateChangeMonthsCount(interestRateLifetimeAdjustmentRule.FirstRateChangeMonthsCount);
 	    loanTermsInterestRate.setCeilingRatePercentEarliestEffectiveMonthsCount(interestRateLifetimeAdjustmentRule.CeilingRatePercentEarliestEffectiveMonthsCount);
 	    loanTermsInterestRate.setCeilingRatePercent(interestRateLifetimeAdjustmentRule.CeilingRatePercent);
 	    loanTermsInterestRate.setDisclosedFullyIndexedRatePercent(termsOfLoan.DisclosedFullyIndexedRatePercent);
 	    
 	    //loanTermsPI
		
		if("true".equalsIgnoreCase(loanDetail.paymentIncreaseIndicator))
			loanTermsPI.setStatus("YES");
		else
			loanTermsPI.setStatus("NO");
		
		if(!"".equals(paymentRule.InitialPrincipalAndInterestPaymentAmount))
			principalAmount = paymentRule.InitialPrincipalAndInterestPaymentAmount;
		if("".equalsIgnoreCase(principalAmount))
			principalAmount = paymentRule.FullyIndexedInitialPrincipalAndInterestPaymentAmount;
		
		initialPrincipalAndInterestPaymentAmount = paymentRule.InitialPrincipalAndInterestPaymentAmount;
		fullyIndexedInitialPrincipalAndInterestPaymentAmount = paymentRule.FullyIndexedInitialPrincipalAndInterestPaymentAmount;
		interestOnlyIndicator = loanDetail.interestOnlyIndicator;
		interestOnlyTermMonthsCount = interestOnly.InterestOnlyTermMonthsCount;
		firstPrincipalAndInterestPaymentChangeMonthsCount = principalAndInterestPaymentLifetimeAdjustmentRule.FirstPrincipalAndInterestPaymentChangeMonthsCount;
		principalAndInterestPaymentMaximumAmount = principalAndInterestPaymentLifetimeAdjustmentRule.PrincipalAndInterestPaymentMaximumAmount;
		principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount = principalAndInterestPaymentLifetimeAdjustmentRule.PrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount;
        
		//AboutVersionIdentifier
		for(int i=0; i<aboutVersions.aboutVersions.length; i++){
			aboutVersionList.add(aboutVersions.aboutVersions[i]);
	    }
		   
		if(interestRatePerChangeAdjustmentRules.interestRatePerChangeAdjustmentRules.length>0)
	        for(int i=0; i<interestRatePerChangeAdjustmentRules.interestRatePerChangeAdjustmentRules.length;i++)
	 	    {
	        	for(AboutVersion aboutVersion : aboutVersionList){
	        		aboutVersionIdentifier = aboutVersion.AboutVersionIdentifier;
	        	
				if("DDOFileNumber".equalsIgnoreCase(aboutVersionIdentifier))
					perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount  = interestRatePerChangeAdjustmentRules.interestRatePerChangeAdjustmentRules[i].PerChangeRateAdjustmentFrequencyMonthsCount;
				else
					if(adjustmentRuleType.equalsIgnoreCase(interestRatePerChangeAdjustmentRules.interestRatePerChangeAdjustmentRules[i].AdjustmentRuleType))
						perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount = interestRatePerChangeAdjustmentRules.interestRatePerChangeAdjustmentRules[i].PerChangeRateAdjustmentFrequencyMonthsCount;
	        	}
	        }
		
 	    loanTermsPI.setPaymentFrequencyType(paymentRule.PaymentFrequencyType);
		loanTermsPI.setAmount(principalAmount);
 	    loanTermsPI.setInitialPrincipalAndInterestPaymentAmount(initialPrincipalAndInterestPaymentAmount);
		loanTermsPI.setFullyIndexedInitialPrincipalAndInterestPaymentAmount(fullyIndexedInitialPrincipalAndInterestPaymentAmount);
		loanTermsPI.setFirstPrincipalAndInterestPaymentChangeMonthsCount(firstPrincipalAndInterestPaymentChangeMonthsCount);
		loanTermsPI.setInterestOnlyIndicator(interestOnlyIndicator);
		loanTermsPI.setInterestOnlyTermMonthsCount(interestOnlyTermMonthsCount);
		loanTermsPI.setAdjustmentRuleType(adjustmentRuleType);
		loanTermsPI.setPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount(perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount);
		loanTermsPI.setFirstPrincipalAndInterestPaymentChangeMonthsCount(firstPrincipalAndInterestPaymentChangeMonthsCount);
		loanTermsPI.setPrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount(principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount);
		loanTermsPI.setPrincipalAndInterestPaymentMaximumAmount(principalAndInterestPaymentMaximumAmount);
 	 
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
			escrowIndicator = "YES";
			EscrowsModel escrowsModel = getEscrowModel(escrowItems,integratedDisclosureSectionType);
			escrowItemType = escrowsModel.getType();
			displayLabelText = escrowsModel.getLabel();
			feePaidToType = escrowsModel.getPaidToType();
			typeOtherDescription = escrowsModel.getTypeOtherDescription();
			escrowItemPaymentPaidByType = escrowsModel.getPaymentPaidByType();
			if("Buyer".equalsIgnoreCase(escrowItemPaymentPaidByType)) 
				escrowItemActualPaymentAmount = escrowsModel.getBuyerAtClosingAmount();
			else if("Seller".equalsIgnoreCase(escrowItemPaymentPaidByType))
				escrowItemActualPaymentAmount = escrowsModel.getSellerAtClosingAmount();
			else
				escrowItemActualPaymentAmount = escrowsModel.getOtherAmount();
		 }
		 else
		 {
		 	escrowIndicator = "NO";
		 	if(fees.fees.length > 0 )
		 		for(int i=0;i<fees.fees.length;i++){
		 			FeeDetail Feedetail = fees.fees[i].feeDetail;
		 			if(!"".equals(Feedetail.FeeType) && "EscrowWaiverFee".equalsIgnoreCase(Feedetail.FeeType))
		 			{
		 				FeeModel feeModel = getFeeModel(fees.fees[i]);
		 				feeActualPaymentAmount = "To Discuss";
		 			}
		 		}
		 }
		
		loanTermsIntialEscrow.setEscrowIndicator(escrowIndicator);
		loanTermsIntialEscrow.setFeeType(feeType);
		loanTermsIntialEscrow.setFeeActualPaymentAmount(feeActualPaymentAmount);
		loanTermsIntialEscrow.setIntegratedDisclosureSectionType(integratedDisclosureSectionType);
		loanTermsIntialEscrow.setEscrowItemType(escrowItemType);
		loanTermsIntialEscrow.setDisplayLabelText(displayLabelText);
		loanTermsIntialEscrow.setFeePaidToType(feePaidToType);
		loanTermsIntialEscrow.setTypeOtherDescription(typeOtherDescription);
		loanTermsIntialEscrow.setEscrowItemPaymentPaidByType(escrowItemPaymentPaidByType);
		loanTermsIntialEscrow.setEscrowItemActualPaymentAmount(escrowItemActualPaymentAmount);
		
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
	 * calculates CostsAtClosing elements
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
     * Populates the escrow model from XML for a given escrow type
     * @param escrowItems
     * @param escrowType
     * @return EscrowsModel
     */
    private EscrowsModel getEscrowModel(EscrowItems escrowItems, String escrowType){
		EscrowsModel escrowsModel = new EscrowsModel();
		String dLabel = "";
		if(escrowItems.escrowItems.length>0 && (null != escrowType || "".equalsIgnoreCase(escrowType)))
	        for(int i=0; i<escrowItems.escrowItems.length;i++)
	 	    {
	        	EscrowItemDetail escrowItemDetail = escrowItems.escrowItems[i].escrowItemDetail;
	        	
	        	if(escrowType.equalsIgnoreCase(escrowItemDetail.EscrowItemType))
	        	{
					dLabel = null != escrowItemDetail.DisplayLabelText ? escrowItemDetail.DisplayLabelText : "";
					if(null == dLabel || dLabel.isEmpty())
						dLabel = null != escrowItemDetail.EscrowItemType ? StringFormatter.CAMEL.formatString(escrowItemDetail.EscrowItemType):"";
					if("Other".equalsIgnoreCase(dLabel))
					{
						if(null != escrowItemDetail.EscrowItemTypeOtherDescription && !escrowItemDetail.EscrowItemTypeOtherDescription.isEmpty())
							escrowsModel.setLabel(escrowItemDetail.EscrowItemTypeOtherDescription);
					}
					else
						escrowsModel.setLabel(dLabel);
						
					escrowsModel.setType(null != escrowItemDetail.EscrowItemType ? escrowItemDetail.EscrowItemType : null);		
				
				if(null != escrowItemDetail.FeePaidToType)
					escrowsModel.setPaidToType(escrowItemDetail.FeePaidToType);
					
					escrowsModel.setMonthlyPaymentAmount(null != escrowItemDetail.EscrowMonthlyPaymentAmount ? escrowItemDetail.EscrowMonthlyPaymentAmount : "");
					escrowsModel.setCollectedNumberOfMonthsCount(null != escrowItemDetail.EscrowCollectedNumberOfMonthsCount ? escrowItemDetail.EscrowCollectedNumberOfMonthsCount : "");
					
					EscrowItemPayments EscrowItemPayments = escrowItems.escrowItems[i].escrowItemPayments;
					
					if(EscrowItemPayments.escrowItemPayment.length > 0)
				        for(int j=0; i<EscrowItemPayments.escrowItemPayment.length;j++)
				 	    {
				        	EscrowItemPayment EscrowItemPayment = EscrowItemPayments.escrowItemPayment[j];
							if( null != EscrowItemPayment.EscrowItemPaymentPaidByType)
							{
								String paidBy = EscrowItemPayment.EscrowItemPaymentPaidByType;
								escrowsModel.setPaymentPaidByType(paidBy);
								if( "Buyer".equalsIgnoreCase(paidBy)) 
									if("BeforeClosing".equalsIgnoreCase(EscrowItemPayment.EscrowItemPaymentTimingType))
										escrowsModel.setBuyerOutsideClosingAmount(null != EscrowItemPayment.EscrowItemActualPaymentAmount ? EscrowItemPayment.EscrowItemActualPaymentAmount : "");
									else
										escrowsModel.setBuyerAtClosingAmount(null != EscrowItemPayment.EscrowItemActualPaymentAmount ?  EscrowItemPayment.EscrowItemActualPaymentAmount : "");
								else if("Seller".equalsIgnoreCase(paidBy))
									if("BeforeClosing".equalsIgnoreCase(EscrowItemPayment.EscrowItemPaymentTimingType))
										escrowsModel.setSellerOutsideClosingAmount(null != EscrowItemPayment.EscrowItemActualPaymentAmount ? EscrowItemPayment.EscrowItemActualPaymentAmount : "");
									else
										escrowsModel.setSellerAtClosingAmount(null != EscrowItemPayment.EscrowItemActualPaymentAmount ? EscrowItemPayment.EscrowItemActualPaymentAmount : "");
								else
									escrowsModel.setOtherAmount(null != EscrowItemPayment.EscrowItemActualPaymentAmount ? EscrowItemPayment.EscrowItemActualPaymentAmount :"");
								
								if("Lender".equalsIgnoreCase(paidBy))
									escrowsModel.setLenderStatus("YES");
								else
									escrowsModel.setLenderStatus("NO");
							}
						}
	        	}
	 	    }
			
		return escrowsModel;
	}
    /**
     * Populates the Fee model from XML
     * @param fee
     * @return FeeModel
     */
    private FeeModel getFeeModel(Fee fee)
	{
		FeeModel feeModel = new FeeModel();
		String dLabel = "";
		if(null != fee.feeDetail) {
			FeeDetail feedetail = fee.feeDetail; 
			if(null != feedetail.FeeType)
			{
				dLabel = null != feedetail.DisplayLabelText ? feedetail.DisplayLabelText  : "";
				if(null == dLabel || dLabel.isEmpty())
					dLabel = null != feedetail.FeeType ? StringFormatter.CAMEL.formatString(feedetail.FeeType):"";
				if("Other".equalsIgnoreCase(dLabel))
				{
					if(null != feedetail.FeePaidToTypeOtherDescription && !feedetail.FeePaidToTypeOtherDescription.isEmpty())
						feeModel.setLabel(feedetail.FeePaidToTypeOtherDescription);
				}
				else
					feeModel.setLabel(dLabel);
					
				feeModel.setType(null != feedetail.FeeType ? feedetail.FeeType : null);		
			}
			
			if(null != feedetail.FeePaidToType)
				feeModel.setPaidToType(feedetail.FeePaidToType);
			if(null != feedetail.FeeActualTotalAmount)
				feeModel.setTotalAmount(feedetail.FeeActualTotalAmount);
			if(null != feedetail.OptionalCostIndicator)
				feeModel.setOptionalCostIndicator(Convertor.stringToBoolean(feedetail.OptionalCostIndicator));
		}
		
		FeePayments feePaymentsList = fee.feePayments;
		if(feePaymentsList.feePayments.length>0)
	        for(int i=0; i<feePaymentsList.feePayments.length;i++)
	 	    {
	        	
	 	  		FeePayment feePayment = feePaymentsList.feePayments[i];
	 	  		if( null != feePayment.FeePaymentPaidByType)
				{
					String paidBy = feePayment.FeePaymentPaidByType;
					feeModel.setPaymentPaidByType(paidBy);
					if( "Buyer".equalsIgnoreCase(paidBy)) 
						if("true".equalsIgnoreCase(feePayment.FeePaymentPaidOutsideOfClosingIndicator))
							feeModel.setBuyerOutsideClosingAmount(null != feePayment.FeeActualPaymentAmount ? feePayment.FeeActualPaymentAmount :"");
						else
							feeModel.setBuyerAtClosingAmount(null != feePayment.FeeActualPaymentAmount ? feePayment.FeeActualPaymentAmount :"");
					else if("Seller".equalsIgnoreCase(paidBy))
						if("true".equalsIgnoreCase(feePayment.FeePaymentPaidOutsideOfClosingIndicator))
							feeModel.setSellerOutsideClosingAmount(null != feePayment.FeeActualPaymentAmount ? feePayment.FeeActualPaymentAmount :"");
						else
							feeModel.setSellerAtClosingAmount(null != feePayment.FeeActualPaymentAmount ? feePayment.FeeActualPaymentAmount :"");
					else
						feeModel.setOtherAmount(null != feePayment.FeeActualPaymentAmount ? feePayment.FeeActualPaymentAmount :"");
					if("Lender".equalsIgnoreCase(paidBy))
						feeModel.setLenderStatus("YES");
					else
						feeModel.setLenderStatus("NO");
				}
			}
		
		return feeModel;
		
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
		if (!loanTerms.LoanPurposeType.equalsIgnoreCase("Purchase"))
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
	private static List<Borrower> createBorrowers(Parties borrowers) {
		
		List<Borrower> borrowersList = new LinkedList<>();
		if (borrowers.parties.length > 0) {
			for(int i=0; i<borrowers.parties.length;i++)
			{
				Borrower borrower = new Borrower();
				NameModel applicant = new NameModel();
				com.actualize.mortgage.domainmodels.Address addressModel = new com.actualize.mortgage.domainmodels.Address();
				if (!borrowers.parties[i].legalEntity.legalEntityDetail.FullName.equals(""))
				{	
					applicant.setFullName(borrowers.parties[i].legalEntity.legalEntityDetail.FullName);
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
}
