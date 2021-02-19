package com.upfpo.app.controller;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.UploadFileResponse;
import com.upfpo.app.entity.FPOGuidelineType;
import com.upfpo.app.entity.FPOGuidelines;
import com.upfpo.app.entity.Language;
import com.upfpo.app.service.FPOGuidelineServiceImpl;

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
import java.util.List;

@RestController
@RequestMapping(value="/fpoguidelines")
@Api(produces = "application/json", tags="FPOGuidelines", value = "Add, Update, Delete, and retrive the FPOGuidelines")
public class FPOGuidelineController {


    private static final Logger LOG = LoggerFactory.getLogger(FPOGuidelineController.class);

    private static final String contentType = new String("application/pdf");

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



    @GetMapping(value="/{type}")
    @ApiOperation(value="Fetch  FPOGuidelines by Type" ,code=201, produces = "application/json", notes="API to Get all FPO FPOGuidelines",response= FPOGuidelines.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<FPOGuidelines> getFPOGuidelineByType (@PathVariable("type") FPOGuidelineType guidelineType){

        return fpoGuidelineService.getFPOGuidelineByType(guidelineType);
    }


    @PostMapping("/uploadFPOGuideline")
    @ApiOperation(value="Create FPO FPOGuidelines" ,code=201, produces = "application/json", notes="API to create new FPO FPOGuidelines",response= FPOGuidelines.class)
    @ApiResponses(value= {
            @ApiResponse(code=400,message = "Bad File" ,response = ExceptionResponse.class),
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> uploadFPOGuideline(@RequestParam("description") String description,
                                                              @RequestParam(value = "hindi_desc", required = false) String hindiDesc,
                                                              @RequestParam("guideline_type") FPOGuidelineType fpoGuidelineType,
                                                              @RequestParam(value = "url", required = false) String url,
                                                              @RequestParam(value = "file", required = false) MultipartFile file,
                                                              @RequestParam(value = "h_file", required = false) MultipartFile hindiFile) {
        LOG.info("Inside FPOGuidelinessController saving FPOGuideliness ");

        ResponseEntity<MessageResponse> resp = null;
        String fileContentType = file.getContentType();
        if (contentType.equals(fileContentType)) {
            try {
                FPOGuidelines fpoGuidelines = new FPOGuidelines(description, fpoGuidelineType, url, hindiDesc);
                FPOGuidelines id = fpoGuidelineService.uploadFPOGuidline(fpoGuidelines, file, hindiFile );
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("FPOGuidelines uploaded Successfully!"), HttpStatus.OK);
            } catch(Exception e){
                resp = new ResponseEntity<MessageResponse>(new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed to Save the FPOGuidelines");
                e.printStackTrace();
            }
        }else{
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Incorrect file type, PDF required."), HttpStatus.INTERNAL_SERVER_ERROR);
            throw new IllegalArgumentException("Incorrect file type, PDF required.");
        }
        LOG.info("Exiting FPOGuidelines Of Controller with response ", resp);
        return resp;
    }


    @GetMapping("/download/{fileName:.+}")
    @ApiOperation(value="FPOGuidelines Download" ,code=201, produces = "application/json", notes="Api for Download FPOGuidelines File", response= UploadFileResponse.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<org.springframework.core.io.Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fpoGuidelineService.loadFileAsResource(fileName);

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

    @PutMapping("/{id}")
    @ApiOperation(value="Update FPOGuidelines Details" ,code=201, produces = "application/json", notes="Api To Update FPOGuidelines Details",response= FPOGuidelines.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> updateFPOGuidelines(@PathVariable Integer id,
                                                               @RequestPart("description") String description,
                                                               @RequestParam("guideline_type") FPOGuidelineType fpoGuidelineType,
                                                               @RequestParam(value = "url", required = false) String url,
                                                               @RequestPart(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside FPOGuidelines updating FPOGuidelines detail ");
        FPOGuidelines fpoGuidelines = new FPOGuidelines();
        fpoGuidelines.setId(id);
        fpoGuidelines.setDescription(description);
        fpoGuidelines.setFpoGuidelineType(fpoGuidelineType);
        fpoGuidelines.setUrl(url);
        ResponseEntity<MessageResponse> resp = null;
        try {
            LOG.info("test");
            fpoGuidelineService.updateFPOGuidelines(id, fpoGuidelines, file);
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("FPOGuidelines Details Updated Successfully!"), HttpStatus.OK );
            LOG.info("FPOGuidelines Updated Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Update the FPOGuidelines Details"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Update the FPOGuidelines Details");
            e.printStackTrace();
        }
        LOG.info("Exiting FPOGuidelines Of Controller with response ", resp);
        return resp;
    }


    @DeleteMapping(value="/{id}")
    @ApiOperation(value="Delete FPOGuidelines",code=204,produces = "text/plain",notes="Api for delete FPOGuidelines by id",response=Boolean.class)
    @ApiResponses(value= {
            @ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
            @ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
            @ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
            @ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
    })
    public ResponseEntity<MessageResponse> deleteFPOGuidelines(@PathVariable Long id) {
        LOG.info("Inside FPOGuidelinesController delete sales details ");
        ResponseEntity<MessageResponse> resp = null;
        try {
            if(fpoGuidelineService.deleteFPOGuidelines(id)==true)
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("FPOGuidelines Deleted Successfully!"), HttpStatus.OK );
            LOG.info("FPOGuidelines Deleted Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Delete the FPOGuidelines"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Delete the FPOGuidelines");
            e.printStackTrace();
        }
        LOG.info("Exiting FPOGuidelines Of Controller with response ", resp);
        return resp;
    }



}
