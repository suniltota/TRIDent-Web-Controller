package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
/**
 * Defines Fee Payments in JSON Response
 * @author sboragala
 *
 */
public class FeePaymentsModel implements Serializable{

	private static final long serialVersionUID = 4266661438349174503L;

	private String feeActualPaymentAmount;
    private String feePaymentPaidByType;
    private boolean feePaymentPaidOutsideOfClosingIndicator;
    
	/**
	 * @return the feeActualPaymentAmount
	 */
	public String getFeeActualPaymentAmount() {
		return feeActualPaymentAmount;
	}
	/**
	 * @param feeActualPaymentAmount the feeActualPaymentAmount to set
	 */
	public void setFeeActualPaymentAmount(String feeActualPaymentAmount) {
		this.feeActualPaymentAmount = feeActualPaymentAmount;
	}
	/**
	 * @return the feePaymentPaidByType
	 */
	public String getFeePaymentPaidByType() {
		return feePaymentPaidByType;
	}
	/**
	 * @param feePaymentPaidByType the feePaymentPaidByType to set
	 */
	public void setFeePaymentPaidByType(String feePaymentPaidByType) {
		this.feePaymentPaidByType = feePaymentPaidByType;
	}
	/**
	 * @return the feePaymentPaidOutsideOfClosingIndicator
	 */
	public boolean isFeePaymentPaidOutsideOfClosingIndicator() {
		return feePaymentPaidOutsideOfClosingIndicator;
	}
	/**
	 * @param feePaymentPaidOutsideOfClosingIndicator the feePaymentPaidOutsideOfClosingIndicator to set
	 */
	public void setFeePaymentPaidOutsideOfClosingIndicator(boolean feePaymentPaidOutsideOfClosingIndicator) {
		this.feePaymentPaidOutsideOfClosingIndicator = feePaymentPaidOutsideOfClosingIndicator;
	}
    
    
}
