package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class EscrowItemPayment extends MISMODataAccessObject{
	
	public final String escrowItemActualPaymentAmount;
	public final String escrowItemPaymentPaidByType; 
	public final String escrowItemPaymentTimingType;
	
	protected EscrowItemPayment(Element element) {
		super(element);
		// TODO Auto-generated constructor stub
		escrowItemActualPaymentAmount = getValueAddNS("EscrowItemActualPaymentAmount");
		escrowItemPaymentPaidByType   = getValueAddNS("EscrowItemPaymentPaidByType"); 
		escrowItemPaymentTimingType  = getValueAddNS("EscrowItemPaymentTimingType");
	}
}
