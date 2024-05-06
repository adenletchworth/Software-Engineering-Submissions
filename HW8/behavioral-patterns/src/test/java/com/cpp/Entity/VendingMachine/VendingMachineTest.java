package com.cpp.Entity.VendingMachine;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VendingMachineTest {

    private VendingMachine vendingMachine;

    @BeforeEach
    void setup() {
        vendingMachine = new VendingMachine();
    }

    @Test
    void testInsertMoneyEnoughForPurchase() {
        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(1.50);
        assertEquals("IdleState", vendingMachine.getMachineState().getClass().getSimpleName(), "Machine should return to IdleState once finished.");
    }

    @Test
    void testInsertNotEnoughMoney() {
        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(0.75);
        assertEquals("IdleState", vendingMachine.getMachineState().getClass().getSimpleName(), "Machine should return to IdleState on insufficient funds.");
    }

    @Test
    void testCancelTransactionFromAwaitingPayment() {
        vendingMachine.selectSnack("Coke");
        vendingMachine.awaitingPayment();  // Assuming this sets the state to AwaitingPaymentState
        vendingMachine.idle();  // Trigger the cancellation
        assertEquals("IdleState", vendingMachine.getMachineState().getClass().getSimpleName(), "Machine should transition to IdleState after cancellation.");
    }
}
