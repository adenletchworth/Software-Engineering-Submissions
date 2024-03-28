package com.hw5.Entity.FoodItemDecorators;

import com.hw5.Entity.FoodItems.FoodItem;

public class SpecialSauceDecorator extends FoodItemDecorator{
    private final double cost = 0.25;
    public SpecialSauceDecorator(FoodItem foodItem){
        super(foodItem);
    }

    @Override
    public double cost(){
        return foodItem.cost() + cost;
    }

    @Override
    public double getCost(){
        return cost;
    }
}
