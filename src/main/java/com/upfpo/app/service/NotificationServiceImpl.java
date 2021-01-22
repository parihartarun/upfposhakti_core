package com.upfpo.app.service;


import com.upfpo.app.entity.ComplaintCatgories;
import com.upfpo.app.entity.Notification;

import com.upfpo.app.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl {

    @Autowired
    private NotificationRepository notificationRepository;

    

    public List<Notification> getAllNotification(){
        return notificationRepository.findAll();
    }

    public Notification createNotification (Notification notification){
        return notificationRepository.save(notification);
    }



    public Notification updateNotification(Integer id, Notification notification) {
        Optional<Notification> sd = notificationRepository.findById(id);
        if(!sd.isPresent()) {
            return null;
        }
        notification.setId(id);
        return notificationRepository.save(notification);
    }


    public Optional deleteNotification(Integer id) {
        return notificationRepository.findById(id)
                .map(notification -> {
                    notificationRepository.delete(notification);
                    return "Delete Successfully!";
                });
    }



}
