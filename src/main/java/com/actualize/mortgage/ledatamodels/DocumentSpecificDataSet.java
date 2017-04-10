package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class DocumentSpecificDataSet extends MISMODataAccessObject {
	public final Execution execution;
	public final IntegratedDisclosure integratedDisclosure;
	public final URLA urla;

	public DocumentSpecificDataSet(String NS, Element element) {
		super(element);
		execution = new Execution(NS, element);
		integratedDisclosure = new IntegratedDisclosure(NS, element);
		urla = new URLA(NS, element);
	}

}
