package com.products.productlist.service;


import com.products.productlist.entity.Order;
import com.products.productlist.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public  List<Order> getallOrders(){
        return orderRepository.findAll();
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        if(orderRepository.existsById(orderId)){
            orderRepository.deleteById(orderId);
        }
    }
}
