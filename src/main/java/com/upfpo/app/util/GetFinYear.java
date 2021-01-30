package com.upfpo.app.util;
import java.time.LocalDateTime;

public class GetFinYear {
	
	public static String getCurrentFinYear() {
		
		String a  = String.valueOf(LocalDateTime.now().getYear());
		String finYear = null;
		String month = LocalDateTime.now().getMonth().toString();
		
		if(month.equals("JANUARY") || month.equals("FEBRUARY") || month.equals("MARCH"))
		{
			finYear =a+"-"+String.valueOf(LocalDateTime.now().getYear()-1);
		}
		else
		{
			finYear =a+"-"+String.valueOf(LocalDateTime.now().getYear()+1);
		}
		return finYear;
	}
	
	  public static void main(String[] args) {
	  System.out.println(getCurrentFinYear()); }
	 
}
