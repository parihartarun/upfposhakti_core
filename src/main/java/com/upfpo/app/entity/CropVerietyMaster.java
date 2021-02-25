package com.upfpo.app.entity;
import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.upfpo.app.dto.CropVerietyMasterDto;
import com.upfpo.app.dto.DepartmentProdReportDto;

@Entity
@SqlResultSetMapping(name="DepartmentProdReportDto",
classes = {
    @ConstructorResult(
            targetClass = DepartmentProdReportDto.class,
            columns = {
                @ColumnResult(name = "district_name", type = String.class),
                @ColumnResult(name = "fpo_name", type = String.class),
                @ColumnResult(name = "fpo_address", type = String.class),
                @ColumnResult(name = "fpo_landline", type = BigInteger.class),
                @ColumnResult(name = "crop_name", type = String.class),
                @ColumnResult(name = "crop_veriety", type = String.class),
                @ColumnResult(name = "total_farmers", type = BigInteger.class),
                @ColumnResult(name = "sowing_area", type = Integer.class),
                @ColumnResult(name = "estimated_production", type = BigInteger.class),
                @ColumnResult(name = "actual_production", type = BigInteger.class),
                //@ColumnResult(name = "sold_quantity", type = Double.class),
                
           })
})

@SqlResultSetMapping(name="CropVerietyMasterDto",
classes = {
    @ConstructorResult(
            targetClass = CropVerietyMasterDto.class,
            columns = {
                @ColumnResult(name = "verietyId", type = Integer.class),
                @ColumnResult(name = "verityName", type = String.class),
           })
})
@Table(name="crop_veriety_master")
public class CropVerietyMaster implements Serializable{

	private static final long serialVersionUID = 3919518454117121902L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="veriety_id")
	private Integer verietyId;
	
	@Column(name="crop_veriety")
	private String  verietyName;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="crop_master_ref_id")
	private CropMaster crop;
	
	
	public CropVerietyMaster(String verietyName,Integer verietyId) {
		super();
		this.verietyId = verietyId;
		this.verietyName = verietyName;
	}

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

	public CropMaster getCrop() {
		return crop;
	}

	public void setCrop(CropMaster crop) {
		this.crop = crop;
	}

	
}
