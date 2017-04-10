package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class BuydownRule extends MISMODataAccessObject {
	public final String BuydownChangeFrequencyMonthsCount;
	public final String BuydownDurationMonthsCount;
	public final String BuydownIncreaseRatePercent;
	
	public BuydownRule(Element element) {
		super(element);
		BuydownChangeFrequencyMonthsCount = getValueAddNS("BuydownChangeFrequencyMonthsCount");
		BuydownDurationMonthsCount = getValueAddNS("BuydownDurationMonthsCount");
		BuydownIncreaseRatePercent = getValueAddNS("BuydownIncreaseRatePercent");
	}
}
