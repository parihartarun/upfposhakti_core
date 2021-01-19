package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.entity.VillageMaster;

public interface VillageMasterService 
{
	public List<VillageMaster> getVillages();
	public List<VillageMaster> getVillagesByPanchayat(int panchayatId);
	public List<VillageMaster> getVillagesByBlockId(int blockId);
}
