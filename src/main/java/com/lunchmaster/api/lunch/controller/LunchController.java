package com.lunchmaster.api.lunch.controller;

import com.lunchmaster.api.Response;
import com.lunchmaster.api.lunch.dto.Lunch;
import com.lunchmaster.api.lunch.service.LunchService;
import com.lunchmaster.api.lunch.dto.Order;
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

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Lunch> getLunches() {
        return lunchService.fetchLunches();
    }

    /* Get Lunch by Id */
    @GetMapping(value = "/fetch")
    public Lunch fetchLunch(@RequestParam("id") int lunchId) {
        return this.lunchService.fetchLunch(lunchId);
    }

    /* Save new Lunch or update existing if Id is present */
    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public Response<Lunch> saveLunch(@RequestBody Lunch lunch) {
        return this.lunchService.saveLunch(lunch);
    }

    /* Delete Lunch by Id */
    @DeleteMapping(value = "/delete")
    public Response<String> deleteLunch(@RequestParam("id") int lunchId) {
        return this.lunchService.deleteLunch(lunchId);
    }

    /* Get order by Id */
    @GetMapping(value = "/order/fetch", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Order fetchOrder(@RequestParam("id") int orderId){
        return this.lunchService.fetchOrder(orderId);
    }

    /* Save new order or update existing if Id is present */
    @PostMapping(value = "/order/save", consumes = "application/json", produces = "application/json")
    public Response<Order> saveOrder(@RequestBody Order order) {
        return this.lunchService.saveOrder(order);
    }

    /* Delete order by Id */
    @DeleteMapping(value = "/order/delete")
    public Response<String> deleteOrder(@RequestParam("id") int orderId) {
        return this.lunchService.deleteOrder(orderId);
    }


}
