package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * Represents Fee Payments in MISMO XML
 * @author sboragala
 *
 */
public class FeePayment extends MISMODataAccessObject {

	public final String feeActualPaymentAmount;
	public final String feePaymentPaidByType;
	public final String feePaymentPaidOutsideOfClosingIndicator;
		
	public FeePayment(Element element) {
		super(element);
		feeActualPaymentAmount = getValueAddNS("FeeActualPaymentAmount"); 
		feePaymentPaidByType = getValueAddNS("FeePaymentPaidByType"); 
		feePaymentPaidOutsideOfClosingIndicator = getValueAddNS("FeePaymentPaidOutsideOfClosingIndicator"); 
	}

}
