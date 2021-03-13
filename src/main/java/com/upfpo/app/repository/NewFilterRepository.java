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
public class NewFilterRepository {
	// fpo_name  
	
	private static final String CROP ="crop";
	private static final String INPUTSUPPLIERS="inputsupplier";
	private static final String FMB ="fmb";
	
	
	@Autowired
	private EntityManager entityManager;
	public List<FilterDto> getDistrictsByFilterKeys(String val,String in)
	{
		String sql ="";
if(in.equalsIgnoreCase(NewFilterRepository.CROP))
{
	sql = "select distinct dist.district_id as id,dist.district_name as name from total_production tp\r\n"
			+ "inner join fpo f on tp.fpo_id = f.fpo_id\r\n"
			+ "inner join districts dist on f.dist_ref_id = dist.district_id\r\n"
			+ "inner join crop_veriety_master cv on cv.veriety_id = tp.veriety_id\r\n"
			+ "inner join crop_master cm on cv.crop_master_ref_id = cm.id\r\n"
			+ "where UPPER(cm.crop_name) like'%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cv.crop_veriety) like'%"+val.toUpperCase()+"%'"
			+ "order by dist.district_name asc";	
				

}else if(in.equalsIgnoreCase(NewFilterRepository.INPUTSUPPLIERS))
{
	
	String unoinquery =selectDistrictsFromInputFertilizerTable(val)
            +" union all "
            +this.selectDistrictsFromInputInsecticidesTable(val)
            +" union all "
            +this.selectDistrictsFromInputSeedTable(val);
sql = "select distinct * from ("+unoinquery+") as a";
	
}else if(in.equalsIgnoreCase(NewFilterRepository.FMB))
{
	String unoinquery = this.selectDistrictsFromInputsupplierMachineryTable(val)
            +" union all "
            +this.selectDistrictsFromChcFmbMachineryTable(val);
            
sql = "select distinct * from ("+unoinquery+") as a order by name asc";

}else {
	
	sql = "";
	return null;
}
	
	
	return entityManager.createNativeQuery(sql,"BookValueMapping").getResultList(); 
	}

