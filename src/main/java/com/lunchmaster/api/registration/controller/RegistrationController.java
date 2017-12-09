package com.lunchmaster.api.registration.controller;

import com.lunchmaster.api.login.dto.User;
import com.lunchmaster.api.registration.dto.RegistrationDto;
import com.lunchmaster.api.registration.service.RegistrationService;
import com.lunchmaster.utils.exception.RequestBodyNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> registerUser(@RequestBody @Valid RegistrationDto dto,
                                          BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            throw new RequestBodyNotValidException(bindingResult.getAllErrors());
        }

        User registeredUser = registrationService.saveRegisteredUser(dto);

        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }
}
