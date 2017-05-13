/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines PaymentRule in JSON response
 * @author sboragala
 *
 */
/**
 * @author sboragala
 *
 */
public class PaymentRuleModel implements Serializable {

	private static final long serialVersionUID = 1763498376101154213L;

	private String fullyIndexedInitialPrincipalAndInterestPaymentAmount;
	private String initialPrincipalAndInterestPaymentAmount;
	private boolean partialPaymentAllowedIndicator;
	private String paymentFrequencyType;
	private boolean paymentOptionIndicator;
	private String seasonalPaymentPeriodEndMonth;
	private String seasonalPaymentPeriodStartMonth;
	private String totalOptionalPaymentCount;
	private String totalStepPaymentCount;
	
	/**
	 * @return the fullyIndexedInitialPrincipalAndInterestPaymentAmount
	 */
	public String getFullyIndexedInitialPrincipalAndInterestPaymentAmount() {
		return fullyIndexedInitialPrincipalAndInterestPaymentAmount;
	}
	/**
	 * @param fullyIndexedInitialPrincipalAndInterestPaymentAmount the fullyIndexedInitialPrincipalAndInterestPaymentAmount to set
	 */
	public void setFullyIndexedInitialPrincipalAndInterestPaymentAmount(
			String fullyIndexedInitialPrincipalAndInterestPaymentAmount) {
		this.fullyIndexedInitialPrincipalAndInterestPaymentAmount = fullyIndexedInitialPrincipalAndInterestPaymentAmount;
	}
	/**
	 * @return the initialPrincipalAndInterestPaymentAmount
	 */
	public String getInitialPrincipalAndInterestPaymentAmount() {
		return initialPrincipalAndInterestPaymentAmount;
	}
	/**
	 * @param initialPrincipalAndInterestPaymentAmount the initialPrincipalAndInterestPaymentAmount to set
	 */
	public void setInitialPrincipalAndInterestPaymentAmount(String initialPrincipalAndInterestPaymentAmount) {
		this.initialPrincipalAndInterestPaymentAmount = initialPrincipalAndInterestPaymentAmount;
	}
	/**
	 * @return the partialPaymentAllowedIndicator
	 */
	public boolean isPartialPaymentAllowedIndicator() {
		return partialPaymentAllowedIndicator;
	}
	/**
	 * @param partialPaymentAllowedIndicator the partialPaymentAllowedIndicator to set
	 */
	public void setPartialPaymentAllowedIndicator(boolean partialPaymentAllowedIndicator) {
		this.partialPaymentAllowedIndicator = partialPaymentAllowedIndicator;
	}
	/**
	 * @return the paymentFrequencyType
	 */
	public String getPaymentFrequencyType() {
		return paymentFrequencyType;
	}
	/**
	 * @param paymentFrequencyType the paymentFrequencyType to set
	 */
	public void setPaymentFrequencyType(String paymentFrequencyType) {
		this.paymentFrequencyType = paymentFrequencyType;
	}
	/**
	 * @return the paymentOptionIndicator
	 */
	public boolean isPaymentOptionIndicator() {
		return paymentOptionIndicator;
	}
	/**
	 * @param paymentOptionIndicator the paymentOptionIndicator to set
	 */
	public void setPaymentOptionIndicator(boolean paymentOptionIndicator) {
		this.paymentOptionIndicator = paymentOptionIndicator;
	}
	/**
	 * @return the seasonalPaymentPeriodEndMonth
	 */
	public String getSeasonalPaymentPeriodEndMonth() {
		return seasonalPaymentPeriodEndMonth;
	}
	/**
	 * @param seasonalPaymentPeriodEndMonth the seasonalPaymentPeriodEndMonth to set
	 */
	public void setSeasonalPaymentPeriodEndMonth(String seasonalPaymentPeriodEndMonth) {
		this.seasonalPaymentPeriodEndMonth = seasonalPaymentPeriodEndMonth;
	}
	/**
	 * @return the seasonalPaymentPeriodStartMonth
	 */
	public String getSeasonalPaymentPeriodStartMonth() {
		return seasonalPaymentPeriodStartMonth;
	}
	/**
	 * @param seasonalPaymentPeriodStartMonth the seasonalPaymentPeriodStartMonth to set
	 */
	public void setSeasonalPaymentPeriodStartMonth(String seasonalPaymentPeriodStartMonth) {
		this.seasonalPaymentPeriodStartMonth = seasonalPaymentPeriodStartMonth;
	}
	/**
	 * @return the totalOptionalPaymentCount
	 */
	public String getTotalOptionalPaymentCount() {
		return totalOptionalPaymentCount;
	}
	/**
	 * @param totalOptionalPaymentCount the totalOptionalPaymentCount to set
	 */
	public void setTotalOptionalPaymentCount(String totalOptionalPaymentCount) {
		this.totalOptionalPaymentCount = totalOptionalPaymentCount;
	}
	/**
	 * @return the totalStepPaymentCount
	 */
	public String getTotalStepPaymentCount() {
		return totalStepPaymentCount;
	}
	/**
	 * @param totalStepPaymentCount the totalStepPaymentCount to set
	 */
	public void setTotalStepPaymentCount(String totalStepPaymentCount) {
		this.totalStepPaymentCount = totalStepPaymentCount;
	}
	
	
	    
}
