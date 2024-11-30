package com.qp.assessment.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class GroceryOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Order ID

    @ManyToMany
    @JoinTable(
        name = "grocery_order_items", 
        joinColumns = @JoinColumn(name = "grocery_order_id"), 
        inverseJoinColumns = @JoinColumn(name = "grocery_item_id")
    )
    private List<GroceryItem> groceryItems;  // List of grocery items

    private double totalPrice; 


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<GroceryItem> getGroceryItems() {
        return groceryItems;
    }

    public void setGroceryItems(List<GroceryItem> groceryItems) {
        this.groceryItems = groceryItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
