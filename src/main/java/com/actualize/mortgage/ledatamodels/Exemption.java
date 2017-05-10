/**
 * 
 */
package com.actualize.mortgage.ledatamodels;

import java.io.Serializable;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 * this class defines Exemption in MISMO XML
 * @author sboragala
 *
 */
public class Exemption extends MISMODataAccessObject implements Serializable {

	private static final long serialVersionUID = 3084196305020133649L;

	public final String abilityToRepayExemptionReasonType;
	protected Exemption(Element e) {
		super(e);
		abilityToRepayExemptionReasonType = getValueAddNS("AbilityToRepayExemptionReasonType");
	}

}
