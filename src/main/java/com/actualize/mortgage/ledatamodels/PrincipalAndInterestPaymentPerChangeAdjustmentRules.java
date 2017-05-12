package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines PrincipalAndInterestPaymentPerChangeAdjustmentRules in MISMO XML
 * @author sboragala
 *
 */
public class PrincipalAndInterestPaymentPerChangeAdjustmentRules extends MISMODataAccessObject {
	
	private static final long serialVersionUID = 8689046794744225450L;
	public final PrincipalAndInterestPaymentPerChangeAdjustmentRule[] principalAndInterestPaymentPerChangeAdjustmentRules;
	
	public PrincipalAndInterestPaymentPerChangeAdjustmentRules(Element element) {
		super(element);
		NodeList nodes = getElementsAddNS("PRINCIPAL_AND_INTEREST_PAYMENT_PER_CHANGE_ADJUSTMENT_RULE");
		principalAndInterestPaymentPerChangeAdjustmentRules = new PrincipalAndInterestPaymentPerChangeAdjustmentRule[nodes==null ? 0 : nodes.getLength()];
		for (int i = 0; i < principalAndInterestPaymentPerChangeAdjustmentRules.length; i++)
			principalAndInterestPaymentPerChangeAdjustmentRules[i] = new PrincipalAndInterestPaymentPerChangeAdjustmentRule((Element)nodes.item(i));
	}
}
