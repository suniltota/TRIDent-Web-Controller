package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class Other extends MISMODataAccessObject {
	public final String IntegratedDisclosureEstimatedClosingCostsExpirationTimezoneType;
	public final String LockExpirationTimezoneType;
	
	public Other(Element element) {
		super(element);
		IntegratedDisclosureEstimatedClosingCostsExpirationTimezoneType = getValue("gse:IntegratedDisclosureEstimatedClosingCostsExpirationTimezoneType");
		LockExpirationTimezoneType = getValue("gse:LockExpirationTimezoneType");
	}
}
