package com.actualize.mortgage.ledatamodels;

import java.io.Serializable;

/**
 *  defines PayoffsAndPayments in JSON response
 * @author sboragala
 *
 */
public class PayoffsAndPayments implements Serializable {


	private static final long serialVersionUID = 422836147116062115L;

	private IntegratedDisclosureSectionSummary integratedDisclosureSectionSummary;

	/**
	 * @return the integratedDisclosureSectionSummary
	 */
	public IntegratedDisclosureSectionSummary getIntegratedDisclosureSectionSummary() {
		return integratedDisclosureSectionSummary;
	}

	/**
	 * @param integratedDisclosureSectionSummary the integratedDisclosureSectionSummary to set
	 */
	public void setIntegratedDisclosureSectionSummary(
			IntegratedDisclosureSectionSummary integratedDisclosureSectionSummary) {
		this.integratedDisclosureSectionSummary = integratedDisclosureSectionSummary;
	}
	
	
	
}
