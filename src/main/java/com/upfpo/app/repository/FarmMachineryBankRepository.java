package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.FarmMachineryBank;


@Repository
public interface FarmMachineryBankRepository extends JpaRepository<FarmMachineryBank, Integer> {

	/*
	 * @Query("Select fm from FarmMachineryBank fm where fm.isDeleted= :b order by createDate desc"
	 * ) List<FarmMachineryBank> findByIsDeleted(boolean b);
	 */
	
	List<FarmMachineryBank> findByIsDeletedOrderByIdDesc(boolean b);
}
