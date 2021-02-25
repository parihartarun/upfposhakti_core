package com.upfpo.app.entity;


import javax.persistence.*;

@Entity
@Table(name="insecticide_type_master")
public class InsecticideType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "insecticide_type")
    private String insecticideType;
}
