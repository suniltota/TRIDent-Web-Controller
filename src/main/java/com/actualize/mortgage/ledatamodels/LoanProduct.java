package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * defines loan product in MISMO XML
 * @author sboragala
 *
 */
public class LoanProduct extends MISMODataAccessObject {

	private static final long serialVersionUID = -188948636323407864L;
	public final String loanPriceQuoteInterestRatePercent;
	public LoanProduct(String NS, Element element) {
		super(element);
		loanPriceQuoteInterestRatePercent = getValueAddNS("LOAN_PRICE_QUOTES/LOAN_PRICE_QUOTE/LOAN_PRICE_QUOTE_DETAIL/LoanPriceQuoteInterestRatePercent");
	}
}
