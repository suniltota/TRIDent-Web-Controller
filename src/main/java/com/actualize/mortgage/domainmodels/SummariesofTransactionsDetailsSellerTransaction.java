/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * defines Seller Transaction for  Summaries of Transactions in JSON response 
 * @author sboragala
 *
 */
public class SummariesofTransactionsDetailsSellerTransaction implements Serializable {

	private static final long serialVersionUID = 7135974335217469384L;
	
	private IntegratedDisclosureSectionSummaryModel toSellerAtClosing = new IntegratedDisclosureSectionSummaryModel();
	private IntegratedDisclosureSectionSummaryModel fromSellerAtClosing = new IntegratedDisclosureSectionSummaryModel();
	
	/**
	 * @return the toSellerAtClosing
	 */
	public IntegratedDisclosureSectionSummaryModel getToSellerAtClosing() {
		return toSellerAtClosing;
	}
	/**
	 * @param toSellerAtClosing the toSellerAtClosing to set
	 */
	public void setToSellerAtClosing(IntegratedDisclosureSectionSummaryModel toSellerAtClosing) {
		this.toSellerAtClosing = toSellerAtClosing;
	}
	/**
	 * @return the fromSellerAtClosing
	 */
	public IntegratedDisclosureSectionSummaryModel getFromSellerAtClosing() {
		return fromSellerAtClosing;
	}
	/**
	 * @param fromSellerAtClosing the fromSellerAtClosing to set
	 */
	public void setFromSellerAtClosing(IntegratedDisclosureSectionSummaryModel fromSellerAtClosing) {
		this.fromSellerAtClosing = fromSellerAtClosing;
	}
	
}
