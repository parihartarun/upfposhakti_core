package com.upfpo.app.repository;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.upfpo.app.dto.DataDisplayDto;
import com.upfpo.app.dto.DisplayDataDTO;
import com.upfpo.app.dto.FPODetailsDTO;
import com.upfpo.app.dto.ProductionDTO;
import com.upfpo.app.dto.ReportDTO;
import com.upfpo.app.dto.SearchPagePagableDto;
import com.upfpo.app.dto.SearchRequestDto;
import com.upfpo.app.dto.SearchResponseDto;
import com.upfpo.app.util.GetFinYear;




@Repository
public class DataDisplayRepository {

	
	Session session = null;
	Query query = null;
	Transaction tx = null;
	Predicate<FPODetailsDTO> finalpredicate=null;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	

	
	
	@Autowired
	private  EntityManager entityManager;
	
	private  String sql = "";
	private List<ReportDTO> result = null;
	
	public DisplayDataDTO farmersData()
	{
		  sql = "select sum(total_farmers) as totalfarmers,sum(total_small_farmers) as smalltotal,\r\n" + 
		  		"sum(total_big_farmers) as bigfarmers,sum(total_marginal_farmers)as marginalfarmers,\r\n" + 
		  		"sum (total_land) as totalland\r\n" + 
		  		"from fpo";
		  
		   DisplayDataDTO obj =  (DisplayDataDTO) entityManager.createNativeQuery(sql,"DisplayDataDTO").getSingleResult();
		   
		    
		    return obj;
	}
	
	
	private  org.hibernate.Session getCurrentSession(){

	    return entityManagerFactory.unwrap(SessionFactory.class).openSession();
	}	
	
		
	

	
	@Transactional
	public Integer numberCrops(Integer fpoId) {
		Integer numberCrops = 0;

		try {
			
			session = getCurrentSession();
			sql = "Select cast(count(distinct crop_ref_name)as Integer) FROM marketable_surplus where master_id=:fpoId ";
			query = session.createSQLQuery(sql).setParameter("fpoId", fpoId);
			numberCrops = ((Integer) query.uniqueResult()).intValue();
			if (numberCrops == null) {
				numberCrops = 0;
			}
			return numberCrops;
		} catch (Exception e) {
			e.printStackTrace();return numberCrops;
		} /*
			 * finally { session.close(); }
			 */
		
	}
	
	
	
	@Transactional
	public Integer totalFarmerCount(Integer fpoId) {
		Integer totalFarmerCount = 0;

		try {
			
			session = getCurrentSession();
			// sql = "Select sum(land.land_area) FROM Landmaster land";
			sql = "select cast(sum(coalesce(total_farmers,0))as Integer) from fpo where fpo_id=:fpoId";
			query = session.createSQLQuery(sql).setParameter("fpoId", fpoId);
			totalFarmerCount = (Integer) query.uniqueResult();
			if (totalFarmerCount == null) {
				totalFarmerCount = 0;
			}return totalFarmerCount;

		} catch (Exception e) {
			e.printStackTrace();return totalFarmerCount;
		} /*
			 * finally { session.close(); }
			 */
		
	}
	
	@Transactional
	public Double totalLand(Integer fpoId) {
		Double totalland = 0.0;
		try {
			
			session = this.getCurrentSession();
			//sql = "Select sum(land.land_area) FROM Landmaster land where masterId=:fpoId ";
			sql ="select sum(coalesce(total_land,0)) from fpo where fpo_id=:fpoId ";
			query = session.createSQLQuery(sql).setParameter("fpoId", fpoId);
			totalland = (Double) query.uniqueResult();
			if (totalland == null) {
				totalland = 0.0;
			}return totalland;

		} catch (Exception e) {
			e.printStackTrace();return totalland;
		} /*
			 * finally { session.close(); }
			 */
		
	}
	

	
	@Transactional
	public Integer totalOtherFarmerCount(Integer fpoId)
	{
		Integer totalFarmerCount = 0;

		try {
			
			session = getCurrentSession();
			// sql = "Select sum(land.land_area) FROM Landmaster land";
			sql = "select cast(sum(coalesce(total_big_farmers,0))as Integer) from fpo where fpo_id=:fpoId";
			query = session.createSQLQuery(sql).setParameter("fpoId", fpoId);
			totalFarmerCount = (Integer) query.uniqueResult();
			if (totalFarmerCount == null) {
				totalFarmerCount = 0;
			}return totalFarmerCount;

		} catch (Exception e) {
			e.printStackTrace();return totalFarmerCount;
		} /*
			 * finally { session.close(); }
			 */
		

	}
	

	@Transactional
	public Integer totalMarginalFarmerCount(Integer fpoId)
	{Integer totalFarmerCount = 0;

	try {
		
		session = getCurrentSession();
		// sql = "Select sum(land.land_area) FROM Landmaster land";
		sql = "select cast(sum(coalesce(total_marginal_farmers,0))as Integer) from fpo where fpo_id=:fpoId";
		query = session.createSQLQuery(sql).setParameter("fpoId", fpoId);
		totalFarmerCount = (Integer) query.uniqueResult();
		if (totalFarmerCount == null) {
			totalFarmerCount = 0;
		}return totalFarmerCount;

	} catch (Exception e) {
		e.printStackTrace();return totalFarmerCount;
	} /*
		 * finally { session.close(); }
		 */
	

		
	}
	
