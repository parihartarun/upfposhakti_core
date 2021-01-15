package com.upfpo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.EqupmentMaster;
import com.upfpo.app.entity.FarmMachineryBank;
import com.upfpo.app.entity.LicenseMaster;
import com.upfpo.app.repository.EquipmentMasterRepository;
import com.upfpo.app.repository.FarmMachineryBankRepository;
import com.upfpo.app.repository.LicenseMasterRepository;

@Service
public class FarmMachineryBankServiceImpl implements FarmMachineryBankService {

	
	@Autowired
	private FarmMachineryBankRepository farmMachineryBankRepository; 
	
	@Override
	public FarmMachineryBank insertFarmMachineryBank(FarmMachineryBank e) {
		// TODO Auto-generated method stub
		
		e.setDeleted(false);
		return farmMachineryBankRepository.save(e);
	}

	@Override
	public FarmMachineryBank  updateFarmMachineryBank(int id, FarmMachineryBank e) {
		// TODO Auto-generated method stub
		e.setId(id);
		e.setDeleted(false);
		return farmMachineryBankRepository.save(e);
	}

	@Override
	public FarmMachineryBank insertOrUpdateFarmMachineryBank(FarmMachineryBank e) {
		// TODO Auto-generated method stub
		e.setDeleted(false);
		return farmMachineryBankRepository.save(e);
	}

	@Override
	public boolean deleteFarmMachineryBank(int id) {
		// TODO Auto-generated method stub
		try {
			FarmMachineryBank farmMachineryBank = farmMachineryBankRepository.getOne(id);
			farmMachineryBank.setDeleteDate(new java.sql.Date(new java.util.Date().getTime()));
			farmMachineryBank.setDeleted(true);
			farmMachineryBankRepository.save(farmMachineryBank);
	          return true;
		}catch(Exception e){
		      return false;	
		}
		
		
	}

	@Override
	public List<FarmMachineryBank> selectFarmMachineryBank() {
		// TODO Auto-generated method stub
		return farmMachineryBankRepository.findByIsDeleted(false);
	}

	@Override
	public FarmMachineryBank selectFarmMachineryBankById(int id) {
		// TODO Auto-generated method stub
		try {
		return farmMachineryBankRepository.getOne(id);
		}catch(Exception e)
		{
			throw new NotFoundException();
		}
		}



}
