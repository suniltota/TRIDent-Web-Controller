package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * 
 * @author sboragala
 *
 */
public class Adjustment extends MISMODataAccessObject {
	public final InterestRateAdjustment interestRateAdjustment;
	public final PrincipalAndInterestPaymentAdjustment principalAndInterestPaymentAdjustment;
	public Adjustment(String NS, Element element) {
		super(element);
		interestRateAdjustment = new InterestRateAdjustment((Element)getElementAddNS("INTEREST_RATE_ADJUSTMENT"));
		principalAndInterestPaymentAdjustment = new PrincipalAndInterestPaymentAdjustment((Element)getElementAddNS("PRINCIPAL_AND_INTEREST_PAYMENT_ADJUSTMENT"));
	}
}
