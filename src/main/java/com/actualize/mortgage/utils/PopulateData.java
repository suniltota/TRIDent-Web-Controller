package com.actualize.mortgage.utils;

import java.util.LinkedList;
import java.util.List;

import org.mismo.residential._2009.schemas.DEAL;
import org.mismo.residential._2009.schemas.DOCUMENT;
import org.mismo.residential._2009.schemas.LOANIDENTIFIER;

import com.actualize.mortgage.domainmodels.LoanInformation;
import com.actualize.mortgage.domainmodels.LoanInformationLoanIdentifier;
import com.actualize.mortgage.domainmodels.LoanTermsBalloonPayment;
import com.actualize.mortgage.domainmodels.LoanTermsETIA;
import com.actualize.mortgage.domainmodels.LoanTermsEscrowAccount;
import com.actualize.mortgage.domainmodels.LoanTermsInterestRate;
import com.actualize.mortgage.domainmodels.LoanTermsIntialEscrow;
import com.actualize.mortgage.domainmodels.LoanTermsLoanAmount;
import com.actualize.mortgage.domainmodels.LoanTermsPI;
import com.actualize.mortgage.domainmodels.LoanTermsPrepaymentPenalty;

public class PopulateData {
	
	public static LoanInformation populateLoanInformation(DOCUMENT document)
	{
		DEAL deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		LoanInformation loanInformation = new LoanInformation();
		
		 String constructionLoanType = "";
		 String constructionPeriodNumberOfMonthsCount = "";
		 String constructionLoanTotalTermMonthsCount = "";//nf
		 String loanMaturityPeriodType = "";
		 String loanMaturityPeriodCount = "";
		 String integratedDisclosureHomeEquityLoanIndicator = "";
		 String lienPriorityType = "";
		 String adjustableRate = "";//nf
		 String integratedDisclosureLoanProductDescription = "";
		 String mortgageType = "";
		 String mortgageTypeOtherDescription = "";
		 List<LoanInformationLoanIdentifier> loanIdentifiers = new LinkedList<>();
		 String miRequiredIndicator = "";
		 String miCertificateIdentifier = "";
		 
			
		 if(null != deal.getLOANS().getLOAN().getCONSTRUCTION() && null != deal.getLOANS().getLOAN().getCONSTRUCTION().getConstructionLoanType())
			 constructionLoanType = deal.getLOANS().getLOAN().getCONSTRUCTION().getConstructionLoanType().getValue().value();
		 if(null != deal.getLOANS().getLOAN().getCONSTRUCTION() && null != deal.getLOANS().getLOAN().getCONSTRUCTION().getConstructionLoanTotalTermMonthsCount())
			 constructionLoanTotalTermMonthsCount = Convertor.convertMonthsToDisplayFormat(deal.getLOANS().getLOAN().getCONSTRUCTION().getConstructionLoanTotalTermMonthsCount().getValue());
		 if(null != deal.getLOANS().getLOAN().getMATURITY().getMATURITYRULE().getLoanMaturityPeriodType())
			 loanMaturityPeriodType = deal.getLOANS().getLOAN().getMATURITY().getMATURITYRULE().getLoanMaturityPeriodType().getValue().value();
		 if(null != deal.getLOANS().getLOAN().getMATURITY().getMATURITYRULE().getLoanMaturityPeriodCount())
			 loanMaturityPeriodCount = Integer.toString(deal.getLOANS().getLOAN().getMATURITY().getMATURITYRULE().getLoanMaturityPeriodCount().getValue());
		 if(null != deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getIntegratedDisclosureHomeEquityLoanIndicator())
			 integratedDisclosureHomeEquityLoanIndicator = Convertor.booleanToString(deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getIntegratedDisclosureHomeEquityLoanIndicator().isValue());
		 if(null != deal.getLOANS().getLOAN().getTERMSOFLOAN().getLienPriorityType())
			 lienPriorityType = deal.getLOANS().getLOAN().getTERMSOFLOAN().getLienPriorityType().getValue().value();
		 
		 if(null != deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getIntegratedDisclosureLoanProductDescription())
			 integratedDisclosureLoanProductDescription = deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getIntegratedDisclosureLoanProductDescription().getValue();
		 if(null != deal.getLOANS().getLOAN().getTERMSOFLOAN().getMortgageType())
			 mortgageType = deal.getLOANS().getLOAN().getTERMSOFLOAN().getMortgageType().getValue().value();
		 if(null != deal.getLOANS().getLOAN().getTERMSOFLOAN().getMortgageType() && "Other".equalsIgnoreCase(deal.getLOANS().getLOAN().getTERMSOFLOAN().getMortgageType().getValue().value()))
			 mortgageTypeOtherDescription = deal.getLOANS().getLOAN().getTERMSOFLOAN().getMortgageTypeOtherDescription().getValue();
		 
		 
		 if(null != deal.getLOANS().getLOAN().getLOANDETAIL().getMIRequiredIndicator())
			 miRequiredIndicator = Convertor.booleanToString(deal.getLOANS().getLOAN().getLOANDETAIL().getMIRequiredIndicator().isValue());
		 if(null != deal.getLOANS().getLOAN().getMIDATA().getMIDATADETAIL().getMICertificateIdentifier())
			 miCertificateIdentifier = deal.getLOANS().getLOAN().getMIDATA().getMIDATADETAIL().getMICertificateIdentifier().getValue();
		 
		 
		 List<LOANIDENTIFIER> loanidentifiers = deal.getLOANS().getLOAN().getLOANIDENTIFIERS().getLOANIDENTIFIER();
			loanidentifiers.forEach(loanidentifier ->{
				if(null != loanidentifier.getLoanIdentifierType().getValue())
				{
					LoanInformationLoanIdentifier loanInformationLoanIdentifier = new LoanInformationLoanIdentifier();
						loanInformationLoanIdentifier.setLoanIdentifierType(loanidentifier.getLoanIdentifierType().getValue().value());
						loanInformationLoanIdentifier.setLoanIdentifier(loanidentifier.getLoanIdentifier().getValue());
						loanIdentifiers.add(loanInformationLoanIdentifier);
				}
			});
		 
		 loanInformation.setConstructionLoanType(constructionLoanType);
		 loanInformation.setConstructionPeriodNumberOfMonthsCount(constructionPeriodNumberOfMonthsCount);
		 loanInformation.setConstructionLoanTotalTermMonthsCount(constructionLoanTotalTermMonthsCount);
		 loanInformation.setLoanMaturityPeriodType(loanMaturityPeriodType);
		 loanInformation.setLoanMaturityPeriodCount(loanMaturityPeriodCount);
		 loanInformation.setIntegratedDisclosureHomeEquityLoanIndicator(integratedDisclosureHomeEquityLoanIndicator);
		 loanInformation.setLienPriorityType(lienPriorityType);
		 loanInformation.setAdjustableRate(adjustableRate);
		 loanInformation.setIntegratedDisclosureLoanProductDescription(integratedDisclosureLoanProductDescription);
		 loanInformation.setMortgageType(mortgageType);
		 loanInformation.setMortgageTypeOtherDescription(mortgageTypeOtherDescription);
		 loanInformation.setLoanIdentifiers(loanIdentifiers);
		 loanInformation.setMiRequiredIndicator(miRequiredIndicator);
		 loanInformation.setMiCertificateIdentifier(miCertificateIdentifier);
		return loanInformation;
		
	}
	
