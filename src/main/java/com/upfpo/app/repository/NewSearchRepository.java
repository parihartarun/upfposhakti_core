package com.upfpo.app.repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.upfpo.app.dto.CropAndVerietyList;
import com.upfpo.app.dto.CropFilterDto;
import com.upfpo.app.dto.CropVerietyFilterDto;
import com.upfpo.app.dto.FPODetailsDTO;
import com.upfpo.app.dto.FilterDto;
import com.upfpo.app.dto.FmbSearchPagePagableDto;
import com.upfpo.app.dto.FpoServicePagePagableDto;
import com.upfpo.app.dto.InputSupplierFertilizersPagePagableDto;
import com.upfpo.app.dto.InputSupplierPagePagableDto;
import com.upfpo.app.dto.ReportDTO;
import com.upfpo.app.dto.CropSearchPagePagableDto;
import com.upfpo.app.dto.SearchRequestDto;
import com.upfpo.app.dto.SearchResponseDto;
import com.upfpo.app.dto.search.FmbSearchDtoAll;
import com.upfpo.app.dto.search.FpoServiceSearchDto;
import com.upfpo.app.dto.search.InputSupplierFertilizerSearchDto;
import com.upfpo.app.dto.search.InputSupplierSearchDtoAll;
import com.upfpo.app.entity.CropMaster;
import com.upfpo.app.util.GetFinYear;



@Repository
public class NewSearchRepository {
	private static final String CROP ="crop";
	private static final String INPUTSUPPLIERS="inputsupplier";
	private static final String FMB ="fmb";
	@Autowired
	private EntityManager entityManager;
	Session session = null;
	Query query = null;
	Transaction tx = null;
	
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;


	
	private  String sql = "";
	private List<ReportDTO> result = null;
	
	
	private  org.hibernate.Session getCurrentSession(){

	    return entityManagerFactory.unwrap(SessionFactory.class).openSession();
	}	
		
