package com.upfpo.app.controller;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.FPOLevelProduction;

import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.FPOSalesDetails;
import com.upfpo.app.service.FPOLevelProductionService;
import com.upfpo.app.service.FPOSalesDetailsServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping(value = "/fpolevelproduction")
public class FPOSLevelProductionContoller {

    @Autowired
    private FPOLevelProductionService levelProductionService;

    @GetMapping("/getall")
    @ApiOperation(value="Fetch All FPO Level Production" ,code=201, produces = "application/json", notes="API to Get all FPO Level Production",response= FPORegister.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<FPOLevelProduction> getAllLevelProduction (){

        return levelProductionService.getAllLevelProduction();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="Fetch FPO Level Production By ID" ,code=201, produces = "application/json", notes="Api to Fetch FPO Level Production By ID",response=FPORegister.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public Optional<FPOLevelProduction> getLevelProductionById(@PathVariable Integer id) {

        return levelProductionService.getLevelProductionById(id);
    }

    @PostMapping("/insert")
    @ApiOperation(value="Add FPO Level Production" ,code=201, produces = "application/json", notes="Api for add new FPO Level Production",response= FPORegister.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public FPOLevelProduction insertLevelProduction(@RequestBody FPOLevelProduction fpoLevelProduction){

        return levelProductionService.addLevelProduction(fpoLevelProduction);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value="Update FPO Level Production" ,code=201, produces = "application/json", notes="Api To Update FPO Level Production",response=FPORegister.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public FPOLevelProduction updateLevelProduction(@PathVariable Integer id,@RequestBody FPOLevelProduction fpoLevelProduction){
        return levelProductionService.updateLevelProduction(id, fpoLevelProduction);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value="Delete FPO Level Production" ,code=201, produces = "application/json", notes="Api To Delete FPO Level Production",response=FPORegister.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public Optional<FPOLevelProduction> deleteLevelProduction(@PathVariable Integer id){
        return levelProductionService.deleteLevelProduction(id);
    }

}
