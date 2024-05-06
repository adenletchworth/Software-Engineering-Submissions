package com.cpp.Entity.VendingMachine;

import java.util.Optional;

public class DispensingState extends StateOfVendingMachine {
    public DispensingState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectSnack() {
        System.out.println("Operation not allowed: Snack selection during dispensing.");
    }

    @Override
    public void insertMoney(double money) {
        System.out.println("Operation not allowed: Inserting money during dispensing.");
    }

    @Override
    public Optional<Snack> dispenseSnack() {
        Snack snack = vendingMachine.getSnack();
        if (snack != null && vendingMachine.isSnackAvailable(snack)) {
            System.out.println("Dispensing your snack: " + snack.getName() + ". Thank you for your purchase!");
            vendingMachine.setSnack(null);  // Clear the selected snack after dispensing
            vendingMachine.setMachineState(new IdleState(vendingMachine));
            vendingMachine.dispenseSnack();
            return Optional.of(snack);
        } else {
            System.out.println("Error: No snack available to dispense.");
            vendingMachine.setMachineState(new IdleState(vendingMachine));
            return Optional.empty();
        }
    }

    @Override
    public void idle() {
        System.out.println("Returning to idle state by system reset or error recovery.");
        vendingMachine.setMachineState(new IdleState(vendingMachine));
    }

    @Override
    public void awaitingPayment() {
        System.out.println("Operation not valid: Payment was already processed.");
    }

    @Override
    public void dispensing() {
        System.out.println("Operation not valid: Already dispensing.");
    }
}


