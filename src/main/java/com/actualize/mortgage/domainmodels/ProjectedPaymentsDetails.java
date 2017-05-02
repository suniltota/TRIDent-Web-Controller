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
	private boolean isMIRequired;
	private String miMonthsDuration;
	private String miSTDate;
	private String miCompanyName;
	private String miCompanyNameOtherDescription;
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
	 * @return the isMIRequired
	 */
	public boolean isMIRequired() {
		return isMIRequired;
	}
	/**
	 * @param isMIRequired the isMIRequired to set
	 */
	public void setMIRequired(boolean isMIRequired) {
		this.isMIRequired = isMIRequired;
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
	 * @return the miSTDate
	 */
	public String getMiSTDate() {
		return miSTDate;
	}
	/**
	 * @param miSTDate the miSTDate to set
	 */
	public void setMiSTDate(String miSTDate) {
		this.miSTDate = miSTDate;
	}
	/**
	 * @return the miCompanyName
	 */
	public String getMiCompanyName() {
		return miCompanyName;
	}
	/**
	 * @param miCompanyName the miCompanyName to set
	 */
	public void setMiCompanyName(String miCompanyName) {
		this.miCompanyName = miCompanyName;
	}
	/**
	 * @return the miCompanyNameOtherDescription
	 */
	public String getMiCompanyNameOtherDescription() {
		return miCompanyNameOtherDescription;
	}
	/**
	 * @param miCompanyNameOtherDescription the miCompanyNameOtherDescription to set
	 */
	public void setMiCompanyNameOtherDescription(String miCompanyNameOtherDescription) {
		this.miCompanyNameOtherDescription = miCompanyNameOtherDescription;
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
