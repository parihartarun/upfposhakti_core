package com.upfpo.app.controller;


import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/notification")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "Notification Details", tags="Notification Controller",description="Notification Details")
public class NotificationController {

    private static final Logger LOG = LoggerFactory.getLogger(NotificationController.class);

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



    /*@PostMapping
    @ApiOperation(value="Create Notification" ,code=201, produces = "application/json", notes="Api for all create Notification")
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> createNotification(@RequestBody Notification notification) {
        LOG.info("Inside NotificationController saving Notification ", notification);
        ResponseEntity<String> resp = null;
        try {
            Notification id = notificationService.createNotification(notification);
            resp = new ResponseEntity<String>("Notification created Successfully!", HttpStatus.OK );
            LOG.info("Notification  created Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Save the Notification", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the Notification");
            e.printStackTrace();
        }
        LOG.info("Existing Notification Of Controller with response ", resp);
        return resp;
    }


    @PutMapping("{id}")
    @ApiOperation(value="Notification Update" ,code=201, produces = "application/json", notes="Api for all Update Notification Info")
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> updateNotification(@PathVariable Integer id, @RequestBody Notification notifications) {
        LOG.info("Inside NotificationController updating sales details ", notifications);
        ResponseEntity<String> resp = null;
        try {
            Notification fsd = notificationService.updateNotification(id, notifications);
            resp = new ResponseEntity<String>("Notification Updated Successfully!", HttpStatus.OK );
            LOG.info("Notification Updated Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Update the Notification", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Update the Notification");
            e.printStackTrace();
        }
        LOG.info("Exiting Notification Of Controller with response ", resp);
        return resp;
    }


    @DeleteMapping("{id}")
    @ApiOperation(value="Delete Notification" ,code=201, produces = "application/json", notes="Api for all Notification Deletion")
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> deleteNotification(@PathVariable Integer id) {
        LOG.info("Inside NotificationController delete sales details ");
        ResponseEntity<String> resp = null;
        try {
            notificationService.deleteNotification(id);
            resp = new ResponseEntity<String>("Notification Deleted Successfully!", HttpStatus.OK );
            LOG.info("Notification Deleted Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Delete the Notification", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Delete the Notification");
            e.printStackTrace();
        }
        LOG.info("Exiting Notification Of Controller with response ", resp);
        return resp;
    }*/

    @PostMapping("/fposend")
    @ApiOperation(value="Create Notification" ,code=201, produces = "application/json", notes="Api for all create Notification",response= Notification.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> sendNotificationToFPO(@RequestParam("message") String message,
                                                                 @RequestParam("dept_id") String departmentId,
                                                                 @RequestParam("role") String role,
                                                           @RequestParam("fpo_id") String fpoId,
                                                           @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside NotificationController saving Notification ");
        ResponseEntity<MessageResponse> resp = null;
        try {

            Notification notification = new Notification(role, message, departmentId,  fpoId);
            Notification id = notificationService.sendNotification(notification, file);
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Notification sent To FPO successfully"), HttpStatus.OK );
            LOG.info("Notification  created Successfully!");
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Notification creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the Notification");
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
    public ResponseEntity<MessageResponse> sendNotificationToFarmer(@RequestParam("message") String message,
                                                                 @RequestParam("role") String role,
                                                                 @RequestParam("farmer_id") String farmerId,
                                                                 @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside NotificationController saving Notification ");
        ResponseEntity<MessageResponse> resp = null;
        try {

            Notification notification = new Notification(role, message, farmerId);
            Notification id = notificationService.sendNotification(notification, file);
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Notification sent To Farmer successfully"), HttpStatus.OK );
            LOG.info("Notification  created Successfully!");
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Notification creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the Notification");
            e.printStackTrace();
        }
        LOG.info("Exiting Notification Of Controller with response ", resp);
        return resp;
    }



    @GetMapping("/fponotification/{id}")
    @ApiOperation(value="Notification List For FPO" ,code=201, produces = "application/json", notes="Api for all Notification Info To FPO")
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<Notification> getNotificationByFPOID (@PathVariable String id){

        return notificationService.getAllNotificationByDepartment(id);
    }

    @GetMapping("/farmernotification/{id}")
    @ApiOperation(value="Notification List To Farmer" ,code=201, produces = "application/json", notes="Api for all Notification Info To Farmer")
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<Notification> getAllNotificationByFarmerId (@PathVariable String id){

        return notificationService.getAllNotificationByFPO(id);
    }

}

