package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class PropertyValuationDetailModel implements Serializable {
	
	private static final long serialVersionUID = -4243667995030954693L;
	
	private String propertyEstimatedValueAmount;
	private String propertyValuationAmount;
	private String propertyValuationMethodType; //refin
	private String propertyValuationMethodTypeOtherDescription;
	
	public String getPropertyEstimatedValueAmount() {
		return propertyEstimatedValueAmount;
	}
	public void setPropertyEstimatedValueAmount(String propertyEstimatedValueAmount) {
		this.propertyEstimatedValueAmount = propertyEstimatedValueAmount;
	}
	public String getPropertyValuationAmount() {
		return propertyValuationAmount;
	}
	public void setPropertyValuationAmount(String propertyValuationAmount) {
		this.propertyValuationAmount = propertyValuationAmount;
	}
	public String getPropertyValuationMethodType() {
		return propertyValuationMethodType;
	}
	public void setPropertyValuationMethodType(String propertyValuationMethodType) {
		this.propertyValuationMethodType = propertyValuationMethodType;
	}
	public String getPropertyValuationMethodTypeOtherDescription() {
		return propertyValuationMethodTypeOtherDescription;
	}
	public void setPropertyValuationMethodTypeOtherDescription(String propertyValuationMethodTypeOtherDescription) {
		this.propertyValuationMethodTypeOtherDescription = propertyValuationMethodTypeOtherDescription;
	}

}
