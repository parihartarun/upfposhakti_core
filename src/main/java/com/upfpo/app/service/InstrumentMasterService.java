package com.upfpo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upfpo.app.entity.InstrumentMaster;

@Service
public interface InstrumentMasterService {
	public InstrumentMaster insertInstrumentMaster(InstrumentMaster e);
	public InstrumentMaster updateInstrumentMaster(int id,InstrumentMaster e);
	public InstrumentMaster insertOrUpdateInstrumentMaster(InstrumentMaster e);
	public boolean deleteInstrumentMaster(int id);	
	public List<InstrumentMaster> selectInstrumentMasters();
	public InstrumentMaster selectInstrumentMasterById(int id);
	public List<InstrumentMaster> selectInstrumentMasterByCriteria(InstrumentMaster employee);
}
