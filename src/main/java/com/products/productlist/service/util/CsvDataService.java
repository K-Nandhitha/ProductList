package com.products.productlist.service.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.products.productlist.entity.Product;
import com.products.productlist.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class CsvDataService {

    @Autowired
    private ProductRepository productRepository;

    String filePath = "C:\\Users\\nandh\\Desktop\\products.csv";
    @Transactional
    public void saveDataFromCsv() {
        try (CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(filePath))))
        {
            String[] nextRecord;

            // Skip header if present
            try {
                reader.readNext();
            } catch (CsvValidationException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);

            }

            while ((nextRecord = reader.readNext()) != null) {
                String productName = nextRecord[0];
                int stock = Integer.parseInt(nextRecord[1]);
                boolean availability = Boolean.parseBoolean(nextRecord[2]);

                Product product = new Product();
                product.setProductName(productName);
                product.setStock(stock);
                product.setAvailability(availability);

                productRepository.save(product);
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();  // Log the exception or handle it appropriately
        }
    }
}
