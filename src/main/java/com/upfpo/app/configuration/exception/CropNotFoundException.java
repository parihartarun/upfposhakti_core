package com.upfpo.app.configuration.exception;

public class CropNotFoundException extends RuntimeException{
	private String msg = "Crop not found..";

	public String getMsg() {
		return msg;
	}
}
