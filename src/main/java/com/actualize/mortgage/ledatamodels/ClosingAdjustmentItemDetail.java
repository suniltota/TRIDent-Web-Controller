/**
 * 
 */
package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 * @author sboragala
 *
 */
public class ClosingAdjustmentItemDetail extends MISMODataAccessObject {
	
	public String displayLabelText;
	public final String closingAdjustmentItemAmount;
	public final String closingAdjustmentItemPaidOutsideOfClosingIndicator;
	public final String closingAdjustmentItemType;
	public final String closingAdjustmentItemTypeOtherDescription;
	public final String integratedDisclosureSectionType;
	public final String integratedDisclosureSubsectionType;

	protected ClosingAdjustmentItemDetail(Element e) {
		super(e);
		
		closingAdjustmentItemAmount = getValueAddNS("ClosingAdjustmentItemAmount");
	    closingAdjustmentItemPaidOutsideOfClosingIndicator = getValueAddNS("ClosingAdjustmentItemPaidOutsideOfClosingIndicator");
	    closingAdjustmentItemType = getValueAddNS("ClosingAdjustmentItemType");
	    NodeList node = getElementsAddNS("ClosingAdjustmentItemType");
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
	    closingAdjustmentItemTypeOtherDescription = getValueAddNS("ClosingAdjustmentItemTypeOtherDescription");
	    integratedDisclosureSectionType = getValueAddNS("IntegratedDisclosureSectionType");
	    integratedDisclosureSubsectionType = getValueAddNS("IntegratedDisclosureSubsectionType");
	}

}
