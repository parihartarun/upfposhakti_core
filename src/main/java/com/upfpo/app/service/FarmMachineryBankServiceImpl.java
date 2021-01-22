package com.upfpo.app.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.DistrictMaster;
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
	public FarmMachineryBank  updateFarmMachineryBank(int id, FarmMachineryBank farmMachineryBank) {
		// TODO Auto-generated method stub
//		farmMachineryBank.setId(id);
//		farmMachineryBank.setDeleted(false);
//		return farmMachineryBankRepository.save(e);
		
		Optional<FarmMachineryBank> farmMachinery = farmMachineryBankRepository.findById(id);
		if(farmMachinery.isPresent())
		{
			FarmMachineryBank machinery = farmMachinery.get();
			//machinery.setId(farmMachineryBank.getId());
			machinery.setEqupment_name(farmMachineryBank.getEqupment_name());
			machinery.setEqupment_no(farmMachineryBank.getEqupment_no());
			machinery.setEqupmnet_capacity(farmMachineryBank.getEqupmnet_capacity());
			machinery.setFpoRefId(farmMachineryBank.getFpoRefId());
			machinery.setMasterId(farmMachineryBank.getMasterId());
			machinery.setDeleted(false);
			machinery.setUpdateDate(new java.sql.Date(new java.util.Date().getTime()));
			machinery.setMasterId(farmMachineryBank.getMasterId());
			machinery = farmMachineryBankRepository.save(machinery);
			return machinery;
		}
		else
		{
			farmMachineryBank = farmMachineryBankRepository.save(farmMachineryBank);
			return farmMachineryBank;
		}
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

//	@Override
//	public FarmMachineryBank selectFarmMachineryBankById(int id) {
//		// TODO Auto-generated method stub
//		try {
//			FarmMachineryBank ss = farmMachineryBankRepository.getOne(id);
//			System.err.println("@@@@@@@@@@ "+ss.getEqupment_name());
//		return farmMachineryBankRepository.getOne(id);
//		}catch(Exception e)
//		{
//			throw new NotFoundException();
//		}
//	}

	@Override
	public FarmMachineryBank selectFarmMachineryBankById(int id) {
		{
			return farmMachineryBankRepository.findById(id).get();
		}

	}



}