	public static LoanTermsLoanAmount populateLoanTermsLoanAmount(DOCUMENT document)
	{
		LoanTermsLoanAmount loanTermsLoanAmount = new LoanTermsLoanAmount();
		DEAL deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		
		 String noteAmount = "";
		 String loanAmountIncreaseIndicator = "";//nf
		 String negativeAmoritzationIndicator = "";//nf
		 String negativeAmortizationMaximumLoanBalanceAmount = "";
		 String negativeAmortizationLimitMonthsCount = "";
		
		if(null != deal.getLOANS().getLOAN().getTERMSOFLOAN().getNoteAmount())
			noteAmount = deal.getLOANS().getLOAN().getTERMSOFLOAN().getNoteAmount().getValue().toPlainString();
		if(null != deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION() && null != deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE().getNegativeAmortizationMaximumLoanBalanceAmount())
			negativeAmortizationMaximumLoanBalanceAmount = deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE().getNegativeAmortizationMaximumLoanBalanceAmount().getValue().toPlainString();
		if(null != deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION() && null != deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE().getNegativeAmortizationLimitMonthsCount())
			negativeAmortizationLimitMonthsCount = Integer.toString(deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE().getNegativeAmortizationLimitMonthsCount().getValue());
		
		loanTermsLoanAmount.setAmount(noteAmount);
		loanTermsLoanAmount.setLoanAmountIncreaseIndicator(loanAmountIncreaseIndicator);
		loanTermsLoanAmount.setNegativeAmoritzationIndicator(negativeAmoritzationIndicator);
		loanTermsLoanAmount.setNegativeAmortizationMaximumLoanBalanceAmount(negativeAmortizationMaximumLoanBalanceAmount);
		loanTermsLoanAmount.setNegativeAmortizationLimitMonthsCount(negativeAmortizationLimitMonthsCount);
		return loanTermsLoanAmount;
	}
	
