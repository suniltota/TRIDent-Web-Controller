package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * defines FeeSummaryDetail in MISMO XML
 * @author sboragala
 *
 */
public class FeeSummaryDetail extends MISMODataAccessObject {
	public final String aprPercent;
	public final String feeSummaryTotalAmountFinancedAmount;
	public final String feeSummaryTotalFinanceChargeAmount;
	public final String feeSummaryTotalInterestPercent;
	public final String feeSummaryTotalOfAllPaymentsAmount;
	
	public FeeSummaryDetail(Element element) {
		super(element);
		aprPercent = getValueAddNS("APRPercent");
		feeSummaryTotalAmountFinancedAmount = getValueAddNS("FeeSummaryTotalAmountFinancedAmount");
		feeSummaryTotalFinanceChargeAmount = getValueAddNS("FeeSummaryTotalFinanceChargeAmount");
		feeSummaryTotalInterestPercent = getValueAddNS("FeeSummaryTotalInterestPercent");
		feeSummaryTotalOfAllPaymentsAmount = getValueAddNS("FeeSummaryTotalOfAllPaymentsAmount");
	}
}
