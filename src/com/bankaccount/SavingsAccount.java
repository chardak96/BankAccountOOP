package com.bankaccount;

//Savings Account child class
//has an interest rate
//a method to apply interest rate - profit

import java.time.LocalDate;

public class SavingsAccount extends Account {

    //interest rate
    private double interestRate;

    //default constructor
    public SavingsAccount(){
        super();
    }

    /**
     * Parameter constructor to initialize Savings Account
     * with a custom Account Number and interest rate
     */

    public SavingsAccount(int accountNumber, double interestRate){
        super(accountNumber);
        this.interestRate = interestRate;
    }

    //getter function


    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    public double calcInterest(){
        return balance * interestRate;
    }

    public void applyInterest(){
        double interest = calcInterest();
        System.out.printf("Interest amount %.2f added to balance %n", interest);
        deposit(interest);
    }

    /**
     * Function to deposit funds into account as long as
     * the amount is > 0
     * <p>
     *
     * @param amount value to be deposited
     */
    public void deposit(double amount){
        //First check amount
        if(amount > 0){
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);
            System.out.printf("Current Balance is: %.2f%n", balance);
        }else{
            System.out.println("A negative amount cannot be deposited.");
        }
    }

    /**
     * Function to withdraw funds
     * 1.the amount is > 0
     * 2. the amount to withdraw must be <= balance
     * <p>
     *
     * @param amount value to be withdrawn
     */

    public void withdraw(double amount) {
        //check if amount is positive
        if ((amount) > balance) {
            System.out.println("Funds insufficient");
        } else if (amount > 0) {
            balance -= amount;
            System.out.printf("Amount %.2f withdrawn %n", amount);
            System.out.printf("Current Balance is: %.2f%n", balance);
            System.out.println();
        } else {
            System.out.println("A negative amount cannot be withdrawn!");
        }
    }

}
