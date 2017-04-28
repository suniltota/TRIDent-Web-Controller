package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
/**
 * defines BalloonPayment of Loan Terms in JSON Response 
 * @author sboragala
 *
 */
public class LoanTermsBalloonPayment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6088742886056212820L;
	
	private String balloonIndicator;
	private String balloonPaymentAmount;
	
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
