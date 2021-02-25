package com.upfpo.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "fertilizer_type_master")
public class FertilizerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fertilizer_type")
    private String fertilizerType;


    public FertilizerType() {
    }

    public FertilizerType(Integer id, String fertilizerType) {
        this.id = id;
        this.fertilizerType = fertilizerType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFertilizerType() {
        return fertilizerType;
    }

    public void setFertilizerType(String fertilizerType) {
        this.fertilizerType = fertilizerType;
    }
}
