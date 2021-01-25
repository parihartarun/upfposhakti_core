package com.upfpo.app.util;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class Sender {
	
  // private static final Logger logger = Logger.getLogger(Sender.class);
	
	@Autowired
	private static JavaMailSender mailSender; 
	
	/*
	 * public void sendMail(String to) { String subject =
	 * "<h1>This is actual message embedded in HTML tags</h1>"; SimpleMailMessage
	 * email = new SimpleMailMessage(); email.setTo(to); email.setSubject(subject);
	 * email.setText(""); logger.info("Email Being Sent"); mailSender.send(email);
	 * logger.info("Email Sent Successfully"); }
	 */
	 
	
	public static void  sendMail(String to,String subject,String text ) throws Exception 
	{
		try {
			SimpleMailMessage email = new SimpleMailMessage();  
			  email.setTo(to); 
			  email.setSubject(subject);
			  email.setText(text);
	//		  logger.info("Email Being Sent");
			  mailSender.send(email);
		//	  logger.info("Email Sent Successfully");
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public static int sendSMS(String textMessage,  String commaSeperatedMobileNo)throws Exception
	 {
	 int responseCode;
	try {
		String url = "http://mkisan.gov.in/ksewa/ksewa.aspx"; 
		 StringBuffer urlParameters=new StringBuffer();
		 URL obj = new URL(url);
		 HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		 //add reuqest header con.setRequestMethod("POST");
		 //con.setRequestProperty("User-Agent", USER_AGENT);
		 con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		 urlParameters.append("userId=testuser&authCode=8625982");
		 urlParameters.append("&txtMsg="+textMessage);
		 urlParameters.append("&SMSMode=O");
		 urlParameters.append("&mobileNo="+commaSeperatedMobileNo); // Send post request
		 con.setDoOutput(true); 
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters.toString()); wr.flush();
		 wr.close();
		 responseCode = con.getResponseCode(); 
		 System.out.println("\nSending 'POST'request to URL : " + url); 
		 System.out.println("Post parameters : " + urlParameters);
		 System.out.println("Response Code : " + responseCode);
		 BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		 String inputLine;
		 StringBuffer response = new StringBuffer();
		 while ((inputLine = in.readLine()) != null)
		 { 
			 response.append(inputLine);
		 }
		 in.close();
		 System.out.println(response.toString());
	} catch (Exception e) {
		
		throw new RuntimeException();// TODO Auto-generated catch block
	} 
	 return responseCode;
	 }

	public static void setMailSender(JavaMailSender mailSender) {
		Sender.mailSender = mailSender;
	}
	
	/*
	 * public static void main(String[] args) throws Exception {
	 * 
	 * Sender sen = new Sender(); sen.sendMail("amitsingh308@gmail.com", "testing",
	 * "<h1>This is actual message embedded in HTML tags</h1>");
	 * sen.sendSMS("<h1>This is actual message embedded in HTML tags</h1>",
	 * "9718123196"); // sen.sendMail("amitsingh308@gmail.com");
	 * System.out.println("sent"); }
	 */
}
