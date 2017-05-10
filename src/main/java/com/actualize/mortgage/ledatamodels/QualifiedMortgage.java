package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class QualifiedMortgage extends MISMODataAccessObject {
	public final QualifiedMortgageDetail qualifiedMortgageDetail;
	public final Exemption exemption;
	public QualifiedMortgage(String NS, Element element) {
		super(element);
		qualifiedMortgageDetail = new QualifiedMortgageDetail((Element)getElementAddNS("QUALIFIED_MORTGAGE_DETAIL"));
		exemption = new Exemption((Element)getElementAddNS("EXEMPTIONS/EXEMPTION"));
	}
}
