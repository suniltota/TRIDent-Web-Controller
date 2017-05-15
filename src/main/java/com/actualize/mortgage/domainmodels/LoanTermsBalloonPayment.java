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
	
	/**
	 * @return the balloonIndicator
	 */
	public String getBalloonIndicator() {
		return balloonIndicator;
	}
	/**
	 * @param balloonIndicator the balloonIndicator to set
	 */
	public void setBalloonIndicator(String balloonIndicator) {
		this.balloonIndicator = balloonIndicator;
	}
	/**
	 * @return the balloonPaymentAmount
	 */
	public String getBalloonPaymentAmount() {
		return balloonPaymentAmount;
	}
	/**
	 * @param balloonPaymentAmount the balloonPaymentAmount to set
	 */
	public void setBalloonPaymentAmount(String balloonPaymentAmount) {
		this.balloonPaymentAmount = balloonPaymentAmount;
	}
	
	
	
	
}
