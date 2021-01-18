package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.upfpo.app.entity.BlockMaster;

public interface BlockMasterRepository extends JpaRepository<BlockMaster, Integer>
{
	@Query("Select b from block b where b.distId= :distId")
	List<BlockMaster> getPanchayatByBlockId(int distId);
}
