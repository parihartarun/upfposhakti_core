package com.upfpo.app.controller;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.UploadFileResponse;
import com.upfpo.app.entity.FertilizerName;
import com.upfpo.app.entity.FertilizerType;
import com.upfpo.app.entity.InputSupplierFertilizer;
import com.upfpo.app.service.InputSupplierFertilizerServiceImpl;
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
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="inputsupplier/fertilizer/")
@Api(produces = "application/json", tags="InputSupplierFertilizer Controller", value = "Add, Update, Delete, and retrive the InputSupplierFertilizer Detail")
public class InputSupplierFertilizerController {


    @Autowired
    private InputSupplierFertilizerServiceImpl fertilizerService;

    private static final Logger LOG = LoggerFactory.getLogger(InputSupplierFertilizerController.class);

    private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg","image/jpg", "image/gif");


    @GetMapping("/getall")
    @ApiOperation(value="InputSupplierFertilizers List" ,code=201, produces = "application/json", notes="Api for all InputSupplierFertilizers Info",response= InputSupplierFertilizer.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<InputSupplierFertilizer> getAllInputSupplierFertilizers (){
        return fertilizerService.getAllInputSupplierFertilizer();
    }

    @GetMapping("/fertilizertype/getall")
    @ApiOperation(value="FertilizerType List" ,code=201, produces = "application/json", notes="Api for all FertilizerType Info",response= FertilizerType.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<FertilizerType> getFertilizerType (){
        return fertilizerService.getAllFertilizerType();
    }

    @GetMapping("/fertilizername/getall")
    @ApiOperation(value="Fertilizer Name List" ,code=201, produces = "application/json", notes="Api for all FertilizerName Info",response= FertilizerName.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<FertilizerName> getAllFertilizerName (){
        return fertilizerService.getAllFertilizerName();
    }

    /*@GetMapping("/{id}")
    @ApiOperation(value="InputSupplierFertilizers List" ,code=201, produces = "application/json", notes="Api for all InputSupplierFertilizers Info",response= InputSupplierFertilizers.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<InputSupplierFertilizer> getInputSupplierFertilizerByFarmerId (@PathVariable Integer id){
        return fertilizerService.getInputSupplierFertilizerByFarmerId(id);
    }*/




    @PostMapping
    @ApiOperation(value="Create InputSupplierFertilizer" ,code=201, produces = "application/json", notes="Api for all create InputSupplierFertilizer",response= InputSupplierFertilizer.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> createInputSupplierFertilizer(@RequestParam(value = "type_id", required = false) Integer fertilizerTypeId,
                                                                         @RequestParam(value = "name_id", required = false) Integer fertilizerNameId,
                                                                         @RequestParam(value = "fertilizer_grade", required = false) String fertilizerGrade,
                                                                         @RequestParam(value = "manufacturer_name", required = false) String manufacturerName,
                                                                         @RequestParam("input_supplier_id") Integer inputSupplierId,
                                                                         @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside InputSupplierFertilizerController saving InputSupplierFertilizer ");
        ResponseEntity<MessageResponse> resp = null;
        String fileContentType = file.getContentType();
        if (contentTypes.contains(fileContentType)) {
            try {
                InputSupplierFertilizer inputSupplierFertilizer = new InputSupplierFertilizer(fertilizerTypeId, fertilizerNameId, inputSupplierId, fertilizerGrade, manufacturerName);
                InputSupplierFertilizer id = fertilizerService.createInputSupplierFertilizer(inputSupplierFertilizer, file);
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("InputSupplierFertilizer created successfully"), HttpStatus.OK );
                LOG.info("InputSupplierFertilizer  created Successfully!");
            } catch (Exception e) {
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("InputSupplierFertilizer creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed to Save the InputSupplierFertilizer");
                e.printStackTrace();
            }
        }
        else{
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Incorrect file type, PDF or Image required."), HttpStatus.BAD_REQUEST);
            throw new IllegalArgumentException("Incorrect file type, Photo required.");
        }
        LOG.info("Exiting InputSupplierFertilizer Of Controller with response ", resp);
        return resp;
    }


    @DeleteMapping(value="/{id}")
    @ApiOperation(value="Delete InputSupplierFertilizer",code=204,produces = "text/plain",notes="Api for delete InputSupplierFertilizer by id",response=Boolean.class)
    @ApiResponses(value= {
            @ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
            @ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
            @ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
            @ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
    })
    public ResponseEntity<MessageResponse> deleteInputSupplierFertilizer(@PathVariable Integer id) {
        LOG.info("Inside InputSupplierFertilizerController delete sales details ");
        ResponseEntity<MessageResponse> resp = null;
        try {
            if(fertilizerService.deleteInputSupplierFertilizer(id)==true)
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("InputSupplierFertilizer Deleted Successfully!"), HttpStatus.OK );
            LOG.info("InputSupplierFertilizer Deleted Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Delete the InputSupplierFertilizer"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Delete the InputSupplierFertilizer");
            e.printStackTrace();
        }
        LOG.info("Exiting InputSupplierFertilizer Of Controller with response ", resp);
        return resp;
    }




    @PutMapping("/{id}")
    @ApiOperation(value="Update InputSupplierFertilizer Details" ,code=201, produces = "application/json", notes="Api To Update InputSupplierFertilizer Details",response= InputSupplierFertilizer.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> updateInputSupplierFertilizer(@PathVariable Integer id,
                                                                         @RequestParam(value = "type_id", required = false) Integer fertilizerTypeId, @RequestParam(value = "name_id", required = false) Integer fertilizerNameId,
                                                                         @RequestParam(value = "fertilizer_grade", required = false) String fertilizerGrade, @RequestParam(value = "manufacturer_name", required = false) String manufacturerName,
                                                                         @RequestParam("input_supplier_id") Integer inputSupplierId,
                                                                         @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside InputSupplierFertilizer updating InputSupplierFertilizer detail ");
        InputSupplierFertilizer inputSupplierFertilizer = new InputSupplierFertilizer(fertilizerTypeId, fertilizerNameId, inputSupplierId, fertilizerGrade, manufacturerName);
        ResponseEntity<MessageResponse> resp = null;
        String fileContentType = file.getContentType();
        if (contentTypes.contains(fileContentType)){
            try {
                fertilizerService.updateInputSupplierFertilizer(id, inputSupplierFertilizer, file);
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("InputSupplierFertilizer Details Updated Successfully!"), HttpStatus.OK );
                LOG.info("InputSupplierFertilizer Updated Successfully!");
            } catch (Exception e) {
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Update the InputSupplierFertilizer Details"), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed to Update the InputSupplierFertilizer Details");
                e.printStackTrace();
            }
        }
        LOG.info("Exiting InputSupplierFertilizer Of Controller with response ", resp);
        return resp;
    }

    @GetMapping("/download/{fileName:.+}")
    @ApiOperation(value="InputSupplierFertilizers Download" ,code=201, produces = "application/json", notes="Api for Download InputSupplierFertilizer File", response= UploadFileResponse.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fertilizerService.loadFileAsResource(fileName);

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
