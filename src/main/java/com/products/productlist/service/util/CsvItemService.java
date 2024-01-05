package com.products.productlist.service.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.products.productlist.entity.Items;
import com.products.productlist.repository.ItemsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class CsvItemService {

    @Autowired
    private ItemsRepository itemsRepository;

    String filePathItem = "C:\\Users\\nandh\\Desktop\\items.csv";

    @Transactional
    public void saveItemFromCsv(){
        try(CSVReader itemsReader = new CSVReader(new InputStreamReader(new FileInputStream(filePathItem)))){
            String[] nextRecord;

            try {
                itemsReader.readNext();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (CsvValidationException e) {
                throw new RuntimeException(e);
            }
            while ((nextRecord = itemsReader.readNext()) != null){
                Long orderId = Long.parseLong(nextRecord[0]);
                Long productId = Long.parseLong(nextRecord[1]);
                String productName = nextRecord[2];
                int quantity = Integer.parseInt(nextRecord[3]);

                Items items = new Items();
                items.setOrderId(orderId);
                items.setProductId(productId);
                items.setProductName(productName);
                items.setQuantity(quantity);

                itemsRepository.save(items);
            }
        }catch (IOException | CsvValidationException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
