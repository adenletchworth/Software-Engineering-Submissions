package com.cpp.Entity.VendingMachine;

public abstract class AbstractSnackHandler implements SnackDispenserHandler {
    protected SnackDispenserHandler nextHandler;

    @Override
    public void setNextHandler(SnackDispenserHandler handler) {
        this.nextHandler = handler;
    }

    public boolean handleDispense(Snack snack, double moneyInserted, VendingMachine vendingMachine) {
        if (canHandle(snack, moneyInserted, vendingMachine)) {
            return true;  
        } else if (nextHandler != null) {
            return nextHandler.handleDispense(snack, moneyInserted, vendingMachine);
        }
        return false;
    }
    
    protected abstract boolean canHandle(Snack snack, double moneyInserted, VendingMachine vendingMachine);
}
