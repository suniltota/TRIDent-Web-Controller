package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class ClosingCostFundModel implements Serializable {

	private static final long serialVersionUID = 1672245049297531156L;
	
	private String closingCostFundAmount;
	private String fundsType;
	private String integratedDisclosureSectionType;
	
	public String getClosingCostFundAmount() {
		return closingCostFundAmount;
	}
	public void setClosingCostFundAmount(String closingCostFundAmount) {
		this.closingCostFundAmount = closingCostFundAmount;
	}
	public String getFundsType() {
		return fundsType;
	}
	public void setFundsType(String fundsType) {
		this.fundsType = fundsType;
	}
	public String getIntegratedDisclosureSectionType() {
		return integratedDisclosureSectionType;
	}
	public void setIntegratedDisclosureSectionType(String integratedDisclosureSectionType) {
		this.integratedDisclosureSectionType = integratedDisclosureSectionType;
	}
	
}
