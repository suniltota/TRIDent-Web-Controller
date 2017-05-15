/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * @author sboragala
 *
 */
public class SummariesofTransactionsDetailsSellerTransaction implements Serializable {


	private static final long serialVersionUID = 901746957146752719L;
	
	private IntegratedDisclosureSectionSummaryModel toSellerAtClosing;
	private IntegratedDisclosureSectionSummaryModel fromSellerAtClosing;
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
