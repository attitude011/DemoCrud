package com.demo.bci.exceptions;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionGlobalResponse {
	
	@Autowired
	Response result;

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Response> runtimeException(RuntimeException e) {
		result = new Response(new Date(), "[Exception Response] - Exception: " + e.getMessage(), 500, "Error in request Bci Demo");
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> exception(Exception e) {
		result = new Response(new Date(), "[Exception Response] - Exception: " + e.getMessage(), 500, "Error in request Bci Demo");
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Response> notFoundException(NotFoundException e) {
		result = new Response(new Date(), "[Exception Response] - Exception: " + e.getMessage(), 404, "Error in request Bci Demo");
		return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
	}


}
