package com.actualize.mortgage.lepagemodels;

import java.io.Serializable;
/**
 * 
 * @author sboragala
 *
 */
public class LoanEstimateSectionRateLock implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -406962959978270500L;
	private String rateLock;
	private String untillDate;
	private String untillTimeZone;
	private String expireDate;
	private String expireTime;
	private String expireTimeZone;
	/**
	 * @return the rateLock
	 */
	public String getRateLock() {
		return rateLock;
	}
	/**
	 * @param rateLock the rateLock to set
	 */
	public void setRateLock(String rateLock) {
		this.rateLock = rateLock;
	}
	/**
	 * @return the untillDate
	 */
	public String getUntillDate() {
		return untillDate;
	}
	/**
	 * @param untillDate the untillDate to set
	 */
	public void setUntillDate(String untillDate) {
		this.untillDate = untillDate;
	}
	/**
	 * @return the untillTimeZone
	 */
	public String getUntillTimeZone() {
		return untillTimeZone;
	}
	/**
	 * @param untillTimeZone the untillTimeZone to set
	 */
	public void setUntillTimeZone(String untillTimeZone) {
		this.untillTimeZone = untillTimeZone;
	}
	/**
	 * @return the expireDate
	 */
	public String getExpireDate() {
		return expireDate;
	}
	/**
	 * @param expireDate the expireDate to set
	 */
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	/**
	 * @return the expireTime
	 */
	public String getExpireTime() {
		return expireTime;
	}
	/**
	 * @param expireTime the expireTime to set
	 */
	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}
	/**
	 * @return the expireTimeZone
	 */
	public String getExpireTimeZone() {
		return expireTimeZone;
	}
	/**
	 * @param expireTimeZone the expireTimeZone to set
	 */
	public void setExpireTimeZone(String expireTimeZone) {
		this.expireTimeZone = expireTimeZone;
	}
	
	
}
