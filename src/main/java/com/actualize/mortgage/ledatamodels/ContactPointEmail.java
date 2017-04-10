package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class ContactPointEmail extends MISMODataAccessObject {
	public final String ContactPointEmailValue;
	
	public ContactPointEmail(Element element) {
		super(element);
		ContactPointEmailValue = getValueAddNS("ContactPointEmailValue");
	}
}
