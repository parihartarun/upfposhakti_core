package com.upfpo.app.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.MalformedURLException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException{


        private static final long serialVersionUID = 1L;

        public ResourceNotFoundException(String msg) {

            super(msg);
        }

    public ResourceNotFoundException(String s, MalformedURLException ex) {

    }
    }
