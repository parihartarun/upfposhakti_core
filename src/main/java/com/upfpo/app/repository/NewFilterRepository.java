package com.upfpo.app.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upfpo.app.dto.ChcFmbOnDistrictDTO;
import com.upfpo.app.dto.CropAndVerietyList;
import com.upfpo.app.dto.CropFilterDto;
import com.upfpo.app.dto.CropVerietyFilterDto;
import com.upfpo.app.dto.FilterDto;
import com.upfpo.app.dto.FpoOnDistrictDTO;
import com.upfpo.app.dto.InputSupplierOnDistrictDTO;
import com.upfpo.app.dto.ListOnDistrictSearchDTO;

@Repository
public class NewFilterRepository {
	// fpo_name  

	private static final String CROP = "crop";
	private static final String FERTILIZER = "fertilizer";
	private static final String INSECTICIDE = "insecticide";
	private static final String SEED = "seed";
	private static final String MACHINERY = "fmb";
	private static final String INPUTSUPPLIER = "inputsupplier";
	private static final String SERVICES = "service";
	private static final String FMB ="fmb";
	private static final String DISTRICTS = "districts";
	
	
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
				

}else if(in.equalsIgnoreCase(NewFilterRepository.INPUTSUPPLIER))
{
	
	String unoinquery =selectDistrictsFromInputFertilizerTable(val)
            +" union all "
            +this.selectDistrictsFromInputInsecticidesTable(val)
            +" union all "
            +this.selectDistrictsFromInputSeedTable(val);
sql = "select distinct * from ("+unoinquery+") as a";
	
}else if(in.equalsIgnoreCase(NewFilterRepository.INSECTICIDE))
{
	
	String unoinquery = this.selectDistrictsFromInputInsecticidesTable(val);
sql = "select distinct * from ("+unoinquery+") as a";
	
}else if(in.equalsIgnoreCase(NewFilterRepository.SEED))
{
	
	String unoinquery =this.selectDistrictsFromInputSeedTable(val);
sql = "select distinct * from ("+unoinquery+") as a";
	
}else if(in.equalsIgnoreCase(NewFilterRepository.FERTILIZER))
{
	
	String unoinquery =selectDistrictsFromInputFertilizerTable(val);
sql = "select distinct * from ("+unoinquery+") as a";
	
}


else if(in.equalsIgnoreCase(NewFilterRepository.FMB))
{
	String unoinquery = this.selectDistrictsFromInputsupplierMachineryTable(val)
            +" union all "
            +this.selectDistrictsFromChcFmbMachineryTable(val);
            
sql = "select distinct * from ("+unoinquery+") as a order by name asc";

}
else if(in.equalsIgnoreCase(NewFilterRepository.SERVICES))
{
	String unoinquery = this.selectDistrictsFromFpoServicesTable(val);
            
            
sql = "select distinct * from ("+unoinquery+") as a order by name asc";

}

