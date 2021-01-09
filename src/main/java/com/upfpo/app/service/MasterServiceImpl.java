package com.upfpo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dao.MasterDao;
import com.upfpo.app.entity.DashBoardData;

@Service
public class MasterServiceImpl implements MasterService{
	
	@Autowired
	private MasterDao masterDao;

	@Override
	public List<DashBoardData> homePageData() {
		
		return masterDao.homePageData();
	}

}
