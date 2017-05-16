package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * this class defines ProjectedPayments details in JSON Response
 * @author sboragala
 *
 */
public class ProjectedPaymentsDetails implements Serializable{
	
	private static final long serialVersionUID = 5298423138196096381L;
	
	private String paymentFrequencyType;
	@JsonProperty("paymentCalculation")
	private List<ProjectedPaymentsPC>  paymentCalculation;
	@JsonProperty("principalInterest")
	private List<ProjectedPaymentsPI>  principalInterest;
	@JsonProperty("mortgageInsurance")
	private List<ProjectedPaymentsMI>  mortgageInsurance;
	private String miMonthsDuration;
	@JsonProperty("estimatedEscrow")
	private List<ProjectedPaymentsEE>  estimatedEscrow;
	@JsonProperty("estimatedTotal")
	private List<ProjectedPaymentsET>  estimatedTotal;
	
	/**
	 * @return the paymentFrequencyType
	 */
	public String getPaymentFrequencyType() {
		return paymentFrequencyType;
	}
	/**
	 * @param paymentFrequencyType the paymentFrequencyType to set
	 */
	public void setPaymentFrequencyType(String paymentFrequencyType) {
		this.paymentFrequencyType = paymentFrequencyType;
	}
	/**
	 * @return the paymentCalculation
	 */
	public List<ProjectedPaymentsPC> getPaymentCalculation() {
		return paymentCalculation;
	}
	/**
	 * @param paymentCalculation the paymentCalculation to set
	 */
	public void setPaymentCalculation(List<ProjectedPaymentsPC> paymentCalculation) {
		this.paymentCalculation = paymentCalculation;
	}
	/**
	 * @return the principalInterest
	 */
	public List<ProjectedPaymentsPI> getPrincipalInterest() {
		return principalInterest;
	}
	/**
	 * @param principalInterest the principalInterest to set
	 */
	public void setPrincipalInterest(List<ProjectedPaymentsPI> principalInterest) {
		this.principalInterest = principalInterest;
	}
	/**
	 * @return the mortgageInsurance
	 */
	public List<ProjectedPaymentsMI> getMortgageInsurance() {
		return mortgageInsurance;
	}
	/**
	 * @param mortgageInsurance the mortgageInsurance to set
	 */
	public void setMortgageInsurance(List<ProjectedPaymentsMI> mortgageInsurance) {
		this.mortgageInsurance = mortgageInsurance;
	}
	/**
	 * @return the miMonthsDuration
	 */
	public String getMiMonthsDuration() {
		return miMonthsDuration;
	}
	/**
	 * @param miMonthsDuration the miMonthsDuration to set
	 */
	public void setMiMonthsDuration(String miMonthsDuration) {
		this.miMonthsDuration = miMonthsDuration;
	}
	/**
	 * @return the estimatedEscrow
	 */
	public List<ProjectedPaymentsEE> getEstimatedEscrow() {
		return estimatedEscrow;
	}
	/**
	 * @param estimatedEscrow the estimatedEscrow to set
	 */
	public void setEstimatedEscrow(List<ProjectedPaymentsEE> estimatedEscrow) {
		this.estimatedEscrow = estimatedEscrow;
	}
	/**
	 * @return the estimatedTotal
	 */
	public List<ProjectedPaymentsET> getEstimatedTotal() {
		return estimatedTotal;
	}
	/**
	 * @param estimatedTotal the estimatedTotal to set
	 */
	public void setEstimatedTotal(List<ProjectedPaymentsET> estimatedTotal) {
		this.estimatedTotal = estimatedTotal;
	}
	
	
}
