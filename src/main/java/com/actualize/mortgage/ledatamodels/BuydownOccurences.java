package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines BuydownOccurences in MISMO XML
 * @author sboragala
 *
 */
public class BuydownOccurences extends MISMODataAccessObject {
	
	private static final long serialVersionUID = 8716038821492999254L;
	public final BuydownOccurence[] buydownOccurences;
	
	public BuydownOccurences(Element element, String qualifier) {
		super(element);
		NodeList nodes = getElementsAddNS("BUYDOWN_OCCURRENCE" + (qualifier == null ? "" : qualifier));
		buydownOccurences = new BuydownOccurence[nodes==null ? 0 : nodes.getLength()];
		for (int i = 0; i < buydownOccurences.length; i++)
			buydownOccurences[i] = new BuydownOccurence((Element)nodes.item(i));			
	}

	public BuydownOccurences(Element element) {
		this(element, null);
	}
}
