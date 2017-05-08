package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * defines PayOff in MISMO XML
 * @author sboragala
 *
 */
public class PayOff extends MISMODataAccessObject{
	public final String payoffAmount;
	public final String payoffPrepaymentPenaltyAmount;
	
	protected PayOff(Element e) {
		super(e);
		payoffAmount = getValueAddNS("PayoffAmount");
		payoffPrepaymentPenaltyAmount = getValueAddNS("PayoffPrepaymentPenaltyAmount");
	}
	

}
