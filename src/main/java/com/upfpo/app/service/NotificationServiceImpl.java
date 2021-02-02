package com.upfpo.app.service;


import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.ComplaintCatgories;
import com.upfpo.app.entity.Complaints;
import com.upfpo.app.entity.Notification;

import com.upfpo.app.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return notificationRepository.save(notification);
    }


    @Override
    public Notification updateNotification(Integer id, Notification notification) {
        Optional<Notification> sd = notificationRepository.findById(id);
        if(!sd.isPresent()) {
            return null;
        }
        notification.setId(id);
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




}
