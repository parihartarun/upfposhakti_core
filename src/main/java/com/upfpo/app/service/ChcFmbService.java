package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.dto.ChcFmbDTO;
import com.upfpo.app.dto.ChcFmbMachineryDTO;
import com.upfpo.app.entity.ChcFmbMaster;

public interface ChcFmbService 
{
    ChcFmbDTO getChcFmbDetail(int masterId);

    List<ChcFmbMachineryDTO> getAllChcFmbMachinery(Integer masterId);

    public ChcFmbMaster updateChcFmb(ChcFmbMaster chcFmbMaster, int chcFmbId);
	public List<ChcFmbMaster> getChcFmbMaster();
	public void deleteChcFmbMaster(int chcFmbId);
}
