package com.lunchmaster.api.order.service;

import com.lunchmaster.api.order.dto.Order;
import com.lunchmaster.api.Response;

public interface OrderService {

    Response<Order> saveOrder(Order order);
    Response<String> deleteOrder(int orderId);
    Order fetchOrder(int id);
}
