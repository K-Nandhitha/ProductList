package com.products.productlist.controller;

import com.products.productlist.service.util.CsvDataService;
import com.products.productlist.entity.Product;
import com.products.productlist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @GetMapping("/page")
    public List<Product> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {


        return productService.getProducts(page, size);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam(required = false) String productName,
            @RequestParam(defaultValue = "false") boolean availability) {
        return productService.searchProducts(productName, availability);
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
