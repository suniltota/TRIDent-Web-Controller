package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class DocumentClassification extends MISMODataAccessObject {
	DocumentClasses documentClasses;
    
    public DocumentClassification(String NS, Element element) {
		super(element);
		Element elem;
        elem = getElement(element, NS + "DOCUMENT_CLASSES");
        documentClasses = elem == null ? null : new DocumentClasses(elem);
	}
}
