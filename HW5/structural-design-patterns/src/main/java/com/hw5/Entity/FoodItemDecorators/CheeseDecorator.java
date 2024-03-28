package com.hw5.Entity.FoodItemDecorators;

import com.hw5.Entity.FoodItems.FoodItem;

public class CheeseDecorator extends FoodItemDecorator{
    private final double cost = 0.50;
    public CheeseDecorator(FoodItem foodItem){
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
