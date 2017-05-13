/**
 * 
 */
package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 * this class defines PartialPayments in MISMO XML
 * @author sboragala
 *
 */
public class PartialPayments extends MISMODataAccessObject {

	private static final long serialVersionUID = 1691512603088384298L;
	
	public final PartialPayment[] partialPayments;
	
	protected PartialPayments(Element e) {
		super(e);
		NodeList nodes = getElementsAddNS("PARTIAL_PAYMENT");
		partialPayments = new PartialPayment[nodes==null ? 0 : nodes.getLength()];
		for (int i = 0; i < partialPayments.length; i++)
			partialPayments[i] = new PartialPayment((Element)nodes.item(i));
	}

}
