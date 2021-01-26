package br.com.itau.departmentmanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.itau.departmentmanagement.response.ResponseMessage;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = { DepartmentNotFoundException.class})
    public ResponseEntity<Object> handleDepartmentNotFound(Exception ex, WebRequest request) {
		ex.printStackTrace();		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).
				body(new ResponseMessage(HttpStatus.NOT_FOUND.toString(), "Department ID doesn't exist"));
    }
	
	@ExceptionHandler(value = { BoardNotFoundException.class})
    public ResponseEntity<Object> handleBoardNotFound(Exception ex, WebRequest request) {
		ex.printStackTrace();		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).
				body(new ResponseMessage(HttpStatus.NOT_FOUND.toString(), "Board ID doesn't exist"));
    }

}
