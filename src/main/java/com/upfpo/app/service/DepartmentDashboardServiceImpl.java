package com.upfpo.app.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.DepartmentDashboardDTO;
import com.upfpo.app.dto.DeptActProdKharifDTO;
import com.upfpo.app.dto.DeptActProdRabiDTO;
import com.upfpo.app.dto.DeptActProdZayadfDTO;
import com.upfpo.app.dto.DeptActualProductionDTO;
import com.upfpo.app.dto.DeptDashboardReportDTO;
import com.upfpo.app.dto.DeptFpoAgencyDTO;
import com.upfpo.app.dto.DeptMarketableProductionDTO;
import com.upfpo.app.dto.DeptSoldProductionDTO;
import com.upfpo.app.dto.DeptTotMarKharifDTO;
import com.upfpo.app.dto.DeptTotMarRabiDTO;
import com.upfpo.app.dto.DeptTotMarZayadDTO;
import com.upfpo.app.dto.DeptTotSoldKharifDTO;
import com.upfpo.app.dto.DeptTotSoldRabiDTO;
import com.upfpo.app.dto.DeptTotSoldZayadDTO;
import com.upfpo.app.repository.FPORegisterRepository;
import com.upfpo.app.repository.FarmerMasterRepository;
import com.upfpo.app.repository.LandDetailsRepo;
import com.upfpo.app.requestStrings.ReportRequestString;
import com.upfpo.app.util.GetFinYear;

@Service
public class DepartmentDashboardServiceImpl implements DepartmentDashboardService
{
	@Autowired
	LandDetailsRepo landDetailsRepo;
	
	@Autowired
	FPORegisterRepository fPORegisterRepository;
	
	@Autowired
	FarmerMasterRepository farmerMasterRepository;
	
	@Autowired
	EntityManager entityManager;
	
	Double landArea = 0.0;
	
	Integer totalFpo = 0;
	
	Integer totalfarmers = 0;
	
	Double totalMarginalFarmer = 0.0;
	
	Double totalSmallFarmer = 0.0;
	
	Double totalOtherFarmer = 0.0;
	
	Double percentile	= 0.0;
	
	String sql = "";
	
	@Override
	public DepartmentDashboardDTO getDepartmentDashboardData(ReportRequestString reportRequestString) 
	{
		DepartmentDashboardDTO departmentDashboardDTO = new DepartmentDashboardDTO();
		landArea 				= landDetailsRepo.getTotalLand();
		totalFpo 				= fPORegisterRepository.getAllFpoCount();
		totalfarmers 			= farmerMasterRepository.getAllFarmers();
		totalMarginalFarmer 	= (totalfarmers * 0.8);
		totalSmallFarmer		= (totalfarmers * 0.13);
		totalOtherFarmer		= (totalfarmers * 0.07);
		
		if(reportRequestString.getFinYear()==null || reportRequestString.getFinYear()=="")
		{
			reportRequestString.setFinYear(GetFinYear.getCurrentFinYear());
		}
		
		DeptActualProductionDTO depAct = new DeptActualProductionDTO();
		depAct.setDeptActProdKharif(getDeptActualCropProductionKharif(reportRequestString.getFinYear()));
		depAct.setDeptActProdRabi(getDeptActualCropProductionRabi(reportRequestString.getFinYear()));
		depAct.setDeptActProdZayad(getDeptActualCropProductionZayad(reportRequestString.getFinYear()));
		
		DeptMarketableProductionDTO depMar = new DeptMarketableProductionDTO();
		depMar.setDeptTotMarKharif(getDeMarketableCropProductionKharif(reportRequestString.getFinYear()));
		depMar.setDeptTotMarRabi(getDeptMarketableCropProductionRabi(reportRequestString.getFinYear()));
		depMar.setDeptTotMarZayad(getDeptMarketableCropProductionZayad(reportRequestString.getFinYear()));
		
		DeptSoldProductionDTO deptSold = new DeptSoldProductionDTO();
		deptSold.setDeptTotSoldKharif(getDeptSaleCropProductionKharif(reportRequestString.getFinYear()));
		deptSold.setDeptTotSoldRabi(getDeptSaleCropProductionRabi(reportRequestString.getFinYear()));
		deptSold.setDeptTotSoldZayad(getDeptSalebleCropProductionZayad(reportRequestString.getFinYear()));
		
		List<DeptFpoAgencyDTO> agency = fPORegisterRepository.getAgency();
		Integer totalFpo = fPORegisterRepository.getAllFpoCount();
		
		for(int i =	0; i < agency.size(); i++)
		{
			Double value = (Double)agency.get(i).getCount().doubleValue();
			percentile = (totalFpo) * (value/ 100);
			agency.get(i).setAgencyWiseFpo(percentile);
		}
		
		departmentDashboardDTO.setLandArea(landArea);
		departmentDashboardDTO.setTotalFpo(totalFpo);
		departmentDashboardDTO.setTotalfarmers(totalfarmers);
		departmentDashboardDTO.setTotalMarginalFarmer(totalMarginalFarmer);
		departmentDashboardDTO.setTotalSmallFarmer(totalSmallFarmer);
		departmentDashboardDTO.setTotalOtherFarmer(totalOtherFarmer);
		departmentDashboardDTO.setDeptActualProduction(depAct);
		departmentDashboardDTO.setDeptMarketableProduction(depMar);
		departmentDashboardDTO.setDeptSoldProduction(deptSold);
		departmentDashboardDTO.setDeptFpoAgency(agency);
		return departmentDashboardDTO;
	}
	
