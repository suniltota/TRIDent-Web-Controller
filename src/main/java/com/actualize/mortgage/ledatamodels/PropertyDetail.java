package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * represents property detail in MISMO XML
 * @author sboragala
 *
 */
public class PropertyDetail extends MISMODataAccessObject {
	private static final long serialVersionUID = 1383906429113848271L;
	public final String propertyEstimatedValueAmount;
	
	public PropertyDetail(Element element) {
		super(element);
		propertyEstimatedValueAmount = getValueAddNS("PropertyEstimatedValueAmount");
	}
}
