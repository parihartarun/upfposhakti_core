package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.entity.Panchayats;

public interface PanchayatMasterService 
{
	public List<Panchayats> getPanchayats();
	public List<Panchayats> getPanchayatByBlockId(int blockRef);
}
