package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.CollectionCenter;

@Repository
public interface CollectionCenterRepository extends JpaRepository<CollectionCenter, Integer>{

	//List<CollectionCenter> findByIsDeleted(boolean b);

	//@Query("Select c from CollectionCenter c where c.masterId = :id and c.isDeleted = false order by c.id desc")
	List<CollectionCenter> findByFpoRefIdAndIsDeletedOrderByIdDesc(Integer id, boolean val);
	
	List<CollectionCenter> findByIsDeletedOrderByIdDesc(boolean b);
	
	

}
