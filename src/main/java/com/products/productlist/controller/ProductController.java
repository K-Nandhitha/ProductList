package com.products.productlist.controller;

import com.products.productlist.service.util.CsvDataService;
import com.products.productlist.entity.Product;
import com.products.productlist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CsvDataService csvDataService;

    @PostMapping("/u")
    public ResponseEntity<String> uploadCsvData() {
        csvDataService.saveDataFromCsv();
        return ResponseEntity.ok("CSV data uploaded and saved to the database.");
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestParam Long productId, @RequestBody Product updatedProduct) {
        return productService.updateProduct(productId, updatedProduct);
    }

    @DeleteMapping
    public void deleteProduct(@RequestParam Long productId){
        productService.deleteProduct(productId);
    }

    // Additional methods for CRUD operations if needed
}
