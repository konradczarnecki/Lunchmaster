package com.lunchmaster.api.restaurant.controller;

import com.lunchmaster.api.Response;
import com.lunchmaster.api.restaurant.dto.Dish;
import com.lunchmaster.api.restaurant.dto.Restaurant;
import com.lunchmaster.api.restaurant.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by m.slefarski on 2017-09-28.
 */
@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantController.class);

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantServiceImpl){
        this.restaurantService =restaurantServiceImpl;
    }

    /* RESTAURANT */

    /* List all restaurants */
    @GetMapping(value = "/list", produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    /* Fetch restaurant by it */
    @GetMapping(value = "/fetch", produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Restaurant getRestaurantById(@RequestParam("id") int id){
        return this.restaurantService.getRestaurantById(id);
    }

    /* Save new restaurant or update existing */
    @PutMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant){
        return this.restaurantService.saveRestaurant(restaurant);
    }

    /* Delete restaurant by Id */
    @DeleteMapping(value = "/delete", produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<String> deleteRestaurantById(@RequestParam("id") int id){
        return this.restaurantService.deleteRestaurantById(id);
    }


    /* DISH */
    /* Fetch dish by id */
    @GetMapping(value = "/dish/fetch", produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Dish getDishById(@RequestParam("id") int id){
        return this.restaurantService.getDishById(id);
    }

    /* Save new dish or update existing */
    @PutMapping(value = "/dish/save", consumes = "application/json", produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<Dish> saveDish(@RequestBody Dish dish){
        return this.restaurantService.saveDish(dish);
    }

    /* Delete dish by Id */
    @DeleteMapping(value = "/dish/delete", produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<String> deleteDishById(@RequestParam("id") int id){
        return this.restaurantService.deleteDishById(id);
    }




}
