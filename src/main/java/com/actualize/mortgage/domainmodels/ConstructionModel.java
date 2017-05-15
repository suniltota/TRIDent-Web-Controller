/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines ConstructionModel in JSON Response
 * @author sboragala
 *
 */
public class ConstructionModel implements Serializable {

	private static final long serialVersionUID = -469430393306010568L;
	
	private String constructionLoanTotalTermMonthsCount;
	private String constructionLoanType;
	private String constructionPeriodNumberOfMonthsCount;
	/**
	 * @return the constructionLoanTotalTermMonthsCount
	 */
	public String getConstructionLoanTotalTermMonthsCount() {
		return constructionLoanTotalTermMonthsCount;
	}
	/**
	 * @param constructionLoanTotalTermMonthsCount the constructionLoanTotalTermMonthsCount to set
	 */
	public void setConstructionLoanTotalTermMonthsCount(String constructionLoanTotalTermMonthsCount) {
		this.constructionLoanTotalTermMonthsCount = constructionLoanTotalTermMonthsCount;
	}
	/**
	 * @return the constructionLoanType
	 */
	public String getConstructionLoanType() {
		return constructionLoanType;
	}
	/**
	 * @param constructionLoanType the constructionLoanType to set
	 */
	public void setConstructionLoanType(String constructionLoanType) {
		this.constructionLoanType = constructionLoanType;
	}
	/**
	 * @return the constructionPeriodNumberOfMonthsCount
	 */
	public String getConstructionPeriodNumberOfMonthsCount() {
		return constructionPeriodNumberOfMonthsCount;
	}
	/**
	 * @param constructionPeriodNumberOfMonthsCount the constructionPeriodNumberOfMonthsCount to set
	 */
	public void setConstructionPeriodNumberOfMonthsCount(String constructionPeriodNumberOfMonthsCount) {
		this.constructionPeriodNumberOfMonthsCount = constructionPeriodNumberOfMonthsCount;
	}
	
	
}
