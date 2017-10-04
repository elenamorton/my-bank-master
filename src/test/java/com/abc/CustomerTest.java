package com.abc;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
	private static final double DOUBLE_DELTA = 1e-15;

    @Test //Test customer name
    public void customerName(){
        Customer oscar = new Customer("Oscar");

        assertEquals("Oscar", oscar.getName());
    }

    @Test //Test customer statement generation
    public void customerStatement(){
        Account checkingAccount = new Account(Account.CHECKING);
        Account savingsAccount = new Account(Account.SAVINGS);
        Customer henry = new Customer("Henry");

        henry.openAccount(checkingAccount).openAccount(savingsAccount);
        checkingAccount.deposit(100.0);
        savingsAccount.deposit(4000.0);
        savingsAccount.withdraw(200.0);

        assertEquals("Statement for Henry\n" +
                "\n" +
                "Checking Account\n" +
                "  deposit $100.00\n" +
                "Total $100.00\n" +
                "\n" +
                "Savings Account\n" +
                "  deposit $4,000.00\n" +
                "  withdrawal $200.00\n" +
                "Total $3,800.00\n" +
                "\n" +
                "Total In All Accounts $3,900.00", henry.getStatement());
    }

    @Test //Test customer with one account
    public void customerHasOneAccount(){
        Account savingsAccount = new Account(Account.SAVINGS);
        Customer oscar = new Customer("Oscar");

        oscar.openAccount(savingsAccount);

        assertEquals(1, oscar.getNumberOfAccounts());
    }

    @Test //Test customer with two accounts
    public void customerHasTwoAccounts(){
        Account checkingAccount = new Account(Account.CHECKING);
        Account savingsAccount = new Account(Account.SAVINGS);
        Customer oscar = new Customer("Oscar");

        oscar.openAccount(checkingAccount);
        oscar.openAccount(savingsAccount);

        assertEquals(2, oscar.getNumberOfAccounts());
    }

    @Test //Test customer with three accounts
    public void customerHasThreeAccounts() {
        Account checkingAccount = new Account(Account.CHECKING);
        Account savingsAccount = new Account(Account.SAVINGS);
        Account maxiSavingsAccount = new Account(Account.MAXI_SAVINGS);
        Customer oscar = new Customer("Oscar");

        oscar.openAccount(checkingAccount);
        oscar.openAccount(savingsAccount);
        oscar.openAccount(maxiSavingsAccount);

        assertEquals(3, oscar.getNumberOfAccounts());
    }

	@Test //Test total interest for customer with two accounts
    public void customerTwoAccountsInterest() {
        Account checkingAccount = new Account(Account.CHECKING);
        Account savingsAccount = new Account(Account.SAVINGS);
        Customer oscar = new Customer("Oscar");

        oscar.openAccount(checkingAccount);
        oscar.openAccount(savingsAccount);
        checkingAccount.deposit(100.0);
        savingsAccount.deposit(1000.0);

        assertEquals(1.1, oscar.totalInterestEarned(), DOUBLE_DELTA);
    }

}
