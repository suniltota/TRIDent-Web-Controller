package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;
/**
 * this class defines DueFromBorrowerAtClosing for SummariesofTransactions in JSON response
 * @author sboragala
 *
 */
public class SummariesofTransactionsDetailsDueFromBorrowerAtClosing implements Serializable{
	

	private static final long serialVersionUID = -7422950890798131710L;
	
	private String salePriceOfPersonalProperty;
	private IntegratedDisclosureSectionSummaryModel dueFromBorrowerAtClosingTotalAmount;
	
	/**
	 * @return the salePriceOfPersonalProperty
	 */
	public String getSalePriceOfPersonalProperty() {
		return salePriceOfPersonalProperty;
	}
	/**
	 * @param salePriceOfPersonalProperty the salePriceOfPersonalProperty to set
	 */
	public void setSalePriceOfPersonalProperty(String salePriceOfPersonalProperty) {
		this.salePriceOfPersonalProperty = salePriceOfPersonalProperty;
	}
	/**
	 * @return the dueFromBorrowerAtClosingTotalAmount
	 */
	public IntegratedDisclosureSectionSummaryModel getDueFromBorrowerAtClosingTotalAmount() {
		return dueFromBorrowerAtClosingTotalAmount;
	}
	/**
	 * @param dueFromBorrowerAtClosingTotalAmount the dueFromBorrowerAtClosingTotalAmount to set
	 */
	public void setDueFromBorrowerAtClosingTotalAmount(
			IntegratedDisclosureSectionSummaryModel dueFromBorrowerAtClosingTotalAmount) {
		this.dueFromBorrowerAtClosingTotalAmount = dueFromBorrowerAtClosingTotalAmount;
	}
	
	
	
}
