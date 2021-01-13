package com.upfpo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upfpo.app.entity.EqupmentMaster;

@Service
public interface EquipmentMasterService {
	public EqupmentMaster insertEqupmentMaster(EqupmentMaster e);
	public EqupmentMaster updateEqupmentMaster(int id,EqupmentMaster e);
	public EqupmentMaster insertOrUpdateEqupmentMaster(EqupmentMaster e);
	public boolean deleteEqupmentMaster(int id);	
	public List<EqupmentMaster> selectEqupmentMasters();
	public EqupmentMaster selectEqupmentMasterById(int id);
	public List<EqupmentMaster> selectEqupmentMasterByCriteria(EqupmentMaster employee);
}
