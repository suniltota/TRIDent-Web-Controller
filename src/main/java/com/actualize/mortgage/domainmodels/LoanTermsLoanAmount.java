package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
/**
 * Represents LoanAmount of LoanTerms in JSON Response
 * @author sboragala
 *
 */
public class LoanTermsLoanAmount implements	Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4527019703978052244L;
	
	private String noteAmount;
	private boolean negativeAmoritzationIndicator;
	private String negativeAmortizationMaximumLoanBalanceAmount;
	private String negativeAmortizationLimitMonthsCount;
	
	/**
	 * @return the noteAmount
	 */
	public String getNoteAmount() {
		return noteAmount;
	}
	/**
	 * @param noteAmount the noteAmount to set
	 */
	public void setNoteAmount(String noteAmount) {
		this.noteAmount = noteAmount;
	}
	/**
	 * @return the negativeAmortizationMaximumLoanBalanceAmount
	 */
	public String getNegativeAmortizationMaximumLoanBalanceAmount() {
		return negativeAmortizationMaximumLoanBalanceAmount;
	}
	/**
	 * @param negativeAmortizationMaximumLoanBalanceAmount the negativeAmortizationMaximumLoanBalanceAmount to set
	 */
	public void setNegativeAmortizationMaximumLoanBalanceAmount(String negativeAmortizationMaximumLoanBalanceAmount) {
		this.negativeAmortizationMaximumLoanBalanceAmount = negativeAmortizationMaximumLoanBalanceAmount;
	}
	/**
	 * @return the negativeAmortizationLimitMonthsCount
	 */
	public String getNegativeAmortizationLimitMonthsCount() {
		return negativeAmortizationLimitMonthsCount;
	}
	/**
	 * @param negativeAmortizationLimitMonthsCount the negativeAmortizationLimitMonthsCount to set
	 */
	public void setNegativeAmortizationLimitMonthsCount(String negativeAmortizationLimitMonthsCount) {
		this.negativeAmortizationLimitMonthsCount = negativeAmortizationLimitMonthsCount;
	}
	/**
	 * @return the negativeAmoritzationIndicator
	 */
	public boolean isNegativeAmoritzationIndicator() {
		return negativeAmoritzationIndicator;
	}
	/**
	 * @param negativeAmoritzationIndicator the negativeAmoritzationIndicator to set
	 */
	public void setNegativeAmoritzationIndicator(boolean negativeAmoritzationIndicator) {
		this.negativeAmoritzationIndicator = negativeAmoritzationIndicator;
	}
	
}
