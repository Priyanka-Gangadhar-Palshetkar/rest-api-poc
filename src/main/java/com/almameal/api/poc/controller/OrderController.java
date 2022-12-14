package com.almameal.api.poc.controller;

import com.almameal.api.poc.model.OrderDetails;
import com.almameal.api.poc.service.OrderService;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/orderss")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDetails> getAllOrders() {
        Iterable<OrderDetails> orders = orderService.getAllOrders();
        if(!Iterables.isEmpty(orders)){
            return Lists.newArrayList(orders);
        }

        return Collections.emptyList();
    }

    @PostMapping
    public OrderDetails saveOrder(@RequestBody OrderDetails order) {
        return orderService.saveOrder(order);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }
}
