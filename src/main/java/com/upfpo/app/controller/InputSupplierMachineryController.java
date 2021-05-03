package com.upfpo.app.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.sun.tools.sjavac.Log;
import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.InputSupplierMachineryDTO;
import com.upfpo.app.dto.UploadFileResponse;
import com.upfpo.app.entity.EquipmentType;
import com.upfpo.app.entity.EqupmentMaster;
import com.upfpo.app.entity.FertilizerName;
import com.upfpo.app.entity.FertilizerType;
import com.upfpo.app.entity.InputSupplierMachinery;
import com.upfpo.app.requestStrings.ReportRequestString;
import com.upfpo.app.service.InputSupplierMachineryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/inputsupplier/machinery")
@Api(produces = "application/json", tags="InputSupplierMachinery Controller", value = "Add, Update, Delete, and retrive the InputSupplierMachinery Detail")
public class InputSupplierMachineryController {


    @Autowired
    private InputSupplierMachineryServiceImpl machineryService;

    private static final Logger LOG = LogManager.getLogger(InputSupplierMachineryController.class);

 //   private static final Logger LOG = LogManager.getLogger(InputSupplierMachineryController.class);
    private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg", "image/jpg", "image/gif",
            "image/PNG", "image/JPEG", "image/JPG", "image/GIF", "multipart/form-data", "application/pdf", "application/msword","application/vnd.openxmlformats-officedocument.wordprocessingml.document", "text/plain");


    @PostMapping("/getall")
    @ApiOperation(value="InputSupplierMachinerys List" ,code=201, produces = "application/json", notes="Api for all InputSupplierMachinerys Info",response= InputSupplierMachinery.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<InputSupplierMachineryDTO> getAllInputSupplierMachinerys (@RequestBody ReportRequestString reportRequestString){
        return machineryService.getAllInputSupplierMachinery(reportRequestString);
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
    public ResponseEntity<MessageResponse> createInputSupplierMachinery(@RequestParam(value = "machinery_type_id", required = false) Integer mchineryTypeId,
                                                                        @RequestParam(value = "machinery_name_id", required = false) Integer machineryNameId,
                                                                        @RequestParam(value = "other_machinery_name", required = false) String otherMachineryName,
                                                                        @RequestParam(value = "specification", required = false) String  specification,
                                                                        @RequestParam(value = "quantity", required = false) Integer quantity,
                                                                        @RequestParam(value = "manufacturer_name", required = false) String manufacturerName,
                                                                        @RequestParam(value = "rent_per_day", required = false) Double rentPerDay,
                                                                        @RequestParam(value = "vendor_id", required = false) Integer inputSupplierId,
                                                                        @RequestParam(value = "role", required = false) String role,
                                                                        @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside InputSupplierMachineryController saving InputSupplierMachinery");
        ResponseEntity<MessageResponse> resp = null;
        String fileContentType = "";
        if(file == null)
        {
        	 fileContentType = null;
        }
        else
        {
        	fileContentType = file.getContentType();
        }
        if(contentTypes.contains(fileContentType) || fileContentType == null)
        {
            try {
                InputSupplierMachinery inputSupplierMachinery = new InputSupplierMachinery(mchineryTypeId, machineryNameId, otherMachineryName, specification, quantity, inputSupplierId, manufacturerName, rentPerDay,role);
                Log.info(inputSupplierMachinery.getRole());
                InputSupplierMachinery id = machineryService.createInputSupplierMachinery(inputSupplierMachinery, file);
                Log.info("InputSupplierMachinery Id"+id);
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

    @PutMapping("/update/{id}")
    @ApiOperation(value="Update Complaint Details" ,code=201, produces = "application/json", notes="Api To Update Complaint Details",response= InputSupplierMachinery.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> updateComplaint(@PathVariable Integer id,
                                                           @RequestParam(value = "machinery_type_id", required = false) Integer mchineryTypeId,
                                                           @RequestParam(value = "machinery_name_id", required = false) Integer machineryNameId,
                                                           @RequestParam(value = "other_machinery_name", required = false) String otherMachineryName,
                                                           @RequestParam(value = "specification", required = false) String specification,
                                                           @RequestParam(value = "quantity", required = false) Integer quantity,
                                                           @RequestParam(value = "manufacturer_name", required = false) String manufacturerName,
                                                           @RequestParam(value = "vendor_id", required = false) Integer inputSupplierId,
                                                           @RequestParam(value = "rent_per_day", required = false) Double rentPerDay,
                                                           @RequestParam(value = "role", required = false) String role,
                                                           @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside Complaint updating Complaint detail ");
        InputSupplierMachinery supplierMachinery = new InputSupplierMachinery();
        supplierMachinery.setId(id);
        supplierMachinery.setMachinerynameId(machineryNameId);
        supplierMachinery.setMachineryTypeId(mchineryTypeId);
        supplierMachinery.setOtherEquipmentName(otherMachineryName);
        supplierMachinery.setInputSupplierId(inputSupplierId);
        supplierMachinery.setTechnicalSpecs(specification);
        supplierMachinery.setQuantity(quantity);
        supplierMachinery.setRole(role);
        supplierMachinery.setManufacturerName(manufacturerName);
        supplierMachinery.setRentPerDay(rentPerDay);
        ResponseEntity<MessageResponse> resp = null;
        String fileContentType = file.getContentType();
        if (contentTypes.contains(fileContentType)){
            try {
                machineryService.updateInputSupplierMachinery(id, supplierMachinery, file);
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("Complaint Details Updated Successfully!"), HttpStatus.OK );
                LOG.info("Complaint Updated Successfully!");
            } catch (Exception e) {
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Update the Complaint Details"), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed to Update the Complaint Details");
                e.printStackTrace();
            }
        }
        LOG.info("Exiting Complaint Of Controller with response ", resp);
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
                                                                        @RequestParam(value = "file", required = false) MultipartFile file,
                                                                        @RequestParam(value = "machinery_type_id", required = false) Integer mchineryTypeId,
                                                                        @RequestParam(value = "machinery_name_id", required = false) Integer machineryNameId,
                                                                        @RequestParam(value = "specification", required = false) String specification,
                                                                        @RequestParam(value = "quantity", required = false) Integer quantity,
                                                                        @RequestParam(value = "manufacturer_name", required = false) String manufacturerName,
                                                                        @RequestParam(value = "input_supplier_id", required = false) Integer inputSupplierId,
                                                                        @RequestParam(value = "role", required = false) String role
                                                                        ) {
        LOG.info("Inside InputSupplierMachinery updating InputSupplierMachinery detail ");
        InputSupplierMachinery supplierMachinery = new InputSupplierMachinery();
        supplierMachinery.setMachinerynameId(machineryNameId);
        supplierMachinery.setMachineryTypeId(mchineryTypeId);
        supplierMachinery.setInputSupplierId(inputSupplierId);
        supplierMachinery.setTechnicalSpecs(specification);
        supplierMachinery.setQuantity(quantity);
        supplierMachinery.setManufacturerName(manufacturerName);
        ResponseEntity<MessageResponse> resp = null;
            try {
                machineryService.updateInputSupplierMachinery(id, supplierMachinery, file);
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("InputSupplierMachinery Details Updated Successfully!"), HttpStatus.OK );
                LOG.info("InputSupplierMachinery Updated Successfully!");
            } catch (Exception e) {
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Update the InputSupplierMachinery Details"), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed to Update the InputSupplierMachinery Details");
                e.printStackTrace();
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
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}