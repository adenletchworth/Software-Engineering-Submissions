package com.hw5.Entity.Orders;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.hw5.Entity.FoodItems.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.stream.Stream;

public class OrderTest {

    private Customer customer;
    private Order order;

    @BeforeEach
    public void setUpOrderAndCustomer(){
        customer = new Customer("Dummy", Status.NONE);
        order = new Order(customer);
    }

    @Test
    public void testToStringReflectsOrderState() {
        FoodItem hotdog = new HotDog();
        order.addItem(hotdog);

        String expectedToString = String.format("Order for Dummy with %d items for a total of $%.2f", order.getNumberOfItems(), hotdog.cost());
        Assertions.assertEquals(expectedToString, order.toString().trim(), "toString output should match expected format and content");
    }


    @Test
    public void testAddItemAndCalculateTotalNoDiscount() {
        FoodItem burger = new Burger();
        FoodItem fries = new Fries();

        order.addItem(burger);
        order.addItem(fries);

        double expectedTotal = burger.cost() + fries.cost();
        Assertions.assertEquals(expectedTotal, order.calculateTotal(), 0.01, "Total should match expected with no discount");
    }

    private static Stream<Customer> customerProvider() {
        return Stream.of(
                new Customer("Customer1", Status.GOLD),
                new Customer("Customer2", Status.SILVER),
                new Customer("Customer3", Status.BRONZE),
                new Customer("Customer4", Status.NONE)
        );
    }

    @ParameterizedTest
    @MethodSource("customerProvider")
    public void testCalculateDiscountedTotal(Customer customer) {
        
        // Fixed Anonymous class implementation of FoodItem for Standardization
        FoodItem item = new FoodItem() {
            @Override
            public double cost() {
                return 100; 
            }
        };


        // Overwrite BeforeEach order
        order = new Order(customer);
        order.addItem(item); 

        double expectedTotal;
        switch (customer.getLoyaltyStatus()) {
            case GOLD:
                expectedTotal = 90.0; 
                break;
            case SILVER:
                expectedTotal = 95.0; 
                break;
            case BRONZE:
                expectedTotal = 97.0; 
                break;
            default:
                expectedTotal = 100.0;
                break;
        }

        Assertions.assertEquals(expectedTotal, order.calculateTotal(), 0.01, "Discounted total does not match expected value for " + customer.getLoyaltyStatus());
    }


}
