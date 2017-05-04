package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines Refinance in MISMO XML
 * @author sboragala
 *
 */
public class Refinance extends MISMODataAccessObject {
	public final String refinanceSameLenderIndicator;
	
	public Refinance(String NS, Element element) {
		super(element);
		refinanceSameLenderIndicator = getValueAddNS("RefinanceSameLenderIndicator");
	}
}