	public ResponseEntity<?> newCropSearch(SearchRequestDto searchRequestDto)
	{
		
		String sql ="select distinct \r\n"
				+ "SUM(tp.current_marketable) as currentMarketable,\r\n"
				+ "cv.crop_master_ref_id as cropid,\r\n"
				+ "cm.crop_name as crop,\r\n"
				+ "tp.veriety_id as varietyid,\r\n"
				+ "cv.crop_veriety as variety,\r\n"
				+ "tp.fpo_id as fpoid,\r\n"
				+ "f.fpo_name as fpo,\r\n"
				+ "dist.district_id as districtid,\r\n"
				+ "dist.district_name as district, \r\n"
				+ "roles.role as role \r\n"
				+ "from total_production tp\r\n"
				+ "inner join fpo f on tp.fpo_id = f.fpo_id\r\n"
				+ "inner join districts dist on f.dist_ref_id = dist.district_id\r\n"
				+ "inner join users usr on usr.user_id = f.user_id \r\n"
				+ "inner join user_roles roles on roles.role_id = usr.role_ref_id \r\n"
				+ "inner join crop_veriety_master cv on cv.veriety_id = tp.veriety_id\r\n"
				+ "inner join crop_master cm on cv.crop_master_ref_id = cm.id\r\n"
				+ "where UPPER(cm.crop_name) like'%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
				+ "or UPPER(cv.crop_veriety) like'%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
				+ "group by cv.crop_master_ref_id,tp.veriety_id,tp.fpo_id,f.fpo_name,dist.district_id,dist.district_name,cv.crop_veriety,\r\n"
				+ "cm.crop_name,\r\n"
				+ "roles.role";
		
		   System.out.println("Query here"+sql);
		  
		  List<SearchResponseDto> obj = (List<SearchResponseDto>) entityManager.createNativeQuery(sql,"SearchResponseDTO").getResultList();	
		  Integer offset  =(searchRequestDto.getPage().intValue()-1)*searchRequestDto.getLimit().intValue();
		  Integer last =offset.intValue()+searchRequestDto.getLimit().intValue(); 
		  Predicate<SearchResponseDto> cropFinalpredicate=null;
		  
			if(searchRequestDto.getDistrictIds()!=null) {
				for(Integer districtId:searchRequestDto.getDistrictIds())
				{
					
					Predicate<SearchResponseDto> samplepredicate =  samplepredecate->samplepredecate.getDistrictid().intValue()==districtId.intValue();
				      if(cropFinalpredicate==null)
				      {
				    	  cropFinalpredicate = samplepredicate;
				      }else {
				    	  cropFinalpredicate =cropFinalpredicate.or(samplepredicate);
				      }
				}
				obj = cropFinalpredicate==null?obj:obj.stream().filter(cropFinalpredicate).collect(Collectors.toList());	
			} 

			cropFinalpredicate=null;
			if(searchRequestDto.getFpoIds()!=null) {
				for(Integer fpoId:searchRequestDto.getFpoIds())
				{
					
					Predicate<SearchResponseDto> samplepredicate =  samplepredecate->samplepredecate.getFpoid().intValue()==fpoId.intValue();
				      if(cropFinalpredicate==null)
				      {
				    	  cropFinalpredicate = samplepredicate;
				      }else {
				    	  cropFinalpredicate =cropFinalpredicate.or(samplepredicate);
				      }
				}
				obj = cropFinalpredicate==null?obj:obj.stream().filter(cropFinalpredicate).collect(Collectors.toList());	
			}
			
		
				cropFinalpredicate=null;
			
//			if(searchRequestDto.getCropIds()!=null) {
//				for(Integer cropId:searchRequestDto.getCropIds())
//				{
//					
//					Predicate<SearchResponseDto> samplepredicate =  samplepredecate->samplepredecate.getCropid().intValue()==cropId.intValue();
//				      if(cropFinalpredicate==null)
//				      {
//				    	  cropFinalpredicate = samplepredicate;
//				      }else {
//				    	  cropFinalpredicate =cropFinalpredicate.or(samplepredicate);
//				      }
//				}
//			
//			}
			if(searchRequestDto.getCropverietyIds()!=null) {
				for(Integer cropVerietyId:searchRequestDto.getCropverietyIds())
				{
					Predicate<SearchResponseDto> samplepredicate =  samplepredecate->samplepredecate.getVarietyid().intValue()==cropVerietyId.intValue();
				      if(cropFinalpredicate==null)
				      {
				    	  cropFinalpredicate = samplepredicate;
				      }else {
				    	  cropFinalpredicate =cropFinalpredicate.or(samplepredicate);
				      }
				}
			
			}
			obj = cropFinalpredicate==null?obj:obj.stream().filter(cropFinalpredicate).collect(Collectors.toList());
			
			if(searchRequestDto.getQtymin()!=null&&searchRequestDto.getQtymax()!=null) 
			{
				Predicate<SearchResponseDto> samplepredicate =  samplepredecate->samplepredecate.getCurrentMarketable().doubleValue()>searchRequestDto.getQtymin().doubleValue() && samplepredecate.getCurrentMarketable().doubleValue()<=searchRequestDto.getQtymax().doubleValue();
				cropFinalpredicate=samplepredicate; 
				obj =obj.stream().filter(cropFinalpredicate).collect(Collectors.toList());
			}
			
		  CropSearchPagePagableDto cropSearchPagePagableDto = new CropSearchPagePagableDto();
		  cropSearchPagePagableDto.setTotalElements(obj.size());
		  //cropSearchPagePagableDto.setPage(obj);
		  cropSearchPagePagableDto.setPage(obj.subList(offset>obj.size()?0:offset, last>obj.size()?obj.size():last));
		  return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(cropSearchPagePagableDto);	
	}
	private String searchFertilizersInInputSupplierFertilizer(SearchRequestDto searchRequestDto)
	{
		
		
		String sql ="select inf.id id, \r\n"
				+ "	fn.fertilizer_name itemname,\r\n"
				+ " fnt.id as itemtypeid,\r\n"
				+ "	fnt.fertilizer_type itemtype,\r\n"
				+ "	inf.quantity quantity,\r\n"
				+ "	inf.input_supplier_id inputsupplierid,\r\n"
				+ "	inps.input_supplier_name inputsupplier,\r\n"
				+ "	dist.district_id as districtid,\r\n"
				+ "	dist.district_name district,\r\n"
				+ "	inf.file_path imagepath,\r\n"
				+ "	inf.manufacturer_name manufacturer,\r\n"
				+ "	'null' as crop,\r\n"
				+ "	cast(null as integer) as cropid,\r\n"
				+ "	'null' as cropveriety,\r\n"
				+ "	cast(null as integer) as cropverietyid,\r\n"
				+ "	'fertilizer' as recordtype,\r\n"
				+ "	usrrole.role as role\r\n"
				+ "	from input_supplier_fertilizer inf \r\n"
				+ "	inner join fertilizer_name_master fn on fn.id = inf.fertilizer_name_id\r\n"
				+ "	inner join fertilizer_type_master fnt on fnt.id = inf.fertilizer_type_id\r\n"
				+ "	inner join input_supplier inps on inps.input_supplier_id = inf.input_supplier_id \r\n"
                + "	inner join users usr on inps.user_id = usr.user_id \r\n"
                + "	inner join user_roles usrrole on usr.role_ref_id = usrrole.role_id \r\n"
				+ " inner join districts dist on inps.dist_ref_id = dist.district_id"
		        + " where UPPER(fn.fertilizer_name) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
		        + " or UPPER(fnt.fertilizer_type) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
		        + " or UPPER(inps.input_supplier_name)LIKE '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n";
		return sql;
		

		
	}

	
	private String searchOnlyFertilizersInInputSupplierFertilizer(SearchRequestDto searchRequestDto)
	{

		
		
//		String sql ="select inf.id id, \r\n"
//				+ "inf.fertilizer_name_id itemnameid,\r\n"
//				+ "	fn.fertilizer_name itemname,\r\n"
//				+ "	inf.fertilizer_grade grade,\r\n"
//				+ " fnt.id as itemtypeid,\r\n"
//				+ "	fnt.fertilizer_type itemtype,\r\n"
//				+ "	inf.quantity quantity,\r\n"
//				+ "	inf.input_supplier_id inputsupplierid,\r\n"
//				+ "	inps.input_supplier_name inputsupplier,\r\n"
//				+ "	dist.district_id as districtid,\r\n"
//				+ "	dist.district_name district,\r\n"
//				+ "	inf.file_path imagepath,\r\n"
//				+ "	inf.manufacturer_name manufacturer,\r\n"
//				+ "	'null' as crop,\r\n"
//				+ "	cast(null as integer) as cropid,\r\n"
//				+ "	'null' as cropveriety,\r\n"
//				+ "	cast(null as integer) as cropverietyid,\r\n"
//				+ "	'fertilizer' as recordtype,\r\n"
//				+ "	usrrole.role as role\r\n"
//				+ "	from input_supplier_fertilizer inf \r\n"
//				+ "	inner join fertilizer_name_master fn on fn.id = inf.fertilizer_name_id\r\n"
//				+ "	inner join fertilizer_type_master fnt on fnt.id = inf.fertilizer_type_id\r\n"
//				+ "	inner join input_supplier inps on inps.input_supplier_id = inf.input_supplier_id \r\n"
//                + "	inner join users usr on inps.user_id = usr.user_id \r\n"
//                + "	inner join user_roles usrrole on usr.role_ref_id = usrrole.role_id \r\n"
//				+ " inner join districts dist on inps.dist_ref_id = dist.district_id"
//		        + " where UPPER(fn.fertilizer_name) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
//		        + " or UPPER(fnt.fertilizer_type) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
//		        + " or UPPER(inps.input_supplier_name)LIKE '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n";
		
		String sql ="select isf.id id, \r\n"
				+ "isf.fertilizer_grade grade,\r\n"
				+ "isf.fertilizer_name_id itemnameid,\r\n"
				+ "fn.fertilizer_name itemname,\r\n"
				+ "isf.fertilizer_type_id itemtypeid,\r\n"
				+ "fnt.fertilizer_type itemtype,\r\n"
				+ "isf.file_path imagepath,  \r\n"
				+ "dist.district_id as districtid,\r\n"
				+ "dist.district_name as district,\r\n"
				+ "isf.input_supplier_id vendorid, \r\n"
				+ "case when usr.role='ROLE_INPUTSUPPLIER' then ip.input_supplier_name\r\n"
				+ "else fp.fpo_name end as vendorname,  \r\n"
				+ "case when usr.role='ROLE_INPUTSUPPLIER' then ip.email\r\n"
				+ "else fp.fpo_email end as vendorEmail,\r\n"
				+ "case when usr.role='ROLE_INPUTSUPPLIER' then ip.user_id\r\n"
				+ "else fp.user_id end as userid,  \r\n"
				+ "isf.manufacturer_name manufacturer,\r\n"
				+ "isf.quantity quantity, \r\n"
				+ "'fertilizer' as recordtype,\r\n"
				+ "'null' as crop, \r\n"
				+ "cast(null as integer) as cropid,\r\n"
				+ "'null' as cropveriety,\r\n"
				+ "cast(null as integer) as cropverietyid,\r\n"
				+ "isf.role as roleid,\r\n"
				+ "usr.role as role\r\n"
				+ "from input_supplier_fertilizer isf \r\n"
				+ "inner join user_roles usr on usr.role_id = isf.role\r\n"
				+ "left join input_supplier ip on ip.input_supplier_id = isf.input_supplier_id \r\n"
				+ "left join fpo fp on fp.fpo_id = isf.input_supplier_id\r\n"
				+ "inner join fertilizer_type_master ft on ft.id = isf.fertilizer_type_id\r\n"
				+ "inner join fertilizer_name_master fn on fn.id = isf.fertilizer_name_id\r\n"
				+ "inner join fertilizer_type_master fnt on fnt.id = isf.fertilizer_type_id\r\n"
				+ "inner join districts dist on dist.district_id = case when usr.role='ROLE_INPUTSUPPLIER' then ip.dist_ref_id\r\n"
				+ "else fp.dist_ref_id end"
				+ " where UPPER(fn.fertilizer_name) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
			    + " or UPPER(fnt.fertilizer_type) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n";
			    //+ " or UPPER(isf.input_supplier_name)LIKE '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n";
		
		
		return sql;
		

		
	}

	
private String searchInsecticidesInInputSupplierInsecticides(SearchRequestDto searchRequestDto)
	{
	
   
//		String sql ="select inf.id id,\r\n"
//				+ "	'null' as itemname,\r\n"
//				+ "	fnt.id as itemtypeid,\r\n"
//				+ "	fnt.insecticide_type itemtype,\r\n"
//				+ "	cast(inf.quantity as float) quantity,\r\n"
//				+ "	inf.input_supplier_id inputsupplierid, \r\n"
//				+ "	inps.input_supplier_name inputsupplier,\r\n"
//				+ "	dist.district_id as districtid,\r\n"
//				+ "	dist.district_name district,\r\n"
//				+ "	inf.file_path imagepath,\r\n"
//				+ "	inf.manufacturer_name manufacturer,\r\n"
//				+ "	'null' as crop,\r\n"
//				+ "	cast(null as integer) as cropid, \r\n"
//				+ "	'null' as cropveriety,\r\n"
//				+ "	cast(null as integer) as cropverietyid,	\r\n"
//				+ "	'insecticide' as recordtype, \r\n"
//				+ "	usrrole.role as role\r\n"
//				+ "	from input_supplier_insecticide inf \r\n"
//				+ "	inner join insecticide_type_master fnt on fnt.id = inf.insecticide_type_id \r\n"
//				+ "	inner join input_supplier inps on inps.input_supplier_id = inf.input_supplier_id \r\n"
//		        + "	inner join users usr on inps.user_id = usr.user_id \r\n"
//	            + "	inner join user_roles usrrole on usr.role_ref_id = usrrole.role_id \r\n"
//				+ "	inner join districts dist on inps.dist_ref_id = dist.district_id \r\n"
//				+ " where UPPER(fnt.insecticide_type) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
//				+ " or UPPER(inf.manufacturer_name) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
//				+ " or UPPER(inps.input_supplier_name) like '%"+searchRequestDto.getVal().toUpperCase()+"%'";
				
	String sql ="select ins.id as id, 	\r\n"
			+ "'null' as itemname,\r\n"
			+ "'null' as crop,\r\n"
			+ "cast(NULL as integer) as cropid,\r\n"
			+ "'null' as cropveriety,\r\n"
			+ "cast(NULL as integer) as cropverietyid,\r\n"
			+ "'insecticide' as recordtype,\r\n"
			+ "ins.file_path as imagepath,\r\n"
			+ "ins.input_supplier_id as vendorid,\r\n"
			+ "case when usr.role='ROLE_INPUTSUPPLIER' then ip.input_supplier_name\r\n"
			+ "else fp.fpo_name end as vendorname,\r\n"
			+ "case when usr.role='ROLE_INPUTSUPPLIER' then ip.email\r\n"
			+ "else fp.fpo_email end as vendoremail,\r\n"
			+ "case when usr.role='ROLE_INPUTSUPPLIER' then ip.user_id\r\n"
			+ "else fp.user_id end as userid,\r\n"
			+ "ins.insecticide_type_id as itemtypeid,\r\n"
			+ "ints.insecticide_type as itemtype,\r\n"
			+ "ins.manufacturer_name as manufacturer,\r\n"
			+ "cast(ins.quantity as float) quantity ,\r\n"
			+ "dist.district_id as districtid,\r\n"
			+ "dist.district_name as district,\r\n"
			+ "ins.role as roleid,\r\n"
			+ "usr.role as role\r\n"
			+ "from input_supplier_insecticide ins\r\n"
			+ "inner join user_roles usr on usr.role_id = ins.role\r\n"
			+ "left join input_supplier ip on ip.input_supplier_id = ins.input_supplier_id \r\n"
			+ "left join fpo fp on fp.fpo_id = ins.input_supplier_id\r\n"
			+ "inner join insecticide_type_master ints on ints.id = ins.insecticide_type_id\r\n"
			+ "inner join districts dist on dist.district_id = case when usr.role='ROLE_INPUTSUPPLIER' then ip.dist_ref_id\r\n"
			+ "else fp.dist_ref_id end"
			+ " where UPPER(ints.insecticide_type) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
			+ " or UPPER(ins.manufacturer_name) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n";
//			+ " or UPPER(inps.input_supplier_name) like '%"+searchRequestDto.getVal().toUpperCase()+"%'"
	
		return sql;
		
	}
	
