package com.upfpo.app.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.InputSupplierDashBoardSeedDTO;
import com.upfpo.app.dto.InputSupplierDashboardBarchartDTO;
import com.upfpo.app.dto.InputSupplierDashboardDTO;
import com.upfpo.app.dto.InputSupplierDashboardFertilizerDTO;
import com.upfpo.app.dto.InputSupplierDashboardMachineryDTO;

@Service
public class InputSupplierDashboardServiceImpl implements InputSupplierDashboardService
{
	@Autowired
	EntityManager entityManager;
	
	String sql = "";
	
	@Override
	public InputSupplierDashboardBarchartDTO getBarchartData(Integer masterId) 
	{
		InputSupplierDashboardBarchartDTO barChart = new InputSupplierDashboardBarchartDTO();
		
		sql = "select i.insecticide_type_id as insecticideTypeId, it.insecticide_type as insecticideType, sum(i.quantity) as quantity from input_supplier_insecticide i join insecticide_type_master it\r\n"
				+ "on i.insecticide_type_id = it.id\r\n"
				+ "where i.input_supplier_id = :masterId and i.is_deleted = false group by i.insecticide_type_id, it.insecticide_type";
		
		List<InputSupplierDashboardDTO> obj =  (List<InputSupplierDashboardDTO>) entityManager.createNativeQuery(sql,"InputSupplierDashboardDTO").setParameter("masterId", masterId).getResultList();
		
		sql = "select i.crop_id as cropId, c.crop_name as cropName, i.variety_id as varietyId, cv. crop_veriety as varietyName, sum(i.quantity) as seedQuantity from input_supplier_seed i join crop_master c on c.id = i.crop_id\r\n"
				+ "			join crop_veriety_master cv on cv.veriety_id = i.variety_id \r\n"
				+ "			where i.input_supplier_id = :masterId and i.is_deleted = false group by i.crop_id , c.crop_name , i.variety_id, cv. crop_veriety order by seedQuantity desc";
		
		List<InputSupplierDashBoardSeedDTO> objseed =  (List<InputSupplierDashBoardSeedDTO>) entityManager.createNativeQuery(sql,"InputSupplierDashBoardSeedDTO").setParameter("masterId", masterId).getResultList();
		
		sql = "select  distinct i.fertilizer_name_id as fertilizerNameId , f.fertilizer_name as fertilizerName, i.fertilizer_grade as fertilizerGrade, \r\n"
				+ "sum(i.quantity) as fertilizerQty from input_supplier_fertilizer i\r\n"
				+ "join fertilizer_name_master f on f.id = i.fertilizer_name_id \r\n"
				+ "where i.input_supplier_id = :masterId and i.is_deleted = false group by i.fertilizer_name_id, f.fertilizer_name, i.fertilizer_grade order by fertilizerQty desc";
		
		List<InputSupplierDashboardFertilizerDTO> objFertilizer =  (List<InputSupplierDashboardFertilizerDTO>) entityManager.createNativeQuery(sql,"InputSupplierDashboardFertilizerDTO").setParameter("masterId", masterId).getResultList();
		
		sql = "select i.machinery_name_id as machineryNameId, e.equpment_name as machinerytName, sum(i.quantity) as machineryQty from input_supplier_machinery i\r\n"
				+ "join equip_master e on e.id = i.machinery_name_id\r\n"
				+ "where i.input_supplier_id = :masterId and i.is_deleted = false group by i.machinery_name_id, e.equpment_name order by machineryQty desc;";
		
		List<InputSupplierDashboardMachineryDTO> objMachinery =  (List<InputSupplierDashboardMachineryDTO>) entityManager.createNativeQuery(sql,"InputSupplierDashboardMachineryDTO").setParameter("masterId", masterId).getResultList();
		
		barChart.setInsecticidesBarChart(obj);
		barChart.setSeedsBarChart(objseed);
		barChart.setFertilizerBarChart(objFertilizer);
		barChart.setMachineryBarChart(objMachinery);
		
		return barChart;
		
	}
}
