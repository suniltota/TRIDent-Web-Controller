package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class PropertyValuationDetail extends MISMODataAccessObject {
	// public final String IdentifierOwnerURI;
	public final String PropertyValuationAmount;
	public final String PropertyValuationMethodType;
	public final String PropertyValuationMethodTypeOtherDescription;
	
	public PropertyValuationDetail(Element element) {
		super(element);
		// IdentifierOwnerURI = getValueAddNS("IdentifierOwnerURI");
		PropertyValuationAmount = getValueAddNS("PropertyValuationAmount");
		PropertyValuationMethodType = getValueAddNS("PropertyValuationMethodType");
		PropertyValuationMethodTypeOtherDescription = getValueAddNS("PropertyValuationMethodTypeOtherDescription");
	}
}
