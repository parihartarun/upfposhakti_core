package com.upfpo.app.controller;


import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.UploadFileResponse;
import com.upfpo.app.entity.FPOGuidelineType;
import com.upfpo.app.entity.Notification;
import com.upfpo.app.entity.Notification;
import com.upfpo.app.entity.Notification;
import com.upfpo.app.service.NotificationServiceImpl;
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
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/notification")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "Notification Details", tags="Notification Controller",description="Notification Details")
public class NotificationController {

    private static final Logger LOG = LoggerFactory.getLogger(NotificationController.class);

    private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg", "image/jpg", "image/gif",
            "image/PNG", "image/JPEG", "image/JPG", "image/GIF", "multipart/form-data");


    @Autowired
    private NotificationServiceImpl notificationService;

    @GetMapping
    @ApiOperation(value="Notification List" ,code=201, produces = "application/json", notes="Api for all Notification Info")
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<Notification> getAllNotification (){

        return notificationService.getAllNotification();
    }


    @GetMapping("/fponotification/{id}/{read}")
    @ApiOperation(value="Notification List For FPO" ,code=201, produces = "application/json", notes="Api for all Notification Info To FPO")
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<Notification> getNotificationByFPOID (@PathVariable String id, @PathVariable Boolean read){

        return notificationService.getAllNotificationByDepartment(id, read);
    }

    @GetMapping("/fponotification/{id}")
    @ApiOperation(value="Notification List For FPO" ,code=201, produces = "application/json", notes="Api for all Notification To FPO read unread both")
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<Notification> getAllNotificationByFPOID (@PathVariable String id){

        return notificationService.getAllNotificationByDepartmentById(id);
    }


    @GetMapping("/farmernotification/{id}/{read}")
    @ApiOperation(value="Notification List To Farmer" ,code=201, produces = "application/json", notes="Api for all Notification Info To Farmer")
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<Notification> getAllNotificationByFarmerId (@PathVariable String id, @PathVariable Boolean read){

        return notificationService.getAllNotificationByFPOByID(id, read);
    }

    @GetMapping("/farmernotification/{id}")
    @ApiOperation(value="Notification List To Farmer" ,code=201, produces = "application/json", notes="Api for all read/unread Notification Info To Farmer")
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<Notification> getBothNotificationByFarmerId (@PathVariable String id){

        return notificationService.getAllNotificationByFPO(id);
    }


    @GetMapping("/viewdeptnotification/{id}")
    @ApiOperation(value="Notification List For FPO" ,code=201, produces = "application/json", notes="Api for all Notification Info To FPO")
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<Notification> viewAllNotificationOfDepartment (@PathVariable String id){

        return notificationService.viewAllNotificationOfDepartment(id);
    }


    @GetMapping("/viewfponotification/{id}")
    @ApiOperation(value="Notification List To Farmer" ,code=201, produces = "application/json", notes="Api for all Notification Info To Farmer")
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<Notification> viewAllNotificationofFPO (@PathVariable String id){

        return notificationService.viewAllNotificationofFPO(id);
    }


    @PostMapping("/fposend")
    @ApiOperation(value="Create Notification" ,code=201, produces = "application/json", notes="Api for all create Notification",response= Notification.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> sendNotificationToFPO(@RequestParam(value = "message", required = false) String message,
                                                                 @RequestParam(value = "dept_id", required = false) String departmentId,
                                                                 @RequestParam(value = "role", required = false) String role,
                                                           @RequestParam(value = "fpo_id", required = false) String fpoId,
                                                           @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside NotificationController saving Notification ");
        ResponseEntity<MessageResponse> resp = null;

            try {
                Notification notification = new Notification(role, message, departmentId,  fpoId);
                Notification id = notificationService.sendNotification(notification, file);
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("Notification Sent To FPO Successfully"), HttpStatus.OK );
                LOG.info("Notification  Created Successfully!");
            } catch (Exception e) {
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("Notification creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed To Save The Notification");
                e.printStackTrace();
            }


        LOG.info("Exiting Notification Of Controller with response ", resp);
        return resp;
    }



    @PostMapping("/farmersend")
    @ApiOperation(value="Create Notification" ,code=201, produces = "application/json", notes="Api for all create Notification",response= Notification.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> sendNotificationToFarmer(@RequestParam(value = "message", required = false) String message,
                                                                 @RequestParam(value = "role", required = false) String role,
                                                                 @RequestParam(value = "farmer_id", required = false) String farmerId,
                                                                 @RequestParam(value = "fpo_id", required = false)String fpoId,
                                                                 @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside NotificationController saving Notification ");
        ResponseEntity<MessageResponse> resp = null;
        String fileContentType = file.getContentType();
        if (contentTypes.contains(fileContentType)){
            try {
                Notification notification = new Notification(role, message, farmerId);
                notification.setFarmerFpoId(fpoId);
                Notification id = notificationService.sendNotification(notification, file);
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("Notification Sent To Farmer Successfully"), HttpStatus.OK );
                LOG.info("Notification  created Successfully!");
            } catch (Exception e) {
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("Notification creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed to Save the Notification");
                e.printStackTrace();
            }
        }
        else{
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Incorrect file type, PDF or Image required."), HttpStatus.BAD_REQUEST);
            throw new IllegalArgumentException("Incorrect file type, Photo required.");
        }
        LOG.info("Exiting Notification Of Controller with response ", resp);
        return resp;
    }



    @PutMapping("/{id}")
    @ApiOperation(value="Update Notification Read Status" ,code=201, produces = "application/json", notes="Api To Update Notification Details",response= Notification.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> updateNotification(@PathVariable Integer id) {
        LOG.info("Inside Notification updating Notification detail ");
        Notification notification = new Notification();
        ResponseEntity<MessageResponse> resp = null;
        try {
            notificationService.notificationIsRead(id);
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Notification Details Updated Successfully!"), HttpStatus.OK );
            LOG.info("Notification Updated Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Update the Notification Details"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Update the Notification Details");
            e.printStackTrace();
        }
        LOG.info("Exiting Notification Of Controller with response ", resp);
        return resp;
    }



    @GetMapping("/download/{fileName:.+}")
    @ApiOperation(value="PhotoUpload Download" ,code=201, produces = "application/json", notes="Api for Download PhotoUpload File", response= UploadFileResponse.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = notificationService.loadFileAsResource(fileName);

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

