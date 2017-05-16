/**
 * 
 */
package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 * defines AutomatedUnderwritings in MISMO XML
 * @author sboragala
 *
 */
public class AutomatedUnderwritings extends MISMODataAccessObject {
	private static final long serialVersionUID = 6772013937327128363L;
	public final AutomatedUnderwriting[] automatedUnderwriting;
	public AutomatedUnderwritings(Element e) {
		super(e);
		NodeList nodes = getElementsAddNS((NS == null ? "" : NS)+"AUTOMATED_UNDERWRITING");
		automatedUnderwriting = new AutomatedUnderwriting[nodes==null ? 0 : nodes.getLength()];
		for (int i = 0; i < automatedUnderwriting.length; i++)
			automatedUnderwriting[i] = new AutomatedUnderwriting((Element)nodes.item(i));	
	}

}