	public static  LoanTermsInterestRate populateLoanTermsInterestRate(DOCUMENT document)
	{
		LoanTermsInterestRate loanTermsInterestRate = new LoanTermsInterestRate();
		DEAL deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		 String buydownTemporarySubsidyFundingIndicator = ""; //nf
		 String gseBuydownReflectedInNoteIndicator = ""; //nf
		 String buydownInitialEffectiveInterestRatePercent = "";
		 String buydownChangeFrequencyMonthsCount = "";//nf
		 String buydownIncreaseRatePercent = "";//nf
		 String noteRatePercent = "";//nf
		 String disclosedFullyIndexedRatePercent = "";
		 String interestRateIncreaseIndicator = "";//nf
		 String adjustmentRuleType = "";//nf
		 String perChangeRateAdjustmentFrequencyMonthsCount = "";//nf
		 String firstRateChangeMonthsCount = "";//nf
		 String ceilingRatePercentEarliestEffectiveMonthsCount = "";//nf
		 String ceilingRatePercent = "";//nf
		 
		 if(null != deal.getLOANS().getLOAN().getTERMSOFLOAN().getDisclosedFullyIndexedRatePercent())
			 disclosedFullyIndexedRatePercent =  deal.getLOANS().getLOAN().getTERMSOFLOAN().getDisclosedFullyIndexedRatePercent().getValue().toPlainString();
		
		 if(null != deal.getLOANS().getLOAN().getBUYDOWN() && deal.getLOANS().getLOAN().getBUYDOWN().getBUYDOWNRULE().getEXTENSION().getOTHER().isBuydownReflectedInNoteIndicator() && !("").equals(deal.getLOANS().getLOAN().getBUYDOWN().getBUYDOWNOCCURRENCES().getBUYDOWNOCCURRENCE().getBuydownInitialEffectiveInterestRatePercent().getValue().toPlainString()))
			buydownInitialEffectiveInterestRatePercent = deal.getLOANS().getLOAN().getBUYDOWN().getBUYDOWNOCCURRENCES().getBUYDOWNOCCURRENCE().getBuydownInitialEffectiveInterestRatePercent().getValue().toPlainString();
		 
		 
		 
		 loanTermsInterestRate.setBuydownTemporarySubsidyFundingIndicator(buydownTemporarySubsidyFundingIndicator);
		 loanTermsInterestRate.setGseBuydownReflectedInNoteIndicator(gseBuydownReflectedInNoteIndicator);
		 loanTermsInterestRate.setBuydownInitialEffectiveInterestRatePercent(buydownInitialEffectiveInterestRatePercent);
		 loanTermsInterestRate.setBuydownChangeFrequencyMonthsCount(buydownChangeFrequencyMonthsCount);
		 loanTermsInterestRate.setBuydownIncreaseRatePercent(buydownIncreaseRatePercent);
		 loanTermsInterestRate.setNoteRatePercent(noteRatePercent);
		 loanTermsInterestRate.setDisclosedFullyIndexedRatePercent(disclosedFullyIndexedRatePercent);
		 loanTermsInterestRate.setInterestRateIncreaseIndicator(interestRateIncreaseIndicator);
		 loanTermsInterestRate.setAdjustmentRuleType(adjustmentRuleType);
		 loanTermsInterestRate.setPerChangeRateAdjustmentFrequencyMonthsCount(perChangeRateAdjustmentFrequencyMonthsCount);
		 loanTermsInterestRate.setFirstRateChangeMonthsCount(firstRateChangeMonthsCount);
		 loanTermsInterestRate.setCeilingRatePercentEarliestEffectiveMonthsCount(ceilingRatePercentEarliestEffectiveMonthsCount);
		 loanTermsInterestRate.setCeilingRatePercent(ceilingRatePercent);
		 loanTermsInterestRate.setDisclosedFullyIndexedRatePercent(disclosedFullyIndexedRatePercent);
		 
		 return loanTermsInterestRate;
	}
	
