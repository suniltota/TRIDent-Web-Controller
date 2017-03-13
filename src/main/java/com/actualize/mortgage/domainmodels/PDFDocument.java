package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

import com.actualize.mortgage.utils.DocumentType;

public class PDFDocument implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4671101480733733876L;
	
	private DocumentType documentType;
	private PageOne pageOne;
	private PageTwo pageTwo;
	
	/**
	 * @return the documentType
	 */
	public DocumentType getDocumentType() {
		return documentType;
	}
	/**
	 * @param documentType the documentType to set
	 */
	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}
	/**
	 * @return the pageOne
	 */
	public PageOne getPageOne() {
		return pageOne;
	}
	/**
	 * @param pageOne the pageOne to set
	 */
	public void setPageOne(PageOne pageOne) {
		this.pageOne = pageOne;
	}
	/**
	 * @return the pageTwo
	 */
	public PageTwo getPageTwo() {
		return pageTwo;
	}
	/**
	 * @param pageTwo the pageTwo to set
	 */
	public void setPageTwo(PageTwo pageTwo) {
		this.pageTwo = pageTwo;
	}


	

}
