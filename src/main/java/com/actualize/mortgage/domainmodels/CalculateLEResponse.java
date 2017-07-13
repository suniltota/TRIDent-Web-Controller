/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * @author sboragala
 *
 */

public class CalculateLEResponse implements Serializable {

	private static final long serialVersionUID = -102889462055466332L;
	
	private LoanEstimate loanEstimate;
	private ErrorsListModel errorsList;
	/**
	 * @return the loanEstimate
	 */
	public LoanEstimate getLoanEstimate() {
		return loanEstimate;
	}
	/**
	 * @param loanEstimate the loanEstimate to set
	 */
	public void setLoanEstimate(LoanEstimate loanEstimate) {
		this.loanEstimate = loanEstimate;
	}
	/**
	 * @return the errorsList
	 */
	public ErrorsListModel getErrorsList() {
		return errorsList;
	}
	/**
	 * @param errorsList the errorsList to set
	 */
	public void setErrorsList(ErrorsListModel errorsList) {
		this.errorsList = errorsList;
	}

}
