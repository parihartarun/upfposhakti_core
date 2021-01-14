package com.upfpo.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.upfpo.app.entity.FarmerRegister;
import com.upfpo.app.repository.FarmerRegisterRepo;
import com.upfpo.app.util.GetCurrentDate;

@Service
public class FarmerServicesImpl implements FarmerServices{
	
	@Resource
	private FarmerRegisterRepo farmerRegisterRepo;

	@Override
	public FarmerRegister addFarmer(FarmerRegister farmerRegister) {
		return farmerRegisterRepo.save(farmerRegister);
	}

	@Override
	public List<FarmerRegister> getAllFarmers() {
		return farmerRegisterRepo.findAll();
	}

	@Override
	public FarmerRegister getFarmerById(Integer id) {
		return farmerRegisterRepo.findById(id).get();
	}

	@Override
	public FarmerRegister deleteFarmerById(Integer id) {
		FarmerRegister fr =  farmerRegisterRepo.findById(id).get();
		fr.setDeleted(true);
		fr.setDeleteDate(GetCurrentDate.getDate());
		farmerRegisterRepo.save(fr);
		
		return fr;
	}

}
