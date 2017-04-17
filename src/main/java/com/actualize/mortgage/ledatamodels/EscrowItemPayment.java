package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class EscrowItemPayment extends MISMODataAccessObject{
	
	public final String EscrowItemActualPaymentAmount;
	public final String EscrowItemPaymentPaidByType; 
	public final String EscrowItemPaymentTimingType;
	
	protected EscrowItemPayment(Element element) {
		super(element);
		// TODO Auto-generated constructor stub
		EscrowItemActualPaymentAmount = getValueAddNS("EscrowItemActualPaymentAmount");
		EscrowItemPaymentPaidByType   = getValueAddNS("EscrowItemPaymentPaidByType"); 
		EscrowItemPaymentTimingType  = getValueAddNS("EscrowItemPaymentTimingType");
	}
}
