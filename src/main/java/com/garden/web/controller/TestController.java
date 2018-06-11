package com.garden.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.garden.web.throwable.ResourceNotFoundException;

@Controller
@RequestMapping(value="/test")
public class TestController {
	
	@RequestMapping(value="/home")
	public String toHome(){
		return "home";
	}
	
	@RequestMapping(value="/getResource")
	public void getResource(){
		//...
		throw new ResourceNotFoundException();
	}
	
}
