package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * Defines prepaids Model in UI response
 * @author sboragala
 *
 */
public class Prepaids extends TLCostsModel implements Serializable{

	private static final long serialVersionUID = -3311207376960972497L;
	
	private String gseDisplayLabelText;
	private String displayLabelText;
	private String feePaidToType;
	private String feePaidToTypeOtherDescription;
	private String integratedDisclosureSectionType;
	private String prepaidItemMonthsPaidCount;
	private String prepaidItemPaidFromDate;
	private String prepaidItemPaidThroughDate;
	private String prepaidItemPerDiemAmount;
	private String prepaidItemPerDiemCalculationMethodType;
	private String prepaidItemType;
	private String prepaidItemTypeOtherDescription;
	private boolean regulationZPointsAndFeesIndicator;
	private boolean paymentIncludedInAPRIndicator;
	private String prepaidPaidTo;
	
	
	/**
	 * @return the gseDisplayLabelText
	 */
	public String getGseDisplayLabelText() {
		return gseDisplayLabelText;
	}
	/**
	 * @param gseDisplayLabelText the gseDisplayLabelText to set
	 */
	public void setGseDisplayLabelText(String gseDisplayLabelText) {
		this.gseDisplayLabelText = gseDisplayLabelText;
	}
	/**
	 * @return the displayLabelText
	 */
	public String getDisplayLabelText() {
		return displayLabelText;
	}
	/**
	 * @param displayLabelText the displayLabelText to set
	 */
	public void setDisplayLabelText(String displayLabelText) {
		this.displayLabelText = displayLabelText;
	}
	/**
	 * @return the feePaidToType
	 */
	public String getFeePaidToType() {
		return feePaidToType;
	}
	/**
	 * @param feePaidToType the feePaidToType to set
	 */
	public void setFeePaidToType(String feePaidToType) {
		this.feePaidToType = feePaidToType;
	}
	/**
	 * @return the feePaidToTypeOtherDescription
	 */
	public String getFeePaidToTypeOtherDescription() {
		return feePaidToTypeOtherDescription;
	}
	/**
	 * @param feePaidToTypeOtherDescription the feePaidToTypeOtherDescription to set
	 */
	public void setFeePaidToTypeOtherDescription(String feePaidToTypeOtherDescription) {
		this.feePaidToTypeOtherDescription = feePaidToTypeOtherDescription;
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
	 * @return the prepaidItemMonthsPaidCount
	 */
	public String getPrepaidItemMonthsPaidCount() {
		return prepaidItemMonthsPaidCount;
	}
	/**
	 * @param prepaidItemMonthsPaidCount the prepaidItemMonthsPaidCount to set
	 */
	public void setPrepaidItemMonthsPaidCount(String prepaidItemMonthsPaidCount) {
		this.prepaidItemMonthsPaidCount = prepaidItemMonthsPaidCount;
	}
	/**
	 * @return the prepaidItemPaidFromDate
	 */
	public String getPrepaidItemPaidFromDate() {
		return prepaidItemPaidFromDate;
	}
	/**
	 * @param prepaidItemPaidFromDate the prepaidItemPaidFromDate to set
	 */
	public void setPrepaidItemPaidFromDate(String prepaidItemPaidFromDate) {
		this.prepaidItemPaidFromDate = prepaidItemPaidFromDate;
	}
	/**
	 * @return the prepaidItemPaidThroughDate
	 */
	public String getPrepaidItemPaidThroughDate() {
		return prepaidItemPaidThroughDate;
	}
	/**
	 * @param prepaidItemPaidThroughDate the prepaidItemPaidThroughDate to set
	 */
	public void setPrepaidItemPaidThroughDate(String prepaidItemPaidThroughDate) {
		this.prepaidItemPaidThroughDate = prepaidItemPaidThroughDate;
	}
	/**
	 * @return the prepaidItemPerDiemAmount
	 */
	public String getPrepaidItemPerDiemAmount() {
		return prepaidItemPerDiemAmount;
	}
	/**
	 * @param prepaidItemPerDiemAmount the prepaidItemPerDiemAmount to set
	 */
	public void setPrepaidItemPerDiemAmount(String prepaidItemPerDiemAmount) {
		this.prepaidItemPerDiemAmount = prepaidItemPerDiemAmount;
	}
	/**
	 * @return the prepaidItemPerDiemCalculationMethodType
	 */
	public String getPrepaidItemPerDiemCalculationMethodType() {
		return prepaidItemPerDiemCalculationMethodType;
	}
	/**
	 * @param prepaidItemPerDiemCalculationMethodType the prepaidItemPerDiemCalculationMethodType to set
	 */
	public void setPrepaidItemPerDiemCalculationMethodType(String prepaidItemPerDiemCalculationMethodType) {
		this.prepaidItemPerDiemCalculationMethodType = prepaidItemPerDiemCalculationMethodType;
	}
	/**
	 * @return the prepaidItemType
	 */
	public String getPrepaidItemType() {
		return prepaidItemType;
	}
	/**
	 * @param prepaidItemType the prepaidItemType to set
	 */
	public void setPrepaidItemType(String prepaidItemType) {
		this.prepaidItemType = prepaidItemType;
	}
	/**
	 * @return the prepaidItemTypeOtherDescription
	 */
	public String getPrepaidItemTypeOtherDescription() {
		return prepaidItemTypeOtherDescription;
	}
	/**
	 * @param prepaidItemTypeOtherDescription the prepaidItemTypeOtherDescription to set
	 */
	public void setPrepaidItemTypeOtherDescription(String prepaidItemTypeOtherDescription) {
		this.prepaidItemTypeOtherDescription = prepaidItemTypeOtherDescription;
	}
	/**
	 * @return the regulationZPointsAndFeesIndicator
	 */
	public boolean isRegulationZPointsAndFeesIndicator() {
		return regulationZPointsAndFeesIndicator;
	}
	/**
	 * @param regulationZPointsAndFeesIndicator the regulationZPointsAndFeesIndicator to set
	 */
	public void setRegulationZPointsAndFeesIndicator(boolean regulationZPointsAndFeesIndicator) {
		this.regulationZPointsAndFeesIndicator = regulationZPointsAndFeesIndicator;
	}
	/**
	 * @return the paymentIncludedInAPRIndicator
	 */
	public boolean isPaymentIncludedInAPRIndicator() {
		return paymentIncludedInAPRIndicator;
	}
	/**
	 * @param paymentIncludedInAPRIndicator the paymentIncludedInAPRIndicator to set
	 */
	public void setPaymentIncludedInAPRIndicator(boolean paymentIncludedInAPRIndicator) {
		this.paymentIncludedInAPRIndicator = paymentIncludedInAPRIndicator;
	}
	/**
	 * @return the prepaidPaidTo
	 */
	public String getPrepaidPaidTo() {
		return prepaidPaidTo;
	}
	/**
	 * @param prepaidPaidTo the prepaidPaidTo to set
	 */
	public void setPrepaidPaidTo(String prepaidPaidTo) {
		this.prepaidPaidTo = prepaidPaidTo;
	}
	
}
