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
public class ClosingAdjustmentItems extends MISMODataAccessObject {
	
	public final ClosingAdjustmentItem closingAdjustmentItemList[];
	
	protected ClosingAdjustmentItems(Element e) {
		super(e);
		NodeList nodes = getElementsAddNS("CLOSING_ADJUSTMENT_ITEM");
		closingAdjustmentItemList = new ClosingAdjustmentItem[nodes==null ? 0 : nodes.getLength()];
		for (int i = 0; i < closingAdjustmentItemList.length; i++)
			closingAdjustmentItemList[i] = new ClosingAdjustmentItem((Element)nodes.item(i));
	}

}
