package com.products.productlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @GetMapping
    public List<Items> getAllItems(){
        return itemsService.getAllItems();
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
