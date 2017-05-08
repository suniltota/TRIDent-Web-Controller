package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class ClosingInformationDetail extends MISMODataAccessObject {
	public final String cashFromBorrowerAtClosingAmount;
	public final String cashFromSellerAtClosingAmount;
	public final String cashToBorrowerAtClosingAmount;
	public final String cashToSellerAtClosingAmount;
	public final String closingAgentOrderNumberIdentifier;
	public final String closingDate;
	public final String closingRateSetDate;
	public final String currentRateSetDate;
	public final String disbursementDate;
	public final String documentOrderClassificationType;
	
	public ClosingInformationDetail(Element element) {
		super(element);
		cashFromBorrowerAtClosingAmount = getValueAddNS("CashFromBorrowerAtClosingAmount");
		cashFromSellerAtClosingAmount = getValueAddNS("CashFromSellerAtClosingAmount");
		cashToBorrowerAtClosingAmount = getValueAddNS("CashToBorrowerAtClosingAmount");
		cashToSellerAtClosingAmount = getValueAddNS("CashToSellerAtClosingAmount");
		closingAgentOrderNumberIdentifier = getValueAddNS("ClosingAgentOrderNumberIdentifier");
		closingDate = getValueAddNS("ClosingDate");
		closingRateSetDate = getValueAddNS("ClosingRateSetDate");
		currentRateSetDate = getValueAddNS("CurrentRateSetDate");
		disbursementDate = getValueAddNS("DisbursementDate");
		documentOrderClassificationType = getValueAddNS("DocumentOrderClassificationType");
	}
}
