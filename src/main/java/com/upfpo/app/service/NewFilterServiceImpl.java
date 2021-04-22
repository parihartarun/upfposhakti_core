package com.upfpo.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.CropFilterDto;
import com.upfpo.app.dto.FilterDto;
import com.upfpo.app.dto.ListOnDistrictSearchDTO;
import com.upfpo.app.repository.FilterRepository;
import com.upfpo.app.repository.NewFilterRepository;

@Service
public class NewFilterServiceImpl implements NewFilterService {

	@Autowired 
	private NewFilterRepository filterRepository;
	
	@Override
	public List<FilterDto> getDistrictFilterListBySearchKeys(String value, String in) {
		
		return filterRepository.getDistrictsByFilterKeys(value, in);
	}

	@Override
	public List<FilterDto> getFpoFilterListBySearchKeys(String value, String in) {
		
		return filterRepository.getFposByFilterKeys(value, in);
	}
	
	@Override
	public List<FilterDto> geChcFmbFilterListBySearchKeys(String value, String in) {
		return filterRepository.getChcFmbByFilterKeys(value, in);
	}

	@Override
	public List<CropFilterDto> getCropFilterListBySearchKeys(String value, String in) {
		// TODO Auto-generated method stub
		return filterRepository.getCropsByFilterKeys(value, in);
	}
	
	@Override
	public List<FilterDto> getInputSuppliersByFilterKeys(String value, String in) {
		// TODO Auto-generated method stub
		return filterRepository.getInputSuppliersByFilterKeys(value,in);
	}
	
	@Override
	public List<FilterDto> getFertilizerTypesByFilterKeys(String value, String in) {
		// TODO Auto-generated method stub
		return filterRepository.getFertilizerTypesByFilterKeys(value,in);
	}
	
	
	@Override
	public List<String> getCategoriesByFilterKeys(String value, String in) {
		// TODO Auto-generated method stub
		return filterRepository.getCategoriesByFilterKeys(value,in);
	}
	
	@Override
	public List<String> getMachineryBrandsByFilterKeys(String val,String in) {
		// TODO Auto-generated method stub
		return filterRepository.getMachineryBrandsByFilterKeys(val, in);
	}
	
	@Override
	public List<FilterDto> getMachineryTypesByFilterKeys(String val,String in) {
		// TODO Auto-generated method stub
		return filterRepository.getMachineryTypesByFilterKeys(val, in);
	}
	@Override
	public Double getMaxQuantityByFilterKeys(String val,String in) {
		// TODO Auto-generated method stub
		return filterRepository.getMaxQuantityByFilterKeys(val, in);
	}
	
	@Override
	public Double getMaxRentByFilterKeys(String val,String in) {
		// TODO Auto-generated method stub
		return filterRepository.getMaxRentByFilterKeys(val, in);
	}
	
	@Override
	public ListOnDistrictSearchDTO getListOnDistrict(String val, String in) 
	{
		return filterRepository.getListOnDistrictSearch(val, in);
	}
	
}