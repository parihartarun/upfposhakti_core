package com.upfpo.app.service;

import com.upfpo.app.entity.PhotoUpload;
import org.springframework.web.multipart.MultipartFile;

public interface PhotoUploadService {


    public PhotoUpload uploadPhoto (PhotoUpload  photoUpload, MultipartFile file);
}