else {
	
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

}else if(in.equalsIgnoreCase(NewFilterRepository.INPUTSUPPLIER)|| in.equalsIgnoreCase(NewFilterRepository.SEED)) {
	
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
			String roleId = "4"; 
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
				

	}else if(in.equalsIgnoreCase(NewFilterRepository.SERVICES))
	{
		sql = "select distinct fs.fpo_id id, fp.fpo_name as name from fpo_additonal_services fs \r\n"
				+ "inner join fpo fp on fp.fpo_id = fs.fpo_id\r\n"
				+ "inner join districts dist on fp.dist_ref_id = dist.district_id\r\n"
				+ "where UPPER(fp.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
			    + "or UPPER(fs.service_name) like '%"+val.toUpperCase()+"%'\r\n"
			    + "or UPPER(fs.description)LIKE '%"+val.toUpperCase()+"%'\r\n"
				+ "order by fp.fpo_name asc";
	}
	else if(in.equalsIgnoreCase(NewFilterRepository.INSECTICIDE))
	{
		sql = "select distinct ins.input_supplier_id as id,f.fpo_name as name from input_supplier_insecticide ins\r\n"
				+ "	inner join fpo f on ins.input_supplier_id = f.fpo_id\r\n"
				+ "	inner join districts dist on f.dist_ref_id = dist.district_id\r\n"
				+ "	inner join insecticide_type_master int on ins.insecticide_type_id = int.id\r\n"
				+ "	where UPPER(int.insecticide_type) like '%"+val.toUpperCase()+"%'\r\n"
				+ "	or UPPER(ins.manufacturer_name) like '%"+val.toUpperCase()+"%'\r\n"
				+ " and ins.role = '4' \r\n"
				+ "	order by f.fpo_name asc";
	}
	else if(in.equalsIgnoreCase(NewFilterRepository.FERTILIZER))
	{
		sql = "select distinct ifs.input_supplier_id as id,f.fpo_name as name from input_supplier_fertilizer ifs\r\n"
				+ "	inner join fpo f on ifs.input_supplier_id = f.fpo_id\r\n"
				+ "	inner join districts dist on f.dist_ref_id = dist.district_id\r\n"
				+ "	inner join fertilizer_type_master ift on ifs.fertilizer_type_id = ift.id\r\n"
				+ "	inner join fertilizer_name_master ifm on ifm.fertilizer_type_id = ift.id\r\n"
				+ "	inner join fertilizer_name_master ifn on ifn.id = ifs.fertilizer_name_id\r\n"
				+ "	where UPPER(ifn.fertilizer_name) like '%"+val.toUpperCase()+"%'\r\n"
				+ "	or UPPER(ift.fertilizer_type) like '%"+val.toUpperCase()+"%'\r\n"
				+ "	and ifs.role = '4' \r\n"
				+ "	order by f.fpo_name asc;";
	}
	else if(in.equalsIgnoreCase(NewFilterRepository.SEED))
	{
		sql = "select distinct iss.input_supplier_id as id,f.fpo_name as name from input_supplier_seed iss\r\n"
				+ "	inner join fpo f on iss.input_supplier_id = f.fpo_id\r\n"
				+ "	inner join districts dist on f.dist_ref_id = dist.district_id\r\n"
				+ "	inner join crop_master cm on cm.id = iss.crop_id\r\n"
				+ "	inner join crop_veriety_master cv on cv.veriety_id = iss.variety_id\r\n"
				+ "	inner join crop_veriety_master cvv on cvv.crop_master_ref_id = cm.id\r\n"
				+ "	where UPPER(cm.crop_name) like '%"+val.toUpperCase()+"%'\r\n"
				+ "	or UPPER(cv.crop_veriety) like '%"+val.toUpperCase()+"%'\r\n"
				+ "	and iss.role = '4'\r\n"
				+ "	order by f.fpo_name asc";
	}
	else if(in.equalsIgnoreCase(NewFilterRepository.MACHINERY))
	{
		sql = "select distinct ism.input_supplier_id as id,f.fpo_name as name from input_supplier_machinery ism\r\n"
				+ "	inner join fpo f on ism.input_supplier_id = f.fpo_id\r\n"
				+ "	inner join districts dist on f.dist_ref_id = dist.district_id\r\n"
				+ "	inner join equipment_type_master etm on etm.id = ism.machinery_type_id\r\n"
				+ "	inner join equip_master eqm on eqm.id = ism.machinery_name_id\r\n"
				+ "	inner join equip_master eq on eq.eqip_type = etm.id\r\n"
				+ "	where UPPER(eqm.equpment_name) like '%"+val.toUpperCase()+"%'\r\n"
				+ "	or UPPER(etm.type) like '%"+val.toUpperCase()+"%'\r\n"
				+ "	or UPPER(ism.manufacturer_name) like '%"+val.toUpperCase()+"%'\r\n"
				+ "	and ism.role = '4'\r\n"
				+ "	order by f.fpo_name asc";
	}
    else {
		sql = "";
		return null;
	}
		
return entityManager.createNativeQuery(sql,"BookValueMapping").getResultList(); 
}

