package com.lunchmaster.api.login.controller;

import com.lunchmaster.api.Response;
import com.lunchmaster.api.login.dto.User;
import com.lunchmaster.api.login.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    private LoginService service;

    @Autowired
    public LoginController(LoginService service){
        this.service = service;
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public Response<User> login(@RequestBody User loggedUser, HttpSession session) {

        boolean authorized = service.authorize(loggedUser);

        Response<User> rsp = new Response<>();

        if(authorized){

            User usr = service.getUserByEmail(loggedUser.getEmail());
            session.setAttribute("user", usr);
            rsp.setStatus("success");
            rsp.setContent(usr);

        } else {

            rsp.setStatus("failed");
        }

        return rsp;
    }
}
