package com.upfpo.app.configuration.exception;

public class FpoNotFoundException extends RuntimeException{
	private String msg = "Fpo details not found..";

	public String getMsg() {
		return msg;
	}
}