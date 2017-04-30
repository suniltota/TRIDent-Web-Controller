package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;
/**
 * Defines ClosingCostProperties for UI Response
 * @author sboragala
 *
 */
public class ClosingCostProperties implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 943579811603225142L;
	
	private String displayLabel;
	private String gseDisplayLabel;
	private String feePaidTo;
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
	private List<FeePaymentsModel> feePayments;
	
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
	 * @return the feePaidTo
	 */
	public String getFeePaidTo() {
		return feePaidTo;
	}
	/**
	 * @param feePaidTo the feePaidTo to set
	 */
	public void setFeePaidTo(String feePaidTo) {
		this.feePaidTo = feePaidTo;
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
	/**
	 * @return the feePayments
	 */
	public List<FeePaymentsModel> getFeePayments() {
		return feePayments;
	}
	/**
	 * @param feePayments the feePayments to set
	 */
	public void setFeePayments(List<FeePaymentsModel> feePayments) {
		this.feePayments = feePayments;
	}
	
	
	
}
