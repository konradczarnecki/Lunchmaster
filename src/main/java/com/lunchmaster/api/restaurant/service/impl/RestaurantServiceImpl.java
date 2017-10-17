package com.lunchmaster.api.restaurant.service.impl;

import com.lunchmaster.api.restaurant.dao.RestaurantDao;
import com.lunchmaster.api.restaurant.dto.Restaurant;
import com.lunchmaster.api.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by m.slefarski on 2017-09-28.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {


    private RestaurantDao restaurantDao;

    public List<Restaurant> getAllRestaurants() {
        return restaurantDao.findAll();
    }

    @Autowired
    public RestaurantServiceImpl(RestaurantDao restaurantDao){
        this.restaurantDao=restaurantDao;
    }


}
