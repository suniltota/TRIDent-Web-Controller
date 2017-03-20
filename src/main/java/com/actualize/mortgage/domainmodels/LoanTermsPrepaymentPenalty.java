package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;



public class LoanTermsPrepaymentPenalty implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4614387411448264728L;
	
	private String amount;
	private String status;
	private List<String> details;
	private String prepaymentPenaltyIndicator;
	private String prepaymentPenaltyMaximumLifeOfLoanAmount;
	private String prepaymentPenaltyExpirationMonthsCount;
	
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the details
	 */
	public List<String> getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(List<String> details) {
		this.details = details;
	}
	public String getPrepaymentPenaltyIndicator() {
		return prepaymentPenaltyIndicator;
	}
	public void setPrepaymentPenaltyIndicator(String prepaymentPenaltyIndicator) {
		this.prepaymentPenaltyIndicator = prepaymentPenaltyIndicator;
	}
	public String getPrepaymentPenaltyMaximumLifeOfLoanAmount() {
		return prepaymentPenaltyMaximumLifeOfLoanAmount;
	}
	public void setPrepaymentPenaltyMaximumLifeOfLoanAmount(String prepaymentPenaltyMaximumLifeOfLoanAmount) {
		this.prepaymentPenaltyMaximumLifeOfLoanAmount = prepaymentPenaltyMaximumLifeOfLoanAmount;
	}
	public String getPrepaymentPenaltyExpirationMonthsCount() {
		return prepaymentPenaltyExpirationMonthsCount;
	}
	public void setPrepaymentPenaltyExpirationMonthsCount(String prepaymentPenaltyExpirationMonthsCount) {
		this.prepaymentPenaltyExpirationMonthsCount = prepaymentPenaltyExpirationMonthsCount;
	}

}
