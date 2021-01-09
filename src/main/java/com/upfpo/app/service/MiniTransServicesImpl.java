package com.upfpo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dao.MiniTransDao;
import com.upfpo.app.entity.Circulars;

@Service
public class MiniTransServicesImpl implements MiniTransServices{
	
	@Autowired
	private MiniTransDao miniTransDao;

	@Override
	public List<Circulars> getCirculars() {
		return miniTransDao.getCirculars();
	}
	
	

}
