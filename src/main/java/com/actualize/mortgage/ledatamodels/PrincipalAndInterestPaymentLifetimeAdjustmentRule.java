package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * defines PrincipalAndInterestPaymentLifetimeAdjustmentRule in MISMO XML
 * @author sboragala
 *
 */
public class PrincipalAndInterestPaymentLifetimeAdjustmentRule extends MISMODataAccessObject {
	private static final long serialVersionUID = 5899985625332099410L;
	public final String firstPrincipalAndInterestPaymentChangeMonthsCount;
	public final String principalAndInterestPaymentMaximumAmount;
	public final String principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount;
	
	public PrincipalAndInterestPaymentLifetimeAdjustmentRule(Element element) {
		super(element);
		firstPrincipalAndInterestPaymentChangeMonthsCount = getValueAddNS("FirstPrincipalAndInterestPaymentChangeMonthsCount");
		principalAndInterestPaymentMaximumAmount = getValueAddNS("PrincipalAndInterestPaymentMaximumAmount");
		principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount = getValueAddNS("PrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount");
	}
}
