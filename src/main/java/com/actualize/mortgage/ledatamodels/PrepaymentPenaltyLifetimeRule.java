package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines PrepaymentPenaltyLifetimeRule in MISMO XML
 * @author sboragala
 *
 */
public class PrepaymentPenaltyLifetimeRule extends MISMODataAccessObject {
	private static final long serialVersionUID = 6454447215728990189L;
	public final String prepaymentPenaltyExpirationDate;
	public final String prepaymentPenaltyExpirationMonthsCount;
	public final String prepaymentPenaltyMaximumLifeOfLoanAmount;
	
	public PrepaymentPenaltyLifetimeRule(Element element) {
		super(element);
		prepaymentPenaltyExpirationDate = getValueAddNS("PrepaymentPenaltyExpirationDate");
		prepaymentPenaltyExpirationMonthsCount = getValueAddNS("PrepaymentPenaltyExpirationMonthsCount");
		prepaymentPenaltyMaximumLifeOfLoanAmount = getValueAddNS("PrepaymentPenaltyMaximumLifeOfLoanAmount");
	}
}
