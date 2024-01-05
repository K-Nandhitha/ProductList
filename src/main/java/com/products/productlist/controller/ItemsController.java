package com.products.productlist.controller;

import com.products.productlist.service.util.CsvItemService;
import com.products.productlist.entity.Items;
import com.products.productlist.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private CsvItemService csvItemService;

    @GetMapping
    public List<Items> getAllItems(){
        return itemsService.getAllItems();
    }

    @PostMapping("/i")
    public ResponseEntity<String> uploadCsvData() {
        csvItemService.saveItemFromCsv();
        return ResponseEntity.ok("CSV data uploaded and saved to the database.");
    }

    @PostMapping
    public Items createItem(@RequestBody Items items){
        return itemsService.createItem(items);
    }

    @DeleteMapping
    public void deleteItem(@RequestParam Long id){
        itemsService.deleteItem(id);
    }
}
