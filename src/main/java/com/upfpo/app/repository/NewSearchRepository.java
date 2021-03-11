package com.upfpo.app.repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.upfpo.app.dto.CropAndVerietyList;
import com.upfpo.app.dto.CropFilterDto;
import com.upfpo.app.dto.CropVerietyFilterDto;
import com.upfpo.app.dto.FPODetailsDTO;
import com.upfpo.app.dto.FilterDto;
import com.upfpo.app.dto.FmbSearchPagePagableDto;
import com.upfpo.app.dto.InputSupplierPagePagableDto;
import com.upfpo.app.dto.ReportDTO;
import com.upfpo.app.dto.CropSearchPagePagableDto;
import com.upfpo.app.dto.SearchRequestDto;
import com.upfpo.app.dto.SearchResponseDto;
import com.upfpo.app.dto.search.FmbSearchDtoAll;
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
	Predicate<FPODetailsDTO> finalpredicate=null;

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
				+ "dist.district_name as district  \r\n"
				+ "from total_production tp\r\n"
				+ "inner join fpo f on tp.fpo_id = f.fpo_id\r\n"
				+ "inner join districts dist on f.dist_ref_id = dist.district_id\r\n"
				+ "inner join crop_veriety_master cv on cv.veriety_id = tp.veriety_id\r\n"
				+ "inner join crop_master cm on cv.crop_master_ref_id = cm.id\r\n"
				+ "where UPPER(cm.crop_name) like'%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
				+ "or UPPER(cv.crop_veriety) like'%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
				+ "group by cv.crop_master_ref_id,tp.veriety_id,tp.fpo_id,f.fpo_name,dist.district_id,dist.district_name,cv.crop_veriety,\r\n"
				+ "cm.crop_name;";
		
		  List<SearchResponseDto> obj = (List<SearchResponseDto>) entityManager.createNativeQuery(sql,"SearchResponseDTO").getResultList();	
		  CropSearchPagePagableDto cropSearchPagePagableDto = new CropSearchPagePagableDto();
		  cropSearchPagePagableDto.setPage(obj);
		  cropSearchPagePagableDto.setTotalElements(obj.size());
 	return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(cropSearchPagePagableDto);	
	}
	// 
	public ResponseEntity<?> newInputSupplierSearch(SearchRequestDto searchRequestDto)
	{
		String sql ="";
		
		  List<InputSupplierSearchDtoAll> obj =  entityManager.createNativeQuery(sql,"inputSupplierResultMapping").getResultList();	
		   
		  InputSupplierPagePagableDto inputSupplierPagePagableDto = new InputSupplierPagePagableDto();
		  inputSupplierPagePagableDto.setPage(obj);
		  inputSupplierPagePagableDto.setTotalElements(obj.size());
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
				+ "		'chcfmb'as recordtype\r\n"
				+ "		from chc_fmb_machinery chc\r\n"
				+ "		inner join chc_fmb fmb on fmb.chc_fmb_id = chc.chc_fmb_id\r\n"
				+ "		inner join districts dist on fmb.dist_ref_id = dist.district_id \r\n"
				+ "		inner join equipment_type_master eqt on eqt.id = chc.equipment_type_id\r\n"
				+ "		inner join equip_master eqp on eqp.id = chc.equipment_name_id \r\n"
				+ "		where UPPER(eqp.equpment_name) LIKE '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
				+ "		or UPPER(eqt.type) LIKE '%"+searchRequestDto.getVal().toUpperCase()+"%'";
		return sql;
		
		
		
	}
	private String searchMachineryInInputSupplierTable(SearchRequestDto searchRequestDto)
	{
		String sql ="select inpm.input_supplier_id as vendorid,\r\n"
				+ "		ip.input_supplier_name as vendorname,\r\n"
				+ "		inpm.file_path as imagepath,\r\n"
				+ "		inpm.manufacturer_name as company,\r\n"
				+ "		inpm.machinery_type_id as machinetypeid,\r\n"
				+ "		eqt.type as machinetype,\r\n"
				+ "		inpm.quantity as quantity,\r\n"
				+ "		dist.district_id as districtid,\r\n"
				+ "		dist.district_name as district,\r\n"
				+ "		inpm.rent_per_day as rent,\r\n"
				+ "		inpm.machinery_name_id as machinenameid,\r\n"
				+ "		eqp.equpment_name as machinename,\r\n"
				+ "		'inputsupplier'as recordtype\r\n"
				+ "		from input_supplier_machinery inpm \r\n"
				+ "		inner join input_supplier ip on ip.input_supplier_id = inpm.input_supplier_id\r\n"
				+ "		inner join districts dist on ip.dist_ref_id = dist.district_id \r\n"
				+ "		inner join equipment_type_master eqt on eqt.id = inpm.machinery_type_id\r\n"
				+ "		inner join equip_master eqp on eqp.id = inpm.machinery_name_id \r\n"
				+ "		where UPPER(eqp.equpment_name) LIKE '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
				+ "		or UPPER(eqt.type) LIKE '%"+searchRequestDto.getVal().toUpperCase()+"%'";
		return sql;
	}
	public ResponseEntity<?> newMachinerySearch(SearchRequestDto searchRequestDto)
	{
		String sql =searchMachineryInFmbTable(searchRequestDto)+" union all "+searchMachineryInInputSupplierTable(searchRequestDto);
		
		  List<FmbSearchDtoAll> obj = entityManager.createNativeQuery(sql,"fmbValueResultMapping").getResultList();	
		  FmbSearchPagePagableDto fmbSearchPagePagableDto = new FmbSearchPagePagableDto();
		  fmbSearchPagePagableDto.setPage(obj);
		  fmbSearchPagePagableDto.setTotalElements(obj.size());
		
		
		  
		  return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(fmbSearchPagePagableDto);	
	}
	
	
}
