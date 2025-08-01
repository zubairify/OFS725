package com.zs.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountsTest {
    private Accounts accounts;

    @BeforeEach
    void setUp() {
        accounts = new Accounts(1000);
    }

    @Test
    void testNegativeDeposit() {
        assertThrows(NumberFormatException.class,
                () -> accounts.deposit(-1));
    }

    @Test
    void testValidDeposit() {
        assertEquals(1500, accounts.deposit(500));
    }

    @Test
    void testNegativeWithdraw() {
    }

    @Test
    void testInvalidWithdraw() {
    }

    @Test
    void testValidWithdraw() {
    }
}