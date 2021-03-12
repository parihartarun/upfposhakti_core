package com.upfpo.app.controller;


import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.service.OtpService;
import com.upfpo.app.service.ResetPasswordService;
import com.upfpo.app.service.ResetPasswordServiceImpl;
import com.upfpo.app.util.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/forgot-password")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "Reset Password", tags="Forgot Password Controller",description="Api to reset password")
public class ForgotPasswordController {


    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public OtpService otpService;

    @Autowired
    public ResetPasswordService passwordService;


    @PutMapping("/verifyUser/{username}")
    @ApiOperation(value="Register new Farmer profile" ,code=201, produces = "application/json", notes="Api for add new Farmer",response=String.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public Object verifyUser(@PathVariable String username){
        return passwordService.resetPasswordByUserName(username);
    }

    @GetMapping("/generateOtp")
    public Integer generateOtp(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        int otp = otpService.generateOTP(username);
        LOG.info("OTP : "+otp);
        /*Map<String,String> replacements = new HashMap<String,String>();
        replacements.put("user", username);
        replacements.put("otpnum", String.valueOf(otp));
        String message = template.getTemplate(replacements); */
        return otp;
    }


    /*@PutMapping("/verifyUser")
    @ApiOperation(value="Register new Farmer profile" ,code=201, produces = "application/json", notes="Api for add new Farmer",response=String.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<ResponseMessage> changePassword(@PathVariable String username, @RequestParam String newPassword){

        return null;

    }*/

    @GetMapping(value ="/validateOtp")
    public @ResponseBody String validateOtp(@RequestParam("otpnum") int otpnum) {

        final String SUCCESS = "Entered Otp is valid";
        final String FAIL = "Entered Otp is NOT valid. Please Retry!";

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        LOG.info(" Otp Number : " + otpnum);

        if (otpnum >= 0) {
            //int serverOtp = otpService.getOtp(username);
            int serverOtp = 1111;
            if (serverOtp > 0) {
                if (otpnum == serverOtp) {
                    otpService.clearOTP(username);
                    return ("Entered Otp is valid");
                } else {
                    return SUCCESS;
                }
            } else {
                return FAIL;
            }
        } else {
            return FAIL;
        }
    }
}
