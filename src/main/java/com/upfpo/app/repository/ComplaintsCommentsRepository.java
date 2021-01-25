package com.upfpo.app.repository;


import com.upfpo.app.entity.ComplaintsComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComplaintsCommentsRepository extends JpaRepository<ComplaintsComments,Integer> {


    Optional<ComplaintsComments> findByComplaints_id(Integer id);
}
