package com.upfpo.app.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.FarmerWiseProductionDTO;
import com.upfpo.app.requestStrings.ReportRequestString;

@Service
public class FarmerWiseProductionServiceImpl implements FarmerWiseProductionService 
{
	@Autowired
	EntityManager entityManager;
	
	List<FarmerWiseProductionDTO> obj = null;
	
	@Override
	public List<FarmerWiseProductionDTO> getReport(ReportRequestString reportRequestString) 
	{
		String sql = "Select f.farmer_name,f.farmer_parants father_husband_name,f.farmer_mob mobile, \r\n"
				+ "	            			case when farm_gen='male' then cast('Male' as varchar) else case when farm_gen='male' then cast('Female' as varchar) \r\n"
				+ "							else cast('Other' as varchar) end end  gender,\r\n"
				+ "	            			case when farm_category='gen' then cast('General' as varchar) else \r\n"
				+ "	            			case when farm_category='sc' then cast('SC' as varchar) else \r\n"
				+ "	            			case when farm_category='st' then cast('ST' as varchar) else \r\n"
				+ "	            			case when farm_category='obc' then cast( 'OBC' as varchar) else cast ('Others' as varchar) end  end end end  category,\r\n"
				+ "	            			sm.season_name,cm.crop_name, cvm.crop_veriety,sum(pd.marketable_quantity) marketable_surplus \r\n"
				+ "	            			from new_sowing_info ns\r\n"
				+ "	            			inner join farmer f on f.farmer_id=ns.farmer_id\r\n"
				+ "							inner join crop_details pd on pd.sowing_id = ns.sowing_id\r\n"
				+ "	            			inner join crop_master cm on cm.id = pd.crop_ref\r\n"
				+ "	            			inner join crop_veriety_master cvm on cvm.veriety_id= pd.veriety_ref\r\n"
				+ "	            			 inner join season_master sm on sm.season_id= pd.season_ref";
				if(reportRequestString.getSeasonId() != null && reportRequestString.getSeasonId() != 0)
				{
					sql = sql+" where f.fpo_ref_id= :fpoId and ns.fin_year= :finYear and pd.season_ref = :seasonId \r\n"
							+ "group by f.farmer_name,f.farmer_mob, cm.crop_name, cvm.crop_veriety, farm_gen, farm_category,sm.season_name, f.farmer_parants,f.farmer_id order by f.farmer_name asc";
					 obj =  (List<FarmerWiseProductionDTO>) entityManager.createNativeQuery(sql,"FarmerWiseProductionDTO").setParameter("fpoId", reportRequestString.getFpoId()).setParameter("finYear", reportRequestString.getFinYear()).setParameter("seasonId", reportRequestString.getSeasonId()).getResultList();
				}
				else
				{
					sql = sql+" where f.fpo_ref_id=:fpoId and ns.fin_year= :finYear  \r\n"
							+ "group by f.farmer_name,f.farmer_mob, cm.crop_name, cvm.crop_veriety, farm_gen, farm_category,sm.season_name, f.farmer_parants,f.farmer_id order by f.farmer_name asc";
					 obj =  (List<FarmerWiseProductionDTO>) entityManager.createNativeQuery(sql,"FarmerWiseProductionDTO").setParameter("fpoId", reportRequestString.getFpoId()).setParameter("finYear", reportRequestString.getFinYear()).getResultList();
				}
				System.out.println("Sql String::"+sql.toString());
		return obj;
	}
}
