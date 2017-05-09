package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines LicenseDetail in MISMO XML
 * @author sboragala
 *
 */
public class LicenseDetail extends MISMODataAccessObject {
	public final String licenseAuthorityLevelType;
	public final String licenseIdentifier;
	public String identifierOwnerURI;
	public final String licenseIssueDate;
	public final String licenseIssuingAuthorityName;
	public final String licenseIssuingAuthorityStateCode;
	
	public LicenseDetail(Element element) {
		super(element);
		licenseAuthorityLevelType = getValueAddNS("LicenseAuthorityLevelType");
		licenseIdentifier = getValueAddNS("LicenseIdentifier");
		NodeList node = getElementsAddNS("LicenseIdentifier");
		if(null != node)
		{	
			Element ele =(Element)node.item(0);
			if(null != ele)
			{
				identifierOwnerURI = ele.getAttribute("IdentifierOwnerURI");
			}
		}
		licenseIssueDate = getValueAddNS("LicenseIssueDate");
		licenseIssuingAuthorityName = getValueAddNS("LicenseIssuingAuthorityName");
		licenseIssuingAuthorityStateCode = getValueAddNS("LicenseIssuingAuthorityStateCode");
	}
}
