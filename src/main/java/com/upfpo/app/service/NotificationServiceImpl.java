package com.upfpo.app.service;


import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.ComplaintCatgories;
import com.upfpo.app.entity.Complaints;
import com.upfpo.app.entity.Notification;

import com.upfpo.app.repository.NotificationRepository;
import com.upfpo.app.user.exception.FileStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private NotificationRepository notificationRepository;

    
    @Override
    public List<Notification> getAllNotification(){
        return notificationRepository.findByIsDeleted(false);
    }

    @Override
    public Notification createNotification (Notification notification){
        notification.setDeleted(false);
        return notificationRepository.save(notification);
    }


    @Override
    public Notification updateNotification(Integer id, Notification notification) {
        Optional<Notification> sd = notificationRepository.findById(id);
        if(!sd.isPresent()) {
            return null;
        }
        notification.setId(id);
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

    }




}
