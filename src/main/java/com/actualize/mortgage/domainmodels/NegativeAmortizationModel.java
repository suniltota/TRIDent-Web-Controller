/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * defines NegativeAmortization in JSON Response
 * @author sboragala
 *
 */
public class NegativeAmortizationModel implements Serializable {

	private static final long serialVersionUID = -7285043492390317209L;

	private String negativeAmortizationLimitMonthsCount;
	private String negativeAmortizationMaximumLoanBalanceAmount;
	private String negativeAmortizationType;
	
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
	 * @return the negativeAmortizationType
	 */
	public String getNegativeAmortizationType() {
		return negativeAmortizationType;
	}
	/**
	 * @param negativeAmortizationType the negativeAmortizationType to set
	 */
	public void setNegativeAmortizationType(String negativeAmortizationType) {
		this.negativeAmortizationType = negativeAmortizationType;
	}
	
	
}
