package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.entity.ChcFmbMaster;

public interface ChcFmbService 
{
	public ChcFmbMaster updateChcFmb(ChcFmbMaster chcFmbMaster,int chcFmbId);
	public List<ChcFmbMaster> getChcFmbMaster();
	public void deleteChcFmbMaster(int chcFmbId);
}
