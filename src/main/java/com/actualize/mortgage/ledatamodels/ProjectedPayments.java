package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class ProjectedPayments extends MISMODataAccessObject {
	public final ProjectedPayment[] projectedPayments;

	public ProjectedPayments(Element element) {
		super(element);
		NodeList nodes = getElementsAddNS("PROJECTED_PAYMENT");
		projectedPayments = new ProjectedPayment[nodes==null ? 0 : nodes.getLength()];
		for (int i = 0; i < projectedPayments.length; i++)
			projectedPayments[i] = new ProjectedPayment((Element)nodes.item(i));
	}
}
