package com.upfpo.app.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.CHCFMBDashboardBarchartDTO;
import com.upfpo.app.dto.CHCFMBDashboardIndentDTO;
import com.upfpo.app.dto.InputSupplierDashBoardIndentMachineryDTO;
import com.upfpo.app.dto.InputSupplierDashboardMachineryDTO;

@Service
public class CHCFMBDashboardServiceImpl implements CHCFMBDashboardService
{
	@Autowired
	EntityManager entityManager;
	
	String sql = "";
	
	@Override
	public CHCFMBDashboardBarchartDTO getBarchartData(Integer masterId) 
	{
		CHCFMBDashboardBarchartDTO barChart = new CHCFMBDashboardBarchartDTO();
		
		sql = "select i.equipment_name_id as machineryNameId, e.equpment_name as machinerytName, sum(i.quantity_avail) as machineryQty from chc_fmb_machinery i\r\n"
				+ "				join equip_master e on e.id = i.equipment_name_id\r\n"
				+ "				where i.chc_fmb_id = :masterId and i.is_deleted = false group by i.equipment_name_id, e.equpment_name order by machineryQty desc";
		
		List<InputSupplierDashboardMachineryDTO> objMachinery =  (List<InputSupplierDashboardMachineryDTO>) entityManager.createNativeQuery(sql,"InputSupplierDashboardMachineryDTO").setParameter("masterId", masterId).getResultList();
		barChart.setMachineryBarChart(objMachinery);
		return barChart;
	}
	
	@Override
	public CHCFMBDashboardIndentDTO getIndentData(Integer masterId) 
	{
		CHCFMBDashboardIndentDTO indent = new CHCFMBDashboardIndentDTO();
		
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
				+ "								 from enquiry_chc_fmb_machinery a\r\n"
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
		
		indent.setMachineryIndent(objMach);
		return indent;
	}
}
