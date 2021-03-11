package com.upfpo.app.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.upfpo.app.dto.DeptActProdKharifDTO;
import com.upfpo.app.dto.DeptActProdRabiDTO;
import com.upfpo.app.dto.DeptActProdZayadfDTO;
import com.upfpo.app.dto.DeptTotMarKharifDTO;
import com.upfpo.app.dto.DeptTotMarRabiDTO;
import com.upfpo.app.dto.DeptTotMarZayadDTO;
import com.upfpo.app.dto.DeptTotSoldKharifDTO;
import com.upfpo.app.dto.DeptTotSoldRabiDTO;
import com.upfpo.app.dto.DeptTotSoldZayadDTO;
import com.upfpo.app.dto.FpoActProdKharifDTO;
import com.upfpo.app.dto.FpoActProdRabiDTO;
import com.upfpo.app.dto.FpoActProdZayadDTO;
import com.upfpo.app.dto.FpoTotMarKharifDTO;
import com.upfpo.app.dto.FpoTotMarRabiDTO;
import com.upfpo.app.dto.FpoTotMarZayadDTO;
import com.upfpo.app.dto.FpoTotSoldKharifDTO;
import com.upfpo.app.dto.FpoTotSoldRabiDTO;
import com.upfpo.app.dto.FpoTotSoldZayadDTO;
import com.upfpo.app.dto.ProductionDetailsDTO;

@SqlResultSetMapping(name="ProductionDetailDTO",
		classes = {
				@ConstructorResult(
						targetClass = ProductionDetailsDTO.class,
						columns = {
								@ColumnResult(name = "crop_name", type = String.class),
								@ColumnResult(name = "veriety", type = String.class),
								@ColumnResult(name = "season_name", type = String.class),
								@ColumnResult(name = "total_marketable", type = BigInteger.class),
								@ColumnResult(name = "total_sold", type = BigInteger.class)
						})
		})
@SqlResultSetMapping(name="FpoTotMarRabiDTO",
classes = {
		@ConstructorResult(
				targetClass = FpoTotMarRabiDTO.class,
				columns = {
						@ColumnResult(name = "cropId", type = Integer.class),
						@ColumnResult(name = "cropName", type = String.class),
						@ColumnResult(name = "seasonId", type = Integer.class),
						@ColumnResult(name = "totMarkProd", type = Double.class)
				})
})
@SqlResultSetMapping(name="FpoTotMarZayadDTO",
classes = {
		@ConstructorResult(
				targetClass = FpoTotMarZayadDTO.class,
				columns = {
						@ColumnResult(name = "cropId", type = Integer.class),
						@ColumnResult(name = "cropName", type = String.class),
						@ColumnResult(name = "seasonId", type = Integer.class),
						@ColumnResult(name = "totMarkProd", type = Double.class)
				})
})
@SqlResultSetMapping(name="FpoTotMarKharifDTO",
classes = {
		@ConstructorResult(
				targetClass = FpoTotMarKharifDTO.class,
				columns = {
						@ColumnResult(name = "cropId", type = Integer.class),
						@ColumnResult(name = "cropName", type = String.class),
						@ColumnResult(name = "seasonId", type = Integer.class),
						@ColumnResult(name = "totMarkProd", type = Double.class)
				})
})
@SqlResultSetMapping(name="FpoActProdRabiDTO",
classes = {
		@ConstructorResult(
				targetClass = FpoActProdRabiDTO.class,
				columns = {
						@ColumnResult(name = "cropId", type = Integer.class),
						@ColumnResult(name = "cropName", type = String.class),
						@ColumnResult(name = "seasonId", type = Integer.class),
						@ColumnResult(name = "totAcProd", type = Double.class)
				})
})
@SqlResultSetMapping(name="FpoActProdZayadDTO",
classes = {
		@ConstructorResult(
				targetClass = FpoActProdZayadDTO.class,
				columns = {
						@ColumnResult(name = "cropId", type = Integer.class),
						@ColumnResult(name = "cropName", type = String.class),
						@ColumnResult(name = "seasonId", type = Integer.class),
						@ColumnResult(name = "totAcProd", type = Double.class)
				})
})
@SqlResultSetMapping(name="FpoActProdKharifDTO",
classes = {
		@ConstructorResult(
				targetClass = FpoActProdKharifDTO.class,
				columns = {
						@ColumnResult(name = "cropId", type = Integer.class),
						@ColumnResult(name = "cropName", type = String.class),
						@ColumnResult(name = "seasonId", type = Integer.class),
						@ColumnResult(name = "totAcProd", type = Double.class)
				})
})
@SqlResultSetMapping(name="DeptTotMarRabiDTO",
classes = {
		@ConstructorResult(
				targetClass = DeptTotMarRabiDTO.class,
				columns = {
						@ColumnResult(name = "cropId", type = Integer.class),
						@ColumnResult(name = "cropName", type = String.class),
						@ColumnResult(name = "seasonId", type = Integer.class),
						@ColumnResult(name = "totMarkProd", type = Double.class)
				})
})

