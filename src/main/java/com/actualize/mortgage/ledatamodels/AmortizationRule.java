package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class AmortizationRule extends MISMODataAccessObject {
	public final String AmortizationType;
	
	public AmortizationRule(Element element) {
		super(element);
		AmortizationType = getValueAddNS("AmortizationType");
	}
}
