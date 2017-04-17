package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * Defines parties from XML
 * @author sboragala
 *
 */
public class Parties extends MISMODataAccessObject {
	public final Party[] parties;
	
	public Parties(Element element, String qualifier) {
		super(element);
		NodeList nodes = getElementsAddNS("PARTY" + (qualifier == null ? "" : qualifier));
		parties = new Party[nodes==null ? 0 : nodes.getLength()];
		for (int i = 0; i < parties.length; i++)
			parties[i] = new Party((Element)nodes.item(i));			
	}

	public Parties(Element element) {
		this(element, null);
	}
}
