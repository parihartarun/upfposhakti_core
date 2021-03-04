package com.upfpo.app.controller;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.WarehouseDTO;
import com.upfpo.app.entity.Warehouse;

import com.upfpo.app.entity.WarehouseFacilities;
import com.upfpo.app.service.WarehouseServiceImpl;
import com.upfpo.app.service.WarehouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/warehouse")
@Api(produces = "application/json", tags="Warehouse Controller", value = "Add, Update, Delete, and retrive the Warehouse Detail")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    private static final Logger LOG = LoggerFactory.getLogger(WarehouseController.class);

    private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg","image/jpg", "image/gif");

    private HttpServletRequest request;


    @GetMapping("/getall")
    @ApiOperation(value="Warehouses List" ,code=201, produces = "application/json", notes="Api for all Warehouses Info",response= Warehouse.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<WarehouseDTO> getAllWarehouses (){
        return warehouseService.getAllWarehouse();
    }

    @GetMapping("/facilities/getall")
    @ApiOperation(value="Warehouses Facilities List" ,code=201, produces = "application/json", notes="Api for all Warehouses Facilities Info",response= WarehouseFacilities.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<WarehouseFacilities> getAllFacilities (){
        return warehouseService.getAllFacilities();
    }



    @PostMapping
    @ApiOperation(value="Create Warehouse" ,code=201, produces = "application/json", notes="Api for all create Warehouse",response= Warehouse.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> createWarehouse(@RequestParam(value = "type", required = false) String typeName,
                                                           @RequestParam(value = "dept_id", required = false) Integer deptId,
                                                           @RequestParam(value = "facilities", required = false) List<WarehouseFacilities> facilities,
                                                                   @RequestParam(value = "capacity", required = false) Double capacity,
                                                                   @RequestParam(value = "seed_processing", required = false) String isSeedProcessing,
                                                                   @RequestParam(value = "district_id", required = false) Integer districtId,
                                                                   @RequestParam(value = "block_id", required = false)Integer blockId,
                                                                   @RequestParam(value = "address", required = false)String address,
                                                                   @RequestParam(value = "longitude", required = false) String longitude,
                                                                   @RequestParam(value = "latitude", required = false) String latitude)  {
        LOG.info("Inside WarehouseController saving Warehouse ");
        ResponseEntity<MessageResponse> resp = null;
        try {
            Warehouse warehouse = new Warehouse(typeName, deptId, facilities, capacity, isSeedProcessing, districtId, blockId, address, longitude, latitude);
            warehouseService.createWarehouse(warehouse);
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Warehouse created successfully"), HttpStatus.OK );
            LOG.info("Warehouse  created Successfully!");
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Warehouse creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the Warehouse");
            e.printStackTrace();
        }
        LOG.info("Exiting Warehouse Of Controller with response ", resp);
        return resp;
    }


    @DeleteMapping(value="/{id}")
    @ApiOperation(value="Delete Warehouse",code=204,produces = "text/plain",notes="Api for delete Warehouse by id",response=Boolean.class)
    @ApiResponses(value= {
            @ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
            @ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
            @ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
            @ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
    })
    public ResponseEntity<MessageResponse> deleteWarehouse(@PathVariable Integer id) {
        LOG.info("Inside WarehouseController delete sales details ");
        ResponseEntity<MessageResponse> resp = null;
        try {
            if(warehouseService.deleteWarehouse(id)==true)
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("Warehouse Deleted Successfully!"), HttpStatus.OK );
            LOG.info("Warehouse Deleted Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Delete the Warehouse"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Delete the Warehouse");
            e.printStackTrace();
        }
        LOG.info("Exiting Warehouse Of Controller with response ", resp);
        return resp;
    }




    @PutMapping("/{id}")
    @ApiOperation(value="Update Warehouse Details" ,code=201, produces = "application/json", notes="Api To Update Warehouse Details",response= Warehouse.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> updateWarehouse(@PathVariable Integer id,
                                                           @RequestParam(value = "type", required = false) String typeName,
                                                           @RequestParam(value = "dept_id", required = false) Integer deptId,
                                                           @RequestParam(value = "facilities", required = false) List<WarehouseFacilities> facilities,
                                                           @RequestParam(value = "capacity", required = false) Double capacity,
                                                           @RequestParam(value = "seed_processing", required = false) String isSeedProcessing,
                                                           @RequestParam(value = "district_id", required = false) Integer districtId,
                                                           @RequestParam(value = "block_id", required = false)Integer blockId,
                                                           @RequestParam(value = "address", required = false)String address,
                                                           @RequestParam(value = "longitude", required = false) String longitude,
                                                           @RequestParam(value = "latitude", required = false) String latitude) {
        LOG.info("Inside Warehouse updating Warehouse detail ");
        Warehouse warehouse = new Warehouse(typeName, deptId, facilities, capacity, isSeedProcessing, districtId, blockId, address, longitude, latitude);

        ResponseEntity<MessageResponse> resp = null;
        try {
            warehouseService.updateWarehouse(id, warehouse);
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Warehouse Details Updated Successfully!"), HttpStatus.OK );
            LOG.info("Warehouse Updated Successfully!");
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Update the Warehouse Details"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Update the Warehouse Details");
            e.printStackTrace();
        }

        LOG.info("Exiting Warehouse Of Controller with response ", resp);
        return resp;
    }



}
