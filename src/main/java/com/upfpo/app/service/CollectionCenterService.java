package com.upfpo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upfpo.app.dto.CollectionCenterDTO;
import com.upfpo.app.entity.CollectionCenter;

@Service
public interface CollectionCenterService {
	public CollectionCenter insertCollectionCenter(CollectionCenter e);
	public CollectionCenter updateCollectionCenter(int id,CollectionCenter e);
	public CollectionCenter insertOrUpdateCollectionCenter(CollectionCenter e);
	public boolean deleteCollectionCenter(int id);	
	public List<CollectionCenter> selectCollectionCenter();
	public CollectionCenter selectCollectionCenterById(int id);
	public List<CollectionCenter> selectCollectionCenterByFpoId(Integer id);
	public List<CollectionCenterDTO> selectCollectionCenterData(Integer id);

}
