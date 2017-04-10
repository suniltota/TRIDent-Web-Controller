package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class ContactPointTelephone extends MISMODataAccessObject {
	public final String ContactPointTelephoneValue;
	
	public ContactPointTelephone(Element element) {
		super(element);
		ContactPointTelephoneValue = getValueAddNS("ContactPointTelephoneValue");
	}
}
