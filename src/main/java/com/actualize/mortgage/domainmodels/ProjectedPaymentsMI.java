package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * This defines Mortgage Insurance in Projected Payments
 * @author sboragala
 * @version 1.0
 */
public class ProjectedPaymentsMI implements Serializable {
		
	private static final long serialVersionUID = 5490856710267963123L;
	
	private String projectedPaymentMIPaymentAmount = "";

	/**
	 * @return the projectedPaymentMIPaymentAmount
	 */
	public String getProjectedPaymentMIPaymentAmount() {
		return projectedPaymentMIPaymentAmount;
	}

	/**
	 * @param projectedPaymentMIPaymentAmount the projectedPaymentMIPaymentAmount to set
	 */
	public void setProjectedPaymentMIPaymentAmount(String projectedPaymentMIPaymentAmount) {
		this.projectedPaymentMIPaymentAmount = projectedPaymentMIPaymentAmount;
	} 
	
	 
}
