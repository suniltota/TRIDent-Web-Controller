package com.actualize.mortgage.domainmodels;
/**
 * Defines prepaids Model in UI response
 * @author sboragala
 *
 */
public class Prepaids extends ClosingCostProperties {

	private static final long serialVersionUID = -3311207376960972497L;
	
	private String fromDate;
	private String toDate;
	private String months;
	
	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public String getFromDate() {
		return fromDate;
	}
	
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	


}
