package com.upfpo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.CollectionCenter;
import com.upfpo.app.repository.CollectionCenterRepository;

@Service
public class CollectionCenterServiceImpl implements CollectionCenterService {

	
	@Autowired
	private CollectionCenterRepository collectionCenterRepository; 
	
	@Override
	public CollectionCenter insertCollectionCenter(CollectionCenter e) {
		// TODO Auto-generated method stub
		return collectionCenterRepository.save(e);
	}

	@Override
	public CollectionCenter updateCollectionCenter(int id, CollectionCenter e) {
		// TODO Auto-generated method stub
		e.setId(id);
		return collectionCenterRepository.save(e);
	}

	@Override
	public CollectionCenter insertOrUpdateCollectionCenter(CollectionCenter e) {
		// TODO Auto-generated method stub
		return collectionCenterRepository.save(e);
	}

	@Override
	public boolean deleteCollectionCenter(int id) {
		// TODO Auto-generated method stub
		try {
			CollectionCenter collectionCenter = collectionCenterRepository.getOne(id);
			collectionCenter.setDeleteDate(new java.sql.Date(new java.util.Date().getTime()));
			collectionCenter.setDeleted(true);
	          return true;
		}catch(Exception e){
		      return false;	
		}
		
		
	}

	@Override
	public List<CollectionCenter> selectCollectionCenter() {
		// TODO Auto-generated method stub
		return collectionCenterRepository.findByIsDeleted(false);
	}

	@Override
	public CollectionCenter selectCollectionCenterById(int id) {
		// TODO Auto-generated method stub
		return collectionCenterRepository.getOne(id);
	}



}
