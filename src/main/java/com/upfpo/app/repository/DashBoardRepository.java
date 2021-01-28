package com.upfpo.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.DashBoardData;

@Repository
public interface DashBoardRepository extends JpaRepository<DashBoardData, Integer> {

	@Query(value="select dbd from DashBoardData dbd")
	public DashBoardData getFarmCropDetailsForDepatment();
	
	
}
