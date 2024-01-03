package com.products.productlist;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "\"order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Long orderNo;
    private LocalDate dateOfOrder;
    private LocalDate expectedDeliveryDate;
    private String listOfProducts;
}
