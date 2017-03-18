package com.actualize.mortgage.utils;

import org.mismo.residential._2009.schemas.DEAL;
import org.mismo.residential._2009.schemas.DOCUMENT;

import com.actualize.mortgage.domainmodels.LoanInformation;
import com.actualize.mortgage.domainmodels.LoanTermsLoanAmount;

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
		 String adjustableRate = "";
		 String integratedDisclosureLoanProductDescription = "";
		 String mortgageType = "";
		 String mortgageTypeOtherDescription = "";
		 String loanIdentifierType = "";
		 String loanIdentifier = "";
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
		 
		 
		 loanInformation.setConstructionLoanType(constructionLoanType);
		 loanInformation.setConstructionPeriodNumberOfMonthsCount(constructionPeriodNumberOfMonthsCount);
		 loanInformation.setLoanMaturityPeriodType(loanMaturityPeriodType);
		 loanInformation.setLoanMaturityPeriodCount(loanMaturityPeriodCount);
		 loanInformation.setIntegratedDisclosureHomeEquityLoanIndicator(integratedDisclosureHomeEquityLoanIndicator);
		 loanInformation.setLienPriorityType(lienPriorityType);
		 loanInformation.setIntegratedDisclosureLoanProductDescription(integratedDisclosureLoanProductDescription);
		 loanInformation.setMortgageType(mortgageType);
		 loanInformation.setMortgageTypeOtherDescription(mortgageTypeOtherDescription);
		 loanInformation.setMiRequiredIndicator(miRequiredIndicator);
		 loanInformation.setMiCertificateIdentifier(miCertificateIdentifier);
		return loanInformation;
		
	}
	
	public static LoanTermsLoanAmount populateLoanTermsLoanAmount(DOCUMENT document)
	{
		LoanTermsLoanAmount loanTermsLoanAmount = new LoanTermsLoanAmount();
		DEAL deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		
		 String noteAmount = "";
		 String loanAmountIncreaseIndicator = "";
		 String negativeAmoritzationIndicator = "";
		 String negativeAmortizationMaximumLoanBalanceAmount = "";
		 String negativeAmortizationLimitMonthsCount = "";
		
		if(null != deal.getLOANS().getLOAN().getTERMSOFLOAN().getNoteAmount())
			noteAmount = deal.getLOANS().getLOAN().getTERMSOFLOAN().getNoteAmount().getValue().toPlainString();
		if(null != deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE() && null != deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE().getNegativeAmortizationMaximumLoanBalanceAmount())
			negativeAmortizationMaximumLoanBalanceAmount = deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE().getNegativeAmortizationMaximumLoanBalanceAmount().getValue().toPlainString();
		if(null != deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE() && null != deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE().getNegativeAmortizationLimitMonthsCount())
			negativeAmortizationLimitMonthsCount = Integer.toString(deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE().getNegativeAmortizationLimitMonthsCount().getValue());
		
		loanTermsLoanAmount.setAmount(noteAmount);
		loanTermsLoanAmount.setNegativeAmortizationMaximumLoanBalanceAmount(negativeAmortizationMaximumLoanBalanceAmount);
		loanTermsLoanAmount.setNegativeAmortizationLimitMonthsCount(negativeAmortizationLimitMonthsCount);
		return loanTermsLoanAmount;
	}
}
