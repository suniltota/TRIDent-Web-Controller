/**
 * 
 */
package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 * this class defines InterestRateAdjustment in MISMO XML
 * @author sboragala
 *
 */
public class InterestRateAdjustment extends MISMODataAccessObject {

	private static final long serialVersionUID = -9007429607017414408L;

	public final InterestRateLifetimeAdjustmentRule interestRateLifetimeAdjustmentRule;
	public final InterestRatePerChangeAdjustmentRules interestRatePerChangeAdjustmentRulesList ;
	public final IndexRule indexRule;
	public InterestRateAdjustment(Element e) {
		super(e);
		indexRule = new IndexRule((Element)getElementAddNS("INDEX_RULES/INDEX_RULE"));
		interestRatePerChangeAdjustmentRulesList = new InterestRatePerChangeAdjustmentRules((Element)getElementAddNS("INTEREST_RATE_PER_CHANGE_ADJUSTMENT_RULES"));
		interestRateLifetimeAdjustmentRule = new InterestRateLifetimeAdjustmentRule((Element)getElementAddNS("INTEREST_RATE_LIFETIME_ADJUSTMENT_RULE"));
	}

}
