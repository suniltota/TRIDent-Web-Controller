/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * defines Payment in JSON response
 * @author sboragala
 *
 */
public class PaymentModel implements Serializable {
	
	private static final long serialVersionUID = 4669875642335523650L;
	
	private PartialPaymentsModel partialPayments;
	private PaymentRuleModel paymentRule;
	
	/**
	 * @return the partialPayments
	 */
	public PartialPaymentsModel getPartialPayments() {
		return partialPayments;
	}
	/**
	 * @param partialPayments the partialPayments to set
	 */
	public void setPartialPayments(PartialPaymentsModel partialPayments) {
		this.partialPayments = partialPayments;
	}
	/**
	 * @return the paymentRule
	 */
	public PaymentRuleModel getPaymentRule() {
		return paymentRule;
	}
	/**
	 * @param paymentRule the paymentRule to set
	 */
	public void setPaymentRule(PaymentRuleModel paymentRule) {
		this.paymentRule = paymentRule;
	}
	
	
}
