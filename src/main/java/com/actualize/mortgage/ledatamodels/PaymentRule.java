package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines PaymentRule in MISMO XML
 * @author sboragala
 *
 */
public class PaymentRule extends MISMODataAccessObject {
	private static final long serialVersionUID = 1052208568093101212L;
	public final String fullyIndexedInitialPrincipalAndInterestPaymentAmount;
	public final String initialPrincipalAndInterestPaymentAmount;
	public final String partialPaymentAllowedIndicator;
	public final String paymentFrequencyType;
	public final String paymentOptionIndicator;
	public final String seasonalPaymentPeriodEndMonth;
	public final String seasonalPaymentPeriodStartMonth;
	public final Other other;
	
	public PaymentRule(Element element) {
		super(element);
		fullyIndexedInitialPrincipalAndInterestPaymentAmount = getValueAddNS("FullyIndexedInitialPrincipalAndInterestPaymentAmount");
		initialPrincipalAndInterestPaymentAmount = getValueAddNS("InitialPrincipalAndInterestPaymentAmount");
		partialPaymentAllowedIndicator = getValueAddNS("PartialPaymentAllowedIndicator");
		paymentFrequencyType = getValueAddNS("PaymentFrequencyType");
		paymentOptionIndicator = getValueAddNS("PaymentOptionIndicator");
		seasonalPaymentPeriodEndMonth = getValueAddNS("SeasonalPaymentPeriodEndMonth");
		seasonalPaymentPeriodStartMonth = getValueAddNS("SeasonalPaymentPeriodStartMonth");
		other = new Other((Element)getElementAddNS("EXTENSION/PAYMENT_RULE_EXTENSION/OTHER"));
	}
}
