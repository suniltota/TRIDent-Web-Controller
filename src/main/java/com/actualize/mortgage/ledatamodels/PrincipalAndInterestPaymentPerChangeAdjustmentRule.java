package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class PrincipalAndInterestPaymentPerChangeAdjustmentRule extends MISMODataAccessObject {
	public final String AdjustmentRuleType;
	public final String PerChangeMaximumPrincipalAndInterestPaymentAmount;
	public final String PerChangeMinimumPrincipalAndInterestPaymentAmount;
	public final String PerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount;
	
	public PrincipalAndInterestPaymentPerChangeAdjustmentRule(Element element) {
		super(element);
		AdjustmentRuleType = getValueAddNS("AdjustmentRuleType");
		PerChangeMaximumPrincipalAndInterestPaymentAmount = getValueAddNS("PerChangeMaximumPrincipalAndInterestPaymentAmount");
		PerChangeMinimumPrincipalAndInterestPaymentAmount = getValueAddNS("PerChangeMinimumPrincipalAndInterestPaymentAmount");
		PerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount = getValueAddNS("PerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount");
	}
}
