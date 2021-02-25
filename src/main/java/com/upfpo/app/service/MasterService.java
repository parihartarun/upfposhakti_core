package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.dto.DisplayDataDTO;
import com.upfpo.app.dto.FPODetailsDTO;
import com.upfpo.app.dto.ProductionDTO;
import com.upfpo.app.dto.SearchPagePagableDto;
import com.upfpo.app.dto.SearchResponseDto;

public interface MasterService {
	
	
	   public DisplayDataDTO farmers();
	   public ProductionDTO productions(String finYear);
	   public List<FPODetailsDTO> homeSearch(String searchVal, String searchIn);
	   public List<FPODetailsDTO> homeSearch(String searchVal, String searchIn,List<String> fileterdistricts,List<Integer> fileterqty,List<String> crops,List<String> fpos);
	   public SearchPagePagableDto newHomeSearch(String searchVal, String searchIn,List<Integer> fileterdistricts,List<Integer> fileterqty,List<Integer> crops,List<Integer> fpos);

}
