package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class LoanTermsEscrowAccount implements Serializable {

	private static final long serialVersionUID = 277127602825429392L;
	
	private String firstYearTotalNonEscrowPaymentDescription;
	private String firstYearTotalNonEscrowPaymentAmount;
	
	public String getFirstYearTotalNonEscrowPaymentDescription() {
		return firstYearTotalNonEscrowPaymentDescription;
	}
	public void setFirstYearTotalNonEscrowPaymentDescription(String firstYearTotalNonEscrowPaymentDescription) {
		this.firstYearTotalNonEscrowPaymentDescription = firstYearTotalNonEscrowPaymentDescription;
	}
	public String getFirstYearTotalNonEscrowPaymentAmount() {
		return firstYearTotalNonEscrowPaymentAmount;
	}
	public void setFirstYearTotalNonEscrowPaymentAmount(String firstYearTotalNonEscrowPaymentAmount) {
		this.firstYearTotalNonEscrowPaymentAmount = firstYearTotalNonEscrowPaymentAmount;
	}
	

}
