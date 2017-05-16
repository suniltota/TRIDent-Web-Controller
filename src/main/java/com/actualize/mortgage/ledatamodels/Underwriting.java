package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines Underwriting in MISMO XML
 * @author sboragala
 *
 */
public class Underwriting extends MISMODataAccessObject {
	private static final long serialVersionUID = -8247142506110814858L;
	public final AutomatedUnderwritings automatedUnderwritings;
	public final UnderwritingDetail underwritingDetail;
	public Underwriting(String NS, Element element) {
		super(element);
		automatedUnderwritings = new AutomatedUnderwritings((Element)getElementAddNS("AUTOMATED_UNDERWRITINGS"));
		underwritingDetail = new UnderwritingDetail((Element)getElementAddNS("UNDERWRITING_DETAIL"));
		
	}
}
