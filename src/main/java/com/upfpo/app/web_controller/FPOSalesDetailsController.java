package com.upfpo.app.web_controller;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.FPOSalesDetails;
import com.upfpo.app.service.FPOSalesDetailsServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/fposalesdetails")
public class FPOSalesDetailsController {

    private static final Logger LOG = LoggerFactory.getLogger(FPOSalesDetailsController.class);

    @Autowired
    private FPOSalesDetailsServiceImpl fpoSalesDetailsService;

    @GetMapping("/getall")
    @ApiOperation(value="Fetch All FPO Sales Details" ,code=201, produces = "application/json", notes="API to Get all FPO Sales Details",response=FPORegister.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<FPOSalesDetails> getSalesDetails (){

        return fpoSalesDetailsService.getSalesDetails();
    }



    @GetMapping("/{id}")
    @ApiOperation(value="Fetch FPOSalesDetails By ID" ,code=201, produces = "application/json", notes="Api to Fetch Farmer Detail By ID",response=FPORegister.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public Optional<FPOSalesDetails> getSalesDetailsById(@PathVariable Integer id) {

        return fpoSalesDetailsService.getSalesDetailsById(id);
    }


    @PostMapping("/insert")
    @ApiOperation(value="Add FPO Sales Details" ,code=201, produces = "application/json", notes="Api for add new FPO Sales Details",response= FPORegister.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> insertSalesDetails(@RequestBody FPOSalesDetails salesDetails) {
        LOG.info("Inside SalesDetailsController saving sales details ", salesDetails);
        ResponseEntity<String> resp = null;
        try {
            FPOSalesDetails id = fpoSalesDetailsService.insertSalesDetails(salesDetails);
            resp = new ResponseEntity<String>("FPOSalesDetails created Successfully!", HttpStatus.OK );
            LOG.info("FPOSalesDetails  created Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Save the Sales Details", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the Sales Details");
            e.printStackTrace();
        }
        LOG.info("Exiting FPOSalesDetails Of Controller with response ", resp);
        return resp;
    }


    @PutMapping("/update1/{id}")
    @ApiOperation(value="Update FPO Sales Details" ,code=201, produces = "application/json", notes="Api To Update FPO Sales Details",response=FPORegister.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> updateSalesDetails1(@PathVariable Integer id, @RequestBody FPOSalesDetails salesDetails) {
        LOG.info("Inside SalesDetailsController updating sales details ", salesDetails);
        ResponseEntity<String> resp = null;
        try {
            FPOSalesDetails fsd = fpoSalesDetailsService.updateSalesDetails(id, salesDetails);
            resp = new ResponseEntity<String>("FPOSalesDetails Updated Successfully!", HttpStatus.OK );
            LOG.info("FPOSalesDetails Updated Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Update the Sales Details", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Update the Sales Details");
            e.printStackTrace();
        }
        LOG.info("Exiting FPOSalesDetails Of Controller with response ", resp);
        return resp;
    }


    @DeleteMapping("/delete1/{id}")
    @ApiOperation(value="Delete FPO Sales Details" ,code=201, produces = "application/json", notes="Api To Delete FPO Sales Details",response=FPORegister.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> deleteSalesDetails1(@PathVariable Integer id) {
        LOG.info("Inside SalesDetailsController delete sales details ");
        ResponseEntity<String> resp = null;
        try {
            fpoSalesDetailsService.deleteSalesDetails(id);
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
