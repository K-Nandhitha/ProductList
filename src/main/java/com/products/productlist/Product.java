package com.products.productlist;

import jakarta.persistence.*;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private int stock;
    private boolean availability;

    // Getters and Setters

    // Constructors

    // Additional methods if needed
}
