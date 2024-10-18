package bankaccount;

class BankAccount {
    private volatile int balance = 1000;

    public void deposit(int amount) {
        // TODO: Реализуйте логику внесения денег на счет
        //this.balance += amount;
        changeBalance(amount);
    }

    public void withdraw(int amount) {
        // TODO: Реализуйте логику снятия денег со счета
        //if (this.balance - amount > 0) this.balance -= amount;
        changeBalance(-amount);
    }

    private void changeBalance(int amount) {
        if (this.balance + amount > 0) {
            this.balance += amount;
        }
        System.out.println(this.balance);
    }

    public int getBalance() {
        return balance;
    }
}