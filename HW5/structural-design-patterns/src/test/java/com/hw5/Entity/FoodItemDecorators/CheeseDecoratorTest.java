package com.hw5.Entity.FoodItemDecorators;

import com.hw5.Entity.FoodItems.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Assertions;

import java.util.stream.Stream;

public class CheeseDecoratorTest {

    private static Stream<FoodItem> foodItemProvider() {
        return Stream.of(new Burger(), new Fries(), new HotDog());
    }

    private static Stream<FoodItemDecorator> foodItemDecoratorProvider() {
        return Stream.of(new PattyDecorator(new Burger()), new SpecialSauceDecorator(new Fries()), new CheeseDecorator(new HotDog()));
    }

    @ParameterizedTest
    @MethodSource("foodItemProvider")
    public void testCheeseDecoratorAddsCorrectCost(FoodItem foodItem) {
        CheeseDecorator cheeseDecorator = new CheeseDecorator(foodItem);
        double cheeseCost = cheeseDecorator.getCost();

        double expectedCost = foodItem.cost() + cheeseCost; 
        Assertions.assertEquals(expectedCost, cheeseDecorator.cost(), 0.0,
            () -> "Failed for " + foodItem.getClass().getSimpleName());
    }

    @ParameterizedTest
    @MethodSource("foodItemDecoratorProvider")
    public void testCheeseDecoratorComposabilityWithOtherDecorators(FoodItemDecorator foodItemDecorator) {
        CheeseDecorator cheeseDecorator = new CheeseDecorator(foodItemDecorator);
        double cheeseCost = cheeseDecorator.getCost();

        double expectedCost = foodItemDecorator.cost() + cheeseCost; 
        Assertions.assertEquals(expectedCost, cheeseDecorator.cost(), 0.0,
            () -> "Failed for " + foodItemDecorator.getClass().getSimpleName());
    }

}
