package com.upfpo.app.controller;


import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.InputSupplierSeedDTO;
import com.upfpo.app.dto.UploadFileResponse;
import com.upfpo.app.entity.InputSupplierMachinery;
import com.upfpo.app.entity.InputSupplierSeed;
import com.upfpo.app.service.InputSupplierSeedServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.applet.Applet;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/master/seed")
@Api(produces = "application/json", tags="InputSupplierSeed Controller", value = "Add, Update, Delete, and retrive the InputSupplierSeed Detail")
public class InputSupplierSeedController {
    
    @Autowired
    private InputSupplierSeedServiceImpl seedService;

    private static final Logger LOG = LoggerFactory.getLogger(InputSupplierSeedController.class);

    private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg", "image/jpg", "image/gif",
            "image/PNG", "image/JPEG", "image/JPG", "image/GIF", "multipart/form-data");

    private HttpServletRequest request;


    @GetMapping("/getall/{id}")
    @ApiOperation(value="InputSupplierSeeds List" ,code=201, produces = "application/json", notes="Api for all InputSupplierSeeds Info",response= InputSupplierSeed.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<InputSupplierSeedDTO> getAllInputSupplierSeeds (@PathVariable Integer id){
        return seedService.getAllInputSupplierSeed(id);
    }

    /*@GetMapping("/{id}")
    @ApiOperation(value="InputSupplierSeeds List" ,code=201, produces = "application/json", notes="Api for all InputSupplierSeeds Info",response= InputSupplierSeeds.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<InputSupplierSeed> getInputSupplierSeedByFarmerId (@PathVariable Integer id){
        return seedService.getInputSupplierSeedByFarmerId(id);
    }*/




    @PostMapping
    @ApiOperation(value="Create InputSupplierSeed" ,code=201, produces = "application/json", notes="Api for all create InputSupplierSeed",response= InputSupplierSeed.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> createInputSupplierSeed(@RequestParam(value = "crop_id", required = false) Integer cropId,
                                                                   @RequestParam(value = "variety_id", required = false) Integer varietyId,
                                                                   @RequestParam(value = "company", required = false) String company,
                                                                   @RequestParam(value = "certification_no", required = false) String certificationNo,
                                                                   @RequestParam(value = "quantity", required = false) Double quantity,
                                                                   @RequestParam(value = "valid_from", required = false)String validFrom,
                                                                   @RequestParam(value = "valid_to", required = false)String validTo,
                                                                   @RequestParam(value = "input_supplier_id", required = false) Integer inputSupplierId,
                                                                   @RequestParam(value = "role", required = false) String role,
                                                                   @RequestParam(value = "file", required = false) MultipartFile file) throws ParseException {
        LOG.info("Inside InputSupplierSeedController saving InputSupplierSeed ");
        ResponseEntity<MessageResponse> resp = null;
        //validFrom = new SimpleDateFormat("dd/MM/yyyy").parse((String)request.getParameter("dob"));
        //validTo = new SimpleDateFormat("dd/MM/yyyy").parse((String)request.getParameter("dob"));
            try {
                InputSupplierSeed inputSupplierSeed = new InputSupplierSeed(cropId,inputSupplierId,varietyId,company, certificationNo,validFrom,validTo, quantity,role);
                InputSupplierSeed id = seedService.createInputSupplierSeed(inputSupplierSeed, file);
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("InputSupplierSeed created successfully"), HttpStatus.OK );
                LOG.info("InputSupplierSeed  created Successfully!");
            } catch (Exception e) {
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("InputSupplierSeed creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed to Save the InputSupplierSeed");
                e.printStackTrace();
            }

        LOG.info("Exiting InputSupplierSeed Of Controller with response ", resp);
        return resp;
    }


    @DeleteMapping(value="/{id}")
    @ApiOperation(value="Delete InputSupplierSeed",code=204,produces = "text/plain",notes="Api for delete InputSupplierSeed by id",response=Boolean.class)
    @ApiResponses(value= {
            @ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
            @ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
            @ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
            @ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
    })
    public ResponseEntity<MessageResponse> deleteInputSupplierSeed(@PathVariable Integer id) {
        LOG.info("Inside InputSupplierSeedController delete sales details ");
        ResponseEntity<MessageResponse> resp = null;
        try {
            if(seedService.deleteInputSupplierSeed(id)==true)
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("InputSupplierSeed Deleted Successfully!"), HttpStatus.OK );
            LOG.info("InputSupplierSeed Deleted Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Delete the InputSupplierSeed"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Delete the InputSupplierSeed");
            e.printStackTrace();
        }
        LOG.info("Exiting InputSupplierSeed Of Controller with response ", resp);
        return resp;
    }



    @PutMapping("/{id}")
    @ApiOperation(value="Update InputSupplierSeed Details" ,code=201, produces = "application/json", notes="Api To Update InputSupplierSeed Details",response= InputSupplierSeed.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> updateInputSupplierSeed(@PathVariable Integer id,
                                                                   @RequestParam(value = "crop_id", required = false) Integer cropId,
                                                                   @RequestParam(value = "variety_id", required = false) Integer varietyId,
                                                                   @RequestParam(value = "company", required = false) String company,
                                                                   @RequestParam(value = "certification_no", required = false) String certificationNo,
                                                                   @RequestParam(value = "quantity", required = false) Double quantity,
                                                                   @RequestParam(value = "valid_from", required = false) String validFrom,
                                                                   @RequestParam(value = "valid_to", required = false) String validTo,
                                                                   @RequestParam(value = "role", required = false) String role,
                                                                   @RequestParam(value = "input_supplier_id", required = false) Integer inputSupplierId,
                                                                   @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside InputSupplierSeed updating InputSupplierSeed detail ");
        InputSupplierSeed inputSupplierSeed = new InputSupplierSeed();
        inputSupplierSeed.setCropId(cropId);
        inputSupplierSeed.setVariety(varietyId);
        inputSupplierSeed.setInputSupplierId(inputSupplierId);
        inputSupplierSeed.setCertificationNumber(certificationNo);
        inputSupplierSeed.setQuantity(quantity);
        inputSupplierSeed.setCompanyBrand(company);
        inputSupplierSeed.setCertificationValidFrom(validFrom);
        inputSupplierSeed.setCertificationValidTo(validTo);
        inputSupplierSeed.setRole(role);
        ResponseEntity<MessageResponse> resp = null;
            try {
                seedService.updateInputSupplierSeed(id, inputSupplierSeed, file);
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("InputSupplierSeed Details Updated Successfully!"), HttpStatus.OK );
                LOG.info("InputSupplierSeed Updated Successfully!");
            } catch (Exception e) {
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Update the InputSupplierSeed Details"), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed to Update the InputSupplierSeed Details");
                e.printStackTrace();
            }

        LOG.info("Exiting InputSupplierSeed Of Controller with response ", resp);
        return resp;
    }


    @GetMapping("/download/{fileName:.+}")
    @ApiOperation(value="InputSupplierSeeds Download" ,code=201, produces = "application/json", notes="Api for Download InputSupplierSeed File", response= UploadFileResponse.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = seedService.loadFileAsResource(fileName);
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            LOG.info("Could not determine file type.");
        }
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
