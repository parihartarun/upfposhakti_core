package com.upfpo.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.DisplayDataDTO;
import com.upfpo.app.dto.FPODetailsDTO;
import com.upfpo.app.dto.ProductionDTO;
import com.upfpo.app.dto.CropSearchPagePagableDto;
import com.upfpo.app.dto.SearchRequestDto;
import com.upfpo.app.dto.SearchResponseDto;

@Service
public interface MasterService {
	
	
	   public DisplayDataDTO farmers();
	   public ProductionDTO productions(String finYear);
	   public List<FPODetailsDTO> homeSearch(String searchVal, String searchIn);
	   public List<FPODetailsDTO> homeSearch(String searchVal, String searchIn,List<String> fileterdistricts,List<Integer> fileterqty,List<String> crops,List<String> fpos);
	   public CropSearchPagePagableDto newHomeSearch(SearchRequestDto searchRequestDto);
	
	  
}
