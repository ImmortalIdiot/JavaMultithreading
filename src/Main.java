import bankaccount.SynchronizedBankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        SynchronizedBankAccount synchronizedBankAccount = new SynchronizedBankAccount();
        List<Thread> threads = new ArrayList<>(4000);
        AtomicInteger finalSum = new AtomicInteger(1000);

        for (int i = 0; i < 4000; i++) {
            threads.add(new Thread(() -> {
               if (random.nextBoolean()) {
                   int sum = random.nextInt(100, 200);
                   synchronizedBankAccount.deposit(sum);
                   finalSum.addAndGet(sum);
               } else {
                   int out = random.nextInt(50, 100);
                   synchronizedBankAccount.withdraw(out);
                   finalSum.addAndGet(-out);
               }
            }));
        }

        threads.forEach(Thread::start);

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            /* do nothing */
        }

        System.out.println("final sum: " + finalSum);
        System.out.println("balance: " + synchronizedBankAccount.getBalance());
    }
}
