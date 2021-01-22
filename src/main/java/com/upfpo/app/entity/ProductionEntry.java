package com.upfpo.app.entity;
import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="production_entry")
public class ProductionEntry {
	
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name="entry_id")
		private Integer entryId;      	
	    
	    @Column(name="farmer_id")
	   	private Integer farmerId;
	    
	    @Column(name="parents_name")
	    private String guardianName;
	 
	    @Column(name="financial_year")
		private String  financialYear;
	    
	    @Column(name="master_id")
	    private Integer masterId;
	    
	    @Column(name="create_date")
	    private Date createDate;

	    @Column(name="update_date")
	    private Date updateDate;

	    @Column(name="delete_date")
	    private Date deleteDate;
	    
	    @Column(name="updated_by")
	 	private String  updatedBy;
	    
	    @Column(name="created_by")
	    private String createdBy;
	    
	    @Column(name="deleted_by")
	    private String deletedBy;
	    
	    @Column(name="seasonId")
	    private Integer seasonId;

	    @OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="entry_id")
		private List<ProductionDetails> productions;
	    
	    
	    
		public Integer getEntryId() {
			return entryId;
		}

		public void setEntryId(Integer entryId) {
			this.entryId = entryId;
		}

		public Integer getFarmerId() {
			return farmerId;
		}

		public void setFarmerId(Integer farmerId) {
			this.farmerId = farmerId;
		}

		public String getFinancialYear() {
			return financialYear;
		}

		public void setFinancialYear(String financialYear) {
			this.financialYear = financialYear;
		}

		public Integer getMasterId() {
			return masterId;
		}

		public void setMasterId(Integer masterId) {
			this.masterId = masterId;
		}

		public Date getCreateDate() {
			return createDate;
		}

		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}

		public Date getUpdateDate() {
			return updateDate;
		}

		public void setUpdateDate(Date updateDate) {
			this.updateDate = updateDate;
		}

		public Date getDeleteDate() {
			return deleteDate;
		}

		public void setDeleteDate(Date deleteDate) {
			this.deleteDate = deleteDate;
		}

		public String getUpdatedBy() {
			return updatedBy;
		}

		public void setUpdatedBy(String updatedBy) {
			this.updatedBy = updatedBy;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public String getDeletedBy() {
			return deletedBy;
		}

		public void setDeletedBy(String deletedBy) {
			this.deletedBy = deletedBy;
		}


		public Integer getSeasonId() {
			return seasonId;
		}

		public void setSeasonId(Integer seasonId) {
			this.seasonId = seasonId;
		}

		public List<ProductionDetails> getProductions() {
			return productions;
		}

		public void setProductions(List<ProductionDetails> productions) {
			this.productions = productions;
		}

		public String getGuardianName() {
			return guardianName;
		}

		public void setGuardianName(String guardianName) {
			this.guardianName = guardianName;
		}
		
		
		
}
