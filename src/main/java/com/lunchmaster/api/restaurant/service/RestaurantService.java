package com.lunchmaster.api.restaurant.service;

import com.lunchmaster.api.restaurant.dto.Restaurant;

import java.util.List;

/**
 * Created by m.slefarski on 2017-09-28.
 */
public interface RestaurantService {

    public List<Restaurant> getAllRestaurants();
}
