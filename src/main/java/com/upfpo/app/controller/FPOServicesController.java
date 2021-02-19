package com.upfpo.app.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.TotalProductionDTO;
import com.upfpo.app.dto.UploadFileResponse;
import com.upfpo.app.entity.FPOServices;
import com.upfpo.app.service.FPOServicesServiceImpl;
import com.upfpo.app.util.TotalProductionCalculation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/fposervices")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "FPOServicess Information", tags="FPOServicess Controller",description="Proucts Details")
public class FPOServicesController {

    private static final Logger LOG = LoggerFactory.getLogger(FPOServicesController.class);

    private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg", "image/gif","application/pdf");


    @Autowired
    private FPOServicesServiceImpl fpoServicesService;

    @GetMapping("/getall")
    @ApiOperation(value="Fetch All FPOServices" ,code=201, produces = "application/json", notes="API to Get all FPOServicess Details",response= FPOServices.class)
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


    @PostMapping
    @ApiOperation(value="Add FPOServicess Details" ,code=201, produces = "application/json", notes="Api for add new FPOServicess Details",response= FPOServices.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> insertFPOService(@RequestParam("description") String description,
                                                            @RequestParam("servicename") String servicename,
                                                            @RequestParam("fpo_id") Integer fpoId,
                                                          @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside FPOServiceController saving FPOService ");
        ResponseEntity<MessageResponse> resp = null;
        String fileContentType = file.getContentType();
        if (contentTypes.contains(fileContentType)){
            try {
                FPOServices fposervices = new FPOServices(description, servicename, fpoId);
                FPOServices id = fpoServicesService.insertFPOServices(fposervices, file);
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("FPOService created successfully"), HttpStatus.OK );
                LOG.info("FPOService  created Successfully!");
            } catch (Exception e) {
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("FPOService creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed to Save the FPOService");
                e.printStackTrace();
            }
        }
        LOG.info("Exiting FPOService Of Controller with response ", resp);
        return resp;
    }



    @PutMapping("/{id}")
    @ApiOperation(value="Update FPOServices Details" ,code=201, produces = "application/json", notes="Api To Update FPOServices Details",response=FPOServices.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> updateFPOServices(@PathVariable Integer id,
                                                             @RequestPart(value = "description") String description,
                                                             @RequestPart(value = "servicename") String servicename,
                                                             @RequestPart(value = "file", required = false) MultipartFile file) {

        LOG.info("Inside FPOServices updating FPOServices detail ");

        FPOServices fpoServices = new FPOServices();
        fpoServices.setId(id);
        fpoServices.setServicename(servicename);
        fpoServices.setDescriptions(description);
        ResponseEntity<MessageResponse> resp = null;
        String fileContentType = file.getContentType();
        if (contentTypes.contains(fileContentType)){
            try {
                fpoServicesService.updateFPOServices(id, fpoServices, description, servicename, file);
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("FPOServices Details Updated Successfully!"), HttpStatus.OK );
                LOG.info("FPOServices Updated Successfully!");
                //}
            } catch (Exception e) {
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Update the FPOServices Details"), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed to Update the FPOServices Details");
                e.printStackTrace();
            }
        }
        LOG.info("Existing FPOServices Of Controller with response ", resp);
        return resp;
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation(value="Delete FPOServicess Details" ,code=201, produces = "application/json", notes="Api To Delete FPOServicess Details",response=FPOServices.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> deleteFPOServices(@PathVariable Integer id) {
        LOG.info("Inside SalesDetailsController delete sales details ");
        ResponseEntity<MessageResponse> resp = null;
        try {
            fpoServicesService.deleteFPOService(id);
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("FPOServices Details Deleted Successfully!"), HttpStatus.OK );
            LOG.info("FPOServicess Details Deleted Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Delete the FPOServices Details"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Delete the FPOServices Details");
            e.printStackTrace();
        }
        LOG.info("Exiting FPOServices Of Controller with response ", resp);
        return resp;
    }

    @GetMapping("/download/{fileName:.+}")
    @ApiOperation(value="Circularss Download" ,code=201, produces = "application/json", notes="Api for Download Circulars File", response= UploadFileResponse.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fpoServicesService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            LOG.info("Could not determine file type.");
        }
        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
