package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class LoanIdentifier extends MISMODataAccessObject {
	public final String LoanIdentifier;
	public final String LoanIdentifierType;
	
	public LoanIdentifier(Element element) {
		super(element);
		LoanIdentifier = getValueAddNS("LoanIdentifier");
		LoanIdentifierType = getValueAddNS("LoanIdentifierType");
	}
}
