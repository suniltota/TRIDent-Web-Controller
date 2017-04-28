package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * Represents Interest Only in MISMO XML
 * @author sboragala
 *
 */
public class InterestOnly extends MISMODataAccessObject {
	public final String interestOnlyTermMonthsCount;
	
	public InterestOnly(Element element) {
		super(element);
		interestOnlyTermMonthsCount = getValueAddNS("InterestOnlyTermMonthsCount");
	}
}
