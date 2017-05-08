package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 *  this class defines the ClosingCostFund in MISMO XML
 * @author sboragala
 *
 */
public class ClosingCostFund extends MISMODataAccessObject {
	public String displayLabelText;
	public final String closingCostFundAmount;
    public final String fundsType;
    public final String integratedDisclosureSectionType;
	
	protected ClosingCostFund(Element e) {
		super(e);
		closingCostFundAmount = getValueAddNS("ClosingCostFundAmount");
	    fundsType = getValueAddNS("FundsType"); 
	    NodeList node = getElementsAddNS("FundsType");
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
	    integratedDisclosureSectionType = getValueAddNS("IntegratedDisclosureSectionType");
	}

}
