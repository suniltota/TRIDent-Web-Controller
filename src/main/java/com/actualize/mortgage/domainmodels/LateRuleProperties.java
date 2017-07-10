/**
 * 
 */
package com.actualize.mortgage.domainmodels;

/**
 * @author sboragala
 *
 */
public class LateRuleProperties {

	private String comparand;
	private double lowerLimit;
	
	private double upperLimit;
	/**
	 * @return the comparand
	 */
	public String getComparand() {
		return comparand;
	}
	/**
	 * @param comparand the comparand to set
	 */
	public void setComparand(String comparand) {
		this.comparand = comparand;
	}
	/**
	 * @return the lowerLimit
	 */
	public double getLowerLimit() {
		return lowerLimit;
	}
	/**
	 * @param lowerLimit the lowerLimit to set
	 */
	public void setLowerLimit(double lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	/**
	 * @return the upperLimit
	 */
	public double getUpperLimit() {
		return upperLimit;
	}
	/**
	 * @param upperLimit the upperLimit to set
	 */
	public void setUpperLimit(double upperLimit) {
		this.upperLimit = upperLimit;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LateRuleProperties [comparand=" + comparand + ", lowerLimit=" + lowerLimit + ", upperLimit="
				+ upperLimit + "]";
	}
}
