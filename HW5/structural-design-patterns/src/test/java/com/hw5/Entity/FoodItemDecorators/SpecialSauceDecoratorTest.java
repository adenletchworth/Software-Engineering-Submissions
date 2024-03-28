package com.hw5.Entity.FoodItemDecorators;

import com.hw5.Entity.FoodItems.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Assertions;

import java.util.stream.Stream;

public class SpecialSauceDecoratorTest {
        private static Stream<FoodItem> foodItemProvider() {
            return Stream.of(new Burger(), new Fries(), new HotDog());
        }
    
        private static Stream<FoodItemDecorator> foodItemDecoratorProvider() {
            return Stream.of(new PattyDecorator(new Burger()), new SpecialSauceDecorator(new Fries()), new CheeseDecorator(new HotDog()));
        }
    
        @ParameterizedTest
        @MethodSource("foodItemProvider")
        public void testSpecialSauceDecoratorAddsCorrectCost(FoodItem foodItem) {
            SpecialSauceDecorator specialSauceDecorator = new SpecialSauceDecorator(foodItem);
            double specialSauceCost = specialSauceDecorator.getCost();
    
            double expectedCost = foodItem.cost() + specialSauceCost; 
            Assertions.assertEquals(expectedCost, specialSauceDecorator.cost(), 0.0,
                () -> "Failed for " + foodItem.getClass().getSimpleName());
        }
    
        @ParameterizedTest
        @MethodSource("foodItemDecoratorProvider")
        public void testSpecialSauceDecoratorComposabilityWithOtherDecorators(FoodItemDecorator foodItemDecorator) {
            SpecialSauceDecorator specialSauceDecorator = new SpecialSauceDecorator(foodItemDecorator);
            double specialSauceCost = specialSauceDecorator.getCost();
    
            double expectedCost = foodItemDecorator.cost() + specialSauceCost; 
            Assertions.assertEquals(expectedCost, specialSauceDecorator.cost(), 0.0,
                () -> "Failed for " + foodItemDecorator.getClass().getSimpleName());
        }
}
