package com.hw5.Entity.FoodItemDecorators;

import com.hw5.Entity.FoodItems.FoodItem;

public abstract class FoodItemDecorator implements FoodItem{
    protected FoodItem foodItem;

    public FoodItemDecorator(FoodItem foodItem){
        this.foodItem = foodItem;
    }

    public double cost(){
        return foodItem.cost();
    }
}
