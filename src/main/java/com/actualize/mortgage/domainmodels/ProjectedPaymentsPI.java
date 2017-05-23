package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class ProjectedPaymentsPI implements Serializable {

	private static final long serialVersionUID = -773708562272145688L;
	
	private String projectedPaymentPrincipalAndInterestMaximumPaymentAmount = "";
    private String projectedPaymentPrincipalAndInterestMinimumPaymentAmount = "";
    private boolean interestOnlyStatus = false;
    
	/**
	 * @return the projectedPaymentPrincipalAndInterestMaximumPaymentAmount
	 */
	public String getProjectedPaymentPrincipalAndInterestMaximumPaymentAmount() {
		return projectedPaymentPrincipalAndInterestMaximumPaymentAmount;
	}
	/**
	 * @param projectedPaymentPrincipalAndInterestMaximumPaymentAmount the projectedPaymentPrincipalAndInterestMaximumPaymentAmount to set
	 */
	public void setProjectedPaymentPrincipalAndInterestMaximumPaymentAmount(
			String projectedPaymentPrincipalAndInterestMaximumPaymentAmount) {
		this.projectedPaymentPrincipalAndInterestMaximumPaymentAmount = projectedPaymentPrincipalAndInterestMaximumPaymentAmount;
	}
	/**
	 * @return the projectedPaymentPrincipalAndInterestMinimumPaymentAmount
	 */
	public String getProjectedPaymentPrincipalAndInterestMinimumPaymentAmount() {
		return projectedPaymentPrincipalAndInterestMinimumPaymentAmount;
	}
	/**
	 * @param projectedPaymentPrincipalAndInterestMinimumPaymentAmount the projectedPaymentPrincipalAndInterestMinimumPaymentAmount to set
	 */
	public void setProjectedPaymentPrincipalAndInterestMinimumPaymentAmount(
			String projectedPaymentPrincipalAndInterestMinimumPaymentAmount) {
		this.projectedPaymentPrincipalAndInterestMinimumPaymentAmount = projectedPaymentPrincipalAndInterestMinimumPaymentAmount;
	}
	/**
	 * @return the interestOnlyStatus
	 */
	public boolean isInterestOnlyStatus() {
		return interestOnlyStatus;
	}
	/**
	 * @param interestOnlyStatus the interestOnlyStatus to set
	 */
	public void setInterestOnlyStatus(boolean interestOnlyStatus) {
		this.interestOnlyStatus = interestOnlyStatus;
	}
    
    
	
}
