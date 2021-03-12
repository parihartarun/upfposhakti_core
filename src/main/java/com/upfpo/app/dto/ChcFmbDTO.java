package com.upfpo.app.dto;

public class ChcFmbDTO {


    int chcFmbId;
    String chcFmbName;
    long mobileNumber;
    String email;


    public ChcFmbDTO() {
    }

    public ChcFmbDTO(int chcFmbId, String chcFmbName, long mobileNumber, String email) {
        this.chcFmbId = chcFmbId;
        this.chcFmbName = chcFmbName;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }



    public int getChcFmbId() {
        return chcFmbId;
    }

    public void setChcFmbId(int chcFmbId) {
        this.chcFmbId = chcFmbId;
    }

    public String getChcFmbName() {
        return chcFmbName;
    }

    public void setChcFmbName(String chcFmbName) {
        this.chcFmbName = chcFmbName;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
