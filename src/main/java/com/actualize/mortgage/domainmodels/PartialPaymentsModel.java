/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

/**
 * this class defines Partial Payments in JSON Response
 * @author sboragala
 *
 */
public class PartialPaymentsModel implements Serializable {

	private static final long serialVersionUID = 1526569653592024383L;
	
	List<PartialPaymentModel> partialPaymentModels;
	
	/**
	 * @return the partialPaymentModels
	 */
	public List<PartialPaymentModel> getPartialPaymentModels() {
		return partialPaymentModels;
	}
	/**
	 * @param partialPaymentModels the partialPaymentModels to set
	 */
	public void setPartialPaymentModels(List<PartialPaymentModel> partialPaymentModels) {
		this.partialPaymentModels = partialPaymentModels;
	}
	
}