@SqlResultSetMapping(name="DeptTotMarZayadDTO",
classes = {
		@ConstructorResult(
				targetClass = DeptTotMarZayadDTO.class,
				columns = {
						@ColumnResult(name = "cropId", type = Integer.class),
						@ColumnResult(name = "cropName", type = String.class),
						@ColumnResult(name = "seasonId", type = Integer.class),
						@ColumnResult(name = "totMarkProd", type = Double.class)
				})
})

@SqlResultSetMapping(name="DeptTotMarKharifDTO",
classes = {
		@ConstructorResult(
				targetClass = DeptTotMarKharifDTO.class,
				columns = {
						@ColumnResult(name = "cropId", type = Integer.class),
						@ColumnResult(name = "cropName", type = String.class),
						@ColumnResult(name = "seasonId", type = Integer.class),
						@ColumnResult(name = "totMarkProd", type = Double.class)
				})
})
@SqlResultSetMapping(name="DeptActProdKharifDTO",
classes = {
		@ConstructorResult(
				targetClass = DeptActProdKharifDTO.class,
				columns = {
						@ColumnResult(name = "cropId", type = Integer.class),
						@ColumnResult(name = "cropName", type = String.class),
						@ColumnResult(name = "seasonId", type = Integer.class),
						@ColumnResult(name = "totAcProd", type = Double.class)
				})
})
@SqlResultSetMapping(name="DeptActProdRabiDTO",
classes = {
		@ConstructorResult(
				targetClass = DeptActProdRabiDTO.class,
				columns = {
						@ColumnResult(name = "cropId", type = Integer.class),
						@ColumnResult(name = "cropName", type = String.class),
						@ColumnResult(name = "seasonId", type = Integer.class),
						@ColumnResult(name = "totAcProd", type = Double.class)
				})
})
@SqlResultSetMapping(name="DeptActProdZayadfDTO",
classes = {
		@ConstructorResult(
				targetClass = DeptActProdZayadfDTO.class,
				columns = {
						@ColumnResult(name = "cropId", type = Integer.class),
						@ColumnResult(name = "cropName", type = String.class),
						@ColumnResult(name = "seasonId", type = Integer.class),
						@ColumnResult(name = "totAcProd", type = Double.class)
				})
})

@SqlResultSetMapping(name="DeptTotSoldZayadDTO",
classes = {
		@ConstructorResult(
				targetClass = DeptTotSoldZayadDTO.class,
				columns = {
						@ColumnResult(name = "cropId", type = Integer.class),
						@ColumnResult(name = "cropName", type = String.class),
						@ColumnResult(name = "seasonId", type = Integer.class),
						@ColumnResult(name = "totSold", type = Double.class)
				})
})
@SqlResultSetMapping(name="DeptTotSoldKharifDTO",
classes = {
		@ConstructorResult(
				targetClass = DeptTotSoldKharifDTO.class,
				columns = {
						@ColumnResult(name = "cropId", type = Integer.class),
						@ColumnResult(name = "cropName", type = String.class),
						@ColumnResult(name = "seasonId", type = Integer.class),
						@ColumnResult(name = "totSold", type = Double.class)
				})
})
@SqlResultSetMapping(name="DeptTotSoldRabiDTO",
classes = {
		@ConstructorResult(
				targetClass = DeptTotSoldRabiDTO.class,
				columns = {
						@ColumnResult(name = "cropId", type = Integer.class),
						@ColumnResult(name = "cropName", type = String.class),
						@ColumnResult(name = "seasonId", type = Integer.class),
						@ColumnResult(name = "totSold", type = Double.class)
				})
})

@SqlResultSetMapping(name="FpoTotSoldZayadDTO",
classes = {
		@ConstructorResult(
				targetClass = FpoTotSoldZayadDTO.class,
				columns = {
						@ColumnResult(name = "cropId", type = Integer.class),
						@ColumnResult(name = "cropName", type = String.class),
						@ColumnResult(name = "seasonId", type = Integer.class),
						@ColumnResult(name = "totSold", type = Double.class)
				})
})

