package com.upfpo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upfpo.app.dto.CropFilterDto;
import com.upfpo.app.dto.FilterDto;
import com.upfpo.app.entity.AgencyMaster;
import com.upfpo.app.entity.BlockMaster;
import com.upfpo.app.entity.FpoLicenceDetails;
import com.upfpo.app.entity.Panchayats;

@Service
public interface FilterService 
{
	public List<FilterDto> getDistrictFilterListBySearchKeys(String value ,String in);
	public List<FilterDto> getFpoFilterListBySearchKeys(String value ,String in);
	List<CropFilterDto> getCropFilterListBySearchKeys(String value ,String in);
	
}
