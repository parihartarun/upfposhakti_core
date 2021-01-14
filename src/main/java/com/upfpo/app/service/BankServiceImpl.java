package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.BankMaster;
import com.upfpo.app.repository.BankMasterRepository;

@Service
public class BankServiceImpl implements BankService
{
	@Autowired
	BankMasterRepository bankMasterRepository;
	
	@Override
	public List<BankMaster> getBanks() 
	{
		List<BankMaster> bankList = new ArrayList<BankMaster>();
		bankMasterRepository.findAll().forEach(bankList1->bankList.add(bankList1));
		return bankList;
	}
}
