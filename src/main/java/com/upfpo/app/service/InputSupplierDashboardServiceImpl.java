package com.upfpo.app.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.InputSupplierDashBoardIndentFertilizerDTO;
import com.upfpo.app.dto.InputSupplierDashBoardIndentInsecticideDTO;
import com.upfpo.app.dto.InputSupplierDashBoardIndentMachineryDTO;
import com.upfpo.app.dto.InputSupplierDashBoardIndentSeedDTO;
import com.upfpo.app.dto.InputSupplierDashBoardSeedDTO;
import com.upfpo.app.dto.InputSupplierDashboardBarchartDTO;
import com.upfpo.app.dto.InputSupplierDashboardDTO;
import com.upfpo.app.dto.InputSupplierDashboardFertilizerDTO;
import com.upfpo.app.dto.InputSupplierDashboardIndentDTO;
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
	
	@Override
	public InputSupplierDashboardIndentDTO getIndentData(Integer masterId) 
	{
		InputSupplierDashboardIndentDTO indent = new InputSupplierDashboardIndentDTO();
		sql = "select  CASE\r\n"
				+ "				 WHEN ur.role='ROLE_BUYERSELLER'  THEN  buyerSeller_name\r\n"
				+ "				 WHEN ur.role='ROLE_CHCFMB'  THEN chc_fmb_name\r\n"
				+ "				 WHEN ur.role='ROLE_INPUTSUPPLIER'  THEN input_supplier_name\r\n"
				+ "				 WHEN ur.role='ROLE_FPC'  THEN fpo_name\r\n"
				+ "				 ELSE farmer_name\r\n"
				+ "				 END as createdBy, case\r\n"
				+ "				 WHEN ur.role='ROLE_BUYERSELLER'  THEN  c.mobile_number\r\n"
				+ "				 WHEN ur.role='ROLE_CHCFMB'  THEN b.mobile_number\r\n"
				+ "				 WHEN ur.role='ROLE_INPUTSUPPLIER'  THEN e.mobile_number\r\n"
				+ "				 ELSE f.farmer_mob\r\n"
				+ "				 END as contact_details,\r\n"
				+ "				 ur.role, a.status, cm.crop_name, cv.crop_veriety as varietyName, sum(a.indent_qty) as indentQty\r\n"
				+ "				 from enquiry_input_supplier_seed a\r\n"
				+ "				 join user_roles ur on ur.role_id=a.role_ref_id\r\n"
				+ "				 left join chc_fmb b on a.user_id = b.user_id\r\n"
				+ "				 left join buyer_seller c on a.user_id=c.user_id\r\n"
				+ "				 left join input_supplier e on a.user_id=e.user_id\r\n"
				+ "				 left join fpo d on a.user_id=d.user_id\r\n"
				+ "				 left join farmer f on a.user_id=f.user_id \r\n"
				+ "				 join crop_master cm on cm.id = a.crop_id\r\n"
				+ "				 join crop_veriety_master cv on cv.veriety_id = a.veriety_id \r\n"
				+ "				 where a.master_id= :masterId group by ur.role,a.status, cm.crop_name, cv.crop_veriety,buyerSeller_name, chc_fmb_name, input_supplier_name, fpo_name,\r\n"
				+ "				 farmer_name,c.mobile_number, c.mobile_number, b.mobile_number, e.mobile_number, f.farmer_mob";
		
		List<InputSupplierDashBoardIndentSeedDTO> obj =  (List<InputSupplierDashBoardIndentSeedDTO>) entityManager.createNativeQuery(sql,"InputSupplierDashBoardIndentSeedDTO").setParameter("masterId", masterId).getResultList();
		
		sql = "select distinct  CASE\r\n"
				+ "								 WHEN ur.role='ROLE_BUYERSELLER'  THEN  buyerSeller_name\r\n"
				+ "								 WHEN ur.role='ROLE_CHCFMB'  THEN chc_fmb_name\r\n"
				+ "								 WHEN ur.role='ROLE_INPUTSUPPLIER'  THEN input_supplier_name\r\n"
				+ "								 WHEN ur.role='ROLE_FPC'  THEN fpo_name\r\n"
				+ "								 ELSE farmer_name\r\n"
				+ "								 END as createdBy, case\r\n"
				+ "								 WHEN ur.role='ROLE_BUYERSELLER'  THEN  c.mobile_number\r\n"
				+ "								 WHEN ur.role='ROLE_CHCFMB'  THEN b.mobile_number\r\n"
				+ "								 WHEN ur.role='ROLE_INPUTSUPPLIER'  THEN e.mobile_number\r\n"
				+ "								 ELSE f.farmer_mob\r\n"
				+ "								 END as contact_details,\r\n"
				+ "								 ur.role, a.status, fn.fertilizer_name, a.fertilizer_grade, sum(a.indent_qty) as indentQty, a.create_date_time\r\n"
				+ "								 from enquiry_input_supplier_fertilizer a\r\n"
				+ "								 join user_roles ur on ur.role_id=a.role_ref_id\r\n"
				+ "								 left join chc_fmb b on a.user_id = b.user_id\r\n"
				+ "								 left join buyer_seller c on a.user_id=c.user_id\r\n"
				+ "								 left join input_supplier e on a.user_id=e.user_id\r\n"
				+ "								 left join fpo d on a.user_id=d.user_id\r\n"
				+ "								 left join farmer f on a.user_id=f.user_id \r\n"
				+ "								 join fertilizer_name_master fn on fn.id = a.fertilizer_name\r\n"
				+ "								 where a.master_id= :masterId group by ur.role,a.status, \r\n"
				+ "								 fn.fertilizer_name, a.fertilizer_grade,buyerSeller_name, chc_fmb_name, input_supplier_name, fpo_name,\r\n"
				+ "								 farmer_name,c.mobile_number, c.mobile_number, b.mobile_number, e.mobile_number, f.farmer_mob, a.create_date_time";
		
		List<InputSupplierDashBoardIndentFertilizerDTO> objFertilizer =  (List<InputSupplierDashBoardIndentFertilizerDTO>) entityManager.createNativeQuery(sql,"InputSupplierDashBoardIndentFertilizerDTO").setParameter("masterId", masterId).getResultList();
		
		sql = "select distinct  CASE\r\n"
				+ "								 WHEN ur.role='ROLE_BUYERSELLER'  THEN  buyerSeller_name\r\n"
				+ "								 WHEN ur.role='ROLE_CHCFMB'  THEN chc_fmb_name\r\n"
				+ "								 WHEN ur.role='ROLE_INPUTSUPPLIER'  THEN input_supplier_name\r\n"
				+ "								 WHEN ur.role='ROLE_FPC'  THEN fpo_name\r\n"
				+ "								 ELSE farmer_name\r\n"
				+ "								 END as createdBy, case\r\n"
				+ "								 WHEN ur.role='ROLE_BUYERSELLER'  THEN  c.mobile_number\r\n"
				+ "								 WHEN ur.role='ROLE_CHCFMB'  THEN b.mobile_number\r\n"
				+ "								 WHEN ur.role='ROLE_INPUTSUPPLIER'  THEN e.mobile_number\r\n"
				+ "								 ELSE f.farmer_mob\r\n"
				+ "								 END as contact_details,\r\n"
				+ "								 ur.role, a.status, it.insecticide_type, sum(a.indent_qty) as indentQty, a.create_date_time\r\n"
				+ "								 from enquiry_input_supplier_insecticide a\r\n"
				+ "								 join user_roles ur on ur.role_id=a.role_ref_id\r\n"
				+ "								 left join chc_fmb b on a.user_id = b.user_id\r\n"
				+ "								 left join buyer_seller c on a.user_id=c.user_id\r\n"
				+ "								 left join input_supplier e on a.user_id=e.user_id\r\n"
				+ "								 left join fpo d on a.user_id=d.user_id\r\n"
				+ "								 left join farmer f on a.user_id=f.user_id \r\n"
				+ "								 join insecticide_type_master it on it.id = a.insecticide_type_id\r\n"
				+ "								 where a.master_id= :masterId group by ur.role,a.status, \r\n"
				+ "								 it.insecticide_type, buyerSeller_name, chc_fmb_name, input_supplier_name, fpo_name,\r\n"
				+ "								 farmer_name,c.mobile_number, c.mobile_number, b.mobile_number, e.mobile_number, f.farmer_mob, a.create_date_time";
		
		List<InputSupplierDashBoardIndentInsecticideDTO> objInsec =  (List<InputSupplierDashBoardIndentInsecticideDTO>) entityManager.createNativeQuery(sql,"InputSupplierDashBoardIndentInsecticideDTO").setParameter("masterId", masterId).getResultList();
		
		sql = "select distinct  CASE\r\n"
				+ "								 WHEN ur.role='ROLE_BUYERSELLER'  THEN  buyerSeller_name\r\n"
				+ "								 WHEN ur.role='ROLE_CHCFMB'  THEN chc_fmb_name\r\n"
				+ "								 WHEN ur.role='ROLE_INPUTSUPPLIER'  THEN input_supplier_name\r\n"
				+ "								 WHEN ur.role='ROLE_FPC'  THEN fpo_name\r\n"
				+ "								 ELSE farmer_name\r\n"
				+ "								 END as createdBy, case\r\n"
				+ "								 WHEN ur.role='ROLE_BUYERSELLER'  THEN  c.mobile_number\r\n"
				+ "								 WHEN ur.role='ROLE_CHCFMB'  THEN b.mobile_number\r\n"
				+ "								 WHEN ur.role='ROLE_INPUTSUPPLIER'  THEN e.mobile_number\r\n"
				+ "								 ELSE f.farmer_mob\r\n"
				+ "								 END as contact_details,\r\n"
				+ "								 ur.role, a.status, eq.equpment_name, a.no_of_days, sum(a.indent_qty) as indentQty, a.create_date_time\r\n"
				+ "								 from enquiry_input_supplier_machinery a\r\n"
				+ "								 join user_roles ur on ur.role_id=a.role_ref_id\r\n"
				+ "								 left join chc_fmb b on a.user_id = b.user_id\r\n"
				+ "								 left join buyer_seller c on a.user_id=c.user_id\r\n"
				+ "								 left join input_supplier e on a.user_id=e.user_id\r\n"
				+ "								 left join fpo d on a.user_id=d.user_id\r\n"
				+ "								 left join farmer f on a.user_id=f.user_id \r\n"
				+ "								 join equip_master eq on eq.id = a.machinery_name_id\r\n"
				+ "								 where a.master_id= :masterId group by ur.role,a.status, \r\n"
				+ "								 eq.equpment_name, a.no_of_days, buyerSeller_name, chc_fmb_name, input_supplier_name, fpo_name,\r\n"
				+ "								 farmer_name,c.mobile_number, c.mobile_number, b.mobile_number, e.mobile_number, f.farmer_mob, a.create_date_time";
		
		List<InputSupplierDashBoardIndentMachineryDTO> objMach =  (List<InputSupplierDashBoardIndentMachineryDTO>) entityManager.createNativeQuery(sql,"InputSupplierDashBoardIndentMachineryDTO").setParameter("masterId", masterId).getResultList();	
		
		indent.setSeedIndent(obj);
		indent.setFertilizerIndent(objFertilizer);
		indent.setInsecticideIndent(objInsec);
		indent.setMachineryIndent(objMach);
		return indent;
	}
}
