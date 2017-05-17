package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class PropertyValuationDetail extends MISMODataAccessObject {

	private static final long serialVersionUID = -5802480622181227042L;
	public String identifierOwnerURI = "";
	public final String propertyValuationAmount;
	public final String propertyValuationMethodType;
	public final String propertyValuationMethodTypeOtherDescription;
	
	public PropertyValuationDetail(Element element) {
		super(element);
		//IdentifierOwnerURI = getValueAddNS("IdentifierOwnerURI");
		NodeList node = getElementsAddNS("FeeType");
		if(null != node)
		{	
			Element ele =(Element)node.item(0);
			if(null != ele)
			{
				identifierOwnerURI = ele.getAttribute("IdentifierOwnerURI");
				if("".equals(identifierOwnerURI) || identifierOwnerURI.isEmpty())
					identifierOwnerURI = ele.getAttribute("gse:DisplayLabelText");
			}
		}
		propertyValuationAmount = getValueAddNS("PropertyValuationAmount");
		propertyValuationMethodType = getValueAddNS("PropertyValuationMethodType");
		propertyValuationMethodTypeOtherDescription = getValueAddNS("PropertyValuationMethodTypeOtherDescription");
	}
}
