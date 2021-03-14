package com.upfpo.app.dto;

public class FPOGuidelinesDTO {

    Integer id;
    String description;
    String create_date;
    String file_path;


    public FPOGuidelinesDTO(Integer id, String description, String create_date, String file_path) {
        this.id = id;
        this.description = description;
        this.create_date = create_date;
        this.file_path = file_path;
    }

    public FPOGuidelinesDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }
}
