package com.upfpo.app.entity;


import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "notification")
public class Notification {


    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="production_id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @Column(name = "receiver_id")
    private Integer receiverId;

    @Column(name = "sender_id")
    private Integer senderId;

    @Column(name ="is_read")
    private Boolean isRead;

    @Column(name = "notificaton_type")
    private NotificationType type;






}
