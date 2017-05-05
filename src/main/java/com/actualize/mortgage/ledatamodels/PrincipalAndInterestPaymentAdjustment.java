/**
 * 
 */
package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 * @author sboragala
 *
 */
public class PrincipalAndInterestPaymentAdjustment extends MISMODataAccessObject {

	public final PrincipalAndInterestPaymentLifetimeAdjustmentRule principalAndInterestPaymentLifetimeAdjustmentRule;
	public final PrincipalAndInterestPaymentPerChangeAdjustmentRules principalAndInterestPaymentPerChangeAdjustmentRules;
	protected PrincipalAndInterestPaymentAdjustment(Element e) {
		super(e);
		principalAndInterestPaymentLifetimeAdjustmentRule = new PrincipalAndInterestPaymentLifetimeAdjustmentRule((Element)getElementAddNS("PRINCIPAL_AND_INTEREST_PAYMENT_LIFETIME_ADJUSTMENT_RULE"));
		principalAndInterestPaymentPerChangeAdjustmentRules = new  PrincipalAndInterestPaymentPerChangeAdjustmentRules((Element)getElementAddNS("PRINCIPAL_AND_INTEREST_PAYMENT_PER_CHANGE_ADJUSTMENT_RULES"));
	}

}
