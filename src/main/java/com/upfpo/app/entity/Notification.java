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


    public Notification() {
    }

    public Notification(Integer id, String title, String message, Integer receiverId, Integer senderId, Boolean isRead, NotificationType type) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.receiverId = receiverId;
        this.senderId = senderId;
        this.isRead = isRead;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }
}
