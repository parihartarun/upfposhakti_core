package com.upfpo.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="educational_level")
public class EducationMaster implements Serializable{

	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private Integer eduid;

@Column(name="educational_level")
private String  qualification;


public EducationMaster() {
}

public Integer getEduid() {
	return eduid;
}
public void setEduid(Integer eduid) {
	this.eduid = eduid;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}


@Override
public String toString() {
	return "EducationMaster [eduid=" + eduid + ", qualification=" + qualification + ", getEduid()=" + getEduid()
			+ ", getQualification()=" + getQualification() + "]";
}

}
