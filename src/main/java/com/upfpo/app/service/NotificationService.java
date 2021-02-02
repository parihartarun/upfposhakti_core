package com.upfpo.app.service;

import com.upfpo.app.entity.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {

    public List<Notification> getAllNotification();
    public Notification createNotification (Notification notification);
    public Notification updateNotification(Integer id, Notification notification);
    public Boolean deleteNotification(Integer id);
}
