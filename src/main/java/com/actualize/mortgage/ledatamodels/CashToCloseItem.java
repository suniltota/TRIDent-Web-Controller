package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * 
 * @author sboragala
 *
 */
public class CashToCloseItem extends MISMODataAccessObject {
	public final String integratedDisclosureCashToCloseItemAmountChangedIndicator;
	public final String integratedDisclosureCashToCloseItemChangeDescription;
	public final String integratedDisclosureCashToCloseItemEstimatedAmount;
	public final String integratedDisclosureCashToCloseItemFinalAmount;
	public final String integratedDisclosureCashToCloseItemPaymentType;
	public final String integratedDisclosureCashToCloseItemType;

	public CashToCloseItem(Element element) {
		super(element);
		integratedDisclosureCashToCloseItemAmountChangedIndicator = getValueAddNS("IntegratedDisclosureCashToCloseItemAmountChangedIndicator");
		integratedDisclosureCashToCloseItemChangeDescription = getValueAddNS("IntegratedDisclosureCashToCloseItemChangeDescription");
		integratedDisclosureCashToCloseItemEstimatedAmount = getValueAddNS("IntegratedDisclosureCashToCloseItemEstimatedAmount");
		integratedDisclosureCashToCloseItemFinalAmount = getValueAddNS("IntegratedDisclosureCashToCloseItemFinalAmount");
		integratedDisclosureCashToCloseItemPaymentType = getValueAddNS("IntegratedDisclosureCashToCloseItemPaymentType");
		integratedDisclosureCashToCloseItemType = getValueAddNS("IntegratedDisclosureCashToCloseItemType");
	}
}
