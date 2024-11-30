package com.qp.assessment.controller;

import com.qp.assessment.model.GroceryItem;
import com.qp.assessment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grocery-items")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/grocery-items/user")
    public List<GroceryItem> getAllGroceryItems() {
        return userService.getAllGroceryItems();
    }

    @PostMapping("/orders")
    public String createOrder(@RequestBody List<Integer> groceryItemIds) {
        return userService.createOrder(groceryItemIds);
    }
}
