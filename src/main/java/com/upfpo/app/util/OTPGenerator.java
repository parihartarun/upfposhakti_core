package com.upfpo.app.util;
import java.util.Random;

public class OTPGenerator {

	 public  char[] OTP() 
	    {
		    int len= 6;
	        String numbers = "023456789abcdefghijkmnopqrstuvwxyzABCDEFGHJKMNOPQRSTUVWXYZ"; 	  
	        Random rndm_method = new Random(); 
	        char[] otp = new char[len]; 
	        for (int i = 0; i < len; i++) 
	        { 
	        	otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length())); 
	        }
	        return otp; 
	    }
}
