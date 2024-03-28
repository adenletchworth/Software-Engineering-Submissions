package com.hw5.Entity.FoodItems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FriesTest {
    @Test
    public void testCostReturnsCorrectValue() {
        FoodItem fries = new Fries();
        double expectedCost = 1.25;
        Assertions.assertEquals(expectedCost, fries.cost(), "Fries cost should be 1.25");
    }
}
