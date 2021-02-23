package com.upfpo.app.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upfpo.app.dto.CropFilterDto;
import com.upfpo.app.dto.FilterDto;
import com.upfpo.app.entity.CropMaster;

@Repository
public class FilterRepository {
	// fpo_name  
	
	private static final String CROP ="crop";
	private static final String FPO_NAME ="fpo_name";
	private static final String ANY ="any";
	private static final String DISTRICT ="district";
	private static final String SERVICES ="services";
	
	@Autowired
	private EntityManager entityManager;
	public List<FilterDto> getDistrictsByFilterKeys(String val,String in)
	{
		String sql ="";
if(in.equalsIgnoreCase(FilterRepository.ANY))
{
	sql = "select distinct districts.district_name as name, districts.district_id as id from fpo \r\n"
			+ "inner join districts on district_id = fpo.dist_ref_id \r\n"
			+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
			+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
			+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
			+ "where UPPER(districts.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cm.crop_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(fpo.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(districts.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by districts.district_name asc";

}else if(in.equalsIgnoreCase(FilterRepository.DISTRICT))
{
	sql = "select distinct districts.district_name as name, districts.district_id as id from fpo \r\n"
			+ "inner join districts on district_id = fpo.dist_ref_id \r\n"
			+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
			+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
			+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
			+ "where UPPER(districts.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by districts.district_name asc";
}else if(in.equalsIgnoreCase(FilterRepository.CROP))
{
	sql = "select distinct districts.district_name as name, districts.district_id as id from fpo \r\n"
			+ "inner join districts on district_id = fpo.dist_ref_id \r\n"
			+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
			+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
			+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
			+ "where UPPER(cm.crop_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
		    + "order by districts.district_name asc";

}else if(in.equalsIgnoreCase(FilterRepository.FPO_NAME))
{
	sql = "select distinct districts.district_name as name, districts.district_id as id from fpo \r\n"
			+ "inner join districts on district_id = fpo.dist_ref_id \r\n"
			+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
			+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
			+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
			+ "where UPPER(fpo.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by districts.district_name asc";
	

}else {
	
	sql = "select distinct districts.district_name as name, districts.district_id as id from fpo \r\n"
			+ "inner join districts on district_id = fpo.dist_ref_id \r\n"
			+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
			+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
			+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
			+ "where UPPER(districts.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cm.crop_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(fpo.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(districts.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by districts.district_name asc";
}
	
	
	return entityManager.createNativeQuery(sql,"BookValueMapping").getResultList(); 
	}

	public List<FilterDto> getFposByFilterKeys(String val,String in)
	{
		String sql ="";
if(in.equalsIgnoreCase(FilterRepository.ANY))
{
	sql = "select distinct fpo.fpo_name as name, fpo.fpo_id as id from fpo \r\n"
			+ "inner join districts on district_id = fpo.dist_ref_id \r\n"
			+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
			+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
			+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
			+ "where UPPER(districts.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cm.crop_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(fpo.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(districts.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by fpo.fpo_name asc";

}else if(in.equalsIgnoreCase(FilterRepository.DISTRICT))
{
	sql = "select distinct fpo.fpo_name as name, fpo.fpo_id as id from fpo \r\n"
			+ "inner join districts on district_id = fpo.dist_ref_id \r\n"
			+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
			+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
			+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
			+ "where UPPER(districts.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by fpo.fpo_name asc";
}else if(in.equalsIgnoreCase(FilterRepository.CROP))
{
	sql = "select distinct fpo.fpo_name as name, fpo.fpo_id as id from fpo \r\n"
			+ "inner join districts on district_id = fpo.dist_ref_id \r\n"
			+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
			+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
			+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
			+ "where UPPER(cm.crop_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
		    + "order by fpo.fpo_name asc";

}else if(in.equalsIgnoreCase(FilterRepository.FPO_NAME))
{
	sql = "select distinct fpo.fpo_name as name, fpo.fpo_id as id from fpo \r\n"
			+ "inner join districts on district_id = fpo.dist_ref_id \r\n"
			+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
			+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
			+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
			+ "where UPPER(fpo.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by fpo.fpo_name asc";
	

}else {
	
	sql = "select distinct fpo.fpo_name as name, fpo.fpo_id as id from fpo \r\n"
			+ "inner join districts on district_id = fpo.dist_ref_id \r\n"
			+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
			+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
			+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
			+ "where UPPER(districts.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cm.crop_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(fpo.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(districts.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by fpo.fpo_name asc";
}
	
	
	return entityManager.createNativeQuery(sql,"BookValueMapping").getResultList(); 
	}
	
	public List<CropFilterDto> getCropsByFilterKeys(String val,String in)
	{
		String sql ="";
if(in.equalsIgnoreCase(FilterRepository.ANY))
{
	sql = "select distinct cm.crop_name, cm.id, cv.veriety_id , cv.crop_veriety from fpo \r\n"
			+ "inner join districts on district_id = fpo.dist_ref_id \r\n"
			+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
			+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
			+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
			+ "where UPPER(districts.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cm.crop_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(fpo.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(districts.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by cm.crop_name asc";

}else if(in.equalsIgnoreCase(FilterRepository.DISTRICT))
{
	sql = "select distinct cm.crop_name as cropName, cm.id as cropId, cv.veriety_id as verietyId , cv.crop_veriety as verietyName from fpo \r\n"
			+ "inner join districts on district_id = fpo.dist_ref_id \r\n"
			+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
			+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
			+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
			+ "where UPPER(districts.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by cm.crop_name asc";
}else if(in.equalsIgnoreCase(FilterRepository.CROP))
{
	sql = "select distinct cm.crop_name as cropName, cm.id as cropId, cv.veriety_id as verietyId , cv.crop_veriety as verietyName from fpo \r\n"
			+ "inner join districts on district_id = fpo.dist_ref_id \r\n"
			+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
			+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
			+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
			+ "where UPPER(cm.crop_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
		    + "order by cm.crop_name asc";

}else if(in.equalsIgnoreCase(FilterRepository.FPO_NAME))
{
	sql = "select distinct cm.crop_name as cropName, cm.id as cropId, cv.veriety_id as verietyId , cv.crop_veriety as verietyName from fpo \r\n"
			+ "inner join districts on district_id = fpo.dist_ref_id \r\n"
			+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
			+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
			+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
			+ "where UPPER(fpo.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by cm.crop_name asc";
	

}else {
	
	sql = "select distinct cm.crop_name as cropName, cm.id as cropId, cv.veriety_id as verietyId , cv.crop_veriety as verietyName from fpo \r\n"
			+ "inner join districts on district_id = fpo.dist_ref_id \r\n"
			+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
			+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
			+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
			+ "where UPPER(districts.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cm.crop_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(fpo.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(districts.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by cm.crop_name asc";
}
	
	
	return entityManager.createNativeQuery(sql,CropMaster.class).getResultList(); 
	}
	
}
