package com.upfpo.app.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.UploadFileResponse;
import com.upfpo.app.entity.ComplaintCatgories;
import com.upfpo.app.entity.Complaints;

import com.upfpo.app.service.ComplaintServiceImpl;

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
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/complaint")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "Complaint Details", tags="Complaint Controller",description="Complaint Details")
public class ComplaintContoller {

    private static final Logger LOG = LoggerFactory.getLogger(ComplaintContoller.class);

    @Autowired
    private ComplaintServiceImpl complaintService;

    @GetMapping
    @ApiOperation(value="Complaints List" ,code=201, produces = "application/json", notes="Api for all Complaints Info",response= Complaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<Complaints> getAllComplaints (){

        return complaintService.getAllComplaint();
    }

    @PostMapping
    @ApiOperation(value="Create Complaint" ,code=201, produces = "application/json", notes="Api for all create Complaint",response= Complaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> createComplaint(@RequestParam("description") String description, @RequestParam("title") String title,
                                                  @RequestParam("issue_type") String issueType, @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside ComplaintController saving Complaint ");
        ResponseEntity<MessageResponse> resp = null;
        try {

            Complaints complaints = new Complaints(description, title, issueType);

            Complaints id = complaintService.createComplaint(complaints, file);
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Complaint created successfully"), HttpStatus.OK );
            LOG.info("Complaint  created Successfully!");
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(fileName)
                    .toUriString();
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Complaint creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the Complaint");
            e.printStackTrace();
        }
        LOG.info("Exiting Complaint Of Controller with response ", resp);
        return resp;
    }


    @PutMapping("/{id}")
    @ApiOperation(value="Complaints Update" ,code=201, produces = "application/json", notes="Api for all Update Complaints Info",response= Complaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> updateComplaint(@PathVariable Integer id, @RequestBody Complaints complaints) {
        LOG.info("Inside ComplaintController updating sales details ", complaints);
        ResponseEntity<String> resp = null;
        try {
            Complaints fsd = complaintService.updateComplaintDetail(id, complaints);
            resp = new ResponseEntity<String>("Complaint Updated Successfully!", HttpStatus.OK );
            LOG.info("Complaint Updated Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Update the Complaint", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Update the Complaint");
            e.printStackTrace();
        }
        LOG.info("Exiting Complaint Of Controller with response ", resp);
        return resp;
    }


    @DeleteMapping(value="/{id}")
    @ApiOperation(value="Delete Complaint",code=204,produces = "text/plain",notes="Api for delete Complaint by id",response=Boolean.class)
    @ApiResponses(value= {
            @ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
            @ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
            @ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
            @ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
    })
    public ResponseEntity<MessageResponse> deleteComplaint(@PathVariable Integer id) {
        LOG.info("Inside ComplaintController delete sales details ");
        ResponseEntity<MessageResponse> resp = null;
        try {
            if(complaintService.deleteComplaint(id)==true)
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Complaint Deleted Successfully!"), HttpStatus.OK );
            LOG.info("Complaint Deleted Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Delete the Complaint"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Delete the Complaint");
            e.printStackTrace();
        }
        LOG.info("Exiting Complaint Of Controller with response ", resp);
        return resp;
    }

    @GetMapping("/catgories")
    @ApiOperation(value="Complaint Catgories" ,code=201, produces = "application/json", notes="Api to get Complaints Catgories",response= ComplaintCatgories.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<ComplaintCatgories> getComplaintCatgories() {

        return complaintService.getComplaintsCatgories();

    }


    /*@PostMapping("/upload")
    @ApiOperation(value="Complaint Upload" ,code=201, produces = "application/json", notes="Api for all Upload Complaints File", response= UploadFileResponse.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = complaintService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    @ApiOperation(value="Complaints File List" ,code=201, produces = "application/json", notes="Api for all All Complaints Files List", response= UploadFileResponse.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }*/

    @GetMapping("/downloadFile/{fileName:.+}")
    @ApiOperation(value="Complaints Download" ,code=201, produces = "application/json", notes="Api for Download Complaint File", response= UploadFileResponse.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = complaintService.loadFileAsResource(fileName);

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


    /*@PostMapping("/upload")
    @ApiOperation(value="Complaint Upload" ,code=201, produces = "application/json", notes="Api for all Upload Complaints File",response= Complaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            complaintService.save(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files")
    @ApiOperation(value="Complaints File List" ,code=201, produces = "application/json", notes="Api for all All Complaints Files List",response= Complaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<List<Circulars>> getListFiles() {
        List<Circulars> circulars = complaintService.loadAll().map(path -> {
            //String filename = path.getFileName().toString();
            String filePath = MvcUriComponentsBuilder
                    .fromMethodName(CircularsController.class, "getFile", path.getFileName().toString()).build().toString();

            return new Circulars();
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(circulars);
    }

    @GetMapping("/files/{filename:.+}")
    @ApiOperation(value="Complaints Download" ,code=201, produces = "application/json", notes="Api for Download Complaint File",response= Complaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = complaintService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }*/
}



