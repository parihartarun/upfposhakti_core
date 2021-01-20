package com.upfpo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.upfpo.app.repository.UserRepository;
import com.upfpo.app.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

}