	@Transactional
	public Integer totalSmallFarmerCount(Integer fpoId)
	{
		Integer totalFarmerCount = 0;

		try {
			
			session = getCurrentSession();
			// sql = "Select sum(land.land_area) FROM Landmaster land";
			sql = "select cast(sum(coalesce(total_small_farmers,0))as Integer) from fpo where fpo_id=:fpoId";
			query = session.createSQLQuery(sql).setParameter("fpoId", fpoId);
			totalFarmerCount = (Integer) query.uniqueResult();
			if (totalFarmerCount == null) {
				totalFarmerCount = 0;
			}return totalFarmerCount;

		} catch (Exception e) {
			e.printStackTrace();return totalFarmerCount;
		} /*
			 * finally { session.close(); }
			 */
		

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

			
			
			sql = "Select id, unitassla,state, cropid,district,nodal,mobile, email,fpo_lot_no, associationdate, crops, services,cropVeriety,marketableSurplus, actualProduction from\r\n"
					+ "(select distinct fpo.fpo_id id,fpo.agency_associated unitassla,states.state_name state,\r\n"
					+ "districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n"
					+ "fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10)as varchar) associationdate, cm.id as cropid, cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops,\r\n"
					+ "CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' ',cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services, cv.crop_veriety as cropVeriety, pd.marketable_quantity\r\n"
					+ "as marketableSurplus,apro.actual_production as actualProduction\r\n"
					+ "from fpo inner join states on states.state_id = fpo.state_ref\r\n"
					+ "inner join districts on district_id = fpo.dist_ref_id\r\n"
					+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
					+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
					+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
					+ "left join production_details apro on apro.crop_id = cm.id\r\n"
					+ "left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n"
					+ "left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id\r\n"
					+ "group by fpo.fpo_id,cm.id,fpo.agency_associated,states.state_name ,districts.district_name ,fpo.fpo_name, cv.crop_veriety, pd.marketable_quantity,\r\n"
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

			
			sql = "Select id, unitassla,state, cropid,district,nodal,mobile, email,fpo_lot_no, associationdate, crops, services,cropVeriety,marketableSurplus, actualProduction from\r\n"
					+ "(select distinct fpo.fpo_id id,fpo.agency_associated unitassla,states.state_name state,\r\n"
					+ "districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n"
					+ "fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10)as varchar) associationdate, cm.id as cropid,cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops,\r\n"
					+ "CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' ',cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services, cv.crop_veriety as cropVeriety, pd.marketable_quantity\r\n"
					+ "as marketableSurplus, cm.id as cropid,apro.actual_production as actualProduction\r\n"
					+ "from fpo inner join states on states.state_id = fpo.state_ref\r\n"
					+ "inner join districts on district_id = fpo.dist_ref_id\r\n"
					+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
					+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
					+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
					+ "left join production_details apro on apro.crop_id = cm.id\r\n"
					+ "left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n"
					+ "left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id\r\n"
					+ "group by fpo.fpo_id, cm.id,fpo.agency_associated,states.state_name ,districts.district_name ,fpo.fpo_name, cv.crop_veriety, pd.marketable_quantity,\r\n"
					+ "apro.actual_production,\r\n"
					+ "fpo.fpo_landline ,fpo.fpo_email,\r\n"
					+ "fpo_lot_no ,\r\n"
					+ "substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10) ) as Q\r\n"
					+ "where\r\n"
					+ "UPPER(nodal) like '%"+searchVal.toUpperCase()+"%'";
		}
		else if (searchIn.equalsIgnoreCase("district")) 
		{
	
			sql = "Select id, unitassla,state, cropid,district,nodal,mobile, email,fpo_lot_no, associationdate, crops, services,cropVeriety,marketableSurplus, actualProduction from\r\n"
					+ "(select distinct fpo.fpo_id id,fpo.agency_associated unitassla,states.state_name state,\r\n"
					+ "districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n"
					+ "fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10)as varchar) associationdate, cm.id cropid, cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops,\r\n"
					+ "CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' ',cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services, cv.crop_veriety as cropVeriety, pd.marketable_quantity\r\n"
					+ "as marketableSurplus,apro.actual_production as actualProduction\r\n"
					+ "from fpo inner join states on states.state_id = fpo.state_ref\r\n"
					+ "inner join districts on district_id = fpo.dist_ref_id\r\n"
					+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
					+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
					+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
					+ "left join production_details apro on apro.crop_id = cm.id\r\n"
					+ "left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n"
					+ "left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id\r\n"
					+ "group by fpo.fpo_id,cm.id,fpo.agency_associated,states.state_name,districts.district_name, cm.id, fpo.fpo_name, cv.crop_veriety, pd.marketable_quantity,\r\n"
					+ "apro.actual_production,\r\n"
					+ "fpo.fpo_landline ,fpo.fpo_email,\r\n"
					+ "fpo_lot_no ,\r\n"
					+ "substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10) ) as Q\r\n"
					+ "where\r\n"
					+ "UPPER(district) like '%"+searchVal.toUpperCase()+"%'";
					
		}
			else if (searchIn.equalsIgnoreCase("crop")) 
			{

				
				sql = "Select id, unitassla,state, district,cropid,nodal,mobile, email,fpo_lot_no, associationdate, crops, services,cropVeriety,marketableSurplus, actualProduction from\r\n"
						+ "(select distinct fpo.fpo_id id,fpo.agency_associated unitassla,states.state_name state,\r\n"
						+ "districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n"
						+ "fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10)as varchar) associationdate, cm.id as cropid, cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops,\r\n"
						+ "CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' ',cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services, cv.crop_veriety as cropVeriety, pd.marketable_quantity\r\n"
						+ "as marketableSurplus,apro.actual_production as actualProduction\r\n"
						+ "from fpo inner join states on states.state_id = fpo.state_ref\r\n"
						+ "inner join districts on district_id = fpo.dist_ref_id\r\n"
						+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
						+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
						+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
						+ "left join production_details apro on apro.crop_id = cm.id\r\n"
						+ "left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n"
						+ "left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id\r\n"
						+ "group by fpo.fpo_id,cm.id, fpo.agency_associated,states.state_name ,districts.district_name ,fpo.fpo_name, cv.crop_veriety, pd.marketable_quantity,\r\n"
						+ "apro.actual_production,\r\n"
						+ "fpo.fpo_landline ,fpo.fpo_email,\r\n"
						+ "fpo_lot_no ,\r\n"
						+ "substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10) ) as Q\r\n"
						+ "where\r\n"
						+ "UPPER(crops) like '%"+searchVal.toUpperCase()+"%'";
			}
			
