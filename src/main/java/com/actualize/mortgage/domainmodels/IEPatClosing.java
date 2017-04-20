package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * 
 * @author sboragala
 *
 */
public class IEPatClosing implements Serializable{

	private static final long serialVersionUID = -5396028708375185601L;
	
	private String displayLabel;
	private String gseDisplayLabel;
	private String escrowCollectedNumberOfMonthsCount;
	private String escrowItemType;
	private String escrowItemTypeOtherDescription;
	private String escrowMonthlyPaymentAmount;
	private String feePaidToType;
	private String feePaidToTypeOtherDescription;
	private String integratedDisclosureSectionType;
	private String regulationZPointsAndFeesIndicator;
	private String paymentIncludedInAPRIndicator;
	private String bpAtClosing;
	private String bpB4Closing;
	private String spAtClosing;
	private String spB4Closing;
	private String paidByOthers;
	private String lenderStatus;
	
	/**
	 * @return the displayLabel
	 */
	public String getDisplayLabel() {
		return displayLabel;
	}
	/**
	 * @param displayLabel the displayLabel to set
	 */
	public void setDisplayLabel(String displayLabel) {
		this.displayLabel = displayLabel;
	}
	/**
	 * @return the gseDisplayLabel
	 */
	public String getGseDisplayLabel() {
		return gseDisplayLabel;
	}
	/**
	 * @param gseDisplayLabel the gseDisplayLabel to set
	 */
	public void setGseDisplayLabel(String gseDisplayLabel) {
		this.gseDisplayLabel = gseDisplayLabel;
	}
	/**
	 * @return the escrowCollectedNumberOfMonthsCount
	 */
	public String getEscrowCollectedNumberOfMonthsCount() {
		return escrowCollectedNumberOfMonthsCount;
	}
	/**
	 * @param escrowCollectedNumberOfMonthsCount the escrowCollectedNumberOfMonthsCount to set
	 */
	public void setEscrowCollectedNumberOfMonthsCount(String escrowCollectedNumberOfMonthsCount) {
		this.escrowCollectedNumberOfMonthsCount = escrowCollectedNumberOfMonthsCount;
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
	 * @return the escrowItemTypeOtherDescription
	 */
	public String getEscrowItemTypeOtherDescription() {
		return escrowItemTypeOtherDescription;
	}
	/**
	 * @param escrowItemTypeOtherDescription the escrowItemTypeOtherDescription to set
	 */
	public void setEscrowItemTypeOtherDescription(String escrowItemTypeOtherDescription) {
		this.escrowItemTypeOtherDescription = escrowItemTypeOtherDescription;
	}
	/**
	 * @return the escrowMonthlyPaymentAmount
	 */
	public String getEscrowMonthlyPaymentAmount() {
		return escrowMonthlyPaymentAmount;
	}
	/**
	 * @param escrowMonthlyPaymentAmount the escrowMonthlyPaymentAmount to set
	 */
	public void setEscrowMonthlyPaymentAmount(String escrowMonthlyPaymentAmount) {
		this.escrowMonthlyPaymentAmount = escrowMonthlyPaymentAmount;
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
	 * @return the feePaidToTypeOtherDescription
	 */
	public String getFeePaidToTypeOtherDescription() {
		return feePaidToTypeOtherDescription;
	}
	/**
	 * @param feePaidToTypeOtherDescription the feePaidToTypeOtherDescription to set
	 */
	public void setFeePaidToTypeOtherDescription(String feePaidToTypeOtherDescription) {
		this.feePaidToTypeOtherDescription = feePaidToTypeOtherDescription;
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
	 * @return the regulationZPointsAndFeesIndicator
	 */
	public String getRegulationZPointsAndFeesIndicator() {
		return regulationZPointsAndFeesIndicator;
	}
	/**
	 * @param regulationZPointsAndFeesIndicator the regulationZPointsAndFeesIndicator to set
	 */
	public void setRegulationZPointsAndFeesIndicator(String regulationZPointsAndFeesIndicator) {
		this.regulationZPointsAndFeesIndicator = regulationZPointsAndFeesIndicator;
	}
	/**
	 * @return the paymentIncludedInAPRIndicator
	 */
	public String getPaymentIncludedInAPRIndicator() {
		return paymentIncludedInAPRIndicator;
	}
	/**
	 * @param paymentIncludedInAPRIndicator the paymentIncludedInAPRIndicator to set
	 */
	public void setPaymentIncludedInAPRIndicator(String paymentIncludedInAPRIndicator) {
		this.paymentIncludedInAPRIndicator = paymentIncludedInAPRIndicator;
	}
	/**
	 * @return the bpAtClosing
	 */
	public String getBpAtClosing() {
		return bpAtClosing;
	}
	/**
	 * @param bpAtClosing the bpAtClosing to set
	 */
	public void setBpAtClosing(String bpAtClosing) {
		this.bpAtClosing = bpAtClosing;
	}
	/**
	 * @return the bpB4Closing
	 */
	public String getBpB4Closing() {
		return bpB4Closing;
	}
	/**
	 * @param bpB4Closing the bpB4Closing to set
	 */
	public void setBpB4Closing(String bpB4Closing) {
		this.bpB4Closing = bpB4Closing;
	}
	/**
	 * @return the spAtClosing
	 */
	public String getSpAtClosing() {
		return spAtClosing;
	}
	/**
	 * @param spAtClosing the spAtClosing to set
	 */
	public void setSpAtClosing(String spAtClosing) {
		this.spAtClosing = spAtClosing;
	}
	/**
	 * @return the spB4Closing
	 */
	public String getSpB4Closing() {
		return spB4Closing;
	}
	/**
	 * @param spB4Closing the spB4Closing to set
	 */
	public void setSpB4Closing(String spB4Closing) {
		this.spB4Closing = spB4Closing;
	}
	/**
	 * @return the paidByOthers
	 */
	public String getPaidByOthers() {
		return paidByOthers;
	}
	/**
	 * @param paidByOthers the paidByOthers to set
	 */
	public void setPaidByOthers(String paidByOthers) {
		this.paidByOthers = paidByOthers;
	}
	/**
	 * @return the lenderStatus
	 */
	public String getLenderStatus() {
		return lenderStatus;
	}
	/**
	 * @param lenderStatus the lenderStatus to set
	 */
	public void setLenderStatus(String lenderStatus) {
		this.lenderStatus = lenderStatus;
	}
	
	
	
}
