package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
/**
 * 
 * @author sboragala
 *
 */
public class ClosingInformationModel implements Serializable {
	
	private static final long serialVersionUID = 8557982875024822649L;
	
	private String dateIssued;
	private AddressModel property;
	private PropertyValuationDetailModel propertyValuationDetail;
	/**
	 * @return the dateIssued
	 */
	public String getDateIssued() {
		return dateIssued;
	}
	/**
	 * @param dateIssued the dateIssued to set
	 */
	public void setDateIssued(String dateIssued) {
		this.dateIssued = dateIssued;
	}
	/**
	 * @return the property
	 */
	public AddressModel getProperty() {
		return property;
	}
	/**
	 * @param property the property to set
	 */
	public void setProperty(AddressModel property) {
		this.property = property;
	}
	/**
	 * @return the propertyValuationDetail
	 */
	public PropertyValuationDetailModel getPropertyValuationDetail() {
		return propertyValuationDetail;
	}
	/**
	 * @param propertyValuationDetail the propertyValuationDetail to set
	 */
	public void setPropertyValuationDetail(PropertyValuationDetailModel propertyValuationDetail) {
		this.propertyValuationDetail = propertyValuationDetail;
	}
	
	
}
