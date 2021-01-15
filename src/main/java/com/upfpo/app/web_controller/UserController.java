package com.upfpo.app.web_controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.upfpo.app.entity.User;
import com.upfpo.app.repository.UserRepository;
import com.upfpo.app.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

}