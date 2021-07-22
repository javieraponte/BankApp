package account;

import java.util.Scanner;

public class BankAccount {
    
    public static void main(String[] args) {
        
        BankAccount test = new BankAccount();
        System.out.println("Enter your name: ");
        Scanner customerName = new Scanner(System.in);
        var cName = customerName.nextLine();
        
        System.out.println("Enter your ID: ");
        Scanner customerID = new Scanner(System.in);
        var cID = customerID.nextLine();
        
        System.out.println("Welcome " + cName);
        test.showMenu();
    }

    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    BankAccount() {
        
    }
    
    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposite: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdraw: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured");
        }
    }

    void showMenu() {
        var option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("This is your Bank App");

        do {
            System.out.println("-------------------------------------------------");
            System.out.println("Enter an option");
            System.out.println("-------------------------------------------------");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Exit");
            option = scanner.next().charAt(0);

            switch (option) {
                case 'A':
                    System.out.println("-------------------------------------------------");
                    System.out.println("Balance: " + balance);
                    System.out.println("-------------------------------------------------");
                    break;
                
                case 'B':
                    System.out.println("-------------------------------------------------");
                    System.out.println("Enter an amount to deposit: ");
                    System.out.println("-------------------------------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    break;
                 
                case 'C':
                    System.out.println("-------------------------------------------------");
                    System.out.println("Enter an amount to withdraw: ");
                    System.out.println("-------------------------------------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    break;
                    
                case 'D':
                    System.out.println("-------------------------------------------------");
                    getPreviousTransaction();
                    System.out.println("-------------------------------------------------");
                    break;
                    
                case 'E':
                    System.out.println("**************************************************");
                    break;
                    
                default:
                    System.out.println("Invalid Option. Please enter again");
                    break;
            }
        }
        while(option != 'E');
        System.out.println("Thanks for using our service");
    }
}
