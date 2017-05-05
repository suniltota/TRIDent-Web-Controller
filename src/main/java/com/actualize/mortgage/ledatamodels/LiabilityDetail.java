/**
 * 
 */
package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 * defines LiabilityDetail in MISMO XML
 * @author sboragala
 *
 */
public class LiabilityDetail extends MISMODataAccessObject {
	public final String liabilityDescription;
	public final String liabilityType;
	public final String liabilityTypeOtherDescription;
	public final Extension extension;
	protected LiabilityDetail(Element e) {
		super(e);
		liabilityDescription = getValueAddNS("LiabilityDescription");
		liabilityType = getValueAddNS("LiabilityType");
		liabilityTypeOtherDescription = getValueAddNS("LiabilityTypeOtherDescription");
		extension = new Extension((Element)getElementAddNS("LIABILITY_DETAIL_EXTENSION"));
	}

}
