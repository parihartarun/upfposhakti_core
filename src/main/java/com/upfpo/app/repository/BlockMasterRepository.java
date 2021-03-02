package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.BlockMaster;

@Repository
public interface BlockMasterRepository extends JpaRepository<BlockMaster, Integer>
{

	@Query("Select b from BlockMaster b where b.distId= :distId order by b.blockName asc")
	List<BlockMaster> getPanchayatByBlockId(int distId);
	
	List<BlockMaster> findAllByOrderByBlockNameAsc();

	@Query("Select id, blockName from BlockMaster v where v.blockName= :blck")
    Object findByBlockName(String blck);
	/*@Query(value = "Select * from BlockMaster where distId= :distId",nativeQuery = true)
	List<BlockMaster> getPanchayatByBlockId(int distId);*/
}
