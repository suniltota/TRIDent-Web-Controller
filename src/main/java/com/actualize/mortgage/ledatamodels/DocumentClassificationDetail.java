/**
 * 
 */
package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

/**
 * this class defines DocumentClassificationDetail in MISMO XML
 * @author sboragala
 *
 */
public class DocumentClassificationDetail extends MISMODataAccessObject {

	private static final long serialVersionUID = 1299250190573158433L;
	
	public final String documentFormIssuingEntityNameType;
	public final String documentFormIssuingEntityVersionIdentifier;
	public final Other other;

	protected DocumentClassificationDetail(Element e) {
		super(e);
		documentFormIssuingEntityNameType = getValueAddNS("DocumentFormIssuingEntityNameType");
		documentFormIssuingEntityVersionIdentifier = getValueAddNS("DocumentFormIssuingEntityVersionIdentifier");
		other = new Other((Element)getElementAddNS("EXTENSION/OTHER"));
	}

}
