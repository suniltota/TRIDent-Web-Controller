package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoanTerms implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -5526192148817359783L;
	
	@JsonProperty("prepaymentPenalty")
	private LoanTermsPrepaymentPenalty loanTermsPrepaymentPenalty;
	
	@JsonProperty("temporaryBuydown")
	private LoanTermsTemporaryBuydown loanTermsTemporaryBuydown;
	
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
	 * @return the loanTermsTemporaryBuydown
	 */
	public LoanTermsTemporaryBuydown getLoanTermsTemporaryBuydown() {
		return loanTermsTemporaryBuydown;
	}
	/**
	 * @param loanTermsTemporaryBuydown the loanTermsTemporaryBuydown to set
	 */
	public void setLoanTermsTemporaryBuydown(LoanTermsTemporaryBuydown loanTermsTemporaryBuydown) {
		this.loanTermsTemporaryBuydown = loanTermsTemporaryBuydown;
	}
	
}
