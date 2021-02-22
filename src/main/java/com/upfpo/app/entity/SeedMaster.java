package com.upfpo.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seed_master1")
public class SeedMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="seed_id")
	private Integer seedId;
	
	@Column(name="seed_name")
	private String seedName;
	
	@Column(name="certificate_valid_from")
	private java.sql.Date certificateValidFrom;
	
	@Column(name="certificate_valid_to")
	private java.sql.Date certificateValidTo;
	
	@Column(name="company_brand")
	private String companyBrand;
	
	@Column(name="crop_id")
	private Integer cropId;
	
	@Column(name="crop_veriety_id")
	private Integer cropVerietyId;
	
	@Column(name="file_name")
	private String fileName;
	
	@Column(name="path")
	private String path;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="seed_certification_number")
	private String seedCertificationNumber;

	public Integer getSeedId() {
		return seedId;
	}

	public void setSeedId(Integer seedId) {
		this.seedId = seedId;
	}

	public String getSeedName() {
		return seedName;
	}

	public void setSeedName(String seedName) {
		this.seedName = seedName;
	}

	public java.sql.Date getCertificateValidFrom() {
		return certificateValidFrom;
	}

	public void setCertificateValidFrom(java.sql.Date certificateValidFrom) {
		this.certificateValidFrom = certificateValidFrom;
	}

	public java.sql.Date getCertificateValidTo() {
		return certificateValidTo;
	}

	public void setCertificateValidTo(java.sql.Date certificateValidTo) {
		this.certificateValidTo = certificateValidTo;
	}

	public String getCompanyBrand() {
		return companyBrand;
	}

	public void setCompanyBrand(String companyBrand) {
		this.companyBrand = companyBrand;
	}

	public Integer getCropId() {
		return cropId;
	}

	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}

	public Integer getCropVerietyId() {
		return cropVerietyId;
	}

	public void setCropVerietyId(Integer cropVerietyId) {
		this.cropVerietyId = cropVerietyId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getSeedCertificationNumber() {
		return seedCertificationNumber;
	}

	public void setSeedCertificationNumber(String seedCertificationNumber) {
		this.seedCertificationNumber = seedCertificationNumber;
	}
	
	
}
