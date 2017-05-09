package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines RealEstateAgent in MISMO XML
 * @author sboragala
 *
 */
public class RealEstateAgent extends MISMODataAccessObject {
	public final String realEstateAgentType;
	
	public RealEstateAgent(Element element) {
		super(element);
		realEstateAgentType = getValueAddNS("RealEstateAgentType");
	}
}
