package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class LoanTermsBalloonPayment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6088742886056212820L;
	
	private String amount;
	private String status;
	private List<String> details;
	private String balloonIndicator;
	private String balloonPaymentAmount;
	
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the details
	 */
	public List<String> getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(List<String> details) {
		this.details = details;
	}
	public String getBalloonIndicator() {
		return balloonIndicator;
	}
	public void setBalloonIndicator(String balloonIndicator) {
		this.balloonIndicator = balloonIndicator;
	}
	public String getBalloonPaymentAmount() {
		return balloonPaymentAmount;
	}
	public void setBalloonPaymentAmount(String balloonPaymentAmount) {
		this.balloonPaymentAmount = balloonPaymentAmount;
	}

}
