package com.upfpo.app.controller;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.upfpo.app.dto.UpAgriFarmerDetailDTO;
import com.upfpo.app.entity.VillageMaster;
import com.upfpo.app.repository.BankMasterRepository;
import com.upfpo.app.repository.BlockMasterRepository;
import com.upfpo.app.repository.DistrictMasterRepository;
import com.upfpo.app.repository.VillageMasterRepository;
import com.upfpo.app.service.UpAgriClientService;
import com.upfpo.app.upagri.UpAgriClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/upagri")
public class UpAgriClientController {


	@Autowired
	private UpAgriClientService agriClientService;


	@GetMapping(value="/getUpAgri/{reg_no}")
	@ApiOperation(value="Get get up agri by registration no.", code=200, produces = "application/json",notes="Api for get up agri by registration no.",response=UpAgriDataDto.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	})
	public UpAgriFarmerDetailDTO getUpAgriByRegistrationNo(@PathVariable("reg_no") String reg_no) throws MalformedURLException, RemoteException
	{
		UpAgriFarmerDetailDTO ls= agriClientService.getUpAgriByRegistrationNo(reg_no);
		return ls;
	}

}
