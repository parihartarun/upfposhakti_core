package com.upfpo.app.service;

import com.upfpo.app.entity.PhotoUpload;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PhotoUploadService {




    public List<PhotoUpload> getAllPhotoUpload(Integer masterId);
    public PhotoUpload uploadPhoto (PhotoUpload  photoUpload, MultipartFile file);
    public PhotoUpload updatePhotoUpload(Integer id, PhotoUpload photoUploads1,  MultipartFile file) throws IOException;
    public Boolean deletePhotoUpload(Integer id);

    public Resource loadFileAsResource(String fileName);


    List<PhotoUpload> getPhotoByFPOID(Integer id);
}
