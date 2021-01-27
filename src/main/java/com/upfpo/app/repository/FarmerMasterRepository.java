package com.upfpo.app.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.FarmerMaster;

@Repository
public interface FarmerMasterRepository extends JpaRepository<FarmerMaster, Integer>
{
	 @Modifying
	 @Transactional
	 @Query("update FarmerMaster f set f.isDeleted=true where f.farmerId = :farmerId")
	 public void deleteFarmer(int farmerId);
	 
	 @Query("select count(f) from FarmerMaster f where f.farmerMob = :farmerMob")
	 public int alreadyExists(long farmerMob);
	
//	 @Query("select f from FarmerMaster f where f.userFar.userId <> :userId")
//	 public List<FarmerMaster> getFarmers(long userId);	 
	 
	 public Optional<FarmerMaster> findByUserNameAndFarmerMob(String userName,Long farmerMob);
	 
	 public Boolean existsByUserNameAndFarmerMob(String userName,Long farmerMob);
	 

	 @Query("select f from FarmerMaster f where f.userFar.userId <> :userId")
	 public List<FarmerMaster> getFarmers(long userId); 

	 
	 @Query("select count(f) from FarmerMaster f where upper(f.userFar.userName) = :userName")
	 public int checkUserFarmerExists(String userName);
}
