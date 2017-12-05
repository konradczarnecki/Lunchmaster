package com.lunchmaster.api.registration.controller;

import com.lunchmaster.api.registration.dto.RegistrationDto;
import com.lunchmaster.utils.exception.RequestBodyNotValidException;
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
@RequestMapping("/api/registration")
public class RegistrationController {

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerUser(@RequestBody @Valid RegistrationDto registrationDto,
                                          BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            throw new RequestBodyNotValidException(bindingResult.getAllErrors());
        }

        ResponseEntity<RegistrationDto> response = new ResponseEntity<>(registrationDto, HttpStatus.OK);
        return response;
    }
}
