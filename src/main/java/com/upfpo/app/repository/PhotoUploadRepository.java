package com.upfpo.app.repository;

import com.upfpo.app.entity.PhotoUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PhotoUploadRepository extends JpaRepository<PhotoUpload,Integer> {
    List<PhotoUpload> findByIsDeleted(Boolean b);

    List<PhotoUpload> findByFpoId(Integer id);
}
