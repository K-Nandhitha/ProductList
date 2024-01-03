package com.products.productlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long productId, Product updatedProduct) {
        if (productRepository.existsById(productId)) {
            updatedProduct.setProductId(productId);
            return productRepository.save(updatedProduct);
        }
        return null; // or throw an exception indicating that the product doesn't exist
    }

    public void deleteProduct(Long productId){
        if(productRepository.existsById(productId)){
            productRepository.deleteById(productId);
        }
    }

    // Method to view the list using streams
    public List<Product> getProductsByNameContains(String keyword) {
        List<Product> allProducts = getAllProducts();

        // Example: Filter products whose name contains the specified keyword using streams
        return allProducts.stream()
                .filter(product -> product.getProductName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Additional methods for CRUD operations if needed
}
