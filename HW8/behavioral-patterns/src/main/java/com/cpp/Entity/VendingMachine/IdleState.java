package com.cpp.Entity.VendingMachine;

import java.util.Optional;

public class IdleState extends StateOfVendingMachine{
    public IdleState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectSnack() {
        Snack snack = vendingMachine.getSnack();
        if (snack != null && vendingMachine.isSnackAvailable(snack)) {
            vendingMachine.setSnack(snack.getName());
            System.out.println("Snack selected: " + snack.getName() + ". Please insert money.");
            vendingMachine.setMachineState(new AwaitingPaymentState(vendingMachine));
        } else {
            System.out.println("Snack selection invalid or unavailable.");
        }
    }

    @Override
    public void insertMoney(double money) {
        System.out.println("Please make a selection first.");
    }

    @Override
    public Optional<Snack> dispenseSnack() {
        System.out.println("No snack selected. Please select a snack first.");
        return Optional.empty();
    }

    @Override
    public void idle() {
        System.out.println("Machine is already in idle state.");
    }

    @Override
    public void awaitingPayment() {
        System.out.println("Please make a selection first.");
    }

    @Override
    public void dispensing() {
        System.out.println("Please make a selection first.");
    }
}





