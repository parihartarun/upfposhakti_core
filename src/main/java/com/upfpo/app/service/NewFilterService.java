package com.upfpo.app.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.upfpo.app.dto.CropFilterDto;
import com.upfpo.app.dto.FilterDto;
import com.upfpo.app.dto.ListOnDistrictSearchDTO;
import com.upfpo.app.entity.AgencyMaster;
import com.upfpo.app.entity.BlockMaster;
import com.upfpo.app.entity.FpoLicenceDetails;
import com.upfpo.app.entity.Panchayats;

@Service
public interface NewFilterService 
{
	public List<FilterDto> getDistrictFilterListBySearchKeys(String value ,String in);
	public List<FilterDto> getFpoFilterListBySearchKeys(String value ,String in);
	public List<FilterDto> geChcFmbFilterListBySearchKeys(String value ,String in);
	public List<CropFilterDto> getCropFilterListBySearchKeys(String value ,String in);
	public List<FilterDto> getInputSuppliersByFilterKeys(String value, String in);
	public List<FilterDto> getFertilizerTypesByFilterKeys(String val,String in);
	List<String> getCategoriesByFilterKeys(String value, String in);
	List<String> getMachineryBrandsByFilterKeys(String val,String in);
	public List<FilterDto> getMachineryTypesByFilterKeys(String val,String in);
	public Double getMaxQuantityByFilterKeys(String val,String in);
	public Double getMaxRentByFilterKeys(String val,String in);
	public ListOnDistrictSearchDTO getListOnDistrict(String val,String in);
}
