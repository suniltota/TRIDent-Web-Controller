/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sboragala
 *
 */
public class IntegratedDisclosureSectionSummaryModel implements Serializable {

	private static final long serialVersionUID = -7346220652759727534L;
	
	private IntegratedDisclosureSectionSummaryDetailModel integratedDisclosureSectionSummaryDetailModel;
	private List<IntegratedDisclosureSubsectionPaymentModel> integratedDisclosureSubsectionPaymentModels = new LinkedList<>();
	
	/**
	 * @return the integratedDisclosureSectionSummaryDetailModel
	 */
	public IntegratedDisclosureSectionSummaryDetailModel getIntegratedDisclosureSectionSummaryDetailModel() {
		return integratedDisclosureSectionSummaryDetailModel;
	}
	/**
	 * @param integratedDisclosureSectionSummaryDetailModel the integratedDisclosureSectionSummaryDetailModel to set
	 */
	public void setIntegratedDisclosureSectionSummaryDetailModel(
			IntegratedDisclosureSectionSummaryDetailModel integratedDisclosureSectionSummaryDetailModel) {
		this.integratedDisclosureSectionSummaryDetailModel = integratedDisclosureSectionSummaryDetailModel;
	}
	/**
	 * @return the integratedDisclosureSubsectionPayments
	 */
	public List<IntegratedDisclosureSubsectionPaymentModel> getIntegratedDisclosureSubsectionPayments() {
		return integratedDisclosureSubsectionPaymentModels;
	}
	/**
	 * @param integratedDisclosureSubsectionPaymentModels the integratedDisclosureSubsectionPayments to set
	 */
	public void setIntegratedDisclosureSubsectionPayments(
			List<IntegratedDisclosureSubsectionPaymentModel> integratedDisclosureSubsectionPaymentModels) {
		this.integratedDisclosureSubsectionPaymentModels = integratedDisclosureSubsectionPaymentModels;
	}
	
	 
}
