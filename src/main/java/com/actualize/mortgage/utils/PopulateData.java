package com.actualize.mortgage.utils;

import java.util.LinkedList;
import java.util.List;

import org.mismo.residential._2009.schemas.DEAL;
import org.mismo.residential._2009.schemas.DOCUMENT;
import org.mismo.residential._2009.schemas.ESCROWITEM;
import org.mismo.residential._2009.schemas.ESTIMATEDPROPERTYCOSTCOMPONENT;
import org.mismo.residential._2009.schemas.FEE;
import org.mismo.residential._2009.schemas.INTERESTRATEPERCHANGEADJUSTMENTRULE;
import org.mismo.residential._2009.schemas.LOAN;
import org.mismo.residential._2009.schemas.LOANIDENTIFIER;

import com.actualize.mortgage.domainmodels.EscrowsModel;
import com.actualize.mortgage.domainmodels.FeeModel;
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
		 String constructionLoanTotalTermMonthsCount = "";
		 String loanMaturityPeriodType = "";
		 String loanMaturityPeriodCount = "";
		 String integratedDisclosureHomeEquityLoanIndicator = "";
		 String lienPriorityType = "";
		 String amortizationType = "";
		 String integratedDisclosureLoanProductDescription = "";
		 String mortgageType = "";
		 String mortgageTypeOtherDescription = "";
		 List<LoanInformationLoanIdentifier> loanIdentifiers = new LinkedList<>();
		 String miRequiredIndicator = "";
		 String miCertificateIdentifier = "";
		 
		 if(null != deal.getLOANS().getLOAN().getCONSTRUCTION()) {
			 if( null != deal.getLOANS().getLOAN().getCONSTRUCTION().getConstructionLoanType())
				 constructionLoanType = deal.getLOANS().getLOAN().getCONSTRUCTION().getConstructionLoanType().getValue().value();
			 if(null != deal.getLOANS().getLOAN().getCONSTRUCTION().getConstructionLoanTotalTermMonthsCount())
				 constructionLoanTotalTermMonthsCount = Convertor.convertMonthsToDisplayFormat(deal.getLOANS().getLOAN().getCONSTRUCTION().getConstructionLoanTotalTermMonthsCount().getValue());
			 if(null != deal.getLOANS().getLOAN().getCONSTRUCTION().getConstructionPeriodNumberOfMonthsCount())
				 constructionPeriodNumberOfMonthsCount = Integer.toString(deal.getLOANS().getLOAN().getCONSTRUCTION().getConstructionPeriodNumberOfMonthsCount().getValue());
		 }
		 
		 if(null != deal.getLOANS().getLOAN().getAMORTIZATION() && null != deal.getLOANS().getLOAN().getAMORTIZATION().getAMORTIZATIONRULE() && null != deal.getLOANS().getLOAN().getAMORTIZATION().getAMORTIZATIONRULE().getAmortizationType())
			 amortizationType =  deal.getLOANS().getLOAN().getAMORTIZATION().getAMORTIZATIONRULE().getAmortizationType().getValue().value();
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
		 if(null != deal.getLOANS().getLOAN().getMIDATA() && null != deal.getLOANS().getLOAN().getMIDATA().getMIDATADETAIL().getMICertificateIdentifier())
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
		 loanInformation.setAmortizationType(amortizationType);
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
		 String negativeAmoritzationIndicator = "";
		 String negativeAmortizationMaximumLoanBalanceAmount = "";
		 String negativeAmortizationLimitMonthsCount = "";
		
		if(null != deal.getLOANS().getLOAN().getTERMSOFLOAN().getNoteAmount())
			noteAmount = deal.getLOANS().getLOAN().getTERMSOFLOAN().getNoteAmount().getValue().toPlainString();
		if(null != deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION() && null != deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE().getNegativeAmortizationMaximumLoanBalanceAmount())
			negativeAmortizationMaximumLoanBalanceAmount = deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE().getNegativeAmortizationMaximumLoanBalanceAmount().getValue().toPlainString();
		if(null != deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION() && null != deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE().getNegativeAmortizationLimitMonthsCount())
			negativeAmortizationLimitMonthsCount = Integer.toString(deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE().getNegativeAmortizationLimitMonthsCount().getValue());
		if(null != deal.getLOANS().getLOAN().getLOANDETAIL().getLoanAmountIncreaseIndicator() && deal.getLOANS().getLOAN().getLOANDETAIL().getLoanAmountIncreaseIndicator().isValue())
			negativeAmoritzationIndicator = Convertor.booleanToString(deal.getLOANS().getLOAN().getLOANDETAIL().getLoanAmountIncreaseIndicator().isValue());
		
		loanTermsLoanAmount.setAmount(noteAmount);
		loanTermsLoanAmount.setNegativeAmoritzationIndicator(negativeAmoritzationIndicator);
		loanTermsLoanAmount.setNegativeAmortizationMaximumLoanBalanceAmount(negativeAmortizationMaximumLoanBalanceAmount);
		loanTermsLoanAmount.setNegativeAmortizationLimitMonthsCount(negativeAmortizationLimitMonthsCount);
		return loanTermsLoanAmount;
	}
	
	public static  LoanTermsInterestRate populateLoanTermsInterestRate(DOCUMENT document)
	{
		LoanTermsInterestRate loanTermsInterestRate = new LoanTermsInterestRate();
		DEAL deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		 String buydownTemporarySubsidyFundingIndicator = "";
		 String gseBuydownReflectedInNoteIndicator = ""; 
		 String buydownInitialEffectiveInterestRatePercent = "";
		 String buydownChangeFrequencyMonthsCount = "";
		 String buydownIncreaseRatePercent = "";
		 String noteRatePercent = "";
		 String disclosedFullyIndexedRatePercent = "";
		 String interestRateIncreaseIndicator = "";
		 String adjustmentRuleTypeFirst = "First";
		 String perChangeRateAdjustmentFrequencyMonthsCount = "";
		 String firstRateChangeMonthsCount = "";
		 String ceilingRatePercentEarliestEffectiveMonthsCount = "";
		 String ceilingRatePercent = "";
		 
		 if(null != deal.getLOANS().getLOAN().getLOANDETAIL().getBuydownTemporarySubsidyFundingIndicator())
			buydownTemporarySubsidyFundingIndicator = Convertor.booleanToString(deal.getLOANS().getLOAN().getLOANDETAIL().getBuydownTemporarySubsidyFundingIndicator().isValue());
		 
		 if(null != deal.getLOANS().getLOAN().getBUYDOWN() && null != deal.getLOANS().getLOAN().getBUYDOWN().getBUYDOWNRULE()){
			 if(null!= deal.getLOANS().getLOAN().getBUYDOWN().getBUYDOWNRULE().getEXTENSION().getOTHER().isBuydownReflectedInNoteIndicator() && !("").equals(deal.getLOANS().getLOAN().getBUYDOWN().getBUYDOWNOCCURRENCES().getBUYDOWNOCCURRENCE().getBuydownInitialEffectiveInterestRatePercent().getValue().toPlainString()))
				 buydownInitialEffectiveInterestRatePercent = deal.getLOANS().getLOAN().getBUYDOWN().getBUYDOWNOCCURRENCES().getBUYDOWNOCCURRENCE().getBuydownInitialEffectiveInterestRatePercent().getValue().toPlainString();
			 if(null != deal.getLOANS().getLOAN().getBUYDOWN().getBUYDOWNRULE().getBuydownChangeFrequencyMonthsCount())
				 buydownChangeFrequencyMonthsCount = Integer.toString(deal.getLOANS().getLOAN().getBUYDOWN().getBUYDOWNRULE().getBuydownChangeFrequencyMonthsCount().getValue());
			 if(null!= deal.getLOANS().getLOAN().getBUYDOWN().getBUYDOWNRULE().getEXTENSION().getOTHER().isBuydownReflectedInNoteIndicator())
				 gseBuydownReflectedInNoteIndicator = deal.getLOANS().getLOAN().getBUYDOWN().getBUYDOWNRULE().getEXTENSION().getOTHER().isBuydownReflectedInNoteIndicator().toString();
			 if(null != deal.getLOANS().getLOAN().getBUYDOWN().getBUYDOWNRULE().getBuydownIncreaseRatePercent())
				 buydownIncreaseRatePercent = deal.getLOANS().getLOAN().getBUYDOWN().getBUYDOWNRULE().getBuydownIncreaseRatePercent().getValue().toPlainString();
		 } 
		 
		 if(null != deal.getLOANS().getLOAN().getTERMSOFLOAN() && null != deal.getLOANS().getLOAN().getTERMSOFLOAN().getNoteRatePercent() && null != deal.getLOANS().getLOAN().getAMORTIZATION() &&  null != deal.getLOANS().getLOAN().getAMORTIZATION().getAMORTIZATIONRULE() && null != deal.getLOANS().getLOAN().getAMORTIZATION().getAMORTIZATIONRULE().getAmortizationType()&& ("Fixed").equalsIgnoreCase(deal.getLOANS().getLOAN().getAMORTIZATION().getAMORTIZATIONRULE().getAmortizationType().getValue().value()))
		 	noteRatePercent = deal.getLOANS().getLOAN().getTERMSOFLOAN().getNoteRatePercent().getValue().toPlainString();
		 
		 if(null != deal.getLOANS().getLOAN().getTERMSOFLOAN() && null != deal.getLOANS().getLOAN().getTERMSOFLOAN().getDisclosedFullyIndexedRatePercent() && null != deal.getLOANS().getLOAN().getAMORTIZATION() &&  null != deal.getLOANS().getLOAN().getAMORTIZATION().getAMORTIZATIONRULE() && null != deal.getLOANS().getLOAN().getAMORTIZATION().getAMORTIZATIONRULE().getAmortizationType()&& ("AdjustableRate").equalsIgnoreCase(deal.getLOANS().getLOAN().getAMORTIZATION().getAMORTIZATIONRULE().getAmortizationType().getValue().value()))
		 	disclosedFullyIndexedRatePercent = deal.getLOANS().getLOAN().getTERMSOFLOAN().getDisclosedFullyIndexedRatePercent().getValue().toPlainString();
		 
		 if(deal.getLOANS().getLOAN().getLOANDETAIL().getInterestRateIncreaseIndicator().isValue())
		 {
			List<INTERESTRATEPERCHANGEADJUSTMENTRULE> interestrateperchangeadjustmentrules = deal.getLOANS().getLOAN().getADJUSTMENT().getINTERESTRATEADJUSTMENT().getINTERESTRATEPERCHANGEADJUSTMENTRULES().getINTERESTRATEPERCHANGEADJUSTMENTRULE();
			for (INTERESTRATEPERCHANGEADJUSTMENTRULE interestrateperchangeadjustmentrule : interestrateperchangeadjustmentrules ){
				if("DDOFileNumber".equalsIgnoreCase(DocumentType.getAboutVersionIdentifier()))
					perChangeRateAdjustmentFrequencyMonthsCount  = Integer.toString(interestrateperchangeadjustmentrule.getPerChangeRateAdjustmentFrequencyMonthsCount().getValue());
				else
					if("First".equalsIgnoreCase(interestrateperchangeadjustmentrule.getAdjustmentRuleType().getValue().value()))
						perChangeRateAdjustmentFrequencyMonthsCount = Integer.toString(interestrateperchangeadjustmentrule.getPerChangeRateAdjustmentFrequencyMonthsCount().getValue());
			}
		 }
		 if(null != deal.getLOANS().getLOAN().getADJUSTMENT().getINTERESTRATEADJUSTMENT().getINTERESTRATELIFETIMEADJUSTMENTRULE() && null != deal.getLOANS().getLOAN().getADJUSTMENT().getINTERESTRATEADJUSTMENT().getINTERESTRATELIFETIMEADJUSTMENTRULE().getFirstRateChangeMonthsCount())
			 firstRateChangeMonthsCount = Integer.toString(deal.getLOANS().getLOAN().getADJUSTMENT().getINTERESTRATEADJUSTMENT().getINTERESTRATELIFETIMEADJUSTMENTRULE().getFirstRateChangeMonthsCount().getValue());
		 
		 if(null != deal.getLOANS().getLOAN().getADJUSTMENT().getINTERESTRATEADJUSTMENT().getINTERESTRATELIFETIMEADJUSTMENTRULE() && null != deal.getLOANS().getLOAN().getADJUSTMENT().getINTERESTRATEADJUSTMENT().getINTERESTRATELIFETIMEADJUSTMENTRULE().getCeilingRatePercent())
		 	 ceilingRatePercent = deal.getLOANS().getLOAN().getADJUSTMENT().getINTERESTRATEADJUSTMENT().getINTERESTRATELIFETIMEADJUSTMENTRULE().getCeilingRatePercent().getValue().toPlainString();
		 if(null != deal.getLOANS().getLOAN().getADJUSTMENT().getINTERESTRATEADJUSTMENT().getINTERESTRATELIFETIMEADJUSTMENTRULE() && null != deal.getLOANS().getLOAN().getADJUSTMENT().getINTERESTRATEADJUSTMENT().getINTERESTRATELIFETIMEADJUSTMENTRULE().getCeilingRatePercentEarliestEffectiveMonthsCount())
			 ceilingRatePercentEarliestEffectiveMonthsCount = Integer.toString(deal.getLOANS().getLOAN().getADJUSTMENT().getINTERESTRATEADJUSTMENT().getINTERESTRATELIFETIMEADJUSTMENTRULE().getCeilingRatePercentEarliestEffectiveMonthsCount().getValue());
		 
		 
		 loanTermsInterestRate.setBuydownTemporarySubsidyFundingIndicator(buydownTemporarySubsidyFundingIndicator);
		 loanTermsInterestRate.setGseBuydownReflectedInNoteIndicator(gseBuydownReflectedInNoteIndicator);
		 loanTermsInterestRate.setBuydownInitialEffectiveInterestRatePercent(buydownInitialEffectiveInterestRatePercent);
		 loanTermsInterestRate.setBuydownChangeFrequencyMonthsCount(buydownChangeFrequencyMonthsCount);
		 loanTermsInterestRate.setBuydownIncreaseRatePercent(buydownIncreaseRatePercent);
		 loanTermsInterestRate.setNoteRatePercent(noteRatePercent);
		 loanTermsInterestRate.setDisclosedFullyIndexedRatePercent(disclosedFullyIndexedRatePercent);
		 loanTermsInterestRate.setInterestRateIncreaseIndicator(interestRateIncreaseIndicator);
		 loanTermsInterestRate.setAdjustmentRuleTypeFirst(adjustmentRuleTypeFirst);
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
		String initialPrincipalAndInterestPaymentAmount = "";
		String fullyIndexedInitialPrincipalAndInterestPaymentAmount = "";
		String interestOnlyIndicator = "";
		String interestOnlyTermMonthsCount = "";
		String adjustmentRuleType = "First";
		String perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount = "";
		String firstPrincipalAndInterestPaymentChangeMonthsCount = "";
		String principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount = "";
		String principalAndInterestPaymentMaximumAmount = "";
		
		if(null != deal.getLOANS().getLOAN().getPAYMENT() && null!= deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE())
		{
			if(null != deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getInitialPrincipalAndInterestPaymentAmount())
				initialPrincipalAndInterestPaymentAmount = deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getInitialPrincipalAndInterestPaymentAmount().getValue().toPlainString();
			if(null != deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getFullyIndexedInitialPrincipalAndInterestPaymentAmount())
				fullyIndexedInitialPrincipalAndInterestPaymentAmount = deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getFullyIndexedInitialPrincipalAndInterestPaymentAmount().getValue().toPlainString();
		}
		if(null != deal.getLOANS().getLOAN().getLOANDETAIL().getInterestOnlyIndicator())
			interestOnlyIndicator = Convertor.booleanToString(deal.getLOANS().getLOAN().getLOANDETAIL().getInterestOnlyIndicator().isValue());
		if(null != deal.getLOANS().getLOAN().getINTERESTONLY() && null != deal.getLOANS().getLOAN().getINTERESTONLY().getInterestOnlyTermMonthsCount())
			interestOnlyTermMonthsCount = Integer.toString(deal.getLOANS().getLOAN().getINTERESTONLY().getInterestOnlyTermMonthsCount().getValue());
		if(null != deal.getLOANS().getLOAN().getADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTADJUSTMENT() && null != deal.getLOANS().getLOAN().getADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTLIFETIMEADJUSTMENTRULE())
		{
			if(null != deal.getLOANS().getLOAN().getADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTLIFETIMEADJUSTMENTRULE().getFirstPrincipalAndInterestPaymentChangeMonthsCount())
				firstPrincipalAndInterestPaymentChangeMonthsCount = Integer.toString(deal.getLOANS().getLOAN().getADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTLIFETIMEADJUSTMENTRULE().getFirstPrincipalAndInterestPaymentChangeMonthsCount().getValue());
			if(null != deal.getLOANS().getLOAN().getADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTLIFETIMEADJUSTMENTRULE().getPrincipalAndInterestPaymentMaximumAmount())
				principalAndInterestPaymentMaximumAmount = deal.getLOANS().getLOAN().getADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTLIFETIMEADJUSTMENTRULE().getPrincipalAndInterestPaymentMaximumAmount().getValue().toPlainString();
			if(null != deal.getLOANS().getLOAN().getADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTLIFETIMEADJUSTMENTRULE().getPrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount())
				principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount = Integer.toString(deal.getLOANS().getLOAN().getADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTLIFETIMEADJUSTMENTRULE().getPrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount().getValue());
		}
		if(null != deal.getLOANS().getLOAN().getADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTADJUSTMENT() && null != deal.getLOANS().getLOAN().getADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTPERCHANGEADJUSTMENTRULES().getPRINCIPALANDINTERESTPAYMENTPERCHANGEADJUSTMENTRULE())
		{
			List<INTERESTRATEPERCHANGEADJUSTMENTRULE> interestrateperchangeadjustmentrules = deal.getLOANS().getLOAN().getADJUSTMENT().getINTERESTRATEADJUSTMENT().getINTERESTRATEPERCHANGEADJUSTMENTRULES().getINTERESTRATEPERCHANGEADJUSTMENTRULE();
			for (INTERESTRATEPERCHANGEADJUSTMENTRULE interestrateperchangeadjustmentrule : interestrateperchangeadjustmentrules ){
				if("DDOFileNumber".equalsIgnoreCase(DocumentType.getAboutVersionIdentifier()))
					perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount  = Integer.toString(interestrateperchangeadjustmentrule.getPerChangeRateAdjustmentFrequencyMonthsCount().getValue());
				else
					if(adjustmentRuleType.equalsIgnoreCase(interestrateperchangeadjustmentrule.getAdjustmentRuleType().getValue().value()))
						perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount = Integer.toString(interestrateperchangeadjustmentrule.getPerChangeRateAdjustmentFrequencyMonthsCount().getValue());
			}
		}
		
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
		String prepaymentPenaltyMaximumLifeOfLoanAmount = "";
		String prepaymentPenaltyExpirationMonthsCount = "";
		if(null != deal.getLOANS().getLOAN().getLOANDETAIL().getPrepaymentPenaltyIndicator())
			prepaymentPenaltyIndicator = Convertor.booleanToString(deal.getLOANS().getLOAN().getLOANDETAIL().getPrepaymentPenaltyIndicator().isValue());
		if(null != deal.getLOANS().getLOAN().getPREPAYMENTPENALTY() && null != deal.getLOANS().getLOAN().getPREPAYMENTPENALTY().getPREPAYMENTPENALTYLIFETIMERULE())
		{
			if(null != deal.getLOANS().getLOAN().getPREPAYMENTPENALTY().getPREPAYMENTPENALTYLIFETIMERULE().getPrepaymentPenaltyExpirationMonthsCount())
				prepaymentPenaltyExpirationMonthsCount = Integer.toString(deal.getLOANS().getLOAN().getPREPAYMENTPENALTY().getPREPAYMENTPENALTYLIFETIMERULE().getPrepaymentPenaltyExpirationMonthsCount().getValue());
			if(null != deal.getLOANS().getLOAN().getPREPAYMENTPENALTY().getPREPAYMENTPENALTYLIFETIMERULE().getPrepaymentPenaltyMaximumLifeOfLoanAmount())
				prepaymentPenaltyMaximumLifeOfLoanAmount = deal.getLOANS().getLOAN().getPREPAYMENTPENALTY().getPREPAYMENTPENALTYLIFETIMERULE().getPrepaymentPenaltyMaximumLifeOfLoanAmount().getValue().toPlainString();
		}
		
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
		LOAN loan = document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN();
		String escrowIndicator = "";
		String feeType = "EscrowWaiverFee";
		String feeActualPaymentAmount = "";//nf
		String integratedDisclosureSectionType = "InitialEscrowPaymentAtClosing";
		String escrowItemType = "";
		String displayLabelText = "";
		String feePaidToType = "";
		String typeOtherDescription = "";
		String escrowItemPaymentPaidByType = "";
		String escrowItemActualPaymentAmount = "";
		
		if(null != loan.getESCROW() && null != loan.getESCROW().getESCROWITEMS() && null != loan.getESCROW().getESCROWITEMS().getESCROWITEM())
		{
			escrowIndicator = "YES";
			List<ESCROWITEM> escrowitems = loan.getESCROW().getESCROWITEMS().getESCROWITEM();
			for(ESCROWITEM escrowitem: escrowitems)
			{
				if(null != escrowitem.getESCROWITEMDETAIL().getEscrowItemType() && integratedDisclosureSectionType.equalsIgnoreCase(escrowitem.getESCROWITEMDETAIL().getEscrowItemType().getValue().value()))
				{
					EscrowsModel escrowsModel = Convertor.getEscrowModel(escrowitem);
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
			}
		}
		else
		{
			escrowIndicator = "NO";
			List<FEE> fees = loan.getFEEINFORMATION().getFEES().getFEE();
			for(FEE fee : fees)
			{
				if(null != fee.getFEEDETAIL().getFeeType().getValue() && "EscrowWaiverFee".equalsIgnoreCase(fee.getFEEDETAIL().getFeeType().getValue().value()))
				{
					FeeModel feeModel = Convertor.getFeeModel(fee);
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
		return loanTermsIntialEscrow;
		
	}
	
	public static List<LoanTermsETIA> populateLoanTermsETIA(DOCUMENT document)
	{
		
		List<LoanTermsETIA>  loanTermsETIAs = new LinkedList<>();
		LOAN loan = document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN();
		
		List<ESTIMATEDPROPERTYCOSTCOMPONENT> estimatedpropertycostcomponents = loan.getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getESTIMATEDPROPERTYCOST().getESTIMATEDPROPERTYCOSTCOMPONENTS().getESTIMATEDPROPERTYCOSTCOMPONENT();
		
		for(ESTIMATEDPROPERTYCOSTCOMPONENT estimatedpropertycostcomponent : estimatedpropertycostcomponents)
		{
			if(null != estimatedpropertycostcomponent)
			{
				LoanTermsETIA  loanTermsETIA = new LoanTermsETIA();
				if(null != estimatedpropertycostcomponent.getProjectedPaymentEscrowedType())
					loanTermsETIA.setProjectedPaymentEscrowedType(estimatedpropertycostcomponent.getProjectedPaymentEscrowedType().getValue().value());
				if(null != estimatedpropertycostcomponent.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType())
					loanTermsETIA.setProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType(estimatedpropertycostcomponent.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType().getValue().value());
				if(null != estimatedpropertycostcomponent.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription())
					loanTermsETIA.setProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription(estimatedpropertycostcomponent.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription().getValue());
				loanTermsETIAs.add(loanTermsETIA);
			}
		}
		return loanTermsETIAs;
		
	}
	
	public static LoanTermsEscrowAccount populateLoanTermsEscrowAccount(DOCUMENT document)
	{
		LoanTermsEscrowAccount  loanTermsEscrowAccount = new LoanTermsEscrowAccount();
		LOAN loan = document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN();
		String firstYearTotalNonEscrowPaymentDescription = "";
		String firstYearTotalNonEscrowPaymentAmount = "";
		
		if(null != loan.getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL())
		{
			if(null != loan.getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getFirstYearTotalNonEscrowPaymentAmount())
				firstYearTotalNonEscrowPaymentAmount = loan.getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getFirstYearTotalNonEscrowPaymentAmount().getValue().toPlainString();
			if(null != loan.getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getFirstYearTotalNonEscrowPaymentDescription())
				firstYearTotalNonEscrowPaymentDescription = loan.getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getFirstYearTotalNonEscrowPaymentDescription().getValue();
		}
		
		loanTermsEscrowAccount.setFirstYearTotalNonEscrowPaymentDescription(firstYearTotalNonEscrowPaymentDescription);
		loanTermsEscrowAccount.setFirstYearTotalNonEscrowPaymentAmount(firstYearTotalNonEscrowPaymentAmount);
		return loanTermsEscrowAccount;
		
	}
}
