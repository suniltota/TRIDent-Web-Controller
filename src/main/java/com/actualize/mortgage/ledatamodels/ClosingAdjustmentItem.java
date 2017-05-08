/**
 * 
 */
package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 * @author sboragala
 *
 */
public class ClosingAdjustmentItem extends MISMODataAccessObject {
	
	public final ClosingAdjustmentItemDetail closingAdjustmentItemDetail;
	public final PaidBy paidBy;
	public final String paidToEntityFullName;

	protected ClosingAdjustmentItem(Element e) {
		super(e);
		closingAdjustmentItemDetail = new ClosingAdjustmentItemDetail((Element)getElementAddNS("CLOSING_ADJUSTMENT_ITEM_DETAIL"));
		paidBy = new PaidBy((Element)getElementAddNS("CLOSING_ADJUSTMENT_ITEM_PAID_BY"));
		paidToEntityFullName = getValue("MISMO:EXTENSION/MISMO:CLOSING_ADJUSTMENT_ITEM_EXTENSION/MISMO:OTHER/gse:OTHER_CLOSING_ADJUSTMENT_ITEM_EXTENSION/MISMO:LEGAL_ENTITY/MISMO:LEGAL_ENTITY_DETAIL/MISMO:FullName");
	}

}
