package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines DocumentClasses in MISMO XML
 * @author sboragala
 *
 */
public class DocumentClasses extends MISMODataAccessObject {
  
	private static final long serialVersionUID = -1516597567986955458L;
	public DocumentClass documentClass;
	
    public DocumentClasses(Element element) {
		super(element);
        documentClass = new DocumentClass((Element)getElementAddNS("DOCUMENT_CLASS"));
	}
}
