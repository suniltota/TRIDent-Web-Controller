package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class Locks extends MISMODataAccessObject {
	public final Lock[] locks;
	
	public Locks(Element element) {
		super(element);
		NodeList nodes = getElementsAddNS("LOCK");
		locks = new Lock[nodes==null ? 0 : nodes.getLength()];
		for (int i = 0; i < locks.length; i++)
			locks[i] = new Lock((Element)nodes.item(i));
	}
}
