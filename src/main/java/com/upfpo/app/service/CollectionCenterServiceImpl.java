package com.upfpo.app.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.dto.CollectionCenterDTO;
import com.upfpo.app.entity.CollectionCenter;
import com.upfpo.app.repository.CollectionCenterRepository;
import com.upfpo.app.repository.DistrictMasterRepository;

@Service
public class CollectionCenterServiceImpl implements CollectionCenterService {

	
	@Autowired
	private CollectionCenterRepository collectionCenterRepository; 
	
	@Autowired
	private DistrictMasterRepository districtRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public CollectionCenter insertCollectionCenter(CollectionCenter e) {
		// TODO Auto-generated method stub
		//DistrictMaster district = districtRepository.findById(e.getDistId()).get();
		e.setUpdatedBy("ROLE_FPO");
		e.setStateId(6);
		//e.setDistId(6);
		e.setDeleted(false);
		return collectionCenterRepository.save(e);
	}

	@Override
	public CollectionCenter updateCollectionCenter(int id, CollectionCenter e) {
		// TODO Auto-generated method stub
		/*e.setId(id);
	    DistrictMaster district = districtRepository.findById(e.getDistId()).get();
	    e.setUpdatedBy("ROLE_FPO");
		e.setStateId(district.getState_id());
		e.setDeleted(false);
		return collectionCenterRepository.save(e);*/
		
		CollectionCenter cc = collectionCenterRepository.findById(id).get();
        cc.setStateId(e.getStateId());
        cc.setUpdatedBy("ROLE_FPC");
        cc.setAddress(e.getAddress());
        cc.setFascilities(e.getFascilities());
        cc.setBlockId(e.getBlockId());
        cc.setFpoRefId(e.getFpoRefId());
        cc.setDistId(e.getDistId());
        cc.setStateId(e.getStateId());
        cc.setDeleted(e.isDeleted());
        cc.setStorageCapacity(e.getStorageCapacity());
        cc.setStorageType(e.getStorageType());
        return collectionCenterRepository.save(cc);
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
		return collectionCenterRepository.findByIsDeletedOrderByIdDesc(false);
		
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
		return collectionCenterRepository.findByFpoRefIdAndIsDeletedOrderByIdDesc(id, false);
	}
	
	@Override
	public List<CollectionCenterDTO> selectCollectionCenterData(Integer masterId) 
	{
		String sql =  "select c.id as collectionId, c.center_address as address, b.block_id as blockId, b.block_name as blockName, d.district_id, d.district_name, c.fascilities,\r\n"
					+ "		c.master_id as masterId, c.is_seed_pro_unit as isseedprocessingunit, c.state_ref_id, c.storage_capacity as storageCapacity, c.storage_type as storageType,\r\n"
					+ "		c.updated_by as updatedBy from collection_center c join districts d on d.district_id = c.dist_ref_id \r\n"
					+ "		join block b on b.block_id = c.block_ref_id\r\n"
					+ "		where c.master_id = :masterId and c.is_deleted = false order by c.id desc";
			
		List<CollectionCenterDTO> obj =  (List<CollectionCenterDTO>) entityManager.createNativeQuery(sql,"CollectionCenterDTO").setParameter("masterId", masterId).getResultList();
			  return obj;
		
	}

	@Override
	public Integer seedProcessingUnits() {
		
		return collectionCenterRepository.seedProcessingUnits();
	}

	@Override
	public Integer totalColdStorage() {
		return collectionCenterRepository.totalColdStorage();
	}

}
