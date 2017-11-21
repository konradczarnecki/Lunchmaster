package com.lunchmaster.api.lunch.service;

import com.lunchmaster.api.Response;
import com.lunchmaster.api.lunch.dto.Lunch;
import com.lunchmaster.api.lunch.dto.Order;

import java.util.List;

/**
 * Created by m.slefarski on 2017-09-25.
 */
public interface LunchService {

     /* LUNCH */
     List<Lunch> fetchLunches();

     Response<Lunch> saveLunch(Lunch lunch);

     Response<String> deleteLunch(int lunchId);

     Lunch fetchLunch(int id);

     /* ORDER */
     Response<Order> saveOrder(Order order);

     Response<String> deleteOrder(int orderId);

     Order fetchOrder(int id);

     List<Order> fetchOrderByLunchId(int lunchId);




}
