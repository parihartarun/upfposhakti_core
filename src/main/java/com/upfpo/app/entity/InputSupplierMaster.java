package com.upfpo.app.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.upfpo.app.dto.ChcFmbComplaintsDto;
import com.upfpo.app.dto.InputSupplierComplaintsDto;
import com.upfpo.app.dto.InputSupplierDTO;

@Entity
@SqlResultSetMapping(name="InputSupplierComplaintsDto",
classes = {
        @ConstructorResult(
                targetClass = InputSupplierComplaintsDto.class,
                columns = {
                		@ColumnResult(name = "id", type = Integer.class),
                		@ColumnResult(name = "masterId", type = Integer.class),
                		@ColumnResult(name = "role", type = String.class),
                		@ColumnResult(name = "title", type = String.class),
                		@ColumnResult(name = "message", type = String.class),
                		@ColumnResult(name = "status", type = String.class),
                		@ColumnResult(name = "issueType", type = String.class),
                		@ColumnResult(name = "otherType", type = String.class),
                		@ColumnResult(name = "description", type = String.class),
                		@ColumnResult(name = "otherAssigned", type = String.class),
                		@ColumnResult(name = "assignTo", type = String.class),
                		@ColumnResult(name = "assignBy", type = String.class),
                		@ColumnResult(name = "assign_date", type = String.class),
                		@ColumnResult(name = "resolve_date", type = String.class),
                		@ColumnResult(name = "deptComment", type = String.class),
                		@ColumnResult(name = "remarks", type = String.class),
                		@ColumnResult(name = "filePath", type = String.class),
                		@ColumnResult(name = "fileName", type = String.class),
                		@ColumnResult(name = "uploadDate", type = String.class),
                		@ColumnResult(name = "uploadedBy", type = String.class),
                		@ColumnResult(name = "updateDate", type = String.class),
                		@ColumnResult(name = "updateBy", type = String.class),
                		@ColumnResult(name = "isDeleted", type = Boolean.class),
                		@ColumnResult(name = "deleteDate",type = String.class),
                		@ColumnResult(name = "createBy",type = String.class),
                		//@ColumnResult(name = "createDateTime",type = String.class),
                		@ColumnResult(name = "inputSupplierName",type = String.class),
                		@ColumnResult(name = "email",type = String.class),
                		@ColumnResult(name = "mobileNumber",type = BigInteger.class),
                })
})
@SqlResultSetMapping(name="InputSupplierDTO",
		classes = {@ConstructorResult(
		targetClass = InputSupplierDTO.class,
		columns = {
				@ColumnResult(name = "input_supplier_id", type = Integer.class),
				@ColumnResult(name = "input_supplier_name", type = String.class),
				@ColumnResult(name = "user_name", type = String.class),
				@ColumnResult(name = "input_supplier_type", type = Integer.class),
				@ColumnResult(name = "district_id", type = Integer.class),
				@ColumnResult(name = "district_name", type = String.class),
				@ColumnResult(name = "block_id", type = Integer.class),
				@ColumnResult(name = "block_name", type = String.class),
				@ColumnResult(name = "village_id", type = Integer.class),
				@ColumnResult(name = "village_name", type = String.class),
				@ColumnResult(name = "pincode", type = Long.class),
				@ColumnResult(name = "email", type = String.class),
				@ColumnResult(name = "mobile_number", type = Long.class),
				@ColumnResult(name = "contact_person", type = String.class),
				@ColumnResult(name = "license_number", type = String.class),
				@ColumnResult(name = "gst_number", type = String.class),
				@ColumnResult(name = "equipment", type = String.class),
				@ColumnResult(name = "fertilizer", type = String.class),
				@ColumnResult(name = "cide", type = String.class),
				@ColumnResult(name = "category_deal", type = String.class)
		})
})
@Table(name="input_supplier")
public class InputSupplierMaster implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "input_supplier_id")
	private Integer inputSupplierId;
	
	@Column(name="input_supplier_name")
	private String inputSupplierName;
	
	@Column(name="input_supplier_type")
	private Integer inputSupplierType;
	
	@Column(name="dist_ref_id")
	private Integer distRefId;
	
	@Column(name="block_ref_id")
	private Integer blockRefId;
	
	@Column(name="village_ref_id")
	private Integer villageRefId;
	
	@Column(name="pincode")
	private long pincode;
	
	@Column(name="email")
	@Email(message = "Please provide valid email id")
	private String email;
	
	@Column(name="mobile_number",nullable = false)
	@NotNull(message = "Mobile number should not be null")
	@Min(10)
	private long mobile_number;
	
	@Column(name="contact_person")
	private String contact_person;
	
	@Column(name="license_number")
	private String license_number;
	
	@Column(name="gst_number")
	private String gstNumber;
	
	@Column(name="is_deleted")
	private boolean isDeleted;
	
