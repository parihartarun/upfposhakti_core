package com.upfpo.app.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadDir;

    private String fposervicesDir;

    private String fpoguidelinesDir;

    private String complaintDir;

    private String circularDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    public String getfposervicesDir() {
        return fposervicesDir;
    }

    public void setFposervicesDir(String fposervicesDir) {
        this.fposervicesDir = fposervicesDir;
    }

    public String getFpoGuidelinesDir() {
        return fpoguidelinesDir;
    }

    public void setFpoGuidelinesDir(String fpoGuidelinesDir) {
        this.fpoguidelinesDir = fpoGuidelinesDir;
    }

    public String getComplaintDir() {
        return complaintDir;
    }

    public void setComplaintDir(String complaintDir) {
        this.complaintDir = complaintDir;
    }

    public String getCircularDir() {
        return circularDir;
    }

    public void setCircularDir(String circularDir) {
        this.circularDir = circularDir;
    }
}