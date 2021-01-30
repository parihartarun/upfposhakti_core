package com.upfpo.app.dto;
import java.io.Serializable;
import java.math.BigInteger;

public class DataDisplayDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String state;
	private String nodal;
	private String designation;
	private BigInteger mobile;
	private String email;
	private String unitassla;
	private String associationdate;
	private String district;
	private java.sql.Date upload_date;
	private String education;
	private String fpo_lot_no;
	private String season_name;
	private String category;
	private String crop_name;
	private String crop_variety;
	private Double marketable_quantity;
	private Double sold_quantity;
	private Double actual_quantity;
	private String farmer_parants;
	private String services;
	private String assigned_to;
	private String assigned_date;
	private String financial_year;
	private String state_name;
	private String district_name;
	private String center_address;
	private BigInteger storage_capacity;
	private String fascilities;
	private String agency_associated;
	private Integer farmer_id;
	private String farmer_name;
	private String storage_type;
	private String gender;
	private Integer total_fmb;
	private Double total_land;
	private Integer total_farmers;
	private Integer total_seedprocessing;
	private String issue_type;
	private String description;
	private String file_path;
	private String remarks;
	private String status_name;
	private String fpo_name;
	private String fpo_address;
	private String fpo_email;
	private String equpment_name;
	private Integer quantity;
	private String crops;
	private BigInteger marginalFarmer;
	private BigInteger smallFarmer;
	private BigInteger bigFarmer;
	private Integer panchayat_id;
	private String  panchayat_name;
	private String guardian_name;
	private Integer member_id;;
	private String member_name;
	private String member_designation;
	private BigInteger member_contact;
	private String member_email;
	private Integer district_id;
	private Integer block_id;
	private String block_name;
    private Integer village_id;
    private String village_name;
    private Integer veriety_ref;
    private Integer crop_ref_name;
    private Integer season_ref;
    private String crop_veriety;
    private Integer district_ref_id;
    private Integer village_ref_id;
    private String address;
    private Integer education_ref_id;
    private String bank_name;
    private Integer bank_ref_id;
    private String ifsccode;
    private BigInteger accountno;
    private String farm_gen; 
    private String farm_category;
    private Integer blockid;
    private Integer pincode;
    private BigInteger farmer_mob;
    private String date_associated;
    private Integer vill_panchayat_ref_id;
    
    
    
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getNodal() {
		return nodal;
	}
	public void setNodal(String nodal) {
		this.nodal = nodal;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public BigInteger getMobile() {
		return mobile;
	}
	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUnitassla() {
		return unitassla;
	}
	public void setUnitassla(String unitassla) {
		this.unitassla = unitassla;
	}
	public String getAssociationdate() {
		return associationdate;
	}
	public void setAssociationdate(String associationdate) {
		this.associationdate = associationdate;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getSeason_name() {
		return season_name;
	}
	public void setSeason_name(String season_name) {
		this.season_name = season_name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCrop_name() {
		return crop_name;
	}
	public void setCrop_name(String crop_name) {
		this.crop_name = crop_name;
	}
	
	public String getFinancial_year() {
		return financial_year;
	}
	public void setFinancial_year(String financial_year) {
		this.financial_year = financial_year;
	}
	
	public String getFpo_lot_no() {
		return fpo_lot_no;
	}
	public void setFpo_lot_no(String fpo_lot_no) {
		this.fpo_lot_no = fpo_lot_no;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public String getDistrict_name() {
		return district_name;
	}
	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}
	public String getCenter_address() {
		return center_address;
	}
	public void setCenter_address(String center_address) {
		this.center_address = center_address;
	}
	public BigInteger getStorage_capacity() {
		return storage_capacity;
	}
	public void setStorage_capacity(BigInteger storage_capacity) {
		this.storage_capacity = storage_capacity;
	}
	public String getFascilities() {
		return fascilities;
	}
	public void setFascilities(String fascilities) {
		this.fascilities = fascilities;
	}
	public String getAgency_associated() {
		return agency_associated;
	}
	public void setAgency_associated(String agency_associated) {
		this.agency_associated = agency_associated;
	}
	public Integer getFarmer_id() {
		return farmer_id;
	}
	public void setFarmer_id(Integer farmer_id) {
		this.farmer_id = farmer_id;
	}
	public String getFarmer_name() {
		return farmer_name;
	}
	public void setFarmer_name(String farmer_name) {
		this.farmer_name = farmer_name;
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
	public String getFpo_email() {
		return fpo_email;
	}
	public void setFpo_email(String fpo_email) {
		this.fpo_email = fpo_email;
	}
	public String getEqupment_name() {
		return equpment_name;
	}
	public void setEqupment_name(String equpment_name) {
		this.equpment_name = equpment_name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getCrops() {
		return crops;
	}
	public void setCrops(String crops) {
		this.crops = crops;
	}
	public BigInteger getMarginalFarmer() {
		return marginalFarmer;
	}
	public void setMarginalFarmer(BigInteger marginalFarmer) {
		this.marginalFarmer = marginalFarmer;
	}
	public BigInteger getSmallFarmer() {
		return smallFarmer;
	}
	public void setSmallFarmer(BigInteger smallFarmer) {
		this.smallFarmer = smallFarmer;
	}
	public BigInteger getBigFarmer() {
		return bigFarmer;
	}
	public void setBigFarmer(BigInteger bigFarmer) {
		this.bigFarmer = bigFarmer;
	}
	public String getStorage_type() {
		return storage_type;
	}
	public void setStorage_type(String storage_type) {
		this.storage_type = storage_type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Double getMarketable_quantity() {
		return marketable_quantity;
	}
	public void setMarketable_quantity(Double marketable_quantity) {
		this.marketable_quantity = marketable_quantity;
	}
	
	public Double getActual_quantity() {
		return actual_quantity;
	}
	public void setActual_quantity(Double actual_quantity) {
		this.actual_quantity = actual_quantity;
	}
	public Integer getTotal_fmb() {
		return total_fmb;
	}
	public void setTotal_fmb(Integer total_fmb) {
		this.total_fmb = total_fmb;
	}
	public Double getTotal_land() {
		return total_land;
	}
	public void setTotal_land(Double total_land) {
		this.total_land = total_land;
	}
	public Integer getTotal_farmers() {
		return total_farmers;
	}
	public void setTotal_farmers(Integer total_farmers) {
		this.total_farmers = total_farmers;
	}
	public Integer getTotal_seedprocessing() {
		return total_seedprocessing;
	}
	public void setTotal_seedprocessing(Integer total_seedprocessing) {
		this.total_seedprocessing = total_seedprocessing;
	}
	public String getFarmer_parants() {
		return farmer_parants;
	}
	public void setFarmer_parants(String farmer_parants) {
		this.farmer_parants = farmer_parants;
	}
	public Double getSold_quantity() {
		return sold_quantity;
	}
	public void setSold_quantity(Double sold_quantity) {
		this.sold_quantity = sold_quantity;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getCrop_variety() {
		return crop_variety;
	}
	public void setCrop_variety(String crop_variety) {
		this.crop_variety = crop_variety;
	}
	public String getIssue_type() {
		return issue_type;
	}
	public void setIssue_type(String issue_type) {
		this.issue_type = issue_type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getStatus_name() {
		return status_name;
	}
	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}
	public String getAssigned_to() {
		return assigned_to;
	}
	public void setAssigned_to(String assigned_to) {
		this.assigned_to = assigned_to;
	}
	public String getAssigned_date() {
		return assigned_date;
	}
	public void setAssigned_date(String assigned_date) {
		this.assigned_date = assigned_date;
	}
	public java.sql.Date getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(java.sql.Date upload_date) {
		this.upload_date = upload_date;
	}
	public Integer getPanchayat_id() {
		return panchayat_id;
	}
	public void setPanchayat_id(Integer panchayat_id) {
		this.panchayat_id = panchayat_id;
	}
	public String getPanchayat_name() {
		return panchayat_name;
	}
	public void setPanchayat_name(String panchayat_name) {
		this.panchayat_name = panchayat_name;
	}
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_designation() {
		return member_designation;
	}
	public void setMember_designation(String member_designation) {
		this.member_designation = member_designation;
	}
	public BigInteger getMember_contact() {
		return member_contact;
	}
	public void setMember_contact(BigInteger member_contact) {
		this.member_contact = member_contact;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public Integer getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(Integer district_id) {
		this.district_id = district_id;
	}
	public Integer getBlock_id() {
		return block_id;
	}
	public void setBlock_id(Integer block_id) {
		this.block_id = block_id;
	}
	public String getBlock_name() {
		return block_name;
	}
	public void setBlock_name(String block_name) {
		this.block_name = block_name;
	}
	public Integer getVillage_id() {
		return village_id;
	}
	public void setVillage_id(Integer village_id) {
		this.village_id = village_id;
	}
	public String getVillage_name() {
		return village_name;
	}
	public void setVillage_name(String village_name) {
		this.village_name = village_name;
	}
	public String getGuardian_name() {
		return guardian_name;
	}
	public void setGuardian_name(String guardian_name) {
		this.guardian_name = guardian_name;
	}
	public Integer getVeriety_ref() {
		return veriety_ref;
	}
	public void setVeriety_ref(Integer veriety_ref) {
		this.veriety_ref = veriety_ref;
	}
	public Integer getCrop_ref_name() {
		return crop_ref_name;
	}
	public void setCrop_ref_name(Integer crop_ref_name) {
		this.crop_ref_name = crop_ref_name;
	}
	public Integer getSeason_ref() {
		return season_ref;
	}
	public void setSeason_ref(Integer season_ref) {
		this.season_ref = season_ref;
	}
	public String getCrop_veriety() {
		return crop_veriety;
	}
	public void setCrop_veriety(String crop_veriety) {
		this.crop_veriety = crop_veriety;
	}
	public Integer getDistrict_ref_id() {
		return district_ref_id;
	}
	public void setDistrict_ref_id(Integer district_ref_id) {
		this.district_ref_id = district_ref_id;
	}
	public Integer getVillage_ref_id() {
		return village_ref_id;
	}
	public void setVillage_ref_id(Integer village_ref_id) {
		this.village_ref_id = village_ref_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getEducation_ref_id() {
		return education_ref_id;
	}
	public void setEducation_ref_id(Integer education_ref_id) {
		this.education_ref_id = education_ref_id;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public Integer getBank_ref_id() {
		return bank_ref_id;
	}
	public void setBank_ref_id(Integer bank_ref_id) {
		this.bank_ref_id = bank_ref_id;
	}
	public String getIfsccode() {
		return ifsccode;
	}
	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}
	public BigInteger getAccountno() {
		return accountno;
	}
	public void setAccountno(BigInteger accountno) {
		this.accountno = accountno;
	}
	public String getFarm_gen() {
		return farm_gen;
	}
	public void setFarm_gen(String farm_gen) {
		this.farm_gen = farm_gen;
	}
	public String getFarm_category() {
		return farm_category;
	}
	public void setFarm_category(String farm_category) {
		this.farm_category = farm_category;
	}
	public Integer getBlockid() {
		return blockid;
	}
	public void setBlockid(Integer blockid) {
		this.blockid = blockid;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public BigInteger getFarmer_mob() {
		return farmer_mob;
	}
	public void setFarmer_mob(BigInteger farmer_mob) {
		this.farmer_mob = farmer_mob;
	}
	public String getDate_associated() {
		return date_associated;
	}
	public void setDate_associated(String date_associated) {
		this.date_associated = date_associated;
	}
	public Integer getVill_panchayat_ref_id() {
		return vill_panchayat_ref_id;
	}
	public void setVill_panchayat_ref_id(Integer vill_panchayat_ref_id) {
		this.vill_panchayat_ref_id = vill_panchayat_ref_id;
	}
}
