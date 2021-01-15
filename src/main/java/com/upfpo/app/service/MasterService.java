package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.dto.DisplayDataDTO;
import com.upfpo.app.entity.DashBoardData;

public interface MasterService {
	
	public List<DashBoardData> homePageData();
	public List<Object> farmers();

}
