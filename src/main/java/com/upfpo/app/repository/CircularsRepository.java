package com.upfpo.app.repository;

import com.upfpo.app.entity.Circulars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.Circulars;

@Repository
public interface CircularsRepository extends JpaRepository<Circulars, Integer>{
	
}
