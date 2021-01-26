package com.upfpo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.CollectionCenter;
import com.upfpo.app.entity.DistrictMaster;
import com.upfpo.app.repository.CollectionCenterRepository;
import com.upfpo.app.repository.DistrictMasterRepository;

@Service
public class CollectionCenterServiceImpl implements CollectionCenterService {

	
	@Autowired
	private CollectionCenterRepository collectionCenterRepository; 
	
	@Autowired
	private DistrictMasterRepository districtRepository;
	
	@Override
	public CollectionCenter insertCollectionCenter(CollectionCenter e) {
		// TODO Auto-generated method stub
		//DistrictMaster district = districtRepository.findById(e.getDistId()).get();
		e.setUpdatedBy("admin");
		e.setStateId(6);
		//e.setDistId(6);
		e.setDeleted(false);
		return collectionCenterRepository.save(e);
	}

	@Override
	public CollectionCenter updateCollectionCenter(int id, CollectionCenter e) {
		// TODO Auto-generated method stub
		e.setId(id);
	    DistrictMaster district = districtRepository.findById(e.getDistId()).get();
		
		e.setStateId(district.getState_id());
		e.setDeleted(false);
		return collectionCenterRepository.save(e);
	}

	@Override
	public CollectionCenter insertOrUpdateCollectionCenter(CollectionCenter e) {
		// TODO Auto-generated method stub
		e.setDeleted(false);
		return collectionCenterRepository.save(e);
	}

	@Override
	public boolean deleteCollectionCenter(int id) {
		// TODO Auto-generated method stub
		try {
			CollectionCenter collectionCenter = collectionCenterRepository.findById(id).get();
			collectionCenter.setDeleteDate(new java.sql.Date(new java.util.Date().getTime()));
			collectionCenter.setDeleted(true);
			collectionCenterRepository.save(collectionCenter);
	          return true;
		}catch(Exception e){
			e.printStackTrace();
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
		try {
		return collectionCenterRepository.findById(id).get();
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new NotFoundException();
		}
		}

	@Override
	public List<CollectionCenter> selectCollectionCenterByFpoId(Integer id) {
		// TODO Auto-generated method stub
		return collectionCenterRepository.findByFpoRefId(id);
	}



}
