package com.actualize.mortgage.domainmodels;

public class ProjectedPaymentsPI {
	private String minValue;
	private String maxValue;
	private String interestOnly;
	
	/**
	 * @return the minValue
	 */
	public String getMinValue() {
		return minValue;
	}
	/**
	 * @param minValue the minValue to set
	 */
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}
	/**
	 * @return the maxValue
	 */
	public String getMaxValue() {
		return maxValue;
	}
	/**
	 * @param maxValue the maxValue to set
	 */
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}
	/**
	 * @return the interestOnly
	 */
	public String getInterestOnly() {
		return interestOnly;
	}
	/**
	 * @param interestOnly the interestOnly to set
	 */
	public void setInterestOnly(String interestOnly) {
		this.interestOnly = interestOnly;
	}

}
