package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.BlockMaster;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockMasterRepository extends JpaRepository<BlockMaster, Integer>
{
	//@Query("Select b from BlockMaster b where b.distId= :distId")
	//List<BlockMaster> getPanchayatByBlockId(int distId);

	@Query(value = "Select * from BlockMaster where distId= :distId",nativeQuery = true)
	List<BlockMaster> getPanchayatByBlockId(int distId);
}