		public List<CropFilterDto> getCropsByFilterKeys(String val,String in)
	{
		String sql ="";
 if(in.equalsIgnoreCase(NewFilterRepository.CROP))
{
	sql = "select distinct cv.crop_master_ref_id as cropId,cm.crop_name as cropName,tp.veriety_id as verietyId,cv.crop_veriety as verietyName from total_production tp\r\n"
			+ "inner join fpo f on tp.fpo_id = f.fpo_id\r\n"
			+ "inner join districts dist on f.dist_ref_id = dist.district_id\r\n"
			+ "inner join crop_veriety_master cv on cv.veriety_id = tp.veriety_id\r\n"
			+ "inner join crop_master cm on cv.crop_master_ref_id = cm.id\r\n"
			+ "where UPPER(cm.crop_name) like'%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cv.crop_veriety) like'%"+val.toUpperCase()+"%'"
	        + "order by cm.crop_name asc";

}else if(in.equalsIgnoreCase(NewFilterRepository.INPUTSUPPLIERS)) {
	
	sql = "select distinct cp.id as cropId, cp.crop_name as cropName,inf.variety_id as verietyId,cv.crop_veriety as verietyName \r\n"
			+ "from input_supplier_seed inf \r\n"
			+ "inner join input_supplier inps on inps.input_supplier_id = inf.input_supplier_id\r\n"
			+ "inner join crop_veriety_master cv on cv.veriety_id = inf.variety_id\r\n"
			+ "inner join crop_master cp on cp.id = cv.crop_master_ref_id\r\n"
			+ "inner join districts dist on inps.dist_ref_id = dist.district_id\r\n"
			+ "where UPPER(cp.crop_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
			+ "or UPPER(inps.input_supplier_name) like '%"+val.toUpperCase()+"%'\r\n"
			+ "order by cp.crop_name asc";
			
			
}else {
	return null;
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

		public List<FilterDto> getFposByFilterKeys(String val,String in)
		{
			String sql ="";
    if(in.equalsIgnoreCase(NewFilterRepository.CROP))
	{
		sql = "select distinct tp.fpo_id as id,f.fpo_name as name from total_production tp\r\n"
				+ "inner join fpo f on tp.fpo_id = f.fpo_id\r\n"
				+ "inner join districts dist on f.dist_ref_id = dist.district_id\r\n"
				+ "inner join crop_veriety_master cv on cv.veriety_id = tp.veriety_id\r\n"
				+ "inner join crop_master cm on cv.crop_master_ref_id = cm.id\r\n"
				+ "where UPPER(cm.crop_name) like'%"+val.toUpperCase()+"%'\r\n"
				+ "or UPPER(cv.crop_veriety) like'%"+val.toUpperCase()+"%'"
				+ "order by f.fpo_name asc";
				

	}else {
		sql = "";
		return null;
	}
		
		
		return entityManager.createNativeQuery(sql,"BookValueMapping").getResultList(); 
		}
		
		private String selectDistrictsFromInputInsecticidesTable(String val)
		{
			String sql ="select dist.district_id id, dist.district_name as name\r\n"
					+ " from input_supplier_insecticide inf \r\n"
					+ " inner join insecticide_type_master fnt on fnt.id = inf.insecticide_type_id\r\n"
					+ " inner join input_supplier inps on inps.input_supplier_id = inf.input_supplier_id \r\n"
					+ " inner join districts dist on inps.dist_ref_id = dist.district_id\r\n"
					+ " where UPPER(fnt.insecticide_type) like '%"+val.toUpperCase()+"%'\r\n"
					+ " or UPPER(inf.manufacturer_name) like '%"+val.toUpperCase()+"%'\r\n"
					+ " or UPPER(inps.input_supplier_name) like '%"+val.toUpperCase()+"%'";
			return sql;
		}
		private String selectDistrictsFromInputSeedTable(String val)
		{
			String sql ="select \r\n"
					+ "  dist.district_id id, dist.district_name as name\r\n"
					+ "  from input_supplier_seed inf \r\n"
					+ "  inner join input_supplier inps on inps.input_supplier_id = inf.input_supplier_id\r\n"
					+ "  inner join crop_veriety_master cv on cv.veriety_id = inf.variety_id\r\n"
					+ "  inner join crop_master cp on cp.id = cv.crop_master_ref_id\r\n"
					+ "  inner join districts dist on inps.dist_ref_id = dist.district_id\r\n"
					+ "  where UPPER(cp.crop_name) like '%"+val.toUpperCase()+"%'\r\n"
					+ "  or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
					+ "  or UPPER(inps.input_supplier_name) like '%"+val.toUpperCase()+"%'";
			return sql;
		}
		private String selectDistrictsFromInputFertilizerTable(String val)
		{
			String sql ="select dist.district_id id, dist.district_name as name\r\n"
					   + "from input_supplier_fertilizer inf \r\n"
					   + "inner join fertilizer_name_master fn on fn.id = inf.fertilizer_name_id\r\n"
					   + "inner join fertilizer_type_master fnt on fnt.id = inf.fertilizer_type_id\r\n"
					   + "inner join input_supplier inps on inps.input_supplier_id = inf.input_supplier_id \r\n"
					   + "inner join districts dist on inps.dist_ref_id = dist.district_id\r\n"
					   + "where UPPER(fn.fertilizer_name) like '%"+val.toUpperCase()+"%'\r\n"
					   + "OR UPPER(fnt.fertilizer_type) like '%"+val.toUpperCase()+"%'\r\n"
					   + "OR UPPER(inps.input_supplier_name)LIKE '%"+val.toUpperCase()+"%'\r\n";
					
					
			return sql;
		}
		private String selectDistrictsFromInputsupplierMachineryTable(String val)
		{
			
			String sql ="select dist.district_id as id,\r\n"
					+ "	dist.district_name as name\r\n"
					+ "	from input_supplier_machinery inpm \r\n"
					+ "	inner join input_supplier ip on ip.input_supplier_id = inpm.input_supplier_id\r\n"
					+ "	inner join districts dist on ip.dist_ref_id = dist.district_id \r\n"
					+ "	inner join equipment_type_master eqt on eqt.id = inpm.machinery_type_id\r\n"
					+ "	inner join equip_master eqp on eqp.id = inpm.machinery_name_id \r\n"
					+ "	where UPPER(eqp.equpment_name) LIKE '%"+val.toUpperCase()+"%'\r\n"
					+ " or UPPER(eqt.type) LIKE '%"+val.toUpperCase()+"%'";
					
			return sql;
		}
		private String selectDistrictsFromChcFmbMachineryTable(String val)
		{
			String sql ="select\r\n"
					+ " dist.district_id as id,\r\n"
					+ "	dist.district_name as name\r\n"
					+ "	from chc_fmb_machinery chc\r\n"
					+ "	inner join chc_fmb fmb on fmb.chc_fmb_id = chc.chc_fmb_id\r\n"
					+ "	inner join districts dist on fmb.dist_ref_id = dist.district_id \r\n"
					+ "	inner join equipment_type_master eqt on eqt.id = chc.equipment_type_id\r\n"
					+ "	inner join equip_master eqp on eqp.id = chc.equipment_name_id \r\n"
					+ "	where UPPER(eqp.equpment_name) LIKE '%"+val.toUpperCase()+"%'\r\n"
					+ "	or UPPER(eqt.type) LIKE '%"+val.toUpperCase()+"%'";
					
			return sql;
		}
		
		private String selectInputSuppliersFromInputInsecticidesTable(String val)
		{
			String sql ="select inf.input_supplier_id as id, inps.input_supplier_name as name\r\n"
					+ " from input_supplier_insecticide inf \r\n"
					+ " inner join insecticide_type_master fnt on fnt.id = inf.insecticide_type_id\r\n"
					+ " inner join input_supplier inps on inps.input_supplier_id = inf.input_supplier_id \r\n"
					+ " inner join districts dist on inps.dist_ref_id = dist.district_id\r\n"
					+ " where UPPER(fnt.insecticide_type) like '%"+val.toUpperCase()+"%'\r\n"
					+ " or UPPER(inf.manufacturer_name) like '%"+val.toUpperCase()+"%'\r\n"
					+ " or UPPER(inps.input_supplier_name) like '%"+val.toUpperCase()+"%'";
			return sql;
		}
		private String selectInputSuppliersFromInputSeedTable(String val)
		{
			String sql ="select \r\n"
					+ "  inf.input_supplier_id as id, inps.input_supplier_name as name\r\n"
					+ "  from input_supplier_seed inf \r\n"
					+ "  inner join input_supplier inps on inps.input_supplier_id = inf.input_supplier_id\r\n"
					+ "  inner join crop_veriety_master cv on cv.veriety_id = inf.variety_id\r\n"
					+ "  inner join crop_master cp on cp.id = cv.crop_master_ref_id\r\n"
					+ "  inner join districts dist on inps.dist_ref_id = dist.district_id\r\n"
					+ "  where UPPER(cp.crop_name) like '%"+val.toUpperCase()+"%'\r\n"
					+ "  or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
					+ "  or UPPER(inps.input_supplier_name) like '%"+val.toUpperCase()+"%'";
			return sql;
		}
		private String selectInputSuppliersFromInputFertilizerTable(String val)
		{
			
			String sql ="select inf.input_supplier_id as id, inps.input_supplier_name as name\r\n"
					   + "from input_supplier_fertilizer inf \r\n"
					   + "inner join fertilizer_name_master fn on fn.id = inf.fertilizer_name_id\r\n"
					   + "inner join fertilizer_type_master fnt on fnt.id = inf.fertilizer_type_id\r\n"
					   + "inner join input_supplier inps on inps.input_supplier_id = inf.input_supplier_id \r\n"
					   + "inner join districts dist on inps.dist_ref_id = dist.district_id\r\n"
					   + "where UPPER(fn.fertilizer_name) like '%"+val.toUpperCase()+"%'\r\n"
					   + "OR UPPER(fnt.fertilizer_type) like '%"+val.toUpperCase()+"%'\r\n"
					   + "OR UPPER(inps.input_supplier_name)LIKE '%"+val.toUpperCase()+"%'\r\n";
					
					
			return sql;
		}
		
		private String selectInsecticidesFromInputInsecticidesTable(String val)
		{
			String sql ="select 'insecticide' as recordtype\r\n"
					+ "	from input_supplier_insecticide inf\r\n"
					+ "	inner join insecticide_type_master fnt on fnt.id = inf.insecticide_type_id\r\n"
					+ "	inner join input_supplier inps on inps.input_supplier_id = inf.input_supplier_id\r\n"
					+ "	inner join districts dist on inps.dist_ref_id = dist.district_id\r\n"
					+ "	where UPPER(fnt.insecticide_type) like '%"+val.toUpperCase()+"%'\r\n"
					+ "	or UPPER(inf.manufacturer_name) like '%"+val.toUpperCase()+"%'\r\n"
					+ "	or UPPER(inps.input_supplier_name) like '%"+val.toUpperCase()+"%'";
			return sql;
		}
		private String selectSeedsFromInputSeedTable(String val)
		{
			String sql ="select \r\n"
					+ "	'seeds' as recordtype\r\n"
					+ "	from input_supplier_seed inf\r\n"
					+ "	inner join input_supplier inps on inps.input_supplier_id = inf.input_supplier_id\r\n"
					+ "	inner join crop_veriety_master cv on cv.veriety_id = inf.variety_id\r\n"
					+ "	inner join crop_master cp on cp.id = cv.crop_master_ref_id\r\n"
					+ "	inner join districts dist on inps.dist_ref_id = dist.district_id\r\n"
					+ "	where UPPER(cp.crop_name) like '%"+val.toUpperCase()+"%'\r\n"
					+ "	or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
					+ "	or UPPER(inps.input_supplier_name) like '%"+val.toUpperCase()+"%'";
			return sql;
		}
		private String selectFertilizersFromInputFertilizerTable(String val)
		{
			String sql ="select\r\n"
					+ "	'fertilizer' as recordtype \r\n"
					+ "	from input_supplier_fertilizer inf\r\n"
					+ "	inner join fertilizer_name_master fn on fn.id = inf.fertilizer_name_id\r\n"
					+ "	inner join fertilizer_type_master fnt on fnt.id = inf.fertilizer_type_id\r\n"
					+ "	inner join input_supplier inps on inps.input_supplier_id = inf.input_supplier_id\r\n"
					+ "	inner join districts dist on inps.dist_ref_id = dist.district_id\r\n"
					+ "	where UPPER(fn.fertilizer_name) like '%"+val.toUpperCase()+"%'\r\n"
					+ "	OR UPPER(fnt.fertilizer_type) like '%"+val.toUpperCase()+"%'\r\n"
					+ "	OR UPPER(inps.input_supplier_name)LIKE '%"+val.toUpperCase()+"%'";
			return sql;
		}
		
		private String selectCompanyFromInputSupplierMachineryTable(String val)
		{
			String sql ="select inpm.manufacturer_name as name\r\n"
					+ "	from input_supplier_machinery inpm \r\n"
					+ "	inner join input_supplier ip on ip.input_supplier_id = inpm.input_supplier_id\r\n"
					+ "	inner join districts dist on ip.dist_ref_id = dist.district_id \r\n"
					+ "	inner join equipment_type_master eqt on eqt.id = inpm.machinery_type_id\r\n"
					+ "	inner join equip_master eqp on eqp.id = inpm.machinery_name_id \r\n"
					+ "	where UPPER(eqp.equpment_name) LIKE '%"+val.toUpperCase()+"%'\r\n"
					+ "	or UPPER(eqt.type) LIKE '%"+val.toUpperCase()+"%'";
			return sql;
			
		}

		private String selectCompanyFromChcFmbMachineryTable(String val)
		{
			String sql ="select\r\n"
					+ "chc.company as name \r\n"
					+ "from chc_fmb_machinery chc\r\n"
					+ "inner join chc_fmb fmb on fmb.chc_fmb_id = chc.chc_fmb_id\r\n"
					+ "inner join districts dist on fmb.dist_ref_id = dist.district_id \r\n"
					+ "inner join equipment_type_master eqt on eqt.id = chc.equipment_type_id\r\n"
					+ "inner join equip_master eqp on eqp.id = chc.equipment_name_id\r\n"
					+ "where UPPER(eqp.equpment_name) LIKE '%"+val.toUpperCase()+"%'\r\n"
					+ "or UPPER(eqt.type) LIKE '%"+val.toUpperCase()+"%'";
			return sql;
			
		}

		private String selectMachineTypeFromInputSupplierMachineryTable(String val)
		{
			String sql ="select inpm.machinery_type_id as id,\r\n"
					+ "eqt.type as name\r\n"
					+ "from input_supplier_machinery inpm \r\n"
					+ "inner join input_supplier ip on ip.input_supplier_id = inpm.input_supplier_id\r\n"
					+ "inner join districts dist on ip.dist_ref_id = dist.district_id \r\n"
					+ "inner join equipment_type_master eqt on eqt.id = inpm.machinery_type_id\r\n"
					+ "inner join equip_master eqp on eqp.id = inpm.machinery_name_id \r\n"
					+ "where UPPER(eqp.equpment_name) LIKE '%"+val.toUpperCase()+"%'\r\n"
					+ "or UPPER(eqt.type) LIKE '%"+val.toUpperCase()+"%'";
			return sql;
			
		}

		private String selectMachineTypeFromChcFmbMachineryTable(String val)
		{
			String sql ="select\r\n"
					+ "chc.equipment_type_id as id ,\r\n"
					+ "eqt.type as name\r\n"
					+ "from chc_fmb_machinery chc\r\n"
					+ "inner join chc_fmb fmb on fmb.chc_fmb_id = chc.chc_fmb_id\r\n"
					+ "inner join districts dist on fmb.dist_ref_id = dist.district_id \r\n"
					+ "inner join equipment_type_master eqt on eqt.id = chc.equipment_type_id\r\n"
					+ "inner join equip_master eqp on eqp.id = chc.equipment_name_id \r\n"
					+ "where UPPER(eqp.equpment_name) LIKE '%"+val.toUpperCase()+"%'\r\n"
					+ "or UPPER(eqt.type) LIKE '%"+val.toUpperCase()+"%'";
			return sql;			
		}
		
		public List<String> getCategoriesByFilterKeys(String val,String in)
		{
			String sql ="";
	           if(in.equalsIgnoreCase(NewFilterRepository.INPUTSUPPLIERS))
	         	{
	        	   String unoinquery = selectFertilizersFromInputFertilizerTable(val)
	        	            +" union all "
	        	            +this.selectInsecticidesFromInputInsecticidesTable(val)
	        	            +" union all "
	        	            +this.selectSeedsFromInputSeedTable(val);
	        	sql = "select distinct * from ("+unoinquery+") as a";

		}else {
			sql = "";
			return null;
		}
	           
	           return entityManager.createNativeQuery(sql).getResultList();
		}
		
 		public List<FilterDto> getInputSuppliersByFilterKeys(String val,String in)
		{
		String sql ="";
           if(in.equalsIgnoreCase(NewFilterRepository.INPUTSUPPLIERS))
         	{
        	   String unoinquery = selectInputSuppliersFromInputFertilizerTable(val)
        	            +" union all "
        	            +this.selectInputSuppliersFromInputInsecticidesTable(val)
        	            +" union all "
        	            +this.selectInputSuppliersFromInputSeedTable(val);
        	sql = "select distinct * from ("+unoinquery+") as a";

	}else {
		sql = "";
		return null;
	}
		
		
		return entityManager.createNativeQuery(sql,"BookValueMapping").getResultList(); 
		}		
		
		public List<FilterDto> getFertilizerTypesByFilterKeys(String val,String in)
		{
			
			
		String sql ="select distinct inf.fertilizer_type_id id, fnt.fertilizer_type as name\r\n"
				+ "	from input_supplier_fertilizer inf \r\n"
				+ "	inner join fertilizer_name_master fn on fn.id = inf.fertilizer_name_id\r\n"
				+ "	inner join fertilizer_type_master fnt on fnt.id = inf.fertilizer_type_id\r\n"
				+ "	inner join input_supplier inps on inps.input_supplier_id = inf.input_supplier_id \r\n"
				+ "	inner join districts dist on inps.dist_ref_id = dist.district_id";
           if(in.equalsIgnoreCase(NewFilterRepository.INPUTSUPPLIERS))
         	{
        	   sql ="select distinct inf.fertilizer_type_id id, fnt.fertilizer_type as name\r\n"
       				+ "	from input_supplier_fertilizer inf \r\n"
       				+ "	inner join fertilizer_name_master fn on fn.id = inf.fertilizer_name_id\r\n"
       				+ "	inner join fertilizer_type_master fnt on fnt.id = inf.fertilizer_type_id\r\n"
       				+ "	inner join input_supplier inps on inps.input_supplier_id = inf.input_supplier_id \r\n"
       				+ "	inner join districts dist on inps.dist_ref_id = dist.district_id\r\n"
       				+ " where UPPER(fn.fertilizer_name) like '%"+val.toUpperCase()+"%'\r\n"
					+ " OR UPPER(fnt.fertilizer_type) like '%"+val.toUpperCase()+"%'\r\n"
					+ " OR UPPER(inps.input_supplier_name)LIKE '%"+val.toUpperCase()+"%'\r\n";;

	}else {
		sql = "";
		return null;
	}
		
		
		return entityManager.createNativeQuery(sql,"BookValueMapping").getResultList(); 
		}		
				
		public List<String> getMachineryBrandsByFilterKeys(String val,String in)
		{
			
			
		String sql ="";
           if(in.equalsIgnoreCase(NewFilterRepository.FMB))
         	{
        	   String unoinquery = this.selectCompanyFromInputSupplierMachineryTable(val)
       	            +" union all "
       	            +selectCompanyFromChcFmbMachineryTable(val);
       	            
       	sql = "select distinct * from ("+unoinquery+") as a order by name asc";
        	   

	}else {
		sql = "";
		return null;
	}
		
		
		return entityManager.createNativeQuery(sql).getResultList(); 
		}		
		
		public List<FilterDto> getMachineryTypesByFilterKeys(String val,String in)
		{
			
		String sql ="";
           if(in.equalsIgnoreCase(NewFilterRepository.FMB))
         	{
        	   String unoinquery = this.selectMachineTypeFromInputSupplierMachineryTable(val)
       	            +" union all "
       	            +selectMachineTypeFromChcFmbMachineryTable(val);
       	            
       	sql = "select distinct * from ("+unoinquery+") as a order by name asc";
        	   

	}else {
		sql = "";
		return null;
	}
		
		
		return entityManager.createNativeQuery(sql,"BookValueMapping").getResultList(); 
		}		
		
	
		public Double getMaxQuantityByFilterKeys(String val,String in)
		{
			
			
			
		String sql ="";
           if(in.equalsIgnoreCase(NewFilterRepository.CROP))
         	{
        	  
       	            
       	sql = "select MAX(currentMarketable) from (\r\n"
       			+ "				select distinct \r\n"
       			+ "				SUM(tp.current_marketable) as currentMarketable\r\n"
       			+ "				from total_production tp\r\n"
       			+ "				inner join fpo f on tp.fpo_id = f.fpo_id\r\n"
       			+ "				inner join districts dist on f.dist_ref_id = dist.district_id\r\n"
       			+ "				inner join crop_veriety_master cv on cv.veriety_id = tp.veriety_id\r\n"
       			+ "				inner join crop_master cm on cv.crop_master_ref_id = cm.id\r\n"
       			+ "				where UPPER(cm.crop_name) like'%"+val.toUpperCase()+"%'\r\n"
       			+ "				or UPPER(cv.crop_veriety) like'%"+val.toUpperCase()+"%'\r\n"
       			+ "				group by cv.crop_master_ref_id,tp.veriety_id,tp.fpo_id,f.fpo_name,dist.district_id,dist.district_name,cv.crop_veriety,\r\n"
       			+ "				cm.crop_name) as a";
        	   

	}else {
		sql = "";
		return null;
	}
		
		
		return (Double)entityManager.createNativeQuery(sql).getSingleResult(); 
		}
		
		
		private String selectMaxRentFromInputSupplierMachineryTable(String val)
		{
			String sql = "select \r\n"
					+ "inpm.rent_per_day as rent\r\n"
					+ "from input_supplier_machinery inpm \r\n"
					+ "inner join input_supplier ip on ip.input_supplier_id = inpm.input_supplier_id\r\n"
					+ "inner join districts dist on ip.dist_ref_id = dist.district_id \r\n"
					+ "inner join equipment_type_master eqt on eqt.id = inpm.machinery_type_id\r\n"
					+ "inner join equip_master eqp on eqp.id = inpm.machinery_name_id \r\n"
					+ "where UPPER(eqp.equpment_name) LIKE '%"+val.toUpperCase()+"%'\r\n"
					+ "or UPPER(eqt.type) LIKE '%"+val.toUpperCase()+"%'";
			return sql;
		}
	
		private String selectMaxRentFromChcFmbMachineryTable(String val)
		{
			String sql = "select \r\n"
					+ "chc.rent_per_day as rent\r\n"
					+ "from chc_fmb_machinery chc\r\n"
					+ "inner join chc_fmb fmb on fmb.chc_fmb_id = chc.chc_fmb_id\r\n"
					+ "inner join districts dist on fmb.dist_ref_id = dist.district_id \r\n"
					+ "inner join equipment_type_master eqt on eqt.id = chc.equipment_type_id\r\n"
					+ "inner join equip_master eqp on eqp.id = chc.equipment_name_id \r\n"
					+ "where UPPER(eqp.equpment_name) LIKE '%"+val.toUpperCase()+"%'\r\n"
					+ "or UPPER(eqt.type) LIKE '%"+val.toUpperCase()+"%'";
			return sql;
		}
		public Double getMaxRentByFilterKeys(String val,String in)
		{
		
		String sql ="";
           if(in.equalsIgnoreCase(NewFilterRepository.FMB))
         	{     
        	   
        	   String unoinquery = this.selectMaxRentFromInputSupplierMachineryTable(val)
          	            +" union all "
          	            +selectMaxRentFromChcFmbMachineryTable(val);
       	sql = "select max(rent) from ("+unoinquery+") as a";
        	   

	}else {
		sql = "";
		return null;
	}
		
		
		return (Double)entityManager.createNativeQuery(sql).getSingleResult(); 
		}

		


	
}
