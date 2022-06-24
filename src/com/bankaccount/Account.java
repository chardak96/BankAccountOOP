package com.bankaccount;

//Base class
//Abstract

public abstract class Account {

    //account number
    private int accountNumber;

    // Balance
    protected double balance;

    //Default constructor
    public Account() {

    }

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        balance = 0;
    }

    //Setter methods
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    //No setter method for account balance - this will be done only via deposit and withdraw methods

    // Getter methods
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    //Abstract methods

    /**
     * Function to deposit funds into account as long as
     * the amount is > 0
     * <p>
     * Apply transaction fee for the CheckingAccount
     *
     * @param amount value to be deposited
     */
    public abstract void deposit(double amount);

    /**
     * Function to withdraw funds
     * 1.the amount is > 0
     * 2. the amount to withdraw must be <= balance
     * <p>
     * Apply transaction fee for the CheckingAccount
     *
     * @param amount value to be withdrawn
     */

    public abstract void withdraw(double amount);

}