package com.lunchmaster.api.restaurant.dao;

import com.lunchmaster.api.restaurant.dto.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by m.slefarski on 2017-09-28.
 */
public interface RestaurantDao extends JpaRepository<Restaurant, Integer> {
    List<Restaurant> findAll();
}
