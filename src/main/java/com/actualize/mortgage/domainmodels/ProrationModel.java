/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines Prorations in JSON response
 * @author sboragala
 *
 */
public class ProrationModel implements Serializable {


	private static final long serialVersionUID = 3059763857881609541L;

	private String displayLabel;
	private String integratedDisclosureSectionType;
    private String integratedDisclosureSubsectionType;
    private String prorationItemAmount;
    private String prorationItemPaidFromDate;
    private String prorationItemPaidThroughDate;
    private String prorationItemType;
    private String prorationItemTypeOtherDescription;
    
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
	 * @return the prorationItemAmount
	 */
	public String getProrationItemAmount() {
		return prorationItemAmount;
	}
	/**
	 * @param prorationItemAmount the prorationItemAmount to set
	 */
	public void setProrationItemAmount(String prorationItemAmount) {
		this.prorationItemAmount = prorationItemAmount;
	}
	/**
	 * @return the prorationItemPaidFromDate
	 */
	public String getProrationItemPaidFromDate() {
		return prorationItemPaidFromDate;
	}
	/**
	 * @param prorationItemPaidFromDate the prorationItemPaidFromDate to set
	 */
	public void setProrationItemPaidFromDate(String prorationItemPaidFromDate) {
		this.prorationItemPaidFromDate = prorationItemPaidFromDate;
	}
	/**
	 * @return the prorationItemPaidThroughDate
	 */
	public String getProrationItemPaidThroughDate() {
		return prorationItemPaidThroughDate;
	}
	/**
	 * @param prorationItemPaidThroughDate the prorationItemPaidThroughDate to set
	 */
	public void setProrationItemPaidThroughDate(String prorationItemPaidThroughDate) {
		this.prorationItemPaidThroughDate = prorationItemPaidThroughDate;
	}
	/**
	 * @return the prorationItemType
	 */
	public String getProrationItemType() {
		return prorationItemType;
	}
	/**
	 * @param prorationItemType the prorationItemType to set
	 */
	public void setProrationItemType(String prorationItemType) {
		this.prorationItemType = prorationItemType;
	}
	/**
	 * @return the prorationItemTypeOtherDescription
	 */
	public String getProrationItemTypeOtherDescription() {
		return prorationItemTypeOtherDescription;
	}
	/**
	 * @param prorationItemTypeOtherDescription the prorationItemTypeOtherDescription to set
	 */
	public void setProrationItemTypeOtherDescription(String prorationItemTypeOtherDescription) {
		this.prorationItemTypeOtherDescription = prorationItemTypeOtherDescription;
	}
    
    

}
