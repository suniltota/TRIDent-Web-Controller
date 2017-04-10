package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class Lock extends MISMODataAccessObject {
	public final String LockExpirationDatetime;
	public final String LockStatusType;
	public final Extension extension;
	
	public Lock(Element element) {
		super(element);
		LockExpirationDatetime = getValueAddNS("LockExpirationDatetime");
		LockStatusType = getValueAddNS("LockStatusType");
		extension = new Extension((Element)getElementAddNS("EXTENSION"));
	}
}
