package com.lunchmaster.api.lunch.controller;

import com.lunchmaster.api.lunch.dto.Lunch;
import com.lunchmaster.api.lunch.service.LunchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by m.slefarski on 2017-09-25.
 */

@RestController
@RequestMapping("/api/lunch")
public class LunchController {


    private LunchService lunchServiceImpl;
    private static final Logger LOGGER = LoggerFactory.getLogger(LunchController.class);

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @CrossOrigin("http://localhost:4200")
    public List<Lunch> getLunches(){
        return lunchServiceImpl.getLunches();
    }

    @Autowired
    public LunchController(LunchService lunchServiceImpl){
        this.lunchServiceImpl=lunchServiceImpl;
    }

}
