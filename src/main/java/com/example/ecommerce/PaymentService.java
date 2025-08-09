package com.example.ecommerce;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    public boolean processPayment(double amount) {
        System.out.println("Processing payment of amount: " + amount);
        return amount > 0;
    }
}
