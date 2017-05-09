package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines Address in MISMO XML 
 * @author sboragala
 *
 */
public class Address extends MISMODataAccessObject {
	public final String addressLineText;
	public final String addressType;
	public final String cityName;
	public final String postalCode;
	public final String stateCode;
	public final String countryCode;
	
	public Address(Element element) {
		super(element);
		addressLineText = getValueAddNS("AddressLineText");
		addressType = getValueAddNS("AddressType");
		cityName = getValueAddNS("CityName");
		postalCode = getValueAddNS("PostalCode");
		stateCode = getValueAddNS("StateCode");
		countryCode = getValueAddNS("CountryCode");
	}
}
