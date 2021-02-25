package com.upfpo.app.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.FarmerMaster;
import com.upfpo.app.entity.FpoLicenceDetails;

@Repository
public interface FarmerMasterRepository extends JpaRepository<FarmerMaster, Integer>
{
	 @Modifying
	 @Transactional
	 @Query("update FarmerMaster f set f.isDeleted=true where f.farmerId = :farmerId")
	 public void deleteFarmer(int farmerId);
	 
	 @Query("select count(f) from FarmerMaster f where f.farmerMob = :farmerMob")
	 public int alreadyExists(long farmerMob);
	
	 @Query("select f from FarmerMaster f where f.userFar.userId <> :userId and f.isDeleted = false order by f.farmerId desc")
	 public List<FarmerMaster> getFarmers(long userId);	 
	 
	 public Optional<FarmerMaster> findByUserNameAndFarmerMob(String userName,Long farmerMob);
	 
	 public Boolean existsByUserNameAndFarmerMob(String userName,Long farmerMob);
	 
	 @Query("select count(f) from FarmerMaster f where upper(f.userFar.userName) = :userName")
	 public int checkUserFarmerExists(String userName);
	 
	 public List<FarmerMaster> findByFpoRefIdAndIsDeletedOrderByFarmerIdDesc(Integer masterId, boolean val);
	 
	 @Query("select f.fpoRefId from FarmerMaster f where f.farmerId = :farmerId")
	 public Integer getFpoIdofFarmer(Integer farmerId);
	 
	 @Query("select count(f) from FarmerMaster f where f.fpoRefId = :fpoId and isDeleted = false")
	 public Integer getFpoFarmer(Integer fpoId);
}
