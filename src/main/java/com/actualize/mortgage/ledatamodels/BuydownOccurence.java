package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class BuydownOccurence extends MISMODataAccessObject {
	public final String BuydownInitialEffectiveInterestRatePercent;
	
	public BuydownOccurence(Element element) {
		super(element);
		BuydownInitialEffectiveInterestRatePercent = getValueAddNS("BuydownInitialEffectiveInterestRatePercent");
	}
}
