package com.upfpo.app.controller;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.UploadFileResponse;
import com.upfpo.app.entity.PhotoUpload;
import com.upfpo.app.entity.PhotoUpload;
import com.upfpo.app.service.PhotoUploadService;
import com.upfpo.app.service.PhotoUploadService;
import com.upfpo.app.service.PhotoUploadServiceImpl;
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
import reactor.util.annotation.Nullable;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(value = "/photo")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "Upload Photo", tags="Photo Upload Controller",description="Upload Photo")
public class PhotoUploadController {
    
    @Autowired
    private PhotoUploadService photoUploadService;

    private static final Logger LOG = LoggerFactory.getLogger(PhotoUploadController.class);

    

    @GetMapping
    @ApiOperation(value="PhotoUpload List" ,code=201, produces = "application/json", notes="Api for all PhotoUpload Info",response= PhotoUpload.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<PhotoUpload> getAllPhotoUpload (){
        return photoUploadService.getAllPhotoUpload();
    }

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

        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Save the Photo"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the Photo");
            e.printStackTrace();
        }
        LOG.info("Exiting Photo Of Controller with response ", resp);
        return resp;
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation(value="Delete PhotoUpload",code=204,produces = "text/plain",notes="Api for delete PhotoUpload by id",response=Boolean.class)
    @ApiResponses(value= {
            @ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
            @ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
            @ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
            @ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
    })
    public ResponseEntity<MessageResponse> deletePhotoUpload(@PathVariable Integer id) {
        LOG.info("Inside PhotoUploadController delete sales details ");
        ResponseEntity<MessageResponse> resp = null;
        try {
            if(photoUploadService.deletePhotoUpload(id)==true)
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("PhotoUpload Deleted Successfully!"), HttpStatus.OK );
            LOG.info("PhotoUpload Deleted Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Delete the PhotoUpload"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Delete the PhotoUpload");
            e.printStackTrace();
        }
        LOG.info("Exiting PhotoUpload Of Controller with response ", resp);
        return resp;
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    @ApiOperation(value="PhotoUpload Download" ,code=201, produces = "application/json", notes="Api for Download PhotoUpload File", response= UploadFileResponse.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = photoUploadService.loadFileAsResource(fileName);

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
    @ApiOperation(value="Update PhotoUpload Details" ,code=201, produces = "application/json", notes="Api To Update PhotoUpload Details",response= PhotoUpload.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> updatePhotoUpload(@PathVariable Integer id,
                                                           @RequestPart(value = "description") String description,
                                                           @RequestPart(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside PhotoUpload updating PhotoUpload detail ");
        PhotoUpload photoUploads = new PhotoUpload();
        photoUploads.setId(id);
        photoUploads.setDescription(description);


        ResponseEntity<MessageResponse> resp = null;
        try {
            LOG.info("test");
            photoUploadService.updatePhotoUpload(id, photoUploads,  file);
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("PhotoUpload Details Updated Successfully!"), HttpStatus.OK );
            LOG.info("PhotoUpload Updated Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Update the PhotoUpload Details"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Update the PhotoUpload Details");
            e.printStackTrace();
        }
        LOG.info("Exiting PhotoUpload Of Controller with response ", resp);
        return resp;
    }
}
