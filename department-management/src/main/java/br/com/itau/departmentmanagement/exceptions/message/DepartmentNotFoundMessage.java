package br.com.itau.departmentmanagement.exceptions.message;

import org.springframework.http.HttpStatus;

public class DepartmentNotFoundMessage extends ExceptionMessage{

	public DepartmentNotFoundMessage() {
		super("Department doesn't exist", HttpStatus.NOT_FOUND.toString());
	}

}
