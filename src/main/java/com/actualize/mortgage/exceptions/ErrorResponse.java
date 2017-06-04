package com.actualize.mortgage.exceptions;

import java.io.Serializable;

/**
 * defines the structure of exception to be thrown to UI 
 * @author sboragala
 *
 */
public class ErrorResponse implements Serializable {
	
	private static final long serialVersionUID = 236576025959648739L;
	
	private int errorCode;
	private String message;
	private Exception detail;
	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the detail
	 */
	public Exception getDetail() {
		return detail;
	}
	/**
	 * @param detail the detail to set
	 */
	public void setDetail(Exception detail) {
		this.detail = detail;
	}
	
	
}
