package com.actualize.mortgage.exceptions;

/**
 * @author sboragala
 *
 */
public class ServiceException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message;

    /**
     * @param message
     * @param cause
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     */
    public ServiceException(String message) {
        super(message);
        this.message=message;
    }

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
}
