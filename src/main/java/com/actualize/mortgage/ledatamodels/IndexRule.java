package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines IndexRule in MISMO XML
 * @author sboragala
 *
 */
public class IndexRule extends MISMODataAccessObject {
	
	private static final long serialVersionUID = 1925424467713795366L;
	
	public final String indexType;
	public final String indexTypeOtherDescription;
	
	public IndexRule(Element element) {
		super(element);
		indexType = getValueAddNS("IndexType");
		indexTypeOtherDescription = getValueAddNS("IndexTypeOtherDescription");
	}
}
