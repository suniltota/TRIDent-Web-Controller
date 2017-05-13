package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines SalesContractDetail in MISMO XML
 * @author sboragala
 *
 */
public class SalesContractDetail extends MISMODataAccessObject {
	
	private static final long serialVersionUID = -8962026788366709408L;
	public final String personalPropertyAmount;
	public final String personalPropertyIncludedIndicator;
	public final String realPropertyAmount;
	public final String salesContractAmount;
	
	public SalesContractDetail(Element element) {
		super(element);
		personalPropertyAmount = getValueAddNS("PersonalPropertyAmount");
		personalPropertyIncludedIndicator = getValueAddNS("PersonalPropertyIncludedIndicator");
		realPropertyAmount = getValueAddNS("RealPropertyAmount");
		salesContractAmount = getValueAddNS("SalesContractAmount");
	}
}
