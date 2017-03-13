package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class CostsAtClosingClosingCosts implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5273848413251894676L;
	
	private String amount;
	private List<String> details;
	
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @return the details
	 */
	public List<String> getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(List<String> details) {
		this.details = details;
	}
	
	

}
