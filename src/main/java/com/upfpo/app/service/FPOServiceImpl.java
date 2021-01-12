package com.upfpo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.repository.FPORegisterRepository;

@Service
public class FPOServiceImpl implements FPOService {

	@Autowired
	private FPORegisterRepository fpoRepository;
	
	@Override
	public FPORegister insertFpo(FPORegister e) {
		// TODO Auto-generated method stub
		return fpoRepository.save(e);
	}

	@Override
	public FPORegister updateFpo(Integer id, FPORegister e) {
		// TODO Auto-generated method stub
		if(fpoRepository.existsById(id))
		{
			return fpoRepository.save(null);
		}else {
			return null;	
		}
		 
	}

	@Override
	public FPORegister insertOrUpdateFpo(FPORegister e) {
		// TODO Auto-generated method stub
		return fpoRepository.save(e);
	}

	@Override
	public Boolean deleteFpo(Integer id) {
		// TODO Auto-generated method stub
		 fpoRepository.deleteById(id);
		return true;
	}

	@Override
	public List<FPORegister> selectFpos() {
		// TODO Auto-generated method stub
		return fpoRepository.findAll();
	}

	@Override
	public FPORegister selectFpoById(Integer id) {
		// TODO Auto-generated method stub
		return fpoRepository.findById(id).get();
	}

}
