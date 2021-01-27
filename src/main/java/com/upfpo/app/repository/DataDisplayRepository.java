package com.upfpo.app.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.upfpo.app.dto.DisplayDataDTO;
import com.upfpo.app.dto.FPODetailsDTO;
import com.upfpo.app.dto.ProductionDTO;

@Repository
@Qualifier("dataDisplayRepository")
public class DataDisplayRepository {
	
	@Autowired
	private  EntityManager entityManager;
	
	private  String sql = "";
	
	public DisplayDataDTO farmersData()
	{
		  sql = "select sum(total_farmers) as totalfarmers,sum(total_small_farmers) as smalltotal,\r\n" + 
		  		"sum(total_big_farmers) as bigfarmers,sum(total_marginal_farmers)as marginalfarmers,\r\n" + 
		  		"sum (total_land) as totalland\r\n" + 
		  		"from fpo";
		  
		   DisplayDataDTO obj =  (DisplayDataDTO) entityManager.createNativeQuery(sql,"DisplayDataDTO").getSingleResult();
		   
		    
		    return obj;
	}
	
	
	public ProductionDTO productions(String finYear)
	{
		  sql = "SELECT sum(actual_production) as totalprod,\r\n" + 
		  		"\r\n" + 
		  		"	SUM (CASE\r\n" + 
		  		"               WHEN  season_ref='1' THEN actual_production\r\n" + 
		  		"	       ELSE 0\r\n" + 
		  		"	      END\r\n" + 
		  		"	) AS \"rabiprod\",\r\n" + 
		  		"	\r\n" + 
		  		"	SUM (CASE\r\n" + 
		  		"               WHEN  season_ref='2' THEN actual_production\r\n" + 
		  		"	       ELSE 0\r\n" + 
		  		"	      END\r\n" + 
		  		"	) AS \"kharifprod\",\r\n" + 
		  		"	SUM (CASE\r\n" + 
		  		"               WHEN  season_ref='3' THEN actual_production\r\n" + 
		  		"	       ELSE 0\r\n" + 
		  		"	      END\r\n" + 
		  		"	) AS \"zayadprod\"\r\n" + 
		  		"	\r\n" + 
		  		"	from  production_details where financial_year =:finYear";
		  
		  ProductionDTO obj =  (ProductionDTO) entityManager.createNativeQuery(sql,"ProductionDTO").setParameter("finYear", finYear).getSingleResult();
		    
		  return obj;
	}
	
	
	public List<FPODetailsDTO> homeSearch(String searchVal, String searchIn)
	{
		if(searchIn.equalsIgnoreCase("any"))
		{
//			sql = "Select id, unitassla,state, district,nodal,mobile, email,fpo_lot_no, associationdate, crops, services from\r\n" + 
//					"(select distinct fpo.fpo_id id,fpo.agency_associated unitassla,states.state_name state,\r\n" + 
//					"districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n" + 
//					"fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10)as varchar) associationdate, cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops,\r\n" + 
//					"CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' ',cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services\r\n" + 
//					"from fpo inner join states on states.state_id = fpo.state_ref\r\n" + 
//					"inner join districts on district_id =  fpo.dist_ref_id\r\n" + 
//					"left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n" + 
//					"left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n" + 
//					"left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n" + 
//					"left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id \r\n" + 
//					"group by fpo.fpo_id,fpo.agency_associated,states.state_name ,districts.district_name ,fpo.fpo_name ,\r\n" + 
//					"fpo.fpo_landline ,fpo.fpo_email,\r\n" + 
//					"fpo_lot_no , \r\n" + 
//					"substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10) )  as Q \r\n" + 
//					"where \r\n" + 
//					"UPPER(district) like '%"+searchVal.toUpperCase()+"%' \r\n" + 
//					"or UPPER(nodal) like '%"+searchVal.toUpperCase()+"%' \r\n" + 
//					"or UPPER(crops) like '%"+searchVal.toUpperCase()+"%' \r\n" + 
//					"or UPPER(services) like '%"+searchVal.toUpperCase()+"%'";
			
			
			sql = "Select id, unitassla,state, district,nodal,mobile, email,fpo_lot_no, associationdate, crops, services,cropVeriety,marketableSurplus, actualProduction from\r\n"
					+ "(select distinct fpo.fpo_id id,fpo.agency_associated unitassla,states.state_name state,\r\n"
					+ "districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n"
					+ "fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10)as varchar) associationdate, cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops,\r\n"
					+ "CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' ',cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services, cv.crop_veriety as cropVeriety, pd.marketable_quantity\r\n"
					+ "as marketableSurplus, apro.actual_production as actualProduction\r\n"
					+ "from fpo inner join states on states.state_id = fpo.state_ref\r\n"
					+ "inner join districts on district_id = fpo.dist_ref_id\r\n"
					+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
					+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
					+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
					+ "left join production_details apro on apro.crop_id = cm.id\r\n"
					+ "left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n"
					+ "left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id\r\n"
					+ "group by fpo.fpo_id,fpo.agency_associated,states.state_name ,districts.district_name ,fpo.fpo_name, cv.crop_veriety, pd.marketable_quantity,\r\n"
					+ "apro.actual_production,\r\n"
					+ "fpo.fpo_landline ,fpo.fpo_email,\r\n"
					+ "fpo_lot_no ,\r\n"
					+ "substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10) ) as Q\r\n"
					+ "where\r\n"
					+ "UPPER(district) like '%"+searchVal.toUpperCase()+"%'\r\n"
					+ "or UPPER(crops) like '%"+searchVal.toUpperCase()+"%'\r\n"
					+ "or UPPER(services) like '%"+searchVal.toUpperCase()+"%'\r\n"
					+ "or UPPER(nodal) like '%"+searchVal.toUpperCase()+"%'";
		
		
		
		}
		else if (searchIn.equalsIgnoreCase("fpo_name")) 
		{
//			sql = "Select id, unitassla,state, district,nodal,mobile, email,fpo_lot_no, associationdate, crops, services from\r\n" + 
//					"(select distinct fpo.fpo_id id,fpo.agency_associated  unitassla,states.state_name state,districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n" + 
//					"fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10)as varchar) associationdate, cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops, \r\n" + 
//					"CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' ',cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services\r\n" + 
//					"from fpo \r\n" + 
//					"inner join states on states.state_id = fpo.state_ref\r\n" + 
//					"inner join districts on district_id =  fpo.dist_ref_id\r\n" + 
//					"left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n" + 
//					"left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n" + 
//					"left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n" + 
//					"left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id\r\n" + 
//					"group by fpo.fpo_id,fpo.agency_associated,states.state_name ,districts.district_name ,fpo.fpo_name ,\r\n" + 
//					" fpo.fpo_landline , fpo.fpo_email ,\r\n" + 
//					"fpo_lot_no , substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10))  as Q\r\n" + 
//					"where UPPER(nodal) like '%"+searchVal.toUpperCase()+"%'\r\n" + 
//					"";
			
			sql = "Select id, unitassla,state, district,nodal,mobile, email,fpo_lot_no, associationdate, crops, services,cropVeriety,marketableSurplus, actualProduction from\r\n"
					+ "(select distinct fpo.fpo_id id,fpo.agency_associated unitassla,states.state_name state,\r\n"
					+ "districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n"
					+ "fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10)as varchar) associationdate, cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops,\r\n"
					+ "CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' ',cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services, cv.crop_veriety as cropVeriety, pd.marketable_quantity\r\n"
					+ "as marketableSurplus, apro.actual_production as actualProduction\r\n"
					+ "from fpo inner join states on states.state_id = fpo.state_ref\r\n"
					+ "inner join districts on district_id = fpo.dist_ref_id\r\n"
					+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
					+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
					+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
					+ "left join production_details apro on apro.crop_id = cm.id\r\n"
					+ "left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n"
					+ "left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id\r\n"
					+ "group by fpo.fpo_id,fpo.agency_associated,states.state_name ,districts.district_name ,fpo.fpo_name, cv.crop_veriety, pd.marketable_quantity,\r\n"
					+ "apro.actual_production,\r\n"
					+ "fpo.fpo_landline ,fpo.fpo_email,\r\n"
					+ "fpo_lot_no ,\r\n"
					+ "substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10) ) as Q\r\n"
					+ "where\r\n"
					+ "UPPER(nodal) like '%"+searchVal.toUpperCase()+"%'";
		}
		else if (searchIn.equalsIgnoreCase("district")) 
		{
//			sql = "Select id, unitassla,state, district,nodal,mobile, email,fpo_lot_no, associationdate, crops,services from\r\n" + 
//					"(select distinct fpo.fpo_id id,fpo.agency_associated  unitassla,states.state_name state,\r\n" + 
//					"districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n" + 
//					"fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10)as varchar) \r\n" + 
//					"associationdate, cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops, \r\n" + 
//					"CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' '\r\n" + 
//					",cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services\r\n" + 
//					"from fpo\r\n" + 
//					"inner join states on states.state_id = fpo.state_ref\r\n" + 
//					"inner join districts on district_id =  fpo.dist_ref_id\r\n" + 
//					"left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n" + 
//					"left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n" + 
//					"left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n" + 
//					"left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id\r\n" + 
//					"group by fpo.fpo_id,fpo.agency_associated,states.state_name ,districts.district_name ,\r\n" + 
//					"fpo.fpo_name ,fpo.fpo_landline ,fpo.fpo_email ,\r\n" + 
//					"fpo_lot_no , substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10) )  as Q\r\n" + 
//					"where UPPER(district) like '%"+searchVal.toUpperCase()+"%'\r\n" + 
//					"";
			
			sql = "Select id, unitassla,state, district,nodal,mobile, email,fpo_lot_no, associationdate, crops, services,cropVeriety,marketableSurplus, actualProduction from\r\n"
					+ "(select distinct fpo.fpo_id id,fpo.agency_associated unitassla,states.state_name state,\r\n"
					+ "districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n"
					+ "fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10)as varchar) associationdate, cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops,\r\n"
					+ "CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' ',cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services, cv.crop_veriety as cropVeriety, pd.marketable_quantity\r\n"
					+ "as marketableSurplus, apro.actual_production as actualProduction\r\n"
					+ "from fpo inner join states on states.state_id = fpo.state_ref\r\n"
					+ "inner join districts on district_id = fpo.dist_ref_id\r\n"
					+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
					+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
					+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
					+ "left join production_details apro on apro.crop_id = cm.id\r\n"
					+ "left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n"
					+ "left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id\r\n"
					+ "group by fpo.fpo_id,fpo.agency_associated,states.state_name ,districts.district_name ,fpo.fpo_name, cv.crop_veriety, pd.marketable_quantity,\r\n"
					+ "apro.actual_production,\r\n"
					+ "fpo.fpo_landline ,fpo.fpo_email,\r\n"
					+ "fpo_lot_no ,\r\n"
					+ "substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10) ) as Q\r\n"
					+ "where\r\n"
					+ "UPPER(district) like '%"+searchVal.toUpperCase()+"%'";
					
		}
			else if (searchIn.equalsIgnoreCase("crop")) 
			{
//				sql = "Select id, unitassla,state, district,nodal,mobile, email,fpo_lot_no, associationdate, crops,services from\r\n" + 
//						"(select distinct fpo.fpo_id id,fpo.agency_associated  unitassla,states.state_name state,\r\n" + 
//						"districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n" + 
//						"fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10)as varchar) associationdate, cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops, \r\n" + 
//						"CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' ',cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services\r\n" + 
//						"from fpo  \r\n" + 
//						"inner join states on states.state_id = fpo.state_ref\r\n" + 
//						"inner join districts on district_id =  fpo.dist_ref_id\r\n" + 
//						"left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n" + 
//						"left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n" + 
//						"left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n" + 
//						"left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id\r\n" + 
//						"group by fpo.fpo_id,fpo.agency_associated,states.state_name ,districts.district_name ,fpo.fpo_name,\r\n" + 
//						"fpo.fpo_landline ,fpo.fpo_email ,\r\n" + 
//						"fpo_lot_no , substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10) )  as Q\r\n" + 
//						"where  UPPER(crops) like '%"+searchVal.toUpperCase()+"%'\r\n" + 
//						"";
				
				
				sql = "Select id, unitassla,state, district,nodal,mobile, email,fpo_lot_no, associationdate, crops, services,cropVeriety,marketableSurplus, actualProduction from\r\n"
						+ "(select distinct fpo.fpo_id id,fpo.agency_associated unitassla,states.state_name state,\r\n"
						+ "districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n"
						+ "fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10)as varchar) associationdate, cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops,\r\n"
						+ "CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' ',cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services, cv.crop_veriety as cropVeriety, pd.marketable_quantity\r\n"
						+ "as marketableSurplus, apro.actual_production as actualProduction\r\n"
						+ "from fpo inner join states on states.state_id = fpo.state_ref\r\n"
						+ "inner join districts on district_id = fpo.dist_ref_id\r\n"
						+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
						+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
						+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
						+ "left join production_details apro on apro.crop_id = cm.id\r\n"
						+ "left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n"
						+ "left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id\r\n"
						+ "group by fpo.fpo_id,fpo.agency_associated,states.state_name ,districts.district_name ,fpo.fpo_name, cv.crop_veriety, pd.marketable_quantity,\r\n"
						+ "apro.actual_production,\r\n"
						+ "fpo.fpo_landline ,fpo.fpo_email,\r\n"
						+ "fpo_lot_no ,\r\n"
						+ "substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10) ) as Q\r\n"
						+ "where\r\n"
						+ "UPPER(crops) like '%"+searchVal.toUpperCase()+"%'";
			}
			
			else if (searchIn.equalsIgnoreCase("services")) 
			{
//				sql = "Select id, unitassla,state, district,nodal,mobile, email,fpo_lot_no, associationdate, crops,services from\r\n" + 
//						"(select distinct fpo.fpo_id id,fpo.agency_associated  unitassla,states.state_name state,\r\n" + 
//						"districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n" + 
//						"fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10)as varchar) associationdate, cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops,\r\n" + 
//						"CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' ',cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services\r\n" + 
//						"from fpo \r\n" + 
//						"inner join states on states.state_id = fpo.state_ref\r\n" + 
//						"inner join districts on district_id =  fpo.dist_ref_id\r\n" + 
//						"left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n" + 
//						"left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n" + 
//						"left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n" + 
//						"left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id\r\n" + 
//						"group by fpo.fpo_id,fpo.agency_associated,states.state_name ,districts.district_name ,fpo.fpo_name ,\r\n" + 
//						"fpo.fpo_landline ,fpo.fpo_email ,\r\n" + 
//						"fpo_lot_no , substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10) )  as Q\r\n" + 
//						"where  UPPER(services) like '%"+searchVal.toUpperCase()+"%'";
				
				sql = "Select id, unitassla,state, district,nodal,mobile, email,fpo_lot_no, associationdate, crops, services,cropVeriety,marketableSurplus, actualProduction from\r\n"
						+ "(select distinct fpo.fpo_id id,fpo.agency_associated unitassla,states.state_name state,\r\n"
						+ "districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n"
						+ "fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10)as varchar) associationdate, cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops,\r\n"
						+ "CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' ',cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services, cv.crop_veriety as cropVeriety, pd.marketable_quantity\r\n"
						+ "as marketableSurplus, apro.actual_production as actualProduction\r\n"
						+ "from fpo inner join states on states.state_id = fpo.state_ref\r\n"
						+ "inner join districts on district_id = fpo.dist_ref_id\r\n"
						+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
						+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
						+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
						+ "left join production_details apro on apro.crop_id = cm.id\r\n"
						+ "left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n"
						+ "left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id\r\n"
						+ "group by fpo.fpo_id,fpo.agency_associated,states.state_name ,districts.district_name ,fpo.fpo_name, cv.crop_veriety, pd.marketable_quantity,\r\n"
						+ "apro.actual_production,\r\n"
						+ "fpo.fpo_landline ,fpo.fpo_email,\r\n"
						+ "fpo_lot_no ,\r\n"
						+ "substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10) ) as Q\r\n"
						+ "where\r\n"
						+ "UPPER(services) like '%"+searchVal.toUpperCase()+"%'";
				
				
			   }
		  
		  List<FPODetailsDTO> obj =   entityManager.createNativeQuery(sql,"FPODetailsDTO").getResultList();
		  return obj;
	}
	
}
