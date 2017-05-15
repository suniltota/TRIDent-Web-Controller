/**
 * @(#)ClosingDisclosureDocumentType.java 1.0 04/11/2017
 */
package com.actualize.mortgage.cdpagemodels;

import java.io.Serializable;

/**
 * This class is used to represent document level variables to quickly verify across all the pages.
 * @author rsudula
 * version : 1.0
 *
 */
public class ClosingDisclosureDocumentDetails implements Serializable {

    private static final long serialVersionUID = 1957140105029843535L;

    private String transactionType;
    private String documentType;
    private boolean isSellerOnly;
    private boolean isStandard;
    private boolean isAlternativeView;
	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}
	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	/**
	 * @return the documentType
	 */
	public String getDocumentType() {
		return documentType;
	}
	/**
	 * @param documentType the documentType to set
	 */
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	/**
	 * @return the isSellerOnly
	 */
	public boolean isSellerOnly() {
		return isSellerOnly;
	}
	/**
	 * @param isSellerOnly the isSellerOnly to set
	 */
	public void setSellerOnly(boolean isSellerOnly) {
		this.isSellerOnly = isSellerOnly;
	}
	/**
	 * @return the isStandard
	 */
	public boolean isStandard() {
		return isStandard;
	}
	/**
	 * @param isStandard the isStandard to set
	 */
	public void setStandard(boolean isStandard) {
		this.isStandard = isStandard;
	}
	/**
	 * @return the isAlternativeView
	 */
	public boolean isAlternativeView() {
		return isAlternativeView;
	}
	/**
	 * @param isAlternativeView the isAlternativeView to set
	 */
	public void setAlternativeView(boolean isAlternativeView) {
		this.isAlternativeView = isAlternativeView;
	}
    
    
	
}
