package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines Adjustment in MISMO XML
 * @author sboragala
 *
 */
public class Adjustment extends MISMODataAccessObject {
	
	private static final long serialVersionUID = -8369040020083756241L;
	
	public final InterestRateAdjustment interestRateAdjustment;
	public final PrincipalAndInterestPaymentAdjustment principalAndInterestPaymentAdjustment;
	public Adjustment(String NS, Element element) {
		super(element);
		interestRateAdjustment = new InterestRateAdjustment((Element)getElementAddNS("INTEREST_RATE_ADJUSTMENT"));
		principalAndInterestPaymentAdjustment = new PrincipalAndInterestPaymentAdjustment((Element)getElementAddNS("PRINCIPAL_AND_INTEREST_PAYMENT_ADJUSTMENT"));
	}
}
