package com.lunchmaster.api.restaurant.controller;

import com.lunchmaster.api.restaurant.dto.Restaurant;
import com.lunchmaster.api.restaurant.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by m.slefarski on 2017-09-28.
 */
@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantController.class);

    private RestaurantService service;

    @Autowired
    public RestaurantController(RestaurantService restaurantServiceImpl){
        this.service=restaurantServiceImpl;
    }

    @GetMapping("/list")
    public List<Restaurant> getAllRestaurants(){
        return service.getAllRestaurants();
    }
}
