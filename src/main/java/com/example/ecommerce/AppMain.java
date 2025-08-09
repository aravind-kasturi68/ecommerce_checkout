package com.example.ecommerce;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = "com.example.ecommerce")
public class AppMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppMain.class);

        CartService cartService = context.getBean(CartService.class);
        OrderService orderService = context.getBean(OrderService.class);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to demo E-commerce checkout (type 'checkout' to pay, 'exit' to quit)");
        while (true) {
            System.out.print("Enter item name (or 'checkout'/'exit'): ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) break;
            if (input.equalsIgnoreCase("checkout")) {
                orderService.checkout();
                continue;
            }
            System.out.print("Enter price for '" + input + "': ");
            String priceStr = scanner.nextLine().trim();
            double price;
            try {
                price = Double.parseDouble(priceStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Try again.");
                continue;
            }
            cartService.addItem(input, price);
        }

        System.out.println("Exiting, bye!");
        context.close();
    }
}
