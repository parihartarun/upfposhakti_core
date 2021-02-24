package com.upfpo.app.controller;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.UploadFileResponse;
import com.upfpo.app.entity.*;
import com.upfpo.app.service.InputSupplierMachineryServiceImpl;
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
@RequestMapping(value="inputsupplier/machinery/")
@Api(produces = "application/json", tags="InputSupplierMachinery Controller", value = "Add, Update, Delete, and retrive the InputSupplierMachinery Detail")
public class InputSupplierMachineryController {


    @Autowired
    private InputSupplierMachineryServiceImpl machineryService;

    private static final Logger LOG = LoggerFactory.getLogger(InputSupplierMachineryController.class);

    private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg","image/jpg", "image/gif");


    @GetMapping("/getall")
    @ApiOperation(value="InputSupplierMachinerys List" ,code=201, produces = "application/json", notes="Api for all InputSupplierMachinerys Info",response= InputSupplierMachinery.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<InputSupplierMachinery> getAllInputSupplierMachinerys (){
        return machineryService.getAllInputSupplierMachinery();
    }

    @GetMapping("/equipmenttype/getall")
    @ApiOperation(value="FertilizerType List" ,code=201, produces = "application/json", notes="Api for all FertilizerType Info",response= FertilizerType.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<EquipmentType> getFertilizerType (){
        return machineryService.getAllEquipmentType();
    }

    @GetMapping("/equipmentname/{id}")
    @ApiOperation(value="Fertilizer Name List" ,code=201, produces = "application/json", notes="Api for all FertilizerName Info",response= FertilizerName.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<EqupmentMaster> getAllEquipmentByType (@PathVariable Integer id){
        return machineryService.getAllEquipmentByType(id);
    }

   /* @GetMapping("/{id}")
    @ApiOperation(value="InputSupplierMachinerys List" ,code=201, produces = "application/json", notes="Api for all InputSupplierMachinerys Info",response= InputSupplierMachinerys.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<InputSupplierMachinery> getInputSupplierMachineryByFarmerId (@PathVariable Integer id){
        return machineryService.getInputSupplierMachineryByFarmerId(id);
    }*/




    @PostMapping
    @ApiOperation(value="Create InputSupplierMachinery" ,code=201, produces = "application/json", notes="Api for all create InputSupplierMachinery",response= InputSupplierMachinery.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> createInputSupplierMachinery(@RequestParam(value = "mchinery_type_id", required = false) Integer mchineryTypeId,
                                                                         @RequestParam(value = "machinery_name_id", required = false) Integer machineryNameId,
                                                                         @RequestParam(value = "quantity", required = false) Integer quantity,
                                                                         @RequestParam(value = "manufacturer_name", required = false) String manufacturerName,
                                                                         @RequestParam("input_supplier_id") Integer inputSupplierId,
                                                                         @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside InputSupplierMachineryController saving InputSupplierMachinery ");
        ResponseEntity<MessageResponse> resp = null;
        String fileContentType = file.getContentType();
        if (contentTypes.contains(fileContentType)) {
            try {
                InputSupplierMachinery inputSupplierMachinery = new InputSupplierMachinery(mchineryTypeId, machineryNameId, quantity, inputSupplierId, manufacturerName);
                InputSupplierMachinery id = machineryService.createInputSupplierMachinery(inputSupplierMachinery, file);
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("InputSupplierMachinery created successfully"), HttpStatus.OK );
                LOG.info("InputSupplierMachinery  created Successfully!");
            } catch (Exception e) {
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("InputSupplierMachinery creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed to Save the InputSupplierMachinery");
                e.printStackTrace();
            }
        }
        else{
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Incorrect file type, PDF or Image required."), HttpStatus.BAD_REQUEST);
            throw new IllegalArgumentException("Incorrect file type, Photo required.");
        }
        LOG.info("Exiting InputSupplierMachinery Of Controller with response ", resp);
        return resp;
    }


    @DeleteMapping(value="/{id}")
    @ApiOperation(value="Delete InputSupplierMachinery",code=204,produces = "text/plain",notes="Api for delete InputSupplierMachinery by id",response=Boolean.class)
    @ApiResponses(value= {
            @ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
            @ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
            @ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
            @ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
    })
    public ResponseEntity<MessageResponse> deleteInputSupplierMachinery(@PathVariable Integer id) {
        LOG.info("Inside InputSupplierMachineryController delete sales details ");
        ResponseEntity<MessageResponse> resp = null;
        try {
            if(machineryService.deleteInputSupplierMachinery(id)==true)
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("InputSupplierMachinery Deleted Successfully!"), HttpStatus.OK );
            LOG.info("InputSupplierMachinery Deleted Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Delete the InputSupplierMachinery"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Delete the InputSupplierMachinery");
            e.printStackTrace();
        }
        LOG.info("Exiting InputSupplierMachinery Of Controller with response ", resp);
        return resp;
    }




    @PutMapping("/{id}")
    @ApiOperation(value="Update InputSupplierMachinery Details" ,code=201, produces = "application/json", notes="Api To Update InputSupplierMachinery Details",response= InputSupplierMachinery.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> updateInputSupplierMachinery(@PathVariable Integer id,
                                                                        @RequestPart(value = "mchinery_type_id", required = false) Integer mchineryTypeId,
                                                                        @RequestPart(value = "machinery_name_id", required = false) Integer machineryNameId,
                                                                        @RequestPart(value = "quantity", required = false) Integer quantity,
                                                                        @RequestPart(value = "manufacturer_name", required = false) String manufacturerName,
                                                                        @RequestPart("input_supplier_id") Integer inputSupplierId,
                                                                        @RequestPart(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside InputSupplierMachinery updating InputSupplierMachinery detail ");
        InputSupplierMachinery inputSupplierMachinery = new InputSupplierMachinery(mchineryTypeId, machineryNameId, quantity, inputSupplierId, manufacturerName);
        ResponseEntity<MessageResponse> resp = null;
        String fileContentType = file.getContentType();
        if (contentTypes.contains(fileContentType)){
            try {
                machineryService.updateInputSupplierMachinery(id, inputSupplierMachinery, file);
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("InputSupplierMachinery Details Updated Successfully!"), HttpStatus.OK );
                LOG.info("InputSupplierMachinery Updated Successfully!");
            } catch (Exception e) {
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Update the InputSupplierMachinery Details"), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed to Update the InputSupplierMachinery Details");
                e.printStackTrace();
            }
        }
        LOG.info("Exiting InputSupplierMachinery Of Controller with response ", resp);
        return resp;
    }

    @GetMapping("/download/{fileName:.+}")
    @ApiOperation(value="InputSupplierMachinerys Download" ,code=201, produces = "application/json", notes="Api for Download InputSupplierMachinery File", response= UploadFileResponse.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = machineryService.loadFileAsResource(fileName);

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
