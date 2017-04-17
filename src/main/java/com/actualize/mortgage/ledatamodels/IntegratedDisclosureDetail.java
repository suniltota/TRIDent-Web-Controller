package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class IntegratedDisclosureDetail extends MISMODataAccessObject{
	public final String IntegratedDisclosureIssuedDate;
	public final String IntegratedDisclosureHomeEquityLoanIndicator;
	public final String IntegratedDisclosureLoanProductDescription;
	public final String IntegratedDisclosureEstimatedClosingCostsExpirationDatetime;
	public final String FiveYearTotalOfPaymentsComparisonAmount;
	public final String FiveYearPrincipalReductionComparisonAmount;
	public final String FirstYearTotalEscrowPaymentAmount;
	public final String FirstYearTotalEscrowPaymentDescription;
	public final String FirstYearTotalNonEscrowPaymentAmount;
	public final String FirstYearTotalNonEscrowPaymentDescription;
	public final Extension extension;
	
	public IntegratedDisclosureDetail(Element element) {
		super(element);
		IntegratedDisclosureIssuedDate = getValueAddNS("IntegratedDisclosureIssuedDate");
		IntegratedDisclosureHomeEquityLoanIndicator = getValueAddNS("IntegratedDisclosureIssuedDate");
		IntegratedDisclosureLoanProductDescription = getValueAddNS("IntegratedDisclosureLoanProductDescription");
		IntegratedDisclosureEstimatedClosingCostsExpirationDatetime = getValueAddNS("IntegratedDisclosureEstimatedClosingCostsExpirationDatetime");
		FiveYearTotalOfPaymentsComparisonAmount = getValueAddNS("FiveYearTotalOfPaymentsComparisonAmount");
		FiveYearPrincipalReductionComparisonAmount = getValueAddNS("FiveYearPrincipalReductionComparisonAmount");
		FirstYearTotalEscrowPaymentAmount = getValueAddNS("FirstYearTotalEscrowPaymentAmount");
		FirstYearTotalEscrowPaymentDescription = getValueAddNS("FirstYearTotalEscrowPaymentDescription");
		FirstYearTotalNonEscrowPaymentAmount = getValueAddNS("FirstYearTotalNonEscrowPaymentAmount");
		FirstYearTotalNonEscrowPaymentDescription = getValueAddNS("FirstYearTotalNonEscrowPaymentDescription");
		extension = new Extension((Element)getElementAddNS("EXTENSION"));
		
	}
}
