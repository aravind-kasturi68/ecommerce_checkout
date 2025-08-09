package com.example.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private final CartService cartService;
    private final PaymentService paymentService;

    @Autowired
    public OrderService(CartService cartService, PaymentService paymentService) {
        this.cartService = cartService;
        this.paymentService = paymentService;
    }

    public void checkout() {
        double amount = cartService.getTotalAmount();
        if (amount == 0) {
            System.out.println("Cart is empty. Cannot place order.");
            return;
        }
        boolean paid = paymentService.processPayment(amount);
        if (paid) {
            System.out.println("Order placed successfully for amount: " + amount);
            cartService.clear();
        } else {
            System.out.println("Payment failed. Order not placed.");
        }
    }
}
