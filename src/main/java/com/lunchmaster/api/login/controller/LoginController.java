package com.lunchmaster.api.login.controller;

import com.lunchmaster.api.login.dto.User;
import com.lunchmaster.api.login.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    private LoginService service;

    @Autowired
    public LoginController(LoginService service){
        this.service = service;
    }

    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping(value = "/me")
    public ResponseEntity<?> showUser(Principal principal){

        User authenticatedUser = service.getUserByEmail(principal.getName());

        if(authenticatedUser == null){
            return new ResponseEntity<>("Are You authenticated ?", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
        }
    }
}
