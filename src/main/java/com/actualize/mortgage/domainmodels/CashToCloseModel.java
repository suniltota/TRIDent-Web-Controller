package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
/**
 * this class  
 * @author sboragala
 *
 */
public class CashToCloseModel implements Serializable {

	
	private static final long serialVersionUID = -4771787160333094672L;
	
	private boolean integratedDisclosureCashToCloseItemAmountChangedIndicator;
    private String integratedDisclosureCashToCloseItemChangeDescription;
    private String integratedDisclosureCashToCloseItemEstimatedAmount;
    private String integratedDisclosureCashToCloseItemFinalAmount;
    private String integratedDisclosureCashToCloseItemPaymentType;
    private String integratedDisclosureCashToCloseItemType;
    private String index;
    
    /**
	 * @return the integratedDisclosureCashToCloseItemAmountChangedIndicator
	 */
	public boolean isIntegratedDisclosureCashToCloseItemAmountChangedIndicator() {
		return integratedDisclosureCashToCloseItemAmountChangedIndicator;
	}
	/**
	 * @param integratedDisclosureCashToCloseItemAmountChangedIndicator the integratedDisclosureCashToCloseItemAmountChangedIndicator to set
	 */
	public void setIntegratedDisclosureCashToCloseItemAmountChangedIndicator(
			boolean integratedDisclosureCashToCloseItemAmountChangedIndicator) {
		this.integratedDisclosureCashToCloseItemAmountChangedIndicator = integratedDisclosureCashToCloseItemAmountChangedIndicator;
	}
	
	/**
	 * @return the integratedDisclosureCashToCloseItemChangeDescription
	 */
	public String getIntegratedDisclosureCashToCloseItemChangeDescription() {
		return integratedDisclosureCashToCloseItemChangeDescription;
	}
	/**
	 * @param integratedDisclosureCashToCloseItemChangeDescription the integratedDisclosureCashToCloseItemChangeDescription to set
	 */
	public void setIntegratedDisclosureCashToCloseItemChangeDescription(
			String integratedDisclosureCashToCloseItemChangeDescription) {
		this.integratedDisclosureCashToCloseItemChangeDescription = integratedDisclosureCashToCloseItemChangeDescription;
	}
	/**
	 * @return the integratedDisclosureCashToCloseItemEstimatedAmount
	 */
	public String getIntegratedDisclosureCashToCloseItemEstimatedAmount() {
		return integratedDisclosureCashToCloseItemEstimatedAmount;
	}
	/**
	 * @param integratedDisclosureCashToCloseItemEstimatedAmount the integratedDisclosureCashToCloseItemEstimatedAmount to set
	 */
	public void setIntegratedDisclosureCashToCloseItemEstimatedAmount(
			String integratedDisclosureCashToCloseItemEstimatedAmount) {
		this.integratedDisclosureCashToCloseItemEstimatedAmount = integratedDisclosureCashToCloseItemEstimatedAmount;
	}
	/**
	 * @return the integratedDisclosureCashToCloseItemFinalAmount
	 */
	public String getIntegratedDisclosureCashToCloseItemFinalAmount() {
		return integratedDisclosureCashToCloseItemFinalAmount;
	}
	/**
	 * @param integratedDisclosureCashToCloseItemFinalAmount the integratedDisclosureCashToCloseItemFinalAmount to set
	 */
	public void setIntegratedDisclosureCashToCloseItemFinalAmount(String integratedDisclosureCashToCloseItemFinalAmount) {
		this.integratedDisclosureCashToCloseItemFinalAmount = integratedDisclosureCashToCloseItemFinalAmount;
	}
	/**
	 * @return the integratedDisclosureCashToCloseItemPaymentType
	 */
	public String getIntegratedDisclosureCashToCloseItemPaymentType() {
		return integratedDisclosureCashToCloseItemPaymentType;
	}
	/**
	 * @param integratedDisclosureCashToCloseItemPaymentType the integratedDisclosureCashToCloseItemPaymentType to set
	 */
	public void setIntegratedDisclosureCashToCloseItemPaymentType(String integratedDisclosureCashToCloseItemPaymentType) {
		this.integratedDisclosureCashToCloseItemPaymentType = integratedDisclosureCashToCloseItemPaymentType;
	}
	/**
	 * @return the integratedDisclosureCashToCloseItemType
	 */
	public String getIntegratedDisclosureCashToCloseItemType() {
		return integratedDisclosureCashToCloseItemType;
	}
	/**
	 * @param integratedDisclosureCashToCloseItemType the integratedDisclosureCashToCloseItemType to set
	 */
	public void setIntegratedDisclosureCashToCloseItemType(String integratedDisclosureCashToCloseItemType) {
		this.integratedDisclosureCashToCloseItemType = integratedDisclosureCashToCloseItemType;
	}
	/**
	 * @return the index
	 */
	public String getIndex() {
		return index;
	}
	/**
	 * @param index the index to set
	 */
	public void setIndex(String index) {
		this.index = index;
	}
    
	
}
