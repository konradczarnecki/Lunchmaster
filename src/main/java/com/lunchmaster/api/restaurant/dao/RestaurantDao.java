package com.lunchmaster.api.restaurant.dao;

import com.lunchmaster.api.restaurant.dto.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by m.slefarski on 2017-09-28.
 */
public interface RestaurantDao extends JpaRepository<Restaurant, Integer> {

    @Transactional(readOnly = true)
    List<Restaurant> findAll();

    @Transactional(readOnly = true)
    Restaurant getById(int id);

    @Transactional
    Restaurant save(Restaurant restaurant);

    @Transactional
    void deleteById(int id);

}
