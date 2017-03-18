package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class LoanTermsIntialEscrow implements Serializable {
	
	private static final long serialVersionUID = -7632316299361622429L;
	
	private String escrowIndicator = "";
	private String feeType = "";
	private String feeActualPaymentAmount = "";
	private String integratedDisclosureSectionType = "";
	private String escrowItemType = "";
	private String displayLabelText = "";
	private String feePaidToType = "";
	private String typeOtherDescription = "";
	private String escrowItemPaymentPaidByType = "";
	private String escrowItemActualPaymentAmount = "";
	
	public String getEscrowIndicator() {
		return escrowIndicator;
	}
	public void setEscrowIndicator(String escrowIndicator) {
		this.escrowIndicator = escrowIndicator;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public String getFeeActualPaymentAmount() {
		return feeActualPaymentAmount;
	}
	public void setFeeActualPaymentAmount(String feeActualPaymentAmount) {
		this.feeActualPaymentAmount = feeActualPaymentAmount;
	}
	public String getIntegratedDisclosureSectionType() {
		return integratedDisclosureSectionType;
	}
	public void setIntegratedDisclosureSectionType(String integratedDisclosureSectionType) {
		this.integratedDisclosureSectionType = integratedDisclosureSectionType;
	}
	public String getEscrowItemType() {
		return escrowItemType;
	}
	public void setEscrowItemType(String escrowItemType) {
		this.escrowItemType = escrowItemType;
	}
	public String getDisplayLabelText() {
		return displayLabelText;
	}
	public void setDisplayLabelText(String displayLabelText) {
		this.displayLabelText = displayLabelText;
	}
	public String getFeePaidToType() {
		return feePaidToType;
	}
	public void setFeePaidToType(String feePaidToType) {
		this.feePaidToType = feePaidToType;
	}
	public String getTypeOtherDescription() {
		return typeOtherDescription;
	}
	public void setTypeOtherDescription(String typeOtherDescription) {
		this.typeOtherDescription = typeOtherDescription;
	}
	public String getEscrowItemPaymentPaidByType() {
		return escrowItemPaymentPaidByType;
	}
	public void setEscrowItemPaymentPaidByType(String escrowItemPaymentPaidByType) {
		this.escrowItemPaymentPaidByType = escrowItemPaymentPaidByType;
	}
	public String getEscrowItemActualPaymentAmount() {
		return escrowItemActualPaymentAmount;
	}
	public void setEscrowItemActualPaymentAmount(String escrowItemActualPaymentAmount) {
		this.escrowItemActualPaymentAmount = escrowItemActualPaymentAmount;
	}
	
	

}
