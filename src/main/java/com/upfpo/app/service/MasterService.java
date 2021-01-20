package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.dto.DisplayDataDTO;
import com.upfpo.app.dto.FPODetailsDTO;
import com.upfpo.app.dto.ProductionDTO;

public interface MasterService {
	
	
	   public DisplayDataDTO farmers();
	   public ProductionDTO productions(String finYear);
	   public List<FPODetailsDTO> homeSearch(String searchVal, String searchIn);
	 
}
