package com.upfpo.app.service;


import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.ComplaintCatgories;
import com.upfpo.app.entity.Complaints;
import com.upfpo.app.entity.Notification;

import com.upfpo.app.entity.Status;
import com.upfpo.app.properties.FileStorageProperties;
import com.upfpo.app.repository.NotificationRepository;
import com.upfpo.app.user.exception.FileStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private NotificationRepository notificationRepository;

    private final Path fileStorageLocation;

    @Autowired
    public NotificationServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            //throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",ex);
        }
    }

    
    @Override
    public List<Notification> getAllNotification(){
        return notificationRepository.findByIsDeleted(false);
    }

    /*@Override
    public Notification createNotification (Notification notification){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        notification.setDeleted(false);
        notification.setCreateDate(Calendar.getInstance());
        notification.setCreateBy(currentPrincipalName);
        return notificationRepository.save(notification);
    }


    @Override
    public Notification updateNotification(Integer id, Notification notification) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Optional<Notification> sd = notificationRepository.findById(id);
        if(!sd.isPresent()) {
            return null;
        }
        notification.setId(id);
        notification.setUpdateBy(currentPrincipalName);
        notification.setUpdateDate(Calendar.getInstance());
        notification.setDeleted(false);
        return notificationRepository.save(notification);
    }


    @Override
    public Boolean deleteNotification(Integer id) {

        try {
            Notification notification = notificationRepository.findById(id).get();
            notification.setDeleted(true);
            notification.setDeleteDate(Calendar.getInstance().getTime());
            notificationRepository.save(notification);
            return true;
        }catch(Exception e)
        {
            throw new NotFoundException();
        }
    }

    public Notification sendNotification (Notification notification){


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        notification.setCreateBy(currentPrincipalName);
        notification.setCreateDate(Calendar.getInstance());
        notification.setDeleted(false);
        return notificationRepository.save(notification);

    }*/

    @Override
    public Notification sendNotification(Notification notification, MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        String role = "ROLE_FARMER";
        notification.setCreateBy(currentPrincipalName);
        notification.setCreateDate(Calendar.getInstance());
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            //Path path = Paths.get( fileBasePath+fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/notification/download/")
                    .path(fileName)
                    .toUriString();
            notification.setFilePath(fileDownloadUri);
            notification.setFilName(fileName);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
        notification.setDeleted(false);
        return notificationRepository.save(notification);
    }


    @Override
    public List<Notification> getAllNotificationByDepartment(String fpoId){
        return notificationRepository.findByFpoId(fpoId);
    }

    @Override
    public List<Notification> getAllNotificationByFPO(String farmerId){
        return notificationRepository.findByFarmerId(farmerId);
    }




}
