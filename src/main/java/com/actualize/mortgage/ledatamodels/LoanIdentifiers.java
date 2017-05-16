package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * Defines loan Identifiers in MISMO XML
 * @author sboragala
 *
 */
public class LoanIdentifiers extends MISMODataAccessObject {
	
	private static final long serialVersionUID = 7035183100459388137L;
	public final LoanIdentifier[] loanIdentifieries;
	
	public LoanIdentifiers(String NS, Element element) {
		super(element);
		NodeList nodes = getElementsAddNS((NS == null ? "" : NS)+"LOAN_IDENTIFIER");
		loanIdentifieries = new LoanIdentifier[nodes==null ? 0 : nodes.getLength()];
		for (int i = 0; i < loanIdentifieries.length; i++)
			loanIdentifieries[i] = new LoanIdentifier((Element)nodes.item(i));		
	}
	public LoanIdentifiers(Element element) {
		//super(element);
		this(null,element);
	}
}
