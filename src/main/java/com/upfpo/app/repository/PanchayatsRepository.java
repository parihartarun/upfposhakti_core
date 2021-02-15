package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.Panchayats;

@Repository
public interface PanchayatsRepository extends JpaRepository<Panchayats, Integer>
{
	@Query("Select c from Panchayats c where c.blockRef= :blockRef order by c.panchayat_name asc")
	List<Panchayats> getPanchayatByBlockId(int blockRef);
	
	@Query("Select c from Panchayats c order by c.panchayat_name asc")
	List<Panchayats> getPanchayats();
}
