package com.upfpo.app.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.upfpo.app.dao.MasterDao;
import com.upfpo.app.dto.DisplayDataDTO;
import com.upfpo.app.entity.DashBoardData;
import com.upfpo.app.repository.DataDisplayRepository;

@Service
public class MasterServiceImpl implements MasterService{
	
	@Autowired
	private MasterDao masterDao;
	
	@Resource
	private DataDisplayRepository dataDisplayRepository;

	@Override
	public List<DashBoardData> homePageData() {
		
		return masterDao.homePageData();
	}

	@Override
	public List<Object> farmers() {
		
		return dataDisplayRepository.homePageData();
	}

}
