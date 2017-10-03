package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {
    private static final double DOUBLE_DELTA = 1e-15;

    @Test //Test account type
    public void accountType() {
    	Account savingsAccount = new Account(Account.SAVINGS);

        assertEquals(1, savingsAccount.getAccountType());
    }

    @Test //Test account deposit with amount > 0
    public void accountDeposit() {
    	Account savingsAccount = new Account(Account.SAVINGS);
    	savingsAccount.deposit(2000.0);

        assertEquals(2000, savingsAccount.sumTransactions(), DOUBLE_DELTA);
    }

}