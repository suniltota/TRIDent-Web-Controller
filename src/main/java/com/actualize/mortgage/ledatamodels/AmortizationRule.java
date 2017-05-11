package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * defines AmortizationRule in MISMO XML
 * @author sboragala
 *
 */
public class AmortizationRule extends MISMODataAccessObject {

	private static final long serialVersionUID = -1233053842692113481L;

	public final String AmortizationType;
	
	public AmortizationRule(Element element) {
		super(element);
		AmortizationType = getValueAddNS("AmortizationType");
	}
}
