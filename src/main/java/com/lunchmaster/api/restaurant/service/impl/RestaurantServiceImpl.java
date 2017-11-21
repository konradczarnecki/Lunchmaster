package com.lunchmaster.api.restaurant.service.impl;

import com.lunchmaster.api.Response;
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
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantDao restaurantDao;
    private DishDao dishDao;

    @Autowired
    public RestaurantServiceImpl(RestaurantDao restaurantDao, DishDao dishDao){
        this.restaurantDao=restaurantDao;
        this.dishDao=dishDao;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantService.class);

    /* RESTAURANT */
    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantDao.findAll();
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
        Response<Dish> resp = new Response<>();
        resp.setContent(dish);
        try{
            dish=this.dishDao.save(dish);
            resp.saveSuccess(Dish.class,dish.getId());
        }
        catch (Exception exc){
            resp.saveError(Dish.class, dish.getId(), exc);
        }
        return resp;
    }

    @Override
    public Response<String> deleteDishById(int id) {
        Response<String> resp = new Response<>();
        Dish dish = dishDao.getById(id);

        //id not in database
        if (dish == null) {
            resp.deleteNotFound(Dish.class, id);
        }
        //order found
        else {
            try {
                this.dishDao.deleteById(id);
            } catch (Exception exc) {
                //error during delete
                resp.deleteFoundButError(Dish.class, id, exc);
                return resp;
            }
            //success
            resp.deleteSuccess(Dish.class, id);
        }

        return resp;
    }


}
