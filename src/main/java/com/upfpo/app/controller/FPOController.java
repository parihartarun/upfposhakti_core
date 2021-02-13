package com.upfpo.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.ValidationException;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.CropListOfFarmersDTO;
import com.upfpo.app.dto.FPOListDTO;
import com.upfpo.app.dto.FarmerCropSowingDTO;
import com.upfpo.app.dto.FarmerLandDetailDto;
import com.upfpo.app.dto.MasterDataDto;
import com.upfpo.app.entity.BoardMember;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.LandDetails;
import com.upfpo.app.entity.NewSowing;
import com.upfpo.app.service.FPOService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping(value="api/fpos")
@Api(produces = "application/json", tags="Farmer Producer Organization", value = "Add, Update, Delete, and retrive the FPO")
public class FPOController {
	
	private Class clz = new ArrayList<FPORegister>().getClass();
	

	@Autowired
	private FPOService fpoService;
	
	@PostMapping
	@ApiOperation(value="Add new FPO profile" ,code=201, produces = "application/json", notes="Api for add new FPO",response=FPORegister.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"), })
	@ResponseStatus(HttpStatus.CREATED)
	public FPORegister addNewFpo(@RequestBody FPORegister newFpoRegister)
	{
		if(newFpoRegister==null)
		{
			throw new ValidationException();
		}else {
			return fpoService.insertFpo(newFpoRegister);
		}    
	}

	@GetMapping(value="/getByUsername/{username}")
	@ApiOperation(value="Get FPO profile by username", code=200, produces = "application/json",notes="Api for get FPO by username",response=FPORegister.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	})
	public FPORegister getFpoByUserName(@PathVariable("username") String username)
	{
		return fpoService.selectFpoByUserName(username);
	}
	
	@GetMapping(value="/{id}")
	@ApiOperation(value="Get FPO profile by id", code=200, produces = "application/json",notes="Api for get FPO by id",response=FPORegister.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public FPORegister getFpoById(@PathVariable("id") Integer id)
	{
		return fpoService.selectFpoById(id);
	}
	
	@GetMapping(value="/getDistrictByFpoId/{fpoId}")
	@ApiOperation(value="Get District details of FPO", code=200, produces = "application/json",notes="Api for get FPO by username",response=FPORegister.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	})
	public MasterDataDto disrtrictName(@PathVariable("fpoId") Integer fpoId)
	{
		return fpoService.getDistrictByFpoId(fpoId);
	}
	
