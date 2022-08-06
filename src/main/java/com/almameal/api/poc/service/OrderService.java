package com.almameal.api.poc.service;

import com.almameal.api.poc.model.OrderDetails;
import com.almameal.api.poc.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Iterable<OrderDetails> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderDetails createNewOrder(OrderDetails order) {
        return orderRepository.save(order);
    }
}
