package com.upfpo.app.upagri;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.axis.message.MessageElement;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.upfpo.app.dto.DepartmentAllUserDto;
import com.upfpo.app.dto.UpAgriDataDto;

public class UpAgriClient {
	
	@Autowired
	EntityManager entityManager;
	
    public String upagri(String reg_no) throws MalformedURLException, RemoteException
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
        String  list_resp = list_any16.toString();
        String _anyname = StringUtils.substringBetween(list_resp, "<Farmer_x0027_s_x0020_name>", "</Farmer_x0027_s_x0020_name>");
        String _fath =  StringUtils.substringBetween(list_resp, "<Father_x0020_name>", "</Father_x0020_name>");
        String _anydist = StringUtils.substringBetween(list_resp, "<District>", "</District>");
        String _blck = StringUtils.substringBetween(list_resp, "<Block>", "</Block>");
        String _vill = StringUtils.substringBetween(list_resp, "<Village>", "</Village>");
        String _cat = StringUtils.substringBetween(list_resp, "<Category>", "</Category>");
        String _mob = StringUtils.substringBetween(list_resp, "<Mobile_x0020_No>", "</Mobile_x0020_No>");
        String _bank_name = StringUtils.substringBetween(list_resp, "<Bank_x0020_Name>", "</Bank_x0020_Name>");
        String _ifsc = StringUtils.substringBetween(list_resp, "<IFSC_x0020_Code>", "</IFSC_x0020_Code>");
        String _accno = StringUtils.substringBetween(list_resp, "<Bank_x0020_Account_x0020_NO>", "</Bank_x0020_Account_x0020_NO>");
        //UpAgriDataDto obj = upAgriService.getUpAgriData(_anydist,_blck,_vill);
        
        System.err.println("  _anyname == "+_anyname +"  _fath == "+_fath +
        		"  _anydist == "+_anydist+"  _blck== "+_blck+"  _vill== "+_vill+"  _cat == "+_cat+
        		"  _mob == "+_mob+"  _bank_nameb =="+_bank_name+" _ifsc == "+_ifsc+"  _accno =="+_accno);
        
        
//        			_anyname 	== SHIV KUMAR  _fath == LAXMIAN  _anydist == Lucknow  _blck== 
//        			Bakshi ka Talab  _vill==   _cat
//        			== 4  _mob == 7523941451  _bank_nameb ==UCO 
//        			BANK _ifsc == UCBA0001524  _accno ==15240100008860
        			
        return list_any16.toString();
    }
    
    public UpAgriDataDto getUpAgriData(String _anydist,String _blck,String _vill) {
		UpAgriDataDto obj = null;
		   try
			{
			  String sql = null;
			  String anydist = _anydist.toUpperCase();
			  String blck = _blck.toUpperCase();
			  String vill = _vill.toUpperCase();
//			  if(_vill == "" || _vill == null) {
//				  sql = "select d.district_id,d.district_name,b.block_id,b.block_name from districts d join block b on d.district_id = b.district_id\r\n"
//					  		+ "and d.district_name= :"+_anydist+" and b.block_name= :"+_blck;
//					   
//			  }
//			  else {
				  sql = "select d.district_id,d.district_name,b.block_id,b.block_name, v.village_id,v.village_name \r\n"
				  		+ "from districts d join block b on d.district_id = b.district_id\r\n"
				  		+ "join villages v on v.district_id = b.district_id where v.village_name =:vill and\r\n"
				  		+ "d.district_name=:anydist and b.block_name=:blck";
			  //}
		
			  obj = (UpAgriDataDto) entityManager.createNativeQuery(sql, "UpAgriDataDto")
					 .setParameter("anydist", anydist)
					 .setParameter("blck", blck)
					 .setParameter("vill", vill)
					.getSingleResult();
			  System.out.println(obj.getBlock_name());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		   return obj;
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

//    public static void main(String[] args){
//        try {
//            System.out.println( upagri("2055153400000"));
//          
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//    }
}
