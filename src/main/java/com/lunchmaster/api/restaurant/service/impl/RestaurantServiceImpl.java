package com.lunchmaster.api.restaurant.service.impl;

import com.lunchmaster.api.Response;
import com.lunchmaster.api.lunch.dto.Lunch;
import com.lunchmaster.api.lunch.dto.Order;
import com.lunchmaster.api.restaurant.dao.DishDao;
import com.lunchmaster.api.restaurant.dao.RestaurantDao;
import com.lunchmaster.api.restaurant.dto.Dish;
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
@SuppressWarnings("unchecked")
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantDao restaurantDao;

    @Autowired
    private DishDao dishDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantService.class);

    /* RESTAURANT */
    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantDao.findAll();
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        return this.restaurantDao.getById(id);
    }

    @Override
    public Response<Restaurant> saveRestaurant(Restaurant restaurant) {
        Response<Restaurant> resp = new Response<>(restaurant);
        //create
        if (restaurant.getId() == 0) {
            restaurant.getDishes().clear();
        }
        //update
        else{
            //ensure dishes are not changed
            Restaurant r = this.getRestaurantById(restaurant.getId());
            restaurant.setDishes(r.getDishes());
        }
        try {
            restaurant = this.restaurantDao.save(restaurant);
            return resp.success();
        } catch (Exception exc) {
            return resp.error();
        }

    }

    @Override
    public Response<String> deleteRestaurantById(int id) {
        Response<String> resp = new Response<>();
        Restaurant restaurant = this.restaurantDao.getById(id);
        //not found
        if (restaurant == null) {
            return resp.error();
            //found
        } else {
            try {
                this.dishDao.deleteByRestaurantId(id);
                this.restaurantDao.deleteById(id);
                return resp.success();
            } catch (Exception exc) {
                return resp.error();
            }
        }
    }

    /* DISH */
    @Override
    public Dish getDishById(int id) {
        return this.dishDao.getById(id);
    }

    @Override
    public List<Dish> getDishesByRestaurantId(int restaurantId) {
        return this.dishDao.getByRestaurantId(restaurantId);
    }

    @Override
    public Response<Dish> saveDish(Dish dish) {
        Response<Dish> resp = new Response<>(dish);
        //update
        if (dish.getId() != 0) {
            //if update - ensure restaurant is not changed
            Dish d = this.dishDao.getById(dish.getId());
            if (d == null) {
                return resp.error();
            }
            dish.setRestaurantId(d.getRestaurantId());
        }
        try {
            dish = this.dishDao.save(dish);
            return resp.success();
        } catch (Exception exc) {
            return resp.error();
        }
    }

    @Override
    public Response<String> deleteDishById(int id) {
        Response<String> resp = new Response<>();
        Dish dish = dishDao.getById(id);
        //id not in database
        if (dish == null) {
            return resp.error();
        }
        //dish found
        else {
            try {
                this.dishDao.deleteById(id);
                return resp.success();
            } catch (Exception exc) {
                //error during delete
                return resp.error();
            }

        }
    }


}
