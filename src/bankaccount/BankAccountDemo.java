package bankaccount;

import java.util.ArrayList;
import java.util.Random;

public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Random random = new Random();

        int n = 100;
        int maxSum = 300;
        var threads = new ArrayList<Thread>(n);
        var secondThreads = new ArrayList<Thread>();

//        for (int i = 0; i < n; i++) {
//            threads.add(new Thread(() -> {
//                int randInt = random.nextInt(0, 100);
//                if (randInt > 50) { account.deposit(maxSum); }
//                else { account.withdraw(maxSum); }
//            }));
//        }

        for (int i = 0; i < n; i++) {
            threads.add(new Thread(() -> account.deposit(maxSum)));
        }

        for (int i = 0; i < n; i++) {
            secondThreads.add(new Thread(() -> account.withdraw(maxSum)));
        }

        if (!secondThreads.isEmpty()) { threads.addAll(secondThreads); }
        threads.forEach(Thread::start);
        try {
            awaitAllThreads(threads);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        // TODO: Создайте и запустите потоки, выполняющие случайные операции со счетом

        // TODO: Дождитесь завершения всех операций

        System.out.println("Финальный баланс: " + account.getBalance());
    }

    private static void awaitAllThreads(ArrayList<Thread> threads) throws InterruptedException {
        for (Thread thread : threads) { thread.join(); }
    }
}
