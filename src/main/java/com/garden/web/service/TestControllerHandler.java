package com.garden.web.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.garden.web.throwable.ResourceNotFoundException;

@ControllerAdvice
public class TestControllerHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="sorry,resource not found")
	public void handlerGetResource(){
		System.out.println("getResource exception happened qaq");
	}
}
