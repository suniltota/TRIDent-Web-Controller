/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines IntegratedDisclosureSectionSummaryDetail in JSON Response
 * @author sboragala
 *
 */
public class IntegratedDisclosureSectionSummaryDetailModel implements Serializable {

	private static final long serialVersionUID = 8448232498165634324L;

	private  String integratedDisclosureSectionTotalAmount;
	private  String integratedDisclosureSectionType;
	private  String integratedDisclosureSubsectionTotalAmount;
	private  String integratedDisclosureSubsectionType;
	private  String integratedDisclosureSubsectionTypeOtherDescription;
	private  String lenderCreditToleranceCureAmount;
	
	/**
	 * @return the integratedDisclosureSectionTotalAmount
	 */
	public String getIntegratedDisclosureSectionTotalAmount() {
		return integratedDisclosureSectionTotalAmount;
	}
	/**
	 * @param integratedDisclosureSectionTotalAmount the integratedDisclosureSectionTotalAmount to set
	 */
	public void setIntegratedDisclosureSectionTotalAmount(String integratedDisclosureSectionTotalAmount) {
		this.integratedDisclosureSectionTotalAmount = integratedDisclosureSectionTotalAmount;
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
	 * @return the integratedDisclosureSubsectionTotalAmount
	 */
	public String getIntegratedDisclosureSubsectionTotalAmount() {
		return integratedDisclosureSubsectionTotalAmount;
	}
	/**
	 * @param integratedDisclosureSubsectionTotalAmount the integratedDisclosureSubsectionTotalAmount to set
	 */
	public void setIntegratedDisclosureSubsectionTotalAmount(String integratedDisclosureSubsectionTotalAmount) {
		this.integratedDisclosureSubsectionTotalAmount = integratedDisclosureSubsectionTotalAmount;
	}
	/**
	 * @return the integratedDisclosureSubsectionType
	 */
	public String getIntegratedDisclosureSubsectionType() {
		return integratedDisclosureSubsectionType;
	}
	/**
	 * @param integratedDisclosureSubsectionType the integratedDisclosureSubsectionType to set
	 */
	public void setIntegratedDisclosureSubsectionType(String integratedDisclosureSubsectionType) {
		this.integratedDisclosureSubsectionType = integratedDisclosureSubsectionType;
	}
	/**
	 * @return the integratedDisclosureSubsectionTypeOtherDescription
	 */
	public String getIntegratedDisclosureSubsectionTypeOtherDescription() {
		return integratedDisclosureSubsectionTypeOtherDescription;
	}
	/**
	 * @param integratedDisclosureSubsectionTypeOtherDescription the integratedDisclosureSubsectionTypeOtherDescription to set
	 */
	public void setIntegratedDisclosureSubsectionTypeOtherDescription(
			String integratedDisclosureSubsectionTypeOtherDescription) {
		this.integratedDisclosureSubsectionTypeOtherDescription = integratedDisclosureSubsectionTypeOtherDescription;
	}
	/**
	 * @return the lenderCreditToleranceCureAmount
	 */
	public String getLenderCreditToleranceCureAmount() {
		return lenderCreditToleranceCureAmount;
	}
	/**
	 * @param lenderCreditToleranceCureAmount the lenderCreditToleranceCureAmount to set
	 */
	public void setLenderCreditToleranceCureAmount(String lenderCreditToleranceCureAmount) {
		this.lenderCreditToleranceCureAmount = lenderCreditToleranceCureAmount;
	}
	
	
}
