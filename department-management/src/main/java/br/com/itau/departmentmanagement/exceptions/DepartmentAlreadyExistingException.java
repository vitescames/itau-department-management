package br.com.itau.departmentmanagement.exceptions;

public class DepartmentAlreadyExistingException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DepartmentAlreadyExistingException() {
		super();
	}

	public DepartmentAlreadyExistingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DepartmentAlreadyExistingException(String message, Throwable cause) {
		super(message, cause);
	}

	public DepartmentAlreadyExistingException(String message) {
		super(message);
	}

	public DepartmentAlreadyExistingException(Throwable cause) {
		super(cause);
	}


}
