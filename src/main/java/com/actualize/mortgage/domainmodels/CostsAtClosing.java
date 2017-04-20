package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * populates CostsAtClosing section in Page One of CD for UI response
 * @author sboragala
 *
 */
public class CostsAtClosing implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2772882968985554852L;
	
	@JsonProperty("ClosingCosts")
	private CostsAtClosingClosingCosts costsAtClosingClosingCosts;
	@JsonProperty("CashToClose")
	private CostsAtClosingCashToClose costsAtClosingCashToClose;
	
	/**
	 * @return the costsAtClosingClosingCosts
	 */
	public CostsAtClosingClosingCosts getCostsAtClosingClosingCosts() {
		return costsAtClosingClosingCosts;
	}
	/**
	 * @param costsAtClosingClosingCosts the costsAtClosingClosingCosts to set
	 */
	public void setCostsAtClosingClosingCosts(CostsAtClosingClosingCosts costsAtClosingClosingCosts) {
		this.costsAtClosingClosingCosts = costsAtClosingClosingCosts;
	}
	/**
	 * @return the costsAtClosingCashToClose
	 */
	public CostsAtClosingCashToClose getCostsAtClosingCashToClose() {
		return costsAtClosingCashToClose;
	}
	/**
	 * @param costsAtClosingCashToClose the costsAtClosingCashToClose to set
	 */
	public void setCostsAtClosingCashToClose(CostsAtClosingCashToClose costsAtClosingCashToClose) {
		this.costsAtClosingCashToClose = costsAtClosingCashToClose;
	}
	

}
