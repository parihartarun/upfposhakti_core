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
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.upfpo.app.dto.DepartmentSalesReportDto;



@Entity
@SqlResultSetMapping(name="DepartmentSalesReportDto",
classes = {
    @ConstructorResult(
            targetClass = DepartmentSalesReportDto.class,
            columns = {
                @ColumnResult(name = "district_name", type = String.class),
                @ColumnResult(name = "fpo_name", type = String.class),
                @ColumnResult(name = "crop_name", type = String.class),
                @ColumnResult(name = "crop_veriety", type = String.class),
                @ColumnResult(name = "sold_quantity", type = Double.class),
                
           })
})
@Table(name ="production_report")
public class FPORegisterForProdReport implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer prod_id;
	
	@Column(name="district_name")
	private String district_name;
	@Column(name="fpo_name")
	private String fpo_name;
	@Column(name="fpo_address")
	private String fpo_address;
	@Column(name="fpo_landline")
	private BigInteger fpo_landline;
	@Column(name="crop_name")
	private String crop_name;
	@Column(name="crop_veriety")
	private String crop_veriety;
	@Column(name="total_farmers")
	private BigInteger total_farmers;
	@Column(name="sowing_area")
	private Integer sowing_area;
	@Column(name="estimated_production")
	private BigInteger estimated_production;
	@Column(name="actual_production")
	private String actual_production;
	
	
	
	public FPORegisterForProdReport(Integer prod_id, String district_name, String fpo_name, String fpo_address,
			BigInteger fpo_landline, String crop_name, String crop_veriety, BigInteger total_farmers,
			Integer sowing_area, BigInteger estimated_production, String actual_production) {
		super();
		this.prod_id = prod_id;
		this.district_name = district_name;
		this.fpo_name = fpo_name;
		this.fpo_address = fpo_address;
		this.fpo_landline = fpo_landline;
		this.crop_name = crop_name;
		this.crop_veriety = crop_veriety;
		this.total_farmers = total_farmers;
		this.sowing_area = sowing_area;
		this.estimated_production = estimated_production;
		this.actual_production = actual_production;
	}

	public Integer getProd_id() {
		return prod_id;
	}

	public void setProd_id(Integer prod_id) {
		this.prod_id = prod_id;
	}
	
	public String getDistrict_name() {
		return district_name;
	}

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}

	public String getFpo_name() {
		return fpo_name;
	}

	public void setFpo_name(String fpo_name) {
		this.fpo_name = fpo_name;
	}

	public String getFpo_address() {
		return fpo_address;
	}

	public void setFpo_address(String fpo_address) {
		this.fpo_address = fpo_address;
	}

	public BigInteger getFpo_landline() {
		return fpo_landline;
	}

	public void setFpo_landline(BigInteger fpo_landline) {
		this.fpo_landline = fpo_landline;
	}

	public String getCrop_name() {
		return crop_name;
	}

	public void setCrop_name(String crop_name) {
		this.crop_name = crop_name;
	}

	public String getCrop_veriety() {
		return crop_veriety;
	}

	public void setCrop_veriety(String crop_veriety) {
		this.crop_veriety = crop_veriety;
	}

	public BigInteger getTotal_farmers() {
		return total_farmers;
	}

	public void setTotal_farmers(BigInteger total_farmers) {
		this.total_farmers = total_farmers;
	}

	public Integer getSowing_area() {
		return sowing_area;
	}

	public void setSowing_area(Integer sowing_area) {
		this.sowing_area = sowing_area;
	}

	public BigInteger getEstimated_production() {
		return estimated_production;
	}

	public void setEstimated_production(BigInteger estimated_production) {
		this.estimated_production = estimated_production;
	}

	public String getActual_production() {
		return actual_production;
	}

	public void setActual_production(String actual_production) {
		this.actual_production = actual_production;
	}
	
	

}
