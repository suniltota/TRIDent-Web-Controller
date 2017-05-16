/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines InterestOnly in JSON response
 * @author sboragala
 *
 */
public class InterestOnlyModel implements Serializable {

	private static final long serialVersionUID = 4104248143814883458L;
	
	private String interestOnlyTermMonthsCount;

	/**
	 * @return the interestOnlyTermMonthsCount
	 */
	public String getInterestOnlyTermMonthsCount() {
		return interestOnlyTermMonthsCount;
	}

	/**
	 * @param interestOnlyTermMonthsCount the interestOnlyTermMonthsCount to set
	 */
	public void setInterestOnlyTermMonthsCount(String interestOnlyTermMonthsCount) {
		this.interestOnlyTermMonthsCount = interestOnlyTermMonthsCount;
	}
	
}
