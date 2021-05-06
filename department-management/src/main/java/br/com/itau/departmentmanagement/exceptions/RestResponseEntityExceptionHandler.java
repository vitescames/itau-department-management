package br.com.itau.departmentmanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.itau.departmentmanagement.exceptions.message.BoardNotFoundMessage;
import br.com.itau.departmentmanagement.exceptions.message.DepartmentAlreadyExistingMessage;
import br.com.itau.departmentmanagement.exceptions.message.DepartmentNotFoundMessage;
import br.com.itau.departmentmanagement.response.ResponseMessage;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = { DepartmentNotFoundException.class})
    public ResponseEntity<Object> handleDepartmentNotFound(Exception ex, WebRequest request) {
		ex.printStackTrace();		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).
				body(new DepartmentNotFoundMessage());
    }
	
	@ExceptionHandler(value = { BoardNotFoundException.class})
    public ResponseEntity<Object> handleBoardNotFound(Exception ex, WebRequest request) {
		ex.printStackTrace();		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).
				body(new BoardNotFoundMessage());
    }
	
	@ExceptionHandler(value = { DepartmentAlreadyExistingException.class})
    public ResponseEntity<Object> handleDepartmentAlreadyExisting(Exception ex, WebRequest request) {
		ex.printStackTrace();		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).
				body(new DepartmentAlreadyExistingMessage());
    }

}
