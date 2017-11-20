package com.lunchmaster.api.order.service.impl;

import com.lunchmaster.api.order.dao.OrderDao;
import com.lunchmaster.api.order.dto.Order;
import com.lunchmaster.api.order.service.OrderService;
import com.lunchmaster.api.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public Response<Order> saveOrder(Order order) {
        Response<Order> resp = new Response<>();

        try {
            order = this.orderDao.save(order);
            resp.setContent(order);

        } catch (Exception exc) {
            resp.setStatus(Response.FAILURE);
            resp.setDetails("Error during saving order with id="+order.getId());
            return resp;
        }
        resp.setStatus(Response.SUCCESS);
        resp.setDetails("Order " + order.getId() + " was saved in database.");
        return resp;
    }

    @Override
    public Response<String> deleteOrder(int orderId) {

        Response<String> resp = new Response<>();
        Order order = orderDao.getById(orderId);

        //order not in database
        if (order == null) {
            resp.setStatus("error");
            resp.setDetails("Cannot delete. Order with id=" + orderId + " not found.");
        }
        //order found and deleted
        else {
            try {
                this.orderDao.deleteById(orderId);
            } catch (Exception exc) {
                resp.setStatus(Response.FAILURE);
                resp.setDetails("Order with id=" + orderId + " was found, but there was an error during deletion.");
                return resp;
            }
            resp.setStatus(Response.SUCCESS);
            resp.setDetails("Order with id=" + orderId + " is deleted.");
        }

        return resp;
    }

    @Override
    public Order fetchOrder(int id) {
        return this.orderDao.getById(id);
    }


    @Autowired
    OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
