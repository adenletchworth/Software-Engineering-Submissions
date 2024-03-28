package com.hw5.Entity.FoodItemDecorators;

import com.hw5.Entity.FoodItems.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Assertions;

import java.util.stream.Stream;

public class PattyDecoratorTest {
    private static Stream<FoodItem> foodItemProvider() {
        return Stream.of(new Burger(), new Fries(), new HotDog());
    }

    private static Stream<FoodItemDecorator> foodItemDecoratorProvider() {
        return Stream.of(new PattyDecorator(new Burger()), new SpecialSauceDecorator(new Fries()), new CheeseDecorator(new HotDog()));
    }

    @ParameterizedTest
    @MethodSource("foodItemProvider")
    public void testPattyDecoratorAddsCorrectCost(FoodItem foodItem) {
        PattyDecorator pattyDecorator = new PattyDecorator(foodItem);
        double pattyCost = pattyDecorator.getCost();

        double expectedCost = foodItem.cost() + pattyCost; 
        Assertions.assertEquals(expectedCost, pattyDecorator.cost(), 0.0,
            () -> "Failed for " + foodItem.getClass().getSimpleName());
    }

    @ParameterizedTest
    @MethodSource("foodItemDecoratorProvider")
    public void testPattyDecoratorComposabilityWithOtherDecorators(FoodItemDecorator foodItemDecorator) {
        PattyDecorator pattyDecorator = new PattyDecorator(foodItemDecorator);
        double pattyCost = pattyDecorator.getCost();

        double expectedCost = foodItemDecorator.cost() + pattyCost; 
        Assertions.assertEquals(expectedCost, pattyDecorator.cost(), 0.0,
            () -> "Failed for " + foodItemDecorator.getClass().getSimpleName());
    }
}
