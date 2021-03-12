package com.upfpo.app.service;

import com.upfpo.app.dto.InputSupplierDashboardBarchartDTO;
import com.upfpo.app.dto.InputSupplierDashboardIndentDTO;

public interface InputSupplierDashboardService 
{
	public InputSupplierDashboardBarchartDTO getBarchartData(Integer masterId);
	
	public InputSupplierDashboardIndentDTO getIndentData(Integer masterId);
}
