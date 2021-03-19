package com.upfpo.app.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.DepartmentAllUserDto;
import com.upfpo.app.dto.DepartmentProdReportDto;
import com.upfpo.app.dto.DepartmentSalesReportDto;
import com.upfpo.app.entity.ReasonsMaster;
import com.upfpo.app.repository.DepartmentRepository;
import com.upfpo.app.repository.UserRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private  EntityManager entityManager;
	
	@Override
	public List<DepartmentProdReportDto>  getDepartmentProductionReport(String finYear, Integer district, Integer crop, Integer seasonref) {
		return getDepartmentProdReport(finYear, district, crop, seasonref);
		
	}
	
	public List<DepartmentProdReportDto> getDepartmentProdReport(String finYear, Integer distId, Integer cropId, Integer seasonId) {
		List<DepartmentProdReportDto> list = null;
		String sql = null;

		try {
			String basequery = "Select d.district_name, fpo.fpo_name, fpo.fpo_address, fpo.fpo_landline, cm.crop_name, "
					+ " case when cast(cd.veriety_ref as integer)!=0 then cvm.crop_veriety else 'Other' end \"crop_veriety\" \r\n"
					+ ", count(f.farmer_id) \"total_farmers\", cast(sum(cd.sowing_area) as integer)as \"sowing_area\"\r\n"
					+ ", cast(sum(cd.ex_yield) as bigint)as \"estimated_production\", cast( sum(pd.marketable_surplus)  as bigint) as \"actual_production\"\r\n"
					+ "from fpo \r\n" + "inner join districts d on d.district_id=fpo.dist_ref_id\r\n"
					+ "inner join farmer f on f.fpo_ref_id=fpo.fpo_id\r\n"
					+ "inner join crop_details cd on cd.farmer_id=f.farmer_id and cd.master_id=fpo.fpo_id  and cd.financial_year=:finYear\r\n"
					+ "inner join crop_master cm on cm.id=cast (cd.crop_ref as integer)\r\n"
					+ "inner join crop_veriety_master cvm on cvm.crop_master_ref_id=cm.id and cvm.veriety_id=cast(cd.veriety_ref as integer)\r\n"
					+ "inner join production_details pd on pd.crop_ref_name=cd.crop_ref and pd.farmer_id=f.farmer_id\r\n"
					+ "and pd.master_id=fpo.fpo_id and cast(pd.season_ref as integer)=cast(cd.season_ref as integer) and pd.financial_year=:finYear\r\n";
			String groupby = "group by d.district_name, fpo.fpo_name, fpo.fpo_address, fpo.fpo_landline, cm.crop_name, cvm.crop_veriety, cd.veriety_ref\r\n";
			if (seasonId == 0 && distId == 0 && cropId == 0) {
				sql = basequery + " " + groupby;
				List<DepartmentProdReportDto> obj =  (List<DepartmentProdReportDto>) entityManager.createNativeQuery(sql,"DepartmentProdReportDto").setParameter("finYear", finYear).getResultList();
				
			} else if (seasonId == 0 && distId > 0 && cropId > 0) {
				String wherecondition = "where cm.id=:cropId and d.district_id=:distId\r\n";
				sql = basequery + " " + wherecondition + " " + groupby;
				list = (List<DepartmentProdReportDto>) entityManager
						.createNativeQuery(sql, "DepartmentProdReportDto")
						.setParameter("finYear", finYear)
						.setParameter("cropId", cropId)
						.setParameter("distId", distId)
						.getResultList();
			}

			else if (seasonId == 0 && distId > 0 && cropId == 0) {

				String wherecondition = "where d.district_id=:distId \r\n";
				sql = basequery + " " + wherecondition + " " + groupby;
				list = (List<DepartmentProdReportDto>) entityManager
						.createNativeQuery(sql, "DepartmentProdReportDto")
						.setParameter("finYear", finYear)
						.setParameter("distId", distId)
						.getResultList();

				
			} else if (seasonId == 0 && distId == 0 && cropId > 0) {
				// System.out.println("specific crop all district");

				String wherecondition = "where cm.id=:cropId \r\n";
				sql = basequery + " " + wherecondition + " " + groupby;
				list = (List<DepartmentProdReportDto>) entityManager
						.createNativeQuery(sql, "DepartmentProdReportDto")
						.setParameter("finYear", finYear)
						.setParameter("cropId", cropId)
						.getResultList();

				
			}
			// for specefic seasion case
			else if (seasonId > 0 && distId == 0 && cropId == 0) {
				// System.out.println("specific crop all district");

				String wherecondition = "where cd.season_ref=:seasonId \r\n";
				sql = basequery + " " + wherecondition + " " + groupby;
				list = (List<DepartmentProdReportDto>) entityManager
						.createNativeQuery(sql, "DepartmentProdReportDto")
						.setParameter("finYear", finYear)
						.setParameter("seasonId", seasonId)
						.getResultList();

			} else if (seasonId > 0 && distId == 0 && cropId > 0) {
				// System.out.println("specific crop all district");

				String wherecondition = "where cm.id=:cropId  and cd.season_ref=:seasonId\r\n";
				sql = basequery + " " + wherecondition + " " + groupby;
				list = (List<DepartmentProdReportDto>) entityManager
						.createNativeQuery(sql, "DepartmentProdReportDto")
						.setParameter("finYear", finYear)
						.setParameter("seasonId", seasonId)
						.setParameter("cropId", cropId)
						.getResultList();

			} else if (seasonId > 0 && distId > 0 && cropId == 0) {
				// System.out.println("specific crop all district");

				String wherecondition = "where cd.season_ref=:seasonId and d.district_id=:distId \r\n";
				sql = basequery + " " + wherecondition + " " + groupby;
				list = (List<DepartmentProdReportDto>) entityManager
						.createNativeQuery(sql, "DepartmentProdReportDto")
						.setParameter("finYear", finYear)
						.setParameter("seasonId", seasonId)
						.setParameter("distId", distId)
						.getResultList();

			} else if (seasonId > 0 && distId > 0 && cropId > 0) {
				// System.out.println("specific crop all district");

				String wherecondition = "where cd.season_ref=:seasonId and d.district_id=:distId and cm.id=:cropId \r\n";
				sql = basequery + " " + wherecondition + " " + groupby;
				list = (List<DepartmentProdReportDto>) entityManager
						.createNativeQuery(sql, "DepartmentProdReportDto")
						.setParameter("finYear", finYear)
						.setParameter("seasonId", seasonId)
						.setParameter("distId", distId)
						.setParameter("cropId", cropId)
						.getResultList();

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
		
	}

	@Override
	public List<DepartmentSalesReportDto> getDepartmentSalesReport(String finYear, Integer distId, Integer cropId,
			Integer seasonId) {
		List<DepartmentSalesReportDto> list = null;
		String sql = null;
		if(distId == null)
		{
			distId = 0;
		}
		if(cropId == null)
		{
			cropId = 0;
		}
		if(seasonId == null)
		{
			seasonId = 0;
		}

		try {
			String basequery = "select distinct f.fpo_name,d.district_name, cm.id as cropId, cm.crop_name as crop_name, cv.veriety_id as verietyId, cv.crop_veriety as crop_veriety, \r\n"
					+ "				sum(fp.sold_quantity) as sold_quantity from fpo f  \r\n"
					+ "				join districts d on d.district_id =  f.dist_ref_id\r\n"
					+ "				join fpo_sale_info fp on fp.master_id = f.fpo_id\r\n"
					+ "				join crop_master cm on cm.id = fp.crop_ref_name\r\n"
					+ "				join crop_veriety_master cv on cv.veriety_id = fp.veriety_ref\r\n";

			String groupby = " group by d.district_name, cm.id, cm.crop_name, cv.veriety_id, cv.crop_veriety, f.fpo_name order by sold_quantity desc";
			
			if (seasonId == 0 && distId == 0 && cropId == 0) {
				String wherecondition = "where fp.financial_year=:finYear\r\n ";
				sql = basequery + " " +wherecondition +" "+ groupby;
				list = (List<DepartmentSalesReportDto>) entityManager
						.createNativeQuery(sql, "DepartmentSalesReportDto")
						.setParameter("finYear", finYear)
						.getResultList();
				
			} else if (seasonId == 0 && distId > 0 && cropId > 0) {
				String wherecondition = "where fp.financial_year=:finYear and cm.id=:cropId and d.district_id=:distId\r\n";
				sql = basequery + " " + wherecondition + " " + groupby;
				list = (List<DepartmentSalesReportDto>) entityManager
						.createNativeQuery(sql, "DepartmentSalesReportDto")
						.setParameter("finYear", finYear)
						.setParameter("cropId", cropId)
						.setParameter("distId", distId)
						.getResultList();
			}

			else if (seasonId == 0 && distId > 0 && cropId == 0) {

				String wherecondition = "where fp.financial_year=:finYear and d.district_id=:distId \r\n";
				sql = basequery + " " + wherecondition + " " + groupby;
				list = (List<DepartmentSalesReportDto>) entityManager
						.createNativeQuery(sql, "DepartmentSalesReportDto")
						.setParameter("finYear", finYear)
						.setParameter("distId", distId)
						.getResultList();

				
			} else if (seasonId == 0 && distId == 0 && cropId > 0) {
				// System.out.println("specific crop all district");

				String wherecondition = "where fp.financial_year=:finYear and cm.id=:cropId \r\n";
				sql = basequery + " " + wherecondition + " " + groupby;
				list = (List<DepartmentSalesReportDto>) entityManager
						.createNativeQuery(sql, "DepartmentSalesReportDto")
						.setParameter("finYear", finYear)
						.setParameter("cropId", cropId)
						.getResultList();

				
			}
			// for specefic seasion case
			else if (seasonId > 0 && distId == 0 && cropId == 0) {
				// System.out.println("specific crop all district");

				String wherecondition = "where fp.financial_year=:finYear and fp.season_ref=:seasonId \r\n";
				sql = basequery + " " + wherecondition + " " + groupby;
				list = (List<DepartmentSalesReportDto>) entityManager
						.createNativeQuery(sql, "DepartmentSalesReportDto")
						.setParameter("finYear", finYear)
						.setParameter("seasonId", seasonId)
						.getResultList();
				
			} else if (seasonId > 0 && distId == 0 && cropId > 0) {
				// System.out.println("specific crop all district");
				String wherecondition = "where fp.financial_year=:finYear and cm.id=:cropId  and fp.season_ref =:seasonId\r\n";
				sql = basequery + " " + wherecondition + " " + groupby;
				list = (List<DepartmentSalesReportDto>) entityManager
						.createNativeQuery(sql, "DepartmentSalesReportDto")
						.setParameter("finYear", finYear)
						.setParameter("seasonId", seasonId)
						.setParameter("cropId", cropId)
						.getResultList();

			} else if (seasonId > 0 && distId > 0 && cropId == 0) {
				// System.out.println("specific crop all district");

				String wherecondition = "where fp.financial_year=:finYear and fp.season_ref =:seasonId and d.district_id=:distId \r\n";
				sql = basequery + " " + wherecondition + " " + groupby;
				list = (List<DepartmentSalesReportDto>) entityManager
						.createNativeQuery(sql, "DepartmentSalesReportDto")
						.setParameter("finYear", finYear)
						.setParameter("seasonId", seasonId)
						.setParameter("distId", distId)
						.getResultList();

			} else if (seasonId > 0 && distId > 0 && cropId > 0) {
				// System.out.println("specific crop all district");

				String wherecondition = "where fp.financial_year=:finYear and fp.season_ref=:seasonId and d.district_id=:distId and cm.id=:cropId \r\n";
				sql = basequery + " " + wherecondition + " " + groupby;
				list = (List<DepartmentSalesReportDto>) entityManager
						.createNativeQuery(sql, "DepartmentSalesReportDto")
						.setParameter("finYear", finYear)
						.setParameter("seasonId", seasonId)
						.setParameter("distId", distId)
						.setParameter("cropId", cropId)
						.getResultList();

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public List<DepartmentAllUserDto> getAllUser() {
		List <DepartmentAllUserDto> list = null;
		   try
			{
			  String sql = "select users.user_id,users.user_name,fpo_name,district_name,date_of_regi,fpo_landline,fpo_email,users.enabled from fpo \r\n" + 
			   		"join districts on fpo.dist_ref_id = districts.district_id  \r\n" + 
			   		"join users on fpo.users_id = users.user_id";
			   
			  list = (List<DepartmentAllUserDto>) entityManager.createNativeQuery(sql, "DepartmentAllUserDto").getResultList();
			  System.out.println(list.size());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		   return list;
	}

	@Override
	public List<ReasonsMaster> getAllReasons() {
		return departmentRepository.findAll();
	}

	@Override
	public void deActivateUser(Long uid, String reason, Integer masterId) {
		userRepository.deActivateUserByDept(uid,reason, masterId);
	}
	
	@Override
	public void activateUser(Long uid, Integer masterId) {
		userRepository.activateUserByDept(uid, masterId);
	}


}
