package com.upfpo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upfpo.app.entity.FPORegister;

@Service
public interface FPOService {

	public FPORegister insertFpo(FPORegister e);
	public FPORegister updateFpo(Integer id,FPORegister e);
	public FPORegister insertOrUpdateFpo(FPORegister e);
	public Boolean deleteFpo(Integer id);
	public List<FPORegister> selectFpos();
	public FPORegister selectFpoById(Integer id);
}
