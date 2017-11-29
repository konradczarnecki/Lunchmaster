package com.lunchmaster.api.lunch.service.impl;

import com.lunchmaster.api.Response;
import com.lunchmaster.api.lunch.dao.LunchDao;
import com.lunchmaster.api.lunch.dao.OrderDao;
import com.lunchmaster.api.lunch.dto.Lunch;
import com.lunchmaster.api.lunch.dto.LunchStatus;
import com.lunchmaster.api.lunch.dto.Order;
import com.lunchmaster.api.lunch.service.LunchService;
import com.lunchmaster.api.restaurant.dao.RestaurantDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by m.slefarski on 2017-09-25.
 */

@Service
@SuppressWarnings("unchecked")
public class LunchServiceImpl implements LunchService {


    private LunchDao lunchDao;
    private OrderDao orderDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(LunchServiceImpl.class);

    @Autowired
    public LunchServiceImpl(LunchDao lunchDao, OrderDao orderDao, RestaurantDao restaurantDao) {
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

    /* save new lunch */
    @Override
    public Response<Lunch> saveLunch(Lunch lunch) {
        if (lunch.getId() == 0) {
            return createNewLunch(lunch);
        } else {
            return new Response<Lunch>().forbidden();
        }
    }

    /* Delete lunch by id */
    @Override
    public Response<String> deleteLunch(int lunchId) {
        Response<String> resp = new Response<>();
        Lunch lunch = lunchDao.getById(lunchId);
        //lunch not found
        if (lunch == null) {
            return resp.error();
        }
        if (canBeDeleted(lunch)){
            try {
                this.orderDao.deleteByLunchId(lunchId);
                this.lunchDao.deleteById(lunchId);
                return resp.success();
            } catch (Exception exc) {
                //error during delete
                return resp.error();
            }
        }
        return resp.forbidden();
    }

    /* LUNCH PRIVATE METHODS */
    /* create new lunch */
    private Response<Lunch> createNewLunch(Lunch lunch) {
        Response<Lunch> resp = new Response<>(lunch);
        try {
            if (isNewLunchOK(lunch)) {
                lunch = lunchDao.save(lunch);
                return resp.success();
            }
            return resp.forbidden();
        } catch (Exception exc) {
            return resp.error();
        }
    }


    /* ORDER */
    /* Save new order or update existing */
    @Override
    public Response<Order> saveOrder(Order order) {
        Response<Order> resp = new Response<>(order);
        if (isOrderOK(order)) {
            try {
                order = this.orderDao.save(order);
                return resp.success();
            } catch (Exception exc) {
                return resp.error();
            }
        }
        return resp.forbidden();
    }

    @Override
    public Response<String> deleteOrder(int orderId) {
        Response<String> resp = new Response<>();
        Order order = orderDao.getById(orderId);
        //order not found
        if (order == null) {
            return resp.error();
        }
        //order found but after deadline
        else if (!isLunchBeforeDeadline(order.getLunchId())) {
            return resp.forbidden();
        } else {
            //order found and lunch is before deadline
            try {
                this.orderDao.deleteById(orderId);
                return resp.success();
            } catch (Exception exc) {
                return resp.error();
            }
        }
    }

    @Override
    public Order fetchOrder(int id) {
        return this.orderDao.getById(id);
    }

    @Override
    public List<Order> fetchOrderByLunchId(int lunchId) {
        return this.orderDao.getByLunchId(lunchId);
    }


    private boolean isLunchBeforeDeadline(int lunchId) {
        try {
            return (this.lunchDao.getById(lunchId).getDeadline().getTime() > new Date().getTime());
        } catch (Exception exc) {
            return false;
        }
    }

    private boolean isLunchBeforeDeadline(Order order) {
        try {
            return (this.lunchDao.getById(order.getLunchId()).getDeadline().getTime() > new Date().getTime());
        } catch (Exception exc) {
            return false;
        }
    }

    private boolean isNewDeadlineOK(Date newDeadline) {
        return newDeadline.getTime() > new Date().getTime();
    }

    private boolean isNewLunchOK(Lunch lunch) {
        return isNewDeadlineOK(lunch.getDeadline())
                && lunch.isOpen()
                && lunch.getStatus().equals(LunchStatus.OPEN.name())
                && lunch.getRestaurant() != null
                && lunch.getLunchMaster() != null;
    }

    private boolean isOrderOK(Order order) {
        return isLunchBeforeDeadline(order)
                && order.getDishes().size() > 0
                && order.getUser() != null;
    }

    private boolean canBeDeleted(Lunch lunch){
        try {
            return (lunch.isOpen() || lunch.isClosed());
        }catch(Exception exc){
            //bad practice lol :)
            return false;
        }
    }


    //TODO - move private methods as public static to lunch and order classes

    //TODO - check if user can delete order/lunch

    //TODO - closed lunches without orders should not be archieved

    //TODO - lunch cannot be 'ordered' if it has no orders

    //TODO - we can only delete lunch if is OPEN/CLOSE

    //TODO - lunch without orders after deadline should be automaticaly deleted

    //TODO - preparated order save can enable ordering dishesh from other restaurant



}