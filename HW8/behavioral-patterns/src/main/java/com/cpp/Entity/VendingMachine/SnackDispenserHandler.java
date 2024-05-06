package com.cpp.Entity.VendingMachine;

public interface SnackDispenserHandler {
    void setNextHandler(SnackDispenserHandler handler);
    boolean handleDispense(Snack snack, double moneyInserted, VendingMachine vendingMachine);
}
