package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines AboutVersion in MISMO XML
 * @author sboragala
 *
 */
public class AboutVersion extends MISMODataAccessObject {
	
	private static final long serialVersionUID = -3790714989093466205L;
	
	public final String createdDatetime;
	public final String dataVersionIdentifier;
	public final String aboutVersionIdentifier;
	public String identifierOwnerURI = "";
	public AboutVersion(String NS, Element element) {
		super(element);
		createdDatetime = getElementValue(element, NS + "CreatedDatetime");
		dataVersionIdentifier = getElementValue(element, NS + "DataVersionIdentifier");
		aboutVersionIdentifier = getElementValue(element, NS + "AboutVersionIdentifier");
		NodeList node = getElementsAddNS("AboutVersionIdentifier");
		if(null != node)
		{	
			Element ele =(Element)node.item(0);
			if(null != ele)
				identifierOwnerURI = ele.getAttribute("IdentifierOwnerURI");
		}
	}
	public AboutVersion(Element element) {
		this(null,element);
	}
}
