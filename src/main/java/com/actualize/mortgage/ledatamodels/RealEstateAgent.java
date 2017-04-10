package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class RealEstateAgent extends MISMODataAccessObject {
	public final String RealEstateAgentType;
	
	public RealEstateAgent(Element element) {
		super(element);
		RealEstateAgentType = getValueAddNS("RealEstateAgentType");
	}
}
