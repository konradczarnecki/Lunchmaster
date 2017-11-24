package com.lunchmaster.api.lunch.service.impl;

import com.lunchmaster.api.Response;
import com.lunchmaster.api.lunch.dto.LunchStatus;
import com.lunchmaster.api.lunch.dao.LunchDao;
import com.lunchmaster.api.lunch.dao.OrderDao;
import com.lunchmaster.api.lunch.dto.Lunch;
import com.lunchmaster.api.lunch.dto.Order;
import com.lunchmaster.api.lunch.service.LunchService;
import com.lunchmaster.api.restaurant.dao.RestaurantDao;
import com.lunchmaster.api.restaurant.dto.Restaurant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

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


    /* LUNCH */
    /* Get all lunches */
    @Override
    public List<Lunch> fetchLunches() {
        return lunchDao.findAll();
    }

    /* Fetch lunch by id */
    @Override
    public Lunch fetchLunch(int id) {
        return this.lunchDao.getById(id);
    }

    /**
     * save lunch - allow saving only new lunches.
     * Editing properties can be achieved only through specified api calls.
     * This approach secures unwanted changes
     */
    @Override
    public Response<Lunch> saveNewLunch(Lunch lunch) {
        Response<Lunch> resp = new Response<>();
        resp.setContent(lunch);
        //new lunch
        if (lunch.getId() == 0) {
            //save
            try {
                //ensure correct values to avoid api exploitation
                lunch.setStatus(LunchStatus.OPEN.name());
                lunch.getOrders().clear();
                lunch = this.lunchDao.save(lunch);
                resp.saveSuccess(Lunch.class, lunch.getId());
            } catch (Exception exc) {
                //error during save
                resp.saveError(Lunch.class, lunch.getId(), exc);
            }
            return resp;
        }
        //existing lunch - return error
        resp.saveLunchErrorLunchExists(lunch.getId());
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

    /* LUNCH PROPERTIES UPDATE */
    @Override
    public Response<String> changeLunchStatus(int lunchId, String status) {
        Response<String> resp = new Response<>();
        Lunch lunch = fetchLunch(lunchId);
        //if lunch exist in DB
        if (lunch != null) {
            //if status change is allowed
            if (lunch.changeState(LunchStatus.valueOf(status))) {
                //if user CLOSED lunch prematurely - change deadline!
                if (lunch.isClosed()) {
                    lunch.setDeadline(new Date());
                }
                this.lunchDao.save(lunch);
                resp.updateLunchStatusSuccess(lunchId, status);
                return resp;
            }
            //forbidden status change
            else {
                resp.updateLunchStatusError(lunchId, status, true);
                return resp;
            }
        }
        //lunch not int DB
        resp.updateLunchStatusError(lunchId, status, false);
        return resp;
    }

    @Override
    public Response<String> changeLunchDeadline(int lunchId, Date deadline) {
        Response<String> resp = new Response<>();
        Lunch lunch = this.fetchLunch(lunchId);
        long now = new Date().getTime();

        //if lunch exist in DB
        if (lunch != null) {
            //deadline is older than now
            if (deadline.getTime() <= now) {
                resp.updateLunchDeadlineError(lunchId, deadline, true);
            }
            //deadline is correct
            else {
                lunch.setDeadline(deadline);
                this.lunchDao.save(lunch);
                resp.updateLunchDeadlineSuccess(lunchId, deadline);
            }
            return resp;
        }
        //lunch not in DB
        resp.updateLunchDeadlineError(lunchId, deadline, false);
        return resp;
    }


    /* ORDER */
    /* Save new order or update existing */
    @Override
    public Response<Order> saveOrder(Order order) {
        Response<Order> resp = new Response<>();
        resp.setContent(order);
        //check if we are before deadline. Status change can be late, soe we can only be
        //sure by comparing time.
        if (this.lunchDao.getById(order.getLunchId()).getDeadline().getTime() < new Date().getTime()) {
            try {
                order = this.orderDao.save(order);
                resp.saveSuccess(Order.class, order.getId());
            } catch (Exception exc) {
                resp.saveError(Order.class, order.getId(), exc);
            }
            return resp;
        }
        resp.saveOrderErrorLunchIsNotOpen(order.getId(), order.getLunchId());
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