			else if (searchIn.equalsIgnoreCase("services")) 
			{

				
				sql = "Select id, unitassla,state, district,cropid,nodal,mobile, email,fpo_lot_no, associationdate, crops, services,cropVeriety,marketableSurplus, actualProduction from\r\n"
						+ "(select distinct fpo.fpo_id id,fpo.agency_associated unitassla,states.state_name state,\r\n"
						+ "districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n"
						+ "fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10)as varchar) associationdate, cm.id cropid, cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops,\r\n"
						+ "CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' ',cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services, cv.crop_veriety as cropVeriety, pd.marketable_quantity\r\n"
						+ "as marketableSurplus,apro.actual_production as actualProduction\r\n"
						+ "from fpo inner join states on states.state_id = fpo.state_ref\r\n"
						+ "inner join districts on district_id = fpo.dist_ref_id\r\n"
						+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
						+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
						+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
						+ "left join production_details apro on apro.crop_id = cm.id\r\n"
						+ "left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n"
						+ "left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id\r\n"
						+ "group by fpo.fpo_id,cm.id, fpo.agency_associated,states.state_name ,districts.district_name ,fpo.fpo_name, cv.crop_veriety, pd.marketable_quantity,\r\n"
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

	
	@Transactional
	public List<DataDisplayDto> getFPOprodzayad(Integer fpoId, String finYear) {
		List<DataDisplayDto> list = null;
		try {
			/*
			 * String sql =
			 * "Select cm.crop_name, sum(ms.marketable_quantity) marketable_quantity from marketable_surplus ms\r\n"
			 * + "inner join crop_master cm on cm.id=ms.crop_ref_name\r\n" +
			 * "where master_id=:fpoId and season_ref='3' and financial_year=:finYear and marketable_quantity>=1 \r\n"
			 * + "group by cm.crop_name";
			 */
			/*
			 * String sql = " Select cm.crop_name, \r\n" +
			 * "coalesce(sum(sold_quantity),0) sold_quantity,\r\n" +
			 * " coalesce((coalesce(sum(ms.marketable_quantity),0) - coalesce((sum(sold_quantity)),0)),0)marketable_quantity  from marketable_surplus ms\r\n"
			 * + " inner join crop_master cm on cm.id=ms.crop_ref_name\r\n" +
			 * " left join fpo_saleinfo si on si.master_id=ms.master_id and ms.crop_ref_name=si.crop_ref_name and ms.financial_year=si.financial_year\r\n"
			 * + " and ms.season_ref=si.season_ref\r\n" +
			 * " where ms.master_id=:fpoId and ms.season_ref='3' and ms.financial_year=:finYear and marketable_quantity>=1\r\n"
			 * + " group by cm.crop_name";
			 */
			
			String sql = "select q.crop_name, coalesce(q1.sold_quantity,0)sold_quantity ,(coalesce(marketable_quantity,0)-coalesce(q1.sold_quantity,0))marketable_quantity from\r\n"
					+ "(Select cm.crop_name, \r\n"
					+ "coalesce(sum(ms.marketable_quantity),0) marketable_quantity  from marketable_surplus ms\r\n"
					+ "inner join crop_master cm on cm.id=ms.crop_ref_name\r\n"
					+ "where ms.master_id=:fpoId and ms.season_ref='3' and ms.financial_year=:finYear and marketable_quantity>=1\r\n"
					+ "group by cm.crop_name) q\r\n"
					+ "left join \r\n"
					+ "(\r\n"
					+ "Select cm.crop_name, coalesce(sum(sold_quantity),0) sold_quantity\r\n"
					+ "  from fpo_saleinfo si\r\n"
					+ "inner join crop_master cm on cm.id=si.crop_ref_name\r\n"
					+ "where si.master_id=:fpoId and si.season_ref='3' and si.financial_year=:finYear and sold_quantity>=1\r\n"
					+ "group by cm.crop_name\r\n"
					+ ")q1 on q1.crop_name=q.crop_name";

			 //Session session = sessionFactory.getCurrentSession();
			Query query = session.createSQLQuery(sql).setParameter("fpoId", fpoId).setParameter("finYear", finYear)
					.setResultTransformer(Transformers.aliasToBean(DataDisplayDto.class));
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();

		} /*
			 * finally {
			 * 
			 * session.close(); }
			 */
		return list;
	}

	@Transactional
	public List<DataDisplayDto> getProdZayad(String finYear) {
		List<DataDisplayDto> list = null;
		try {
			/*
			 * String sql =
			 * "Select cm.crop_name, sum(ms.marketable_quantity) marketable_quantity from marketable_surplus ms\r\n"
			 * + "inner join crop_master cm on cm.id=ms.crop_ref_name\r\n" +
			 * "where master_id=:fpoId and season_ref='3' and financial_year=:finYear and marketable_quantity>=1 \r\n"
			 * + "group by cm.crop_name";
			 */
			/*
			 * String sql = " Select cm.crop_name, \r\n" +
			 * "coalesce(sum(sold_quantity),0) sold_quantity,\r\n" +
			 * " coalesce((coalesce(sum(ms.marketable_quantity),0) - coalesce((sum(sold_quantity)),0)),0)marketable_quantity  from marketable_surplus ms\r\n"
			 * + " inner join crop_master cm on cm.id=ms.crop_ref_name\r\n" +
			 * " left join fpo_saleinfo si on si.master_id=ms.master_id and ms.crop_ref_name=si.crop_ref_name and ms.financial_year=si.financial_year\r\n"
			 * + " and ms.season_ref=si.season_ref\r\n" +
			 * " where ms.season_ref='3' and ms.financial_year=:finYear and marketable_quantity>=1\r\n"
			 * + " group by cm.crop_name";
			 */
					
			String sql = "select q.crop_name, coalesce(q1.sold_quantity,0)sold_quantity ,(coalesce(marketable_quantity,0)-coalesce(q1.sold_quantity,0))marketable_quantity from\r\n"
					+ "(Select cm.crop_name, \r\n"
					+ "coalesce(sum(ms.marketable_quantity),0) marketable_quantity  from marketable_surplus ms\r\n"
					+ "inner join crop_master cm on cm.id=ms.crop_ref_name\r\n"
					+ "where ms.season_ref='3' and ms.financial_year=:finYear and marketable_quantity>=1\r\n"
					+ "group by cm.crop_name) q\r\n"
					+ "left join \r\n"
					+ "(\r\n"
					+ "Select cm.crop_name, coalesce(sum(sold_quantity),0) sold_quantity\r\n"
					+ "  from fpo_saleinfo si\r\n"
					+ "inner join crop_master cm on cm.id=si.crop_ref_name\r\n"
					+ "where si.season_ref='3' and si.financial_year=:finYear and sold_quantity>=1\r\n"
					+ "group by cm.crop_name\r\n"
					+ ")q1 on q1.crop_name=q.crop_name";


			session = getCurrentSession();
			Query query = session.createSQLQuery(sql).setParameter("finYear", finYear)
					.setResultTransformer(Transformers.aliasToBean(DataDisplayDto.class));
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();

		} /*
			 * finally {
			 * 
			 * session.close(); }
			 */
		return list;
	}

	@Transactional
	public List<DataDisplayDto> getFPOprodkharif(Integer fpoId, String finYear) {
		List<DataDisplayDto> list = null;
		try {
			/*
			 * String sql =
			 * "Select cm.crop_name, sum(ms.marketable_quantity) marketable_quantity from marketable_surplus ms\r\n"
			 * + "inner join crop_master cm on cm.id=ms.crop_ref_name\r\n" +
			 * "where master_id=:fpoId and season_ref='2'  and financial_year=:finYear and marketable_quantity>=1\r\n"
			 * + "group by cm.crop_name";
			 */
			/*
			 * String sql = " Select cm.crop_name, \r\n" +
			 * "coalesce(sum(sold_quantity),0) sold_quantity,\r\n" +
			 * " coalesce((coalesce(sum(ms.marketable_quantity),0) - coalesce((sum(sold_quantity)),0)),0)marketable_quantity  from marketable_surplus ms\r\n"
			 * + " inner join crop_master cm on cm.id=ms.crop_ref_name\r\n" +
			 * " left join fpo_saleinfo si on si.master_id=ms.master_id and ms.crop_ref_name=si.crop_ref_name and ms.financial_year=si.financial_year\r\n"
			 * + " and ms.season_ref=si.season_ref\r\n" +
			 * " where ms.master_id=:fpoId and ms.season_ref='2' and ms.financial_year=:finYear and marketable_quantity>=1\r\n"
			 * + " group by cm.crop_name";
			 */
			
			String sql = "select q.crop_name, coalesce(q1.sold_quantity,0)sold_quantity ,(coalesce(marketable_quantity,0)-coalesce(q1.sold_quantity,0))marketable_quantity from\r\n"
					+ "(Select cm.crop_name, \r\n"
					+ "coalesce(sum(ms.marketable_quantity),0) marketable_quantity  from marketable_surplus ms\r\n"
					+ "inner join crop_master cm on cm.id=ms.crop_ref_name\r\n"
					+ "where ms.master_id=:fpoId and ms.season_ref='2' and ms.financial_year=:finYear and marketable_quantity>=1\r\n"
					+ "group by cm.crop_name) q\r\n"
					+ "left join \r\n"
					+ "(\r\n"
					+ "Select cm.crop_name, coalesce(sum(sold_quantity),0) sold_quantity\r\n"
					+ "  from fpo_saleinfo si\r\n"
					+ "inner join crop_master cm on cm.id=si.crop_ref_name\r\n"
					+ "where si.master_id=:fpoId and si.season_ref='2' and si.financial_year=:finYear and sold_quantity>=1\r\n"
					+ "group by cm.crop_name\r\n"
					+ ")q1 on q1.crop_name=q.crop_name";

					

			session = getCurrentSession();
			Query query = session.createSQLQuery(sql).setParameter("fpoId", fpoId).setParameter("finYear", finYear)
					.setResultTransformer(Transformers.aliasToBean(DataDisplayDto.class));
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();

		} /*
			 * finally {
			 * 
			 * session.close(); }
			 */
		return list;
	}

	@Transactional
	public List<DataDisplayDto> getProdKharif(String finYear) {
		List<DataDisplayDto> list = null;
		try {
			/*
			 * String sql =
			 * "Select cm.crop_name, sum(ms.marketable_quantity) marketable_quantity from marketable_surplus ms\r\n"
			 * + "inner join crop_master cm on cm.id=ms.crop_ref_name\r\n" +
			 * "where master_id=:fpoId and season_ref='2'  and financial_year=:finYear and marketable_quantity>=1\r\n"
			 * + "group by cm.crop_name";
			 */
			/*
			 * String sql = " Select cm.crop_name, \r\n" +
			 * "coalesce(sum(sold_quantity),0) sold_quantity,\r\n" +
			 * " coalesce((coalesce(sum(ms.marketable_quantity),0) - coalesce((sum(sold_quantity)),0)),0)marketable_quantity  from marketable_surplus ms\r\n"
			 * + " inner join crop_master cm on cm.id=ms.crop_ref_name\r\n" +
			 * " left join fpo_saleinfo si on si.master_id=ms.master_id and ms.crop_ref_name=si.crop_ref_name and ms.financial_year=si.financial_year\r\n"
			 * + " and ms.season_ref=si.season_ref\r\n" +
			 * " where  ms.season_ref='2' and ms.financial_year=:finYear and marketable_quantity>=1\r\n"
			 * + " group by cm.crop_name";
			 */
			
			String sql = "select q.crop_name, coalesce(q1.sold_quantity,0)sold_quantity ,(coalesce(marketable_quantity,0)-coalesce(q1.sold_quantity,0))marketable_quantity from\r\n"
					+ "(Select cm.crop_name, \r\n"
					+ "coalesce(sum(ms.marketable_quantity),0) marketable_quantity  from marketable_surplus ms\r\n"
					+ "inner join crop_master cm on cm.id=ms.crop_ref_name\r\n"
					+ "where  ms.season_ref='2' and ms.financial_year=:finYear and marketable_quantity>=1\r\n"
					+ "group by cm.crop_name) q\r\n"
					+ "left join \r\n"
					+ "(\r\n"
					+ "Select cm.crop_name, coalesce(sum(sold_quantity),0) sold_quantity\r\n"
					+ "  from fpo_saleinfo si\r\n"
					+ "inner join crop_master cm on cm.id=si.crop_ref_name\r\n"
					+ "where si.season_ref='2' and si.financial_year=:finYear and sold_quantity>=1\r\n"
					+ "group by cm.crop_name\r\n"
					+ ")q1 on q1.crop_name=q.crop_name";


			session = getCurrentSession();
			Query query = session.createSQLQuery(sql).setParameter("finYear", finYear)
					.setResultTransformer(Transformers.aliasToBean(DataDisplayDto.class));
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
			/* return list; */
		} /*
			 * finally {
			 * 
			 * session.close(); }
			 */
		return list;
	}

	@Transactional
	public List<DataDisplayDto> getFPOprodrabi(Integer fpoId, String finYear) {
		List<DataDisplayDto> list = null;
		try {
			/*
			 * String sql =
			 * "Select cm.crop_name, sum(ms.marketable_quantity) marketable_quantity from marketable_surplus ms\r\n"
			 * + "inner join crop_master cm on cm.id=ms.crop_ref_name\r\n" +
			 * "where master_id=:fpoId and season_ref='1' and financial_year=:finYear and marketable_quantity>=1\r\n"
			 * + "group by cm.crop_name";
			 */
			/*
			 * String sql = " Select cm.crop_name, \r\n" +
			 * "coalesce(sum(sold_quantity),0) sold_quantity,\r\n" +
			 * " coalesce((coalesce(sum(ms.marketable_quantity),0) - coalesce((sum(sold_quantity)),0)),0)marketable_quantity  from marketable_surplus ms\r\n"
			 * + " inner join crop_master cm on cm.id=ms.crop_ref_name\r\n" +
			 * " left join fpo_saleinfo si on si.master_id=ms.master_id and ms.crop_ref_name=si.crop_ref_name and ms.financial_year=si.financial_year\r\n"
			 * + " and ms.season_ref=si.season_ref\r\n" +
			 * " where ms.master_id=:fpoId and ms.season_ref='1' and ms.financial_year=:finYear and marketable_quantity>=1\r\n"
			 * + " group by cm.crop_name";
			 */
			
			String sql = "select q.crop_name, coalesce(q1.sold_quantity,0)sold_quantity ,(coalesce(marketable_quantity,0)-coalesce(q1.sold_quantity,0))marketable_quantity from\r\n"
					+ "(Select cm.crop_name, \r\n"
					+ "coalesce(sum(ms.marketable_quantity),0) marketable_quantity  from marketable_surplus ms\r\n"
					+ "inner join crop_master cm on cm.id=ms.crop_ref_name\r\n"
					+ "where ms.master_id=:fpoId and ms.season_ref='1' and ms.financial_year=:finYear and marketable_quantity>=1\r\n"
					+ "group by cm.crop_name) q\r\n"
					+ "left join \r\n"
					+ "(\r\n"
					+ "Select cm.crop_name, coalesce(sum(sold_quantity),0) sold_quantity\r\n"
					+ "  from fpo_saleinfo si\r\n"
					+ "inner join crop_master cm on cm.id=si.crop_ref_name\r\n"
					+ "where si.master_id=:fpoId and si.season_ref='1' and si.financial_year=:finYear and sold_quantity>=1\r\n"
					+ "group by cm.crop_name\r\n"
					+ ")q1 on q1.crop_name=q.crop_name";

					

			session = getCurrentSession();
			Query query = session.createSQLQuery(sql).setParameter("fpoId", fpoId).setParameter("finYear", finYear)
					.setResultTransformer(Transformers.aliasToBean(DataDisplayDto.class));
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
			/* return list; */
		} /*
			 * finally {
			 * 
			 * session.close(); }
			 */
		return list;
	}

	
	@javax.transaction.Transactional
	public List<DataDisplayDto> getProdRabi(String finYear) {
		List<DataDisplayDto> list = null;
		try {
			/*
			 * String sql =
			 * "Select cm.crop_name, sum(ms.marketable_quantity) marketable_quantity from marketable_surplus ms\r\n"
			 * + "inner join crop_master cm on cm.id=ms.crop_ref_name\r\n" +
			 * "where master_id=:fpoId and season_ref='1' and financial_year=:finYear and marketable_quantity>=1\r\n"
			 * + "group by cm.crop_name";
			 */
			/*
			 * String sql = " Select cm.crop_name, \r\n" +
			 * "coalesce(sum(sold_quantity),0) sold_quantity,\r\n" +
			 * " coalesce((coalesce(sum(ms.marketable_quantity),0) - coalesce((sum(sold_quantity)),0)),0)marketable_quantity  from marketable_surplus ms\r\n"
			 * + " inner join crop_master cm on cm.id=ms.crop_ref_name\r\n" +
			 * " left join fpo_saleinfo si on si.master_id=ms.master_id and ms.crop_ref_name=si.crop_ref_name and ms.financial_year=si.financial_year\r\n"
			 * + " and ms.season_ref=si.season_ref\r\n" +
			 * " where ms.season_ref='1' and ms.financial_year=:finYear and marketable_quantity>=1\r\n"
			 * + " group by cm.crop_name";
			 */
			String sql = "select q.crop_name, coalesce(q1.sold_quantity,0)sold_quantity ,(coalesce(marketable_quantity,0)-coalesce(q1.sold_quantity,0))marketable_quantity from\r\n"
					+ "(Select cm.crop_name, \r\n"
					+ "coalesce(sum(ms.marketable_quantity),0) marketable_quantity  from marketable_surplus ms\r\n"
					+ "inner join crop_master cm on cm.id=ms.crop_ref_name\r\n"
					+ "where  ms.season_ref='1' and ms.financial_year=:finYear and marketable_quantity>=1\r\n"
					+ "group by cm.crop_name) q\r\n"
					+ "left join \r\n"
					+ "(\r\n"
					+ "Select cm.crop_name, coalesce(sum(sold_quantity),0) sold_quantity\r\n"
					+ "  from fpo_saleinfo si\r\n"
					+ "inner join crop_master cm on cm.id=si.crop_ref_name\r\n"
					+ "where  si.season_ref='1' and si.financial_year=:finYear and sold_quantity>=1\r\n"
					+ "group by cm.crop_name\r\n"
					+ ")q1 on q1.crop_name=q.crop_name";


			session = getCurrentSession();
			Query query = session.createSQLQuery(sql).setParameter("finYear", finYear)
					.setResultTransformer(Transformers.aliasToBean(DataDisplayDto.class));
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
			/* return list; */
		} /*
			 * finally {
			 * 
			 * session.close(); }
			 */
		return list;
	}
	
	@Transactional
	public List<ReportDTO> rabiProductionCropWise_actual(Integer masterId,String finyear) {
		
		try 
		{
			/*
			 * sql = "Select  crop_name, actual_production from (" +
			 * "Select  cm.crop_name,   sum(pd.actual_production) \"actual_production\" \r\n"
			 * + "from fpo\r\n" +
			 * "inner join production_details pd on  pd.master_id=fpo.fpo_id and pd.financial_year=:finyear\r\n"
			 * + "inner join crop_master cm on cast(pd.crop_ref_name as integer)=cm.id\r\n"
			 * +
			 * "inner join season_master sm on sm.season_id=cast(pd.season_ref as integer) and sm.season_name='Rabi'\r\n"
			 * + "where fpo.fpo_id = :masterId\r\n" + "group by  cm.crop_name\r\n" +
			 * " ) Q\r\n" + " order by actual_production desc limit 5";
			 */
			sql="Select  crop_name, actual_production from (\r\n" + 
					"Select  cm.crop_name,   coalesce (sum(pd.actual_quantity),0) \"actual_production\" \r\n" + 
					"from fpo\r\n" + 
					"inner join marketable_surplus pd on  pd.master_id=fpo.fpo_id and pd.financial_year=:finyear\r\n" + 
					"inner join crop_master cm on cast(pd.crop_ref_name as integer)=cm.id\r\n" + 
					"inner join season_master sm on sm.season_id=cast(pd.season_ref as integer) and sm.season_name='Rabi'\r\n" + 
					"where fpo.fpo_id = :masterId and pd.marketable_quantity>1 \r\n" + 
					"group by  cm.crop_name\r\n" + 
					" ) Q\r\n" + 
					"order by actual_production desc limit 5";
			/* session = sessionFactory.openSession(); */
			
			session = getCurrentSession();
		//	tx = session.beginTransaction();
		 query = session.createSQLQuery(sql).setParameter("finyear", finyear).setParameter("masterId", masterId).setResultTransformer(Transformers.aliasToBean(ReportDTO.class));
		 result = query.list();
		 return result;
		}
		catch (Exception e) {
			e.printStackTrace();
			//logger.error(e.getMessage() +" on "+ new Date());return result;
		}
		/*
		 * finally { //tx.commit(); session.clear(); session.clear(); }
		 */
		return result;
		
	}
	
	
	@Transactional
	public List<ReportDTO> rabiProductionCropWise_actual_all(String finyear) {
		
		try 
		{
			/*
			 * sql = "Select  crop_name, actual_production from (" +
			 * "Select  cm.crop_name,   sum(pd.actual_production) \"actual_production\" \r\n"
			 * + "from fpo\r\n" +
			 * "inner join production_details pd on  pd.master_id=fpo.fpo_id and pd.financial_year=:finyear\r\n"
			 * + "inner join crop_master cm on cast(pd.crop_ref_name as integer)=cm.id\r\n"
			 * +
			 * "inner join season_master sm on sm.season_id=cast(pd.season_ref as integer) and sm.season_name='Rabi'\r\n"
			 * + "where fpo.fpo_id = :masterId\r\n" + "group by  cm.crop_name\r\n" +
			 * " ) Q\r\n" + " order by actual_production desc limit 5";
			 */
			sql="Select  crop_name, actual_production from (\r\n" + 
					"Select  cm.crop_name,   coalesce (sum(pd.actual_quantity),0) \"actual_production\" \r\n" + 
					"from fpo\r\n" + 
					"inner join marketable_surplus pd on  pd.master_id=fpo.fpo_id and pd.financial_year=:finyear\r\n" + 
					"inner join crop_master cm on cast(pd.crop_ref_name as integer)=cm.id\r\n" + 
					"inner join season_master sm on sm.season_id=cast(pd.season_ref as integer) and sm.season_name='Rabi'\r\n" + 
					"where  pd.marketable_quantity>1 \r\n" + 
					"group by  cm.crop_name\r\n" + 
					" ) Q\r\n" + 
					"order by actual_production desc limit 5";
			
			session = getCurrentSession();
		//	tx = session.beginTransaction();
		 query = session.createSQLQuery(sql).setParameter("finyear", finyear).setResultTransformer(Transformers.aliasToBean(ReportDTO.class));
		 result = query.list();return result;
		}
		catch (Exception e) {
			e.printStackTrace();
		//	logger.error(e.getMessage() +" on "+ new Date());return result;
		}
		/*
		 * finally { //tx.commit(); session.clear(); session.clear(); }
		 */
		return result;
		
	}

	
	@Transactional
	public List<ReportDTO> kharifProductionCropWise_actual(Integer masterId, String finyear) {
		try 
		{
			/*
			 * sql = "Select  crop_name, actual_production from (" +
			 * "Select  cm.crop_name,   sum(pd.actual_production) \"actual_production\" \r\n"
			 * + "from fpo\r\n" +
			 * "inner join production_details pd on  pd.master_id=fpo.fpo_id and pd.financial_year=:finyear\r\n"
			 * + "inner join crop_master cm on cast(pd.crop_ref_name as integer)=cm.id\r\n"
			 * +
			 * "inner join season_master sm on sm.season_id=cast(pd.season_ref as integer) and sm.season_name='Kharif'\r\n"
			 * + "where fpo.fpo_id = :masterId\r\n" + "group by  cm.crop_name" + ") Q\r\n" +
			 * " order by actual_production desc limit 5";
			 */
			sql="Select  crop_name, actual_production from (\r\n" + 
					"Select  cm.crop_name,   coalesce (sum(pd.actual_quantity),0) \"actual_production\" \r\n" + 
					"from fpo\r\n" + 
					"inner join marketable_surplus pd on  pd.master_id=fpo.fpo_id and pd.financial_year=:finyear\r\n" + 
					"inner join crop_master cm on cast(pd.crop_ref_name as integer)=cm.id\r\n" + 
					"inner join season_master sm on sm.season_id=cast(pd.season_ref as integer) and sm.season_name='Kharif'\r\n" + 
					"where fpo.fpo_id = :masterId and pd.marketable_quantity>1\r\n" + 
					"group by  cm.crop_name\r\n" + 
					" ) Q\r\n" + 
					"order by actual_production desc";
			
			session = getCurrentSession();
			//tx = session.beginTransaction();
		 query = session.createSQLQuery(sql).setParameter("finyear", finyear).setParameter("masterId", masterId).setResultTransformer(Transformers.aliasToBean(ReportDTO.class));
		 result = query.list();return result;
		}
		catch (Exception e) {
			e.printStackTrace();
	//		logger.error(e.getMessage() +" on "+ new Date());return result;
		}
		/*
		 * finally { //tx.commit(); session.clear(); session.clear(); }
		 */
		return result;
		
	}
	
	@Transactional
	public List<ReportDTO> kharifProductionCropWise_actual_all(String finyear) {
		try 
		{
			/*
			 * sql = "Select  crop_name, actual_production from (" +
			 * "Select  cm.crop_name,   sum(pd.actual_production) \"actual_production\" \r\n"
			 * + "from fpo\r\n" +
			 * "inner join production_details pd on  pd.master_id=fpo.fpo_id and pd.financial_year=:finyear\r\n"
			 * + "inner join crop_master cm on cast(pd.crop_ref_name as integer)=cm.id\r\n"
			 * +
			 * "inner join season_master sm on sm.season_id=cast(pd.season_ref as integer) and sm.season_name='Kharif'\r\n"
			 * + "where fpo.fpo_id = :masterId\r\n" + "group by  cm.crop_name" + ") Q\r\n" +
			 * " order by actual_production desc limit 5";
			 */
			sql="Select  crop_name, actual_production from (\r\n" + 
					"Select  cm.crop_name,   coalesce (sum(pd.actual_quantity),0) \"actual_production\" \r\n" + 
					"from fpo\r\n" + 
					"inner join marketable_surplus pd on  pd.master_id=fpo.fpo_id and pd.financial_year=:finyear\r\n" + 
					"inner join crop_master cm on cast(pd.crop_ref_name as integer)=cm.id\r\n" + 
					"inner join season_master sm on sm.season_id=cast(pd.season_ref as integer) and sm.season_name='Kharif'\r\n" + 
					"where pd.marketable_quantity>1\r\n" + 
					"group by  cm.crop_name\r\n" + 
					" ) Q\r\n" + 
					"order by actual_production desc limit 5";
			
			session = getCurrentSession();
			//tx = session.beginTransaction();
		 query = session.createSQLQuery(sql).setParameter("finyear", finyear).setResultTransformer(Transformers.aliasToBean(ReportDTO.class));
		 result = query.list();return result;
		}
		catch (Exception e) {
			e.printStackTrace();
			//logger.error(e.getMessage() +" on "+ new Date());return result;
		}
		/*
		 * finally { //tx.commit(); session.clear(); session.clear(); }
		 */
		return result;
		
	}

	
	@Transactional
	public List<ReportDTO> zayadProductionCropWise_actual(Integer masterId, String finyear) {
		try 
		{
			/*
			 * sql = " Select  crop_name, actual_production from (" +
			 * "Select  cm.crop_name,   sum(pd.actual_production) \"actual_production\" \r\n"
			 * + "from fpo\r\n" +
			 * "inner join production_details pd on  pd.master_id=fpo.fpo_id and pd.financial_year=:finyear\r\n"
			 * + "inner join crop_master cm on cast(pd.crop_ref_name as integer)=cm.id\r\n"
			 * +
			 * "inner join season_master sm on sm.season_id=cast(pd.season_ref as integer) and sm.season_name='Zayad'\r\n"
			 * + "where fpo.fpo_id = :masterId\r\n" + "group by  cm.crop_name" + ") Q\r\n" +
			 * " order by actual_production desc limit 5";
			 */
			sql="Select  crop_name, actual_production from (\r\n" + 
					"Select  cm.crop_name,   coalesce (sum(pd.actual_quantity),0) \"actual_production\" \r\n" + 
					"from fpo\r\n" + 
					"inner join marketable_surplus pd on  pd.master_id=fpo.fpo_id and pd.financial_year=:finyear\r\n" + 
					"inner join crop_master cm on cast(pd.crop_ref_name as integer)=cm.id\r\n" + 
					"inner join season_master sm on sm.season_id=cast(pd.season_ref as integer) and sm.season_name='Zayad'\r\n" + 
					"where fpo.fpo_id = :masterId and pd.marketable_quantity>1\r\n" + 
					"group by  cm.crop_name\r\n" + 
					" ) Q\r\n" + 
					"order by actual_production desc limit 5";
			
			session = getCurrentSession();
			//tx = session.beginTransaction();
		 query = session.createSQLQuery(sql).setParameter("finyear", finyear).setParameter("masterId", masterId).setResultTransformer(Transformers.aliasToBean(ReportDTO.class));
		 result = query.list();return result;
		}
		catch (Exception e) {
			e.printStackTrace();
			//logger.error(e.getMessage() +" on "+ new Date());return result;
		}
		/*
		 * finally { //tx.commit(); session.clear(); session.clear(); }
		 */
		return result;
		
	}
	
	
	@Transactional
	public List<ReportDTO> zayadProductionCropWise_actual_all(String finyear) {
		try 
		{

			sql="Select  crop_name, actual_production from (\r\n" + 
					"Select  cm.crop_name,   coalesce (sum(pd.actual_quantity),0) \"actual_production\" \r\n" + 
					"from fpo\r\n" + 
					"inner join marketable_surplus pd on  pd.master_id=fpo.fpo_id and pd.financial_year=:finyear\r\n" + 
					"inner join crop_master cm on cast(pd.crop_ref_name as integer)=cm.id\r\n" + 
					"inner join season_master sm on sm.season_id=cast(pd.season_ref as integer) and sm.season_name='Zayad'\r\n" + 
					"where pd.marketable_quantity>1\r\n" + 
					"group by  cm.crop_name\r\n" + 
					" ) Q\r\n" + 
					"order by actual_production desc limit 5";
			
			session = getCurrentSession();
			//tx = session.beginTransaction();
		 query = session.createSQLQuery(sql).setParameter("finyear", finyear).setResultTransformer(Transformers.aliasToBean(ReportDTO.class));
		 result = query.list();return result;
		}
		catch (Exception e) {
			e.printStackTrace();
			//logger.error(e.getMessage() +" on "+ new Date());return result;
		}
		/*
		 * finally { //tx.commit(); session.clear(); session.clear(); }
		 */
		return result;
		
	}


	public List<FPODetailsDTO> homeSearch(String searchVal, String searchIn, List<String> fileterdistricts,
			List<Integer> fileterqty,List<String> filtercrops,List<String> fpos) {
		// TODO Auto-generated method stub
// first we are searching from home page by two inputs one is value other is search in
//		
//		
		
		if(searchIn.equalsIgnoreCase("any"))
		{

	
			
			sql = "Select id, unitassla,state, cropid, district,nodal,mobile, email,fpo_lot_no, associationdate, crops, services,cropVeriety,marketableSurplus, actualProduction from\r\n"
					+ "(select distinct fpo.fpo_id id,fpo.agency_associated unitassla,states.state_name state,\r\n"
					+ "districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n"
					+ "fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10)as varchar) associationdate, cm.id cropid,cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops,\r\n"
					+ "CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' ',cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services, cv.crop_veriety as cropVeriety, cast(coalesce(pd.marketable_quantity,0) as varchar)\r\n"
					+ "as marketableSurplus, apro.actual_production as actualProduction\r\n"
					+ "from fpo inner join states on states.state_id = fpo.state_ref\r\n"
					+ "inner join districts on district_id = fpo.dist_ref_id\r\n"
					+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
					+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
					+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
					+ "left join production_details apro on apro.crop_id = cm.id\r\n"
					+ "left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n"
					+ "left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id\r\n"
					+ "group by fpo.fpo_id,cm.id,fpo.agency_associated,states.state_name ,districts.district_name ,fpo.fpo_name, cv.crop_veriety, pd.marketable_quantity,\r\n"
					+ "apro.actual_production,\r\n"
					+ "fpo.fpo_landline ,fpo.fpo_email,\r\n"
					+ "fpo_lot_no ,\r\n"
					+ "substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10) ) as Q\r\n"
					+ "where\r\n"
					+ "UPPER (district) like '%"+searchVal.toUpperCase()+"%'\r\n"
					+ "or UPPER(crops) like '%"+searchVal.toUpperCase()+"%'\r\n"
					+ "or UPPER(services) like '%"+searchVal.toUpperCase()+"%'\r\n"
					+ "or UPPER(nodal) like '%"+searchVal.toUpperCase()+"%'";
		
		
		
		}
		
		else if (searchIn.equalsIgnoreCase("fpo_name")) 
		{

			
			sql = "Select id, unitassla,state, cropid,district,nodal,mobile, email,fpo_lot_no, associationdate, crops, services,cropVeriety,marketableSurplus, actualProduction from\r\n"
					+ "(select distinct fpo.fpo_id id,fpo.agency_associated unitassla,states.state_name state,\r\n"
					+ "districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n"
					+ "fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10)as varchar) associationdate, cm.id cropid,cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops,\r\n"
					+ "CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' ',cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services, cv.crop_veriety as cropVeriety, cast(coalesce(pd.marketable_quantity,0) as varchar)\r\n"
					+ "as marketableSurplus, apro.actual_production as actualProduction\r\n"
					+ "from fpo inner join states on states.state_id = fpo.state_ref\r\n"
					+ "inner join districts on district_id = fpo.dist_ref_id\r\n"
					+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
					+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
					+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
					+ "left join production_details apro on apro.crop_id = cm.id\r\n"
					+ "left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n"
					+ "left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id\r\n"
					+ "group by fpo.fpo_id,cm.id,fpo.agency_associated,states.state_name ,districts.district_name ,fpo.fpo_name, cv.crop_veriety, pd.marketable_quantity,\r\n"
					+ "apro.actual_production,\r\n"
					+ "fpo.fpo_landline ,fpo.fpo_email,\r\n"
					+ "fpo_lot_no ,\r\n"
					+ "substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10) ) as Q\r\n"
					+ "where\r\n"
					+ "UPPER(nodal) like '%"+searchVal.toUpperCase()+"%'";
		}
		else if (searchIn.equalsIgnoreCase("district")) 
		{
		
			sql = "Select id, unitassla,state, district, cropid, nodal,mobile, email,fpo_lot_no, associationdate, crops, services,cropVeriety,marketableSurplus, actualProduction from\r\n"
					+ "(select distinct fpo.fpo_id id,fpo.agency_associated unitassla,states.state_name state,\r\n"
					+ "districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n"
					+ "fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40)) from 1 for 10)as varchar) associationdate, cm.id cropid,cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops,\r\n"
					+ "CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' ',cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services, cv.crop_veriety as cropVeriety, cast(coalesce(pd.marketable_quantity,0) as varchar)\r\n"
					+ "as marketableSurplus,apro.actual_production as actualProduction\r\n"
					+ "from fpo inner join states on states.state_id = fpo.state_ref\r\n"
					+ "inner join districts on district_id = fpo.dist_ref_id\r\n"
					+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
					+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
					+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
					+ "left join production_details apro on apro.crop_id = cm.id\r\n"
					+ "left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n"
					+ "left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id\r\n"
					+ "group by fpo.fpo_id,cm.id,fpo.agency_associated,states.state_name ,districts.district_name ,fpo.fpo_name, cv.crop_veriety, pd.marketable_quantity,\r\n"
					+ "apro.actual_production,\r\n"
					+ "fpo.fpo_landline ,fpo.fpo_email,\r\n"
					+ "fpo_lot_no ,\r\n"
					+ "substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10) ) as Q\r\n"
					+ "where\r\n"
					+ "UPPER(district) like '%"+searchVal.toUpperCase()+"%'";
					
		} 
			else if (searchIn.equalsIgnoreCase("crop")) 
			{

				
				
				sql = "Select id, unitassla,state, cropid, district,nodal,mobile, email,fpo_lot_no, associationdate, crops, services,cropVeriety,marketableSurplus, actualProduction from\r\n"
						+ "(select distinct fpo.fpo_id id,fpo.agency_associated unitassla,states.state_name state,\r\n"
						+ "districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n"
						+ "fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10)as varchar) associationdate,cm.id as cropid,cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops,\r\n"
						+ "CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' ',cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services, cv.crop_veriety as cropVeriety, cast(coalesce(pd.marketable_quantity,0) as varchar)\r\n"
						+ "as marketableSurplus,apro.actual_production as actualProduction\r\n"
						+ "from fpo inner join states on states.state_id = fpo.state_ref\r\n"
						+ "inner join districts on district_id = fpo.dist_ref_id\r\n"
						+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
						+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
						+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
						+ "left join production_details apro on apro.crop_id = cm.id\r\n"
						+ "left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n"
						+ "left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id\r\n"
						+ "group by fpo.fpo_id,cm.id,fpo.agency_associated,states.state_name ,districts.district_name ,fpo.fpo_name, cv.crop_veriety, pd.marketable_quantity,\r\n"
						+ "apro.actual_production,\r\n"
						+ "fpo.fpo_landline ,fpo.fpo_email,\r\n"
						+ "fpo_lot_no ,\r\n"
						+ "substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10) ) as Q\r\n"
						+ "where\r\n"
						+ "UPPER(crops) like '%"+searchVal.toUpperCase()+"%'";
			}
		
			else if (searchIn.equalsIgnoreCase("services")) 
			{

				
				sql = "Select id, unitassla,state, cropid,district,nodal,mobile, email,fpo_lot_no, associationdate, crops, services,cropVeriety,marketableSurplus, actualProduction from\r\n"
						+ "(select distinct fpo.fpo_id id,fpo.agency_associated unitassla,states.state_name state,\r\n"
						+ "districts.district_name district,fpo.fpo_name nodal,fpo.fpo_landline mobile,fpo.fpo_email email,\r\n"
						+ "fpo_lot_no ,cast (substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10)as varchar) associationdate,cm.id as cropid,cast(string_agg(distinct cm.crop_name, ', ')as varchar) crops,\r\n"
						+ "CONCAT(cast(string_agg(distinct ads.service_name, ', ')as varchar),' ',cast(string_agg(distinct fmb.equpment_name, ', ')as varchar)) services, cv.crop_veriety as cropVeriety, cast(coalesce(pd.marketable_quantity,0) as varchar)\r\n"
						+ "as marketableSurplus,apro.actual_production as actualProduction\r\n"
						+ "from fpo inner join states on states.state_id = fpo.state_ref\r\n"
						+ "inner join districts on district_id = fpo.dist_ref_id\r\n"
						+ "left join marketable_surplus pd on pd.master_id=fpo.fpo_id\r\n"
						+ "left join crop_master cm on cm.id=cast(pd.crop_ref_name as integer)\r\n"
						+ "left join crop_veriety_master cv on cv.crop_master_ref_id = cm.id\r\n"
						+ "left join production_details apro on apro.crop_id = cm.id\r\n"
						+ "left join fpo_additonal_services ads on ads.fpo_id=fpo.fpo_id\r\n"
						+ "left join farm_manchinery_bank fmb on fmb.master_id=fpo.fpo_id\r\n"
						+ "group by fpo.fpo_id,cm.id,fpo.agency_associated,states.state_name ,districts.district_name ,fpo.fpo_name, cv.crop_veriety, pd.marketable_quantity,\r\n"
						+ "apro.actual_production,\r\n"
						+ "fpo.fpo_landline ,fpo.fpo_email,\r\n"
						+ "fpo_lot_no ,\r\n"
						+ "substring(CAST ( date_of_regi AS character varying (40) ) from 1 for 10) ) as Q\r\n"
						+ "where\r\n"
						+ "UPPER(services) like '%"+searchVal.toUpperCase()+"%'";
			   }
	
		
         	//String finalsql = 	"Select * from ("+sql+")";
		
		  List<FPODetailsDTO> obj = entityManager.createNativeQuery(sql,"FPODetailsDTO").getResultList();
			  finalpredicate=null;
			  
			  System.out.println("Here all records we are processing predictes..start");
			  if(fileterdistricts!=null)
			  {
				  fileterdistricts.forEach(data->{
						 Predicate<FPODetailsDTO> samplepredicate =  samplepredecate->samplepredecate.getDistrict().contentEquals(data);
						 System.out.println("Here all records we are processing predictes");
						 if(finalpredicate == null)
						 {
							 finalpredicate = samplepredicate;
						 }else
						 {
							 finalpredicate =  finalpredicate.or(samplepredicate);
						 }
				  });				  
			  }
			  
			  if(fileterqty != null)
			  {
				  fileterqty.forEach(data -> {
					  Predicate<FPODetailsDTO> maxpredicate;
					  switch(data)
					  {
					  
						  
					  case 100:
						  maxpredicate =  samplepredecate->samplepredecate.getMarketableSurplus()<100 && samplepredecate.getMarketableSurplus()>0;
							
							 if(finalpredicate == null)
							 {
								 finalpredicate = maxpredicate;
							 }else
							 {
								 finalpredicate =  finalpredicate.or(maxpredicate);
							 }
						  break;
					  case 200:
						   maxpredicate =  samplepredecate->samplepredecate.getMarketableSurplus()<300 && samplepredecate.getMarketableSurplus()>199;
							
							 if(finalpredicate == null)
							 {
								 finalpredicate = maxpredicate;
							 }else
							 {
								 finalpredicate =  finalpredicate.or(maxpredicate);
							 }
						  break;
					  case 300:
						   maxpredicate =  samplepredecate->samplepredecate.getMarketableSurplus()<399 && samplepredecate.getMarketableSurplus()>299;
							
							 if(finalpredicate == null)
							 {
								 finalpredicate = maxpredicate;
							 }else
							 {
								 finalpredicate =  finalpredicate.or(maxpredicate);
							 }
						  break;
						  default:
							  break;
					  }
					
				  });				  
			  }
			  
			  if(filtercrops!=null)
			  {
				  filtercrops.forEach(cropdetails->{
					  Predicate<FPODetailsDTO> croppredicate;
					  
					  String arr[] = cropdetails.split("@");
					  System.out.println("arr string = "+cropdetails);
					  System.out.println("array = "+arr.toString());
					
					  Arrays.asList(arr).forEach(System.out::println);
					  if(arr.length==1)
					  {
						  croppredicate = cropdata->cropdata.getCrops()!=null&&cropdata.getCrops().contentEquals(arr[0]);
					  }else
					  {
						  croppredicate = cropdata->cropdata.getCrops()!=null&&cropdata.getCrops().contentEquals(arr[0]) && cropdata.getCropVeriety()!=null&&cropdata.getCropVeriety().contentEquals(arr[1]);
					  }
					  
					  if(finalpredicate == null)
						 {
							 finalpredicate = croppredicate;
						 }else
						 {
							 
							 finalpredicate =  finalpredicate.or(croppredicate);
						 }
					  
				  });
			  }
			  
			  if(fpos!=null)
			  {
			  fpos.forEach(data->{
				  System.out.println("Fpo caught = "+data);
				  Predicate<FPODetailsDTO> fpopredicate =  fpredicate->fpredicate.getNodal().contentEquals(data);
					 
					 if(finalpredicate == null)
					 {
						 finalpredicate = fpopredicate;
					 }else
					 {
						 finalpredicate =  finalpredicate.or(fpopredicate);
					 }
				  
			  });
			  }
			
				fpos.forEach(data->{
					System.out.println("String of filterfpos = "+data);		
				});
			  
		return finalpredicate!=null?obj.stream().filter(finalpredicate).collect(Collectors.toList()):obj;
		
	}
	
	public SearchPagePagableDto newHomeSearch(SearchRequestDto searchRequestDto)
	{
		
		
		
		
		
		sql ="";
		if(searchRequestDto.getIn().equalsIgnoreCase("any"))
		{		
			sql = "select distinct fpo.fpo_id as fpoid, cv.veriety_id as varietyid, cv.crop_veriety as variety, fpo.fpo_name as fpo, \r\n"
					+ "dist.district_name as district,dist.district_id as districtid,\r\n"
					+ "cp.id as cropid, cp.crop_name as crop,  \r\n"
					+ "sum(tp.current_marketable) as currentMarketable from fpo \r\n"
					+ "inner join districts dist on dist.district_id = fpo.dist_ref_id \r\n"
					+ "inner join total_production tp on fpo.fpo_id = tp.fpo_id   \r\n"
					+ "left join crop_master cp on cp.id = tp.crop_id\r\n"
					+ "left join crop_veriety_master cv on cv.veriety_id = tp.veriety_id \r\n"
					+ "where \r\n"
					+ "tp.fin_year = '"+GetFinYear.getCurrentFinYear()+"' and UPPER(cp.crop_name) like '%"+searchRequestDto.getVal().toUpperCase()+"%' \r\n"
					+ "or UPPER(dist.district_name) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
					+ "or UPPER(cv.crop_veriety) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
					+ "or UPPER(fpo.fpo_name) like '%"+searchRequestDto.getVal().toUpperCase()+"%'"
					+"group by cv.crop_veriety,fpoid,fpo,district,districtid,crop,varietyid,cropid\r\n"
					+"order by fpo asc";				
		}
		
		else if (searchRequestDto.getIn().equalsIgnoreCase("fpo_name")) 
		{
			sql = "select distinct fpo.fpo_id as fpoid, cv.veriety_id as varietyid,cv.crop_veriety as variety, fpo.fpo_name as fpo, \r\n"
					+ "dist.district_name as district,dist.district_id as districtid,\r\n"
					+ "cp.id as cropid, cp.crop_name as crop,  \r\n"
					+ "sum(tp.current_marketable) as currentMarketable from fpo \r\n"
					+ "inner join districts dist on dist.district_id = fpo.dist_ref_id \r\n"
					+ "inner join total_production tp on fpo.fpo_id = tp.fpo_id   \r\n"
					+ "left join crop_master cp on cp.id = tp.crop_id\r\n"
					+ "left join crop_veriety_master cv on cv.veriety_id = tp.veriety_id \r\n"
					+ "where \r\n"
					+ "tp.fin_year = '"+GetFinYear.getCurrentFinYear()+"' and UPPER(fpo.fpo_name) like '%"+searchRequestDto.getVal().toUpperCase()+"%'"
					+"group by cv.crop_veriety,fpoid,fpo,district,districtid,crop,varietyid,cropid\r\n"
					+ "order by fpo asc";
					
		}
		else if (searchRequestDto.getIn().equalsIgnoreCase("district")) 
		{
			
			sql = "select distinct fpo.fpo_id as fpoid, cv.veriety_id as varietyid,cv.crop_veriety as variety, fpo.fpo_name as fpo, \r\n"
					+ "dist.district_name as district,dist.district_id as districtid,\r\n"
					+ "cp.id as cropid, cp.crop_name as crop,  \r\n"
					+ "sum(tp.current_marketable) as currentMarketable from fpo \r\n"
					+ "inner join districts dist on dist.district_id = fpo.dist_ref_id \r\n"
					+ "inner join total_production tp on fpo.fpo_id = tp.fpo_id   \r\n"
					+ "left join crop_master cp on cp.id = tp.crop_id\r\n"
					+ "left join crop_veriety_master cv on cv.veriety_id = tp.veriety_id \r\n"
					+ "where \r\n"
					+ "tp.fin_year = '"+GetFinYear.getCurrentFinYear()+"' and UPPER(dist.district_name) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
				    +"group by cv.crop_veriety,fpoid,fpo,district,districtid,crop,varietyid,cropid\r\n"
					+ "order by fpo asc";
					
		} 
		
		else if (searchRequestDto.getIn().equalsIgnoreCase("crop")) 
			{	
			sql = "select distinct fpo.fpo_id as fpoid, cv.veriety_id as varietyid, cv.crop_veriety as variety, fpo.fpo_name as fpo, \r\n"
					+ "dist.district_name as district,dist.district_id as districtid,\r\n"
					+ "cp.id as cropid,cp.crop_name as crop,  \r\n"
					+ "sum(tp.current_marketable) as currentMarketable from fpo \r\n"
					+ "inner join districts dist on dist.district_id = fpo.dist_ref_id \r\n"
					+ "inner join total_production tp on fpo.fpo_id = tp.fpo_id   \r\n"
					+ "left join crop_master cp on cp.id = tp.crop_id\r\n"
					+ "left join crop_veriety_master cv on cv.veriety_id = tp.veriety_id \r\n"
					+ "where \r\n"
					+ "tp.fin_year = '"+GetFinYear.getCurrentFinYear()+"' and UPPER(cp.crop_name) like '%"+searchRequestDto.getVal().toUpperCase()+"%' \r\n"
					+ "or UPPER(cv.crop_veriety) like '%"+searchRequestDto.getVal().toUpperCase()+"%'\r\n"
					+ "group by cv.crop_veriety,fpoid,fpo,district,districtid,crop,varietyid,cropid\r\n"
					+ "order by fpo asc";
					
					
			}else {
				
			}
		
//filtering the dataset at Java side to avoid lengthy query processing.
Predicate<SearchResponseDto> 	finalpredicate=null;		
	if(searchRequestDto.getDistrictIds()!=null) {
		for(Integer districtId:searchRequestDto.getDistrictIds())
		{
			
			Predicate<SearchResponseDto> samplepredicate =  samplepredecate->samplepredecate.getDistrictid().intValue()==districtId.intValue();
		      if(finalpredicate==null)
		      {
		    	  finalpredicate = samplepredicate;
		      }else {
		    	  finalpredicate =finalpredicate.or(samplepredicate);
		      }
		}
		
	}
    if(searchRequestDto.getQtymin()!=null&&searchRequestDto.getQtymax()!=null) {
    	
    		Predicate<SearchResponseDto> samplepredicate =  samplepredecate->samplepredecate.getCurrentMarketable().intValue() < searchRequestDto.getQtymin().intValue() && samplepredecate.getCurrentMarketable().intValue() < searchRequestDto.getQtymax().intValue();
		      if(finalpredicate==null)
		      {  	  
		    	  finalpredicate = samplepredicate;
		      
		      }else {
		    	  
		    	  finalpredicate =finalpredicate.and(samplepredicate);
		      }
		
	}
    
    if(searchRequestDto.getCropverietyIds()!=null) {
    	for(Integer filtercropsveritm:searchRequestDto.getCropverietyIds())
		{
    		Predicate<SearchResponseDto> samplepredicate =  samplepredecate->samplepredecate.getVarietyid().intValue() == filtercropsveritm.intValue();
		      if(finalpredicate==null)
		      {
		    	  finalpredicate = samplepredicate;
		      }else {
		    	  finalpredicate =finalpredicate.or(samplepredicate);
		      }		
		}
    	
      }
    
    if(searchRequestDto.getCropIds()!=null) {
    	for(Integer filtercropsItm:searchRequestDto.getCropIds())
		{
    		Predicate<SearchResponseDto> samplepredicate =  samplepredecate->samplepredecate.getCropid().intValue() == filtercropsItm.intValue();
		      if(finalpredicate==null)
		      {
		    	  finalpredicate = samplepredicate;
		      }else {
		    	  finalpredicate =finalpredicate.or(samplepredicate);
		      }
		}
    	
      }
   if(searchRequestDto.getFpoIds()!=null) 
     {
	   for(Integer fpoId:searchRequestDto.getFpoIds())
		{
			Predicate<SearchResponseDto> samplepredicate =  samplepredecate->samplepredecate.getFpoid().longValue() == fpoId.longValue();
		      if(finalpredicate==null)
		      {
		    	  finalpredicate = samplepredicate;
		      }else {
		    	  finalpredicate =finalpredicate.or(samplepredicate);
		      }
			
		}
     }
 
		
	     //String finalsql = 	"Select * from ("+sql+")";
		 //javax.persistence.Query query = entityManager.createNativeQuery("SELECT COUNT(*) FROM DOG WHERE ID =:id");
		 //query.setParameter("id", 1);
		 //int count = ((Number) query.getSingleResult()).intValue();
		
		  List<SearchResponseDto> obj = (List<SearchResponseDto>) entityManager.createNativeQuery(sql,"SearchResponseDTO").getResultList();		
		  //obj.subList(0, 0);
		  Integer offset  =(searchRequestDto.getPage().intValue()-1)*searchRequestDto.getLimit().intValue();
		  Integer last =offset.intValue()+searchRequestDto.getLimit().intValue(); 
		  obj = finalpredicate==null?obj:obj.stream().filter(finalpredicate).collect(Collectors.toList());
		  SearchPagePagableDto searchPagePagableDto = new SearchPagePagableDto();
		  searchPagePagableDto.setTotalElements(obj.size());
		  searchPagePagableDto.setPage(obj.subList(offset>obj.size()?0:offset, last>obj.size()?obj.size():last));
		  return searchPagePagableDto;
	}
	
}
