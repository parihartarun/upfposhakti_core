package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.upfpo.app.entity.VillageMaster;

public interface VillageMasterRepository extends JpaRepository<VillageMaster, Integer>
{
	@Query("Select v from villages v where v.panchayatId= :panchayatId")
	List<VillageMaster> getVillagesByPanchayat(int panchayatId);
}
