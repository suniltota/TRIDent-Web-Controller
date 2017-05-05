package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class Liabilities extends MISMODataAccessObject {

	public final Liability[] liabilityList;

	public Liabilities(String NS, Element element) {
		super(element);
		NodeList nodes = getElementsAddNS("LIABILITY");
		liabilityList = new Liability[nodes==null ? 0 : nodes.getLength()];
		for (int i = 0; i < liabilityList.length; i++)
			liabilityList[i] = new Liability((Element)nodes.item(i));
	}
}
