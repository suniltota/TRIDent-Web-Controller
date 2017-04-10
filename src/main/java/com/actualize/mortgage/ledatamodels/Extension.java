package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class Extension extends MISMODataAccessObject {
	public final Other other;
	
	public Extension(Element element) {
		super(element);
		other = new Other((Element)getElementAddNS("OTHER"));
	}
}