    private String searchSeedsInInputSupplierSeeds(SearchRequestDto searchRequestDto)
	{
//		String sql ="select inf.id id, \r\n"
//				+ "	'null' as itemname,\r\n"
//				+ "	cast(null as integer) as itemtypeid,\r\n"
//				+ "	'null' as itemtype,\r\n"
//				+ "	inf.quantity quantity,\r\n"
//				+ "	inf.input_supplier_id inputsupplierid,\r\n"
//				+ "	inps.input_supplier_name inputsupplier,\r\n"
//				+ "	dist.district_id as districtid,\r\n"
//				+ "	dist.district_name district,\r\n"
//				+ "	inf.file_path imagepath,\r\n"
//				+ "	'null' as manufacturer,\r\n"
//				+ "	cp.crop_name as crop,\r\n"
//				+ "	cv.crop_master_ref_id as cropid, \r\n"
//				+ "	cv.crop_veriety as cropveriety,\r\n"
//				+ "	inf.variety_id 	as cropverietyid,\r\n"
//				+ "	'seeds' as recordtype, \r\n"
//				+ "	usrrole.role as role\r\n"
//				+ "	from input_supplier_seed inf \r\n"
//				+ "	inner join input_supplier inps on inps.input_supplier_id = inf.input_supplier_id\r\n"
//				+ "	inner join users usr on inps.user_id = usr.user_id \r\n"
//	            + "	inner join user_roles usrrole on usr.role_ref_id = usrrole.role_id \r\n"
//				+ "	inner join crop_veriety_master cv on cv.veriety_id = inf.variety_id\r\n"
//				+ "	inner join crop_master cp on cp.id = cv.crop_master_ref_id\r\n"
//				+ "	inner join districts dist on inps.dist_ref_id = dist.district_id \r\n"
//		        + "  where UPPER(cp.crop_name) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
//		        + "  or UPPER(cv.crop_veriety) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
//		        + "  or UPPER(inps.input_supplier_name) like '%"+searchRequestDto.getVal().toUpperCase()+"%'";
		
    	String sql = "select isd.id id,\r\n"
    			+ "	'null' as itemname,\r\n"
				+ "	cast(null as integer) as itemtypeid,\r\n"
				+ "	'null' as itemtype,\r\n"
    			+ "isd.input_supplier_id vendorid,\r\n"
    			+ "case when usr.role='ROLE_INPUTSUPPLIER' then ip.input_supplier_name\r\n"
    			+ "else fp.fpo_name end as vendorname, \r\n"
    			+ "case when usr.role='ROLE_INPUTSUPPLIER' then ip.email\r\n"
    			+ "else fp.fpo_email end as vendorEmail,\r\n"
    			+ "case when usr.role='ROLE_INPUTSUPPLIER' then ip.user_id\r\n"
    			+ "else fp.user_id end as userid, \r\n"
    			+ "isd.company_brand manufacturer,\r\n"
    			+ "'seeds' as recordtype,\r\n"
    			+ "cv.crop_master_ref_id as cropid,\r\n"
    			+ "cp.crop_name as crop,\r\n"
    			+ "isd.variety_id cropverietyid,\r\n"
    			+ "cv.crop_veriety as cropveriety,\r\n"
    			+ "isd.role roleid,\r\n"
    			+ "isd.quantity quantity,\r\n"
    			+ "isd.file_path imagepath,\r\n"
    			+ "isd.role as roleid,\r\n"
    			+ "dist.district_id as districtid,\r\n"
    			+ "dist.district_name as district,\r\n"
    			+ "usr.role as role\r\n"
    			+ "from input_supplier_seed isd\r\n"
    			+ "inner join user_roles usr on usr.role_id = isd.role\r\n"
    			+ "left join input_supplier ip on ip.input_supplier_id = isd.input_supplier_id \r\n"
    			+ "left join fpo fp on fp.fpo_id = isd.input_supplier_id\r\n"
    			+ "inner join crop_veriety_master cv on cv.veriety_id = isd.variety_id\r\n"
    			+ "inner join crop_master cp on cp.id = cv.crop_master_ref_id\r\n"
    			+ "inner join districts dist on dist.district_id = case when usr.role='ROLE_INPUTSUPPLIER' then ip.dist_ref_id\r\n"
    			+ "else fp.dist_ref_id end"
    			+ "  where UPPER(cp.crop_name) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
		        + "  or UPPER(cv.crop_veriety) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n";
//		        + "  or UPPER(inps.input_supplier_name) like '%"+searchRequestDto.getVal().toUpperCase()+"%'";
    			
    			;
		
		return sql;
	}
	
	
	
