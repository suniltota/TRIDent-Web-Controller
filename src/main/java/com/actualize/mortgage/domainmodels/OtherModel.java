/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class represents GSE datapoints while redering MISMO XML from JSON Object
 * @author sboragala
 *
 */
public class OtherModel implements Serializable {
	
	private static final long serialVersionUID = 4937365492092727921L;
	
	private String integratedDisclosureEstimatedClosingCostsExpirationTimezoneType = "";
	private String lockExpirationTimezoneType = "";
	private String buydownReflectedInNoteIndicator = "";                                 
	private String documentSignatureRequiredIndicator = "";                              
	private String escrowAccountRolloverAmount = "";                                     
	private String integratedDisclosureSectionType = "";                                 
	private String liabilitySecuredBySubjectPropertyIndicator = "";                      
	private String totalOptionalPaymentCount = "";                                       
	private String totalStepCount = "";                                                  
	private String totalStepPaymentCount = "";                                           
	private String subordinateFinancingIsNewIndicator = "";
	private String paymentIncludedInAPRIndicator = "";
	private String payoffPartialIndicator = "";
	private String escrowAggregateAccountingAdjustmentPaidByType = "";
	private String escrowAggregateAccountingAdjustmentPaymentTimingType = "";
	
	/**
	 * @return the integratedDisclosureEstimatedClosingCostsExpirationTimezoneType
	 */
	public String getIntegratedDisclosureEstimatedClosingCostsExpirationTimezoneType() {
		return integratedDisclosureEstimatedClosingCostsExpirationTimezoneType;
	}
	/**
	 * @param integratedDisclosureEstimatedClosingCostsExpirationTimezoneType the integratedDisclosureEstimatedClosingCostsExpirationTimezoneType to set
	 */
	public void setIntegratedDisclosureEstimatedClosingCostsExpirationTimezoneType(
			String integratedDisclosureEstimatedClosingCostsExpirationTimezoneType) {
		this.integratedDisclosureEstimatedClosingCostsExpirationTimezoneType = integratedDisclosureEstimatedClosingCostsExpirationTimezoneType;
	}
	/**
	 * @return the lockExpirationTimezoneType
	 */
	public String getLockExpirationTimezoneType() {
		return lockExpirationTimezoneType;
	}
	/**
	 * @param lockExpirationTimezoneType the lockExpirationTimezoneType to set
	 */
	public void setLockExpirationTimezoneType(String lockExpirationTimezoneType) {
		this.lockExpirationTimezoneType = lockExpirationTimezoneType;
	}
	/**
	 * @return the buydownReflectedInNoteIndicator
	 */
	public String getBuydownReflectedInNoteIndicator() {
		return buydownReflectedInNoteIndicator;
	}
	/**
	 * @param buydownReflectedInNoteIndicator the buydownReflectedInNoteIndicator to set
	 */
	public void setBuydownReflectedInNoteIndicator(String buydownReflectedInNoteIndicator) {
		this.buydownReflectedInNoteIndicator = buydownReflectedInNoteIndicator;
	}
	/**
	 * @return the documentSignatureRequiredIndicator
	 */
	public String getDocumentSignatureRequiredIndicator() {
		return documentSignatureRequiredIndicator;
	}
	/**
	 * @param documentSignatureRequiredIndicator the documentSignatureRequiredIndicator to set
	 */
	public void setDocumentSignatureRequiredIndicator(String documentSignatureRequiredIndicator) {
		this.documentSignatureRequiredIndicator = documentSignatureRequiredIndicator;
	}
	/**
	 * @return the escrowAccountRolloverAmount
	 */
	public String getEscrowAccountRolloverAmount() {
		return escrowAccountRolloverAmount;
	}
	/**
	 * @param escrowAccountRolloverAmount the escrowAccountRolloverAmount to set
	 */
	public void setEscrowAccountRolloverAmount(String escrowAccountRolloverAmount) {
		this.escrowAccountRolloverAmount = escrowAccountRolloverAmount;
	}
	/**
	 * @return the integratedDisclosureSectionType
	 */
	public String getIntegratedDisclosureSectionType() {
		return integratedDisclosureSectionType;
	}
	/**
	 * @param integratedDisclosureSectionType the integratedDisclosureSectionType to set
	 */
	public void setIntegratedDisclosureSectionType(String integratedDisclosureSectionType) {
		this.integratedDisclosureSectionType = integratedDisclosureSectionType;
	}
	/**
	 * @return the liabilitySecuredBySubjectPropertyIndicator
	 */
	public String getLiabilitySecuredBySubjectPropertyIndicator() {
		return liabilitySecuredBySubjectPropertyIndicator;
	}
	/**
	 * @param liabilitySecuredBySubjectPropertyIndicator the liabilitySecuredBySubjectPropertyIndicator to set
	 */
	public void setLiabilitySecuredBySubjectPropertyIndicator(String liabilitySecuredBySubjectPropertyIndicator) {
		this.liabilitySecuredBySubjectPropertyIndicator = liabilitySecuredBySubjectPropertyIndicator;
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
	 * @return the totalStepCount
	 */
	public String getTotalStepCount() {
		return totalStepCount;
	}
	/**
	 * @param totalStepCount the totalStepCount to set
	 */
	public void setTotalStepCount(String totalStepCount) {
		this.totalStepCount = totalStepCount;
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
	/**
	 * @return the subordinateFinancingIsNewIndicator
	 */
	public String getSubordinateFinancingIsNewIndicator() {
		return subordinateFinancingIsNewIndicator;
	}
	/**
	 * @param subordinateFinancingIsNewIndicator the subordinateFinancingIsNewIndicator to set
	 */
	public void setSubordinateFinancingIsNewIndicator(String subordinateFinancingIsNewIndicator) {
		this.subordinateFinancingIsNewIndicator = subordinateFinancingIsNewIndicator;
	}
	/**
	 * @return the paymentIncludedInAPRIndicator
	 */
	public String getPaymentIncludedInAPRIndicator() {
		return paymentIncludedInAPRIndicator;
	}
	/**
	 * @param paymentIncludedInAPRIndicator the paymentIncludedInAPRIndicator to set
	 */
	public void setPaymentIncludedInAPRIndicator(String paymentIncludedInAPRIndicator) {
		this.paymentIncludedInAPRIndicator = paymentIncludedInAPRIndicator;
	}
	/**
	 * @return the payoffPartialIndicator
	 */
	public String getPayoffPartialIndicator() {
		return payoffPartialIndicator;
	}
	/**
	 * @param payoffPartialIndicator the payoffPartialIndicator to set
	 */
	public void setPayoffPartialIndicator(String payoffPartialIndicator) {
		this.payoffPartialIndicator = payoffPartialIndicator;
	}
	/**
	 * @return the escrowAggregateAccountingAdjustmentPaidByType
	 */
	public String getEscrowAggregateAccountingAdjustmentPaidByType() {
		return escrowAggregateAccountingAdjustmentPaidByType;
	}
	/**
	 * @param escrowAggregateAccountingAdjustmentPaidByType the escrowAggregateAccountingAdjustmentPaidByType to set
	 */
	public void setEscrowAggregateAccountingAdjustmentPaidByType(String escrowAggregateAccountingAdjustmentPaidByType) {
		this.escrowAggregateAccountingAdjustmentPaidByType = escrowAggregateAccountingAdjustmentPaidByType;
	}
	/**
	 * @return the escrowAggregateAccountingAdjustmentPaymentTimingType
	 */
	public String getEscrowAggregateAccountingAdjustmentPaymentTimingType() {
		return escrowAggregateAccountingAdjustmentPaymentTimingType;
	}
	/**
	 * @param escrowAggregateAccountingAdjustmentPaymentTimingType the escrowAggregateAccountingAdjustmentPaymentTimingType to set
	 */
	public void setEscrowAggregateAccountingAdjustmentPaymentTimingType(
			String escrowAggregateAccountingAdjustmentPaymentTimingType) {
		this.escrowAggregateAccountingAdjustmentPaymentTimingType = escrowAggregateAccountingAdjustmentPaymentTimingType;
	}
	
	

}
