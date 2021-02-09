package com.upfpo.app.controller;

import com.upfpo.app.dto.FarmerLandDTO;
import com.upfpo.app.dto.FarmerLandDetailDto;
import com.upfpo.app.entity.LandDetails;
import com.upfpo.app.service.LandDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/landdetail")
@Api(produces = "application/json", tags="LandDetail", value = "Add, Update, Delete, and retrive the LandDetails")
public class LandDetailController {


    @Autowired
    private LandDetailsService landDetailsService;

    @GetMapping("/{id}")
    public FarmerLandDTO getFarmerLandDetails(@PathVariable Integer id){

        return landDetailsService.getfarmerLandDetailById(id);
    }


    @GetMapping(value= {"/getall/{masterId}"})
    @ApiOperation(value="View All LandDetails",code=200,produces = "application/json",notes="Api to view all Land Details",response= LandDetails.class)
    @ApiResponses(value= {
            @ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
            @ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
    public @ResponseBody
    List<FarmerLandDetailDto> getLandDetails(@PathVariable("masterId")Integer masterId)
    {
        return landDetailsService.getAllLandDetail(masterId);
    }



    @PostMapping(value= {"/land"})
    @ApiOperation(value="Add new Land Info",code=201, produces = "application/json", notes="Api for adding new Land",response=LandDetails.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
            @ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"), })
    @ResponseStatus(HttpStatus.CREATED)
    public LandDetails createLand(@RequestBody LandDetails landDetails)
    {
        return landDetailsService.addLand(landDetails);
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
        return landDetailsService.updateLand(landDetails, landId);
    }

    @DeleteMapping(value= {"/land/deleteDetails/{landId}"})
    @ApiOperation(value="View Land by Id",code=204,produces = "text/plain",notes="Api to view Land by Id",response=boolean.class)
    @ApiResponses(value= {
            @ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
            @ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
    public boolean deleteLandDetailsById(@PathVariable("landId")Integer landId)
    {
        return landDetailsService.deleteLandDetailById(landId);
    }
}
