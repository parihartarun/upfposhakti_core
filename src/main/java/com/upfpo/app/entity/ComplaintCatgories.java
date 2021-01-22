package com.upfpo.app.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="complaint_type_master")
public class ComplaintCatgories implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer comp_type_id;

    @Column(name="complaint_type_en")
    private String comp_type_en;

    @Column(name="complaint_type_hi")
    private String comp_type_hi;

    public Integer getComp_type_id() {
        return comp_type_id;
    }

    public void setComp_type_id(Integer comp_type_id) {
        this.comp_type_id = comp_type_id;
    }

    public String getComp_type_en() {
        return comp_type_en;
    }

    public void setComp_type_en(String comp_type_en) {
        this.comp_type_en = comp_type_en;
    }

    public String getComp_type_hi() {
        return comp_type_hi;
    }

    public void setComp_type_hi(String comp_type_hi) {
        this.comp_type_hi = comp_type_hi;
    }


}

