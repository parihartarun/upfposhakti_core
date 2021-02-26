package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.dto.DepartmentDashboardDTO;
import com.upfpo.app.dto.DeptDashboardReportDTO;
import com.upfpo.app.requestStrings.ReportRequestString;

public interface DepartmentDashboardService 
{
	public DepartmentDashboardDTO getDepartmentDashboardData();
	
	public List<DeptDashboardReportDTO> getDepartmentDashboardReport(ReportRequestString reportRequestString); 
}
