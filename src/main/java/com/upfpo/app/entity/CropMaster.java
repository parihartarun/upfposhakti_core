package com.upfpo.app.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.upfpo.app.dto.CropAndVerietyList;
import com.upfpo.app.dto.CropMasterDto;
import com.upfpo.app.dto.FPODetailsDTO;
import com.upfpo.app.dto.FilterDto;
import com.upfpo.app.dto.SearchResponseDto;
import com.upfpo.app.dto.search.FmbSearchDtoAll;
import com.upfpo.app.dto.search.InputSupplierSearchDtoAll;




@SqlResultSetMapping(name = "fmbValueResultMapping", 
classes = @ConstructorResult( 
        targetClass = FmbSearchDtoAll.class, 
        columns = {        		
        		@ColumnResult(name = "vendorid"),
        		@ColumnResult(name = "vendorname"),
        		@ColumnResult(name = "imagepath"),
        		@ColumnResult(name = "company"),
        		@ColumnResult(name = "machinetypeid"),
        		@ColumnResult(name = "machinetype"),
        		@ColumnResult(name = "quantity"),
        		@ColumnResult(name = "districtid"),
        		@ColumnResult(name = "district"),
        		@ColumnResult(name = "rent"),
        		@ColumnResult(name = "machinenameid"),
        		@ColumnResult(name = "machinename"),
        		@ColumnResult(name = "recordtype"),
        		@ColumnResult(name = "role")
                    }
        )
)


@SqlResultSetMapping(name = "inputSupplierResultMapping", 
classes = @ConstructorResult(
        targetClass = InputSupplierSearchDtoAll.class, 
        columns = {
        		        		
        		@ColumnResult(name = "id"),
        		@ColumnResult(name = "itemname"),
        		@ColumnResult(name = "itemtypeid"),
        		@ColumnResult(name = "itemtype"),
        		@ColumnResult(name = "quantity"),
        		@ColumnResult(name = "inputsupplierid"),
        		@ColumnResult(name = "inputsupplier"),
        		@ColumnResult(name = "districtid"),
        		@ColumnResult(name = "district"),
        		@ColumnResult(name = "imagepath"),
        		@ColumnResult(name = "manufacturer"),
        		@ColumnResult(name = "crop"),
        		@ColumnResult(name = "cropid"),
        		@ColumnResult(name = "cropveriety"),
        		@ColumnResult(name = "cropverietyid"),
        		@ColumnResult(name = "recordtype"),
        		@ColumnResult(name = "role")
                    }
        )
)




@SqlResultSetMapping(name = "BookValueMapping", 
classes = @ConstructorResult(
        targetClass = FilterDto.class, 
        columns = {
        		@ColumnResult(name = "name"),
        		@ColumnResult(name = "id")
                    }
        )
)

@SqlResultSetMapping(name = "CropValueMapping", 
classes = @ConstructorResult(
        targetClass = CropAndVerietyList.class, 
        columns = { @ColumnResult(name = "cropName",type=String.class),
                    @ColumnResult(name = "cropId",type=Integer.class),
                    @ColumnResult(name = "verietyName",type=String.class),
                    @ColumnResult(name = "verietyId",type=Integer.class)
        }
        )
       

)

@SqlResultSetMapping(name = "SearchResponseDTO", 
classes = @ConstructorResult(
        targetClass = SearchResponseDto.class, 
        columns = { @ColumnResult(name = "fpoid",type=Long.class),
                    @ColumnResult(name = "fpo",type=String.class),
                    @ColumnResult(name = "districtid",type=Integer.class),
                    @ColumnResult(name = "district",type=String.class),
                    @ColumnResult(name = "cropid",type=Integer.class),
                    @ColumnResult(name = "crop",type=String.class),       
                    @ColumnResult(name = "varietyid",type=Integer.class),
                    @ColumnResult(name = "variety",type=String.class),
                    @ColumnResult(name = "currentMarketable",type=Double.class),
                    @ColumnResult(name = "role",type=String.class)
                    
        }
        )
    
        

)

@SqlResultSetMapping(name = "SearchDistrictMapper", classes = @ConstructorResult(
	    targetClass = FilterDto.class,
	    columns = {
	            @ColumnResult(name = "districtName", type = String.class),
	            @ColumnResult(name = "districtId", type = Integer.class)
	    }))

@SqlResultSetMapping(name="FPODetailsDTO",
classes = {
		  @ConstructorResult(targetClass = FPODetailsDTO.class, 
		  columns = {
		  @ColumnResult(name = "id", type = Integer.class),
		  @ColumnResult(name = "cropid", type = Integer.class),
		  @ColumnResult(name = "unitassla", type = String.class),
		  @ColumnResult(name = "state", type = String.class),
		  @ColumnResult(name = "district", type = String.class),
		  @ColumnResult(name = "nodal", type = String.class),
		  @ColumnResult(name = "mobile", type = BigInteger.class),
		  @ColumnResult(name = "email", type = String.class),
		  @ColumnResult(name = "fpo_lot_no", type = String.class),
		  @ColumnResult(name = "associationdate", type = String.class),
		  @ColumnResult(name = "crops", type = String.class),
		  @ColumnResult(name = "services", type = String.class),
		  @ColumnResult(name = "marketableSurplus", type = Double.class),
		  @ColumnResult(name = "actualProduction", type = Double.class),
		  @ColumnResult(name = "cropVeriety", type = String.class),
		  })
})

@SqlResultSetMapping(name="CropMasterDto",
classes = {
    @ConstructorResult(
            targetClass = CropMasterDto.class,
            columns = {
                @ColumnResult(name = "cropId", type = Integer.class),
                @ColumnResult(name = "cropName", type = String.class),
                @ColumnResult(name = "seasonRefId", type = Integer.class),
                @ColumnResult(name = "isActive", type = Boolean.class),
           })
})

@Entity
@Table(name="crop_master")
public class CropMaster implements Serializable {

	private static final long serialVersionUID = -1087510302226095291L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer cropId;
	
	@Column(name="crop_name")
	private String  cropName;
	
	public CropMaster(String cropName,Integer cropId) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
	}

	public CropMaster() {
	}

	@Column(name="season_ref_id")
	private Integer seasonRefId;
	
	@JsonManagedReference
	@OneToMany(mappedBy="crop")
	private List<CropVerietyMaster> cropTypes;
	
	@Column(name="is_active")
	private Boolean isActive;
	

	public Integer getCropId() {
		return cropId;
	}

	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public Integer getSeasonRefId() {
		return seasonRefId;
	}

	public void setSeasonRefId(Integer seasonRefId) {
		this.seasonRefId = seasonRefId;
	}

	



	public List<CropVerietyMaster> getCropTypes() {
		return cropTypes;
	}

	public void setCropTypes(List<CropVerietyMaster> cropTypes) {
		this.cropTypes = cropTypes;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
