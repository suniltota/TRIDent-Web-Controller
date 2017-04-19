package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class FeePaidTo extends MISMODataAccessObject {
	public LegalEntity legalEntity;

	public FeePaidTo(Element element) {
		super(element);
		legalEntity = new LegalEntity((Element)getElementAddNS("LEGAL_ENTITY"));
	}
}
