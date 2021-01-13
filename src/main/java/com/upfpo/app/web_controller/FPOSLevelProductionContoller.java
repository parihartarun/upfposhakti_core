package com.upfpo.app.web_controller;

import com.upfpo.app.entity.FPOLevelProduction;
import com.upfpo.app.entity.FPOSalesDetails;
import com.upfpo.app.service.FPOLevelProductionService;
import com.upfpo.app.service.FPOSalesDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/fpolevelproduction")
public class FPOSLevelProductionContoller {

    @Autowired
    private FPOLevelProductionService levelProductionService;

    @GetMapping("/getall")
    public List<FPOLevelProduction> getAllLevelProduction (){

        return levelProductionService.getAllLevelProduction();
    }

    @GetMapping("/{id}")
    public Optional<FPOLevelProduction> getSalesDetailsById(@PathVariable Integer id) {

        return levelProductionService.getLevelProductionById(id);
    }

    @PostMapping("/insert")
    public FPOLevelProduction insertSalesDetails(@RequestBody FPOLevelProduction fpoLevelProduction){

        return levelProductionService.addLevelProduction(fpoLevelProduction);
    }

    @PutMapping("/update/{id}")
    public FPOLevelProduction updateSalesDetails(@PathVariable Integer id,@RequestBody FPOLevelProduction fpoLevelProduction){
        return levelProductionService.updateLevelProduction(id, fpoLevelProduction);
    }

    @DeleteMapping("/delete/{id}")
    public Optional<FPOLevelProduction> deleteSalesDetails(@PathVariable Integer id){
        return levelProductionService.deleteLevelProduction(id);
    }

}
