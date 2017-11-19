package com.lunchmaster.api.Order.dao;

import com.lunchmaster.api.Order.dto.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


public interface OrderDao extends JpaRepository<Order, Integer> {


    @Transactional
    Order save(Order order);

    @Transactional(readOnly = true)
    Order getById(int id);

    @Transactional
    void deleteById(int id);

}
