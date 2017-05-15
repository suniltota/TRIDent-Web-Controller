package com.actualize.mortgage.ledatamodels;

import java.io.Serializable;

import com.actualize.mortgage.domainmodels.IntegratedDisclosureSectionSummaryModel;
import com.actualize.mortgage.domainmodels.LiabilityModel;

/**
 *  defines PayoffsAndPayments in JSON response
 * @author sboragala
 *
 */
public class PayoffsAndPayments implements Serializable {


	private static final long serialVersionUID = 422836147116062115L;
	
	private boolean useLiability;
	private LiabilityModel liability;
	private IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummary;
	
	/**
	 * @return the useLiability
	 */
	public boolean isUseLiability() {
		return useLiability;
	}
	/**
	 * @param useLiability the useLiability to set
	 */
	public void setUseLiability(boolean useLiability) {
		this.useLiability = useLiability;
	}
	/**
	 * @return the liability
	 */
	public LiabilityModel getLiability() {
		return liability;
	}
	/**
	 * @param liability the liability to set
	 */
	public void setLiability(LiabilityModel liability) {
		this.liability = liability;
	}
	/**
	 * @return the integratedDisclosureSectionSummary
	 */
	public IntegratedDisclosureSectionSummaryModel getIntegratedDisclosureSectionSummary() {
		return integratedDisclosureSectionSummary;
	}
	/**
	 * @param integratedDisclosureSectionSummary the integratedDisclosureSectionSummary to set
	 */
	public void setIntegratedDisclosureSectionSummary(
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummary) {
		this.integratedDisclosureSectionSummary = integratedDisclosureSectionSummary;
	}
	
	
}
