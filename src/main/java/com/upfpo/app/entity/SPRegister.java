package com.upfpo.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name="service_provider")
public class SPRegister implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sp_id")
	private Integer spId;
	
	@Pattern(regexp="^[ A-Za-z0-9]+$",message="Please Enter Name Without Special Characters")
	@Length(min=2,max=20,message="Please Enter Name Between 2 and 20 Characters")
	@Column(name="sp_name")
	private String  spName;
	
	@Column(name="sp_landline")
	private Long    splandLine;
	
	@NotBlank(message="Please provide Valid Address")
	@Column(name="sp_address")
	private String  spAddress;
	
	@Email(message ="Please Provie Valid Email Address")
    @NotBlank(message ="Please Provie Valid Email Address")
	@Column(name="sp_official_email")
	private String  spOfficeEmail;
	
	
	@Column(name="sla_refid")
	private Integer slaRefId;
	
	@Pattern(regexp="^[ A-Za-z0-9]+$",message="Please Enter Name Without Special Characters")
	@Length(min=2,max=20,message="Please Enter Name Between 2 and 20 Characters")
	@Column(name="sp_spoc_name")
	private String  spSPOCName;
		
	@Email(message ="Please Provie Valid Email Address")
    @NotBlank(message ="Please Provie Valid Email Address")
	@Column(name="sp_spoc_email")
	private String  spSPOCEmail;
	
	
	@Column(name="sp_spoc_mob")
	private Long spSPOCMob;
	
	@NotBlank(message="Please provide Valid Address")
	@Column(name="sp_spoc_address")
	private String  spSPOCAddress;
	
	@Column(name="user_ref_id")
	private Long userRefId;
	
	@Length(min=6,max=20,message="Username Should be in between 6 to 20 Characters")
	@Column(name="username")
	private String userName;
	
	@Column(name="update_date")
	private java.sql.Date updateDate;
	
	@Column(name="create_date")
	private java.sql.Date createdate;
	
	
	
	public Integer getSpId() {
		return spId;
	}

	public void setSpId(Integer spId) {
		this.spId = spId;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public Long getSplandLine() {
		return splandLine;
	}

	public void setSplandLine(Long splandLine) {
		this.splandLine = splandLine;
	}

	public String getSpAddress() {
		return spAddress;
	}

	public void setSpAddress(String spAddress) {
		this.spAddress = spAddress;
	}

	public String getSpOfficeEmail() {
		return spOfficeEmail;
	}

	public void setSpOfficeEmail(String spOfficeEmail) {
		this.spOfficeEmail = spOfficeEmail;
	}

	public Integer getSlaRefId() {
		return slaRefId;
	}

	public void setSlaRefId(Integer slaRefId) {
		this.slaRefId = slaRefId;
	}

	public String getSpSPOCName() {
		return spSPOCName;
	}

	public void setSpSPOCName(String spSPOCName) {
		this.spSPOCName = spSPOCName;
	}

	public String getSpSPOCEmail() {
		return spSPOCEmail;
	}

	public void setSpSPOCEmail(String spSPOCEmail) {
		this.spSPOCEmail = spSPOCEmail;
	}

	public Long getSpSPOCMob() {
		return spSPOCMob;
	}

	public void setSpSPOCMob(Long spSPOCMob) {
		this.spSPOCMob = spSPOCMob;
	}

	public String getSpSPOCAddress() {
		return spSPOCAddress;
	}

	public void setSpSPOCAddress(String spSPOCAddress) {
		this.spSPOCAddress = spSPOCAddress;
	}

	public Long getUserRefId() {
		return userRefId;
	}

	public void setUserRefId(Long userRefId) {
		this.userRefId = userRefId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public java.sql.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.sql.Date updateDate) {
		this.updateDate = updateDate;
	}

	public java.sql.Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(java.sql.Date createdate) {
		this.createdate = createdate;
	}
	
	
		
}
