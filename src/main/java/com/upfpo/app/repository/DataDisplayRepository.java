package com.upfpo.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.upfpo.app.dto.DisplayDataDTO;

@Repository
@Qualifier("dataDisplayRepository")
public class DataDisplayRepository {
	
	@Autowired
	private  EntityManager entityManager;
	
	private  String sql = "";
	
	public List<Object> homePageData()
	{
		
		  sql = "select sum(total_farmers) as \"totalFarmers\",sum(total_small_farmers) as \"smallFarmers\",\r\n" + 
		 		"sum(total_big_farmers) as \"bigFarmers\",sum(total_marginal_farmers)as \"marginalFarmers\",\r\n" + 
		 		"sum (total_land) as \"totalLand\"\r\n" + 
		 		"from fpo";
		  
		    List<Object> list = (List<Object>)entityManager.createQuery(sql).getSingleResult(); 

		    return list;
	}
	

}
