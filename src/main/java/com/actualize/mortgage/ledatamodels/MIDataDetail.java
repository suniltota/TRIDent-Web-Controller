package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines the MIDetail in MISMO XML
 * @author pugaz
 *
 */
public class MIDataDetail extends MISMODataAccessObject {
	public final String miCertificateIdentifier;
	public final String miCompanyNameType;
	public final String miCompanyNameTypeOtherDescription;
	public final String miScheduledTerminationDate;
	public final String miInitialPremiumAmount;
	
	public MIDataDetail(Element element) {
		super(element);
		// TODO
		miCertificateIdentifier = getValueAddNS("MICertificateIdentifier");
		miCompanyNameType = getValueAddNS("MICompanyNameType");
		miCompanyNameTypeOtherDescription = getValueAddNS("MICompanyNameTypeOtherDescription");
		miScheduledTerminationDate = getValueAddNS("MIScheduledTerminationDate");
		miInitialPremiumAmount = getValueAddNS("MIInitialPremiumAmount");
	}
}
