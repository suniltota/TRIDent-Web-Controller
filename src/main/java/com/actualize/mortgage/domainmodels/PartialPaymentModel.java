/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines PartialPayment in JSON Response 
 * @author sboragala
 *
 */
public class PartialPaymentModel implements Serializable {

	private static final long serialVersionUID = 449704335666254940L;
	
	private String partialPaymentApplicationMethodType;
	private String partialPaymentApplicationMethodTypeOtherDescription;
	
	/**
	 * @return the partialPaymentApplicationMethodType
	 */
	public String getPartialPaymentApplicationMethodType() {
		return partialPaymentApplicationMethodType;
	}
	/**
	 * @param partialPaymentApplicationMethodType the partialPaymentApplicationMethodType to set
	 */
	public void setPartialPaymentApplicationMethodType(String partialPaymentApplicationMethodType) {
		this.partialPaymentApplicationMethodType = partialPaymentApplicationMethodType;
	}
	/**
	 * @return the partialPaymentApplicationMethodTypeOtherDescription
	 */
	public String getPartialPaymentApplicationMethodTypeOtherDescription() {
		return partialPaymentApplicationMethodTypeOtherDescription;
	}
	/**
	 * @param partialPaymentApplicationMethodTypeOtherDescription the partialPaymentApplicationMethodTypeOtherDescription to set
	 */
	public void setPartialPaymentApplicationMethodTypeOtherDescription(
			String partialPaymentApplicationMethodTypeOtherDescription) {
		this.partialPaymentApplicationMethodTypeOtherDescription = partialPaymentApplicationMethodTypeOtherDescription;
	}
	
	
}
