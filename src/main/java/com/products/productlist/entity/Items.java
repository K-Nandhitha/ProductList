package com.products.productlist.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity")
    private int quantity;
}
