package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * defines NegativeAmortization in MISMO XML
 * @author sboragala
 *
 */
public class NegativeAmortization extends MISMODataAccessObject {
	
	private static final long serialVersionUID = -5227757461474596317L;
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
