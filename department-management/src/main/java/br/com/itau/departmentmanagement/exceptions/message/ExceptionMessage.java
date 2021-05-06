package br.com.itau.departmentmanagement.exceptions.message;

class ExceptionMessage {
	
	protected String error;
	
	protected String code;

	public ExceptionMessage(String error, String code) {
		this.error = error;
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}	

}
