package com.upfpo.app.entity;


import javax.persistence.*;

@Entity
@Table(name = "fertilizer_name_master")
public class FertilizerName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fertilizer_type_id")
    private Integer fertilizerTypeId;

    @Column(name = "fertilizer_name")
    private String fertilizerName;


    public FertilizerName() {
    }

    public FertilizerName(Integer id, Integer fertilizerTypeId, String fertilizerName) {
        this.id = id;
        this.fertilizerTypeId = fertilizerTypeId;
        this.fertilizerName = fertilizerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFertilizerTypeId() {
        return fertilizerTypeId;
    }

    public void setFertilizerTypeId(Integer fertilizerTypeId) {
        this.fertilizerTypeId = fertilizerTypeId;
    }

    public String getFertilizerName() {
        return fertilizerName;
    }

    public void setFertilizerName(String fertilizerName) {
        this.fertilizerName = fertilizerName;
    }
}
