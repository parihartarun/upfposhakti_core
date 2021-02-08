package com.upfpo.app.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="season_master")
public class SeasonMaster implements Serializable 
{

	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="season_id")
	private Integer seasonId;
		
	@Column(name="season_name")
	private String season;

	public Integer getSeasonId() {
			return seasonId;
	}

	public void setSeasonId(Integer seasonId) {
			this.seasonId = seasonId;
	}

	public String getSeason() {
			return season;
	}
	
	public void setSeason(String season) {
			this.season = season;
	}
			
}