	private String searchServicesInFpos(SearchRequestDto searchRequestDto)
	{
		
		String sql ="select fs.id, fs.fpo_id vendorid, fp.fpo_name vendorname,dist.district_id districtid,dist.district_name district, fs.service_name servicename,fs.description from fpo_additonal_services fs \r\n"
				+ "inner join fpo fp on fp.fpo_id = fs.fpo_id\r\n"
				+ "inner join districts dist on fp.dist_ref_id = dist.district_id\r\n"
				+ "where UPPER(fp.fpo_name) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
			    + "or UPPER(fs.service_name) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
			    + "or UPPER(fs.description)LIKE '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n";
		return sql;
		

		
	}
	
	
	public ResponseEntity<?> newInputSupplierSearch(SearchRequestDto searchRequestDto)
	{
		String sql = searchFertilizersInInputSupplierFertilizer(searchRequestDto)
				     +" union all " 
	                 +searchInsecticidesInInputSupplierInsecticides(searchRequestDto) 
		             +" union all "
		             +searchSeedsInInputSupplierSeeds(searchRequestDto);
		
		  List<InputSupplierSearchDtoAll> obj =  entityManager.createNativeQuery(sql,"inputSupplierResultMapping").getResultList();	
		  Integer offset  =(searchRequestDto.getPage().intValue()-1)*searchRequestDto.getLimit().intValue();
		  Integer last =offset.intValue()+searchRequestDto.getLimit().intValue(); 
		  
		  Predicate<InputSupplierSearchDtoAll> inputSupplierFinalPredecate=null;
			if(searchRequestDto.getDistrictIds()!=null) {
				for(Integer districtId:searchRequestDto.getDistrictIds())
				{
					
					Predicate<InputSupplierSearchDtoAll> samplepredicate =  samplepredecate->samplepredecate.getDistrictid().intValue()==districtId.intValue();
				      if(inputSupplierFinalPredecate==null)
				      {
				    	  inputSupplierFinalPredecate = samplepredicate;
				      }else {
				    	  inputSupplierFinalPredecate = inputSupplierFinalPredecate.or(samplepredicate);
				      }
				}
				obj = inputSupplierFinalPredecate==null?obj:obj.stream().filter(inputSupplierFinalPredecate).collect(Collectors.toList());
			} 
			//obj = obj.stream().filter(inputSupplierFinalPredecate).collect(Collectors.toList());
		  InputSupplierPagePagableDto inputSupplierPagePagableDto = new InputSupplierPagePagableDto();
		  inputSupplierPagePagableDto.setTotalElements(obj.size());
		  //inputSupplierPagePagableDto.setPage(obj);
		  inputSupplierPagePagableDto.setPage(obj.subList(offset>obj.size()?0:offset, last>obj.size()?obj.size():last));
		  return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(inputSupplierPagePagableDto);
	}
	
