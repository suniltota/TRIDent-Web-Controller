package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines Construction in MISMO XML
 * @author sboragala
 *
 */
public class Construction extends MISMODataAccessObject {

	private static final long serialVersionUID = -2494620292431299407L;
	public final String constructionLoanTotalTermMonthsCount;
	public final String constructionLoanType;
	public final String constructionPeriodNumberOfMonthsCount;

	public Construction(Element element) {
		super(element);
		constructionLoanTotalTermMonthsCount = getValueAddNS("ConstructionLoanTotalTermMonthsCount");
		constructionLoanType = getValueAddNS("ConstructionLoanType");
		constructionPeriodNumberOfMonthsCount = getValueAddNS("ConstructionPeriodNumberOfMonthsCount");
	}
}
