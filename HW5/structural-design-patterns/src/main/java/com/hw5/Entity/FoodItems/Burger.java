package com.hw5.Entity.FoodItems;

public class Burger implements FoodItem{
    private final double cost = 4.50;

    public Burger(){}
    
    @Override
    public double cost(){
        return cost;
    }
}
