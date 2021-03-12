package com.upfpo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.CropFilterDto;
import com.upfpo.app.dto.FilterDto;
import com.upfpo.app.repository.FilterRepository;
import com.upfpo.app.repository.NewFilterRepository;

@Service
public class FilterServiceImpl implements FilterService {

	@Autowired 
	private FilterRepository filterRepository;
	
	@Override
	public List<FilterDto> getDistrictFilterListBySearchKeys(String value, String in) {
		
		return filterRepository.getDistrictsByFilterKeys(value, in);
	}

	@Override
	public List<FilterDto> getFpoFilterListBySearchKeys(String value, String in) {
		
		return filterRepository.getFposByFilterKeys(value, in);
	}

	@Override
	public List<CropFilterDto> getCropFilterListBySearchKeys(String value, String in) {
		// TODO Auto-generated method stub
		return filterRepository.getCropsByFilterKeys(value, in);
	}
			
}
