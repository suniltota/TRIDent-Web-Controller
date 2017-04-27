package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 *  this class represents PropertyValuationDetail in JSON response
 * @author sboragala
 *
 */
public class PropertyValuationDetailModel implements Serializable {
	
	private static final long serialVersionUID = -4243667995030954693L;
	
	private String propertyEstimatedValueAmount;
	private String propertyValuationAmount;
	private String propertyValuationMethodType; //refin
	private String propertyValuationMethodTypeOtherDescription;
	private String propertyValue;
	
	/**
	 * @return the propertyEstimatedValueAmount
	 */
	public String getPropertyEstimatedValueAmount() {
		return propertyEstimatedValueAmount;
	}
	/**
	 * @param propertyEstimatedValueAmount the propertyEstimatedValueAmount to set
	 */
	public void setPropertyEstimatedValueAmount(String propertyEstimatedValueAmount) {
		this.propertyEstimatedValueAmount = propertyEstimatedValueAmount;
	}
	/**
	 * @return the propertyValuationAmount
	 */
	public String getPropertyValuationAmount() {
		return propertyValuationAmount;
	}
	/**
	 * @param propertyValuationAmount the propertyValuationAmount to set
	 */
	public void setPropertyValuationAmount(String propertyValuationAmount) {
		this.propertyValuationAmount = propertyValuationAmount;
	}
	/**
	 * @return the propertyValuationMethodType
	 */
	public String getPropertyValuationMethodType() {
		return propertyValuationMethodType;
	}
	/**
	 * @param propertyValuationMethodType the propertyValuationMethodType to set
	 */
	public void setPropertyValuationMethodType(String propertyValuationMethodType) {
		this.propertyValuationMethodType = propertyValuationMethodType;
	}
	/**
	 * @return the propertyValuationMethodTypeOtherDescription
	 */
	public String getPropertyValuationMethodTypeOtherDescription() {
		return propertyValuationMethodTypeOtherDescription;
	}
	/**
	 * @param propertyValuationMethodTypeOtherDescription the propertyValuationMethodTypeOtherDescription to set
	 */
	public void setPropertyValuationMethodTypeOtherDescription(String propertyValuationMethodTypeOtherDescription) {
		this.propertyValuationMethodTypeOtherDescription = propertyValuationMethodTypeOtherDescription;
	}
	/**
	 * @return the propertyValue
	 */
	public String getPropertyValue() {
		return propertyValue;
	}
	/**
	 * @param propertyValue the propertyValue to set
	 */
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	
	
}
