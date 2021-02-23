package com.upfpo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upfpo.app.dto.DistrictFilterDto;
import com.upfpo.app.entity.AgencyMaster;
import com.upfpo.app.entity.BlockMaster;
import com.upfpo.app.entity.FpoLicenceDetails;
import com.upfpo.app.entity.Panchayats;

@Service
public interface FilterService 
{
	public List<DistrictFilterDto> getDistrictFilterListBySearchKeys(String value ,String in);
}
