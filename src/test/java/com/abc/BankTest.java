package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {
    private static final double DOUBLE_DELTA = 1e-15;

    @Test
    public void getFirstCustomerExists() {
        Bank bank = new Bank();
        Customer john = new Customer("John");
        Customer jane = new Customer("Jane");

        bank.addCustomer(john);
        bank.addCustomer(jane);

        assertEquals("John", bank.getFirstCustomer());
    }

    @Test
    public void customerSummarySingleAccount() {
        Bank bank = new Bank();
        Customer john = new Customer("John");
        Account checkingAccount = new Account(Account.CHECKING);

        bank.addCustomer(john);
        john.openAccount(checkingAccount);

        assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
    }

    @Test
    public void customerSummaryMultipleAccounts() {
        Bank bank = new Bank();
        Customer jane = new Customer("Jane");
        Account checkingAccount = new Account(Account.CHECKING);
        Account savingsAccount = new Account(Account.SAVINGS);

        bank.addCustomer(jane);
        jane.openAccount(checkingAccount);
        jane.openAccount(savingsAccount);

        assertEquals("Customer Summary\n - Jane (2 accounts)", bank.customerSummary());
    }

    @Test
    public void checkingAccount() {
        Bank bank = new Bank();
        Customer bill = new Customer("Bill");
        Account checkingAccount = new Account(Account.CHECKING);

        bank.addCustomer(bill);
        bill.openAccount(checkingAccount);
        checkingAccount.deposit(100.0);

        assertEquals(0.1, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void savingsAccount() {
        Bank bank = new Bank();
        Customer bill = new Customer("Bill");
        Account savingsAccount = new Account(Account.SAVINGS);

        bank.addCustomer(bill);
        bill.openAccount(savingsAccount);
        savingsAccount.deposit(1500.0);

        assertEquals(2.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void maxiSavingsAccount() {
        Bank bank = new Bank();
        Customer bill = new Customer("Bill");
        Account maxiSavingsAccount = new Account(Account.MAXI_SAVINGS);

        bank.addCustomer(bill);
        bill.openAccount(maxiSavingsAccount);
        maxiSavingsAccount.deposit(3000.0);

        assertEquals(170.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

}
