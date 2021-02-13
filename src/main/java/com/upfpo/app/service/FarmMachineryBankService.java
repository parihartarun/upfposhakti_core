package com.upfpo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upfpo.app.entity.EqupmentMaster;
import com.upfpo.app.entity.FarmMachineryBank;
import com.upfpo.app.entity.LicenseMaster;

@Service
public interface FarmMachineryBankService {
	public FarmMachineryBank insertFarmMachineryBank(FarmMachineryBank e);
	public FarmMachineryBank updateFarmMachineryBank(int id,FarmMachineryBank e);
	public FarmMachineryBank insertOrUpdateFarmMachineryBank(FarmMachineryBank e);
	public boolean deleteFarmMachineryBank(int id);	
	public List<FarmMachineryBank> selectFarmMachineryBank();
	public FarmMachineryBank selectFarmMachineryBankById(int id);
	public List<FarmMachineryBank> selectFarmMachineryBankByFpo(Integer masterId);

}
