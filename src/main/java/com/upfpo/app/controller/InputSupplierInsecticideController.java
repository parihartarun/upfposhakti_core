package com.upfpo.app.controller;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.InputSupplierInsecticideDTO;
import com.upfpo.app.dto.UploadFileResponse;
import com.upfpo.app.entity.FertilizerName;
import com.upfpo.app.entity.FertilizerType;
import com.upfpo.app.entity.InputSupplierInsecticide;
import com.upfpo.app.entity.InsecticideType;
import com.upfpo.app.service.InputSupplierInsecticideServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/inputsupplier/insecticide")
@Api(produces = "application/json", tags="InputSupplierInsecticide Controller", value = "Add, Update, Delete, and retrive the InputSupplierInsecticide Detail")
public class InputSupplierInsecticideController {


    @Autowired
    private InputSupplierInsecticideServiceImpl insecticideService;

    private static final Logger LOG = LoggerFactory.getLogger(InputSupplierInsecticideController.class);

    private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg", "image/jpg", "image/gif",
            "image/PNG", "image/JPEG", "image/JPG", "image/GIF", "multipart/form-data");



    @GetMapping("/getall/{id}")
    @ApiOperation(value="InputSupplierInsecticides List" ,code=201, produces = "application/json", notes="Api for all InputSupplierInsecticides Info",response= InputSupplierInsecticide.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<InputSupplierInsecticideDTO> getAllInputSupplierInsecticides (@PathVariable Integer id){
        return insecticideService.getAllInputSupplierInsecticide(id);
    }

    @GetMapping("/insecticidetype/getall")
    @ApiOperation(value="InsecticideType List" ,code=201, produces = "application/json", notes="Api for all InsecticideType Info",response= InsecticideType.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<InsecticideType> getInsecticideType (){
        return insecticideService.getInsecticideType();
    }

    /*@GetMapping("/fertilizername/getall")
    @ApiOperation(value="Fertilizer Name List" ,code=201, produces = "application/json", notes="Api for all FertilizerName Info",response= FertilizerName.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<FertilizerName> getAllFertilizerName (){
        return insecticideService.getAllFertilizerName();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="InputSupplierInsecticides List" ,code=201, produces = "application/json", notes="Api for all InputSupplierInsecticides Info",response= InputSupplierInsecticides.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<InputSupplierInsecticide> getInputSupplierInsecticideByFarmerId (@PathVariable Integer id){
        return insecticideService.getInputSupplierInsecticideByFarmerId(id);
    }*/




    @PostMapping
    @ApiOperation(value="Create InputSupplierInsecticide" ,code=201, produces = "application/json", notes="Api for all create InputSupplierInsecticide",response= InputSupplierInsecticide.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> createInputSupplierInsecticide(@RequestParam(value = "insecticide_type_id", required = false) Integer insecticideTypeId,
                                                                          @RequestParam(value = "manufacturer_name", required = false) String manufacturerName,
                                                                        @RequestParam(value = "quantity", required = false) Integer quantity,
                                                                        @RequestParam(value = "cib_rc_number", required = false) String cibRcNumber,
                                                                        @RequestParam(value = "cib_rc_issuedate", required = false) String cibRcIssuedate,
                                                                        @RequestParam(value = "vendor_id", required = false) Integer inputSupplierId,
                                                                        @RequestParam(value = "role", required = false) String role,
                                                                        @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside InputSupplierInsecticideController saving InputSupplierInsecticide ");
        ResponseEntity<MessageResponse> resp = null;
            try {
                InputSupplierInsecticide inputSupplierInsecticide = new InputSupplierInsecticide(insecticideTypeId,manufacturerName, quantity, inputSupplierId, cibRcNumber, cibRcIssuedate,role);
                InputSupplierInsecticide id = insecticideService.createInputSupplierInsecticide(inputSupplierInsecticide, file);
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("InputSupplierInsecticide created successfully"), HttpStatus.OK );
                LOG.info("InputSupplierInsecticide  created Successfully!");
            } catch (Exception e) {
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("InputSupplierInsecticide creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed to Save the InputSupplierInsecticide");
                e.printStackTrace();
            }
        LOG.info("Exiting InputSupplierInsecticide Of Controller with response ", resp);
        return resp;
    }


    @DeleteMapping(value="/{id}")
    @ApiOperation(value="Delete InputSupplierInsecticide",code=204,produces = "text/plain",notes="Api for delete InputSupplierInsecticide by id",response=Boolean.class)
    @ApiResponses(value= {
            @ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
            @ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
            @ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
            @ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
    })
    public ResponseEntity<MessageResponse> deleteInputSupplierInsecticide(@PathVariable Integer id) {
        LOG.info("Inside InputSupplierInsecticideController delete sales details ");
        ResponseEntity<MessageResponse> resp = null;
        try {
            if(insecticideService.deleteInputSupplierInsecticide(id)==true)
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("InputSupplierInsecticide Deleted Successfully!"), HttpStatus.OK );
            LOG.info("InputSupplierInsecticide Deleted Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Delete the InputSupplierInsecticide"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Delete the InputSupplierInsecticide");
            e.printStackTrace();
        }
        LOG.info("Exiting InputSupplierInsecticide Of Controller with response ", resp);
        return resp;
    }




    @PutMapping("/{id}")
    @ApiOperation(value="Update InputSupplierInsecticide Details" ,code=201, produces = "application/json", notes="Api To Update InputSupplierInsecticide Details",response= InputSupplierInsecticide.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> updateInputSupplierInsecticide(@PathVariable Integer id,
                                                                          @RequestParam(value = "insecticide_type_id", required = false) Integer insecticideTypeId,
                                                                          @RequestParam(value = "manufacturer_name", required = false) String manufacturerName,
                                                                          @RequestParam(value = "quantity", required = false) Integer quantity,
                                                                          @RequestParam(value = "cib_rc_number", required = false) String cibRcNumber,
                                                                          @RequestParam(value = "cib_rc_issuedate", required = false) String cibRcIssuedate,
                                                                          @RequestParam(value = "vendor_id", required = false) Integer inputSupplierId,
                                                                          @RequestParam(value = "role", required = false) String role,
                                                                          @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside InputSupplierInsecticide updating InputSupplierInsecticide detail ");
        InputSupplierInsecticide inputSupplierInsecticide = new InputSupplierInsecticide();
        inputSupplierInsecticide.setInsecticideTypeId(insecticideTypeId);
        inputSupplierInsecticide.setManufacturerName(manufacturerName);
        inputSupplierInsecticide.setQuantity(quantity);
        inputSupplierInsecticide.setCibRcNumber(cibRcNumber);
        inputSupplierInsecticide.setCibRcIssueDate(cibRcIssuedate);
        inputSupplierInsecticide.setInputSupplierId(inputSupplierId);
        ResponseEntity<MessageResponse> resp = null;
            try {
                insecticideService.updateInputSupplierInsecticide(id, inputSupplierInsecticide, file);
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("InputSupplierInsecticide Details Updated Successfully!"), HttpStatus.OK );
                LOG.info("InputSupplierInsecticide Updated Successfully!");
            } catch (Exception e) {
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Update the InputSupplierInsecticide Details"), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed to Update the InputSupplierInsecticide Details");
                e.printStackTrace();
            }
        LOG.info("Exiting InputSupplierInsecticide Of Controller with response ", resp);
        return resp;
    }

    @GetMapping("/download/{fileName:.+}")
    @ApiOperation(value="InputSupplierInsecticides Download" ,code=201, produces = "application/json", notes="Api for Download InputSupplierInsecticide File", response= UploadFileResponse.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = insecticideService.loadFileAsResource(fileName);

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
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
