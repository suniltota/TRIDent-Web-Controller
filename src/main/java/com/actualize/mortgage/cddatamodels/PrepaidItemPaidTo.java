package com.actualize.mortgage.cddatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
import com.actualize.mortgage.ledatamodels.LegalEntity;

public class PrepaidItemPaidTo extends MISMODataAccessObject{
	public final LegalEntity legalEntity;
	public PrepaidItemPaidTo(Element e) {
		super(e);
		legalEntity = new LegalEntity((Element)getElementAddNS("LEGAL_ENTITY"));
	}

}
