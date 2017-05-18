/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines LiabilityModel in JSON response
 * @author sboragala
 *
 */
public class LiabilityModel implements Serializable {

	private static final long serialVersionUID = 6864703105075998928L;
	
	private String displayLabel;
	private String liabilityDescription;
	private String liabilityType;
	private String liabilityTypeOtherDescription;
	private String integratedDisclosureSectionType;
	private boolean liabilitySecuredBySubjectPropertyIndicator;
	private String liabilityHolderFullName;
	private String payoffAmount;
	private String payoffPrepaymentPenaltyAmount;
	private boolean payoffPartialIndicator;
	
	/**
	 * @return the displayLabel
	 */
	public String getDisplayLabel() {
		return displayLabel;
	}
	/**
	 * @param displayLabel the displayLabel to set
	 */
	public void setDisplayLabel(String displayLabel) {
		this.displayLabel = displayLabel;
	}
	/**
	 * @return the liabilityDescription
	 */
	public String getLiabilityDescription() {
		return liabilityDescription;
	}
	/**
	 * @param liabilityDescription the liabilityDescription to set
	 */
	public void setLiabilityDescription(String liabilityDescription) {
		this.liabilityDescription = liabilityDescription;
	}
	/**
	 * @return the liabilityType
	 */
	public String getLiabilityType() {
		return liabilityType;
	}
	/**
	 * @param liabilityType the liabilityType to set
	 */
	public void setLiabilityType(String liabilityType) {
		this.liabilityType = liabilityType;
	}
	/**
	 * @return the liabilityTypeOtherDescription
	 */
	public String getLiabilityTypeOtherDescription() {
		return liabilityTypeOtherDescription;
	}
	/**
	 * @param liabilityTypeOtherDescription the liabilityTypeOtherDescription to set
	 */
	public void setLiabilityTypeOtherDescription(String liabilityTypeOtherDescription) {
		this.liabilityTypeOtherDescription = liabilityTypeOtherDescription;
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
	public boolean isLiabilitySecuredBySubjectPropertyIndicator() {
		return liabilitySecuredBySubjectPropertyIndicator;
	}
	/**
	 * @param liabilitySecuredBySubjectPropertyIndicator the liabilitySecuredBySubjectPropertyIndicator to set
	 */
	public void setLiabilitySecuredBySubjectPropertyIndicator(boolean liabilitySecuredBySubjectPropertyIndicator) {
		this.liabilitySecuredBySubjectPropertyIndicator = liabilitySecuredBySubjectPropertyIndicator;
	}
	/**
	 * @return the liabilityHolderFullName
	 */
	public String getLiabilityHolderFullName() {
		return liabilityHolderFullName;
	}
	/**
	 * @param liabilityHolderFullName the liabilityHolderFullName to set
	 */
	public void setLiabilityHolderFullName(String liabilityHolderFullName) {
		this.liabilityHolderFullName = liabilityHolderFullName;
	}
	/**
	 * @return the payoffAmount
	 */
	public String getPayoffAmount() {
		return payoffAmount;
	}
	/**
	 * @param payoffAmount the payoffAmount to set
	 */
	public void setPayoffAmount(String payoffAmount) {
		this.payoffAmount = payoffAmount;
	}
	/**
	 * @return the payoffPrepaymentPenaltyAmount
	 */
	public String getPayoffPrepaymentPenaltyAmount() {
		return payoffPrepaymentPenaltyAmount;
	}
	/**
	 * @param payoffPrepaymentPenaltyAmount the payoffPrepaymentPenaltyAmount to set
	 */
	public void setPayoffPrepaymentPenaltyAmount(String payoffPrepaymentPenaltyAmount) {
		this.payoffPrepaymentPenaltyAmount = payoffPrepaymentPenaltyAmount;
	}
	/**
	 * @return the payoffPartialIndicator
	 */
	public boolean isPayoffPartialIndicator() {
		return payoffPartialIndicator;
	}
	/**
	 * @param payoffPartialIndicator the payoffPartialIndicator to set
	 */
	public void setPayoffPartialIndicator(boolean payoffPartialIndicator) {
		this.payoffPartialIndicator = payoffPartialIndicator;
	}
	
	    
}
