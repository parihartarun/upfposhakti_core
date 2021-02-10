package com.upfpo.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.upfpo.app.entity.CropMaster;

public interface CropDetailsService 
{
	List<CropMaster> getCropDetails();

	List<CropMaster> getCropsBySeasonId(Integer seasonId);
}
