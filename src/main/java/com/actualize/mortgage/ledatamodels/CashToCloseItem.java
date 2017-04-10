package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * 
 * @author sboragala
 *
 */
public class CashToCloseItem extends MISMODataAccessObject {
	public final String IntegratedDisclosureCashToCloseItemAmountChangedIndicator;
	public final String IntegratedDisclosureCashToCloseItemChangeDescription;
	public final String IntegratedDisclosureCashToCloseItemEstimatedAmount;
	public final String IntegratedDisclosureCashToCloseItemFinalAmount;
	public final String IntegratedDisclosureCashToCloseItemPaymentType;
	public final String IntegratedDisclosureCashToCloseItemType;

	public CashToCloseItem(Element element) {
		super(element);
		IntegratedDisclosureCashToCloseItemAmountChangedIndicator = getValueAddNS("IntegratedDisclosureCashToCloseItemAmountChangedIndicator");
		IntegratedDisclosureCashToCloseItemChangeDescription = getValueAddNS("IntegratedDisclosureCashToCloseItemChangeDescription");
		IntegratedDisclosureCashToCloseItemEstimatedAmount = getValueAddNS("IntegratedDisclosureCashToCloseItemEstimatedAmount");
		IntegratedDisclosureCashToCloseItemFinalAmount = getValueAddNS("IntegratedDisclosureCashToCloseItemFinalAmount");
		IntegratedDisclosureCashToCloseItemPaymentType = getValueAddNS("IntegratedDisclosureCashToCloseItemPaymentType");
		IntegratedDisclosureCashToCloseItemType = getValueAddNS("IntegratedDisclosureCashToCloseItemType");
	}
}
