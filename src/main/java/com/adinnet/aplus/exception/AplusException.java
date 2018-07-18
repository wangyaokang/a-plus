/**
 * 
 */
package com.adinnet.aplus.exception;

import static com.adinnet.framework.web.WebxController.*;

/**
 * @author zhurui
 *
 */
public class AplusException extends RuntimeException {

	private static final long serialVersionUID = 8592777324864320498L;
	
	protected String status = ERROR_UNKNOWN;

	/**
	 * 
	 */
	public AplusException() {
		super();
	}

	/**
	 * @param status
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AplusException(String status, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.status = status;
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AplusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param status
	 * @param message
	 * @param cause
	 */
	public AplusException(String status, String message, Throwable cause) {
		super(message, cause);
		this.status = status;
	}
	
	/**
	 * @param message
	 * @param cause
	 */
	public AplusException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param status
	 * @param message
	 */
	public AplusException(String status, String message) {
		super(message);
		this.status = status;
	}
	
	/**
	 * @param message
	 */
	public AplusException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AplusException(Throwable cause) {
		super(cause);
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
	
}
