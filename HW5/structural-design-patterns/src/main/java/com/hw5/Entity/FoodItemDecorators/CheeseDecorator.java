package com.hw5.Entity.FoodItemDecorators;

import com.hw5.Entity.FoodItems.FoodItem;

public class CheeseDecorator extends FoodItemDecorator{
    public CheeseDecorator(FoodItem foodItem){
        super(foodItem);
    }

    @Override
    public double cost(){
        return foodItem.cost() + 0.50;
    }
}
