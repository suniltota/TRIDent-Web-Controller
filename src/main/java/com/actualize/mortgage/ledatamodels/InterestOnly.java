package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class InterestOnly extends MISMODataAccessObject {
	public final String InterestOnlyTermMonthsCount;
	
	public InterestOnly(Element element) {
		super(element);
		InterestOnlyTermMonthsCount = getValueAddNS("InterestOnlyTermMonthsCount");
	}
}
