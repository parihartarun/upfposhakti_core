package com.upfpo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.configuration.exception.AlreadyExistsException;
import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.repository.FPORegisterRepository;

@Service
public class FPOServiceImpl implements FPOService {

	@Autowired
	private FPORegisterRepository fpoRepository;
	
	@Override
	public FPORegister insertFpo(FPORegister e) {
		// TODO Auto-generated method stub
		e.setDeleted(false);
		return fpoRepository.save(e);
	}

	@Override
	public FPORegister updateFpo(Integer id, FPORegister e) {
		// TODO Auto-generated method stub
		if(!fpoRepository.existsById(id))
		{
			e.setDeleted(false);
			e.setFpoId(id);
			return fpoRepository.save(e);
		}else {
	throw new AlreadyExistsException();
		}
		 
	}

	@Override
	public FPORegister insertOrUpdateFpo(FPORegister e) {
		// TODO Auto-generated method stub
		e.setDeleted(false);
		return fpoRepository.save(e);
	}

	@Override
	public Boolean deleteFpo(Integer id) {
		// TODO Auto-generated method stub
		try {
		FPORegister fpoRegister = fpoRepository.getOne(id);
		fpoRegister.setDeleted(true);
		fpoRepository.save(fpoRegister);
		return true;
		}catch(Exception e)
		{
			throw new NotFoundException();
		}
	}

	@Override
	public List<FPORegister> selectFpos() {
		// TODO Auto-generated method stub
		return fpoRepository.findByIsDeleted(false);
	}

	@Override
	public FPORegister selectFpoById(Integer id) {
		// TODO Auto-generated method stub
		try {
		return fpoRepository.findById(id).get();
		}catch(Exception e)
		{
			throw new NotFoundException();
		}
		}

	@Override
	public FPORegister selectFpoByUserName(String username) {
		// TODO Auto-generated method stub
		try {
			return fpoRepository.findByUserName(username).get();
			}catch(Exception e)
			{
				throw new NotFoundException();
			}
	}

}
