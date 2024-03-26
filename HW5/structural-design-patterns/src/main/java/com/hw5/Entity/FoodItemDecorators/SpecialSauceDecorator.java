package com.hw5.Entity.FoodItemDecorators;

import com.hw5.Entity.FoodItems.FoodItem;

public class SpecialSauceDecorator extends FoodItemDecorator{
    public SpecialSauceDecorator(FoodItem foodItem){
        super(foodItem);
    }

    @Override
    public double cost(){
        return foodItem.cost() + 0.25;
    }
}
