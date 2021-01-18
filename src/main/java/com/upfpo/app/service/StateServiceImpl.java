package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.StateMaster;
import com.upfpo.app.repository.StateMasterRepository;

@Service
public class StateServiceImpl implements StateService
{
	@Autowired
	StateMasterRepository stateMasterRepository;
	
	@Override
	public List<StateMaster> getStates() 
	{
		List<StateMaster> stateList = new ArrayList<StateMaster>();
		stateMasterRepository.findAll().forEach(stateList1->stateList.add(stateList1));
		return stateList;
	}
}
