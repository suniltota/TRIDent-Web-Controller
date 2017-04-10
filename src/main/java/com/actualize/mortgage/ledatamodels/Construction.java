package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class Construction extends MISMODataAccessObject {
	public final String ConstructionLoanTotalTermMonthsCount;
	public final String ConstructionLoanType;
	public final String ConstructionPeriodNumberOfMonthsCount;

	public Construction(Element element) {
		super(element);
		ConstructionLoanTotalTermMonthsCount = getValueAddNS("ConstructionLoanTotalTermMonthsCount");
		ConstructionLoanType = getValueAddNS("ConstructionLoanType");
		ConstructionPeriodNumberOfMonthsCount = getValueAddNS("ConstructionPeriodNumberOfMonthsCount");
	}
}
