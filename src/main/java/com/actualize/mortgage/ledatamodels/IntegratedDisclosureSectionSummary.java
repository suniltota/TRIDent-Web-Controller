package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * defines IntegratedDisclosureSectionSummary in MISMO XML
 * @author sboragala
 *
 */
public class IntegratedDisclosureSectionSummary extends MISMODataAccessObject {

	private static final long serialVersionUID = -8227255530778646492L;
	public final IntegratedDisclosureSectionSummaryDetail integratedDisclosureSectionSummaryDetail;
	public final IntegratedDisclosureSubsectionPayments integratedDisclosureSubsectionPayments;

	public IntegratedDisclosureSectionSummary(Element element) {
		super(element);
		integratedDisclosureSectionSummaryDetail = new IntegratedDisclosureSectionSummaryDetail((Element)getElementAddNS("INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL"));
		integratedDisclosureSubsectionPayments = new IntegratedDisclosureSubsectionPayments((Element)getElementAddNS("INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENTS"));
	}
}
