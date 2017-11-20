package com.lunchmaster.api.lunch.controller;

import com.lunchmaster.api.lunch.dto.Lunch;
import com.lunchmaster.api.lunch.service.LunchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by m.slefarski on 2017-09-25.
 */

@RestController
@RequestMapping("/api/lunch")
public class LunchController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LunchController.class);

    private LunchService service;

    @Autowired
    public LunchController(LunchService lunchServiceImpl) {
        this.service = lunchServiceImpl;
    }


    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Lunch> getLunches() {
        return service.getLunches();
    }

}
