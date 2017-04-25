package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class CashToCloseItems extends MISMODataAccessObject {
	public final CashToCloseItem[] cashToCloseItems;

	public CashToCloseItems(Element element) {
		super(element);
		NodeList nodes = getElementsAddNS((NS == null ? "" : NS)+"CASH_TO_CLOSE_ITEM");
		cashToCloseItems = new CashToCloseItem[nodes==null ? 0 : nodes.getLength()];
		for (int i = 0; i < cashToCloseItems.length; i++)
			cashToCloseItems[i] = new CashToCloseItem((Element)nodes.item(i));
	}
}