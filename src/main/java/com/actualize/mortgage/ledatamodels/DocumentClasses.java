package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class DocumentClasses extends MISMODataAccessObject {
    DocumentClass documentClass;
	
    public DocumentClasses(Element element) {
		super(element);
        documentClass = new DocumentClass((Element)getElementAddNS("DOCUMENT_CLASS"));
	}
}