//	@Column(name="seed_id")
//	private Integer seed_id;

//	@Column(name="Fertilizer")
//	private String Fertilizer;
//	
//	@Column(name="cide")
//	private String cide;
//	
//	@Column(name="Equipment")
//	private String Equipment;
	
	@Column(name="category_deal")
	private String categoryDeal;
	
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="user_id")
	private User userInputSeller;

	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="input_supplier_id",referencedColumnName="input_supplier_id")
	private List<InputSupplierSeed> inputSupplierSeeds;

	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="input_supplier_id",referencedColumnName="input_supplier_id")
	private List <InputSupplierMachinery> inputSupplierMachineries;

	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="input_supplier_id",referencedColumnName="input_supplier_id")
	private List <InputSupplierFertilizer> inputSupplierFertilizers;

	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="input_supplier_id",referencedColumnName="input_supplier_id")
	private List <InputSupplierInsecticide> inputSupplierInsecticides;


	public User getUserInputSeller() {
		return userInputSeller;
	}

	public void setUserInputSeller(User userInputSeller) {
		this.userInputSeller = userInputSeller;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getInputSupplierId() {
		return inputSupplierId;
	}

	public void setInputSupplierId(Integer inputSupplierId) {
		this.inputSupplierId = inputSupplierId;
	}

	public String getInputSupplierName() {
		return inputSupplierName;
	}

	public void setInputSupplierName(String inputSupplierName) {
		this.inputSupplierName = inputSupplierName;
	}

	public Integer getInputSupplierType() {
		return inputSupplierType;
	}

	public void setInputSupplierType(Integer inputSupplierType) {
		this.inputSupplierType = inputSupplierType;
	}

	public Integer getDistRefId() {
		return distRefId;
	}

	public void setDistRefId(Integer distRefId) {
		this.distRefId = distRefId;
	}

	public Integer getBlockRefId() {
		return blockRefId;
	}

	public void setBlockRefId(Integer blockRefId) {
		this.blockRefId = blockRefId;
	}

	public Integer getVillageRefId() {
		return villageRefId;
	}

	public void setVillageRefId(Integer villageRefId) {
		this.villageRefId = villageRefId;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getContact_person() {
		return contact_person;
	}

	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}

	public String getLicense_number() {
		return license_number;
	}

	public void setLicense_number(String license_number) {
		this.license_number = license_number;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getCategoryDeal() {
		return categoryDeal;
	}

	public void setCategoryDeal(String categoryDeal) {
		this.categoryDeal = categoryDeal;
	}

//	public Integer getSeed_id() {
//		return seed_id;
//	}
//
//	public String getFertilizer() {
//		return Fertilizer;
//	}
//
//	public void setFertilizer(String fertilizer) {
//		Fertilizer = fertilizer;
//	}
//
//	public String getCide() {
//		return cide;
//	}
//	
//	public void setSeed_id(Integer seed_id) {
//		this.seed_id = seed_id;
//	}
//
//	public void setCide(String cide) {
//		this.cide = cide;
//	}
//
//	public String getEquipment() {
//		return Equipment;
//	}
//
//	public void setEquipment(String equipment) {
//		Equipment = equipment;
//	}


	public List<InputSupplierSeed> getInputSupplierSeeds() {
		return inputSupplierSeeds;
	}

	public void setInputSupplierSeeds(List<InputSupplierSeed> inputSupplierSeeds) {
		this.inputSupplierSeeds = inputSupplierSeeds;
	}

	public List<InputSupplierMachinery> getInputSupplierMachineries() {
		return inputSupplierMachineries;
	}

	public void setInputSupplierMachineries(List<InputSupplierMachinery> inputSupplierMachineries) {
		this.inputSupplierMachineries = inputSupplierMachineries;
	}

	public List<InputSupplierFertilizer> getInputSupplierFertilizers() {
		return inputSupplierFertilizers;
	}

	public void setInputSupplierFertilizers(List<InputSupplierFertilizer> inputSupplierFertilizers) {
		this.inputSupplierFertilizers = inputSupplierFertilizers;
	}

	public List<InputSupplierInsecticide> getInputSupplierInsecticides() {
		return inputSupplierInsecticides;
	}

	public void setInputSupplierInsecticides(List<InputSupplierInsecticide> inputSupplierInsecticides) {
		this.inputSupplierInsecticides = inputSupplierInsecticides;
	}
}
