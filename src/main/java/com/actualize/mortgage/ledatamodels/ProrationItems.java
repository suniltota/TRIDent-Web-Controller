/**
 * 
 */
package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 * @author sboragala
 *
 */
public class ProrationItems extends MISMODataAccessObject {
	public final ProrationItem prorationItemList[];
	protected ProrationItems(Element e) {
		super(e);
		NodeList nodes = getElementsAddNS("PRORATION_ITEM");
		prorationItemList = new ProrationItem[nodes==null ? 0 : nodes.getLength()];
		for (int i = 0; i < prorationItemList.length; i++)
			prorationItemList[i] = new ProrationItem((Element)nodes.item(i));
	}

}
