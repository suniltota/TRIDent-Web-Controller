package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * Maps with the Fee Elements of MISMO XML
 * @author sboragala
 *
 */
public class FeeDetail extends MISMODataAccessObject {
	public String displayLabelText = "";
	public final String feeActualTotalAmount;
	public final String feeEstimatedTotalAmount;
	public final String feePaidToType;
	public final String feePaidToTypeOtherDescription;
	public final String feePercentBasisType;
	public final String feeTotalPercent;
	public final String feeType;
	public final String feeTypeOtherDescription;
	public final String integratedDisclosureSectionType;
	public final String optionalCostIndicator;
	public final String regulationZPointsAndFeesIndicator;
	public final String paymentIncludedInAPRIndicator;
	
	public FeeDetail(Element element) {
		super(element);
		feeActualTotalAmount = getValueAddNS("FeeActualTotalAmount");
		feeEstimatedTotalAmount = getValueAddNS("FeeEstimatedTotalAmount");
		feePaidToType = getValueAddNS("FeePaidToType");		
		feePaidToTypeOtherDescription = getValueAddNS("FeePaidToTypeOtherDescription");
		feePercentBasisType = getValueAddNS("FeePercentBasisType");
		feeTotalPercent = getValueAddNS("FeeTotalPercent");
		feeType = getValueAddNS("FeeType");
		NodeList node = getElementsAddNS("FeeType");
		if(null != node)
		{	
			Element ele =(Element)node.item(0);
			if(null != ele)
			{
				displayLabelText = ele.getAttribute("DisplayLabelText");
				if("".equals(displayLabelText) || displayLabelText.isEmpty())
					displayLabelText = ele.getAttribute("gse:DisplayLabelText");
			}
		}
		if("".equals(displayLabelText) || displayLabelText.isEmpty())
			displayLabelText = getAttributeValue("gse:DisplayLabelText");
		if("".equals(displayLabelText) || displayLabelText.isEmpty())
			displayLabelText = getAttributeValue("DisplayLabelText");
		feeTypeOtherDescription = getValueAddNS("FeeTypeOtherDescription");
		integratedDisclosureSectionType = getValueAddNS("IntegratedDisclosureSectionType");
		optionalCostIndicator = getValueAddNS("OptionalCostIndicator");
		regulationZPointsAndFeesIndicator = getValueAddNS("RegulationZPointsAndFeesIndicator");
		paymentIncludedInAPRIndicator = getValueAddNS("EXTENSION/MISMO/PaymentIncludedInAPRIndicator");
	}
	
	public String displayName() {
		if (!displayLabelText.equals(""))
			return displayLabelText;
		if (feeType.equalsIgnoreCase("Other"))
			return feeTypeOtherDescription;
		return feeType;
	}
}
