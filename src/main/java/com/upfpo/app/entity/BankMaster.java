
package com.upfpo.app.entity;

import com.upfpo.app.dto.UpAgriBankDataDto;
import com.upfpo.app.dto.UpAgriDataDto;

import java.io.Serializable;

import javax.persistence.*;


@SqlResultSetMapping(name="UpAgriBankDataDto",
		classes = {
				@ConstructorResult(
						targetClass = UpAgriBankDataDto.class,
						columns = {
								@ColumnResult(name = "bank_id", type = Integer.class),
								@ColumnResult(name = "bank_name", type = String.class)
						})
		})
@Entity
@Table(name="banks")
public class BankMaster implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bank_id")
	private Integer bankId;
	
	@Column(name="bank_name")
	private String  bankName;
	
	@Column(name="bank_name_hi")
	private String bankNameHi;
	
	public String getBankNameHi() {
		return bankNameHi;
	}

	public void setBankNameHi(String bankNameHi) {
		this.bankNameHi = bankNameHi;
	}

	public BankMaster() {		
	}
	
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "BankMaster [bankId=" + bankId + ", bankName=" + bankName + "]";
	}		
}