	private String searchMachineryInFmbTable(SearchRequestDto searchRequestDto)
	{
		
		String sql ="select \r\n"
				+ "		fmb.chc_fmb_id as vendorid,\r\n"
				+ "		fmb.chc_fmb_name as vendorname,\r\n"
				+ "		chc.file_path as imagepath,\r\n"
				+ "		chc.company as company,\r\n"
				+ "		chc.equipment_type_id as machinetypeid,\r\n"
				+ "		eqt.type as machinetype,\r\n"
				+ "		chc.quantity_avail as quantity,\r\n"
				+ "		dist.district_id as districtid,\r\n"
				+ "		dist.district_name as district,\r\n"
				+ "		chc.rent_per_day as rent,\r\n"
				+ "		chc.equipment_name_id as machinenameid,\r\n"
				+ "		eqp.equpment_name as machinename,\r\n"
				+ "		'chcfmb'as recordtype,\r\n"
				+ "		roles.role as role\r\n"
				+ "		from chc_fmb_machinery chc\r\n"
				+ "		inner join chc_fmb fmb on fmb.chc_fmb_id = chc.chc_fmb_id\r\n"
				+ "		inner join users usr on usr.user_id = fmb.user_id\r\n"
				+ "		inner join user_roles roles on usr.role_ref_id = roles.role_id\r\n"
				+ "		inner join districts dist on fmb.dist_ref_id = dist.district_id \r\n"
				+ "		inner join equipment_type_master eqt on eqt.id = chc.equipment_type_id\r\n"
				+ "		inner join equip_master eqp on eqp.id = chc.equipment_name_id \r\n"
				+ "		where UPPER(eqp.equpment_name) LIKE '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
				+ "		or UPPER(eqt.type) LIKE '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
		        + "		or UPPER(chc.company) LIKE '%"+searchRequestDto.getVal().toUpperCase()+"%'";
		
		return sql;
		
		
		
	}
	private String searchMachineryInInputSupplierTable(SearchRequestDto searchRequestDto)
	{
//		String sql ="select inpm.input_supplier_id as vendorid,\r\n"
//				+ "		ip.input_supplier_name as vendorname,\r\n"
//				+ "		inpm.file_path as imagepath,\r\n"
//				+ "		inpm.manufacturer_name as company,\r\n"
//				+ "		inpm.machinery_type_id as machinetypeid,\r\n"
//				+ "		eqt.type as machinetype,\r\n"
//				+ "		inpm.quantity as quantity,\r\n"
//				+ "		dist.district_id as districtid,\r\n"
//				+ "		dist.district_name as district,\r\n"
//				+ "		inpm.rent_per_day as rent,\r\n"
//				+ "		inpm.machinery_name_id as machinenameid,\r\n"
//				+ "		eqp.equpment_name as machinename,\r\n"
//				+ "		'inputsupplier'as recordtype,\r\n"
//				+ "		roles.role as role\r\n"
//				+ "		from input_supplier_machinery inpm \r\n"
//				+ "		inner join input_supplier ip on ip.input_supplier_id = inpm.input_supplier_id\r\n"
//				+ "		inner join users usr on usr.user_id = ip.user_id\r\n"
//				+ "		inner join user_roles roles on usr.role_ref_id = roles.role_id\r\n"
//				+ "		inner join districts dist on ip.dist_ref_id = dist.district_id \r\n"
//				+ "		inner join equipment_type_master eqt on eqt.id = inpm.machinery_type_id\r\n"
//				+ "		inner join equip_master eqp on eqp.id = inpm.machinery_name_id \r\n"
//				+ "		where UPPER(eqp.equpment_name) LIKE '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
//				+ "		or UPPER(eqt.type) LIKE '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
//	        	+ "		or UPPER(inpm.manufacturer_name) LIKE '%"+searchRequestDto.getVal().toUpperCase()+"%'";
		
		String sql ="select ism.id id,\r\n"
				+ "ism.file_path imagepath,\r\n"
				+ "ism.input_supplier_id as vendorid,\r\n"
				+ "ism.machinery_type_id machinetypeid,\r\n"
				+ "eqt.type machinetype,\r\n"
				+ "ism.machinery_name_id machinenameid,\r\n"
				+ "eqp.equpment_name as machinename,\r\n"
				+ "case when usr.role='ROLE_INPUTSUPPLIER' then ip.input_supplier_name\r\n"
				+ "else fp.fpo_name end as vendorname, \r\n"
				+ "case when usr.role='ROLE_INPUTSUPPLIER' then ip.email\r\n"
				+ "else fp.fpo_email end as vendoremail,\r\n"
				+ "case when usr.role='ROLE_INPUTSUPPLIER' then ip.user_id\r\n"
				+ "else fp.user_id end as userid, \r\n"
				+ "ism.manufacturer_name as company, \r\n"
				+ "ism.quantity quantity,\r\n"
				+ "ism.rent_per_day rent,\r\n"
				+ "'machinery'as recordtype,\r\n"
				+ "dist.district_id as districtid,\r\n"
				+ "dist.district_name as district,\r\n"
				+ "ism.role roleid,\r\n"
				+ "usr.role as role\r\n"
				+ "from input_supplier_machinery ism\r\n"
				+ "inner join user_roles usr on usr.role_id = ism.role\r\n"
				+ "left join input_supplier ip on ip.input_supplier_id = ism.input_supplier_id \r\n"
				+ "left join fpo fp on fp.fpo_id = ism.input_supplier_id\r\n"
				+ "inner join equipment_type_master eqt on eqt.id = ism.machinery_type_id\r\n"
				+ "inner join equip_master eqp on eqp.id = ism.machinery_name_id\r\n"
				+ "inner join districts dist on dist.district_id = case when usr.role='ROLE_INPUTSUPPLIER' then ip.dist_ref_id\r\n"
				+ "else fp.dist_ref_id end"
				+ "	where UPPER(eqp.equpment_name) LIKE '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
				+ "	or UPPER(eqt.type) LIKE '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
	        	+ "	or UPPER(ism.manufacturer_name) LIKE '%"+searchRequestDto.getVal().toUpperCase()+"%'";
				
				
				;
		
		return sql;
	}
	public ResponseEntity<?> newMachinerySearch(SearchRequestDto searchRequestDto)
	{
		//String sql =searchMachineryInFmbTable(searchRequestDto)+" union all "+searchMachineryInInputSupplierTable(searchRequestDto);
		
		String sql =searchMachineryInInputSupplierTable(searchRequestDto);
		
		
		  List<FmbSearchDtoAll> obj = entityManager.createNativeQuery(sql,"fmbValueResultMapping").getResultList();	
		  
			Predicate<FmbSearchDtoAll> fmbFinalpredicate=null;		
			if(searchRequestDto.getDistrictIds()!=null) {
				for(Integer districtId:searchRequestDto.getDistrictIds())
				{			
					Predicate<FmbSearchDtoAll> samplepredicate =  samplepredecate->samplepredecate.getDistrictid().intValue()==districtId.intValue();
				      if(fmbFinalpredicate==null)
				      {
				    	  fmbFinalpredicate = samplepredicate;
				      }else {
				    	  fmbFinalpredicate =fmbFinalpredicate.or(samplepredicate);
				      }
				}
				obj = fmbFinalpredicate==null?obj:obj.stream().filter(fmbFinalpredicate).collect(Collectors.toList());	
			}
			
			fmbFinalpredicate=null;		
			if(searchRequestDto.getBrands()!=null) {
				for(String machinebrand:searchRequestDto.getBrands())
				{			
					Predicate<FmbSearchDtoAll> samplepredicate =  samplepredecate->samplepredecate.getCompany().contentEquals(machinebrand);
				      if(fmbFinalpredicate==null)
				      {
				    	  fmbFinalpredicate = samplepredicate;
				      }else {
				    	  fmbFinalpredicate =fmbFinalpredicate.or(samplepredicate);
				      }
				}
				obj = fmbFinalpredicate==null?obj:obj.stream().filter(fmbFinalpredicate).collect(Collectors.toList());	
			}
			
			fmbFinalpredicate=null;		
			if(searchRequestDto.getMachineryTypes()!=null) {
				for(Integer machinetypeId:searchRequestDto.getMachineryTypes())
				{			
					Predicate<FmbSearchDtoAll> samplepredicate =  samplepredecate->samplepredecate.getMachinetypeid().intValue()==machinetypeId.intValue();
				      if(fmbFinalpredicate==null)
				      {
				    	  fmbFinalpredicate = samplepredicate;
				      }else {
				    	  fmbFinalpredicate =fmbFinalpredicate.or(samplepredicate);
				      }
				}
				obj = fmbFinalpredicate==null?obj:obj.stream().filter(fmbFinalpredicate).collect(Collectors.toList());	
			}
			
			
			if(searchRequestDto.getQtymin()!=null&&searchRequestDto.getQtymax()!=null) 
			{
				Predicate<FmbSearchDtoAll> samplepredicate =  samplepredecate->samplepredecate.getRent().doubleValue()>searchRequestDto.getRentMin().doubleValue() && samplepredecate.getRent().doubleValue()<=searchRequestDto.getRentMax().doubleValue();
				fmbFinalpredicate=samplepredicate; 
				obj =obj.stream().filter(fmbFinalpredicate).collect(Collectors.toList());
			}
			
			//obj = obj.stream().filter(fmbFinalpredicate).collect(Collectors.toList());
			
			
		  
		  FmbSearchPagePagableDto fmbSearchPagePagableDto = new FmbSearchPagePagableDto();
		  Integer offset  =(searchRequestDto.getPage().intValue()-1)*searchRequestDto.getLimit().intValue();
		  Integer last =offset.intValue()+searchRequestDto.getLimit().intValue(); 
		  fmbSearchPagePagableDto.setTotalElements(obj.size());
		  fmbSearchPagePagableDto.setPage(obj.subList(offset>obj.size()?0:offset, last>obj.size()?obj.size():last));
		  
		  return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(fmbSearchPagePagableDto);	
	}
	
