package com.cpp.Entity.VendingMachine;

import java.util.Optional;

public abstract class StateOfVendingMachine {
    protected VendingMachine vendingMachine;

    public StateOfVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public abstract void selectSnack();
    public abstract void insertMoney(double money);
    public abstract Optional<Snack> dispenseSnack();
    public abstract void idle();
    public abstract void awaitingPayment();
    public abstract void dispensing();
}
