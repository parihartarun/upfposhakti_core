package com.upfpo.app.upagri;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

import org.apache.axis.message.MessageElement;
import org.apache.commons.lang.StringUtils;

public class UpAgriClient {
	
	
	
    public static String upagri(String reg_no) throws MalformedURLException, RemoteException
    {
    	List list_any16 = null;
    	java.net.URL endPointURL = new java.net.URL("http://upagriculture.com:81/DbtService.asmx");
		org.apache.axis.client.Service service = new org.apache.axis.client.Service();
		DbtServiceSoapStub stub = new DbtServiceSoapStub(endPointURL,service);
		MessageElement[] res = stub.UPAGRI(reg_no).get_any();
        if(res != null)
        {
         list_any16 = java.util.Arrays.asList(res);
        }
        return list_any16.toString();
    }
    
    
    public static String upagri_area(String reg_no) throws MalformedURLException, RemoteException
    {
        List list_any16 = null;
    	java.net.URL endPointURL = new java.net.URL("http://upagriculture.com:81/DbtService.asmx");
		org.apache.axis.client.Service service = new org.apache.axis.client.Service();
		DbtServiceSoapStub stub = new DbtServiceSoapStub(endPointURL,service);
		MessageElement[] res = stub.UPAGRI_AREA(reg_no).get_any();
        if(res != null)
        {
         list_any16 = java.util.Arrays.asList(res);
        }
        
        String land_area = StringUtils.substringBetween(list_any16.toString(), "<Column1>", "</Column1>");
        
        return land_area;
    }
}
