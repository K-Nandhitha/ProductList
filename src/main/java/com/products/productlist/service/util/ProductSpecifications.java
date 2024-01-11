package com.products.productlist.service.util;

import com.products.productlist.entity.Product;
import org.springframework.data.jpa.domain.Specification;


public class ProductSpecifications {

    public static Specification<Product> nameLike(String productName) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("productName")), "%" + productName.toLowerCase() + "%");
    }

    public static Specification<Product> byAvailability(boolean availability) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("availability"), availability);
    }
}
