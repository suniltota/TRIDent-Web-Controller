package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class PropertyValuationDetail extends MISMODataAccessObject {
	// public final String IdentifierOwnerURI;
	public final String propertyValuationAmount;
	public final String propertyValuationMethodType;
	public final String propertyValuationMethodTypeOtherDescription;
	
	public PropertyValuationDetail(Element element) {
		super(element);
		//IdentifierOwnerURI = getValueAddNS("IdentifierOwnerURI");
		propertyValuationAmount = getValueAddNS("PropertyValuationAmount");
		propertyValuationMethodType = getValueAddNS("PropertyValuationMethodType");
		propertyValuationMethodTypeOtherDescription = getValueAddNS("PropertyValuationMethodTypeOtherDescription");
	}
}
