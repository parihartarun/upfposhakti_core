package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.BlockMaster;
import com.upfpo.app.repository.BlockMasterRepository;

@Service
public class BlockMasterServiceImpl implements BlockMasterService
{
	@Autowired
	BlockMasterRepository blockRepository;
	
	@Override
	public List<BlockMaster> getBlocks() 
	{
		List<BlockMaster> blockList = new ArrayList<BlockMaster>();
		//blockRepository.findAll().forEach(blockList1->blockList.add(blockList1));
		blockRepository.findAllByOrderByBlockNameAsc().forEach(blockList1->blockList.add(blockList1));
		return blockList;
	}
	
	@Override
	public List<BlockMaster> getBlockByDistrictId(int distId) 
	{
		return blockRepository.getPanchayatByBlockId(distId);
	}
}
