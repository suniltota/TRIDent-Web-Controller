package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class ClosingCostFundModel implements Serializable {

	private static final long serialVersionUID = 1672245049297531156L;
	
	private String displayLabel;
	private String closingCostFundAmount;
	private String fundsType;
	private String integratedDisclosureSectionType;
	
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
	 * @return the closingCostFundAmount
	 */
	public String getClosingCostFundAmount() {
		return closingCostFundAmount;
	}
	/**
	 * @param closingCostFundAmount the closingCostFundAmount to set
	 */
	public void setClosingCostFundAmount(String closingCostFundAmount) {
		this.closingCostFundAmount = closingCostFundAmount;
	}
	/**
	 * @return the fundsType
	 */
	public String getFundsType() {
		return fundsType;
	}
	/**
	 * @param fundsType the fundsType to set
	 */
	public void setFundsType(String fundsType) {
		this.fundsType = fundsType;
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
	
	
	
	
}
