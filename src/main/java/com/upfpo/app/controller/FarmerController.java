package com.upfpo.app.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.auth.request.UserDeactivateRequest;
import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.custom.CustomException;
import com.upfpo.app.dto.DepartmentAllUserDto;
import com.upfpo.app.dto.FarmerAllUserToFpoDto;
import com.upfpo.app.entity.FarmerMaster;
import com.upfpo.app.entity.ReasonsMaster;
import com.upfpo.app.service.FarmerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/api/Farmer")
@Api(produces = "application/json", value = "Update, Delete, and retrive the Farmer", tags="Farmer Operations", description="fUpdate, Delete, and retrive the FPO")
public class FarmerController 
{
	@Autowired
	FarmerService farmerService;
	
	@PutMapping(value="/editFarmer/{farmerId}")
	@ApiOperation(value="Update Farmer Details", code=200, produces = "application/json", notes="Api for update Farmer",response=FarmerMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response = ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response = ExceptionResponse.class, message = "Validation Failed"),
	})
	private ResponseEntity<FarmerMaster> editFarmer(@RequestBody FarmerMaster farmerMaster, @PathVariable("farmerId") int farmerId )
	{
		FarmerMaster farmerEntity = farmerService.updateFarmer(farmerMaster, farmerId);
		return new ResponseEntity<FarmerMaster>(farmerEntity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@ApiOperation(value="Get all Farmer details", code=200, produces = "application/json",notes="Api for get all Farmer details",response=FarmerMaster.class, responseContainer = "List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),
	})
	@GetMapping(value="/getFarmerDetails/{masterId}")
	private ResponseEntity<List<FarmerMaster>> getFarmerDetailsById(@PathVariable("masterId") Integer masterId)
	{
		List<FarmerMaster> list = farmerService.getFarmer(masterId);
		return new ResponseEntity<List<FarmerMaster>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	/*
	 * @GetMapping(value="/getFarmerDetails/{farmerId}") private FarmerMaster
	 * getFarmerDetailsById(@PathVariable("farmerId") int farmerId) { return
	 * registerServices.getFarmerDetailsById(farmerId); }
	 */
	
	@DeleteMapping(value="/deleteFarmer/{farmerId}")
	@ApiOperation(value="Delete Farmer deatails by id",code=204,produces = "text/plain",notes="Api for delete FPO by id",response=Boolean.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),
	})
	private Boolean deleteFarmer(@PathVariable("farmerId") int farmerId)
	{
		farmerService.deleteFarmer(farmerId);
		return true;
	}
	
	@GetMapping(value="/getAllUserToFpo/{fpoId}")
	@ApiOperation(value="Get All user for department",code=200,produces = "application/json",notes="Api for view all users",response=FarmerAllUserToFpoDto.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public List<FarmerAllUserToFpoDto> getUsers(@PathVariable("fpoId") Integer fpoId)
	{
		return farmerService.getAllFarmerUserToFpo(fpoId);
	}
	
	@PutMapping(value="/deactivateFarmerUser")
	@ApiOperation(value="Deactivate user by department",code=201,produces = "application/json",notes="Api for deactivate users",response=MessageResponse.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	@ResponseStatus( HttpStatus.OK)
	public ResponseEntity<MessageResponse> deActivateUser(@RequestBody UserDeactivateRequest userDeactivateRequest) throws Exception {
		String msg = null;
		try {
			if ( userDeactivateRequest.getUserrole()!= null
					&& userDeactivateRequest.getUserrole().equals("ROLE_FPC")) {
				Long uid = new Long(userDeactivateRequest.getUserid());
				Integer masterId = userDeactivateRequest.getMasterId();
				farmerService.deActivateFarmerUser(uid, userDeactivateRequest.getReason(), masterId);
				msg = userDeactivateRequest.getUsername()+ " user deactivate successfully";
			} 
			else {
				throw new CustomException("user deactivation fail",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(new MessageResponse(msg));
	}
	
	@PutMapping(value="/activateUser")
	@ApiOperation(value="Activate user by department",code=201,produces = "application/json",notes="Api for Activate users",response=MessageResponse.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	@ResponseStatus( HttpStatus.OK)
	public ResponseEntity<MessageResponse> activateUser(@RequestBody UserDeactivateRequest userDeactivateRequest) throws Exception {
		String msg = null;
		try {
			if ( userDeactivateRequest.getUserrole()!= null
					&& userDeactivateRequest.getUserrole().equals("ROLE_FPC")) {
				Long uid = new Long(userDeactivateRequest.getUserid());
				Integer masterId = userDeactivateRequest.getMasterId();
				farmerService.activateFarmerUser(uid, masterId);
				msg = userDeactivateRequest.getUsername()+ " user activate successfully";
			} 
			else {
				throw new CustomException("user activation fail",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(new MessageResponse(msg));
	}

	
	/*
	 * @RequestMapping(value = "upagri") public @ResponseBody String
	 * upagri(@RequestParam("id") String reg_no) throws JsonProcessingException,
	 * MalformedURLException, RemoteException {
	 * 
	 * // logger.error("API CALLED"); String list_resp =
	 * UpagriClient.upagri(reg_no).toString(); String _anyname =
	 * StringUtils.substringBetween(list_resp, "<Farmer_x0027_s_x0020_name>",
	 * "</Farmer_x0027_s_x0020_name>"); String _fath =
	 * StringUtils.substringBetween(list_resp, "<Father_x0020_name>",
	 * "</Father_x0020_name>"); String _anydist =
	 * StringUtils.substringBetween(list_resp, "<District>", "</District>"); String
	 * _blck = StringUtils.substringBetween(list_resp, "<Block>", "</Block>");
	 * String _vill = StringUtils.substringBetween(list_resp, "<Village>",
	 * "</Village>"); String _cat = StringUtils.substringBetween(list_resp,
	 * "<Category>", "</Category>"); String _mob =
	 * StringUtils.substringBetween(list_resp, "<Mobile_x0020_No>",
	 * "</Mobile_x0020_No>"); String _bank_name =
	 * StringUtils.substringBetween(list_resp, "<Bank_x0020_Name>",
	 * "</Bank_x0020_Name>"); String _ifsc = StringUtils.substringBetween(list_resp,
	 * "<IFSC_x0020_Code>", "</IFSC_x0020_Code>"); String _accno =
	 * StringUtils.substringBetween(list_resp, "<Bank_x0020_Account_x0020_NO>",
	 * "</Bank_x0020_Account_x0020_NO>"); String gender =
	 * StringUtils.substringBetween(list_resp, "<gender>", "</gender>"); //
	 * logger.error("_anyname"+_anyname+"_fath"+_fath+"_anydist"+"_blck"+"_blck"+
	 * _vill+"_cat"+_mob+"_bank_name"+_bank_name+"_ifsc"+_ifsc+"_accno"+_accno);
	 * 
	 * // Integer blockId = masterServices.getBLockId(_blck.trim().toUpperCase());
	 * // Integer distId = masterServices.getDistId(_anydist.trim().toUpperCase());
	 * // Integer bankId =
	 * masterServices.getBankId(_bank_name.trim().toUpperCase());
	 * 
	 * // System.out.println("DistId"+distId); //
	 * System.out.println("blcokId"+blockId); //
	 * System.out.println("bankId"+bankId); /// List <DataDisplayDto> pan = new
	 * ArrayList<DataDisplayDto>(); List<String> al = new ArrayList<String>();
	 * al.add(_anyname); // 0 al.add(_fath); // 1 al.add(_anydist); //2
	 * al.add(_blck); //3 al.add(_mob); //4 al.add(_bank_name); //5 al.add(_ifsc);
	 * //6 al.add(_accno); //7 // al.add(distId.toString()); //8 //
	 * al.add(blockId.toString()); //9 // al.add(bankId.toString()); //10
	 * 
	 * // System.out.println("bankId"+masterServices.getBankId(_bank_name.trim().
	 * toUpperCase()).toString()); al.add(_cat); //11 al.add(gender);//12
	 * 
	 * if(!_vill.contains("#")) { al.add(_vill); //13 //
	 * al.add(masterServices.getVliiageId(_vill,blockId).toString()); // 14 //
	 * System.out.println("VillageId"+masterServices.getVliiageId(_vill,blockId).
	 * toString()); // System.out.println(masterServices.getPanchayats(_vill,
	 * blockId).size()+"list Size"); // pan = masterServices.getPanchayats(_vill,
	 * blockId);
	 * 
	 * // System.out.println("PanchayatId"+pan); //
	 * System.out.println(pan.size()+"Panchayats"); // if(pan.size()>0) // { //
	 * al.add(pan.get(0).getPanchayat_name()); //15 //
	 * al.add(pan.get(0).getPanchayat_id().toString()); //16 // } }
	 * 
	 * return new ObjectMapper().writeValueAsString(al); }
	 */
	}
