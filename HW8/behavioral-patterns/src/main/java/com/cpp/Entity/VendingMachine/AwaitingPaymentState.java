package com.cpp.Entity.VendingMachine;

import java.util.Optional;

public class AwaitingPaymentState extends StateOfVendingMachine {
    public AwaitingPaymentState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectSnack() {
        System.out.println("Snack already selected, please insert money.");
    }

    @Override
    public void insertMoney(double money) {
        if (vendingMachine.processPayment(money)) {
            System.out.println("Payment successful. Dispensing snack.");
            vendingMachine.decrementSnack(vendingMachine.getSnack().getName());  
            vendingMachine.setMachineState(new DispensingState(vendingMachine));
            vendingMachine.dispenseSnack();
        } else {
            System.out.println("Insufficient funds. Please Select another snack and try again.");
            vendingMachine.setMachineState(new IdleState(vendingMachine));
        }
    }


    @Override
    public Optional<Snack> dispenseSnack() {
        System.out.println("Please insert money to dispense the snack.");
        return Optional.empty();
    }

    @Override
    public void idle() {
        System.out.println("Cancelling the selection and returning to idle state.");
        vendingMachine.setMachineState(new IdleState(vendingMachine));
    }

    @Override
    public void awaitingPayment() {
        System.out.println("Awaiting payment. Please insert money.");
    }

    @Override
    public void dispensing() {
        System.out.println("Error: No payment made. Cannot dispense.");
    }
}


