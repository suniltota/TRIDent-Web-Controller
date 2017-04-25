package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class InterestRateLifetimeAdjustmentRule extends MISMODataAccessObject {
	public final String CeilingRatePercent;
	public final String CeilingRatePercentEarliestEffectiveMonthsCount;
	public final String FirstRateChangeMonthsCount;
	public final String FloorRatePercent;
	public final String MarginRatePercent;
	
	public InterestRateLifetimeAdjustmentRule(Element element) {
		super(element);
		CeilingRatePercent = getValueAddNS("CeilingRatePercent");
		CeilingRatePercentEarliestEffectiveMonthsCount = getValueAddNS("CeilingRatePercentEarliestEffectiveMonthsCount");
		FirstRateChangeMonthsCount = getValueAddNS("FirstRateChangeMonthsCount");
		FloorRatePercent = getValueAddNS("FloorRatePercent");
		MarginRatePercent = getValueAddNS("MarginRatePercent");
	}
}