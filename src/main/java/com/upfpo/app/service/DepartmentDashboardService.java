package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.dto.DataDisplayDto;

public interface DepartmentDashboardService 
{
	public List<DataDisplayDto> getProdZayad(String finYear);
}
