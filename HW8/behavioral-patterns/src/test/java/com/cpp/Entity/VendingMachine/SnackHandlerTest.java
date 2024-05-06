package com.cpp.Entity.VendingMachine;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cpp.Entity.VendingMachine.Handlers.*;

class SnackHandlerTest {

    private CokeHandler cokeHandler;
    private PepsiHandler pepsiHandler;
    private VendingMachine vendingMachine;
    private Snack coke;
    private Snack pepsi;

    @BeforeEach
    void setup() {
        vendingMachine = new VendingMachine();
        cokeHandler = new CokeHandler();
        pepsiHandler = new PepsiHandler();
        coke = new Snack("Coke", 1.25);
        pepsi = new Snack("Pepsi", 1.50);

        // Setup the chain of handlers
        cokeHandler.setNextHandler(pepsiHandler);
    }

    @Test
    void testCokeHandlerHandlesCokeCorrectly() {
        assertTrue(cokeHandler.handleDispense(coke, 1.25, vendingMachine),
            "CokeHandler should handle Coke correctly.");
    }

    @Test
    void testCokeHandlerDoesNotHandlePepsi() {
        assertFalse(cokeHandler.handleDispense(pepsi, 1.50, vendingMachine),
            "CokeHandler should not handle Pepsi.");
    }

    @Test
    void testPepsiHandlerHandlesPepsiCorrectly() {
        assertTrue(pepsiHandler.handleDispense(pepsi, 1.50, vendingMachine),
            "PepsiHandler should handle Pepsi correctly.");
    }

    @Test
    void testChainOfResponsibility() {
        assertFalse(cokeHandler.handleDispense(pepsi, 1.50, vendingMachine),
            "CokeHandler should pass the responsibility to PepsiHandler.");
        assertTrue(cokeHandler.handleDispense(pepsi, 1.50, vendingMachine),
            "Chain should eventually handle Pepsi with PepsiHandler.");
    }
}
