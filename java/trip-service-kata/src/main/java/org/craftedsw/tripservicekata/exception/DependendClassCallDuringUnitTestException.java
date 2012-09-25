package org.craftedsw.tripservicekata.exception;

public class DependendClassCallDuringUnitTestException extends RuntimeException {

	private static final long serialVersionUID = -4584041339906109902L;

	public DependendClassCallDuringUnitTestException() {
		super();
	}

	public DependendClassCallDuringUnitTestException(String message,
			Throwable cause) {
		super(message, cause);
	}

	public DependendClassCallDuringUnitTestException(String message) {
		super(message);
	}

	public DependendClassCallDuringUnitTestException(Throwable cause) {
		super(cause);
	}

	
}
