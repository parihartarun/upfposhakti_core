package com.upfpo.app.repository;

import java.util.List;

import com.upfpo.app.dto.UpAgriBankDataDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.VillageMaster;

@Repository
public interface VillageMasterRepository extends JpaRepository<VillageMaster, Integer>
{
	@Query("Select v from VillageMaster v where v.panchayatId= :panchayatId order by v.villageName asc")
	List<VillageMaster> getVillagesByPanchayat(int panchayatId);
	
	@Query("Select v from VillageMaster v where v.blockId= :blockId order by v.villageName asc")
	List<VillageMaster> getVillagesByBlockId(int blockId);
	
	List<VillageMaster> findAllByOrderByVillageNameAsc();

	@Query("Select villageId from VillageMaster v where v.villageName= :vill")
	Integer findByVillageName(String vill);
}
