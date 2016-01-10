package com.github.mdjc.youmeal.web;

import java.util.NoSuchElementException;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestAPIControllerAdvice {

	@ResponseBody
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public VndErrors noSuchElementExceptionHandler(NoSuchElementException ex) {
		return new VndErrors("error", ex.getMessage());
	}
}
