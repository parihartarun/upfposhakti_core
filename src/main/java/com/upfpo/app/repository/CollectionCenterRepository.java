package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.CollectionCenter;

@Repository
public interface CollectionCenterRepository extends JpaRepository<CollectionCenter, Integer>{

	List<CollectionCenter> findByIsDeleted(boolean b);

	List<CollectionCenter> findByFpoRefId(Integer id);

}
