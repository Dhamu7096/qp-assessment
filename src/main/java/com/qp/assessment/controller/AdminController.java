package com.qp.assessment.controller;

import com.qp.assessment.model.GroceryItem;
import com.qp.assessment.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grocery-items")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GroceryItem addGroceryItem(@RequestBody GroceryItem groceryItem) {
        return adminService.addGroceryItem(groceryItem);
    }

    @GetMapping("/api/grocery-items/admin")
    public List<GroceryItem> getAllGroceryItems() {
        return adminService.getAllGroceryItems();
    }

    @PutMapping("/{id}")
    public GroceryItem updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItem groceryItem) {
        return adminService.updateGroceryItem(id, groceryItem);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGroceryItem(@PathVariable int id) {
        adminService.deleteGroceryItem(id);
    }

    @PutMapping("/inventory/{id}")
    public GroceryItem updateInventory(@PathVariable int id, @RequestParam int inventoryCount) {
        return adminService.updateInventory(id, inventoryCount);
    }
}
