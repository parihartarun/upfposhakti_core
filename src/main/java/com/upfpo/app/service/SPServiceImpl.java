package com.upfpo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.SPRegister;
import com.upfpo.app.repository.SPRegisterRepository;

@Service
public class SPServiceImpl implements SPService {

	
	@Autowired
	private SPRegisterRepository spRepository;
	@Override
	public SPRegister insertSp(SPRegister e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SPRegister updateSp(Integer id, SPRegister e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SPRegister insertOrUpdateSp(SPRegister e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteSp(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SPRegister> selectSps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SPRegister selectSpById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
