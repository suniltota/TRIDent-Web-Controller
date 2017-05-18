/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines LoanCalculationModel in JSON Response
 * @author sboragala
 *
 */
public class LoanCalculationModel implements Serializable {

	private static final long serialVersionUID = -4301427738949561131L;
	
	private String aprPercent;
    private String feeSummaryTotalAmountFinancedAmount;
    private String feeSummaryTotalFinanceChargeAmount;
    private String feeSummaryTotalInterestPercent;
    private String feeSummaryTotalOfAllPaymentsAmount;
    private boolean deficiencyRightsPreservedIndicator;
    
	/**
	 * @return the aprPercent
	 */
	public String getAprPercent() {
		return aprPercent;
	}
	/**
	 * @param aprPercent the aprPercent to set
	 */
	public void setAprPercent(String aprPercent) {
		this.aprPercent = aprPercent;
	}
	/**
	 * @return the feeSummaryTotalAmountFinancedAmount
	 */
	public String getFeeSummaryTotalAmountFinancedAmount() {
		return feeSummaryTotalAmountFinancedAmount;
	}
	/**
	 * @param feeSummaryTotalAmountFinancedAmount the feeSummaryTotalAmountFinancedAmount to set
	 */
	public void setFeeSummaryTotalAmountFinancedAmount(String feeSummaryTotalAmountFinancedAmount) {
		this.feeSummaryTotalAmountFinancedAmount = feeSummaryTotalAmountFinancedAmount;
	}
	/**
	 * @return the feeSummaryTotalFinanceChargeAmount
	 */
	public String getFeeSummaryTotalFinanceChargeAmount() {
		return feeSummaryTotalFinanceChargeAmount;
	}
	/**
	 * @param feeSummaryTotalFinanceChargeAmount the feeSummaryTotalFinanceChargeAmount to set
	 */
	public void setFeeSummaryTotalFinanceChargeAmount(String feeSummaryTotalFinanceChargeAmount) {
		this.feeSummaryTotalFinanceChargeAmount = feeSummaryTotalFinanceChargeAmount;
	}
	/**
	 * @return the feeSummaryTotalInterestPercent
	 */
	public String getFeeSummaryTotalInterestPercent() {
		return feeSummaryTotalInterestPercent;
	}
	/**
	 * @param feeSummaryTotalInterestPercent the feeSummaryTotalInterestPercent to set
	 */
	public void setFeeSummaryTotalInterestPercent(String feeSummaryTotalInterestPercent) {
		this.feeSummaryTotalInterestPercent = feeSummaryTotalInterestPercent;
	}
	/**
	 * @return the feeSummaryTotalOfAllPaymentsAmount
	 */
	public String getFeeSummaryTotalOfAllPaymentsAmount() {
		return feeSummaryTotalOfAllPaymentsAmount;
	}
	/**
	 * @param feeSummaryTotalOfAllPaymentsAmount the feeSummaryTotalOfAllPaymentsAmount to set
	 */
	public void setFeeSummaryTotalOfAllPaymentsAmount(String feeSummaryTotalOfAllPaymentsAmount) {
		this.feeSummaryTotalOfAllPaymentsAmount = feeSummaryTotalOfAllPaymentsAmount;
	}
	/**
	 * @return the deficiencyRightsPreservedIndicator
	 */
	public boolean isDeficiencyRightsPreservedIndicator() {
		return deficiencyRightsPreservedIndicator;
	}
	/**
	 * @param deficiencyRightsPreservedIndicator the deficiencyRightsPreservedIndicator to set
	 */
	public void setDeficiencyRightsPreservedIndicator(boolean deficiencyRightsPreservedIndicator) {
		this.deficiencyRightsPreservedIndicator = deficiencyRightsPreservedIndicator;
	}
	
}
