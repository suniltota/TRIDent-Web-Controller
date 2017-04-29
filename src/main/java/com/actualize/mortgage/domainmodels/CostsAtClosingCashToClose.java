package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
/**
 * populates CashToClose section in CostsAtClosing for UI response
 * @author sboragala
 *
 */
public class CostsAtClosingCashToClose implements Serializable {
	
	private static final long serialVersionUID = -3001522846265870603L;
	
	private String amount;
	private boolean fromType;
	private String cashFromBorrowerAtClosingAmount;
	private String cashToBorrowerAtClosingAmount;
	
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
	 * @return the fromType
	 */
	public boolean isFromType() {
		return fromType;
	}
	/**
	 * @param fromType the fromType to set
	 */
	public void setFromType(boolean fromType) {
		this.fromType = fromType;
	}
	/**
	 * @return the cashFromBorrowerAtClosingAmount
	 */
	public String getCashFromBorrowerAtClosingAmount() {
		return cashFromBorrowerAtClosingAmount;
	}
	/**
	 * @param cashFromBorrowerAtClosingAmount the cashFromBorrowerAtClosingAmount to set
	 */
	public void setCashFromBorrowerAtClosingAmount(String cashFromBorrowerAtClosingAmount) {
		this.cashFromBorrowerAtClosingAmount = cashFromBorrowerAtClosingAmount;
	}
	/**
	 * @return the cashToBorrowerAtClosingAmount
	 */
	public String getCashToBorrowerAtClosingAmount() {
		return cashToBorrowerAtClosingAmount;
	}
	/**
	 * @param cashToBorrowerAtClosingAmount the cashToBorrowerAtClosingAmount to set
	 */
	public void setCashToBorrowerAtClosingAmount(String cashToBorrowerAtClosingAmount) {
		this.cashToBorrowerAtClosingAmount = cashToBorrowerAtClosingAmount;
	}
	
	
	
	
	
}
