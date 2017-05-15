/**
 * 
 */
package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 * defines LiabilityDetail in MISMO XML
 * @author sboragala
 *
 */
public class LiabilityDetail extends MISMODataAccessObject {

	private static final long serialVersionUID = -3136605525922314698L;
	public String displayLabelText = "";
	public final String liabilityDescription;
	public final String liabilityType;
	public final String liabilityTypeOtherDescription;
	public final Other other;
	protected LiabilityDetail(Element e) {
		super(e);
		liabilityDescription = getValueAddNS("LiabilityDescription");
		liabilityType = getValueAddNS("LiabilityType");
		NodeList node = getElementsAddNS("LiabilityType");
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
		liabilityTypeOtherDescription = getValueAddNS("LiabilityTypeOtherDescription");
		other = new Other((Element)getElementAddNS("EXTENSION/OTHER"));
	}

}
