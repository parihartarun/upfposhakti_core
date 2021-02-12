package com.upfpo.app.configuration.exception;


	public class UserNotFoundException extends RuntimeException{
		private String msg = "User details not found..";

		public String getMsg() {
			return msg;
		}
	}

