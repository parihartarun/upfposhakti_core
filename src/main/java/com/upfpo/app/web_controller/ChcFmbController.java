package com.upfpo.app.web_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.entity.ChcFmbMaster;
import com.upfpo.app.service.ChcFmbService;

@RestController
@RequestMapping(value="api/v1/CHCFMB")
public class ChcFmbController 
{
	@Autowired
	ChcFmbService chcFmbService;
	
	@GetMapping(value="/getChcFmb")
	private ResponseEntity<List<ChcFmbMaster>> getchcFmbMaster()
	{
		List<ChcFmbMaster> list = chcFmbService.getChcFmbMaster();
		return new ResponseEntity<List<ChcFmbMaster>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping(value="/editChcFmb/{chcFmbId}")
	private ResponseEntity<ChcFmbMaster> editChcFmb(@RequestBody ChcFmbMaster chcFmbMaster,@PathVariable("chcFmbId") int chcFmbId)
	{
		ChcFmbMaster chcFmbentity = chcFmbService.updateChcFmb(chcFmbMaster,chcFmbId);
		return new ResponseEntity<ChcFmbMaster>(chcFmbentity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping(value="/deleteChcFmbMaster/{chcFmbId}")
	private HttpStatus deleteChcFmbMaster(@PathVariable("chcFmbId") int chcFmbId)
	{
		chcFmbService.deleteChcFmbMaster(chcFmbId);
		return HttpStatus.FORBIDDEN;
	}
}
