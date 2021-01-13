package com.upfpo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upfpo.app.entity.SPRegister;




@Service
public interface SPService {

	public SPRegister insertSp(SPRegister e);
	public SPRegister updateSp(Integer id,SPRegister e);
	public SPRegister insertOrUpdateSp(SPRegister e);
	public Boolean deleteSp(Integer id);
	public List<SPRegister> selectSps();
	public SPRegister selectSpById(Integer id);
}
