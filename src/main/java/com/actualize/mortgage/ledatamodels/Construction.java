package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class Construction extends MISMODataAccessObject {
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
