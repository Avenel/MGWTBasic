package de.hska.iwi.mgwt.demo.backend.exception;

/**
 * Thrown if something went wrong with the Request.
 * @author Nico
 */
@SuppressWarnings("serial")
public class FailedRequestException extends RuntimeException {

	/**
	 * C'tor for creating a new FailedRequestException
	 */
	public FailedRequestException() {
		super();
	}

	/**
	 * C'tor for creating a new FailedRequestException with a detailed message.
	 * @param message the details message
	 */
	public FailedRequestException(String message) {
		super(message);
	}

	/**
	 * C'tor for creating a new FailedRequestException with Throwable as a cause
	 * @param cause thr origin throwable
	 */
	public FailedRequestException(Throwable cause) {
		super(cause);
	}

	/**
	 * C'tor for creating a new FailedRequestException
	 * @param message details message
	 * @param cause another Throwable
	 */
	public FailedRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * C'tor for creating a new FailedRequestException
	 * @param message detailed message
	 * @param cause antoher Throwable
	 * @param enableSuppression whether or not suppression is enabled or disabled
	 * @param writableStackTrace whether or not the stack trace should be writable
	 */
	public FailedRequestException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
