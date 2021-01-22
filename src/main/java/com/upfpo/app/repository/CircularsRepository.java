package com.upfpo.app.repository;

<<<<<<< HEAD
import com.upfpo.app.entity.Circulars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CircularsRepository extends JpaRepository<Circulars, Integer> {
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.Circulars;

@Repository
public interface CircularsRepository extends JpaRepository<Circulars, Integer>{
	
	

>>>>>>> 11eec8db0b7631bb1e9af844d510dacd69cb659e
}
