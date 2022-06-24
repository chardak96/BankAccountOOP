package com.bankaccount;

import java.util.Scanner;

public class AccountDriver {


    //Program entry point
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Array of accounts
        Account[] accounts = new Account[10];

        int choice;
        int numAccounts = 0;

        do {
            choice = menu(scanner);
            System.out.println();
            if (choice == 1) {
                accounts[numAccounts++] = createAccount(scanner);
            } else if (choice == 2) {
                doDeposit(accounts, numAccounts, scanner);
            } else if (choice == 3) {
                doWithdraw(accounts, numAccounts, scanner);
            }else if(choice == 4){
                applyInterest(accounts, numAccounts, scanner);
            }else {
                System.out.println("GoodBye!");
            }
        } while (choice != 5);
    }


    /**
     * @param scanner
     * @return choice
     */

    public static int accountMenu(Scanner scanner) {
        System.out.println("Select Account Type: ");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");

        int choice;
        do {
            System.out.println("Enter choice: ");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 2);
        return choice;

    }

    /**
     * Function to perform Deposit on a selected account
     */
    public static void doDeposit(Account[] accounts, int count, Scanner scanner) {
        //Get the account number

        System.out.print("\nPlease enter account number: ");
        int accountNumber = scanner.nextInt();

        //search for account
        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0){
            //Amount
            System.out.println("Please enter Deposit Amount: ");
            double amount = scanner.nextDouble();

            accounts[index].deposit(amount);
        }else{
            System.out.println("No account exists with AccountNumber: " + accountNumber);
        }
    }


    /**
     * function to withdraw from account
     * @param accounts
     * @param count
     * @param scanner
     */

    public static void doWithdraw(Account[] accounts, int count, Scanner scanner) {
        //Get the account number

        System.out.print("\nPlease enter account number: ");
        int accountNumber = scanner.nextInt();

        //search for account
        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0) {
            //Amount
            System.out.println("Please enter Withdrawal Amount: ");
            double amount = scanner.nextDouble();

            accounts[index].withdraw(amount);
        } else {
            System.out.println("No account exists with AccountNumber: " + accountNumber);
        }
    }


    public static void applyInterest(Account[] accounts, int count, Scanner scanner) {
        //Get the account number

        System.out.print("\nPlease enter account number: ");
        int accountNumber = scanner.nextInt();

        //search for account
        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0) {
            //must be instance of savings
            if (accounts[index] instanceof SavingsAccount) {
                ((SavingsAccount) accounts[index]).applyInterest();
            } else {
                System.out.println("No account exists with AccountNumber: " + accountNumber);
            }
        }
    }


    public static int searchAccount(Account[] accounts, int count, int accountNumber) {
        for (int i = 0; i < count ; i++) {
            if(accounts[i].getAccountNumber() == accountNumber){
                return  i;
            }
        }

        return -1;
    }

    /**
         * Function to create a new account
         * @param scanner
         * @return choice
         */

    public static Account createAccount(Scanner scanner) {
        Account account = null;
        int choice = accountMenu(scanner);
        int accountNumber;

        System.out.println("Enter Account Number: ");
        accountNumber = scanner.nextInt();

        if (choice == 1) {//checking account
            System.out.println("Enter Transaction Fee: ");
            double fee = scanner.nextDouble();
            account = new CheckingAccount(accountNumber, fee);
        } else { //savings account
            System.out.println("Please enter interest rate: ");
            double interestRate = scanner.nextDouble();
            account = new SavingsAccount(accountNumber, interestRate);
        }
        return account;
    }

    /**
     * Menu to display options and get the user's selection
     *
     * @param scanner
     * @return choice
     */


    public static int menu(Scanner scanner){
        System.out.println();
        System.out.println("Bank Account Menu");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Apply Interest");
        System.out.println("5. Quit");

        int choice;

        do{
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
        }while (choice < 1 || choice > 5);
        return choice;
    }
}
