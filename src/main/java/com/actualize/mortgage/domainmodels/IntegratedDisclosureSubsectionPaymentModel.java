/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * defines IntegratedDisclosureSubsectionPayment in JSON Response
 * @author sboragala
 *
 */
public class IntegratedDisclosureSubsectionPaymentModel implements Serializable {

	private static final long serialVersionUID = 7838166323890753180L;
	
	private String integratedDisclosureSubsectionPaidByType;
	private String integratedDisclosureSubsectionPaymentAmount;
	private String integratedDisclosureSubsectionPaymentTimingType;
	
	/**
	 * @return the integratedDisclosureSubsectionPaidByType
	 */
	public String getIntegratedDisclosureSubsectionPaidByType() {
		return integratedDisclosureSubsectionPaidByType;
	}
	/**
	 * @param integratedDisclosureSubsectionPaidByType the integratedDisclosureSubsectionPaidByType to set
	 */
	public void setIntegratedDisclosureSubsectionPaidByType(String integratedDisclosureSubsectionPaidByType) {
		this.integratedDisclosureSubsectionPaidByType = integratedDisclosureSubsectionPaidByType;
	}
	/**
	 * @return the integratedDisclosureSubsectionPaymentAmount
	 */
	public String getIntegratedDisclosureSubsectionPaymentAmount() {
		return integratedDisclosureSubsectionPaymentAmount;
	}
	/**
	 * @param integratedDisclosureSubsectionPaymentAmount the integratedDisclosureSubsectionPaymentAmount to set
	 */
	public void setIntegratedDisclosureSubsectionPaymentAmount(String integratedDisclosureSubsectionPaymentAmount) {
		this.integratedDisclosureSubsectionPaymentAmount = integratedDisclosureSubsectionPaymentAmount;
	}
	/**
	 * @return the integratedDisclosureSubsectionPaymentTimingType
	 */
	public String getIntegratedDisclosureSubsectionPaymentTimingType() {
		return integratedDisclosureSubsectionPaymentTimingType;
	}
	/**
	 * @param integratedDisclosureSubsectionPaymentTimingType the integratedDisclosureSubsectionPaymentTimingType to set
	 */
	public void setIntegratedDisclosureSubsectionPaymentTimingType(String integratedDisclosureSubsectionPaymentTimingType) {
		this.integratedDisclosureSubsectionPaymentTimingType = integratedDisclosureSubsectionPaymentTimingType;
	}
	
	

}
