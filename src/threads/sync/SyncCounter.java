package threads.sync;

import java.util.ArrayList;

public class SyncCounter {
    private static final int INCREMENTS_PER_THREAD = 100000;

    public static void main(String[] args) throws InterruptedException {
        final int NUM_THREADS = 5;

        SimpleCounter counter = new SimpleCounter();

        var threads = createIncrementThread(NUM_THREADS, counter);
        threads.addAll(createDecrementThread(NUM_THREADS, counter));

        threads.forEach(Thread::start);
        awaitAllThreads(threads);

        System.out.println("Фактическое значение: " + counter.getCount());
    }

    private static void awaitAllThreads(ArrayList<Thread> threads) throws InterruptedException {
        for (Thread thread : threads) { thread.join(); }
    }

    public static ArrayList<Thread> createIncrementThread(int n, SimpleCounter counter) {
        var threads = new ArrayList<Thread>();

        for (int i = 0; i < n; i++) {
            threads.add(new Thread(runIncrement(INCREMENTS_PER_THREAD, counter)));
        }

        return threads;
    }

    public static ArrayList<Thread> createDecrementThread(int n, SimpleCounter counter) {
        var threads = new ArrayList<Thread>();

        for (int i = 0; i < n; i++) {
            threads.add(new Thread(runDecrement(INCREMENTS_PER_THREAD, counter)));
        }

        return threads;
    }

    public static Runnable runIncrement(int n, SimpleCounter counter) {
        return () -> { for (int i = 0; i < n; i++) { counter.increment(); } };
    }

    public static Runnable runDecrement(int n, SimpleCounter counter) {
        return () -> { for (int i = 0; i < n; i++) { counter.decrement(); } };
    }
}
