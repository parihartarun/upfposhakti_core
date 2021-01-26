package com.upfpo.app.repository;


import com.upfpo.app.entity.Circulars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CircularsRepository extends JpaRepository<Circulars, Integer> {
}
