package com.upfpo.app.util;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetCurrentDate {
	
	public static Date getDate()
	{
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		   LocalDateTime now = LocalDateTime.now();
		   return java.sql.Date.valueOf(now.toLocalDate());
	}
	
	
public static String getCurrentFinYear() {
		
		String a  = String.valueOf(LocalDateTime.now().getYear());
		String finYear = null;
		String month = LocalDateTime.now().getMonth().toString();
		
		if(month.equals("JANUARY") || month.equals("FEBRUARY") || month.equals("MARCH"))
		{
			finYear =Integer.parseInt(a)-1+"-"+a.toString();
		}
		else
		{
			finYear =a+"-"+String.valueOf(LocalDateTime.now().getYear()+1);
		}
		return finYear;
	}
	
	
	
}
