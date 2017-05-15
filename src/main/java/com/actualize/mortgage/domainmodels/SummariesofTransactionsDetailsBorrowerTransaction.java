/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * @author sboragala
 *
 */
public class SummariesofTransactionsDetailsBorrowerTransaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4380364076683782942L;
	
	private IntegratedDisclosureSectionSummaryModel dueFromBorrowerAtClosing;
	private IntegratedDisclosureSectionSummaryModel paidAlreadyByOrOnBehalfOfBorrowerAtClosing;
	
	
	/**
	 * @return the dueFromBorrowerAtClosing
	 */
	public IntegratedDisclosureSectionSummaryModel getDueFromBorrowerAtClosing() {
		return dueFromBorrowerAtClosing;
	}
	/**
	 * @param dueFromBorrowerAtClosing the dueFromBorrowerAtClosing to set
	 */
	public void setDueFromBorrowerAtClosing(IntegratedDisclosureSectionSummaryModel dueFromBorrowerAtClosing) {
		this.dueFromBorrowerAtClosing = dueFromBorrowerAtClosing;
	}
	/**
	 * @return the paidAlreadyByOrOnBehalfOfBorrowerAtClosing
	 */
	public IntegratedDisclosureSectionSummaryModel getPaidAlreadyByOrOnBehalfOfBorrowerAtClosing() {
		return paidAlreadyByOrOnBehalfOfBorrowerAtClosing;
	}
	/**
	 * @param paidAlreadyByOrOnBehalfOfBorrowerAtClosing the paidAlreadyByOrOnBehalfOfBorrowerAtClosing to set
	 */
	public void setPaidAlreadyByOrOnBehalfOfBorrowerAtClosing(
			IntegratedDisclosureSectionSummaryModel paidAlreadyByOrOnBehalfOfBorrowerAtClosing) {
		this.paidAlreadyByOrOnBehalfOfBorrowerAtClosing = paidAlreadyByOrOnBehalfOfBorrowerAtClosing;
	}

}
