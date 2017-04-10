package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class License extends MISMODataAccessObject {
	public final LicenseDetail licenseDetail;

	public License(Element element) {
		super(element);
		licenseDetail = new LicenseDetail((Element)getElementAddNS("LICENSE_DETAIL"));
	}
}
