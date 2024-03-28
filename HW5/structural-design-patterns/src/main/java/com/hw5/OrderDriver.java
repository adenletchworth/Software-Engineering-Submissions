package com.hw5;

import com.hw5.Entity.FoodItemDecorators.*;
import com.hw5.Entity.FoodItems.*;
import com.hw5.Entity.Orders.*;

public class OrderDriver {
    public static void main(String[] args) {
        Customer jane = new Customer("Jane", Status.BRONZE);
        Customer john = new Customer("John", Status.SILVER);
        Customer jack = new Customer("Jack", Status.GOLD);

        Order janesOrder = new Order(jane);
        Order johnsOrder = new Order(john);
        Order jacksOrder = new Order(jack);

        // Probably could have used a factory pattern here, but we have a limited number of items for this assignment

        // Simple Decorator
        CheeseDecorator cheeseBurger = new CheeseDecorator(new Burger());
        SpecialSauceDecorator specialSauceBurger = new SpecialSauceDecorator(new Fries());
        PattyDecorator doublePattyBurger = new PattyDecorator(new Burger());

        // Nested Decorator
        PattyDecorator doublePattyCheeseBurgerWithSpecialSauce = new PattyDecorator(new CheeseDecorator(new SpecialSauceDecorator(new Burger())));
        CheeseDecorator animalStyleFriesWithoutOnions = new CheeseDecorator(new SpecialSauceDecorator(new Fries()));

        janesOrder.addItem(cheeseBurger);
        janesOrder.addItem(doublePattyCheeseBurgerWithSpecialSauce);
        johnsOrder.addItem(specialSauceBurger);
        jacksOrder.addItem(doublePattyBurger);
        jacksOrder.addItem(animalStyleFriesWithoutOnions);


        System.out.println(janesOrder);
        System.out.println(jacksOrder);
        System.out.println(johnsOrder);
    }
}
