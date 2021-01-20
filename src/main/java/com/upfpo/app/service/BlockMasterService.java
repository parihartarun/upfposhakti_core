package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.entity.BlockMaster;
import com.upfpo.app.entity.Panchayats;

public interface BlockMasterService 
{
	public List<BlockMaster> getBlocks();
	public List<BlockMaster> getBlockByDistrictId(int distId);
}
