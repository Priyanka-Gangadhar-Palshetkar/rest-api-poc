package com.almameal.api.poc.service;

import com.almameal.api.poc.model.OrderDetails;
import com.almameal.api.poc.repository.OrderRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Objects;

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

    public OrderDetails saveOrder(OrderDetails order) {
        if(Objects.isNull(order.getOrderId())) {
            order.setCreatedDate(new Date(System.currentTimeMillis()));
        } else {
            OrderDetails orderDetails = orderRepository.findById(order.getOrderId()).orElse(null);
            if(Objects.nonNull(orderDetails)) {
                order.setCreatedDate(orderDetails.getCreatedDate());
            }
            order.setUpdatedDate(new Date(System.currentTimeMillis()));
        }
        return orderRepository.save(order);
    }

    public String deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
        return "SUCCESS";
    }


}
