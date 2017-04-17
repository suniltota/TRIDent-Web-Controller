package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class EscrowItem extends MISMODataAccessObject {
	public final EscrowItemDetail escrowItemDetail;
	public final EscrowItemPayments escrowItemPayments;

	public EscrowItem(Element element) {
		super(element);
		escrowItemDetail = new EscrowItemDetail((Element)getElementAddNS("ESCROW_ITEM_DETAIL"));
		escrowItemPayments = new EscrowItemPayments((Element)getElementAddNS("ESCROW_ITEM_PAYMENTS"));
	}
}
