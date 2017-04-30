package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
/**
 * Defines Prepaid Payments in JSON response
 * @author sboragala
 *
 */
public class PrepaidPayments implements Serializable{

	
	private static final long serialVersionUID = 3706756052380648482L;
	
	private String prepaidItemActualPaymentAmount;
    private String prepaidItemPaymentPaidByType;
    private String prepaidItemPaymentTimingType;
    private String regulationZPointsAndFeesIndicator;
    
	/**
	 * @return the prepaidItemActualPaymentAmount
	 */
	public String getPrepaidItemActualPaymentAmount() {
		return prepaidItemActualPaymentAmount;
	}
	/**
	 * @param prepaidItemActualPaymentAmount the prepaidItemActualPaymentAmount to set
	 */
	public void setPrepaidItemActualPaymentAmount(String prepaidItemActualPaymentAmount) {
		this.prepaidItemActualPaymentAmount = prepaidItemActualPaymentAmount;
	}
	/**
	 * @return the prepaidItemPaymentPaidByType
	 */
	public String getPrepaidItemPaymentPaidByType() {
		return prepaidItemPaymentPaidByType;
	}
	/**
	 * @param prepaidItemPaymentPaidByType the prepaidItemPaymentPaidByType to set
	 */
	public void setPrepaidItemPaymentPaidByType(String prepaidItemPaymentPaidByType) {
		this.prepaidItemPaymentPaidByType = prepaidItemPaymentPaidByType;
	}
	/**
	 * @return the prepaidItemPaymentTimingType
	 */
	public String getPrepaidItemPaymentTimingType() {
		return prepaidItemPaymentTimingType;
	}
	/**
	 * @param prepaidItemPaymentTimingType the prepaidItemPaymentTimingType to set
	 */
	public void setPrepaidItemPaymentTimingType(String prepaidItemPaymentTimingType) {
		this.prepaidItemPaymentTimingType = prepaidItemPaymentTimingType;
	}
	/**
	 * @return the regulationZPointsAndFeesIndicator
	 */
	public String getRegulationZPointsAndFeesIndicator() {
		return regulationZPointsAndFeesIndicator;
	}
	/**
	 * @param regulationZPointsAndFeesIndicator the regulationZPointsAndFeesIndicator to set
	 */
	public void setRegulationZPointsAndFeesIndicator(String regulationZPointsAndFeesIndicator) {
		this.regulationZPointsAndFeesIndicator = regulationZPointsAndFeesIndicator;
	}
    
    

}
