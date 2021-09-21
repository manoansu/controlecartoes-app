package com.sibs.app.resources.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sibs.app.services.exception.DataIntegrityViolationException;
import com.sibs.app.services.exception.ObjectNotFoundException;

@RestControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public StandardError objectNotFoundException(ObjectNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(Instant.now(), status.value(), "Resource not found", e.getMessage(),
				request.getRequestURI());
		return error;
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public StandardError dataIntegrityViolationException(ObjectNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError error = new StandardError(Instant.now(), status.value(), "Resource not found!", e.getMessage(),
				request.getRequestURI());
		return error;

	}

}
