package com.actualize.mortgage.cddatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * Maps PrepaidItemPayment  from XML
 * @author sboragala
 *
 */
public class PrepaidItemPayments extends MISMODataAccessObject {
	public final PrepaidItemPayment[] prepaidItemPayments;
	public PrepaidItemPayments(Element element) {
		this(element,"");
	}
	
	public PrepaidItemPayments(Element element, String qualifier) {
		super(element);
		NodeList nodes = getElementsAddNS("PREPAID_ITEM_PAYMENT" + qualifier);
		prepaidItemPayments = new PrepaidItemPayment[nodes==null ? 0 : nodes.getLength()];
		for (int i = 0; i < prepaidItemPayments.length; i++)
			prepaidItemPayments[i] = new PrepaidItemPayment((Element)nodes.item(i));
	}
}
