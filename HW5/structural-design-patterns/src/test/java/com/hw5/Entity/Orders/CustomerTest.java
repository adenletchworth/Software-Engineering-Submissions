package com.hw5.Entity.Orders;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    @ParameterizedTest
    @EnumSource(Status.class) 
    public void testCustomerCreationWithDifferentStatuses(Status status) {
        String name = "Dummy";
        Customer customer = new Customer(name, status);

        assertEquals(name, customer.getName(), "The name should be the same as was set.");
        assertEquals(status, customer.getLoyaltyStatus(), "The status should be the same as was set.");
    }
}
