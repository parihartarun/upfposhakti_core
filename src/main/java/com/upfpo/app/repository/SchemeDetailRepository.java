package com.upfpo.app.repository;

import com.upfpo.app.entity.SchemeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SchemeDetailRepository extends JpaRepository<SchemeDetail, Integer> {
    List<SchemeDetail> findByIsDeleted(boolean b);
}
