package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines InterestRateLifetimeAdjustmentRule in MISMO XML
 * @author sboragala
 *
 */
public class InterestRateLifetimeAdjustmentRule extends MISMODataAccessObject {

	private static final long serialVersionUID = -3238763569026709083L;
	public final String ceilingRatePercent;
	public final String ceilingRatePercentEarliestEffectiveMonthsCount;
	public final String firstRateChangeMonthsCount;
	public final String floorRatePercent;
	public final String marginRatePercent;
	public final Other other;
	
	public InterestRateLifetimeAdjustmentRule(Element element) {
		super(element);
		ceilingRatePercent = getValueAddNS("CeilingRatePercent");
		ceilingRatePercentEarliestEffectiveMonthsCount = getValueAddNS("CeilingRatePercentEarliestEffectiveMonthsCount");
		firstRateChangeMonthsCount = getValueAddNS("FirstRateChangeMonthsCount");
		floorRatePercent = getValueAddNS("FloorRatePercent");
		marginRatePercent = getValueAddNS("MarginRatePercent");
		other = new Other((Element)getElementAddNS("EXTENSION/INTEREST_RATE_LIFETIME_ADJUSTMENT_RULE_EXTENSION/OTHER"));
	}
}
