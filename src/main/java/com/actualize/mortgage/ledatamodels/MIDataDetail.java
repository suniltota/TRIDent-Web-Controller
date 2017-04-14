package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class MIDataDetail extends MISMODataAccessObject {
	public final String MICertificateIdentifier;
	public final String MICompanyNameType;
	public final String MICompanyNameTypeOtherDescription;
	public final String MIScheduledTerminationDate;
	public final String MIInitialPremiumAmount;
	
	public MIDataDetail(Element element) {
		super(element);
		// TODO
		MICertificateIdentifier = getValueAddNS("MICertificateIdentifier");
		MICompanyNameType = getValueAddNS("MICompanyNameType");
		MICompanyNameTypeOtherDescription = getValueAddNS("MICompanyNameTypeOtherDescription");
		MIScheduledTerminationDate = getValueAddNS("MIScheduledTerminationDate");
		MIInitialPremiumAmount = getValueAddNS("MIInitialPremiumAmount");
	}
}
