package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * calculates IntegratedDisclosureSubsectionPayment from XML
 * @author sboragala
 *
 */
public class IntegratedDisclosureSubsectionPayment extends MISMODataAccessObject {
	public final String integratedDisclosureSubsectionPaidByType;
	public final String integratedDisclosureSubsectionPaymentAmount;
	public final String integratedDisclosureSubsectionPaymentTimingType;
	
	public IntegratedDisclosureSubsectionPayment(Element element) {
		super(element);
		integratedDisclosureSubsectionPaidByType = getValueAddNS("IntegratedDisclosureSubsectionPaidByType");
		integratedDisclosureSubsectionPaymentAmount = getValueAddNS("IntegratedDisclosureSubsectionPaymentAmount");
		integratedDisclosureSubsectionPaymentTimingType = getValueAddNS("IntegratedDisclosureSubsectionPaymentTimingType");
	}
}
