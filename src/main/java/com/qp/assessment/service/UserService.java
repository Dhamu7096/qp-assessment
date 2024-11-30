package com.qp.assessment.service;

import com.qp.assessment.model.GroceryItem;
import com.qp.assessment.model.GroceryOrder;
import com.qp.assessment.repository.GroceryRepository;
import com.qp.assessment.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final GroceryRepository groceryRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public UserService(GroceryRepository groceryRepository, OrderRepository orderRepository) {
        this.groceryRepository = groceryRepository;
        this.orderRepository = orderRepository;
    }

    public List<GroceryItem> getAllGroceryItems() {
        return groceryRepository.findAll();
    }

    public String createOrder(List<Integer> groceryItemIds) {
        List<GroceryItem> groceryItems = groceryItemIds.stream()
                .map(id -> groceryRepository.findById(id)  // ID is Long
                        .orElseThrow(() -> new RuntimeException("Item not found with ID: " + id)))
                .collect(Collectors.toList());  // Collecting into a list of GroceryItems

        GroceryOrder groceryOrder = new GroceryOrder();
        groceryOrder.setGroceryItems(groceryItems);

        groceryOrder.setTotalPrice(groceryItems.stream().mapToDouble(GroceryItem::getPrice).sum());

        orderRepository.save(groceryOrder);

        return "Grocery Order created successfully!";
    }




}
