package com.lunchmaster.api.lunch.dao;

import com.lunchmaster.api.lunch.dto.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


public interface OrderDao extends JpaRepository<Order, Integer> {


    @Transactional
    Order save(Order order);

    @Transactional(readOnly = true)
    Order getById(int id);

    @Transactional(readOnly = true)
    List<Order> getByLunchId(int lunchId);

    @Transactional
    void deleteById(int id);

    @Transactional
    void deleteByLunchId(int lunchId);


}
