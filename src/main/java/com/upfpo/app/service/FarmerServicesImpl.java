package com.upfpo.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import com.upfpo.app.entity.FPOSalesDetails;
import com.upfpo.app.entity.FarmerRegister;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


	@Override
	public List<FarmerRegister> getAllFarmerList() {

		return farmerRegisterRepo.findAll();
	}

	@Override
	public Optional<FarmerRegister> getFarmerDetailById(Integer id) {
		if(!farmerRegisterRepo.existsById(id)) {
			return null;
		}
		return farmerRegisterRepo.findById(id);
	}

	@Override
	public FarmerRegister updateFarmerDetails(Integer id, FarmerRegister farmerRegister) {
		Optional<FarmerRegister> sd = farmerRegisterRepo.findById(id);
		if(!sd.isPresent()) {
			return null;
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		farmerRegister.setUpdateDate(Calendar.getInstance().getTime());
		farmerRegister.setUpdatedBy(currentPrincipalName);
		farmerRegister.setDeleted(false);

		return farmerRegisterRepo.save(farmerRegister);
	}




}
