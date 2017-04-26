package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class AutomatedUnderwriting extends MISMODataAccessObject{
	
	public final String automatedUnderwritingCaseIdentifier;
	public final String automatedUnderwritingSystemType;
	public final String automatedUnderwritingSystemTypeOtherDescription;
	
	public AutomatedUnderwriting(Element e) {
		super(e);
		automatedUnderwritingCaseIdentifier = getValueAddNS("AutomatedUnderwritingCaseIdentifier");
		automatedUnderwritingSystemType = getValueAddNS("AutomatedUnderwritingSystemType");
		automatedUnderwritingSystemTypeOtherDescription = getValueAddNS("AutomatedUnderwritingSystemTypeOtherDescription");
	}
	
	
}
