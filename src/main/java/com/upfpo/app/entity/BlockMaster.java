package com.upfpo.app.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.upfpo.app.dto.UpAgriDataDto;

@Entity

@SqlResultSetMapping(name="UpAgriDataDto",
classes = {
    @ConstructorResult(
            targetClass = UpAgriDataDto.class,
            columns = {
            	@ColumnResult(name = "district_id", type = Integer.class),
            	@ColumnResult(name = "district_name", type = String.class),
            	@ColumnResult(name = "block_id", type = Integer.class),
            	@ColumnResult(name = "block_name", type = String.class),
            	@ColumnResult(name = "village_id", type = Integer.class),
            	@ColumnResult(name = "village_name", type = String.class)
           })
})


@Table(name="block")
public class BlockMaster implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="block_id")
	private Integer id;
	
	@Column(name="state_code")
	private Integer stateCode;
	
	@Column(name="block_code")
	private Integer blockCode;
	
	@Column(name="block_name")
	private String blockName;
	
	@Column(name="block_name_hi")
	private String blockNameHi;
	
	@Column(name="district_code")
	private Integer distCode;
	
	@Column(name="district_id")
	private Integer distId;

	public BlockMaster() {
	}


	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStateCode() {
		return stateCode;
	}
	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}
	public Integer getBlockCode() {
		return blockCode;
	}
	public void setBlockCode(Integer blockCode) {
		this.blockCode = blockCode;
	}
	public Integer getDistCode() {
		return distCode;
	}
	public void setDistCode(Integer distCode) {
		this.distCode = distCode;
	}
	
	public Integer getDistId() {
		return distId;
	}
	public void setDistId(Integer distId) {
		this.distId = distId;
	}
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public String getBlockNameHi() {
		return blockNameHi;
	}
	public void setBlockNameHi(String blockNameHi) {
		this.blockNameHi = blockNameHi;
	}
}