	public ResponseEntity<?> newFertilizersSearch(SearchRequestDto searchRequestDto)
	{
		
		String sql = searchOnlyFertilizersInInputSupplierFertilizer(searchRequestDto);
	
	 // List<InputSupplierSearchDtoAll> obj =  entityManager.createNativeQuery(sql,"inputSupplierResultMapping").getResultList();
	  
	  List<InputSupplierFertilizerSearchDto> obj =  entityManager.createNativeQuery(sql,"fertilizerResultMapping").getResultList();
	  
	  Integer offset  =(searchRequestDto.getPage().intValue()-1)*searchRequestDto.getLimit().intValue();
	  Integer last =offset.intValue()+searchRequestDto.getLimit().intValue(); 
	  
	  Predicate<InputSupplierFertilizerSearchDto> inputSupplierFinalPredecate=null;
		if(searchRequestDto.getDistrictIds()!=null) {
			for(Integer districtId:searchRequestDto.getDistrictIds())
			{
				
				Predicate<InputSupplierFertilizerSearchDto> samplepredicate =  samplepredecate->samplepredecate.getDistrictid().intValue()==districtId.intValue();
			      if(inputSupplierFinalPredecate==null)
			      {
			    	  inputSupplierFinalPredecate = samplepredicate;
			      }else {
			    	  inputSupplierFinalPredecate = inputSupplierFinalPredecate.or(samplepredicate);
			      }
			}
			obj = inputSupplierFinalPredecate==null?obj:obj.stream().filter(inputSupplierFinalPredecate).collect(Collectors.toList());
		} 
		//obj = obj.stream().filter(inputSupplierFinalPredecate).collect(Collectors.toList());
		inputSupplierFinalPredecate=null;
		
		if(searchRequestDto.getInputSupplierIds()!=null) {
			for(Integer inputsupplierId:searchRequestDto.getInputSupplierIds())
			{
				
				Predicate<InputSupplierFertilizerSearchDto> samplepredicate =  samplepredecate->samplepredecate.getVendorid().intValue()==inputsupplierId.intValue();
			      if(inputSupplierFinalPredecate==null)
			      {
			    	  inputSupplierFinalPredecate = samplepredicate;
			      }else {
			    	  inputSupplierFinalPredecate = inputSupplierFinalPredecate.or(samplepredicate);
			      }
			}
			obj = inputSupplierFinalPredecate==null?obj:obj.stream().filter(inputSupplierFinalPredecate).collect(Collectors.toList());
		}
		inputSupplierFinalPredecate=null;
		
		if(searchRequestDto.getFertilizerTypeIds()!=null) {
			for(Integer fertTypeId:searchRequestDto.getFertilizerTypeIds())
			{
				
				Predicate<InputSupplierFertilizerSearchDto> samplepredicate =  samplepredecate->samplepredecate.getItemtypeid().intValue()==fertTypeId.intValue();
			      if(inputSupplierFinalPredecate==null)
			      {
			    	  inputSupplierFinalPredecate = samplepredicate;
			      }else {
			    	  inputSupplierFinalPredecate = inputSupplierFinalPredecate.or(samplepredicate);
			      }
			}
			obj = inputSupplierFinalPredecate==null?obj:obj.stream().filter(inputSupplierFinalPredecate).collect(Collectors.toList());
		}
		
		
		InputSupplierFertilizersPagePagableDto inputSupplierPagePagableDto = new InputSupplierFertilizersPagePagableDto();
	  inputSupplierPagePagableDto.setTotalElements(obj.size());
	  //inputSupplierPagePagableDto.setPage(obj);
	  inputSupplierPagePagableDto.setPage(obj.subList(offset>obj.size()?0:offset, last>obj.size()?obj.size():last));
	  return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(inputSupplierPagePagableDto);
	}
	
