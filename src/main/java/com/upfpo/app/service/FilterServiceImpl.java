package com.upfpo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.DistrictFilterDto;
import com.upfpo.app.repository.FilterRepository;

@Service
public class FilterServiceImpl implements FilterService {

	@Autowired 
	private FilterRepository filterRepository;
	
	@Override
	public List<DistrictFilterDto> getDistrictFilterListBySearchKeys(String value, String in) {
		
		return filterRepository.getDistrictsByFilterKeys(value, in);
	}

}
