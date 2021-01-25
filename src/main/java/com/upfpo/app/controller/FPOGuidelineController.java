package com.upfpo.app.controller;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.FPOGuidelines;
import com.upfpo.app.service.FPOGuidelineServiceImpl;

import com.upfpo.app.util.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.swing.plaf.UIResource;
import java.util.List;

@RestController
@RequestMapping(value="/fpoguidelines")
@Api(produces = "application/json", tags="FPOGuidelines", value = "Add, Update, Delete, and retrive the FPOGuidelines")
public class FPOGuidelineController {


    private static final Logger LOG = LoggerFactory.getLogger(FPOGuidelineController.class);

    @Autowired
    private FPOGuidelineServiceImpl fpoGuidelineService;

    @GetMapping("/getall")
    @ApiOperation(value="Fetch All FPO FPOGuidelines" ,code=201, produces = "application/json", notes="API to Get all FPO FPOGuidelines",response= FPOGuidelines.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<FPOGuidelines> getFPOGuidelines (){

        return fpoGuidelineService.getAllFPOGuidelines();
    }



    @GetMapping("/{id}")
    @ApiOperation(value="Fetch FPOGuidelines By ID" ,code=201, produces = "application/json", notes="Api to FPO FPOGuideliness By ID",response=FPOGuidelines.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public FPOGuidelines getFPOGuidelinesById(@PathVariable Long id) {

        return fpoGuidelineService.getFPOGuidelinesByID(id);
    }


    @PostMapping("/insert")
    @ApiOperation(value="Add FPO FPOGuidelines" ,code=201, produces = "application/json", notes="Api for add new FPO FPOGuidelines",response= FPOGuidelines.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> insertFPOGuidelines(@RequestBody FPOGuidelines fpoGuidelines) {
        LOG.info("Inside FPOGuidelinesController saving FPOGuidelines ", fpoGuidelines);
        ResponseEntity<String> resp = null;
        try {
            FPOGuidelines id = fpoGuidelineService.createFPOGuidelines(fpoGuidelines);
            resp = new ResponseEntity<String>("FPOGuidelines created Successfully!", HttpStatus.OK );
            LOG.info("FPOGuidelines  created Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Save the FPOGuidelines", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the FPOGuidelines");
            e.printStackTrace();
        }
        LOG.info("Exiting FPOGuidelines Of Controller with response ", resp);
        return resp;
    }


    @PutMapping("/update1/{id}")
    @ApiOperation(value="Update FPO FPOGuidelines" ,code=201, produces = "application/json", notes="Api To Update FPO FPOGuidelines",response=FPOGuidelines.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> updateFPOGuidelines(@PathVariable Long id, @RequestBody FPOGuidelines fpoGuidelines) {
        LOG.info("Inside FPOGuidelinesController updating FPOGuidelines ", fpoGuidelines);
        ResponseEntity<String> resp = null;
        try {
            FPOGuidelines fsd = fpoGuidelineService.updateFPOGuidelines(id, fpoGuidelines);
            resp = new ResponseEntity<String>("FPOGuidelines Updated Successfully!", HttpStatus.OK );
            LOG.info("FPOGuidelines Updated Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Update the FPOGuidelines", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Update the FPOGuidelines");
            e.printStackTrace();
        }
        LOG.info("Exiting FPOGuidelines Of Controller with response ", resp);
        return resp;
    }


    @DeleteMapping("/delete1/{id}")
    @ApiOperation(value="Delete FPO FPOGuidelines" ,code=201, produces = "application/json", notes="Api To Delete FPO FPOGuidelines",response=FPOGuidelines.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> deleteFPOGuidelines1(@PathVariable Long id) {
        LOG.info("Inside FPOGuidelinesController delete FPOGuidelines ");
        ResponseEntity<String> resp = null;
        try {
            fpoGuidelineService.deleteFPOGuidelines(id);
            resp = new ResponseEntity<String>("FPOGuidelines Deleted Successfully!", HttpStatus.OK );
            LOG.info("FPOGuidelines Deleted Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Delete the FPOGuidelines", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Delete the FPOGuidelines");
            e.printStackTrace();
        }
        LOG.info("Exiting FPOGuidelines Of Controller with response ", resp);
        return resp;
    }

    @PostMapping("/upload")
    @ApiOperation(value="Upload FPOGuidelines" ,code=201, produces = "application/json", notes="Api To Upload FPOGuidelines",response=FPOGuidelines.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            fpoGuidelineService.save(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/download/{filename:.+}")
    @ApiOperation(value="Download FPOGuidelines" ,code=201, produces = "application/json", notes="Api To Download FPOGuidelines",response=FPOGuidelines.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    @ResponseBody
    public ResponseEntity<UrlResource> getFile(@PathVariable String filename) {
        UrlResource file = fpoGuidelineService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
    
}
