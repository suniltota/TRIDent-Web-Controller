package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class NegativeAmortization extends MISMODataAccessObject {
	
	public final String negativeAmortizationLimitMonthsCount;
	public final String negativeAmortizationMaximumLoanBalanceAmount;
	public final String negativeAmortizationType;
	
	public NegativeAmortization(String NS, Element element) {
		super(element);
		negativeAmortizationLimitMonthsCount = getValueAddNS("NegativeAmortizationLimitMonthsCount");
		negativeAmortizationMaximumLoanBalanceAmount = getValueAddNS("NegativeAmortizationMaximumLoanBalanceAmount");
		negativeAmortizationType = getValueAddNS("NegativeAmortizationType");
	}
}
