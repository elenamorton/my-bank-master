package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    @Test //Test account type
    public void getFirstCustomerExists() {
    	Account savingsAccount = new Account(Account.SAVINGS);

        assertEquals(1, savingsAccount.getAccountType());
    }

}