	public ResponseEntity<?> newInsecticidesSearch(SearchRequestDto searchRequestDto)
	{
		String sql =  searchInsecticidesInInputSupplierInsecticides(searchRequestDto); 
	             
		//return new ResponseEntity(entityManager.createNativeQuery(sql).getResultList(), HttpStatus.OK);
	  List<InputSupplierSearchDtoAll> obj =  entityManager.createNativeQuery(sql,"inputSupplierResultMapping").getResultList();	
	  Integer offset  =(searchRequestDto.getPage().intValue()-1)*searchRequestDto.getLimit().intValue();
	  Integer last =offset.intValue()+searchRequestDto.getLimit().intValue(); 
	  
	  Predicate<InputSupplierSearchDtoAll> inputSupplierFinalPredecate=null;
	  Predicate<InputSupplierSearchDtoAll> rolepredicate = null;
		if(searchRequestDto.getDistrictIds()!=null) {
			for(Integer districtId:searchRequestDto.getDistrictIds())
			{
				
				Predicate<InputSupplierSearchDtoAll> samplepredicate =  samplepredecate->samplepredecate.getDistrictid().intValue()==districtId.intValue();
			      if(inputSupplierFinalPredecate==null)
			      {
			    	  inputSupplierFinalPredecate = samplepredicate;
			      }else {
			    	  inputSupplierFinalPredecate = inputSupplierFinalPredecate.or(samplepredicate);
			      }
			}
			obj = inputSupplierFinalPredecate==null?obj:obj.stream().filter(inputSupplierFinalPredecate).collect(Collectors.toList());
		} 
		
		inputSupplierFinalPredecate=null;
		rolepredicate = null;
		if(searchRequestDto.getInputSupplierIds()!=null) 
		{
			String role = "ROLE_INPUTSUPPLIER";
			for(Integer inputsupplierId:searchRequestDto.getInputSupplierIds())
			{
				
				Predicate<InputSupplierSearchDtoAll> samplepredicate =  samplepredecate->samplepredecate.getVendorid().intValue()==inputsupplierId.intValue();
				rolepredicate	= rolepredecate->rolepredecate.getRole().equals(role);
			      if(inputSupplierFinalPredecate==null)
			      {
			    	  inputSupplierFinalPredecate = samplepredicate;
			      }else {
			    	  inputSupplierFinalPredecate = inputSupplierFinalPredecate.or(samplepredicate);
			      }
			}
			obj = inputSupplierFinalPredecate==null?obj:obj.stream().filter(inputSupplierFinalPredecate.and(rolepredicate)).collect(Collectors.toList());
		} 	
		
		inputSupplierFinalPredecate = null;
		rolepredicate = null;
		if(searchRequestDto.getFpoIds()!=null)
		{
			String role = "ROLE_FPC";
			for(Integer fpoId:searchRequestDto.getFpoIds())
			{
			
				Predicate<InputSupplierSearchDtoAll> samplepredicate =  samplepredecate->samplepredecate.getVendorid().intValue()==fpoId.intValue();
				rolepredicate	= rolepredecate->rolepredecate.getRole().equals(role);
			      if(inputSupplierFinalPredecate==null)
			      {
			    	  inputSupplierFinalPredecate = samplepredicate;
			      }else {
			    	  inputSupplierFinalPredecate = inputSupplierFinalPredecate.or(samplepredicate);
			      }
			}
			obj = inputSupplierFinalPredecate==null?obj:obj.stream().filter(inputSupplierFinalPredecate.and(rolepredicate)).collect(Collectors.toList()); 
		}
		
		//obj = obj.stream().filter(inputSupplierFinalPredecate).collect(Collectors.toList());
	  InputSupplierPagePagableDto inputSupplierPagePagableDto = new InputSupplierPagePagableDto();
	  inputSupplierPagePagableDto.setTotalElements(obj.size());
	  //inputSupplierPagePagableDto.setPage(obj);
	  inputSupplierPagePagableDto.setPage(obj.subList(offset>obj.size()?0:offset, last>obj.size()?obj.size():last));
	  return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(inputSupplierPagePagableDto);
	}
	public ResponseEntity<?> newSeedsSearch(SearchRequestDto searchRequestDto)
	{
		String sql = searchSeedsInInputSupplierSeeds(searchRequestDto);
	
	  List<InputSupplierSearchDtoAll> obj =  entityManager.createNativeQuery(sql,"inputSupplierResultMapping").getResultList();	
	  Integer offset  =(searchRequestDto.getPage().intValue()-1)*searchRequestDto.getLimit().intValue();
	  Integer last =offset.intValue()+searchRequestDto.getLimit().intValue(); 
	  
	  Predicate<InputSupplierSearchDtoAll> inputSupplierFinalPredecate=null;
		if(searchRequestDto.getDistrictIds()!=null) {
			for(Integer districtId:searchRequestDto.getDistrictIds())
			{
				
				Predicate<InputSupplierSearchDtoAll> samplepredicate =  samplepredecate->samplepredecate.getDistrictid().intValue()==districtId.intValue();
			      if(inputSupplierFinalPredecate==null)
			      {
			    	  inputSupplierFinalPredecate = samplepredicate;
			      }else {
			    	  inputSupplierFinalPredecate = inputSupplierFinalPredecate.or(samplepredicate);
			      }
			}
			obj = inputSupplierFinalPredecate==null?obj:obj.stream().filter(inputSupplierFinalPredecate).collect(Collectors.toList());
		} 
		
		inputSupplierFinalPredecate=null;
		if(searchRequestDto.getInputSupplierIds()!=null) {
			for(Integer inputsupplierId:searchRequestDto.getInputSupplierIds())
			{
				
				Predicate<InputSupplierSearchDtoAll> samplepredicate =  samplepredecate->samplepredecate.getVendorid().intValue()==inputsupplierId.intValue();
			      if(inputSupplierFinalPredecate==null)
			      {
			    	  inputSupplierFinalPredecate = samplepredicate;
			      }else {
			    	  inputSupplierFinalPredecate = inputSupplierFinalPredecate.or(samplepredicate);
			      }
			}
			obj = inputSupplierFinalPredecate==null?obj:obj.stream().filter(inputSupplierFinalPredecate).collect(Collectors.toList());
		} 
		
		inputSupplierFinalPredecate=null;
		if(searchRequestDto.getCropverietyIds()!=null) {
			for(Integer cropVerietyId:searchRequestDto.getCropverietyIds())
			{
				Predicate<InputSupplierSearchDtoAll> samplepredicate =  samplepredecate->samplepredecate.getCropverietyid().intValue()==cropVerietyId.intValue();
			      if(inputSupplierFinalPredecate==null)
			      {
			    	  inputSupplierFinalPredecate = samplepredicate;
			      }else {
			    	  inputSupplierFinalPredecate =inputSupplierFinalPredecate.or(samplepredicate);
			      }
			}
		
		}
		obj = inputSupplierFinalPredecate==null?obj:obj.stream().filter(inputSupplierFinalPredecate).collect(Collectors.toList());
		
		
		//obj = obj.stream().filter(inputSupplierFinalPredecate).collect(Collectors.toList());
	  InputSupplierPagePagableDto inputSupplierPagePagableDto = new InputSupplierPagePagableDto();
	  inputSupplierPagePagableDto.setTotalElements(obj.size());
	  //inputSupplierPagePagableDto.setPage(obj);
	  inputSupplierPagePagableDto.setPage(obj.subList(offset>obj.size()?0:offset, last>obj.size()?obj.size():last));
	  return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(inputSupplierPagePagableDto);
	}
	
