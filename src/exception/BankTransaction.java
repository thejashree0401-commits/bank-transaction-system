package exception;

import java.util.Scanner;

public class BankTransaction {

    private double balance;

    public BankTransaction(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount)
            throws InvalidAmountException, InsufficientBalanceException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Amount must be greater than zero."
            );
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient balance. Available balance: ₹" + balance
            );
        }

        balance = balance - amount;

        System.out.println("Withdrawal successful!");
        System.out.println("Withdrawn amount: ₹" + amount);
        System.out.println("Remaining balance: ₹" + balance);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("     BANK TRANSACTION SYSTEM");
        System.out.println("=================================");

        System.out.print("Enter account balance: ₹");
        double balance = scanner.nextDouble();

        BankTransaction account = new BankTransaction(balance);

        System.out.print("Enter withdrawal amount: ₹");
        double amount = scanner.nextDouble();

        try {
            account.withdraw(amount);
        }
        catch (InvalidAmountException e) {
            System.out.println("Transaction Failed!");
            System.out.println("Error: " + e.getMessage());
        }
        catch (InsufficientBalanceException e) {
            System.out.println("Transaction Failed!");
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}