package com.lunchmaster.api.lunch.service.impl;

import com.lunchmaster.api.Response;
import com.lunchmaster.api.lunch.dao.LunchDao;
import com.lunchmaster.api.lunch.dao.OrderDao;
import com.lunchmaster.api.lunch.dto.Lunch;
import com.lunchmaster.api.lunch.dto.Order;
import com.lunchmaster.api.lunch.service.LunchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by m.slefarski on 2017-09-25.
 */
@Service
public class LunchServiceImpl implements LunchService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LunchServiceImpl.class);

    private LunchDao lunchDao;

    private OrderDao orderDao;

    @Autowired
    public LunchServiceImpl(LunchDao lunchDao, OrderDao orderDao) {
        this.lunchDao = lunchDao;
        this.orderDao = orderDao;
    }

    public LunchServiceImpl() {
    }


    /* Get all lunches */
    @Override
    public List<Lunch> fetchLunches() {
        return lunchDao.findAll();
    }

    /* Get lunch by id */
    @Override
    public Lunch fetchLunch(int id) {
        return this.lunchDao.getById(id);
    }

    /* save lunch */
    @Override
    public Response<Lunch> saveLunch(Lunch lunch) {
        Response<Lunch> resp = new Response<>();
        resp.setContent(lunch);

        //ensure integrity of orders
        if (lunch.getId() != 0 && !lunch.getOrders().isEmpty()) {
            lunch.setOrders(orderDao.getByLunchId(lunch.getId()));
        }
        //save
        try {
            lunch = this.lunchDao.save(lunch);
            resp.saveSuccess(Lunch.class, lunch.getId());
        } catch (Exception exc) {
            //error during save
            resp.saveError(Lunch.class, lunch.getId(), exc);
        }
        return resp;
    }

    /* Delete lunch by id */
    @Override
    public Response<String> deleteLunch(int lunchId) {
        Response<String> resp = new Response<>();
        Lunch lunch = lunchDao.getById(lunchId);

        if (lunch == null) {
            resp.deleteNotFound(Lunch.class, lunchId);
        }
        //lunch found
        else {
            try {
                this.orderDao.deleteByLunchId(lunchId);
                this.lunchDao.deleteById(lunchId);
                resp.deleteSuccess(Lunch.class, lunchId);
            } catch (Exception exc) {
                //error during delete
                resp.deleteFoundButError(Lunch.class, lunchId, exc);
            }
        }
        return resp;
    }


    @Override
    public Response<Order> saveOrder(Order order) {
        Response<Order> resp = new Response<>();
        resp.setContent(order);
        try {
            order = this.orderDao.save(order);
            resp.saveSuccess(Order.class, order.getId());
        } catch (Exception exc) {
            //error during save
            resp.saveError(Order.class, order.getId(), exc);
        }
        return resp;
    }

    @Override
    public Response<String> deleteOrder(int orderId) {
        Response<String> resp = new Response<>();
        Order order = orderDao.getById(orderId);

        //id not in database
        if (order == null) {
            resp.deleteNotFound(Order.class, orderId);
        }
        //order found
        else {
            try {
                this.orderDao.deleteById(orderId);
                resp.deleteSuccess(Order.class, orderId);
            } catch (Exception exc) {
                resp.deleteFoundButError(Order.class, orderId, exc);
            }
        }
        return resp;
    }

    @Override
    public Order fetchOrder(int id) {
        return this.orderDao.getById(id);
    }

    @Override
    public List<Order> fetchOrderByLunchId(int lunchId) {
        return this.orderDao.getByLunchId(lunchId);
    }
}

