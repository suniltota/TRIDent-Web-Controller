package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class PrepaidItem extends MISMODataAccessObject {
	public final PrepaidItemDetail prepaidItemDetail;

	public PrepaidItem(Element element) {
		super(element);
		prepaidItemDetail = new PrepaidItemDetail((Element)getElementAddNS("PREPAID_ITEM_DETAIL"));
	}
}
