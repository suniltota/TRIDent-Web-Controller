package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines payment in MISMO XML
 * @author sboragala
 *
 */
public class Payment extends MISMODataAccessObject {
	
	private static final long serialVersionUID = -2284442143945289114L;
	
	public final PartialPayments partialPayments;
	public final PaymentRule paymentRule;

	public Payment(String NS, Element element) {
		super(element);
		partialPayments = new PartialPayments((Element)getElementAddNS("PARTIAL_PAYMENTS"));
		paymentRule = new PaymentRule((Element)getElementAddNS("PAYMENT_RULE"));
	}
}
