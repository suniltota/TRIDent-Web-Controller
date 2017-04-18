package com.actualize.mortgage.cddatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class PrepaidItemPayment extends MISMODataAccessObject {
	public final String prepaidItemActualPaymentAmount;
	public final String prepaidItemPaymentPaidByType;
	public final String prepaidItemPaymentTimingType;
	public final String regulationZPointsAndFeesIndicator;
	
	public PrepaidItemPayment(Element e) {
		super(e);
		prepaidItemActualPaymentAmount = getValueAddNS("PrepaidItemActualPaymentAmount");
		prepaidItemPaymentPaidByType = getValueAddNS("PrepaidItemPaymentPaidByType");
		prepaidItemPaymentTimingType = getValueAddNS("PrepaidItemPaymentTimingType");
		regulationZPointsAndFeesIndicator = getValueAddNS("regulationZPointsAndFeesIndicator");
	}
	
}
