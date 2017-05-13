package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * defines Extension in MISMO XML
 * @author sboragala
 *
 */
public class Extension extends MISMODataAccessObject {
	
	private static final long serialVersionUID = -7320370149076956146L;
	public final Other other;
	
	public Extension(Element element) {
		super(element);
		other = new Other((Element)getElementAddNS("OTHER"));
	}
}
