package exception;

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

    public double getBalance() {
        return balance;
    }
}



BankTransaction account = new BankTransaction(balance);

try {
    account.withdraw(amount);
}
catch (InvalidAmountException e) {
    System.out.println(e.getMessage());
}
catch (InsufficientBalanceException e) {
    System.out.println(e.getMessage());
}