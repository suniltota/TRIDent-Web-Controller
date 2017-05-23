package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
/**
 * This class defines Estimated Total Payment for Projected Payments in JSON Response
 * @author sboragala
 *
 */
public class ProjectedPaymentsET implements Serializable {

	private static final long serialVersionUID = 3337686189596337094L;
	
	private String projectedPaymentEstimatedTotalMaximumPaymentAmount = "";
	private String projectedPaymentEstimatedTotalMinimumPaymentAmount = "";
	 
	/**
	 * @return the projectedPaymentEstimatedTotalMaximumPaymentAmount
	 */
	public String getProjectedPaymentEstimatedTotalMaximumPaymentAmount() {
		return projectedPaymentEstimatedTotalMaximumPaymentAmount;
	}
	/**
	 * @param projectedPaymentEstimatedTotalMaximumPaymentAmount the projectedPaymentEstimatedTotalMaximumPaymentAmount to set
	 */
	public void setProjectedPaymentEstimatedTotalMaximumPaymentAmount(
			String projectedPaymentEstimatedTotalMaximumPaymentAmount) {
		this.projectedPaymentEstimatedTotalMaximumPaymentAmount = projectedPaymentEstimatedTotalMaximumPaymentAmount;
	}
	/**
	 * @return the projectedPaymentEstimatedTotalMinimumPaymentAmount
	 */
	public String getProjectedPaymentEstimatedTotalMinimumPaymentAmount() {
		return projectedPaymentEstimatedTotalMinimumPaymentAmount;
	}
	/**
	 * @param projectedPaymentEstimatedTotalMinimumPaymentAmount the projectedPaymentEstimatedTotalMinimumPaymentAmount to set
	 */
	public void setProjectedPaymentEstimatedTotalMinimumPaymentAmount(
			String projectedPaymentEstimatedTotalMinimumPaymentAmount) {
		this.projectedPaymentEstimatedTotalMinimumPaymentAmount = projectedPaymentEstimatedTotalMinimumPaymentAmount;
	}

	 
}
