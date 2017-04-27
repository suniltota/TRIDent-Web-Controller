package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * represents property detail in MISMO XML
 * @author sboragala
 *
 */
public class PropertyDetail extends MISMODataAccessObject {
	public final String propertyEstimatedValueAmount;
	
	public PropertyDetail(Element element) {
		super(element);
		propertyEstimatedValueAmount = getValueAddNS("PropertyEstimatedValueAmount");
	}
}
