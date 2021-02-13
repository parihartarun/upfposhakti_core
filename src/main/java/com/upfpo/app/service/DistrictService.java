package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.dto.MasterDataDto;
import com.upfpo.app.entity.DistrictMaster;

public interface DistrictService 
{
	public List<MasterDataDto> getDistricts();
	public DistrictMaster getDistrictsById(int distId);
	public List<DistrictMaster> getDistrictsByStateId(int state_id);
}
