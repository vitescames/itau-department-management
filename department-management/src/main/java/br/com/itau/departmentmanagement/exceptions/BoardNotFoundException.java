package br.com.itau.departmentmanagement.exceptions;

public class BoardNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BoardNotFoundException() {
		super();
	}

	public BoardNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BoardNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BoardNotFoundException(String message) {
		super(message);
	}

	public BoardNotFoundException(Throwable cause) {
		super(cause);
	}


}
