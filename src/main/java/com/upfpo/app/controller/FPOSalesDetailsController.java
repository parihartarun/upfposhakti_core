package com.upfpo.app.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.FPOSalesDetailsDTO;
import com.upfpo.app.entity.FPOSaleInfo;
import com.upfpo.app.entity.FPOSalesDetails;
import com.upfpo.app.service.FPOSalesDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(value = "/fposalesdetails")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "FPOSalesDetails", tags="FPOSalesDetails Controller",description="FPOSales Details")
public class FPOSalesDetailsController {

    private static final Logger LOG = LoggerFactory.getLogger(FPOSalesDetailsController.class);

    @Autowired
    private FPOSalesDetailsService fpoSalesDetailsService;

    @GetMapping("/getFpoSalesDetails/{masterId}")
    @ApiOperation(value="Fetch All FPO Sales Details" ,code=201, produces = "application/json", notes="API to Get all FPO Sales Details",response=FPOSalesDetails.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forb	idden" , response = ExceptionResponse.class)
    })
    public List<FPOSalesDetailsDTO> getSalesDetails(@PathVariable("masterId") Integer masterId){

        return fpoSalesDetailsService.getSalesDetails(masterId);
    }

    @GetMapping("/getFpoSalesDetailsById/{id}")
    @ApiOperation(value="Fetch FPOSalesDetails By ID" ,code=201, produces = "application/json", notes="Api to FPO Sales Detailss By ID",response=FPOSalesDetails.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public Optional<FPOSaleInfo> getSalesDetailsById(@PathVariable Integer id) {

        return fpoSalesDetailsService.getSalesDetailsById(id);
    }


    @PostMapping("/addFpoSalesDetails")
    @ApiOperation(value="Add FPO Sales Details" ,code=201, produces = "application/json", notes="Api for add new FPO Sales Details",response= FPOSalesDetails.class)
    @ApiResponses(value= {
    		@ApiResponse(code = 201, message = "Created",response = ExceptionResponse.class),
    		@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> insertSalesDetails(@RequestBody FPOSaleInfo salesInfo) throws Exception
    {
        
        try {
            FPOSaleInfo id = fpoSalesDetailsService.insertSalesDetails(salesInfo);
            return new ResponseEntity<String>("FPOSalesDetails Saved Successfully!", HttpStatus.OK );
            
        } catch (Exception e) {
        	System.out.print(e.getMessage());
        	return new ResponseEntity<String>("Failed to save FPOSalesDetails", HttpStatus.INTERNAL_SERVER_ERROR );
        }
        
    }


    @PutMapping("/updateFpoSalesDetails/{id}")
    @ApiOperation(value="Update FPO Sales Details" ,code=201, produces = "application/json", notes="Api To Update FPO Sales Details",response=FPOSaleInfo.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> updateSalesDetails1(@PathVariable Integer id, @RequestBody FPOSaleInfo fpoSalesInfo) 
    {
        ResponseEntity<String> resp = null;
        try {
            FPOSaleInfo fsd = fpoSalesDetailsService.updateSalesDetails(id, fpoSalesInfo);
            resp = new ResponseEntity<String>("FPOSalesDetails Updated Successfully!", HttpStatus.OK );
            LOG.info("FPOSalesDetails Updated Successfully!");
            
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Update the Sales Details", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Update the Sales Details");
            e.printStackTrace();
        }
        LOG.info("Exiting FPOSalesDetails Of Controller with response ", resp);
        return resp;
    }


    @DeleteMapping("/deleteFpoSalesDetails/{id}")
    @ApiOperation(value="Delete FPO Sales Details" ,code=201, produces = "application/json", notes="Api To Delete FPO Sales Details",response=FPOSalesDetails.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> deleteSalesDetails1(@PathVariable Integer id) {
        LOG.info("Inside SalesDetailsController delete sales details ");
        ResponseEntity<String> resp = null;
        try {
            fpoSalesDetailsService.deleteFPOSalesDetails(id);
            resp = new ResponseEntity<String>("FPOSalesDetails Deleted Successfully!", HttpStatus.OK );
            LOG.info("FPOSalesDetails Deleted Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Delete the Sales Details", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Delete the Sales Details");
            e.printStackTrace();
        }
        LOG.info("Exiting FPOSalesDetails Of Controller with response ", resp);
        return resp;
    }

}
