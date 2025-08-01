package com.zs.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountsTest {
    private Accounts accounts;

    @BeforeEach
    public void setUp() {
        accounts = new Accounts(1000);
    }

    @Test
    public void testNegativeDeposit() {
        assertThrows(NumberFormatException.class,
                () -> accounts.deposit(-1));
    }

    @Test
    public void testValidDeposit() {
        assertEquals(1500, accounts.deposit(500));
    }

    @Test
    public void testNegativeWithdraw() {
        assertThrows(NumberFormatException.class,
                () -> accounts.withdraw(-1));
    }

    @Test
    public void testInvalidWithdraw() {
        assertThrows(BalanceException.class,
                () -> accounts.withdraw(1500));
    }

    @Test
    public void testValidWithdraw() throws BalanceException {
        assertEquals(900, accounts.withdraw(100));
    }
}