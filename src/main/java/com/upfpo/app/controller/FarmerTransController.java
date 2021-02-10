package com.upfpo.app.controller;

import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.FarmerRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.upfpo.app.entity.FarmerRegister;
import com.upfpo.app.service.FarmerServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping(value="/api/farmer")
@Api(produces = "application/json", value = "Add, Update, Delete, and retrive the Farmers")
public class FarmerTransController {
	
	@Resource
	private FarmerServices farmerServices;

	private static final Logger LOG = LoggerFactory.getLogger(FarmerTransController.class);
	
	@PostMapping
	@ApiOperation(value="Add new Farmer",code=201, produces = "application/json", notes="Api for add new Farmer",response=FarmerRegister.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"), })
	@ResponseStatus(HttpStatus.CREATED)
	public FarmerRegister addNewFpo(@RequestBody FarmerRegister farmerRegister)
	{
	    return farmerServices.addFarmer(farmerRegister);
	}
	
	@GetMapping
	@ApiOperation(value="Get All Farmers profile",code=200,produces = "application/json",notes="Api to view all Farmers")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
	public List<FarmerRegister> getFarmers()
	{
		return farmerServices.getAllFarmers();
	}
	
	@GetMapping("{id}")
	@ApiOperation(value="Get Farmer by id", code=200, produces = "application/json",notes="Api to get Farmer by id",response=FarmerRegister.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),
	})
	public FarmerRegister getFarmerById(@PathVariable("id") Integer id)
	{
		return farmerServices.getFarmerById(id);
	}
	
	@PutMapping("{id}")
	@ApiOperation(value="Delete Farmer by Id",code=201,produces = "application/json",notes="API to delete Farmer by ID",response=FarmerRegister.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
	public FarmerRegister deleteBoardMemberById(@PathVariable("id")Integer id)
	{
		return farmerServices.deleteFarmerById(id);
	}


	@PutMapping("/update/{id}")
	@ApiOperation(value="Update FPO Farmer" ,code=201, produces = "application/json", notes="Api To Update FPO Farmer",response= FarmerRegister.class)
	@ApiResponses(value= {
			@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
			@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
			@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	public ResponseEntity<MessageResponse> updateFarmerRegister(@PathVariable Integer id, @RequestBody FarmerRegister farmerRegister) {
		LOG.info("Inside FarmerRegisterController updating Farmer ", farmerRegister);
		ResponseEntity<MessageResponse> resp = null;
		try {
			FarmerRegister fsd = farmerServices.updateFarmerDetails(id, farmerRegister);
			resp = new ResponseEntity<MessageResponse>(new MessageResponse("FarmerRegister Updated Successfully!"), HttpStatus.OK );
			LOG.info("FarmerRegister Updated Successfully!");
			//}
		} catch (Exception e) {
			resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Update the Farmer"), HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.info("Failed to Update the Farmer");
			e.printStackTrace();
		}
		LOG.info("Exiting FarmerRegister Of Controller with response ", resp);
		return resp;
	}

	@GetMapping("/getall")
	@ApiOperation(value="Fetch All Farmer" ,code=201, produces = "application/json", notes="API to Get all Farmer",response=FarmerRegister.class)
	@ApiResponses(value= {
			@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
			@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
			@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	public List<FarmerRegister> getFarmerRegister (){

		return farmerServices.getAllFarmerList();
	}



	@GetMapping("/profile/{id}")
	@ApiOperation(value="Fetch FarmerRegister By ID" ,code=201, produces = "application/json", notes="Api to FPO Farmers By ID",response=FarmerRegister.class)
	@ApiResponses(value= {
			@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
			@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
			@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	public Optional<FarmerRegister> getFarmerRegisterById(@PathVariable Integer id) {

		return farmerServices.getFarmerDetailById(id);
	}


	@GetMapping("/user/{username}")
	@ApiOperation(value="Get Farmer By Username" ,code=201, produces = "application/json", notes="Get Farmer By username",response= FarmerRegister.class)
	@ApiResponses(value= {
			@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
			@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
			@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	public Optional<FarmerRegister> getFarmerByUsername(@PathVariable String username) {
		LOG.info("Inside FarmerRegisterController fetching Farmerdetail ");
		Optional<FarmerRegister> fsd=null;
		ResponseEntity<MessageResponse> resp = null;
		try {
			fsd = farmerServices.getFarmerDetailByUsername(username);
			resp = new ResponseEntity<MessageResponse>(new MessageResponse("Farmer Get Successfully!"), HttpStatus.OK );
			LOG.info("FarmerRegister Get Successfully!");
			//}
		} catch (Exception e) {
			resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Get the Farmer detail"), HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.info("Failed to Update the Farmer");
			e.printStackTrace();
		}
		LOG.info("Exiting FarmerRegister Of Controller with response ", resp);
		return fsd;
	}

}
