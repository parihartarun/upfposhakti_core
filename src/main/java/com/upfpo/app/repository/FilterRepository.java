package com.upfpo.app.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upfpo.app.dto.CropAndVerietyList;
import com.upfpo.app.dto.CropFilterDto;
import com.upfpo.app.dto.CropVerietyFilterDto;
import com.upfpo.app.dto.FilterDto;
import com.upfpo.app.entity.CropMaster;
import com.upfpo.app.util.GetFinYear;

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
			+ "inner join districts dist on dist.district_id = fpo.dist_ref_id \r\n"
			+ "inner join total_production tp on fpo.fpo_id = tp.fpo_id   \r\n"
			+ "left join crop_master cp on cp.id = tp.crop_id\r\n"
			+ "left join crop_veriety_master cv on cv.veriety_id = tp.veriety_id \r\n"
			+ "where \r\n"
			+ "tp.fin_year = '"+GetFinYear.getCurrentFinYear()+"' and UPPER(cp.crop_name) like '%"+val.toUpperCase()+"%' \r\n"
			+ "or UPPER(dist.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(fpo.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
	        + "order by districts.district_name asc";	

}else if(in.equalsIgnoreCase(FilterRepository.DISTRICT))
{
	sql = "select distinct districts.district_name as name, districts.district_id as id from fpo \r\n"
			+ "inner join districts dist on dist.district_id = fpo.dist_ref_id \r\n"
			+ "inner join total_production tp on fpo.fpo_id = tp.fpo_id   \r\n"
			+ "left join crop_master cp on cp.id = tp.crop_id\r\n"
			+ "left join crop_veriety_master cv on cv.veriety_id = tp.veriety_id \r\n"
			+ "where \r\n"
			+ "tp.fin_year = '"+GetFinYear.getCurrentFinYear()+"' and UPPER(dist.district_name) like '%"+val.toUpperCase()+"%'\r\n"
	        + "order by districts.district_name asc";
	
}else if(in.equalsIgnoreCase(FilterRepository.CROP))
{
	sql = "select distinct districts.district_name as name, districts.district_id as id from fpo \r\n"
			+ "inner join districts dist on dist.district_id = fpo.dist_ref_id \r\n"
			+ "inner join total_production tp on fpo.fpo_id = tp.fpo_id   \r\n"
			+ "left join crop_master cp on cp.id = tp.crop_id\r\n"
			+ "left join crop_veriety_master cv on cv.veriety_id = tp.veriety_id \r\n"
			+ "where \r\n"
			+ "tp.fin_year = '"+GetFinYear.getCurrentFinYear()+"' and UPPER(cp.crop_name) like '%"+val.toUpperCase()+"%' \r\n"
			+ "or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
	        + "order by districts.district_name asc";

}else if(in.equalsIgnoreCase(FilterRepository.FPO_NAME))
{
	sql = "select distinct districts.district_name as name, districts.district_id as id from fpo \r\n"
			+ "inner join districts dist on dist.district_id = fpo.dist_ref_id \r\n"
			+ "inner join total_production tp on fpo.fpo_id = tp.fpo_id   \r\n"
			+ "left join crop_master cp on cp.id = tp.crop_id\r\n"
			+ "left join crop_veriety_master cv on cv.veriety_id = tp.veriety_id \r\n"
			+ "where \r\n"
			+ "tp.fin_year = '"+GetFinYear.getCurrentFinYear()+"'and UPPER(fpo.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
	        + "order by districts.district_name asc";
	

}else {
	
	sql = "select distinct districts.district_name as name, districts.district_id as id from fpo \r\n"
			+ "inner join districts dist on dist.district_id = fpo.dist_ref_id \r\n"
			+ "inner join total_production tp on fpo.fpo_id = tp.fpo_id   \r\n"
			+ "left join crop_master cp on cp.id = tp.crop_id\r\n"
			+ "left join crop_veriety_master cv on cv.veriety_id = tp.veriety_id \r\n"
			+ "where \r\n"
			+ "tp.fin_year = '"+GetFinYear.getCurrentFinYear()+"' and UPPER(cp.crop_name) like '%"+val.toUpperCase()+"%' \r\n"
			+ "or UPPER(dist.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(fpo.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
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
			+ "inner join districts dist on dist.district_id = fpo.dist_ref_id \r\n"
			+ "inner join total_production tp on fpo.fpo_id = tp.fpo_id   \r\n"
			+ "left join crop_master cp on cp.id = tp.crop_id\r\n"
			+ "left join crop_veriety_master cv on cv.veriety_id = tp.veriety_id \r\n"
			+ "where \r\n"
			+ "tp.fin_year = '"+GetFinYear.getCurrentFinYear()+"' and UPPER(cp.crop_name) like '%"+val.toUpperCase()+"%' \r\n"
			+ "or UPPER(dist.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(fpo.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by fpo.fpo_name asc";
	

}else if(in.equalsIgnoreCase(FilterRepository.DISTRICT))
{
	sql = "select distinct fpo.fpo_name as name, fpo.fpo_id as id from fpo \r\n"
			+ "inner join districts dist on dist.district_id = fpo.dist_ref_id \r\n"
			+ "inner join total_production tp on fpo.fpo_id = tp.fpo_id   \r\n"
			+ "left join crop_master cp on cp.id = tp.crop_id\r\n"
			+ "left join crop_veriety_master cv on cv.veriety_id = tp.veriety_id \r\n"
			+ "where \r\n"
			+ "tp.fin_year = '"+GetFinYear.getCurrentFinYear()+"' and UPPER(dist.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by fpo.fpo_name asc";
	
}else if(in.equalsIgnoreCase(FilterRepository.CROP))
{
	sql = "select distinct fpo.fpo_name as name, fpo.fpo_id as id from fpo \r\n"
			+ "inner join districts dist on dist.district_id = fpo.dist_ref_id \r\n"
			+ "inner join total_production tp on fpo.fpo_id = tp.fpo_id   \r\n"
			+ "left join crop_master cp on cp.id = tp.crop_id\r\n"
			+ "left join crop_veriety_master cv on cv.veriety_id = tp.veriety_id \r\n"
			+ "where \r\n"
			+ "tp.fin_year = '"+GetFinYear.getCurrentFinYear()+"' and UPPER(cp.crop_name) like '%"+val.toUpperCase()+"%' \r\n"
			+ "or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by fpo.fpo_name asc";

}else if(in.equalsIgnoreCase(FilterRepository.FPO_NAME))
{
	sql = "select distinct fpo.fpo_name as name, fpo.fpo_id as id from fpo \r\n"
			+ "inner join districts dist on dist.district_id = fpo.dist_ref_id \r\n"
			+ "inner join total_production tp on fpo.fpo_id = tp.fpo_id   \r\n"
			+ "left join crop_master cp on cp.id = tp.crop_id\r\n"
			+ "left join crop_veriety_master cv on cv.veriety_id = tp.veriety_id \r\n"
			+ "where \r\n"
			+ "tp.fin_year = '"+GetFinYear.getCurrentFinYear()+"'and UPPER(fpo.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by fpo.fpo_name asc";
	

}else {
	
	sql = "select distinct fpo.fpo_name as name, fpo.fpo_id as id from fpo \r\n"
			+ "inner join districts dist on dist.district_id = fpo.dist_ref_id \r\n"
			+ "inner join total_production tp on fpo.fpo_id = tp.fpo_id   \r\n"
			+ "left join crop_master cp on cp.id = tp.crop_id\r\n"
			+ "left join crop_veriety_master cv on cv.veriety_id = tp.veriety_id \r\n"
			+ "where \r\n"
			+ "tp.fin_year = '"+GetFinYear.getCurrentFinYear()+"' and UPPER(cp.crop_name) like '%"+val.toUpperCase()+"%' \r\n"
			+ "or UPPER(dist.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(fpo.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by fpo.fpo_name asc";
			
}
	
	
	return entityManager.createNativeQuery(sql,"BookValueMapping").getResultList(); 
	}
	
	public List<CropFilterDto> getCropsByFilterKeys(String val,String in)
	{
		String sql ="";
if(in.equalsIgnoreCase(FilterRepository.ANY))
{
	
	sql = "select distinct cp.crop_name as cropName, cp.id as cropId, cv.veriety_id as verietyId , cv.crop_veriety as verietyName from fpo \r\n"
			+ "inner join districts dist on dist.district_id = fpo.dist_ref_id \r\n"
			+ "inner join total_production tp on fpo.fpo_id = tp.fpo_id   \r\n"
			+ "left join crop_master cp on cp.id = tp.crop_id\r\n"
			+ "left join crop_veriety_master cv on cv.veriety_id = tp.veriety_id \r\n"
			+ "where \r\n"
			+ "tp.fin_year = '"+GetFinYear.getCurrentFinYear()+"' and UPPER(cp.crop_name) like '%"+val.toUpperCase()+"%' \r\n"
			+ "or UPPER(dist.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(fpo.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by cp.crop_name asc";
	


}else if(in.equalsIgnoreCase(FilterRepository.DISTRICT))
{
	sql = "select distinct cp.crop_name as cropName, cp.id as cropId, cv.veriety_id as verietyId , cv.crop_veriety as verietyName from fpo \r\n"
			+ "inner join districts dist on dist.district_id = fpo.dist_ref_id \r\n"
			+ "inner join total_production tp on fpo.fpo_id = tp.fpo_id   \r\n"
			+ "left join crop_master cp on cp.id = tp.crop_id\r\n"
			+ "left join crop_veriety_master cv on cv.veriety_id = tp.veriety_id \r\n"
			+ "where \r\n"
			+ "tp.fin_year = '"+GetFinYear.getCurrentFinYear()+"' and UPPER(dist.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by cp.crop_name asc";
}else if(in.equalsIgnoreCase(FilterRepository.CROP))
{
	sql = "select distinct cp.crop_name as cropName, cp.id as cropId, cv.veriety_id as verietyId , cv.crop_veriety as verietyName from fpo \r\n"
			+ "inner join districts dist on dist.district_id = fpo.dist_ref_id \r\n"
			+ "inner join total_production tp on fpo.fpo_id = tp.fpo_id   \r\n"
			+ "left join crop_master cp on cp.id = tp.crop_id\r\n"
			+ "left join crop_veriety_master cv on cv.veriety_id = tp.veriety_id \r\n"
			+ "where \r\n"
			+ "tp.fin_year = '"+GetFinYear.getCurrentFinYear()+"' and UPPER(cp.crop_name) like '%"+val.toUpperCase()+"%' \r\n"
			+ "or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by cp.crop_name asc";

}else if(in.equalsIgnoreCase(FilterRepository.FPO_NAME))
{
	sql = "select distinct cp.crop_name as cropName, cp.id as cropId, cv.veriety_id as verietyId , cv.crop_veriety as verietyName from fpo \r\n"
			+ "inner join districts dist on dist.district_id = fpo.dist_ref_id \r\n"
			+ "inner join total_production tp on fpo.fpo_id = tp.fpo_id   \r\n"
			+ "left join crop_master cp on cp.id = tp.crop_id\r\n"
			+ "left join crop_veriety_master cv on cv.veriety_id = tp.veriety_id \r\n"
			+ "where \r\n"
			+ "tp.fin_year = '"+GetFinYear.getCurrentFinYear()+"' and UPPER(fpo.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by cp.crop_name asc";
	

}else {
	
	sql = "select distinct cp.crop_name as cropName, cp.id as cropId, cv.veriety_id as verietyId , cv.crop_veriety as verietyName from fpo \r\n"
			+ "inner join districts dist on dist.district_id = fpo.dist_ref_id \r\n"
			+ "inner join total_production tp on fpo.fpo_id = tp.fpo_id   \r\n"
			+ "left join crop_master cp on cp.id = tp.crop_id\r\n"
			+ "left join crop_veriety_master cv on cv.veriety_id = tp.veriety_id \r\n"
			+ "where \r\n"
			+ "tp.fin_year = '"+GetFinYear.getCurrentFinYear()+"' and UPPER(cp.crop_name) like '%"+val.toUpperCase()+"%' \r\n"
			+ "or UPPER(dist.district_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(fpo.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by cp.crop_name asc";
}
		
List<CropAndVerietyList> cropAndVerietyList = entityManager.createNativeQuery(sql,"CropValueMapping").getResultList();
List<CropFilterDto> cropFilterDtoList = new ArrayList<CropFilterDto>();
HashMap<Integer,List<CropVerietyFilterDto>> verietymap = new HashMap<Integer,List<CropVerietyFilterDto>>();
for(CropAndVerietyList cropAndVerietyListItm: cropAndVerietyList)
{
	verietymap.put(cropAndVerietyListItm.getCropId(), new ArrayList<CropVerietyFilterDto>());
}
for(CropAndVerietyList cropAndVerietyListItm: cropAndVerietyList)
{
	 List<CropVerietyFilterDto> crpvarlist = verietymap.get(cropAndVerietyListItm.getCropId());
	 crpvarlist.add(new CropVerietyFilterDto(cropAndVerietyListItm.getVerietyName(),cropAndVerietyListItm.getVerietyId()));
}
for(CropAndVerietyList cropAndVerietyListItm: cropAndVerietyList)
{
	 List<CropVerietyFilterDto> crpvarlist = verietymap.get(cropAndVerietyListItm.getCropId());
	 boolean exists = false;
	 for(CropFilterDto cropFilterDtoItm:cropFilterDtoList)
	 {
      if(cropFilterDtoItm.getId() == cropAndVerietyListItm.getCropId())		 
      {
    	  exists = true;
      }	 
	 }
	 if(!exists)
	 {
		 CropFilterDto newItem = new CropFilterDto();
		 newItem.setId(cropAndVerietyListItm.getCropId());
		 newItem.setName(cropAndVerietyListItm.getCropName());
		 newItem.setCropVeriety(crpvarlist);
		 cropFilterDtoList.add(newItem);
	 }
	 
}


return cropFilterDtoList;  
	}
	
}
