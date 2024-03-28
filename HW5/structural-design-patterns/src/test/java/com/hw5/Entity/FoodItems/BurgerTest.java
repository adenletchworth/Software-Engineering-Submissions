package com.hw5.Entity.FoodItems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BurgerTest {

    @Test
    public void testCostReturnsCorrectValue() {
        FoodItem burger = new Burger();
        double expectedCost = 4.50;
        Assertions.assertEquals(expectedCost, burger.cost(), "Burger cost should be 4.50");
    }
}
