package com.lunchmaster.api.restaurant.service;

import com.lunchmaster.api.Response;
import com.lunchmaster.api.restaurant.dto.Dish;
import com.lunchmaster.api.restaurant.dto.Restaurant;

import java.util.List;

/**
 * Created by m.slefarski on 2017-09-28.
 */
public interface RestaurantService {

    /* RESTAURANT */
   List<Restaurant> getAllRestaurants();

   /* DISH */
   Dish getDishById(int id);

   List<Dish> getDishesByRestaurantId(int restaurantId);

   Response<Dish> saveDish(Dish dish);

   Response<String> deleteDishById(int id);

}
