package com.hw5.Entity.FoodItemDecorators;

import com.hw5.Entity.FoodItems.FoodItem;

public class PattyDecorator extends FoodItemDecorator{
    private final double cost = 1.00;

    public PattyDecorator(FoodItem foodItem){
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
