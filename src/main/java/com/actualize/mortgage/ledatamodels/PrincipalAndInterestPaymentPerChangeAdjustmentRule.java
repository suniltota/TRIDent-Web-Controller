package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines PrincipalAndInterestPaymentPerChangeAdjustmentRule in MISMO XML
 * @author sboragala
 *
 */
public class PrincipalAndInterestPaymentPerChangeAdjustmentRule extends MISMODataAccessObject {
	
	private static final long serialVersionUID = -869334314692463742L;
	public final String adjustmentRuleType;
	public final String perChangeMaximumPrincipalAndInterestPaymentAmount;
	public final String perChangeMinimumPrincipalAndInterestPaymentAmount;
	public final String perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount;
	
	public PrincipalAndInterestPaymentPerChangeAdjustmentRule(Element element) {
		super(element);
		adjustmentRuleType = getValueAddNS("AdjustmentRuleType");
		perChangeMaximumPrincipalAndInterestPaymentAmount = getValueAddNS("PerChangeMaximumPrincipalAndInterestPaymentAmount");
		perChangeMinimumPrincipalAndInterestPaymentAmount = getValueAddNS("PerChangeMinimumPrincipalAndInterestPaymentAmount");
		perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount = getValueAddNS("PerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount");
	}
}
