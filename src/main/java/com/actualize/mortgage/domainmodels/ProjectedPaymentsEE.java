/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * This class defines Estimated Escrow of Projected Payments in JSON Reponse 
 * @author sboragala
 *
 */
public class ProjectedPaymentsEE implements Serializable{

	private static final long serialVersionUID = -3833721422110952372L;
	
	private String projectedPaymentEstimatedEscrowPaymentAmount = "";
	

	/**
	 * @return the projectedPaymentEstimatedEscrowPaymentAmount
	 */
	public String getProjectedPaymentEstimatedEscrowPaymentAmount() {
		return projectedPaymentEstimatedEscrowPaymentAmount;
	}

	/**
	 * @param projectedPaymentEstimatedEscrowPaymentAmount the projectedPaymentEstimatedEscrowPaymentAmount to set
	 */
	public void setProjectedPaymentEstimatedEscrowPaymentAmount(String projectedPaymentEstimatedEscrowPaymentAmount) {
		this.projectedPaymentEstimatedEscrowPaymentAmount = projectedPaymentEstimatedEscrowPaymentAmount;
	}

}
