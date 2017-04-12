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
public class ClosingDisclosureDocumentType implements Serializable {

    private static final long serialVersionUID = 1957140105029843535L;

    private String loanId;
    private String loanType;
    private String viewType;
    private boolean payoffsAndPayments = false;

    /**
     * @return the loanId
     */
    public String getLoanId() {
        return loanId;
    }

    /**
     * @param loanId
     *            the loanId to set
     */
    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    /**
     * @return the loanType
     */
    public String getLoanType() {
        return loanType;
    }

    /**
     * @param loanType
     *            the loanType to set
     */
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    /**
     * @return the viewType
     */
    public String getViewType() {
        return viewType;
    }

    /**
     * @param viewType
     *            the viewType to set
     */
    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    /**
     * @return the payoffsAndPayments
     */
    public boolean isPayoffsAndPayments() {
        return payoffsAndPayments;
    }

    /**
     * @param payoffsAndPayments
     *            the payoffsAndPayments to set
     */
    public void setPayoffsAndPayments(boolean payoffsAndPayments) {
        this.payoffsAndPayments = payoffsAndPayments;
    }

}
