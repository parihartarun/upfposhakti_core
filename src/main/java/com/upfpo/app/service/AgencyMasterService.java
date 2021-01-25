package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.entity.AgencyMaster;
import com.upfpo.app.entity.BlockMaster;
import com.upfpo.app.entity.FpoLicenceDetails;
import com.upfpo.app.entity.Panchayats;

public interface AgencyMasterService 
{
	public AgencyMaster insertAgencyMaster(AgencyMaster e);
	public AgencyMaster updateAgencyMaster(int id,AgencyMaster e);
	public AgencyMaster insertOrUpdateAgencyMaster(AgencyMaster e);
	public boolean deleteAgencyMaster(int id);	
	public List<AgencyMaster> selectAgencyMaster();
	public AgencyMaster selectAgencyMasterById(int id);
}
