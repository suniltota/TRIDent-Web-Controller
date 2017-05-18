package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class SummariesofTransactionsDetailsPaidByAlready implements Serializable{
	
	
	private static final long serialVersionUID = -5690104701135903828L;
	
	
	private ClosingAdjustmentItemModel subordinateLien = new ClosingAdjustmentItemModel() ; 
	
	/**
	 * @return the subordinateLien
	 */
	public ClosingAdjustmentItemModel getSubordinateLien() {
		return subordinateLien;
	}
	/**
	 * @param subordinateLien the subordinateLien to set
	 */
	public void setSubordinateLien(ClosingAdjustmentItemModel subordinateLien) {
		this.subordinateLien = subordinateLien;
	}
	
}
