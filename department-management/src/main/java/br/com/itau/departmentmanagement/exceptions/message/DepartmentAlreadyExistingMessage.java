package br.com.itau.departmentmanagement.exceptions.message;

import org.springframework.http.HttpStatus;

public class DepartmentAlreadyExistingMessage extends ExceptionMessage{

	public DepartmentAlreadyExistingMessage() {
		super("Department already exists", HttpStatus.BAD_REQUEST.toString());
	}

}
