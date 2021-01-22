package com.upfpo.app.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="crop_veriety_master")
public class CropVerietyMaster implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="veriety_id")
	private Integer verietyId;
	
	@Column(name="crop_veriety")
	private String  verietyName;
	
	@Column(name="crop_master_ref_id")
	private Integer cropRefId;
	
	
	public Integer getVerietyId() {
		return verietyId;
	}

	public void setVerietyId(Integer verietyId) {
		this.verietyId = verietyId;
	}

	public String getVerietyName() {
		return verietyName;
	}

	public void setVerietyName(String verietyName) {
		this.verietyName = verietyName;
	}

	public Integer getCropRefId() {
		return cropRefId;
	}

	public void setCropRefId(Integer cropRefId) {
		this.cropRefId = cropRefId;
	}
}
