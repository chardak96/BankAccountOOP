package com.bankaccount;


public class CheckingAccount extends Account {

    //Fee - default value
    private static double FEE = 2.5;

    //default constructor
    public CheckingAccount(){
        super();
    }



    /**
     * Parameter constructor to initialize CheckingAccount
     * with a custom Account Number and a Customer Transaction
     * Fee
     */

    public CheckingAccount(int accountNumber, double fee){
        super(accountNumber);
       FEE = fee;
    }

    /**
     * Function to deposit funds into account as long as
     * the amount is > 0
     * <p>
     * Apply transaction fee for the CheckingAccount
     *
     * @param amount value to be deposited
     */
    public void deposit(double amount){
        //First check amount
        if(amount > 0){
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);
            //Apply transaction fee
            balance -= FEE;
            System.out.printf("Fee %.2f applied%n", FEE);
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
     * Apply transaction fee for the CheckingAccount
     *
     * @param amount value to be withdrawn
     */

    public void withdraw(double amount) {
        //check if amount is positive
        if ((amount + FEE) > balance) {
            System.out.println("Funds insufficient");
        } else if (amount > 0) {
            balance -= amount;
            System.out.printf("Amount %.2f withdrawn %n", amount);
            balance -= FEE;
            System.out.printf("Fee %.2f applied%n", FEE);
            System.out.printf("Current Balance is: %.2f%n", balance);
            System.out.println();
        } else {
            System.out.println("A negative amount cannot be withdrawn!");
        }
    }
}