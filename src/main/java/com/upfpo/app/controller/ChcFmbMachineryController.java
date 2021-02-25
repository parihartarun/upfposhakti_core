package com.upfpo.app.controller;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.UploadFileResponse;
import com.upfpo.app.entity.*;
import com.upfpo.app.service.ChcFmbMachineryService;
import com.upfpo.app.service.ChcFmbMachineryServiceImpl;
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
@RequestMapping(value="chcfmb/machinery/")
@Api(produces = "application/json", tags="ChcFmbMachinery Controller", value = "Add, Update, Delete, and retrive the ChcFmbMachinery Detail")
public class ChcFmbMachineryController {


    @Autowired
    private ChcFmbMachineryService machineryService;

    private static final Logger LOG = LoggerFactory.getLogger(ChcFmbMachineryController.class);

    private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg","image/jpg", "image/gif");



    @GetMapping("/getall")
    @ApiOperation(value="ChcFmbMachinerys List" ,code=201, produces = "application/json", notes="Api for all ChcFmbMachinerys Info",response= ChcFmbMachinery.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<ChcFmbMachinery> getAllChcFmbMachinerys (){
        return machineryService.getAllChcFmbMachinery();
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
    @ApiOperation(value="ChcFmbMachinerys List" ,code=201, produces = "application/json", notes="Api for all ChcFmbMachinerys Info",response= ChcFmbMachinerys.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<ChcFmbMachinery> getChcFmbMachineryByFarmerId (@PathVariable Integer id){
        return machineryService.getChcFmbMachineryByFarmerId(id);
    }*/




    @PostMapping
    @ApiOperation(value="Create ChcFmbMachinery" ,code=201, produces = "application/json", notes="Api for all create ChcFmbMachinery",response= ChcFmbMachinery.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> createChcFmbMachinery(@RequestParam(value = "type_id", required = false) Integer typeId,
                                                                        @RequestParam(value = "name_id", required = false) Integer nameId,
                                                                        @RequestParam(value = "chc_fmb_id", required = false) Integer chcFmbId,
                                                                        @RequestParam(value = "capacity", required = false) Integer capacity,
                                                                        @RequestParam(value = "purchase_year", required = false) Calendar year,
                                                                        @RequestParam(value = "quantity", required = false) Integer quantity,
                                                                        @RequestParam(value = "company", required = false) String company,
                                                                        @RequestParam(value = "govt_scheme", required = false) String govtScheme,
                                                                        @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside ChcFmbMachineryController saving ChcFmbMachinery ");
        ResponseEntity<MessageResponse> resp = null;
        String fileContentType = file.getContentType();
        if (contentTypes.contains(fileContentType)) {
            try {
                ChcFmbMachinery chcFmbMachinery = new ChcFmbMachinery(typeId, nameId, chcFmbId, capacity, year, quantity, company, govtScheme);
                ChcFmbMachinery id = machineryService.createChcFmbMachinery(chcFmbMachinery, file);
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("ChcFmbMachinery created successfully"), HttpStatus.OK );
                LOG.info("ChcFmbMachinery  created Successfully!");
            } catch (Exception e) {
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("ChcFmbMachinery creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed to Save the ChcFmbMachinery");
                e.printStackTrace();
            }
        }
        else{
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Incorrect file type, PDF or Image required."), HttpStatus.BAD_REQUEST);
            throw new IllegalArgumentException("Incorrect file type, Photo required.");
        }
        LOG.info("Exiting ChcFmbMachinery Of Controller with response ", resp);
        return resp;
    }


    @DeleteMapping(value="/{id}")
    @ApiOperation(value="Delete ChcFmbMachinery",code=204,produces = "text/plain",notes="Api for delete ChcFmbMachinery by id",response=Boolean.class)
    @ApiResponses(value= {
            @ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
            @ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
            @ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
            @ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
    })
    public ResponseEntity<MessageResponse> deleteChcFmbMachinery(@PathVariable Integer id) {
        LOG.info("Inside ChcFmbMachineryController delete sales details ");
        ResponseEntity<MessageResponse> resp = null;
        try {
            if(machineryService.deleteChcFmbMachinery(id)==true)
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("ChcFmbMachinery Deleted Successfully!"), HttpStatus.OK );
            LOG.info("ChcFmbMachinery Deleted Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Delete the ChcFmbMachinery"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Delete the ChcFmbMachinery");
            e.printStackTrace();
        }
        LOG.info("Exiting ChcFmbMachinery Of Controller with response ", resp);
        return resp;
    }




    @PutMapping("/{id}")
    @ApiOperation(value="Update ChcFmbMachinery Details" ,code=201, produces = "application/json", notes="Api To Update ChcFmbMachinery Details",response= ChcFmbMachinery.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> updateChcFmbMachinery(@PathVariable Integer id,
                                                                 @RequestPart(value = "type_id", required = false) Integer typeId,
                                                                 @RequestPart(value = "name_id", required = false) Integer nameId,
                                                                 @RequestPart(value = "chc_fmb_id", required = false) Integer chcFmbId,
                                                                 @RequestPart(value = "capacity", required = false) Integer capacity,
                                                                 @RequestPart(value = "purchase_year", required = false) Calendar year,
                                                                 @RequestPart(value = "quantity", required = false) Integer quantity,
                                                                 @RequestPart(value = "company", required = false) String company,
                                                                 @RequestPart(value = "govt_scheme", required = false) String govtScheme,
                                                                 @RequestPart(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside ChcFmbMachinery updating ChcFmbMachinery detail ");
        ChcFmbMachinery chcFmbMachinery = new ChcFmbMachinery(typeId, nameId, chcFmbId, capacity, year, quantity, company, govtScheme);
        ResponseEntity<MessageResponse> resp = null;
        String fileContentType = file.getContentType();
        if (contentTypes.contains(fileContentType)){
            try {
                machineryService.updateChcFmbMachinery(id, chcFmbMachinery, file);
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("ChcFmbMachinery Details Updated Successfully!"), HttpStatus.OK );
                LOG.info("ChcFmbMachinery Updated Successfully!");
            } catch (Exception e) {
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Update the ChcFmbMachinery Details"), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed to Update the ChcFmbMachinery Details");
                e.printStackTrace();
            }
        }
        LOG.info("Exiting ChcFmbMachinery Of Controller with response ", resp);
        return resp;
    }

    @GetMapping("/download/{fileName:.+}")
    @ApiOperation(value="ChcFmbMachinerys Download" ,code=201, produces = "application/json", notes="Api for Download ChcFmbMachinery File", response= UploadFileResponse.class)
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