	@DeleteMapping(value="/{id}")
	@ApiOperation(value="Delete FPO profile by id",code=204,produces = "text/plain",notes="Api for delete FPO by id",response=Boolean.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	@ResponseStatus( HttpStatus.NO_CONTENT)
	public Boolean deleteFpo(@PathVariable("id") Integer id)
	{
		return fpoService.deleteFpo(id);
	}
	

	@PutMapping(value="/{id}")
	@ApiOperation(value="Update FPO profile", code=200, produces = "application/json", notes="Api for update FPO",response=FPORegister.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response = ExceptionResponse.class, message = "Validation Failed")
	})
	public FPORegister updateFpo(@PathVariable("id") Integer id, @RequestBody FPORegister updateFpoRegister)
	{
		return fpoService.updateFpo(id, updateFpoRegister);
	}

	@GetMapping
	@ApiOperation(value="Get All FPO profiles",code=200,produces = "application/json",notes="Api for view all FPOs",response=FPOListDTO.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public List<FPOListDTO> getFpos()
	{
		return fpoService.selectFpos();
	}
	
	@PostMapping(value= {"/boardmember"})
	@ApiOperation(value="Add new Board Member",code=201, produces = "application/json", notes="Api for adding new Board Member",response=BoardMember.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"), })
	@ResponseStatus(HttpStatus.CREATED)
	public BoardMember createBoardMember(@Valid @RequestBody BoardMember boardMember)
	{
		return fpoService.addBoardMember(boardMember);
	}
	
	@GetMapping(value= {"/boardmember/{masterId}"})
	@ApiOperation(value="View All BoardMembers",code=200,produces = "application/json",notes="Api to view all Board Members")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
	public @ResponseBody List<BoardMember> getBoardMembers(@PathVariable("masterId")Integer masterId)
	{
		return fpoService.getBoardMembers(masterId);
	}
	
	@GetMapping(value= {"/boardmember/getBoardMemberById/{id}"})
	@ApiOperation(value="View BoardMember by Id",code=200,produces = "application/json",notes="Api to view Board Member by Id",response=BoardMember.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
	public BoardMember getBoardMembersById(@PathVariable("id")Long id)
	{
		return fpoService.getBoardMembersById(id);
	}
	
	@PutMapping(value = "/boardmember/editBoardMember/{id}")
	@ApiOperation(value="Edit BoardMember by Id",code=200,produces = "application/json",notes="Api to edit Board Member by Id",response=BoardMember.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
	public ResponseEntity<BoardMember> updateBoardMember(@RequestBody BoardMember boardMember, @PathVariable("id")Long id)
	{
		BoardMember boardMemberEntity = fpoService.updateBoardMember(boardMember,id);
		return new ResponseEntity<BoardMember>(boardMemberEntity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping(value= {"/boardmember/deleteBoardMember/{id}"})
	@ApiOperation(value="Delete BoardMember by Id",code=204,produces = "application/json",notes="API to delete Board Member by ID",response=BoardMember.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
	public BoardMember deleteBoardMemberById(@PathVariable("id")Long id)
	{
		return fpoService.deleteBoardMembersById(id);
	}
	
	@GetMapping(value= {"/landfarmer/{masterId}"})
	@ApiOperation(value="View All LandDetails",code=200,produces = "application/json",notes="Api to view all Land Details",response=LandDetails.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
	public @ResponseBody List<FarmerLandDetailDto> getLandDetails(@PathVariable("masterId")Integer masterId)
	{
		return fpoService.getAllLandDetail(masterId);
	}
	
	@GetMapping(value= {"/land/{id}"})
	@ApiOperation(value="View Land by Id",code=200,produces = "application/json",notes="Api to view Land by Id",response=LandDetails.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
	public LandDetails getLandDetailsById(@PathVariable("id")Integer id)
	{
		return fpoService.getLandDetailById(id);
	}
	
	@PostMapping(value= {"/land"})
	@ApiOperation(value="Add new Land Info",code=201, produces = "application/json", notes="Api for adding new Land",response=LandDetails.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"), })
	@ResponseStatus(HttpStatus.CREATED)
	public LandDetails createLand(@RequestBody LandDetails landDetails)
	{
		return fpoService.addLand(landDetails);
	}
	
	@PutMapping(value="/land/editDetails/{landId}")
	@ApiOperation(value="Edit Land Info",code=201, produces = "application/json", notes="Api for editing Land",response=LandDetails.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"), })
	@ResponseStatus(HttpStatus.CREATED)
	public LandDetails updateLand(@RequestBody LandDetails landDetails, @PathVariable("landId") int landId)
	{
		System.out.println("Farmer Profile Object:"+landDetails.getFarmerProfile().getFarmerId());
		return fpoService.updateLand(landDetails, landId);
	}
	
	@DeleteMapping(value= {"/land/deleteDetails/{landId}"})
	@ApiOperation(value="View Land by Id",code=204,produces = "text/plain",notes="Api to view Land by Id",response=boolean.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
	public boolean deleteLandDetailsById(@PathVariable("landId")Integer landId)
	{
		return fpoService.deleteLandDetailById(landId);
	}
	
	
	 @GetMapping(value="/cropSowing/getFarmerDetailsForCropSowing/{farmerId}") 
	 public  FarmerCropSowingDTO getFarmerDetailsForCropSowing(@PathVariable("farmerId") Integer farmerId) 
	 { 
		  return fpoService.getFarmerDetailsForCropSowing(farmerId); 
     }
	 
	 @GetMapping(value="/cropSowing/farmersCropList/{masterId}")
	 public List<CropListOfFarmersDTO> getfarmersCropList(@PathVariable("masterId") int masterId)
	 {
		 return fpoService.getCropListForFarmersByFpo(masterId);
	 }
	 
	 @PostMapping(value="/cropSowing/addFarmerCropDetails")
	 public NewSowing addFarmerCropDetails(@RequestBody NewSowing newSowing)
	 {
		 return fpoService.addFarmerCropDetails(newSowing);
	 }

}
