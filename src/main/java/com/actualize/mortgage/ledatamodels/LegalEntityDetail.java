package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class LegalEntityDetail extends MISMODataAccessObject {
	public final String FullName;
	
	public LegalEntityDetail(Element element) {
		super(element);
		FullName = getValueAddNS("FullName");
	}
}
