package com.actualize.mortgage.utils;

import java.util.LinkedList;
import java.util.List;

import org.mismo.residential._2009.schemas.DEAL;
import org.mismo.residential._2009.schemas.DOCUMENT;
import org.mismo.residential._2009.schemas.LIABILITY;
import org.mismo.residential._2009.schemas.LOANIDENTIFIER;
import org.mismo.residential._2009.schemas.MESSAGE;

/**
 * @author bkollepara
 *
 */
public class DocumentType {
	
	private String loanType;
	private boolean standardView;
	private boolean alternateView;
	private boolean payoffsAndPayments;
	private boolean refinanceTypeLoan;
	private boolean homeEquityLoanIndicator;
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
		List<LIABILITY> liabilityList = new LinkedList<>();
		
		if(null != document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLIABILITIES())
			liabilityList = document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLIABILITIES().getLIABILITY(); 
		//List<CASHTOCLOSEITEM> cashList = 
		
		if (isStandardView(document))
			return false;
		
		// Check payoffs and payment
		boolean isPayoffsAndPayments = false;
		for(LIABILITY liability:liabilityList) {
			//if(("PayoffsAndPayments").equalsIgnoreCase()) {
			//	isPayoffsAndPayments = true;
			//	break;
			System.out.println(liability.getLIABILITYDETAIL().getEXTENSION().getOTHER().getIntegratedDisclosureSectionType());
			//}
		}
		/*for (CashToClose cashToClose:cashList) {
			if (cashToClose.getItemType().equalsIgnoreCase("TotalPayoffsAndPayments")) {
				isPayoffsAndPayments = true;
				break;
			}
		}*/

		// Check if refi
		boolean isRefinanceTypeLoan = false;
		if (("Refinance").equalsIgnoreCase(deal.getLOANS().getLOAN().getTERMSOFLOAN().getLoanPurposeType().getValue().value()))
			isRefinanceTypeLoan = true;

		// Check if home equity
		boolean isHomeEquityLoanIndicator = false;
		if (deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getIntegratedDisclosureHomeEquityLoanIndicator().isValue()) {
			isHomeEquityLoanIndicator = true;
		}

		// Return alternate view
		if (isPayoffsAndPayments && (isRefinanceTypeLoan || isHomeEquityLoanIndicator)) 
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
		if (("Refinance").equalsIgnoreCase(document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getTERMSOFLOAN().getLoanPurposeType().getValue().value()))
			return true;
		return false;
	}
	
	public static boolean isHomeEquityLoanIndicator(DOCUMENT document)
	{
		if (document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getIntegratedDisclosureHomeEquityLoanIndicator().isValue())
			return  true;
		return false;
	}
	
	public static boolean isPayoffsAndPayments(DOCUMENT document)
	{
		return false;
	}
	
	public String getLoanType(DOCUMENT document)
	{
		return document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getTERMSOFLOAN().getLoanPurposeType().getValue().value();
	}

	/**
	 * @return the loanType
	 */
	public String getLoanType() {
		return loanType;
	}

	/**
	 * @param loanType the loanType to set
	 */
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	/**
	 * @return the standardView
	 */
	public boolean isStandardView() {
		return standardView;
	}

	/**
	 * @param standardView the standardView to set
	 */
	public void setStandardView(boolean standardView) {
		this.standardView = standardView;
	}

	/**
	 * @return the alternateView
	 */
	public boolean isAlternateView() {
		return alternateView;
	}

	/**
	 * @param alternateView the alternateView to set
	 */
	public void setAlternateView(boolean alternateView) {
		this.alternateView = alternateView;
	}

	/**
	 * @return the payoffsAndPayments
	 */
	public boolean isPayoffsAndPayments() {
		return payoffsAndPayments;
	}

	/**
	 * @param payoffsAndPayments the payoffsAndPayments to set
	 */
	public void setPayoffsAndPayments(boolean payoffsAndPayments) {
		this.payoffsAndPayments = payoffsAndPayments;
	}

	/**
	 * @return the refinanceTypeLoan
	 */
	public boolean isRefinanceTypeLoan() {
		return refinanceTypeLoan;
	}

	/**
	 * @param refinanceTypeLoan the refinanceTypeLoan to set
	 */
	public void setRefinanceTypeLoan(boolean refinanceTypeLoan) {
		this.refinanceTypeLoan = refinanceTypeLoan;
	}

	/**
	 * @return the homeEquityLoanIndicator
	 */
	public boolean isHomeEquityLoanIndicator() {
		return homeEquityLoanIndicator;
	}

	/**
	 * @param homeEquityLoanIndicator the homeEquityLoanIndicator to set
	 */
	public void setHomeEquityLoanIndicator(boolean homeEquityLoanIndicator) {
		this.homeEquityLoanIndicator = homeEquityLoanIndicator;
	}

	/**
	 * @return the sellerOnly
	 */
	public boolean isSellerOnly() {
		return sellerOnly;
	}

	/**
	 * @param sellerOnly the sellerOnly to set
	 */
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