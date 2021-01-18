package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.upfpo.app.entity.BlockMaster;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockMasterRepository extends CrudRepository<BlockMaster, Integer>
{
	@Query("Select b from block b where b.distId= :distId")
	List<BlockMaster> getPanchayatByBlockId(Integer distId);
}
