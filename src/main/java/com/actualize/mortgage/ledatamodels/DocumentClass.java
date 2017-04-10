package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class DocumentClass extends MISMODataAccessObject {
    public final String documentType;
    public final String documentTypeOtherDescription;
    
	public DocumentClass(Element element) {
		super(element);
		documentType = getValueAddNS("DocumentType");
		documentTypeOtherDescription = getValueAddNS("DocumentTypeOtherDescription");
	}
}
