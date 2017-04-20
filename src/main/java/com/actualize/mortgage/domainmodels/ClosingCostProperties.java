package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
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
	private String feeActualTotalAmount;
	private String feePaidToType;
	private String feePaidToTypeOtherDescription;
	private String feePercentBasisType;
	private String feeTotalPercent;
	private String feeType;
	private String feeTypeOtherDescription;
	private String integratedDisclosureSectionType;
	private String optionalCostIndicator;
	private String regulationZPointsAndFeesIndicator;
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
	public String getOptionalCostIndicator() {
		return optionalCostIndicator;
	}
	/**
	 * @param optionalCostIndicator the optionalCostIndicator to set
	 */
	public void setOptionalCostIndicator(String optionalCostIndicator) {
		this.optionalCostIndicator = optionalCostIndicator;
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
