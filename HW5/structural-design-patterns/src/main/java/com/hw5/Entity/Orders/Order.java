package com.hw5.Entity.Orders;

import java.util.ArrayList;
import java.util.List;

import com.hw5.Entity.FoodItems.FoodItem;

public class Order {
    private List<FoodItem> items = new ArrayList<>();
    private Customer customer;

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void addItem(FoodItem item) {
        items.add(item);
    }

    private double calculateDiscountedTotal(double total) {
        switch (customer.getLoyaltyStatus()) {
            case GOLD:
                return total * 0.9;
            case SILVER:
                return total * 0.95;
            case BRONZE:
                return total * 0.97;
            default:
                return total;
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (FoodItem item : items) {
            total += item.cost();
        }
        return calculateDiscountedTotal(total);
    }

    @Override
    public String toString() {
    return "Order for " + customer.getName() + " with " + items.size() + " items for a total of $" + String.format("%.2f", calculateTotal());
    }

}
