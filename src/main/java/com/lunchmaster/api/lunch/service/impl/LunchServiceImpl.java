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
    private RestaurantDao restaurantDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(LunchServiceImpl.class);

    @Autowired
    public LunchServiceImpl(LunchDao lunchDao, OrderDao orderDao, RestaurantDao restaurantDao) {
        this.lunchDao = lunchDao;
        this.orderDao = orderDao;
        this.restaurantDao = restaurantDao;
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


    @Override
    public Response<Lunch> saveLunch(Lunch lunch) {
        if (lunch.getId() == 0){
            return createNewLunch(lunch);
        } else {
            return updateLunch(lunch);
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
        //lunch found but ordered
        if(lunch.isOrdered()){
            return resp.forbidden();
        }
        else {
            try {
                this.orderDao.deleteByLunchId(lunchId);
                this.lunchDao.deleteById(lunchId);
                return resp.success();
            } catch (Exception exc) {
                //error during delete
                return resp.error();
            }
        }
    }

    /* LUNCH PRIVATE METHODS */
    private Response<Lunch> createNewLunch(Lunch lunch) {
        Response<Lunch> resp = new Response<>(lunch);
        try {
            //ensure correct values for new lunch
            //TODO ensure correct deadline
            lunch.getOrders().clear();
            lunch.setStatus(LunchStatus.OPEN.name());
            lunch = lunchDao.save(lunch);
            return resp.success();
        } catch (Exception exc) {
            return resp.error();
        }
    }

    private Response<Lunch> updateLunch(Lunch lunch) {
        Response<Lunch> resp = new Response<>(lunch);
        //fetch lunch from db to ensure proper values
        Lunch l = this.fetchLunch(lunch.getId());
        //lunch not found
        if (l == null) {
            return resp.error();
        }
        //lunch found and not yet ordered
        if(l.isOpen() || l.isClosed()) {
            //you can modify restaurant when there are no orders yet
            if (l.getOrders().size() == 0) {
                l.setRestaurant(lunch.getRestaurant());
            }
            if(isNewDeadlineOK(lunch.getDeadline())){
                l.setDeadline(lunch.getDeadline());
                l.changeStatus(LunchStatus.OPEN);
            }
        }
        //you can update status till lunch is archieved
        if(!l.isArchived()) {
            if(!l.changeStatus(LunchStatus.valueOf(lunch.getStatus()))){
                return resp.forbidden();
            }
        }

        try {
            lunch = this.lunchDao.save(l);
            return resp.success();
        } catch (Exception exc) {
            return resp.error();
        }
    }


    /* ORDER */
    /* Save new order or update existing */
    @Override
    public Response<Order> saveOrder(Order order) {
        Response<Order> resp = new Response<>(order);
        if (lunchIsBeforeDeadline(order.getLunchId())) {
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
        else if(!lunchIsBeforeDeadline(order.getLunchId())) {
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

    private boolean lunchIsBeforeDeadline(int lunchId) {
        return (this.lunchDao.getById(lunchId).getDeadline().getTime() > new Date().getTime());
    }

    private boolean isNewDeadlineOK(Date newDeadline){
        return newDeadline.getTime()>new Date().getTime();
    }

}

