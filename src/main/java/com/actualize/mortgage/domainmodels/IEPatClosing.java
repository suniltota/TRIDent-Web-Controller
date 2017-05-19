package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines escrow elements in JSON Object
 * @author sboragala
 *
 */
public class IEPatClosing extends PaymentsModel implements Serializable{

	private static final long serialVersionUID = -1627061167861563038L;
	private String displayLabel;
	private String escrowCollectedNumberOfMonthsCount;
	private String escrowItemType;
	private String escrowItemTypeOtherDescription;
	private String escrowMonthlyPaymentAmount;
	private String feePaidToType;
	private String feePaidToTypeOtherDescription;
	private String integratedDisclosureSectionType;
	private String regulationZPointsAndFeesIndicator;
	private String paymentIncludedInAPRIndicator;
	
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
	
}