	public ResponseEntity<?> newFpoServicesSearch(SearchRequestDto searchRequestDto)
	{
		
		String sql = this.searchServicesInFpos(searchRequestDto);
	
	 // List<InputSupplierSearchDtoAll> obj =  entityManager.createNativeQuery(sql,"inputSupplierResultMapping").getResultList();
	  
	  List<FpoServiceSearchDto> obj =  entityManager.createNativeQuery(sql,"fpoServicesResultMapping").getResultList();
	  
	  Integer offset  =(searchRequestDto.getPage().intValue()-1)*searchRequestDto.getLimit().intValue();
	  Integer last =offset.intValue()+searchRequestDto.getLimit().intValue(); 
	  
	  Predicate<FpoServiceSearchDto> fpoFinalPredecate=null;
		if(searchRequestDto.getDistrictIds()!=null) {
			for(Integer districtId:searchRequestDto.getDistrictIds())
			{
				
				Predicate<FpoServiceSearchDto> samplepredicate =  samplepredecate->samplepredecate.getDistrictid().intValue()==districtId.intValue();
			      if(fpoFinalPredecate==null)
			      {
			    	  fpoFinalPredecate = samplepredicate;
			      }else {
			    	  fpoFinalPredecate = fpoFinalPredecate.or(samplepredicate);
			      }
			}
			obj = fpoFinalPredecate==null?obj:obj.stream().filter(fpoFinalPredecate).collect(Collectors.toList());
		} 
		//obj = obj.stream().filter(inputSupplierFinalPredecate).collect(Collectors.toList());
		fpoFinalPredecate=null;
		
		if(searchRequestDto.getFpoIds()!=null) {
			for(Integer fpoId:searchRequestDto.getFpoIds())
			{
				
				Predicate<FpoServiceSearchDto> samplepredicate =  samplepredecate->samplepredecate.getVendorid().intValue()==fpoId.intValue();
			      if(fpoFinalPredecate==null)
			      {
			    	  fpoFinalPredecate = samplepredicate;
			      }else {
			    	  fpoFinalPredecate = fpoFinalPredecate.or(samplepredicate);
			      }
			}
			obj = fpoFinalPredecate==null?obj:obj.stream().filter(fpoFinalPredecate).collect(Collectors.toList());
		}
	
		
		
		FpoServicePagePagableDto inputSupplierPagePagableDto = new FpoServicePagePagableDto();
	  inputSupplierPagePagableDto.setTotalElements(obj.size());
	  //inputSupplierPagePagableDto.setPage(obj);
	  inputSupplierPagePagableDto.setPage(obj.subList(offset>obj.size()?0:offset, last>obj.size()?obj.size():last));
	  return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(inputSupplierPagePagableDto);
	}
	
	
}
