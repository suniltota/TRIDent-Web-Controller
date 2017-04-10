package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class Amortization extends MISMODataAccessObject {
	public final AmortizationRule amortizationRule;

	public Amortization(Element element) {
		super(element);
		amortizationRule = new AmortizationRule((Element)getElementAddNS("AMORTIZATION_RULE"));
	}
}
