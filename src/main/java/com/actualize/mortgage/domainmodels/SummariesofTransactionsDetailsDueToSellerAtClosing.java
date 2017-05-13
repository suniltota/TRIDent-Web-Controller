package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class SummariesofTransactionsDetailsDueToSellerAtClosing implements Serializable{

	private static final long serialVersionUID = 3636097337611112788L;

	private IntegratedDisclosureSectionSummaryModel dueToSellerTotalAmount;
	
	/**
	 * @return the dueToSellerTotalAmount
	 */
	public IntegratedDisclosureSectionSummaryModel getDueToSellerTotalAmount() {
		return dueToSellerTotalAmount;
	}
	/**
	 * @param dueToSellerTotalAmount the dueToSellerTotalAmount to set
	 */
	public void setDueToSellerTotalAmount(IntegratedDisclosureSectionSummaryModel dueToSellerTotalAmount) {
		this.dueToSellerTotalAmount = dueToSellerTotalAmount;
	}
	
	
}
