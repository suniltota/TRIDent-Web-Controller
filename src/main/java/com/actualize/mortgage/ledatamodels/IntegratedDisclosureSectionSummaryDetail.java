package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class IntegratedDisclosureSectionSummaryDetail extends MISMODataAccessObject {
	public final String IntegratedDisclosureSectionTotalAmount;
	public final String IntegratedDisclosureSectionType;
	public final String IntegratedDisclosureSubsectionTotalAmount;
	public final String IntegratedDisclosureSubsectionType;
	public final String IntegratedDisclosureSubsectionTypeOtherDescription;
	public final String LenderCreditToleranceCureAmount;
	
	public IntegratedDisclosureSectionSummaryDetail(Element element) {
		super(element);
		IntegratedDisclosureSectionTotalAmount = getValueAddNS("IntegratedDisclosureSectionTotalAmount");
		IntegratedDisclosureSectionType = getValueAddNS("IntegratedDisclosureSectionType");
		IntegratedDisclosureSubsectionTotalAmount = getValueAddNS("IntegratedDisclosureSubsectionTotalAmount");
		IntegratedDisclosureSubsectionType = getValueAddNS("IntegratedDisclosureSubsectionType");
		IntegratedDisclosureSubsectionTypeOtherDescription = getValueAddNS("IntegratedDisclosureSubsectionTypeOtherDescription");
		LenderCreditToleranceCureAmount = getValueAddNS("LenderCreditToleranceCureAmount");
	}
}
