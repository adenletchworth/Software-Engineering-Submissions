package com.hw5.Entity.Orders;

public class Customer {
    public String name;
    public Status loyaltyStatus;

    public Customer(String name, Status loyaltyStatus) {
        this.name = name;
        this.loyaltyStatus = loyaltyStatus;
    }

    public String getName() {
        return name;
    }

    public Status getLoyaltyStatus() {
        return loyaltyStatus;
    }
}
