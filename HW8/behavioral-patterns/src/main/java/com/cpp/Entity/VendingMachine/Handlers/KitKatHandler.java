package com.cpp.Entity.VendingMachine.Handlers;

import com.cpp.Entity.VendingMachine.AbstractSnackHandler;
import com.cpp.Entity.VendingMachine.Snack;
import com.cpp.Entity.VendingMachine.VendingMachine;

public class KitKatHandler extends AbstractSnackHandler {
    @Override
    protected boolean canHandle(Snack snack, double moneyInserted, VendingMachine vendingMachine) {
        return snack.getName().equals("KitKat") && vendingMachine.isSnackAvailable(snack) && moneyInserted >= snack.getPrice();
    }
}