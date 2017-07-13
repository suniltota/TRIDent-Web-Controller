/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

import com.actualize.mortgage.cd.domainmodels.ClosingDisclosure;

/**
 * @author sboragala
 *
 */

public class CalculateCDResponse implements Serializable {

	private static final long serialVersionUID = -102889462055466332L;
	
	private ClosingDisclosure closingDisclosure;
	private ErrorsListModel errorsList;
	
	/**
	 * @return the closingDisclosure
	 */
	public ClosingDisclosure getClosingDisclosure() {
		return closingDisclosure;
	}
	/**
	 * @param closingDisclosure the closingDisclosure to set
	 */
	public void setClosingDisclosure(ClosingDisclosure closingDisclosure) {
		this.closingDisclosure = closingDisclosure;
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
