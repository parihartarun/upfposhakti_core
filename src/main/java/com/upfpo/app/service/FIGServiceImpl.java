package com.upfpo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.FIGRegister;
import com.upfpo.app.repository.FIGRegisterRepository;


@Service
public class FIGServiceImpl implements FIGService {

	@Autowired
	private FIGRegisterRepository figRepository;
	
	@Override
	public FIGRegister insertFig(FIGRegister e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FIGRegister updateFig(Integer id, FIGRegister e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FIGRegister insertOrUpdateFig(FIGRegister e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteFig(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FIGRegister> selectFigs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FIGRegister selectFigById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
