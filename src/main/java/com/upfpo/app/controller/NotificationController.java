package com.upfpo.app.controller;


import com.upfpo.app.auth.response.JwtResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/notification")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "Notification Details", tags="Notification Controller",description="Notification Details")
public class NotificationController {

    private static final Logger LOG = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    private NotificationServiceImpl notificationService;

    @GetMapping("/getall")
    @ApiOperation(value="Notification List" ,code=201, produces = "application/json", notes="Api for all Notification Info",response= JwtResponse.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<Notification> getAllNotification (){

        return notificationService.getAllNotification();
    }



    @PostMapping("/insert")
    @ApiOperation(value="Create Notification" ,code=201, produces = "application/json", notes="Api for all create Notification",response= JwtResponse.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> createNotification(@RequestBody Notification notifications) {
        LOG.info("Inside NotificationController saving Notification ", notifications);
        ResponseEntity<String> resp = null;
        try {
            Notification id = notificationService.createNotification(notifications);
            resp = new ResponseEntity<String>("Notification created Successfully!", HttpStatus.OK );
            LOG.info("Notification  created Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Save the Notification", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the Notification");
            e.printStackTrace();
        }
        LOG.info("Exiting Notification Of Controller with response ", resp);
        return resp;
    }


    @PutMapping("/update1/{id}")
    @ApiOperation(value="Notification Update" ,code=201, produces = "application/json", notes="Api for all Update Notification Info",response= JwtResponse.class)
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


    @DeleteMapping("/delete1/{id}")
    @ApiOperation(value="Delete Notification" ,code=201, produces = "application/json", notes="Api for all Notification Deletion",response= JwtResponse.class)
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
    }


}

