/**
 * 
 */
package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 * defines proration item in MISMO XML
 * @author sboragala
 *
 */
public class ProrationItem extends MISMODataAccessObject{
	public String displayLabelText = "";
	public final String integratedDisclosureSectionType;
	public final String integratedDisclosureSubsectionType;
	public final String prorationItemAmount;
	public final String prorationItemPaidFromDate;
	public final String prorationItemPaidThroughDate;
	public final String prorationItemType;
	public final String prorationItemTypeOtherDescription;
	protected ProrationItem(Element e) {
		super(e);
		integratedDisclosureSectionType = getValueAddNS("IntegratedDisclosureSectionType");
		integratedDisclosureSubsectionType = getValueAddNS("IntegratedDisclosureSubsectionType");
		prorationItemAmount = getValueAddNS("ProrationItemAmount");
		prorationItemPaidFromDate = getValueAddNS("ProrationItemPaidFromDate");
		prorationItemPaidThroughDate = getValueAddNS("ProrationItemPaidThroughDate");
		prorationItemType = getValueAddNS("ProrationItemType");
		NodeList node = getElementsAddNS("ProrationItemType");
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
		prorationItemTypeOtherDescription = getValueAddNS("ProrationItemTypeOtherDescription");
	}

}