@SqlResultSetMapping(name="FpoTotSoldKharifDTO",
classes = {
		@ConstructorResult(
				targetClass = FpoTotSoldKharifDTO.class,
				columns = {
						@ColumnResult(name = "cropId", type = Integer.class),
						@ColumnResult(name = "cropName", type = String.class),
						@ColumnResult(name = "seasonId", type = Integer.class),
						@ColumnResult(name = "totSold", type = Double.class)
				})
})

@SqlResultSetMapping(name="FpoTotSoldRabiDTO",
classes = {
		@ConstructorResult(
				targetClass = FpoTotSoldRabiDTO.class,
				columns = {
						@ColumnResult(name = "cropId", type = Integer.class),
						@ColumnResult(name = "cropName", type = String.class),
						@ColumnResult(name = "seasonId", type = Integer.class),
						@ColumnResult(name = "totSold", type = Double.class)
				})
})
@Entity
@Table(name="total_production")
public class TotalProduction implements Serializable {
	
	private static final long serialVersionUID = -6418872506669794191L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pid")
	private Integer pid;
	
	@Column(name="total_production")
	private Double totalProduction;
	
	@Column(name="total_marketable")
	private Double totalMarketable; 
	
	@Column(name="total_sold")
	private Double totalSold;
	
	@Column(name="total_actual_prod")
	private Double total_actual_prod;
	
	@Column(name="total_expected_prod")
	private Double total_expected_prod;
	
	@Column(name="total_sowing")
	private Double total_sowing;
	
	@Column(name="current_marketable")
	private Double currentMarketable;
	
	@Column(name="season_id")
	private Integer seasonId;
	
	@Column(name="fin_year")
	private String finYear;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "crop_id", referencedColumnName = "id")
	private CropMaster cropMaster;
		
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "veriety_id", referencedColumnName = "veriety_id")
	private CropVerietyMaster cropVerityMaster;

	@Column(name="fpo_id")
	private Integer fpoRegister;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "farmer_id", referencedColumnName = "farmer_id")
	private FarmerMaster farmerMaster;

	public TotalProduction() {
		
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Double getTotalProduction() {
		return totalProduction;
	}

	public void setTotalProduction(Double totalProduction) {
		this.totalProduction = totalProduction;
	}

	public Double getTotalMarketable() {
		return totalMarketable;
	}

	public void setTotalMarketable(Double totalMarketable) {
		this.totalMarketable = totalMarketable;
	}

	public Double getTotalSold() {
		return totalSold;
	}

	public void setTotalSold(Double totalSold) {
		this.totalSold = totalSold;
	}

	public Double getTotal_actual_prod() {
		return total_actual_prod;
	}

	public void setTotal_actual_prod(Double total_actual_prod) {
		this.total_actual_prod = total_actual_prod;
	}

	public Double getTotal_expected_prod() {
		return total_expected_prod;
	}

	public void setTotal_expected_prod(Double total_expected_prod) {
		this.total_expected_prod = total_expected_prod;
	}

	public Double getTotal_sowing() {
		return total_sowing;
	}

	public void setTotal_sowing(Double total_sowing) {
		this.total_sowing = total_sowing;
	}

	public CropMaster getCropMaster() {
		return cropMaster;
	}

	public void setCropMaster(CropMaster cropMaster) {
		this.cropMaster = cropMaster;
	}

	public CropVerietyMaster getCropVerityMaster() {
		return cropVerityMaster;
	}

	public void setCropVerityMaster(CropVerietyMaster cropVerityMaster) {
		this.cropVerityMaster = cropVerityMaster;
	}

	public Integer getFpoRegister() {
		return fpoRegister;
	}

	public void setFpoRegister(Integer fpoRegister) {
		this.fpoRegister = fpoRegister;
	}

	public FarmerMaster getFarmerMaster() {
		return farmerMaster;
	}

	public void setFarmerMaster(FarmerMaster farmerMaster) {
		this.farmerMaster = farmerMaster;
	}
	
	public Double getCurrentMarketable() {
		return currentMarketable;
	}


	public void setCurrentMarketable(Double currentMarketable) {
		this.currentMarketable = currentMarketable;
	}
	
	public Integer getSeasonId() {
		return seasonId;
	}


	public void setSeasonId(Integer seasonId) {
		this.seasonId = seasonId;
	}


	public String getFinYear() {
		return finYear;
	}


	public void setFinYear(String finYear) {
		this.finYear = finYear;
	}
}
