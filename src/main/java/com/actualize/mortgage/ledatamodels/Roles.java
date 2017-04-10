package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class Roles extends MISMODataAccessObject {
	public Role[] roles;
	
	public Roles(Element element) {
		super(element);
		NodeList nodes = getElementsAddNS("ROLE");
		roles = new Role[nodes==null ? 0 : nodes.getLength()];
		for (int i = 0; i < roles.length; i++)
			roles[i] = new Role((Element)nodes.item(i));
	}
}
