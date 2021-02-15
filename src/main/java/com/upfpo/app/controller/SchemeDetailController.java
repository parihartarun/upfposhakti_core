package com.upfpo.app.controller;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.UploadFileResponse;
import com.upfpo.app.entity.SchemeDetail;

import com.upfpo.app.service.SchemeDetailService;

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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(value = "/schemes")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "SchemeDetail Details", tags="SchemeDetail Controller",description="Scheme Details")
public class SchemeDetailController {

    private static final Logger LOG = LoggerFactory.getLogger(SchemeDetailController.class);

    @Autowired
    private SchemeDetailService schemeDetailService;

    @GetMapping
    @ApiOperation(value="SchemeDetail List" ,code=201, produces = "application/json", notes="Api for all SchemeDetail Info",response= SchemeDetail.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<SchemeDetail> getAllSchemeDetail (){
        return schemeDetailService.getAllSchemeDetail();
    }

    @GetMapping("/{type}")
    @ApiOperation(value="SchemeDetail List" ,code=201, produces = "application/json", notes="Api for all SchemeDetail Info",response= SchemeDetail.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<SchemeDetail> getBySchemeType (@PathVariable String type){
        return schemeDetailService.getSchemeByType(type);
    }


    @PostMapping
    @ApiOperation(value="Create SchemeDetail" ,code=201, produces = "application/json", notes="Api for all create SchemeDetail",response= SchemeDetail.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> createSchemeDetail(@RequestParam("description") String description,
                                                              @RequestParam("title") String schemeType,
                                                           @RequestParam("parent_department") String parentDepartment,
                                                              @RequestParam("url") String url,
                                                           @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside SchemeDetailController saving SchemeDetail ");
        ResponseEntity<MessageResponse> resp = null;
        try {
            SchemeDetail schemeDetails = new SchemeDetail(description,schemeType,parentDepartment,url);
            SchemeDetail id = schemeDetailService.createSchemeDetail(schemeDetails, file);
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("SchemeDetail created successfully"), HttpStatus.OK );
            LOG.info("SchemeDetail  created Successfully!");
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("SchemeDetail creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the SchemeDetail");
            e.printStackTrace();
        }
        LOG.info("Exiting SchemeDetail Of Controller with response ", resp);
        return resp;
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation(value="Delete SchemeDetail",code=204,produces = "text/plain",notes="Api for delete SchemeDetail by id",response=Boolean.class)
    @ApiResponses(value= {
            @ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
            @ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
            @ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
            @ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
    })
    public ResponseEntity<MessageResponse> deleteSchemeDetail(@PathVariable Integer id) {
        LOG.info("Inside SchemeDetailController delete sales details ");
        ResponseEntity<MessageResponse> resp = null;
        try {
            if(schemeDetailService.deleteSchemeDetail(id)==true)
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("SchemeDetail Deleted Successfully!"), HttpStatus.OK );
            LOG.info("SchemeDetail Deleted Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Delete the SchemeDetail"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Delete the SchemeDetail");
            e.printStackTrace();
        }
        LOG.info("Exiting SchemeDetail Of Controller with response ", resp);
        return resp;
    }


    @GetMapping("/download/{fileName:.+}")
    @ApiOperation(value="SchemeDetail Download" ,code=201, produces = "application/json", notes="Api for Download SchemeDetail File", response= UploadFileResponse.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = schemeDetailService.loadFileAsResource(fileName);

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
    @ApiOperation(value="Update SchemeDetail Details" ,code=201, produces = "application/json", notes="Api To Update SchemeDetail Details",response= SchemeDetail.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> updateSchemeDetail(@PathVariable Integer id,
                                                           @RequestPart(value = "description") String description,
                                                           @RequestPart(value ="title") String schemeType,
                                                              @RequestParam("url") String url,
                                                              @RequestPart("parent_department") String parentDepartment,
                                                           @RequestPart(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside SchemeDetail updating SchemeDetail detail ");
        SchemeDetail schemeDetails = new SchemeDetail(description);
        schemeDetails.setId(id);
        schemeDetails.setDescription(description);
        schemeDetails.setSchemeType(schemeType);
        schemeDetails.setParentDepartment(parentDepartment);
        schemeDetails.setUrl(url);
        ResponseEntity<MessageResponse> resp = null;
        try {
            schemeDetailService.updateSchemeDetail(id, schemeDetails, file);
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("SchemeDetail Details Updated Successfully!"), HttpStatus.OK );
            LOG.info("SchemeDetail Updated Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Update the SchemeDetail Details"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Update the SchemeDetail Details");
            e.printStackTrace();
        }
        LOG.info("Exiting SchemeDetail Of Controller with response ", resp);
        return resp;
    }




}




