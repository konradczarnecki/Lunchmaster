package com.lunchmaster.api.login.controller;

import com.lunchmaster.api.Response;
import com.lunchmaster.api.login.dto.User;
import com.lunchmaster.api.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/user")
public class LoginController {

    private LoginService service;

    @Autowired
    public LoginController(LoginService service){
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Response<String> login(@RequestBody User loggedUser, HttpSession session) {

        boolean authorized = service.authorize(loggedUser);

        Response<String> rsp = new Response<>();

        if(authorized){

            User usr = service.getUserByEmail(loggedUser.getEmail());
            session.setAttribute("user", usr);
            rsp.setStatus("success");
            rsp.setContent("tokenStub");

        } else {

            rsp.setStatus("failed");
        }

        return rsp;
    }
}
