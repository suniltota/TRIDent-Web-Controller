package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class PropertyDetail extends MISMODataAccessObject {
	public final String PropertyEstimatedValueAmount;
	
	public PropertyDetail(Element element) {
		super(element);
		PropertyEstimatedValueAmount = getValueAddNS("PropertyEstimatedValueAmount");
	}
}
