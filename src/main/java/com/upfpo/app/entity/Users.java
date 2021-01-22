package com.upfpo.app.entity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="pass")
	private String password;
	
	@Column(name="enabled")
	private boolean isEnabled;
	
	@Column(name="role_ref_id")
	private String roleRefId;
	
	@Column(name="is_changed")
	private boolean isChanged;
	
	@Column(name="is_deleted")
	private boolean isDeleted;
	
	@Column(name="delete_date")
	private Date deleteDate;
	
	@Column(name="deleted_by")
	private Integer dateletedBy;
	
	@Column(name="activated_by")
	private Integer activatedBy;
	
	@Column(name="activate_date")
	private Date activateDate;
	
	@Column(name="deactivated_by")
	private Integer deActivatedBy;
	
	@Column(name="deactivate_date")
	private Date deActivateDate;
	
	@Column(name="reason")
	private String reason;


	
	private String captcha;
	
	public Users() {
		super();	
	}
	
	public Users(String userName, String password, boolean isEnabled, String roleRefId) {
		super();	
		this.userName = userName;
		this.password = password;
		this.isEnabled = isEnabled;
		this.roleRefId = roleRefId;
	}

	public String getRoleRefId() {
		return roleRefId;
	}
	public void setRoleRefId(String roleRefId) {
		this.roleRefId = roleRefId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public boolean isChanged() {
		return isChanged;
	}

	public void setChanged(boolean isChanged) {
		this.isChanged = isChanged;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public Integer getDateletedBy() {
		return dateletedBy;
	}

	public void setDateletedBy(Integer dateletedBy) {
		this.dateletedBy = dateletedBy;
	}

	public Integer getActivatedBy() {
		return activatedBy;
	}

	public void setActivatedBy(Integer activatedBy) {
		this.activatedBy = activatedBy;
	}

	public Date getActivateDate() {
		return activateDate;
	}

	public void setActivateDate(Date activateDate) {
		this.activateDate = activateDate;
	}

	public Integer getDeActivatedBy() {
		return deActivatedBy;
	}

	public void setDeActivatedBy(Integer deActivatedBy) {
		this.deActivatedBy = deActivatedBy;
	}

	public Date getDeActivateDate() {
		return deActivateDate;
	}

	public void setDeActivateDate(Date deActivateDate) {
		this.deActivateDate = deActivateDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
}
