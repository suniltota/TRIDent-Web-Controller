package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * Defines Prepayment Penalty of Loan Terms in JSON Response
 * @author sboragala
 *
 */
public class LoanTermsPrepaymentPenalty implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4614387411448264728L;
	//to delete below
	private String prepaymentPenaltyIndicator;
	private String prepaymentPenaltyMaximumLifeOfLoanAmount;
	private String prepaymentPenaltyExpirationMonthsCount;
	
	
	/**
	 * @return the prepaymentPenaltyIndicator
	 */
	public String getPrepaymentPenaltyIndicator() {
		return prepaymentPenaltyIndicator;
	}
	/**
	 * @param prepaymentPenaltyIndicator the prepaymentPenaltyIndicator to set
	 */
	public void setPrepaymentPenaltyIndicator(String prepaymentPenaltyIndicator) {
		this.prepaymentPenaltyIndicator = prepaymentPenaltyIndicator;
	}
	/**
	 * @return the prepaymentPenaltyMaximumLifeOfLoanAmount
	 */
	public String getPrepaymentPenaltyMaximumLifeOfLoanAmount() {
		return prepaymentPenaltyMaximumLifeOfLoanAmount;
	}
	/**
	 * @param prepaymentPenaltyMaximumLifeOfLoanAmount the prepaymentPenaltyMaximumLifeOfLoanAmount to set
	 */
	public void setPrepaymentPenaltyMaximumLifeOfLoanAmount(String prepaymentPenaltyMaximumLifeOfLoanAmount) {
		this.prepaymentPenaltyMaximumLifeOfLoanAmount = prepaymentPenaltyMaximumLifeOfLoanAmount;
	}
	/**
	 * @return the prepaymentPenaltyExpirationMonthsCount
	 */
	public String getPrepaymentPenaltyExpirationMonthsCount() {
		return prepaymentPenaltyExpirationMonthsCount;
	}
	/**
	 * @param prepaymentPenaltyExpirationMonthsCount the prepaymentPenaltyExpirationMonthsCount to set
	 */
	public void setPrepaymentPenaltyExpirationMonthsCount(String prepaymentPenaltyExpirationMonthsCount) {
		this.prepaymentPenaltyExpirationMonthsCount = prepaymentPenaltyExpirationMonthsCount;
	}
	
	
	
	
}
