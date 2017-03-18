package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClosingCostDetails implements Serializable {
	
	
	private static final long serialVersionUID = -7409412092150931776L;
	
	@JsonProperty("LoanCosts")
	private ClosingCostDetailsLoanCosts closingCostDetailsLoanCosts;
	@JsonProperty("OtherCosts")
	private ClosingCostDetailsOtherCosts closingCostDetailsOtherCosts;
	/**
	 * @return the closingCostDetailsLoanCosts
	 */
	public ClosingCostDetailsLoanCosts getClosingCostDetailsLoanCosts() {
		return closingCostDetailsLoanCosts;
	}
	/**
	 * @param closingCostDetailsLoanCosts the closingCostDetailsLoanCosts to set
	 */
	public void setClosingCostDetailsLoanCosts(ClosingCostDetailsLoanCosts closingCostDetailsLoanCosts) {
		this.closingCostDetailsLoanCosts = closingCostDetailsLoanCosts;
	}
	/**
	 * @return the closingCostDetailsOtherCosts
	 */
	public ClosingCostDetailsOtherCosts getClosingCostDetailsOtherCosts() {
		return closingCostDetailsOtherCosts;
	}
	/**
	 * @param closingCostDetailsOtherCosts the closingCostDetailsOtherCosts to set
	 */
	public void setClosingCostDetailsOtherCosts(ClosingCostDetailsOtherCosts closingCostDetailsOtherCosts) {
		this.closingCostDetailsOtherCosts = closingCostDetailsOtherCosts;
	}
	
			
}
