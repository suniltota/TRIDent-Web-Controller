package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

import com.actualize.mortgage.utils.DocumentType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ClosingDisclosureDocument implements Serializable {
	
	private static final long serialVersionUID = 4671101480733733876L;
	
	private DocumentType documentType;
	private PageOne pageOne;
	private PageTwo pageTwo;
	private PageThree pageThree;
	
	public DocumentType getDocumentType() {
		return documentType;
	}
	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}
	public PageOne getPageOne() {
		return pageOne;
	}
	public void setPageOne(PageOne pageOne) {
		this.pageOne = pageOne;
	}
	public PageTwo getPageTwo() {
		return pageTwo;
	}
	public void setPageTwo(PageTwo pageTwo) {
		this.pageTwo = pageTwo;
	}
	public PageThree getPageThree() {
		return pageThree;
	}
	public void setPageThree(PageThree pageThree) {
		this.pageThree = pageThree;
	}
	

	

}
