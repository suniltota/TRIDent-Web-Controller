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

    private String loanId;
    private boolean payoffsAndPayments;
    private boolean isSellerOnly;
    private boolean isBorrowerOnly;
    private boolean isAlternativeView;
    private boolean isStandardView;
    private boolean isRefinanceTypeLoan;
    private boolean isHomeEquityLoanIndicator;
    
    
	/**
	 * @return the loanId
	 */
	public String getLoanId() {
		return loanId;
	}
	/**
	 * @param loanId the loanId to set
	 */
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	/**
	 * @return the payoffsAndPayments
	 */
	public boolean isPayoffsAndPayments() {
		return payoffsAndPayments;
	}
	/**
	 * @param payoffsAndPayments the payoffsAndPayments to set
	 */
	public void setPayoffsAndPayments(boolean payoffsAndPayments) {
		this.payoffsAndPayments = payoffsAndPayments;
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
	 * @return the isBorrowerOnly
	 */
	public boolean isBorrowerOnly() {
		return isBorrowerOnly;
	}
	/**
	 * @param isBorrowerOnly the isBorrowerOnly to set
	 */
	public void setBorrowerOnly(boolean isBorrowerOnly) {
		this.isBorrowerOnly = isBorrowerOnly;
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
	/**
	 * @return the isStandardView
	 */
	public boolean isStandardView() {
		return isStandardView;
	}
	/**
	 * @param isStandardView the isStandardView to set
	 */
	public void setStandardView(boolean isStandardView) {
		this.isStandardView = isStandardView;
	}
	/**
	 * @return the isRefinanceTypeLoan
	 */
	public boolean isRefinanceTypeLoan() {
		return isRefinanceTypeLoan;
	}
	/**
	 * @param isRefinanceTypeLoan the isRefinanceTypeLoan to set
	 */
	public void setRefinanceTypeLoan(boolean isRefinanceTypeLoan) {
		this.isRefinanceTypeLoan = isRefinanceTypeLoan;
	}
	/**
	 * @return the isHomeEquityLoanIndicator
	 */
	public boolean isHomeEquityLoanIndicator() {
		return isHomeEquityLoanIndicator;
	}
	/**
	 * @param isHomeEquityLoanIndicator the isHomeEquityLoanIndicator to set
	 */
	public void setHomeEquityLoanIndicator(boolean isHomeEquityLoanIndicator) {
		this.isHomeEquityLoanIndicator = isHomeEquityLoanIndicator;
	}
    
}
