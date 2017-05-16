package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 * defines UnderwritingDetail in MISMO XML
 * @author sboragala
 *
 */
public class UnderwritingDetail extends MISMODataAccessObject{

	private static final long serialVersionUID = 5834552202933231788L;
	public final String loanManualUnderwritingIndicator;
	
	protected UnderwritingDetail(Element e) {
		super(e);
		loanManualUnderwritingIndicator = getValueAddNS("LoanManualUnderwritingIndicator");
	}

}