public List<FilterDto> getChcFmbByFilterKeys(String val,String in)
{
	String sql ="";
	if(in.equalsIgnoreCase(NewFilterRepository.MACHINERY))
	{
		sql = "select distinct ism.input_supplier_id as id,f.chc_fmb_name as name from input_supplier_machinery ism\r\n"
				+ "	inner join chc_fmb f on ism.input_supplier_id = f.chc_fmb_id\r\n"
				+ "	inner join districts dist on f.dist_ref_id = dist.district_id\r\n"
				+ "	inner join equipment_type_master etm on etm.id = ism.machinery_type_id\r\n"
				+ "	inner join equip_master eqm on eqm.id = ism.machinery_name_id\r\n"
				+ "	inner join equip_master eq on eq.eqip_type = etm.id\r\n"
				+ "	where UPPER(eqm.equpment_name) like '%"+val.toUpperCase()+"%'\r\n"
				+ "	or UPPER(etm.type) like '%"+val.toUpperCase()+"%'\r\n"
				+ "	or UPPER(ism.manufacturer_name) like '%"+val.toUpperCase()+"%'\r\n"
				+ "	and ism.role = '5'\r\n"
				+ "	order by f.chc_fmb_name asc";
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
		private String selectDistrictsFromFpoServicesTable(String val)
		{
			
			String sql ="select dist.district_id id,dist.district_name as name from fpo_additonal_services fs \r\n"
					+ "inner join fpo fp on fp.fpo_id = fs.fpo_id\r\n"
					+ "inner join districts dist on fp.dist_ref_id = dist.district_id\r\n"
					+ "where UPPER(fp.fpo_name) like '%"+val.toUpperCase()+"%'\r\n"
				    + "or UPPER(fs.service_name) like '%"+val.toUpperCase()+"%'\r\n"
				    + "or UPPER(fs.description)LIKE '%"+val.toUpperCase()+"%'\r\n";
					
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
					+ " or UPPER(inps.input_supplier_name) like '%"+val.toUpperCase()+"%'"
					+ " and inf.role = '3' ";
			return sql;
		}
		
		private String selectInputSuppliersFromInputMachineryTable(String val)
		{
			String sql ="select inm.input_supplier_id as id, inps.input_supplier_name as name\r\n"
					+ "	from input_supplier_machinery inm\r\n"
					+ "	inner join input_supplier inps on inps.input_supplier_id = inm.input_supplier_id \r\n"
					+ "	inner join equipment_type_master eqt on eqt.id = inm.machinery_type_id\r\n"
					+ "	inner join equip_master eqp on eqp.id = inm.machinery_name_id \r\n"
					+ "	inner join districts dist on inps.dist_ref_id = dist.district_id\r\n"
					+ "	where UPPER(eqt.type) like '%"+val.toUpperCase()+"%'\r\n"
					+ "	or UPPER(eqp.equpment_name) like '%"+val.toUpperCase()+"%'\r\n"
					+ "	or UPPER(inm.manufacturer_name) like '%"+val.toUpperCase()+"%'\r\n"
					+ "	and inm.role = '3' ";
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
					+ "  or UPPER(inps.input_supplier_name) like '%"+val.toUpperCase()+"%'"
					+ "	 and inf.role = '3' ";
			return sql;
		}
		private String selectInputSuppliersFromInputFertilizerTable(String val)
		{
			
			String sql ="select inf.input_supplier_id as id, inps.input_supplier_name as name\r\n"
					   + " from input_supplier_fertilizer inf \r\n"
					   + " inner join fertilizer_name_master fn on fn.id = inf.fertilizer_name_id\r\n"
					   + " inner join fertilizer_type_master fnt on fnt.id = inf.fertilizer_type_id\r\n"
					   + " inner join input_supplier inps on inps.input_supplier_id = inf.input_supplier_id \r\n"
					   + " inner join districts dist on inps.dist_ref_id = dist.district_id\r\n"
					   + " where UPPER(fn.fertilizer_name) like '%"+val.toUpperCase()+"%'\r\n"
					   + " OR UPPER(fnt.fertilizer_type) like '%"+val.toUpperCase()+"%'\r\n"
					   + " OR UPPER(inps.input_supplier_name)LIKE '%"+val.toUpperCase()+"%'\r\n"
					   + " and inf.role = '3' ";
					
					
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
			/*String sql ="select inpm.manufacturer_name as name\r\n"
					+ "	from input_supplier_machinery inpm \r\n"
					+ "	inner join input_supplier ip on ip.input_supplier_id = inpm.input_supplier_id\r\n"
					+ "	inner join districts dist on ip.dist_ref_id = dist.district_id \r\n"
					+ "	inner join equipment_type_master eqt on eqt.id = inpm.machinery_type_id\r\n"
					+ "	inner join equip_master eqp on eqp.id = inpm.machinery_name_id \r\n"
					+ "	where UPPER(eqp.equpment_name) LIKE '%"+val.toUpperCase()+"%'\r\n"
					+ "	or UPPER(eqt.type) LIKE '%"+val.toUpperCase()+"%'";*/
			String sql = "select inpm.manufacturer_name as name\r\n"
					+ "	from input_supplier_machinery inpm \r\n"
					+ "	left join input_supplier ip on ip.input_supplier_id = inpm.input_supplier_id\r\n"
					+ "	left join fpo fp on fp.fpo_id = inpm.input_supplier_id\r\n"
					+ "	inner join user_roles usr on usr.role_id = inpm.role\r\n"
					+ "	inner join equipment_type_master eqt on eqt.id = inpm.machinery_type_id\r\n"
					+ "	inner join equip_master eqp on eqp.id = inpm.machinery_name_id \r\n"
					+ "	inner join districts dist on dist.district_id = case when usr.role='ROLE_INPUTSUPPLIER' then ip.dist_ref_id\r\n"
					+ "	else fp.dist_ref_id end\r\n"
					+ "	where UPPER(eqp.equpment_name) LIKE '%"+val.toUpperCase()+"%'\r\n"
					+ "	or UPPER(eqt.type) LIKE '%"+val.toUpperCase()+"%'\r\n"
					+ "	or UPPER(inpm.manufacturer_name) LIKE '%"+val.toUpperCase()+"%'\r\n";
			
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
	           if(in.equalsIgnoreCase(NewFilterRepository.INPUTSUPPLIER))
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
           if(in.equalsIgnoreCase(NewFilterRepository.INPUTSUPPLIER))
         	{
        	   String unoinquery = selectInputSuppliersFromInputFertilizerTable(val)
        	            +" union all "
        	            +this.selectInputSuppliersFromInputInsecticidesTable(val)
        	            +" union all "
        	            +this.selectInputSuppliersFromInputSeedTable(val);
        	   sql = "select distinct * from ("+unoinquery+") as a";

         	}else if (in.equalsIgnoreCase(NewFilterRepository.SEED))
         	{
         		String unoinquery = this.selectInputSuppliersFromInputSeedTable(val);
         		sql = "select distinct * from ("+unoinquery+") as a";

         	}
         	else if (in.equalsIgnoreCase(NewFilterRepository.FERTILIZER))
         	{
         		String unoinquery = selectInputSuppliersFromInputFertilizerTable(val);
         		sql = "select distinct * from ("+unoinquery+") as a";

         	}else if (in.equalsIgnoreCase(NewFilterRepository.INSECTICIDE))
         	{
         		String unoinquery = this.selectInputSuppliersFromInputInsecticidesTable(val);
         		sql = "select distinct * from ("+unoinquery+") as a";

         	}
         	else if(in.equalsIgnoreCase(NewFilterRepository.FMB))
         	{
         		String unoinquery = this.selectInputSuppliersFromInputMachineryTable(val);
         		sql = "select distinct * from ("+unoinquery+") as a";
         	}
         	else {
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
           if(in.equalsIgnoreCase(NewFilterRepository.INPUTSUPPLIER) || in.equalsIgnoreCase(NewFilterRepository.FERTILIZER))
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
        	   String unoinquery = this.selectCompanyFromInputSupplierMachineryTable(val);
       	            //+" union all "
       	            //+selectCompanyFromChcFmbMachineryTable(val);
       	            
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

		
	public ListOnDistrictSearchDTO getListOnDistrictSearch(String val,String in)
	{
		String sql = "";
		String groupBy = "";
		List<FpoOnDistrictDTO> obj = null;
		List<InputSupplierOnDistrictDTO> objIns = null;
		List<ChcFmbOnDistrictDTO> objChcFmb = null;
		ListOnDistrictSearchDTO listDto = new ListOnDistrictSearchDTO();
		if(val == null)
		{
			val = "";
		}
		
		if(in.equalsIgnoreCase(NewFilterRepository.DISTRICTS))
		{
			if(val == "")
			{
				sql = "select distinct d.district_id as districtId, d.district_name as districtName, f.fpo_id as fpoId, f.fpo_name as fpoName, f.fpo_email as fpoEmail, f.fpo_landline as fpoLandline, \r\n"
						+ "STRING_AGG(distinct cm.crop_name, ', ') as crops, STRING_AGG(distinct ads.service_name, ', ') as additionalServices from fpo f\r\n"
						+ "				inner join districts d on f.dist_ref_id = d.district_id\r\n"
						+ "				left join total_production t on t.fpo_id = f.fpo_id\r\n"
						+ "				left join crop_master cm on cm.id = t.crop_id\r\n"
						+ "				left join fpo_additonal_services ads on ads.fpo_id = f.fpo_id\r\n";
				groupBy = " group by d.district_id, d.district_name, f.fpo_id, f.fpo_name, f.fpo_email, f.fpo_landline";
				sql = sql+groupBy;
				obj = (List<FpoOnDistrictDTO>) entityManager.createNativeQuery(sql,"FpoOnDistrictDTO").getResultList();
			}
			else
			{
				sql = "select distinct d.district_id as districtId, d.district_name as districtName, f.fpo_id as fpoId, f.fpo_name as fpoName, f.fpo_email as fpoEmail, f.fpo_landline as fpoLandline, \r\n"
						+ "STRING_AGG(distinct cm.crop_name, ', ') as crops, STRING_AGG(distinct ads.service_name, ', ') as additionalServices from fpo f\r\n"
						+ "				inner join districts d on f.dist_ref_id = d.district_id\r\n"
						+ "				left join total_production t on t.fpo_id = f.fpo_id\r\n"
						+ "				left join crop_master cm on cm.id = t.crop_id\r\n"
						+ "				left join fpo_additonal_services ads on ads.fpo_id = f.fpo_id\r\n"
						+ "				where upper(d.district_name) like '%"+val.toUpperCase()+"%'"
						+ " group by d.district_id, d.district_name, f.fpo_id, f.fpo_name, f.fpo_email, f.fpo_landline";
				
				obj = (List<FpoOnDistrictDTO>) entityManager.createNativeQuery(sql,"FpoOnDistrictDTO").getResultList();
			}
			
			
			
			if(val == "")
			{
				sql = "select distinct d.district_id as districtId, d.district_name as districtName, i.input_supplier_id, i.input_supplier_name, i.email, i.mobile_number,\r\n"
						+ "STRING_AGG(distinct cm.crop_name, ', ') as cropSeeds, STRING_AGG(distinct ifn.fertilizer_name, ', ') as fertilizers,\r\n"
						+ "STRING_AGG(distinct ist.insecticide_type, ', ') as insecticides, STRING_AGG(distinct eq.equpment_name, ', ') as machineries\r\n"
						+ "from input_supplier i\r\n"
						+ "inner join districts d on i.dist_ref_id = d.district_id\r\n"
						+ "left join input_supplier_seed isu on isu.input_supplier_id = i.input_supplier_id\r\n"
						+ "left join crop_master cm on cm.id = isu.crop_id\r\n"
						+ "left join input_supplier_fertilizer ifr on ifr.input_supplier_id = i.input_supplier_id\r\n"
						+ "left join fertilizer_name_master ifn on ifr.fertilizer_name_id = ifn.id\r\n"
						+ "left join input_supplier_insecticide isi on isi.input_supplier_id = i.input_supplier_id\r\n"
						+ "left join insecticide_type_master ist on isi.insecticide_type_id = ist.id\r\n"
						+ "left join input_supplier_machinery ism on ism.input_supplier_id = i.input_supplier_id\r\n"
						+ "left join equip_master eq on eq.id = ism.machinery_name_id\r\n"
						+ "  group by d.district_id, d.district_name, i.input_supplier_id, i.input_supplier_name, i.email, i.mobile_number order by i.input_supplier_id asc";
				objIns = (List<InputSupplierOnDistrictDTO>) entityManager.createNativeQuery(sql,"InputSupplierOnDistrictDTO").getResultList();
			}
			else
			{
				sql = "select distinct d.district_id as districtId, d.district_name as districtName, i.input_supplier_id, i.input_supplier_name, i.email, i.mobile_number,\r\n"
						+ "STRING_AGG(distinct cm.crop_name, ', ') as cropSeeds, STRING_AGG(distinct ifn.fertilizer_name, ', ') as fertilizers,\r\n"
						+ "STRING_AGG(distinct ist.insecticide_type, ', ') as insecticides, STRING_AGG(distinct eq.equpment_name, ', ') as machineries\r\n"
						+ "from input_supplier i\r\n"
						+ "inner join districts d on i.dist_ref_id = d.district_id\r\n"
						+ "left join input_supplier_seed isu on isu.input_supplier_id = i.input_supplier_id\r\n"
						+ "left join crop_master cm on cm.id = isu.crop_id\r\n"
						+ "left join input_supplier_fertilizer ifr on ifr.input_supplier_id = i.input_supplier_id\r\n"
						+ "left join fertilizer_name_master ifn on ifr.fertilizer_name_id = ifn.id\r\n"
						+ "left join input_supplier_insecticide isi on isi.input_supplier_id = i.input_supplier_id\r\n"
						+ "left join insecticide_type_master ist on isi.insecticide_type_id = ist.id\r\n"
						+ "left join input_supplier_machinery ism on ism.input_supplier_id = i.input_supplier_id\r\n"
						+ "left join equip_master eq on eq.id = ism.machinery_name_id\r\n"
						+ "where upper(d.district_name) like '%"+val.toUpperCase()+"%'"
						+ "  group by d.district_id, d.district_name, i.input_supplier_id, i.input_supplier_name, i.email, i.mobile_number order by i.input_supplier_id asc;";
				objIns = (List<InputSupplierOnDistrictDTO>) entityManager.createNativeQuery(sql,"InputSupplierOnDistrictDTO").getResultList();
			}
			
			if(val == "")
			{
				sql = "select distinct d.district_id, d.district_name, c.chc_fmb_id, c.chc_fmb_name, c.email, c.mobile_number, \r\n"
						+ "STRING_AGG(distinct eq.equpment_name, ', ') as machineries from chc_fmb c\r\n"
						+ "				inner join districts d on c.dist_ref_id = d.district_id\r\n"
						+ "				left join chc_fmb_machinery cm on cm.chc_fmb_id = c.chc_fmb_id\r\n"
						+ "				left join equip_master eq on eq.id = cm.equipment_name_id\r\n"
						+ "				group by d.district_id, d.district_name, c.chc_fmb_id, c.chc_fmb_name, c.email, c.mobile_number";
				objChcFmb = (List<ChcFmbOnDistrictDTO>) entityManager.createNativeQuery(sql,"ChcFmbOnDistrictDTO").getResultList();
			}
			else
			{
				sql = "select distinct d.district_id, d.district_name, c.chc_fmb_id, c.chc_fmb_name, c.email, c.mobile_number, \r\n"
						+ "STRING_AGG(distinct eq.equpment_name, ', ') as machineries from chc_fmb c\r\n"
						+ "				inner join districts d on c.dist_ref_id = d.district_id\r\n"
						+ "				left join chc_fmb_machinery cm on cm.chc_fmb_id = c.chc_fmb_id\r\n"
						+ "				left join equip_master eq on eq.id = cm.equipment_name_id\r\n"
						+ "				where upper(d.district_name) like '%"+val.toUpperCase()+"%'"
						+ "				group by d.district_id, d.district_name, c.chc_fmb_id, c.chc_fmb_name, c.email, c.mobile_number";
				objChcFmb = (List<ChcFmbOnDistrictDTO>) entityManager.createNativeQuery(sql,"ChcFmbOnDistrictDTO").getResultList();
			}
			listDto.setFpoDetails(obj);
			listDto.setInputSupplierDetails(objIns);
			listDto.setChcFmbDetails(objChcFmb);
		}
		
		return listDto;
	}

	
}
