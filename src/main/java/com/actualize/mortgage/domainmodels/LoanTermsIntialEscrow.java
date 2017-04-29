package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
/**
 *  Defines IntialEscrow of Loan '
 * @author sboragala
 *
 */
public class LoanTermsIntialEscrow implements Serializable {
	
	private static final long serialVersionUID = -7632316299361622429L;
	
	private boolean escrowIndicator ;
	private String feeType ;
	private String feeActualPaymentAmount ;
	private String integratedDisclosureSectionType ;
	private String escrowItemType ;
	private String displayLabelText ;
	private String feePaidToType ;
	private String typeOtherDescription ;
	private String escrowItemPaymentPaidByType ;
	private String escrowItemActualPaymentAmount ;
	
	/**
	 * @return the escrowIndicator
	 */
	public boolean isEscrowIndicator() {
		return escrowIndicator;
	}
	/**
	 * @param escrowIndicator the escrowIndicator to set
	 */
	public void setEscrowIndicator(boolean escrowIndicator) {
		this.escrowIndicator = escrowIndicator;
	}
	/**
	 * @return the feeTyp0
	 *; 
	 */
	public String getFeeType() {
		return feeType;
	}
	/**
	 * @param feeType the feeType to set
	 */
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	/**
	 * @return the feeActualPaymentAmount
	 */
	public String getFeeActualPaymentAmount() {
		return feeActualPaymentAmount;
	}
	/**
	 * @param feeActualPaymentAmount the feeActualPaymentAmount to set
	 */
	public void setFeeActualPaymentAmount(String feeActualPaymentAmount) {
		this.feeActualPaymentAmount = feeActualPaymentAmount;
	}
	/**
	 * @return the integratedDisclosureSectionType
	 */
	public String getIntegratedDisclosureSectionType() {
		return integratedDisclosureSectionType;
	}
	/**
	 * @param integratedDisclosureSectionType the integratedDisclosureSectionType to set
	 */
	public void setIntegratedDisclosureSectionType(String integratedDisclosureSectionType) {
		this.integratedDisclosureSectionType = integratedDisclosureSectionType;
	}
	/**
	 * @return the escrowItemType
	 */
	public String getEscrowItemType() {
		return escrowItemType;
	}
	/**
	 * @param escrowItemType the escrowItemType to set
	 */
	public void setEscrowItemType(String escrowItemType) {
		this.escrowItemType = escrowItemType;
	}
	/**
	 * @return the displayLabelText
	 */
	public String getDisplayLabelText() {
		return displayLabelText;
	}
	/**
	 * @param displayLabelText the displayLabelText to set
	 */
	public void setDisplayLabelText(String displayLabelText) {
		this.displayLabelText = displayLabelText;
	}
	/**
	 * @return the feePaidToType
	 */
	public String getFeePaidToType() {
		return feePaidToType;
	}
	/**
	 * @param feePaidToType the feePaidToType to set
	 */
	public void setFeePaidToType(String feePaidToType) {
		this.feePaidToType = feePaidToType;
	}
	/**
	 * @return the typeOtherDescription
	 */
	public String getTypeOtherDescription() {
		return typeOtherDescription;
	}
	/**
	 * @param typeOtherDescription the typeOtherDescription to set
	 */
	public void setTypeOtherDescription(String typeOtherDescription) {
		this.typeOtherDescription = typeOtherDescription;
	}
	/**
	 * @return the escrowItemPaymentPaidByType
	 */
	public String getEscrowItemPaymentPaidByType() {
		return escrowItemPaymentPaidByType;
	}
	/**
	 * @param escrowItemPaymentPaidByType the escrowItemPaymentPaidByType to set
	 */
	public void setEscrowItemPaymentPaidByType(String escrowItemPaymentPaidByType) {
		this.escrowItemPaymentPaidByType = escrowItemPaymentPaidByType;
	}
	/**
	 * @return the escrowItemActualPaymentAmount
	 */
	public String getEscrowItemActualPaymentAmount() {
		return escrowItemActualPaymentAmount;
	}
	/**
	 * @param escrowItemActualPaymentAmount the escrowItemActualPaymentAmount to set
	 */
	public void setEscrowItemActualPaymentAmount(String escrowItemActualPaymentAmount) {
		this.escrowItemActualPaymentAmount = escrowItemActualPaymentAmount;
	}
	
	
	
	

}
