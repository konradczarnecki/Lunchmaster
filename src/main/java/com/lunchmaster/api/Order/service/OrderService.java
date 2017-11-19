package com.lunchmaster.api.Order.service;

import com.lunchmaster.api.Order.dto.Order;
import com.lunchmaster.api.Response;

public interface OrderService {

    Response<Order> saveOrder(Order order);
    Response<String> deleteOrder(int orderId);
    Order fetchOrder(int id);
}
