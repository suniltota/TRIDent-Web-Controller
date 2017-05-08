package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 * 
 * @author sboragala
 *
 */
public class PaidBy extends MISMODataAccessObject{
	
	public final Individual individual;
	public final LegalEntity legalEntity;

	protected PaidBy(Element e) {
		super(e);
		individual = new Individual((Element)getElementAddNS("INDIVIDUAL"));
		legalEntity = new LegalEntity((Element)getElementAddNS("LEGAL_ENTITY"));
	}

}
