package com.lunchmaster.api.restaurant.service.impl;

import com.lunchmaster.api.restaurant.dao.RestaurantDao;
import com.lunchmaster.api.restaurant.dto.Restaurant;
import com.lunchmaster.api.restaurant.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by m.slefarski on 2017-09-28.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantDao restaurantDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantService.class);

    public List<Restaurant> getAllRestaurants() {
        return restaurantDao.findAll();
    }




}
