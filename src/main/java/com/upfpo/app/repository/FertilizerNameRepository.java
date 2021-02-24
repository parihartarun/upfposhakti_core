package com.upfpo.app.repository;

import com.upfpo.app.entity.FertilizerName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FertilizerNameRepository extends JpaRepository<FertilizerName, Integer> {
    List<FertilizerName> findByFertilizerTypeId(Integer typeId);
}
