package com.upfpo.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.UploadFileResponse;
import com.upfpo.app.entity.Circulars;
import com.upfpo.app.service.CircularsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@RestController
@RequestMapping(value = "/circulars")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "Circulars Details", tags="Circulars Controller",description="Circulars Details")
public class CircularsController {

    private static final Logger LOG = LoggerFactory.getLogger(CircularsController.class);

    @Autowired
    CircularsServiceImpl circularsService;

    @PostMapping("/insert")
    @ApiOperation(value="Create Circular" ,code=201, produces = "application/json", notes="Api for all create Circular",response= Circulars.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> uploadCircular(@RequestParam("model") String model, @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside CircularsController saving Circulars ");
        ResponseEntity<String> resp = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            Circulars circulars = mapper.readValue(model, Circulars.class);
            Circulars id = circularsService.createCircular(circulars, file);
            resp = new ResponseEntity<String>("Circular created Successfully!", HttpStatus.OK );
            LOG.info("Circular created Successfully!");
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(fileName)
                    .toUriString();
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Save the Circular", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the Circular");
            e.printStackTrace();
        }
        LOG.info("Exiting Circular Of Controller with response ", resp);
        return resp;
    }


    @GetMapping("/downloadFile/{fileName:.+}")
    @ApiOperation(value="Circularss Download" ,code=201, produces = "application/json", notes="Api for Download Circulars File", response= UploadFileResponse.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = circularsService.loadFileAsResource(fileName);

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
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            circularsService.save(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<Circulars>> getListFiles() {
        List<Circulars> circulars = circularsService.loadAll().map(path -> {
            //String filename = path.getFileName().toString();
            String filePath = MvcUriComponentsBuilder
                    .fromMethodName(CircularsController.class, "getFile", path.getFileName().toString()).build().toString();

            return new Circulars();
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(circulars);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = circularsService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }*/
}
