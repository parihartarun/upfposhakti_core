package com.upfpo.app.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.dto.FarmerDetailsDTO;
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
	
	 @Query("select f from FarmerMaster f where f.userFar.userId <> :userId and f.isDeleted = false order by f.farmerId desc")
	 public List<FarmerMaster> getFarmers(long userId);	 
	 
	 public Optional<FarmerMaster> findByUserNameAndFarmerMob(String userName,Long farmerMob);
	 
	 public Boolean existsByUserNameAndFarmerMob(String userName,Long farmerMob);
	 
	 @Query("select count(f) from FarmerMaster f where upper(f.userFar.userName) = :userName")
	 public int checkUserFarmerExists(String userName);
	 
	 public List<FarmerMaster> findByFpoRefIdAndIsDeletedOrderByFarmerIdDesc(Integer masterId, boolean val);
	 
	 @Query("select f.fpoRefId from FarmerMaster f where f.farmerId = :farmerId")
	 public Integer getFpoIdofFarmer(Integer farmerId);
	 
	 @Query("select count(f) from FarmerMaster f where f.fpoRefId = :fpoId and f.isDeleted = false")
	 public Integer getFpoFarmer(Integer fpoId);
	 
	 @Query("select count(f) from FarmerMaster f where f.isDeleted = false")
	 public Integer getAllFarmers();

	//deActivate user by department user 
	@Modifying
	@Transactional
	@Query("update User u set u.isEnabled=false, u.deActivatedBy= :masterId, u.reason= :reason where u.userId = :uid")
	public void deActivateUserByFpo(Long uid, String reason, Integer masterId);
	
	//Activate user by department user
	@Modifying
	@Transactional
	@Query("update User u set u.isEnabled=true, u.activatedBy= :masterId where u.userId = :uid")
	public void activateUserByFpo(Long uid, Integer masterId);
	
	@Query("select new com.upfpo.app.dto.FarmerDetailsDTO(f.farmerId, f.farmerName) from FarmerMaster f where f.fpoRefId = :masterId and f.isDeleted = false")
	public List<FarmerDetailsDTO> getFarmersByFpo(Integer masterId);
}
