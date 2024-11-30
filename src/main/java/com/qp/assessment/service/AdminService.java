package com.qp.assessment.service;

import com.qp.assessment.model.GroceryItem;
import com.qp.assessment.repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final GroceryRepository groceryRepository;

    @Autowired
    public AdminService(GroceryRepository groceryRepository) {
        this.groceryRepository = groceryRepository;
    }

    public GroceryItem addGroceryItem(GroceryItem groceryItem) {
        return groceryRepository.save(groceryItem);
    }

    public List<GroceryItem> getAllGroceryItems() {
        return groceryRepository.findAll();
    }

    public GroceryItem updateGroceryItem(Long id, GroceryItem groceryItem) {
        groceryItem.setId(id);
        return groceryRepository.save(groceryItem);
    }

    public void deleteGroceryItem(int id) {
        groceryRepository.deleteById(id);
    }

    public GroceryItem updateInventory(int id, int inventoryCount) {
        GroceryItem groceryItem = groceryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grocery Item not found"));
        groceryItem.setInventoryCount(inventoryCount);
        return groceryRepository.save(groceryItem);
    }
}
