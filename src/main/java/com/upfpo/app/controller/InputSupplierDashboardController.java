
package com.upfpo.app.controller;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.*;
import com.upfpo.app.entity.InputSupplierFertilizer;
import com.upfpo.app.entity.InputSupplierInsecticide;
import com.upfpo.app.entity.InputSupplierMachinery;
import com.upfpo.app.entity.InputSupplierSeed;
import com.upfpo.app.repository.InputSupplierMasterRepository;
import com.upfpo.app.service.InputSupplierDashboardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/InputSupplier/dashboard")
@Api(produces = "application/json", value = "Update,Delete, and retrive the Input Supplier", tags="Input Supplier Dashboard",description="Input Supplier Dashboard")
public class InputSupplierDashboardController {


    @Autowired
    private InputSupplierDashboardService dashboardService;




    @GetMapping("/inputsupplier/{id}")
    @ApiOperation(value="Input Supplier Contect Detail" ,code=201, produces = "application/json", notes="Api for all InputSupplier Contect Info",response= InputSupplierDTO.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public InputSupplierDTO getInputSupplierDetail (@PathVariable Integer id){
        return dashboardService.getInputSupplierDetails(id);
    }



    @GetMapping("/fertilizer/{id}")
    @ApiOperation(value="InputSupplierFertilizers List" ,code=201, produces = "application/json", notes="Api for all InputSupplierFertilizers Info",response= InputSupplierFertilizer.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<InputSupplierFertilizerDTO> getAllInputSupplierFertilizers (@PathVariable Integer id){
        return dashboardService.getAllInputSupplierFertilizer(id);
    }

    @GetMapping("/seed/{id}")
    @ApiOperation(value="InputSupplierSeeds List" ,code=201, produces = "application/json", notes="Api for all InputSupplierSeeds Info",response= InputSupplierSeed.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<InputSupplierSeedDTO> getAllInputSupplierSeeds (@PathVariable Integer id){
        return dashboardService.getAllInputSupplierSeed(id);
    }

    @GetMapping("/machinery/{id}")
    @ApiOperation(value="InputSupplierMachinerys List" ,code=201, produces = "application/json", notes="Api for all InputSupplierMachinerys Info",response= InputSupplierMachinery.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<InputSupplierMachineryDTO> getAllInputSupplierMachinerys (@PathVariable Integer id){
        return dashboardService.getAllInputSupplierMachinery(id);
    }


    @GetMapping("/insecticide/{id}")
    @ApiOperation(value="InputSupplierInsecticides List" ,code=201, produces = "application/json", notes="Api for all InputSupplierInsecticides Info",response= InputSupplierInsecticide.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<InputSupplierInsecticideDTO> getAllInputSupplierInsecticides (@PathVariable Integer id){
        return dashboardService.getAllInputSupplierInsecticide(id);
    }

}
