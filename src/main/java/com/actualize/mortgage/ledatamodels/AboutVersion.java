package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * 
 * @author sboragala
 *
 */
public class AboutVersion extends MISMODataAccessObject {
	public final String CreatedDatetime;
	public final String DataVersionIdentifier;
	public final String AboutVersionIdentifier;
	public AboutVersion(String NS, Element element) {
		super(element);
		CreatedDatetime = getElementValue(element, NS + "CreatedDatetime");
		DataVersionIdentifier = getElementValue(element, NS + "DataVersionIdentifier");
		AboutVersionIdentifier = getElementValue(element, NS + "AboutVersionIdentifier");
	}
	public AboutVersion(Element element) {
		this(null,element);
	}
}
