package com.lunchmaster.api.lunch.controller;

import com.lunchmaster.api.Response;
import com.lunchmaster.api.lunch.dto.Lunch;
import com.lunchmaster.api.lunch.dto.Order;
import com.lunchmaster.api.lunch.service.LunchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by m.slefarski on 2017-09-25.
 */

@RestController
@RequestMapping("/api/lunch")
public class LunchController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LunchController.class);

    private LunchService lunchService;

    @Autowired
    public LunchController(LunchService lunchServiceImpl) {
        this.lunchService = lunchServiceImpl;
    }

    /* LUNCH */

    /* Fetch all lunches */
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Lunch> getLunches() {
        return lunchService.fetchLunches();
    }

    /* Get Lunch by Id */
    @GetMapping(value = "/fetch", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Lunch fetchLunch(@RequestParam("id") int lunchId) {
        return this.lunchService.fetchLunch(lunchId);
    }

    /* Save new Lunch */
    @PutMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<Lunch> saveLunch(@RequestBody Lunch lunch) {
        return this.lunchService.saveLunch(lunch);
    }

    /* Delete Lunch by Id */
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<String> deleteLunch(@RequestParam("id") int lunchId) {
        return this.lunchService.deleteLunch(lunchId);
    }

    /* Change restaurant */
    @PostMapping(value = "/change-restaurant", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<String> changeRestaurant(@RequestParam("lunchId") int lunchId,
                                             @RequestParam("restaurantId") int restaurantId) {
        return lunchService.changeRestaurant(lunchId, restaurantId);
    }

    /* Close lunch */
    @PostMapping(value = "/close", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<String> closeLunch(@RequestParam("lunchId") int lunchId) {
        return lunchService.closeLunch(lunchId);
    }

    /* Change deadline */
    @PostMapping(value = "/change-deadline", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<String> changeDeadline(@RequestParam("lunchId") int lunchId,
                                           @RequestParam("deadline") long deadline) {
        return lunchService.changeDeadline(lunchId, deadline);
    }

    /* Change expected delivery */
    @PostMapping(value = "/change-exp-delivery", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<String> changeExpectedDelivery(@RequestParam("lunchId") int lunchId,
                                           @RequestParam("expectedDelivery") int expectedDelivery) {
        return lunchService.changeDeadline(lunchId, expectedDelivery);
    }

    /* Re-open lunch */
    @PostMapping(value = "/re-open", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<String> reopenLunch(@RequestParam("lunchId") int lunchId) {
        return lunchService.reopenLunch(lunchId);
    }


    /* ORDER */
    /* Get order by Id */
    @GetMapping(value = "/order/fetch", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Order fetchOrder(@RequestParam("id") int orderId) {
        return this.lunchService.fetchOrder(orderId);
    }

    /* Save new order or update existing if Id is present */
    @PutMapping(value = "/order/save", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<Order> saveOrder(@RequestBody Order order) {
        return this.lunchService.saveOrder(order);
    }

    /* Delete order by Id */
    @DeleteMapping(value = "/order/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<String> deleteOrder(@RequestParam("id") int orderId) {
        return this.lunchService.deleteOrder(orderId);
    }

}
