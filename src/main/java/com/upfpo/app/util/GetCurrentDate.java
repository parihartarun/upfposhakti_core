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
	
}
