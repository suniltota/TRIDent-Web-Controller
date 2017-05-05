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
public class InterestRateAdjustment extends MISMODataAccessObject {

	// protected INTERESTRATELIFETIMEADJUSTMENTRULE interestratelifetimeadjustmentrule;
	    //@XmlElement(name = "INTEREST_RATE_PER_CHANGE_ADJUSTMENT_RULES")
	public final InterestRateLifetimeAdjustmentRule interestRateLifetimeAdjustmentRule;
	public final InterestRatePerChangeAdjustmentRules interestRatePerChangeAdjustmentRulesList ;
	protected InterestRateAdjustment(Element e) {
		super(e);
		interestRatePerChangeAdjustmentRulesList = new InterestRatePerChangeAdjustmentRules((Element)getElementAddNS("INTEREST_RATE_PER_CHANGE_ADJUSTMENT_RULES"));
		interestRateLifetimeAdjustmentRule = new InterestRateLifetimeAdjustmentRule((Element)getElementAddNS("INTEREST_RATE_LIFETIME_ADJUSTMENT_RULE"));
	}

}
