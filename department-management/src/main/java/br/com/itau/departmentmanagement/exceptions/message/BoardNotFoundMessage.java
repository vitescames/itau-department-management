package br.com.itau.departmentmanagement.exceptions.message;

import org.springframework.http.HttpStatus;

public class BoardNotFoundMessage extends ExceptionMessage{

	public BoardNotFoundMessage() {
		super("Board ID doesn't exist", HttpStatus.NOT_FOUND.toString());
	}

}
