package com.upfpo.app.web_controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.upfpo.app.entity.BoardMember;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.LandDetails;
import com.upfpo.app.service.FPOService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/api/fpos")
@Api(produces = "application/json", value = "Add, Update, Delete, and retrive the FPO")
public class FPOController {
	
	private Class clz = new ArrayList<FPORegister>().getClass();
	
	@Autowired
	private FPOService fpoService;
	
	@PostMapping
	@ApiOperation(value="Add new FPO profile",code=201, produces = "application/json", notes="Api for add new FPO",response=FPORegister.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"), })
	@ResponseStatus(HttpStatus.CREATED)
	public FPORegister addNewFpo(@RequestBody FPORegister newFpoRegister)
	{
	    return fpoService.insertFpo(newFpoRegister);
	}
	
	@PutMapping("/:id")
	@ApiOperation(value="Update FPO profile", code=200, produces = "application/json", notes="Api for update FPO",response=FPORegister.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),
	})
	public FPORegister updateFpo(@PathVariable("id") Integer id,@RequestBody FPORegister updateFpoRegister)
	{
		return fpoService.updateFpo(id, updateFpoRegister);
	}
	
	@GetMapping("/:id")
	@ApiOperation(value="Get FPO profile by id", code=200, produces = "application/json",notes="Api for get FPO by id",response=FPORegister.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),
	})
	public FPORegister getFpoById(@PathVariable("id") Integer id)
	{
		return fpoService.selectFpoById(id);
	}
	
	@DeleteMapping("/:id")
	@ApiOperation(value="Delete FPO profile by id",code=204,produces = "text/plain",notes="Api for delete FPO by id",response=Boolean.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),})
	public Boolean deleteFpo(@PathVariable("id") Integer id)
	{
		return fpoService.deleteFpo(id);
	}
	
	@GetMapping
	@ApiOperation(value="Get All FPO profiles",code=200,produces = "application/json",notes="Api for view all FPOs")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
	public List<FPORegister> getFpos()
	{
		return fpoService.selectFpos();
	}
	
	@PostMapping(value= {"/addbm"})
	@ApiOperation(value="Add new Board Member",code=201, produces = "application/json", notes="Api for adding new Board Member",response=BoardMember.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"), })
	@ResponseStatus(HttpStatus.CREATED)
	public BoardMember createBoardMember(@RequestBody BoardMember boardMember)
	{
		return fpoService.addBoardMember(boardMember);
	}
	
	@GetMapping(value= {"/getallbm"})
	@ApiOperation(value="View All BoardMembers",code=200,produces = "application/json",notes="Api to view all Board Members")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
	public @ResponseBody List<BoardMember> getBoardMembers()
	{
		return fpoService.getBoardMembers();
	}
	
	@GetMapping(value= {"/getbm/{id}"})
	@ApiOperation(value="View BoardMember by Id",code=200,produces = "application/json",notes="Api to view Board Member by Id",response=BoardMember.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
	public BoardMember getBoardMembersById(@PathVariable("id")Long id)
	{
		return fpoService.getBoardMembersById(id);
	}
	
	@PutMapping(value= {"/deletebm/{id}"})
	@ApiOperation(value="Delete BoardMember by Id",code=201,produces = "application/json",notes="API to delete Board Member by ID",response=BoardMember.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
	public BoardMember deleteBoardMemberById(@PathVariable("id")Long id)
	{
		return fpoService.deleteBoardMembersById(id);
	}
	
	@GetMapping(value= {"/lands"})
	@ApiOperation(value="View All LandDetails",code=200,produces = "application/json",notes="Api to view all Land Details")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
	public @ResponseBody List<LandDetails> getLandDetails()
	{
		return fpoService.getAllLandDetail();
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
	
	@PostMapping(value= {"/addland"})
	@ApiOperation(value="Add new Land Info",code=201, produces = "application/json", notes="Api for adding new Land",response=LandDetails.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"), })
	@ResponseStatus(HttpStatus.CREATED)
	public LandDetails createLand(@RequestBody LandDetails landDetails)
	{
		return fpoService.addLand(landDetails);
	}
	
	@PutMapping(value= {"/land/{id}"})
	@ApiOperation(value="View Land by Id",code=200,produces = "application/json",notes="Api to view Land by Id",response=LandDetails.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
	public LandDetails deleteLandDetailsById(@PathVariable("id")Integer id)
	{
		return fpoService.deleteLandDetailById(id);
	}

	
}
