package com.abc;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class Account {

    public static final int CHECKING = 0;
    public static final int SAVINGS = 1;
    public static final int MAXI_SAVINGS = 2;
    public static final long TEN_DAYS = 10 * 24 * 60 * 60 * 1000;

    private final int accountType;
    public List<Transaction> transactions;

    public Account(int accountType) {
        this.accountType = accountType;
        this.transactions = new ArrayList<Transaction>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(amount));
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
        transactions.add(new Transaction(-amount));
        }
    }

    public double interestEarned() {
        double amount = (checkIfTransactionsExist()) ? sumTransactions() : 0.0;
        switch(accountType){
            case SAVINGS:
                if (amount <= 1000)
                    return amount * 0.001;
                else
                    return 1 + (amount-1000) * 0.002;
            case MAXI_SAVINGS:
                Transaction t = transactions.get(transactions.size() - 1);
                long time = DateProvider.getInstance().now().getTime();
                if ((t.amount < 0.0) && ((t.transactionDate).getTime() + TEN_DAYS) > time)
                    return amount * 0.001;
                else
                    return amount * 0.05;
            default:
                return amount * 0.001;
        }
    }

    public int getAccountType() {
        return accountType;
    }

    public double sumTransactions() {
        double sum = 0.0;
        for (Transaction t: transactions)
            sum += t.amount;
        return sum;
    }

    private boolean checkIfTransactionsExist() {
        return !(transactions.isEmpty());
    }

}