	public static LoanTermsPI populateLoanTermsPI(DOCUMENT document)
	{
		LoanTermsPI loanTermsPI = new LoanTermsPI();
		DEAL deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		String initialPrincipalAndInterestPaymentAmount = "";//nf
		String fullyIndexedInitialPrincipalAndInterestPaymentAmount = "";//nf
		String interestOnlyIndicator = "";//nf
		String interestOnlyTermMonthsCount = "";//nf
		String adjustmentRuleType = "";//nf
		String perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount = "";//nf
		String firstPrincipalAndInterestPaymentChangeMonthsCount = "";//nf
		String principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount = "";//nf
		String principalAndInterestPaymentMaximumAmount = "";//nf
		
		
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
		return loanTermsPI;
		
	}
	
	public static LoanTermsPrepaymentPenalty populateLoanTermsPrepaymentPenalty(DOCUMENT document) 
	{
		LoanTermsPrepaymentPenalty loanTermsPrepaymentPenalty = new LoanTermsPrepaymentPenalty();
		DEAL deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		String prepaymentPenaltyIndicator = "";
		String prepaymentPenaltyMaximumLifeOfLoanAmount = "";//nf
		String prepaymentPenaltyExpirationMonthsCount = "";//nf
		if(null != deal.getLOANS().getLOAN().getLOANDETAIL().getPrepaymentPenaltyIndicator())
			prepaymentPenaltyIndicator = Convertor.booleanToString(deal.getLOANS().getLOAN().getLOANDETAIL().getPrepaymentPenaltyIndicator().isValue());
		
		loanTermsPrepaymentPenalty.setPrepaymentPenaltyIndicator(prepaymentPenaltyIndicator);
		loanTermsPrepaymentPenalty.setPrepaymentPenaltyMaximumLifeOfLoanAmount(prepaymentPenaltyMaximumLifeOfLoanAmount);
		loanTermsPrepaymentPenalty.setPrepaymentPenaltyExpirationMonthsCount(prepaymentPenaltyExpirationMonthsCount);
		return loanTermsPrepaymentPenalty;
	}
	
	public static LoanTermsBalloonPayment populateLoanTermsBalloonPayment(DOCUMENT document)
	{
		LoanTermsBalloonPayment loanTermsBalloonPayment = new LoanTermsBalloonPayment();
		DEAL deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		String balloonIndicator = "";
		String balloonPaymentAmount = "";
		if(null != deal.getLOANS().getLOAN().getLOANDETAIL().getBalloonIndicator())
			balloonIndicator = Convertor.booleanToString(deal.getLOANS().getLOAN().getLOANDETAIL().getBalloonIndicator().isValue());
		if(null != deal.getLOANS().getLOAN().getLOANDETAIL().getBalloonPaymentAmount())
			balloonPaymentAmount = deal.getLOANS().getLOAN().getLOANDETAIL().getBalloonPaymentAmount().getValue().toPlainString();
		
		loanTermsBalloonPayment.setBalloonIndicator(balloonIndicator);
		loanTermsBalloonPayment.setBalloonPaymentAmount(balloonPaymentAmount);
			
		return loanTermsBalloonPayment;
		
	}
	
	public static LoanTermsIntialEscrow populateLoanTermsIntialEscrow(DOCUMENT document)
	{
		LoanTermsIntialEscrow loanTermsIntialEscrow = new LoanTermsIntialEscrow();
		DEAL deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		String escrowIndicator = "";
		String feeType = "";
		String feeActualPaymentAmount = "";
		String integratedDisclosureSectionType = "";
		String escrowItemType = "";
		String displayLabelText = "";
		String feePaidToType = "";
		String typeOtherDescription = "";
		String escrowItemPaymentPaidByType = "";
		String escrowItemActualPaymentAmount = "";
		
		return loanTermsIntialEscrow;
		
	}
	
	public static LoanTermsETIA populateLoanTermsETIA(DOCUMENT document)
	{
		LoanTermsETIA  loanTermsETIA = new LoanTermsETIA();
		DEAL deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		String projectedPaymentEstimatedTaxesInsuranceAssessmentComponentType = "";
		String projectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription = "";
		String projectedPaymentEscrowedType = "";
		
		return loanTermsETIA;
		
	}
	
	public static LoanTermsEscrowAccount populateLoanTermsEscrowAccount(DOCUMENT document)
	{
		LoanTermsEscrowAccount  loanTermsEscrowAccount = new LoanTermsEscrowAccount();
		DEAL deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		String firstYearTotalNonEscrowPaymentDescription = "";
		String firstYearTotalNonEscrowPaymentAmount = "";
		
		
		return loanTermsEscrowAccount;
		
	}
}
