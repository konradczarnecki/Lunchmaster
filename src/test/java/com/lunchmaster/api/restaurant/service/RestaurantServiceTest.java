package com.lunchmaster.api.restaurant.service;

/**
 * Created by m.slefarski on 2017-10-18.
 */

import com.lunchmaster.api.restaurant.dao.RestaurantDao;
import com.lunchmaster.api.restaurant.dto.Restaurant;
import com.lunchmaster.api.restaurant.service.impl.RestaurantServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class RestaurantServiceTest {

    @TestConfiguration
    static class RestaurantServiceImpl_TestConfiguration {

        @Bean
        public RestaurantService restaurantService() {
            return new RestaurantServiceImpl();
        }
    }

    @Autowired
    private RestaurantService restaurantService;

    @MockBean
    private RestaurantDao dao;



    @Before
    public void setup(){

        Restaurant restaurant = new Restaurant();
        restaurant.setName("TEST");
        restaurant.setId(0);

        List<Restaurant> restaurants = Collections.singletonList(restaurant);
        Mockito.when(dao.findAll()).thenReturn(restaurants);
    }

    @Test
    public void whenGetAllRestaurants_thenRestaurantShouldBeFound(){

        List<Restaurant> restaurants = restaurantService.getAllRestaurants();

        //returned array shoud be the same and not changed
        assertThat(restaurants.size()).isEqualTo(1);
        assertThat(restaurants.get(0).getId()).isEqualTo(0);
        assertThat(restaurants.get(0).getName()).isEqualTo("TEST");

    }

}
