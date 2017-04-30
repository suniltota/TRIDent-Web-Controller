package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class PrepaidItemDetail extends MISMODataAccessObject {
	public String displayLabelText = "";
	public final String feePaidToType;
	public final String feePaidToTypeOtherDescription;
	public final String integratedDisclosureSectionType;
	public final String prepaidItemEstimatedTotalAmount;
	public final String prepaidItemMonthsPaidCount;
	public final String prepaidItemNumberOfDaysCount;
	public final String prepaidItemPaidFromDate;
	public final String prepaidItemPaidThroughDate;
	public final String prepaidItemPerDiemAmount;
	public final String prepaidItemPerDiemCalculationMethodType;
	public final String prepaidItemType;
	public final String prepaidItemTypeOtherDescription;
	public final String regulationZPointsAndFeesIndicator;
	public final String paymentIncludedInAPRIndicator;
	
	public PrepaidItemDetail(Element element) {
		super(element);
		feePaidToType = getValueAddNS("FeePaidToType");
		feePaidToTypeOtherDescription = getValueAddNS("FeePaidToTypeOtherDescription");
		integratedDisclosureSectionType = getValueAddNS("IntegratedDisclosureSectionType");
		prepaidItemEstimatedTotalAmount = getValueAddNS("PrepaidItemEstimatedTotalAmount");
		prepaidItemMonthsPaidCount = getValueAddNS("PrepaidItemMonthsPaidCount");
		prepaidItemNumberOfDaysCount = getValueAddNS("PrepaidItemNumberOfDaysCount");
		prepaidItemPaidFromDate = getValueAddNS("PrepaidItemPaidFromDate");
		prepaidItemPaidThroughDate = getValueAddNS("PrepaidItemPaidThroughDate");
		prepaidItemPerDiemAmount = getValueAddNS("PrepaidItemPerDiemAmount");
		prepaidItemPerDiemCalculationMethodType = getValueAddNS("PrepaidItemPerDiemCalculationMethodType");
		prepaidItemType = getValueAddNS("PrepaidItemType");
		NodeList node = getElementsAddNS("PrepaidItemType");
		if(null != node)
		{	
			Element ele =(Element)node.item(0);
			if(null != ele){
				displayLabelText = ele.getAttribute("DisplayLabelText");
				if("".equals(displayLabelText) || displayLabelText.isEmpty())
					displayLabelText = ele.getAttribute("gse:DisplayLabelText");
			}
		}
		if("".equals(displayLabelText) || displayLabelText.isEmpty())
			displayLabelText = getAttributeValue("gse:DisplayLabelText");
		
		if("".equals(displayLabelText) || displayLabelText.isEmpty())
			displayLabelText = getAttributeValue("DisplayLabelText");

		prepaidItemTypeOtherDescription = getValueAddNS("PrepaidItemTypeOtherDescription");
		regulationZPointsAndFeesIndicator = getValueAddNS("RegulationZPointsAndFeesIndicator");
		paymentIncludedInAPRIndicator = getValueAddNS("EXTENSION/MISMO/PaymentIncludedInAPRIndicator");
	}
	
	public String displayName() {
		String str = prepaidItemType;
		if (!displayLabelText.equals(""))
			str = displayLabelText;
		else if (prepaidItemType.equalsIgnoreCase("Other"))
			str = prepaidItemTypeOtherDescription;
		return canonicalLabel(str);
	}
}
