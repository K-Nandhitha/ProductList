package com.products.productlist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getallOrders(){
        return orderService.getallOrders();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @DeleteMapping
    public void deleteOrder(@RequestParam Long orderId){
        orderService.deleteOrder(orderId);
    }

}
