package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines MaturityRule in MISMO XML
 * @author sboragala
 *
 */
public class MaturityRule extends MISMODataAccessObject {
	
	private static final long serialVersionUID = -2680112037891370710L;
	public final String loanMaturityPeriodCount;
	public final String loanMaturityPeriodType;
	public final String loanTermMaximumMonthsCount;

	public MaturityRule(Element element) {
		super(element);
		loanMaturityPeriodCount = getValueAddNS("LoanMaturityPeriodCount");
		loanMaturityPeriodType = getValueAddNS("LoanMaturityPeriodType");
		loanTermMaximumMonthsCount = getValueAddNS("LoanTermMaximumMonthsCount");
	}
}
