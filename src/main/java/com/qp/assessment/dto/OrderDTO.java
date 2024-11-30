package com.qp.assessment.dto;

import java.util.List;

public class OrderDTO {

    private int userId;
    private double totalPrice;
    private List<OrderItemDTO> groceryItems;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<OrderItemDTO> getGroceryItems() {
		return groceryItems;
	}
	public void setGroceryItems(List<OrderItemDTO> groceryItems) {
		this.groceryItems = groceryItems;
	}

    
    
}
