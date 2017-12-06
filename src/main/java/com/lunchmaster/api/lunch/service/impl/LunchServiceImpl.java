package com.lunchmaster.api.lunch.service.impl;

import com.lunchmaster.api.Response;
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

    /* Change restaurant */
    @Override
    public Response<String> changeRestaurant(int lunchId, int restaurantId) {
        Response<String> resp = new Response<>();
        Lunch lunch = fetchLunch(lunchId);
        Restaurant restaurant = restaurantDao.getById(restaurantId);

        //if lunch or restaurant not found
        if (lunch == null || restaurant == null) {
            return resp.error();
        }
        //if lunch is open and have no orders
        if (lunch.canChangeRestaurant()) {
            try {
                lunch.setRestaurant(restaurant);
                return resp.success();
            } catch (Exception exc) {
                return resp.error();
            }
        }
        return resp.forbidden();
    }

    /* Close lunch */
    @Override
    public Response<String> closeLunch(int lunchId) {
        Response<String> resp = new Response<>();
        Lunch lunch = fetchLunch(lunchId);
        //is not null and is legal to change status
        if (lunch != null && lunch.close()) {
            //user is forcing lunch close - set deadline to now
            lunch.setDeadline(new Date());
            try {
                saveLunch(lunch);
                return resp.success();
            } catch (Exception exc) {
                return resp.error();
            }
        }
        return resp.forbidden();
    }

    /* Change deadline */
    @Override
    public Response<String> changeDeadline(int lunchId, long deadline) {
        Response<String> resp = new Response<>();
        Lunch lunch = fetchLunch(lunchId);
        Date deadlineDate = new Date(deadline);

        //check if not null
        if(lunch==null) {
            return resp.error();
        }
        //not null and correct deadlineDate
        else if(isNewDeadlineOK(deadlineDate) && lunch.isOpen() || lunch.isClosed()){
            try{
                lunch.setDeadline(deadlineDate);
                lunch.open();
                saveLunch(lunch);
                return resp.success();
            }catch(Exception exc){
                return resp.error();
            }
        }
        return resp.forbidden();
    }

    /* Change expected delivery */
    @Override
    public Response<String> changeExpectedDelivery(int lunchId, int expectedDelivery){
        Response<String> resp = new Response<>();
        Lunch lunch = fetchLunch(lunchId);

        //lunch not found
        if(lunch==null){
            return resp.error();
        }
        //found, but in billing phase
        else if(lunch.isInBillingPhase()){
            return resp.forbidden();
        }
        //found and can edit delivery
        else{
            lunch.setExpectedDelivery(expectedDelivery);
            try {
                saveLunch(lunch);
                return resp.success();
            }catch (Exception exc){
                return resp.error();
            }
        }
    }

    /* Reopen lunch */
    @Override
    public Response<String> reopenLunch(int lunchId){
        Response<String> resp = new Response<>();
        Lunch lunch = fetchLunch(lunchId);

        //lunch not found
        if(lunch==null){
            return resp.error();
        }
        //can be reopened
        else if(lunch.open()){
            lunch.prolongDeadline(10);
            try {
                saveLunch(lunch);
                return resp.success();
            } catch (Exception exc) {
                return resp.error();
            }
        }
        //cant be reopened
        return resp.forbidden();
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
        //can be deleted
        if (lunch.canBeDeleted()) {
            try {
                this.lunchDao.deleteById(lunchId);
                return resp.success();
            } catch (Exception exc) {
                return resp.error();
            }
        }
        //can't be deleted
        return resp.forbidden();
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

    /* Delete order */
    @Override
    public Response<String> deleteOrder(int orderId) {
        Response<String> resp = new Response<>();
        Order order = orderDao.getById(orderId);
        //order not found
        if (order == null) {
            return resp.error();
        }
        //order found but after deadline
        else if (isAfterDeadline(order)) {
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

    /* fetch order */
    @Override
    public Order fetchOrder(int id) {
        return this.orderDao.getById(id);
    }

    /* fetch list of orders by lunch id */
    @Override
    public List<Order> fetchOrderByLunchId(int lunchId) {
        return this.orderDao.getByLunchId(lunchId);
    }



    /* PRIVATE METHODS */
    //TODO move them to Order/Lunch dto
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

    private boolean isAfterDeadline(int lunchId) {
        try {
            return (this.lunchDao.getById(lunchId).isAfterDeadline());
        } catch (Exception exc) {
            return false;
        }
    }

    private boolean isAfterDeadline(Order order) {
        try {
            return (this.lunchDao.getById(order.getLunchId()).isAfterDeadline());
        } catch (Exception exc) {
            return false;
        }
    }

    private boolean isNewDeadlineOK(Date newDeadline) {
        return newDeadline.getTime() > new Date().getTime();
    }

    private boolean isNewLunchOK(Lunch lunch) {
        return isNewDeadlineOK(lunch.getDeadline())
                && lunch.getId()==0
                && lunch.isOpen()
                && lunch.getRestaurant() != null
                && lunch.getLunchMaster() != null;
    }

    private boolean isOrderOK(Order order) {
        return !isAfterDeadline(order)
                && order.getDishes().size() > 0
                && order.getUser() != null;
    }

}