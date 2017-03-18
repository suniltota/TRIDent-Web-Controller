package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ProjectedPayments implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 5490856710267963123L;
	
	@JsonProperty("paymentCalculation")
	private List<String> projectedPaymentsPaymentCalculation;
	@JsonProperty("principalInterest")
	private List<ProjectedPaymentsPI> projectedPaymentsPrincipalInterest;
	@JsonProperty("mortgageInsurance")
	private List<String> projectedPaymentsMortgageInsurance;
	@JsonProperty("estimatedEscrow")
	private List<String> projectedPaymentsEstimatedEscrow;
	@JsonProperty("estimatedTotalPayment")
	private List<String> projectedPaymentsEstimatedTotalPayment;
	@JsonProperty("estimatedTotalPaymentType")
	private String projectedPaymentsEstimatedTotalPaymentType;
	@JsonProperty("etia")
	private ProjectedPaymentsETIA projectedPaymentsETIA;
	

	/**
	 * @return the projectedPaymentsPaymentCalculation
	 */
	public List<String> getProjectedPaymentsPaymentCalculation() {
		return projectedPaymentsPaymentCalculation;
	}

	/**
	 * @param projectedPaymentsPaymentCalculation the projectedPaymentsPaymentCalculation to set
	 */
	public void setProjectedPaymentsPaymentCalculation(List<String> projectedPaymentsPaymentCalculation) {
		this.projectedPaymentsPaymentCalculation = projectedPaymentsPaymentCalculation;
	}

	/**
	 * @return the projectedPaymentsPrincipalInterest
	 */
	public List<ProjectedPaymentsPI> getProjectedPaymentsPrincipalInterest() {
		return projectedPaymentsPrincipalInterest;
	}

	/**
	 * @param projectedPaymentsPrincipalInterest the projectedPaymentsPrincipalInterest to set
	 */
	public void setProjectedPaymentsPrincipalInterest(List<ProjectedPaymentsPI> projectedPaymentsPrincipalInterest) {
		this.projectedPaymentsPrincipalInterest = projectedPaymentsPrincipalInterest;
	}

	/**
	 * @return the projectedPaymentsMortgageInsurance
	 */
	public List<String> getProjectedPaymentsMortgageInsurance() {
		return projectedPaymentsMortgageInsurance;
	}

	/**
	 * @param projectedPaymentsMortgageInsurance the projectedPaymentsMortgageInsurance to set
	 */
	public void setProjectedPaymentsMortgageInsurance(List<String> projectedPaymentsMortgageInsurance) {
		this.projectedPaymentsMortgageInsurance = projectedPaymentsMortgageInsurance;
	}

	/**
	 * @return the projectedPaymentsEstimatedEscrow
	 */
	public List<String> getProjectedPaymentsEstimatedEscrow() {
		return projectedPaymentsEstimatedEscrow;
	}

	/**
	 * @param projectedPaymentsEstimatedEscrow the projectedPaymentsEstimatedEscrow to set
	 */
	public void setProjectedPaymentsEstimatedEscrow(List<String> projectedPaymentsEstimatedEscrow) {
		this.projectedPaymentsEstimatedEscrow = projectedPaymentsEstimatedEscrow;
	}

	/**
	 * @return the projectedPaymentsEstimatedTotalPayment
	 */
	public List<String> getProjectedPaymentsEstimatedTotalPayment() {
		return projectedPaymentsEstimatedTotalPayment;
	}

	/**
	 * @param projectedPaymentsEstimatedTotalPayment the projectedPaymentsEstimatedTotalPayment to set
	 */
	public void setProjectedPaymentsEstimatedTotalPayment(List<String> projectedPaymentsEstimatedTotalPayment) {
		this.projectedPaymentsEstimatedTotalPayment = projectedPaymentsEstimatedTotalPayment;
	}

	/**
	 * @return the projectedPaymentsEstimatedTotalPaymentType
	 */
	public String getProjectedPaymentsEstimatedTotalPaymentType() {
		return projectedPaymentsEstimatedTotalPaymentType;
	}

	/**
	 * @param projectedPaymentsEstimatedTotalPaymentType the projectedPaymentsEstimatedTotalPaymentType to set
	 */
	public void setProjectedPaymentsEstimatedTotalPaymentType(String projectedPaymentsEstimatedTotalPaymentType) {
		this.projectedPaymentsEstimatedTotalPaymentType = projectedPaymentsEstimatedTotalPaymentType;
	}

	/**
	 * @return the projectedPaymentsETIA
	 */
	public ProjectedPaymentsETIA getProjectedPaymentsETIA() {
		return projectedPaymentsETIA;
	}

	/**
	 * @param projectedPaymentsETIA the projectedPaymentsETIA to set
	 */
	public void setProjectedPaymentsETIA(ProjectedPaymentsETIA projectedPaymentsETIA) {
		this.projectedPaymentsETIA = projectedPaymentsETIA;
	}
}
