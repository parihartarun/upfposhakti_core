package com.upfpo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upfpo.app.entity.FIGRegister;

@Service
public interface FIGService {

	public FIGRegister insertFig(FIGRegister e);
	public FIGRegister updateFig(Integer id,FIGRegister e);
	public FIGRegister insertOrUpdateFig(FIGRegister e);
	public Boolean deleteFig(Integer id);
	public List<FIGRegister> selectFigs();
	public FIGRegister selectFigById(Integer id);
}
