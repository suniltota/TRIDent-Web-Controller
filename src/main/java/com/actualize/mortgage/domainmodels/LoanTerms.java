package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoanTerms implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -5526192148817359783L;
	
	@JsonProperty("loanAmount") 
	private LoanTermsLoanAmount loanTermsLoanAmount;
	@JsonProperty("interestRate")
	private LoanTermsInterestRate loanTermsInterestRate;
	@JsonProperty("principalInterest")
	private LoanTermsPI loanTermsPI;
	@JsonProperty("prepaymentPenalty")
	private LoanTermsPrepaymentPenalty loanTermsPrepaymentPenalty;
	@JsonProperty("balloonPayment")
	private LoanTermsBalloonPayment loanTermsBalloonPayment;
	
	/**
	 * @return the loanTermsLoanAmount
	 */
	public LoanTermsLoanAmount getLoanTermsLoanAmount() {
		return loanTermsLoanAmount;
	}
	/**
	 * @param loanTermsLoanAmount the loanTermsLoanAmount to set
	 */
	public void setLoanTermsLoanAmount(LoanTermsLoanAmount loanTermsLoanAmount) {
		this.loanTermsLoanAmount = loanTermsLoanAmount;
	}
	/**
	 * @return the loanTermsInterestRate
	 */
	public LoanTermsInterestRate getLoanTermsInterestRate() {
		return loanTermsInterestRate;
	}
	/**
	 * @param loanTermsInterestRate the loanTermsInterestRate to set
	 */
	public void setLoanTermsInterestRate(LoanTermsInterestRate loanTermsInterestRate) {
		this.loanTermsInterestRate = loanTermsInterestRate;
	}
	/**
	 * @return the loanTermsPI
	 */
	public LoanTermsPI getLoanTermsPI() {
		return loanTermsPI;
	}
	/**
	 * @param loanTermsPI the loanTermsPI to set
	 */
	public void setLoanTermsPI(LoanTermsPI loanTermsPI) {
		this.loanTermsPI = loanTermsPI;
	}
	/**
	 * @return the loanTermsPrepaymentPenalty
	 */
	public LoanTermsPrepaymentPenalty getLoanTermsPrepaymentPenalty() {
		return loanTermsPrepaymentPenalty;
	}
	/**
	 * @param loanTermsPrepaymentPenalty the loanTermsPrepaymentPenalty to set
	 */
	public void setLoanTermsPrepaymentPenalty(LoanTermsPrepaymentPenalty loanTermsPrepaymentPenalty) {
		this.loanTermsPrepaymentPenalty = loanTermsPrepaymentPenalty;
	}
	/**
	 * @return the loanTermsBalloonPayment
	 */
	public LoanTermsBalloonPayment getLoanTermsBalloonPayment() {
		return loanTermsBalloonPayment;
	}
	/**
	 * @param loanTermsBalloonPayment the loanTermsBalloonPayment to set
	 */
	public void setLoanTermsBalloonPayment(LoanTermsBalloonPayment loanTermsBalloonPayment) {
		this.loanTermsBalloonPayment = loanTermsBalloonPayment;
	}
	
}
