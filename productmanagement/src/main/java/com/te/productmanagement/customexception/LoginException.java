package com.te.productmanagement.customexception;

public class LoginException extends RuntimeException {
	
	public LoginException(String msg) {
		super(msg);
	}

}
