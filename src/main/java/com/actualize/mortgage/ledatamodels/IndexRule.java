package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines IndexRule in MISMO XML
 * @author sboragala
 *
 */
public class IndexRule extends MISMODataAccessObject {
	public final String indexType;
	public final String indexTypeOtherDescription;
	
	public IndexRule(Element element) {
		super(element);
		indexType = getValueAddNS("IndexType");
		indexTypeOtherDescription = getValueAddNS("IndexTypeOtherDescription");
	}
}
