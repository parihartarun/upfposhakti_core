package com.upfpo.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="equipment_type_master")
public class EquipmentType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    //private Integer id;
    private Integer machineTypeId;

    @Column(name = "type")
    private String equipType;

    @Column(name="is_active")
    private Boolean isactive;

	public Integer getMachineTypeId() {
		return machineTypeId;
	}

	public void setMachineTypeId(Integer machineTypeId) {
		this.machineTypeId = machineTypeId;
	}

	public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType;
    }

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

}
