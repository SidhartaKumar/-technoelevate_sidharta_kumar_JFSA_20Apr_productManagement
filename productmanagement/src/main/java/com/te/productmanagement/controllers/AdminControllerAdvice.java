package com.te.productmanagement.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.te.productmanagement.customexception.LoginException;

@ControllerAdvice
public class AdminControllerAdvice {
	
	
	@ExceptionHandler(LoginException.class)
	public String handleExp(LoginException exception,HttpServletRequest req ) {
		req.setAttribute("errMsg", exception.getMessage());
		return "login";
	}

}
