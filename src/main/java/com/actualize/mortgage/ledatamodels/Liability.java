/**
 * 
 */
package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 * defines Liability in MISMO XML  
 * @author sboragala
 *
 */
public class Liability extends MISMODataAccessObject {
	public final LiabilityDetail liabilityDetail;
	public final Name liabilityholderName;
	public final PayOff payOff;
	protected Liability(Element e) {
		super(e);
		liabilityDetail = new LiabilityDetail((Element)getElementAddNS("FEE_DETAIL"));
		liabilityholderName = new Name((Element)getElementAddNS("LIABILITY_HOLDER/NAME"));
		payOff = new PayOff((Element)getElementAddNS("PAYOFF"));
	}

}
