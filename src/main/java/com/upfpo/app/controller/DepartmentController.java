package com.upfpo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.auth.request.UserDeactivateRequest;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.DepartmentAllUserDto;
import com.upfpo.app.dto.DepartmentProdReportDto;
import com.upfpo.app.dto.DepartmentSalesReportDto;
import com.upfpo.app.entity.ReasonsMaster;
import com.upfpo.app.service.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="api/department")
@Api(produces = "application/json", tags="Department reports and circular and suggestions", value = "view report, and upload circular of the Department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping(value="/getProductionReport")
	@ApiOperation(value="Get production report", code=200, produces = "application/json",notes="Api for get production report",response=DepartmentProdReportDto.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	})
	public List<DepartmentProdReportDto> productionReport(@RequestBody ProdRequest prodRequest) {
		
		return departmentService.getDepartmentProductionReport(prodRequest.getFinYear(), prodRequest.getDistId(), prodRequest.getCropId(), prodRequest.getSeasonId());
	}
	
	@PostMapping(value="/getSalesReport")
	@ApiOperation(value="Get sales report", code=200, produces = "application/json",notes="Api for get sales report",response=DepartmentSalesReportDto.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	})
//	public List<DepartmentSalesReportDto> salesReport(@RequestParam("finYear") String finYear,
//			@RequestParam("distId") Integer distId, @RequestParam("cropId") Integer cropId,
//			@RequestParam("seasonId") Integer seasonId){
	public List<DepartmentSalesReportDto> salesReport(@RequestBody ProdRequest prodRequest){
		
		return departmentService.getDepartmentSalesReport(prodRequest.getFinYear(), prodRequest.getDistId(), prodRequest.getCropId(), prodRequest.getSeasonId());
	}
	
	@GetMapping(value="/getAlluser")
	@ApiOperation(value="Get All user for department",code=200,produces = "application/json",notes="Api for view all users",response=DepartmentAllUserDto.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public List<DepartmentAllUserDto> getUsers()
	{
		return departmentService.getAllUser();
	}
	
	@GetMapping(value="/getAllReasons")
	@ApiOperation(value="Get All user for department",code=200,produces = "application/json",notes="Api for view all users",response=ReasonsMaster.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public List<ReasonsMaster> getReasons()
	{
		return departmentService.getAllReasons();
	}
	
	@PutMapping(value="/deactivateUser")
	@ApiOperation(value="Deactivate user by department",code=200,produces = "application/json",notes="Api for deactivate users",response=String.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public String deActivateUser(@RequestBody UserDeactivateRequest userDeactivateRequest) throws Exception {
		String msg = null;
		try {
			if ( userDeactivateRequest.getUserrole()!= null
					&& userDeactivateRequest.getUserrole().equals("ROLE_MIN")) {
				Long uid = new Long(userDeactivateRequest.getUserid());
				Integer masterId = userDeactivateRequest.getMasterId();
				departmentService.deActivateUser(uid, userDeactivateRequest.getReason(), masterId);
				msg = "SUCCESS";
			} 
			else {
				msg = "FAIL";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	@PutMapping(value="/activateUser")
	@ApiOperation(value="Activate user by department",code=200,produces = "application/json",notes="Api for Activate users",response=String.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public String activateUser(@RequestBody UserDeactivateRequest userDeactivateRequest) throws Exception {
		String msg = null;
		try {
			if ( userDeactivateRequest.getUserrole()!= null
					&& userDeactivateRequest.getUserrole().equals("ROLE_MIN")) {
				Long uid = new Long(userDeactivateRequest.getUserid());
				Integer masterId = userDeactivateRequest.getMasterId();
				departmentService.activateUser(uid, masterId);
				msg = "SUCCESS";
			} 
			else {
				msg = "FAIL";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

}
