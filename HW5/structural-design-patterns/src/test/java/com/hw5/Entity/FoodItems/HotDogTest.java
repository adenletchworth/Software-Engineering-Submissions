package com.hw5.Entity.FoodItems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotDogTest {  
    @Test
    public void testCostReturnsCorrectValue() {
        FoodItem hotDog = new HotDog();
        double expectedCost = 2.00;
        Assertions.assertEquals(expectedCost, hotDog.cost(), "HotDog cost should be 2.00");
    }
}
