package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.dto.DepartmentAllUserDto;
import com.upfpo.app.dto.DepartmentProdReportDto;
import com.upfpo.app.dto.DepartmentSalesReportDto;
import com.upfpo.app.entity.ReasonsMaster;

public interface DepartmentService {

	List<DepartmentProdReportDto> getDepartmentProductionReport(String finYear, Integer district, Integer crop, Integer seasonref);

	List<DepartmentSalesReportDto> getDepartmentSalesReport(String finYear, Integer distId, Integer cropId, Integer seasonId);

	List<DepartmentAllUserDto> getAllUser();

	List<ReasonsMaster> getAllReasons();

	void deActivateUser(Long uid, String reason, Integer masterId);
	
	void activateUser(Long uid, Integer masterId);

}
