package com.upfpo.app.configuration.exception;

public class NotFoundException extends RuntimeException{

	private String msg = "Data Not Found";

	public String getMsg() {
		return msg;
	}

}
