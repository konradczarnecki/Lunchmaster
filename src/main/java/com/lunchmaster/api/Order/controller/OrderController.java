package com.lunchmaster.api.Order.controller;

import com.lunchmaster.api.Order.dto.Order;
import com.lunchmaster.api.Order.service.OrderService;
import com.lunchmaster.api.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/order")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    private OrderService orderService;

    /* Get Order by Id */
    @GetMapping(value = "/fetch")
    public Order fetchOrder(@RequestParam("id") int orderId){
        return this.orderService.fetchOrder(orderId);
    }

    /* Save new Order or update existing if Id is present */
    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public Response<Order> saveOrder(@RequestBody Order order) {
        return this.orderService.saveOrder(order);
    }

    /* Delete Order by Id */
    @GetMapping(value = "/delete")
    public Response<String> deleteOrder(@RequestParam("id") int orderId) {
        return this.orderService.deleteOrder(orderId);
    }


    @Autowired
    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

}
