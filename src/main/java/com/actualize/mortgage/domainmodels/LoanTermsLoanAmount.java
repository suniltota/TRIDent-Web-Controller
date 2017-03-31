package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class LoanTermsLoanAmount implements	Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4527019703978052244L;
	
	private String amount;
	private String status;
	private List<String> details;
	private String noteAmount;
	private String negativeAmoritzationIndicator;
	private String negativeAmortizationMaximumLoanBalanceAmount;
	private String negativeAmortizationLimitMonthsCount;
	
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
	public String getNoteAmount() {
		return noteAmount;
	}
	public void setNoteAmount(String noteAmount) {
		this.noteAmount = noteAmount;
	}
	public String getNegativeAmoritzationIndicator() {
		return negativeAmoritzationIndicator;
	}
	public void setNegativeAmoritzationIndicator(String negativeAmoritzationIndicator) {
		this.negativeAmoritzationIndicator = negativeAmoritzationIndicator;
	}
	public String getNegativeAmortizationMaximumLoanBalanceAmount() {
		return negativeAmortizationMaximumLoanBalanceAmount;
	}
	public void setNegativeAmortizationMaximumLoanBalanceAmount(String negativeAmortizationMaximumLoanBalanceAmount) {
		this.negativeAmortizationMaximumLoanBalanceAmount = negativeAmortizationMaximumLoanBalanceAmount;
	}
	public String getNegativeAmortizationLimitMonthsCount() {
		return negativeAmortizationLimitMonthsCount;
	}
	public void setNegativeAmortizationLimitMonthsCount(String negativeAmortizationLimitMonthsCount) {
		this.negativeAmortizationLimitMonthsCount = negativeAmortizationLimitMonthsCount;
	}

}
