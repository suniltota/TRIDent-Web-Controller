/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines ClosingAdjustmentItem in JSON response
 * @author sboragala
 *
 */
public class ClosingAdjustmentItemModel implements Serializable {

	private static final long serialVersionUID = -8722334409738681690L;

	private String displayLabel = "";
	private String closingAdjustmentItemAmount = "";
	private boolean closingAdjustmentItemPaidOutsideOfClosingIndicator = false;
	private String closingAdjustmentItemType = "";
	private String closingAdjustmentItemTypeOtherDescription = "";
	private String integratedDisclosureSectionType = "";
	private String integratedDisclosureSubsectionType = "";
	private String paidByIndividualFullName = "";
	private String paidByEntityFullName = "";
	private String paidToEntityFullName = "";
	
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
	 * @return the closingAdjustmentItemAmount
	 */
	public String getClosingAdjustmentItemAmount() {
		return closingAdjustmentItemAmount;
	}
	/**
	 * @param closingAdjustmentItemAmount the closingAdjustmentItemAmount to set
	 */
	public void setClosingAdjustmentItemAmount(String closingAdjustmentItemAmount) {
		this.closingAdjustmentItemAmount = closingAdjustmentItemAmount;
	}
	/**
	 * @return the closingAdjustmentItemPaidOutsideOfClosingIndicator
	 */
	public boolean isClosingAdjustmentItemPaidOutsideOfClosingIndicator() {
		return closingAdjustmentItemPaidOutsideOfClosingIndicator;
	}
	/**
	 * @param closingAdjustmentItemPaidOutsideOfClosingIndicator the closingAdjustmentItemPaidOutsideOfClosingIndicator to set
	 */
	public void setClosingAdjustmentItemPaidOutsideOfClosingIndicator(
			boolean closingAdjustmentItemPaidOutsideOfClosingIndicator) {
		this.closingAdjustmentItemPaidOutsideOfClosingIndicator = closingAdjustmentItemPaidOutsideOfClosingIndicator;
	}
	/**
	 * @return the closingAdjustmentItemType
	 */
	public String getClosingAdjustmentItemType() {
		return closingAdjustmentItemType;
	}
	/**
	 * @param closingAdjustmentItemType the closingAdjustmentItemType to set
	 */
	public void setClosingAdjustmentItemType(String closingAdjustmentItemType) {
		this.closingAdjustmentItemType = closingAdjustmentItemType;
	}
	/**
	 * @return the closingAdjustmentItemTypeOtherDescription
	 */
	public String getClosingAdjustmentItemTypeOtherDescription() {
		return closingAdjustmentItemTypeOtherDescription;
	}
	/**
	 * @param closingAdjustmentItemTypeOtherDescription the closingAdjustmentItemTypeOtherDescription to set
	 */
	public void setClosingAdjustmentItemTypeOtherDescription(String closingAdjustmentItemTypeOtherDescription) {
		this.closingAdjustmentItemTypeOtherDescription = closingAdjustmentItemTypeOtherDescription;
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
	 * @return the paidByIndividualFullName
	 */
	public String getPaidByIndividualFullName() {
		return paidByIndividualFullName;
	}
	/**
	 * @param paidByIndividualFullName the paidByIndividualFullName to set
	 */
	public void setPaidByIndividualFullName(String paidByIndividualFullName) {
		this.paidByIndividualFullName = paidByIndividualFullName;
	}
	/**
	 * @return the paidByEntityFullName
	 */
	public String getPaidByEntityFullName() {
		return paidByEntityFullName;
	}
	/**
	 * @param paidByEntityFullName the paidByEntityFullName to set
	 */
	public void setPaidByEntityFullName(String paidByEntityFullName) {
		this.paidByEntityFullName = paidByEntityFullName;
	}
	/**
	 * @return the paidToEntityFullName
	 */
	public String getPaidToEntityFullName() {
		return paidToEntityFullName;
	}
	/**
	 * @param paidToEntityFullName the paidToEntityFullName to set
	 */
	public void setPaidToEntityFullName(String paidToEntityFullName) {
		this.paidToEntityFullName = paidToEntityFullName;
	}
	
	
}
