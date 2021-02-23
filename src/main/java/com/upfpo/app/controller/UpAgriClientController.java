package com.upfpo.app.controller;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.UpAgriDataDto;
import com.upfpo.app.entity.CropVerietyMaster;
import com.upfpo.app.upagri.UpAgriClient;
import com.upfpo.app.upagri.UpAgriService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/upagri")
public class UpAgriClientController {
	
	//UpAgriClient UAC = new UpAgriClient();
	@Autowired
	UpAgriService upAgriService;
	
	@GetMapping(value="/getUpAgri/{reg_no}")
	@ApiOperation(value="Get get up agri by registration no.", code=200, produces = "application/json",notes="Api for get up agri by registration no.",response=UpAgriDataDto.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	})
	public ResponseEntity<UpAgriDataDto> getUpAgriByRegistrationNo(@PathVariable("reg_no") String reg_no) throws MalformedURLException, RemoteException
	{
		UpAgriDataDto upAgri = null;
		try {
			upAgri = upAgriService.upagri(reg_no);
			System.err.println("upAgri ==  "+upAgri);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//return upAgri;
				//(ResponseEntity<UpAgriDataDto>) ResponseEntity.ok(upAgriService.upagri(reg_no));
		return new ResponseEntity<UpAgriDataDto>(upAgri, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping(value="/getUpAgriArea/{reg_no}")
	@ApiOperation(value="Get get up agri area by registration no.", code=200, produces = "application/json",notes="Api for get up agri area by registration no.",response=MessageResponse.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	})
	public ResponseEntity<MessageResponse> getUpAgriAreaByRegistrationNo(@PathVariable("reg_no") String reg_no)
	{
		String upagriArea = null;
		try {
			upagriArea = upAgriService.upagri_area(reg_no);
			System.err.println("upagriArea ==  "+upagriArea);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return new ResponseEntity<MessageResponse>(new MessageResponse(upagriArea), HttpStatus.OK);
	}
	
	
	
	
	

}
