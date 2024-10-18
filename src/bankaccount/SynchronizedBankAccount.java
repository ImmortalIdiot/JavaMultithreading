package bankaccount;

public class SynchronizedBankAccount {
    private int balance = 1000;

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
