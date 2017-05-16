package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines AutomatedUnderwriting in MISMO XML
 * @author sboragala
 *
 */
public class AutomatedUnderwriting extends MISMODataAccessObject{
	
	private static final long serialVersionUID = -1254903675617268266L;
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
