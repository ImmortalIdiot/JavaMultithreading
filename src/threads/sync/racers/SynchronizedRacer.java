package threads.sync.racers;

import java.util.concurrent.CountDownLatch;

class SynchronizedRacer implements Runnable {
    private String name;
    private CountDownLatch startSignal;
    private CountDownLatch finishSignal;

    public SynchronizedRacer(String name, CountDownLatch startSignal, CountDownLatch finishSignal) {
        this.name = name;
        this.startSignal = startSignal;
        this.finishSignal = finishSignal;
    }

    @Override
    public void run() {
        try {
            startSignal.await(); // Ждем сигнала старта

            long startTime = System.nanoTime();
            System.out.println(name + " начал гонку");

            // реализуйте гонку
            for(int i = 0; i < 1_000_000; i++) { /* do nothing */ }

            finishSignal.countDown();
            long endTime = System.nanoTime();
            System.out.println(this.name + " завершил гонку за " + (endTime - startTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}