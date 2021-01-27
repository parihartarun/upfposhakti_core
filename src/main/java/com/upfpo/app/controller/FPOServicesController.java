package com.upfpo.app.controller;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;

import com.upfpo.app.entity.FPOServices;
import com.upfpo.app.entity.FPOServices;
import com.upfpo.app.service.FPOServicesServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/FPOServices")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "FPOServicess Information", tags="FPOServicess Controller",description="Proucts Details")
public class FPOServicesController {

    private static final Logger LOG = LoggerFactory.getLogger(FPOServicesController.class);

    @Autowired
    private FPOServicesServiceImpl fpoServicesService;

    @GetMapping("/getall")
    @ApiOperation(value="Fetch All FPOServicess" ,code=201, produces = "application/json", notes="API to Get all FPOServicess Details",response= FPOServices.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<FPOServices> getFPOServices (){

        return fpoServicesService.getFPOServices();
    }



    @GetMapping("/{id}")
    @ApiOperation(value="Fetch FPOServicess By ID" ,code=201, produces = "application/json", notes="Api to FPOServicess Detailss By ID",response=FPOServices.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public Optional<FPOServices> getFPOServicesById(@PathVariable Integer id) {

        return fpoServicesService.getFPOServicesById(id);
    }


    @PostMapping("/insert")
    @ApiOperation(value="Add FPOServicess Details" ,code=201, produces = "application/json", notes="Api for add new FPOServicess Details",response= FPOServices.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> insertFPOService(@RequestParam("description") String description, @RequestParam("servicename") String servicename,
                                                          @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside FPOServiceController saving FPOService ");
        ResponseEntity<MessageResponse> resp = null;
        try {

            FPOServices fposervices = new FPOServices(description, servicename);

            FPOServices id = fpoServicesService.insertFPOServices(fposervices, file);
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("FPOService created successfully"), HttpStatus.OK );
            LOG.info("FPOService  created Successfully!");
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(fileName)
                    .toUriString();
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("FPOService creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the FPOService");
            e.printStackTrace();
        }
        LOG.info("Exiting FPOService Of Controller with response ", resp);
        return resp;
    }



   /* @PostMapping("/insert")
    @ApiOperation(value="Add FPOServicess Details" ,code=201, produces = "application/json", notes="Api for add new FPOServicess Details",response= FPOServices.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> insertFPOServices(@RequestBody FPOServices fpoServices) {
        LOG.info("Inside SalesDetailsController saving sales details ", fpoServices);
        ResponseEntity<String> resp = null;
        try {
            FPOServices id = fpoServicesService.insertFPOServices(fpoServices);
            resp = new ResponseEntity<String>("FPOServices details created Successfully!", HttpStatus.OK );
            LOG.info("FPOSalesDetails  created Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Save the FPOServices Details", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the FPOServices Details");
            e.printStackTrace();
        }
        LOG.info("Exiting FPOServices Of Controller with response ", resp);
        return resp;
    }*/


    @PutMapping("/update1/{id}")
    @ApiOperation(value="Update FPOServices Details" ,code=201, produces = "application/json", notes="Api To Update FPOServices Details",response=FPOServices.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> updateFPOServices(@PathVariable Integer id, @RequestBody FPOServices fpoServices) {
        LOG.info("Inside SalesDetailsController updating sales details ", fpoServices);
        ResponseEntity<String> resp = null;
        try {
            FPOServices fsd = fpoServicesService.updateFPOServices(id, fpoServices);
            resp = new ResponseEntity<String>("FPOServices Details Updated Successfully!", HttpStatus.OK );
            LOG.info("FPOServices Updated Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Update the FPOServices Details", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Update the FPOServices Details");
            e.printStackTrace();
        }
        LOG.info("Exiting FPOServices Of Controller with response ", resp);
        return resp;
    }


    @DeleteMapping("/delete1/{id}")
    @ApiOperation(value="Delete FPOServicess Details" ,code=201, produces = "application/json", notes="Api To Delete FPOServicess Details",response=FPOServices.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> deleteFPOServices(@PathVariable Integer id) {
        LOG.info("Inside SalesDetailsController delete sales details ");
        ResponseEntity<String> resp = null;
        try {
            fpoServicesService.deleteFPOServices(id);
            resp = new ResponseEntity<String>("FPOServices Details Deleted Successfully!", HttpStatus.OK );
            LOG.info("FPOServicess Details Deleted Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Delete the FPOServices Details", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Delete the FPOServices Details");
            e.printStackTrace();
        }
        LOG.info("Exiting FPOServices Of Controller with response ", resp);
        return resp;
    }

}
