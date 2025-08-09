package com.example.ecommerce;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartService {
    private final List<String> cartItems = new ArrayList<>();
    private double totalAmount = 0.0;

    public void addItem(String item, double price) {
        cartItems.add(item);
        totalAmount += price;
        System.out.println(item + " added to cart. Price: " + price);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public List<String> getItems() {
        return new ArrayList<>(cartItems);
    }

    public void clear() {
        cartItems.clear();
        totalAmount = 0.0;
    }
}
