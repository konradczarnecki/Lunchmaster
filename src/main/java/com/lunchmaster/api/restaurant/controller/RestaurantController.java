package com.lunchmaster.api.restaurant.controller;

import com.lunchmaster.api.restaurant.dto.Restaurant;
import com.lunchmaster.api.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by m.slefarski on 2017-09-28.
 */
@Controller
@ResponseBody
@RequestMapping("/api/restaurant")
public class RestaurantController {


    private RestaurantService restaurantServiceImpl;

    @GetMapping("/list")
    @CrossOrigin("http://localhost:4200")
    public List<Restaurant> getAllRestaurants(){
        return restaurantServiceImpl.getAllRestaurants();
    }

    @Autowired
    public RestaurantController(RestaurantService restaurantServiceImpl){
        this.restaurantServiceImpl=restaurantServiceImpl;
    }
}
