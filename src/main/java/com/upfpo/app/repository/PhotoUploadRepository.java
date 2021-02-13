package com.upfpo.app.repository;

import com.upfpo.app.entity.PhotoUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PhotoUploadRepository extends JpaRepository<PhotoUpload,Integer> {
    List<PhotoUpload> findByIsDeleted(Boolean b);
<<<<<<< HEAD

    List<PhotoUpload> findByFpoId(Integer id);
||||||| 68a5b09
=======
    
    List<PhotoUpload> findByFpoIdAndIsDeletedOrderByIdDesc(Integer masterId, boolean val);
>>>>>>> 351d4b95297e7965009dc8dda3a78203dab2d728
}
