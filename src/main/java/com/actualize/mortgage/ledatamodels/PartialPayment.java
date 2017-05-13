/**
 * 
 */
package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 * this defines patial payments in MISMO XML 
 * @author sboragala
 *
 */
public class PartialPayment extends MISMODataAccessObject {
	private static final long serialVersionUID = -2718233585282088020L;

	public final String partialPaymentApplicationMethodType;
	public final String partialPaymentApplicationMethodTypeOtherDescription;
	protected PartialPayment(Element e) {
		super(e);
		partialPaymentApplicationMethodType = getValueAddNS("PartialPaymentApplicationMethodType");
		partialPaymentApplicationMethodTypeOtherDescription = getValueAddNS("PartialPaymentApplicationMethodTypeOtherDescription"); 
	}

}
