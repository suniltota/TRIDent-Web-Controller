package com.actualize.mortgage.utils;

import java.util.List;

import org.mismo.residential._2009.schemas.DEAL;
import org.mismo.residential._2009.schemas.DOCUMENT;
import org.mismo.residential._2009.schemas.LOANIDENTIFIER;
import org.mismo.residential._2009.schemas.MESSAGE;

import com.actualize.mortgage.domainmodels.CashToCloseModel;
import com.actualize.mortgage.domainmodels.LiabilitiesModel;

public class DocumentType {
	
	private String loanType;
	private boolean standardView;
	private boolean alternateView;
	private static boolean payoffsAndPayments = false;
	private boolean refinanceTypeLoan;
	private static boolean homeEquityLoanIndicator;
	private boolean sellerOnly;
	private static String aboutVersionIdentifier;
	private String loanId;
	
	public static boolean isStandardView(DOCUMENT document)
	{
		if("Other".equalsIgnoreCase(document.getDOCUMENTCLASSIFICATION().getDOCUMENTCLASSES().getDOCUMENTCLASS().getDocumentType().getValue().value()) && "ClosingDisclosure:ModelForm".equalsIgnoreCase(document.getDOCUMENTCLASSIFICATION().getDOCUMENTCLASSES().getDOCUMENTCLASS().getDocumentTypeOtherDescription().getValue().value()))
			return true;
		if("Other".equalsIgnoreCase(document.getDOCUMENTCLASSIFICATION().getDOCUMENTCLASSES().getDOCUMENTCLASS().getDocumentType().getValue().value()) && "ClosingDisclosure:Standard".equalsIgnoreCase(document.getDOCUMENTCLASSIFICATION().getDOCUMENTCLASSES().getDOCUMENTCLASS().getDocumentTypeOtherDescription().getValue().value()))
			return true;
		return false;
	}
	
	public static boolean isAlternateView(DOCUMENT document) {
		
		DEAL deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		
		List<CashToCloseModel> cashToCloseModels = PopulateData.populateCashToCloseModel(document);
		List<LiabilitiesModel> liabilitiesModels = PopulateData.populateLiabilitiesModel(document);
		if (isStandardView(document))
			return false;
		
		// Check payoffs and payment
		boolean isPayoffsAndPayments = false;
		for(LiabilitiesModel liability:liabilitiesModels) {
			if(("PayoffsAndPayments").equalsIgnoreCase(liability.getIDSection())) {
				isPayoffsAndPayments = true;
				break;
			}
		}
		for (CashToCloseModel cashToCloseModel : cashToCloseModels) {
			if (cashToCloseModel.getItemType().equalsIgnoreCase("TotalPayoffsAndPayments")) {
				isPayoffsAndPayments = true;
				break;
			}
		}

		// Check if refi
		boolean isRefinanceTypeLoan = false;
		if (null != deal.getLOANS().getLOAN().getTERMSOFLOAN() &&
			null != deal.getLOANS().getLOAN().getTERMSOFLOAN().getLoanPurposeType() && 
			("Refinance").equalsIgnoreCase(deal.getLOANS().getLOAN().getTERMSOFLOAN().getLoanPurposeType().getValue().value()))
			isRefinanceTypeLoan = true;

		// Check if home equity
		if (null != document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS() && null != document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET() && null!= document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE() && null != document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL() && null != document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getIntegratedDisclosureHomeEquityLoanIndicator() && document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getIntegratedDisclosureHomeEquityLoanIndicator().isValue()){
			homeEquityLoanIndicator = true;
		}

		if(isPayoffsAndPayments)
			payoffsAndPayments = true;
		// Return alternate view
		if (isPayoffsAndPayments && (isRefinanceTypeLoan || homeEquityLoanIndicator)) 
			return true;
		
		return false;
	}
	
	public static boolean isSellerOnly(DOCUMENT document){
		if ("Other".equals(document.getDOCUMENTCLASSIFICATION().getDOCUMENTCLASSES().getDOCUMENTCLASS().getDocumentType().getValue().value())
			&& "ClosingDisclosure:SellerOnly".equals(document.getDOCUMENTCLASSIFICATION().getDOCUMENTCLASSES().getDOCUMENTCLASS().getDocumentTypeOtherDescription().getValue().value()))
			return true;
		return false;
	}
	
	public static boolean isRefinanceTypeLoan(DOCUMENT document)
	{
		if (null != document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getTERMSOFLOAN() &&
			null != document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getTERMSOFLOAN().getLoanPurposeType() &&
				("Refinance").equalsIgnoreCase(document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getTERMSOFLOAN().getLoanPurposeType().getValue().value()))
			return true;
		return false;
	}
	
	public static boolean HomeEquityLoanIndicator()
	{
		return  homeEquityLoanIndicator;
	}
	
	public static boolean PayoffsAndPayments()
	{
		return payoffsAndPayments;
	}
	
	public String getLoanType(DOCUMENT document)
	{
		if(null != document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN() && null != document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getTERMSOFLOAN() && null != document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getTERMSOFLOAN().getLoanPurposeType())
			return document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getTERMSOFLOAN().getLoanPurposeType().getValue().value();
		return "";
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public boolean isStandardView() {
		return standardView;
	}

	public void setStandardView(boolean standardView) {
		this.standardView = standardView;
	}

	public boolean isAlternateView() {
		return alternateView;
	}

	public void setAlternateView(boolean alternateView) {
		this.alternateView = alternateView;
	}

	public boolean isPayoffsAndPayments() {
		return payoffsAndPayments;
	}

	public void setPayoffsAndPayments(boolean payoffsAndPayments) {
		this.payoffsAndPayments = payoffsAndPayments;
	}

	public boolean isRefinanceTypeLoan() {
		return refinanceTypeLoan;
	}

	public void setRefinanceTypeLoan(boolean refinanceTypeLoan) {
		this.refinanceTypeLoan = refinanceTypeLoan;
	}

	public boolean isHomeEquityLoanIndicator() {
		return homeEquityLoanIndicator;
	}
	
	public void setHomeEquityLoanIndicator(boolean homeEquityLoanIndicator) {
		this.homeEquityLoanIndicator = homeEquityLoanIndicator;
	}
	
	public boolean isSellerOnly() {
		return sellerOnly;
	}

	public void setSellerOnly(boolean sellerOnly) {
		this.sellerOnly = sellerOnly;
	}

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
    
	public String getLoanIdentifier(DOCUMENT document){
		String loanId = "";
		List<LOANIDENTIFIER> loanidentifiers = document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getLOANIDENTIFIERS().getLOANIDENTIFIER();
		for(LOANIDENTIFIER loanidentifier : loanidentifiers){
			if("LenderLoan".equalsIgnoreCase(loanidentifier.getLoanIdentifierType().getValue().value()))
				loanId = loanidentifier.getLoanIdentifier().getValue();
		}
		return loanId;
	}
	
	public static String getAboutVersionIdentifier(MESSAGE message)
	{
		return (null != message.getABOUTVERSIONS() && null != message.getABOUTVERSIONS().getABOUTVERSION() && null != message.getABOUTVERSIONS().getABOUTVERSION().getAboutVersionIdentifier())? message.getABOUTVERSIONS().getABOUTVERSION().getAboutVersionIdentifier().getValue() : "";
	}

	public static String getAboutVersionIdentifier() {
		return aboutVersionIdentifier;
	}

	public static void setAboutVersionIdentifier(String VersionIdentifier) {
		aboutVersionIdentifier = VersionIdentifier;
	}

}