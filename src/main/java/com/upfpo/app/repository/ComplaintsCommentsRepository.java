package com.upfpo.app.repository;


import com.upfpo.app.entity.ComplaintsComments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComplaintsCommentsRepository extends JpaRepository<ComplaintsComments,Integer> {


    Page<ComplaintsComments> findByComplaints_id(Integer id, Pageable pageable);
}
