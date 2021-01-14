package com.upfpo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.EqupmentMaster;
import com.upfpo.app.entity.LicenseMaster;
import com.upfpo.app.repository.EquipmentMasterRepository;
import com.upfpo.app.repository.LicenseMasterRepository;

@Service
public class EquipmentMasterServiceImpl implements EquipmentMasterService {

	
	@Autowired
	private EquipmentMasterRepository equipmentMasterRepository; 
	
	@Override
	public EqupmentMaster insertEquipmentMaster(EqupmentMaster e) {
		// TODO Auto-generated method stub
		
		e.setDeleted(false);
		return equipmentMasterRepository.save(e);
	}

	@Override
	public EqupmentMaster  updateEquipmentMaster(int id, EqupmentMaster e) {
		// TODO Auto-generated method stub
		e.setId(id);
		e.setDeleted(false);
		return equipmentMasterRepository.save(e);
	}

	@Override
	public EqupmentMaster insertOrUpdateEquipmentMaster(EqupmentMaster e) {
		// TODO Auto-generated method stub
		e.setDeleted(false);
		return equipmentMasterRepository.save(e);
	}

	@Override
	public boolean deleteEquipmentMaster(int id) {
		// TODO Auto-generated method stub
		try {
			EqupmentMaster equpmentMaster = equipmentMasterRepository.getOne(id);
			equpmentMaster.setDeleteDate(new java.sql.Date(new java.util.Date().getTime()));
			equpmentMaster.setDeleted(true);
			equipmentMasterRepository.save(equpmentMaster);
	          return true;
		}catch(Exception e){
		      return false;	
		}
		
		
	}

	@Override
	public List<EqupmentMaster> selectEquipmentMaster() {
		// TODO Auto-generated method stub
		return equipmentMasterRepository.findByIsDeleted(false);
	}

	@Override
	public EqupmentMaster selectEquipmentMasterById(int id) {
		// TODO Auto-generated method stub
		try {
		return equipmentMasterRepository.getOne(id);
		}catch(Exception e)
		{
			throw new NotFoundException();
		}
		}



}
