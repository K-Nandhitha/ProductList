package com.products.productlist.service.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.products.productlist.entity.Order;
import com.products.productlist.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CsvOrderService {

    @Autowired
    private OrderRepository orderRepository;

    String filePathOrder = "C:\\Users\\nandh\\Desktop\\order.csv";

    public void saveOrderFromCsv(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try(CSVReader readerOrder = new CSVReader(new InputStreamReader(new FileInputStream(filePathOrder)))){
            String[] nextRecord;

            try {
                readerOrder.readNext();
            } catch (CsvValidationException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);

            }

            while((nextRecord = readerOrder.readNext())!= null)
            {
                LocalDate dateOfOrder = LocalDate.parse(nextRecord[0], dateFormatter);
                LocalDate expectedDeliveryDate = LocalDate.parse(nextRecord[1], dateFormatter);
                String listOfProducts = nextRecord[2];
                Long orderNo = Long.parseLong(nextRecord[3]);

                Order order = new Order();
                order.setDateOfOrder(dateOfOrder);
                order.setExpectedDeliveryDate(expectedDeliveryDate);
                order.setListOfProducts(listOfProducts);
                order.setOrderNo(orderNo);

                orderRepository.save(order);
            }
        }catch (IOException | CsvValidationException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
