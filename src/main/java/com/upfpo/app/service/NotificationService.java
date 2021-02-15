package com.upfpo.app.service;

import com.upfpo.app.entity.Notification;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface NotificationService {

    public List<Notification> getAllNotification();
    /*public Notification createNotification (Notification notification);
    public Notification updateNotification(Integer id, Notification notification);
    public Boolean deleteNotification(Integer id);*/

    Notification sendNotification(Notification notification, MultipartFile file);

    List<Notification> getAllNotificationByDepartment(String fpoId);

    List<Notification> getAllNotificationByFPO(String farmerId);

    List<Notification> viewAllNotificationOfDepartment(String deptId);

    List<Notification> viewAllNotificationofFPO(String fpoId);

    Resource loadFileAsResource(String fileName);
}
