package com.lunchmaster.api.lunch.service;

import com.lunchmaster.api.Response;
import com.lunchmaster.api.lunch.dto.Lunch;
import com.lunchmaster.api.lunch.dto.Order;

import java.util.List;
import java.util.Date;

/**
 * Created by m.slefarski on 2017-09-25.
 */
public interface LunchService {

    /* LUNCH */
    Lunch fetchLunch(int id);

    List<Lunch> fetchLunches();

    Response<String> reopenLunch(int lunchId);

    Response<Lunch> saveLunch(Lunch lunch);

    Response<String> deleteLunch(int lunchId);

    Response<String> changeRestaurant(int lunchId, int restaurantId);

    Response<String> closeLunch(int lunchId);

    Response<String> changeDeadline(int lunchId, long deadline);

    Response<String> changeExpectedDelivery(int lunchId, int expectedDelivery);



    /* ORDER */
    Response<Order> saveOrder(Order order);

    Response<String> deleteOrder(int orderId);

    Order fetchOrder(int id);

    List<Order> fetchOrderByLunchId(int lunchId);

}
