package com.upfpo.app.configuration.exception.handlers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.configuration.exception.ValidationException;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.FPORegister;

import io.swagger.annotations.ApiOperation;

@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

	@Order(Ordered.HIGHEST_PRECEDENCE)
	@ControllerAdvice
	public class validationAdvice{

	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ResponseBody
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
	        BindingResult result = ex.getBindingResult();

	        List<FieldError> fieldErrors = result.getFieldErrors();
//            JsonObject jsonResponse = new JsonObject();

	        String errorMessage = fieldErrors.get(0).getDefaultMessage();
	        return ResponseEntity.badRequest().body(errorMessage);
	    }

	}
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException exception, WebRequest webRequest) {
//        ExceptionResponse response = new ExceptionResponse();
//        response.setDateTime(LocalDateTime.now());
//        response.setMessage(exception.getMessage());
//        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
//        return entity;
//    }
	
	
//	@Override
//	   protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//	                 HttpHeaders headers, HttpStatus status, WebRequest request){
//		
//		  ExceptionResponse response = new ExceptionResponse();
//        response.setDateTime(LocalDateTime.now());
//        response.setMessage("Validation Error = "+ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
//        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
//        return this.handleExceptionInternal(ex, response, headers, HttpStatus.BAD_REQUEST, request);
//		
//	}
	
}
