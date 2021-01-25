package com.upfpo.app.repository;

<<<<<<< HEAD

import com.upfpo.app.entity.Circulars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CircularsRepository extends JpaRepository<Circulars, Integer> {
}
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.Circulars;

@Repository
public interface CircularsRepository extends JpaRepository<Circulars, Integer>{

}
>>>>>>> 9c2bb7a71dd4103eb94b9fb30cf8d51a71144f80
