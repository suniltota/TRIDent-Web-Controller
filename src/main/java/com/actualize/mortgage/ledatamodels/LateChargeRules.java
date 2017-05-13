/**
 * 
 */
package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 * this class defines LateChargeRules in MISMO XML 
 * @author sboragala
 *
 */
public class LateChargeRules extends MISMODataAccessObject {

	private static final long serialVersionUID = -3816658692888333944L;
	
	public LateChargeRule[] lateChargeRules;

	protected LateChargeRules(Element e) {
		super(e);
		NodeList nodes = getElementsAddNS("FEE");
		lateChargeRules = new LateChargeRule[nodes==null ? 0 : nodes.getLength()];
		for (int i = 0; i < lateChargeRules.length; i++)
			lateChargeRules[i] = new LateChargeRule((Element)nodes.item(i));
		
	}

}
