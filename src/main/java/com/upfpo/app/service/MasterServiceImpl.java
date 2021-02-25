package com.upfpo.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.upfpo.app.dto.DisplayDataDTO;
import com.upfpo.app.dto.FPODetailsDTO;
import com.upfpo.app.dto.ProductionDTO;
import com.upfpo.app.dto.SearchPagePagableDto;
import com.upfpo.app.dto.SearchResponseDto;
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

	@Override
	public List<FPODetailsDTO> homeSearch(String searchVal, String searchIn, List<String> fileterdistricts,
			List<Integer> fileterqty,List<String> filtercrops,List<String> fpos) {
		// TODO Auto-generated method stub
		
		if(fileterdistricts==null&&fileterqty==null&&filtercrops==null&&fpos==null)
		{
			return dataDisplayRepository.homeSearch(searchVal,searchIn);			
		}else
		{
			return dataDisplayRepository.homeSearch(searchVal,searchIn,fileterdistricts,fileterqty,filtercrops,fpos);
		}

	}
	
	@Override
	public SearchPagePagableDto newHomeSearch(Integer limit,Integer page,String searchVal, String searchIn, List<Integer> fileterdistricts,
			List<Integer> fileterqty,List<Integer> filtercropsverieties,List<Integer> filtercrops,List<Integer> fpos) {
		// TODO Auto-generated method stub
		
				return dataDisplayRepository.newHomeSearch(limit,page,searchVal,searchIn, fileterdistricts,fileterqty,filtercropsverieties,filtercrops,fpos);			
	

	}

}
