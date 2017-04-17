package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
/**
 * 
 * @author sboragala
 *
 */
public class ProjectedPaymentsETIA implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8631045707264453095L;
	
	private String amount;
	private String frequencyType;
	private String propertyTaxesStatus;
	private String homeownersInsuranceStatus;
	private String otherStatus;
	private String otherDescription;
	private String propertyTaxesInEscrow;
	private String homeownersInsuranceInEscrow;
	private String otherInEscrow;
	
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @return the frequencyType
	 */
	public String getFrequencyType() {
		return frequencyType;
	}
	/**
	 * @param frequencyType the frequencyType to set
	 */
	public void setFrequencyType(String frequencyType) {
		this.frequencyType = frequencyType;
	}
	/**
	 * @return the propertyTaxesStatus
	 */
	public String getPropertyTaxesStatus() {
		return propertyTaxesStatus;
	}
	/**
	 * @param propertyTaxesStatus the propertyTaxesStatus to set
	 */
	public void setPropertyTaxesStatus(String propertyTaxesStatus) {
		this.propertyTaxesStatus = propertyTaxesStatus;
	}
	/**
	 * @return the homeownersInsuranceStatus
	 */
	public String getHomeownersInsuranceStatus() {
		return homeownersInsuranceStatus;
	}
	/**
	 * @param homeownersInsuranceStatus the homeownersInsuranceStatus to set
	 */
	public void setHomeownersInsuranceStatus(String homeownersInsuranceStatus) {
		this.homeownersInsuranceStatus = homeownersInsuranceStatus;
	}
	/**
	 * @return the otherStatus
	 */
	public String getOtherStatus() {
		return otherStatus;
	}
	/**
	 * @param otherStatus the otherStatus to set
	 */
	public void setOtherStatus(String otherStatus) {
		this.otherStatus = otherStatus;
	}
	/**
	 * @return the otherDescription
	 */
	public String getOtherDescription() {
		return otherDescription;
	}
	/**
	 * @param otherDescription the otherDescription to set
	 */
	public void setOtherDescription(String otherDescription) {
		this.otherDescription = otherDescription;
	}
	/**
	 * @return the propertyTaxesInEscrow
	 */
	public String getPropertyTaxesInEscrow() {
		return propertyTaxesInEscrow;
	}
	/**
	 * @param propertyTaxesInEscrow the propertyTaxesInEscrow to set
	 */
	public void setPropertyTaxesInEscrow(String propertyTaxesInEscrow) {
		this.propertyTaxesInEscrow = propertyTaxesInEscrow;
	}
	/**
	 * @return the homeownersInsuranceInEscrow
	 */
	public String getHomeownersInsuranceInEscrow() {
		return homeownersInsuranceInEscrow;
	}
	/**
	 * @param homeownersInsuranceInEscrow the homeownersInsuranceInEscrow to set
	 */
	public void setHomeownersInsuranceInEscrow(String homeownersInsuranceInEscrow) {
		this.homeownersInsuranceInEscrow = homeownersInsuranceInEscrow;
	}
	/**
	 * @return the otherInEscrow
	 */
	public String getOtherInEscrow() {
		return otherInEscrow;
	}
	/**
	 * @param otherInEscrow the otherInEscrow to set
	 */
	public void setOtherInEscrow(String otherInEscrow) {
		this.otherInEscrow = otherInEscrow;
	}
	
}
