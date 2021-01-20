package com.upfpo.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upfpo.app.dto.DisplayDataDTO;
import com.upfpo.app.dto.FPODetailsDTO;
import com.upfpo.app.dto.ProductionDTO;
import com.upfpo.app.repository.DataDisplayRepository;

@Service
public class MasterServiceImpl implements MasterService {
	
	@Resource
	private DataDisplayRepository dataDisplayRepository;

	public DisplayDataDTO farmers() {
		
		return dataDisplayRepository.farmersData();
	}

	@Override
	public ProductionDTO productions(String finYear) {
		return dataDisplayRepository.productions(finYear);
	}

	@Override
	public List<FPODetailsDTO> homeSearch(String searchVal, String searchIn) {
		
		return dataDisplayRepository.homeSearch(searchVal,searchIn);
	}

}
