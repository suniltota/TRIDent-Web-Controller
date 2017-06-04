package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
/**
 * Defines ClosingCostProperties for UI Response
 * @author sboragala
 *
 */
public class ClosingCostProperties extends PaymentsModel implements Serializable {
		
	private static final long serialVersionUID = 943579811603225142L;
	
	private String displayLabel;
	private String feePaidToFullName;
	private String feeActualTotalAmount;
	private String feePaidToType;
	private String feePaidToTypeOtherDescription;
	private String feePercentBasisType;
	private String feeTotalPercent;
	private String feeType;
	private String feeTypeOtherDescription;
	private String integratedDisclosureSectionType;
	private boolean optionalCostIndicator;
	private boolean regulationZPointsAndFeesIndicator;
	private boolean paymentIncludedInAPRIndicator;
	
	
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
	 * @return the feePaidToFullName
	 */
	public String getFeePaidToFullName() {
		return feePaidToFullName;
	}
	/**
	 * @param feePaidToFullName the feePaidToFullName to set
	 */
	public void setFeePaidToFullName(String feePaidToFullName) {
		this.feePaidToFullName = feePaidToFullName;
	}
	/**
	 * @return the feeActualTotalAmount
	 */
	public String getFeeActualTotalAmount() {
		return feeActualTotalAmount;
	}
	/**
	 * @param feeActualTotalAmount the feeActualTotalAmount to set
	 */
	public void setFeeActualTotalAmount(String feeActualTotalAmount) {
		this.feeActualTotalAmount = feeActualTotalAmount;
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
	 * @return the feePercentBasisType
	 */
	public String getFeePercentBasisType() {
		return feePercentBasisType;
	}
	/**
	 * @param feePercentBasisType the feePercentBasisType to set
	 */
	public void setFeePercentBasisType(String feePercentBasisType) {
		this.feePercentBasisType = feePercentBasisType;
	}
	/**
	 * @return the feeTotalPercent
	 */
	public String getFeeTotalPercent() {
		return feeTotalPercent;
	}
	/**
	 * @param feeTotalPercent the feeTotalPercent to set
	 */
	public void setFeeTotalPercent(String feeTotalPercent) {
		this.feeTotalPercent = feeTotalPercent;
	}
	/**
	 * @return the feeType
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
	 * @return the feeTypeOtherDescription
	 */
	public String getFeeTypeOtherDescription() {
		return feeTypeOtherDescription;
	}
	/**
	 * @param feeTypeOtherDescription the feeTypeOtherDescription to set
	 */
	public void setFeeTypeOtherDescription(String feeTypeOtherDescription) {
		this.feeTypeOtherDescription = feeTypeOtherDescription;
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
	 * @return the optionalCostIndicator
	 */
	public boolean isOptionalCostIndicator() {
		return optionalCostIndicator;
	}
	/**
	 * @param optionalCostIndicator the optionalCostIndicator to set
	 */
	public void setOptionalCostIndicator(boolean optionalCostIndicator) {
		this.optionalCostIndicator = optionalCostIndicator;
	}
	/**
	 * @return the regulationZPointsAndFeesIndicator
	 */
	public boolean isRegulationZPointsAndFeesIndicator() {
		return regulationZPointsAndFeesIndicator;
	}
	/**
	 * @param regulationZPointsAndFeesIndicator the regulationZPointsAndFeesIndicator to set
	 */
	public void setRegulationZPointsAndFeesIndicator(boolean regulationZPointsAndFeesIndicator) {
		this.regulationZPointsAndFeesIndicator = regulationZPointsAndFeesIndicator;
	}
	/**
	 * @return the paymentIncludedInAPRIndicator
	 */
	public boolean isPaymentIncludedInAPRIndicator() {
		return paymentIncludedInAPRIndicator;
	}
	/**
	 * @param paymentIncludedInAPRIndicator the paymentIncludedInAPRIndicator to set
	 */
	public void setPaymentIncludedInAPRIndicator(boolean paymentIncludedInAPRIndicator) {
		this.paymentIncludedInAPRIndicator = paymentIncludedInAPRIndicator;
	}
	
}
