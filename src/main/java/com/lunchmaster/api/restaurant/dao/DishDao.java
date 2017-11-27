package com.lunchmaster.api.restaurant.dao;

import com.lunchmaster.api.restaurant.dto.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DishDao extends JpaRepository<Dish, Integer> {

    @Transactional
    void deleteById(int Id);

    @Transactional
    void deleteByRestaurantId(int restaurantId);

    @Transactional
    Dish save(Dish dish);

    @Transactional(readOnly = true)
    Dish getById(int id);

    @Transactional(readOnly = true)
    List<Dish> getByRestaurantId(int restaurantId);

}
