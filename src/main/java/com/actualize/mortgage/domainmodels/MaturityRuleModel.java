/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines MaturityRuleModel in JSON Response
 * @author sboragala
 *
 */
public class MaturityRuleModel implements Serializable {

	private static final long serialVersionUID = -415262829821954625L;
	
	private String loanMaturityPeriodCount;
	private String loanMaturityPeriodType;
	private String loanTermMaximumMonthsCount;
	
	/**
	 * @return the loanMaturityPeriodCount
	 */
	public String getLoanMaturityPeriodCount() {
		return loanMaturityPeriodCount;
	}
	/**
	 * @param loanMaturityPeriodCount the loanMaturityPeriodCount to set
	 */
	public void setLoanMaturityPeriodCount(String loanMaturityPeriodCount) {
		this.loanMaturityPeriodCount = loanMaturityPeriodCount;
	}
	/**
	 * @return the loanMaturityPeriodType
	 */
	public String getLoanMaturityPeriodType() {
		return loanMaturityPeriodType;
	}
	/**
	 * @param loanMaturityPeriodType the loanMaturityPeriodType to set
	 */
	public void setLoanMaturityPeriodType(String loanMaturityPeriodType) {
		this.loanMaturityPeriodType = loanMaturityPeriodType;
	}
	/**
	 * @return the loanTermMaximumMonthsCount
	 */
	public String getLoanTermMaximumMonthsCount() {
		return loanTermMaximumMonthsCount;
	}
	/**
	 * @param loanTermMaximumMonthsCount the loanTermMaximumMonthsCount to set
	 */
	public void setLoanTermMaximumMonthsCount(String loanTermMaximumMonthsCount) {
		this.loanTermMaximumMonthsCount = loanTermMaximumMonthsCount;
	}
	
	
}