	public List<DeptActProdRabiDTO> getDeptActualCropProductionRabi(String finYear)
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_actual_prod) as totAcProd from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.season_id = 1 and c.fin_year = :finYear group by c.crop_id, d.crop_name, seasonId order by totAcProd desc ";
		List<DeptActProdRabiDTO> obj =  (List<DeptActProdRabiDTO>) entityManager.createNativeQuery(sql,"DeptActProdRabiDTO").setParameter("finYear", finYear).getResultList();
		return obj;
	}
	
	public List<DeptActProdZayadfDTO> getDeptActualCropProductionZayad(String finYear)
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_actual_prod) as totAcProd from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.season_id = 3 and c.fin_year = :finYear group by c.crop_id, d.crop_name, seasonId order by totAcProd desc ";
		List<DeptActProdZayadfDTO> obj =  (List<DeptActProdZayadfDTO>) entityManager.createNativeQuery(sql,"DeptActProdZayadfDTO").setParameter("finYear", finYear).getResultList();
		return obj;
	}
	
	public List<DeptActProdKharifDTO> getDeptActualCropProductionKharif(String finYear)
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_actual_prod) as totAcProd from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.season_id = 2 and c.fin_year = :finYear group by c.crop_id, d.crop_name, seasonId order by totAcProd desc ";
		List<DeptActProdKharifDTO> obj =  (List<DeptActProdKharifDTO>) entityManager.createNativeQuery(sql,"DeptActProdKharifDTO").setParameter("finYear", finYear).getResultList();
		return obj;
	}
	
	public List<DeptTotMarRabiDTO> getDeptMarketableCropProductionRabi(String finYear)
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_marketable) as totMarkProd from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.season_id = 1 and c.fin_year = :finYear group by c.crop_id, d.crop_name, seasonId  order by totMarkProd desc";
		List<DeptTotMarRabiDTO> obj =  (List<DeptTotMarRabiDTO>) entityManager.createNativeQuery(sql,"DeptTotMarRabiDTO").setParameter("finYear", finYear).getResultList();
		return obj;
	}
	
	public List<DeptTotMarZayadDTO> getDeptMarketableCropProductionZayad(String finYear)
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_marketable) as totMarkProd from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.season_id = 3 and c.fin_year = :finYear group by c.crop_id, d.crop_name, seasonId  order by totMarkProd desc";
		List<DeptTotMarZayadDTO> obj =  (List<DeptTotMarZayadDTO>) entityManager.createNativeQuery(sql,"DeptTotMarZayadDTO").setParameter("finYear", finYear).getResultList();
		return obj;
	}
	
	public List<DeptTotMarKharifDTO> getDeMarketableCropProductionKharif(String finYear)
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_marketable) as totMarkProd from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.season_id = 2 and c.fin_year = :finYear group by c.crop_id, d.crop_name, seasonId  order by totMarkProd desc";
		List<DeptTotMarKharifDTO> obj =  (List<DeptTotMarKharifDTO>) entityManager.createNativeQuery(sql,"DeptTotMarKharifDTO").setParameter("finYear", finYear).getResultList();
		return obj;
	}
	
	public List<DeptTotSoldRabiDTO> getDeptSaleCropProductionRabi(String finYear)
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_sold) as totSold from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.season_id = 1 and c.fin_year = :finYear group by c.crop_id, d.crop_name, seasonId  order by totSold desc";
		List<DeptTotSoldRabiDTO> obj =  (List<DeptTotSoldRabiDTO>) entityManager.createNativeQuery(sql,"DeptTotSoldRabiDTO").setParameter("finYear", finYear).getResultList();
		return obj;
	}
	
	public List<DeptTotSoldZayadDTO> getDeptSalebleCropProductionZayad(String finYear)
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_sold) as totSold from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.season_id = 3 and c.fin_year = :finYear group by c.crop_id, d.crop_name, seasonId  order by totSold desc";
		List<DeptTotSoldZayadDTO> obj =  (List<DeptTotSoldZayadDTO>) entityManager.createNativeQuery(sql,"DeptTotSoldZayadDTO").setParameter("finYear", finYear).getResultList();
		return obj;
	}
	
	public List<DeptTotSoldKharifDTO> getDeptSaleCropProductionKharif(String finYear)
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_sold) as totSold from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.season_id = 2 and c.fin_year = :finYear group by c.crop_id, d.crop_name, seasonId  order by totSold desc";
		List<DeptTotSoldKharifDTO> obj =  (List<DeptTotSoldKharifDTO>) entityManager.createNativeQuery(sql,"DeptTotSoldKharifDTO").setParameter("finYear", finYear).getResultList();
		return obj;
	}
	
	@Override
	public List<DeptDashboardReportDTO> getDepartmentDashboardReport(ReportRequestString reportRequestString) 
	{
		List<DeptDashboardReportDTO> obj = null;
		Integer distId = reportRequestString.getDistId();
		if(distId == null)
		{
			distId = 0;
		}
		Integer cropId = reportRequestString.getCropId();
		if(cropId == null)
		{
			cropId = 0;
		}
		sql = "select distinct f.fpo_name,f.fpo_address, f.fpo_landline, d.district_name, cm.id as cropId, cm.crop_name as cropName, cv.veriety_id as verietyId, cv.crop_veriety as verietyName,\r\n"
				+ "				sum(tp.total_actual_prod) as actualFpoProduction, sum(tp.total_marketable) as marketable from fpo f \r\n"
				+ "				join districts d on d.district_id =  f.dist_ref_id\r\n"
				+ "				join total_production tp on tp.fpo_id = f.fpo_id\r\n"
				+ "				join crop_master cm on cm.id = tp.crop_id\r\n"
				+ "				join crop_veriety_master cv on cv.veriety_id = tp.veriety_id";
		
		String groupBy = " group by d.district_name, cm.id, cm.crop_name, cv.veriety_id, cv.crop_veriety, f.fpo_name,f.fpo_address, f.fpo_landline";
		
		if(distId > 0 && cropId > 0)
		{
				sql = sql + " where d.district_id = :distId  and cm.id = :cropId " + groupBy;
				obj =  (List<DeptDashboardReportDTO>) entityManager.createNativeQuery(sql,"DeptDashboardReportDTO").setParameter("distId",reportRequestString.getDistId()).
						setParameter("cropId",reportRequestString.getCropId()).getResultList();
		}
		else if(distId > 0 && cropId == 0)
		{
				sql = sql + " where d.district_id = :distId " + groupBy;
				obj =  (List<DeptDashboardReportDTO>) entityManager.createNativeQuery(sql,"DeptDashboardReportDTO").setParameter("distId",reportRequestString.getDistId()).
						getResultList();
		}
		else if(distId == 0 && cropId > 0)
		{
			sql = sql + " where cm.id = :cropId " + groupBy;
			obj =  (List<DeptDashboardReportDTO>) entityManager.createNativeQuery(sql,"DeptDashboardReportDTO").setParameter("cropId",reportRequestString.getCropId()).
					getResultList();
		}
		else
		{
			sql = sql + groupBy;
			obj =  (List<DeptDashboardReportDTO>) entityManager.createNativeQuery(sql,"DeptDashboardReportDTO").getResultList();
		}
		System.out.println("Query::"+sql.toString());
		return obj;
	}
}
