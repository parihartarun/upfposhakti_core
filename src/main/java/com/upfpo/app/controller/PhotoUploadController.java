package com.upfpo.app.controller;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.PhotoUpload;
import com.upfpo.app.service.PhotoUploadService;
import com.upfpo.app.service.PhotoUploadServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(value = "/photo")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "Upload Photo", tags="Photo Upload Controller",description="Upload Photo")
public class PhotoUploadController {
    
    @Autowired
    private PhotoUploadService photoUploadService;

    private static final Logger LOG = LoggerFactory.getLogger(PhotoUploadController.class);

    @PostMapping
    @ApiOperation(value="Create Photo" ,code=201, produces = "application/json", notes="Api for all Upload Photo",response= PhotoUpload.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> uploadPhoto(@RequestParam("description") String description,
                                                          @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside PhotosController saving Photos ");
        ResponseEntity<MessageResponse> resp = null;
        try {
            PhotoUpload photo = new PhotoUpload(description);
            PhotoUpload id = photoUploadService.uploadPhoto(photo, file);
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Photo uploaded Successfully!"), HttpStatus.OK );
            LOG.info("Photo uploaded Successfully!");
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(fileName)
                    .toUriString();
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Save the Photo"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the Photo");
            e.printStackTrace();
        }
        LOG.info("Exiting Photo Of Controller with response ", resp);
        return resp;
    }
}
