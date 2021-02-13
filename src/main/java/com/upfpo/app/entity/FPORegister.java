package com.upfpo.app.entity;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.Errors;

import com.upfpo.app.dto.DisplayDataDTO;


@Entity

@SqlResultSetMapping(name="DisplayDataDTO",
classes = {
    @ConstructorResult(
            targetClass = DisplayDataDTO.class,
            columns = {
                @ColumnResult(name = "totalfarmers", type = BigInteger.class),
                @ColumnResult(name = "smalltotal", type = BigInteger.class),
                @ColumnResult(name = "bigfarmers", type = BigInteger.class),
                @ColumnResult(name = "marginalfarmers", type = BigInteger.class),
                @ColumnResult(name = "totalland", type = Double.class)
           })
})
@Table(name ="fpo")
public class FPORegister implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fpo_id")
	private Integer fpoId;
	
	@Column (name="state_ref")
	private Integer stateref;
	
	@Column(name = "dist_ref_id")
	private Integer distRefId;
	
	@Column(name="agency_associated")
	private String agency;
	
	@Column(name="pincode")
	private Integer pincode;
	
	@Column(name="blockId")
	private Integer blockRef;
	
	@NotNull(message="Please Provide the Name")
	@Column(name = "fpo_name")
	private String fpoName;
	
	@Column(name = "fpo_address")
	private String fpoAddress;
	
	@Column(name = "date_of_regi")
	private String dateOfRegistration;
	
	@Column(name = "fpo_landline")
	private BigInteger fpolandLine;
	
	@Email
	@NotNull(message = "Please provide email id")
	@Column(name = "fpo_email")
	private String fpoEmail;
	
	@Column(name = "fpo_lot_no")
	private String fpoLotNo;
	
	@Column(name = "fpo_bank_name")
	private Integer fpoBankName;
	
	@Column(name = "fpo_account_no")
	private BigInteger fpoBankAccNo;
	
    @NotBlank(message="Please Provide the Valid IFSC Code")
	@Column(name = "fpo_ifsc")
	private String fpoIFSC;

	@Column(name = "description")
	private String description ;

	/*
	 * @Column(name="users_id") private long userRefId;
	 */
	
	@Length(min=6,max=20,message="Username Should be in between 6 to 20 Characters")
	@Column(name="username")
	private String userName;
	
	@Column(name="update_date")
	private Date updateDate;
	
	@Column(name="create_date")
	private Date createdate;
	
	
	@Column(name = "total_fmb")
	private Integer fmbno;
	
	@Column(name = "total_seedprocessing")
	private Integer seedprocessingunitno;
	
	@Column(name = "total_farmers")
	private Integer totalfarmers;
	
	@Column(name = "total_big_farmers")
	private Integer totalbfarmer;
	
	@Column(name = "total_marginal_farmers")
	private Integer totalmfarmer;
	
	@Column(name = "total_small_farmers")
	private Integer totalsfarmer;
	
	@Column(name = "total_land")
	private Double totalland;
	
	@Column(name="is_deleted")
    private Boolean isDeleted;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="fpo_id")
	@Fetch(value=FetchMode.SELECT)
	private List <PhotoUpload> photoUpload;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="master_id",referencedColumnName="fpo_id")
	private List <ProductionDetails> productionDetails;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="master_id",referencedColumnName="fpo_id")
	private List <BoardMember> boardMember;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="master_id",referencedColumnName="fpo_id")
	private List <FpoLicenceDetails> fpoLicenceDetails;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="master_id",referencedColumnName="fpo_id")
	private List <FarmMachineryBank> farmMachineryBank;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="fpo_id")
	private List <FpoAdditionalServices> fpoAdditionalServices;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="user_id")
	private User userFpo;
	
	public User getUserFpo() {
		return userFpo;
	}

	public void setUserFpo(User userFpo) {
		this.userFpo = userFpo;
	}

	/*
	 * @NotEmpty(message="required")
	 * 
	 * @Column(name = "board_mem_name") private String fpoBoardMemName;
	 * 
	 * @NotNull(message="required")
	 * 
	 * @Min(1)
	 * 
	 * @Column(name = "board_mem_mob") private Long fpoBoardMemMob;
	 * 
	 * @NotEmpty(message="required")
	 * 
	 * @Column(name = "board_mem_email") private String fpoBoardMemEmail;
	 * 
	 * @NotEmpty(message="required")
	 * 
	 * @Column(name = "board_mem_designation") private String fpoBoardMemDesig;
	 */
	public FPORegister() {

	}



	public Integer getFpoId() {
		return fpoId;
	}

	public void setFpoId(Integer fpoId) {
		this.fpoId = fpoId;
	}

	public Integer getDistRefId() {
		return distRefId;
	}

	public void setDistRefId(Integer distRefId) {
		this.distRefId = distRefId;
	}

	public String getFpoName() {
		return fpoName;
	}

	public void setFpoName(String fpoName) {
		this.fpoName = fpoName;
	}

	public String getFpoAddress() {
		return fpoAddress;
	}

	public void setFpoAddress(String fpoAddress) {
		this.fpoAddress = fpoAddress;
	}

	public BigInteger getFpolandLine() {
		return fpolandLine;
	}

	public void setFpolandLine(BigInteger fpolandLine) {
		this.fpolandLine = fpolandLine;
	}

	public String getFpoEmail() {
		return fpoEmail;
	}

	public void setFpoEmail(String fpoEmail) {
		this.fpoEmail = fpoEmail;
	}

	public String getFpoLotNo() {
		return fpoLotNo;
	}

	public void setFpoLotNo(String fpoLotNo) {
		this.fpoLotNo = fpoLotNo;
	}

	public Integer getFpoBankName() {
		return fpoBankName;
	}

	public void setFpoBankName(Integer fpoBankName) {
		this.fpoBankName = fpoBankName;
	}

	public BigInteger getFpoBankAccNo() {
		return fpoBankAccNo;
	}

	public void setFpoBankAccNo(BigInteger fpoBankAccNo) {
		this.fpoBankAccNo = fpoBankAccNo;
	}

	public String getFpoIFSC() {
		return fpoIFSC;
	}

	public void setFpoIFSC(String fpoIFSC) {
		this.fpoIFSC = fpoIFSC;
	}

	/*
	 * public Long getUserRefId() { return userRefId; }
	 * 
	 * public void setUserRefId(Long userRefId) { this.userRefId = userRefId; }
	 */

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Integer getStateref() {
		return stateref;
	}

	public void setStateref(Integer stateref) {
		this.stateref = stateref;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Integer getBlockRef() {
		return blockRef;
	}

	public void setBlockRef(Integer blockRef) {
		this.blockRef = blockRef;
	}


	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public Integer getFmbno() {
		return fmbno;
	}

	public void setFmbno(Integer fmbno) {
		this.fmbno = fmbno;
	}

	public Integer getSeedprocessingunitno() {
		return seedprocessingunitno;
	}

	public void setSeedprocessingunitno(Integer seedprocessingunitno) {
		this.seedprocessingunitno = seedprocessingunitno;
	}

	public Integer getTotalfarmers() {
		return totalfarmers;
	}

	public void setTotalfarmers(Integer totalfarmers) {
		this.totalfarmers = totalfarmers;
	}

	public Integer getTotalbfarmer() {
		return totalbfarmer;
	}

	public void setTotalbfarmer(Integer totalbfarmer) {
		this.totalbfarmer = totalbfarmer;
	}

	public Integer getTotalmfarmer() {
		return totalmfarmer;
	}

	public void setTotalmfarmer(Integer totalmfarmer) {
		this.totalmfarmer = totalmfarmer;
	}

	public Integer getTotalsfarmer() {
		return totalsfarmer;
	}

	public void setTotalsfarmer(Integer totalsfarmer) {
		this.totalsfarmer = totalsfarmer;
	}

	public Double getTotalland() {
		return totalland;
	}

	public void setTotalland(Double totalland) {
		this.totalland = totalland;
	}

	public Boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public List<PhotoUpload> getPhotoUpload() {
		return photoUpload;
	}

	public void setPhotoUpload(List<PhotoUpload> photoUpload) {
		this.photoUpload = photoUpload;
	}

	public List<BoardMember> getBoardMember() {
		return boardMember;
	}

	public void setBoardMember(List<BoardMember> boardMember) {
		this.boardMember = boardMember;
	}

	public List<FpoLicenceDetails> getFpoLicenceDetails() {
		return fpoLicenceDetails;
	}

	public void setFpoLicenceDetails(List<FpoLicenceDetails> fpoLicenceDetails) {
		this.fpoLicenceDetails = fpoLicenceDetails;
	}

	public List<FpoAdditionalServices> getFpoAdditionalServices() {
		return fpoAdditionalServices;
	}

	public void setFpoAdditionalServices(List<FpoAdditionalServices> fpoAdditionalServices) {
		this.fpoAdditionalServices = fpoAdditionalServices;
	}

	public List<ProductionDetails> getProductionDetails() {
		return productionDetails;
	}

	public void setProductionDetails(List<ProductionDetails> productionDetails) {
		this.productionDetails = productionDetails;
	}

	public List<FarmMachineryBank> getFarmMachineryBank() {
		return farmMachineryBank;
	}

	public void setFarmMachineryBank(List<FarmMachineryBank> farmMachineryBank) {
		this.farmMachineryBank = farmMachineryBank;
	}	
	
}
