package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * defines IntegratedDisclosureDetail in MISMO XML
 * @author sboragala
 *
 */
public class IntegratedDisclosureDetail extends MISMODataAccessObject{
	private static final long serialVersionUID = 4016595902751079829L;
	public final String integratedDisclosureIssuedDate;
	public final String integratedDisclosureHomeEquityLoanIndicator;
	public final String integratedDisclosureLoanProductDescription;
	public final String integratedDisclosureEstimatedClosingCostsExpirationDatetime;
	public final String fiveYearTotalOfPaymentsComparisonAmount;
	public final String fiveYearPrincipalReductionComparisonAmount;
	public final String firstYearTotalEscrowPaymentAmount;
	public final String firstYearTotalEscrowPaymentDescription;
	public final String firstYearTotalNonEscrowPaymentAmount;
	public final String firstYearTotalNonEscrowPaymentDescription;
	public final Extension extension;
	
	public IntegratedDisclosureDetail(Element element) {
		super(element);
		integratedDisclosureIssuedDate = getValueAddNS("IntegratedDisclosureIssuedDate");
		integratedDisclosureHomeEquityLoanIndicator = getValueAddNS("IntegratedDisclosureHomeEquityLoanIndicator");
		integratedDisclosureLoanProductDescription = getValueAddNS("IntegratedDisclosureLoanProductDescription");
		integratedDisclosureEstimatedClosingCostsExpirationDatetime = getValueAddNS("IntegratedDisclosureEstimatedClosingCostsExpirationDatetime");
		fiveYearTotalOfPaymentsComparisonAmount = getValueAddNS("FiveYearTotalOfPaymentsComparisonAmount");
		fiveYearPrincipalReductionComparisonAmount = getValueAddNS("FiveYearPrincipalReductionComparisonAmount");
		firstYearTotalEscrowPaymentAmount = getValueAddNS("FirstYearTotalEscrowPaymentAmount");
		firstYearTotalEscrowPaymentDescription = getValueAddNS("FirstYearTotalEscrowPaymentDescription");
		firstYearTotalNonEscrowPaymentAmount = getValueAddNS("FirstYearTotalNonEscrowPaymentAmount");
		firstYearTotalNonEscrowPaymentDescription = getValueAddNS("FirstYearTotalNonEscrowPaymentDescription");
		extension = new Extension((Element)getElementAddNS("EXTENSION"));
		
	}
}
