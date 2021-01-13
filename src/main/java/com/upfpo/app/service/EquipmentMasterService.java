package com.upfpo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upfpo.app.entity.EqupmentMaster;
import com.upfpo.app.entity.LicenseMaster;

@Service
public interface EquipmentMasterService {
	public EqupmentMaster insertEquipmentMaster(EqupmentMaster e);
	public EqupmentMaster updateEquipmentMaster(int id,EqupmentMaster e);
	public EqupmentMaster insertOrUpdateEquipmentMaster(EqupmentMaster e);
	public boolean deleteEquipmentMaster(int id);	
	public List<EqupmentMaster> selectEquipmentMaster();
	public EqupmentMaster selectEquipmentMasterById(int id);

}
