package com.upfpo.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/api/cropproduction")
@Api(produces = "application/json", value = "Add, Update, Delete, and retrive the FPO Crop Production", tags="Agency",description="Add, Update, Delete, and retrive the FPO Crop Production.")
public class FPOCropProductionController {
	

}
