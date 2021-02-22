package com.upfpo.app.upagri;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.UpAgriDataDto;
@Service
public class UpAgriServiceImpl implements UpAgriService{
	@Autowired
	EntityManager entityManager;
	
	@Override
	public UpAgriDataDto getUpAgriData(String _anydist,String _blck,String _vill) {
		UpAgriDataDto obj = null;
		   try
			{
			  String sql = null;
			  _anydist = _anydist.toUpperCase();
			  _blck = _blck.toUpperCase();
			  _vill = _vill.toUpperCase();
			  if(_vill == "" || _vill == null) {
				  sql = "select d.district_id,d.district_name,b.block_id,b.block_name from districts d join block b on d.district_id = b.district_id\r\n"
					  		+ "and d.district_name= :"+_anydist+" and b.block_name= :"+_blck;
					   
			  }
			  else {
				  sql = "select d.district_id,d.district_name,b.block_id,b.block_name, v.village_id,v.village_name from districts d join block b on d.district_id = b.district_id\r\n"
					  		+ "and d.district_name= :"+_anydist+" and b.block_name= :"+_blck+" join villages v on v.district_id = b.district_id and v.village_name = :"+_vill;
			  }
		
			  obj = (UpAgriDataDto) entityManager.createNativeQuery(sql, "UpAgriDataDto")
					 .setParameter("_anydist", _anydist)
					 .setParameter("_blck", _blck)
					 .setParameter("_vill", _vill)
					.getSingleResult();
			  System.out.println(obj.getBlock_name());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		   return obj;
	}

}
