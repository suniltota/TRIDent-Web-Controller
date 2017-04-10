package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class IndexRule extends MISMODataAccessObject {
	public final String IndexType;
	public final String IndexTypeOtherDescription;
	
	public IndexRule(Element element) {
		super(element);
		IndexType = getValueAddNS("IndexType");
		IndexTypeOtherDescription = getValueAddNS("IndexTypeOtherDescription");
	}
}
