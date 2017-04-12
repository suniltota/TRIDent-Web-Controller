/**
 * @(#)ClosingDisclosurePageOne.java 1.0 04/10/2017
 */
package com.actualize.mortgage.cdpagemodels;

import java.io.Serializable;
import java.util.List;

import com.actualize.mortgage.domainmodels.CashToClose;
import com.actualize.mortgage.domainmodels.SummariesofTransactions;

/**
 * This class represents all the sections present in Closing Disclosure Form Page-3
 * @author rsudula
 * @version 1.0
 */
public class ClosingDisclosurePageThree implements Serializable {
    
    private static final long serialVersionUID = 8155245346743820565L;
    
    private List<CashToClose> cashToCloses;
    private SummariesofTransactions summariesofTransactions;
    /**
     * @return the cashToCloses
     */
    public List<CashToClose> getCashToCloses() {
        return cashToCloses;
    }
    /**
     * @param cashToCloses the cashToCloses to set
     */
    public void setCashToCloses(List<CashToClose> cashToCloses) {
        this.cashToCloses = cashToCloses;
    }
    /**
     * @return the summariesofTransactions
     */
    public SummariesofTransactions getSummariesofTransactions() {
        return summariesofTransactions;
    }
    /**
     * @param summariesofTransactions the summariesofTransactions to set
     */
    public void setSummariesofTransactions(SummariesofTransactions summariesofTransactions) {
        this.summariesofTransactions = summariesofTransactions;
    }

}
