package com.products.productlist.service;

import com.products.productlist.entity.Items;
import com.products.productlist.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemsService {
    @Autowired
    private ItemsRepository itemsRepository;

    public List<Items> getAllItems() {
        return itemsRepository.findAll();
    }

    public Items createItem(Items items) {
    // Check if itemsRepository is not null before using it
         if (itemsRepository != null) {
              return itemsRepository.save(items);
         } else {
        // Handle the case where itemsRepository is null (throw an exception or handle it appropriately)
            throw new RuntimeException("ItemsRepository is null in ItemsService");
       }
    }
    public void deleteItem(Long id) {
        if(itemsRepository.existsById(id)){
            itemsRepository.deleteById(id);
        }
    }
}
