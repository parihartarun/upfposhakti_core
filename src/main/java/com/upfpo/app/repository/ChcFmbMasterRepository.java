package com.upfpo.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.ChcFmbMaster;

@Repository
public interface ChcFmbMasterRepository extends JpaRepository<ChcFmbMaster, Integer>
{
	@Modifying
	@Transactional
	@Query("update ChcFmbMaster c set c.isDeleted=true where c.chcFmbId = :chcFmbId")
	public void deleteChcFmb(int chcFmbId);
	
	@Query("select count(c) from ChcFmbMaster c where c.mobileNumber = :mobileNumber")
	 public int alreadyExists(long mobileNumber);
}
