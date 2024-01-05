package com.products.productlist.controller;


import com.products.productlist.service.util.CsvOrderService;
import com.products.productlist.entity.Order;
import com.products.productlist.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CsvOrderService csvOrderService;

    @GetMapping
    public List<Order> getallOrders(){
        return orderService.getallOrders();
    }

    @PostMapping("/o")
    public ResponseEntity<String> uploadCsvData() {
        csvOrderService.saveOrderFromCsv();
        return ResponseEntity.ok("CSV data uploaded and saved to the database.");
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
